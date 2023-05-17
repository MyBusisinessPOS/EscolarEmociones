package com.example.escolar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.escolar.R;
import com.example.escolar.adapters.AdapterAgenda;
import com.example.escolar.database.bean.AgendaBean;
import com.example.escolar.database.bean.UsuariosBean;
import com.example.escolar.database.dao.AgendaDao;
import com.example.escolar.database.dao.UsuariosDao;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class AgendaActivity extends AppCompatActivity {


    private List<AgendaBean> mData;
    private AdapterAgenda adapter;
    private RecyclerView recyclerView;
    TextView textViewMensaje;
    private FloatingActionButton add_agenda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        add_agenda = findViewById(R.id.add_agenda);
        add_agenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(AgendaActivity.this);
            }
        });
        textViewMensaje = findViewById(R.id.tv_mesage);

        recyclerView = findViewById(R.id.rv_agendas);
        loadData();
    }


    private void showDialog(Context context){
        Dialog dialog = new Dialog(AgendaActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog_agenda);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        if (dialog.getWindow() != null) {
            lp.copyFrom(dialog.getWindow().getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

            EditText amountEditText = dialog.findViewById(R.id.edit_recordatorio);
            EditText editTextFecha = dialog.findViewById(R.id.edit_fecha);



            editTextFecha.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calendar now = Calendar.getInstance();
                    Calendar min = Calendar.getInstance();
                    min.add(Calendar.DAY_OF_YEAR, -2);
                    DatePickerDialog dialogPicker = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear,
                                              int dayOfMonth) {
                            Calendar now = Calendar.getInstance();
                            now.set(Calendar.YEAR, year);
                            now.set(Calendar.MONTH, monthOfYear);
                            now.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                            String myFormat = "dd-MM-yyyy";
                            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                            //((TextInputLayout) findViewById(R.id.layout_date)).setError(null);
                            editTextFecha.setText(sdf.format(now.getTime()));
                        }

                    },
                            now.get(Calendar.YEAR),
                            now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH));
                    //dialogPicker.getDatePicker().setMaxDate(now.getTimeInMillis());
                    dialogPicker.show();

                }
            });

            MaterialButton positiveButton = dialog.findViewById(R.id.okButton);
            MaterialButton negativeButton = dialog.findViewById(R.id.cancelButton);

            positiveButton.setEnabled(false);
            // Colocar el foco en el EditText y abrir el teclado
            amountEditText.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

            amountEditText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                    String enteredValue = s.toString();
                    if (enteredValue == null || enteredValue.isEmpty()) {
                        amountEditText.setError("Ingrese un recordatorio");
                        positiveButton.setEnabled(false);
                    } else {
                        amountEditText.setError(null);
                        positiveButton.setEnabled(true);
                    }
                }
            });

            positiveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String recorddatorio = amountEditText.getText().toString();
                    String fecha = editTextFecha.getText().toString();
                    imm.hideSoftInputFromWindow(amountEditText.getWindowToken(), 0);

                    final UsuariosDao usuariosDao = new UsuariosDao();
                    final UsuariosBean usuariosBean = usuariosDao.isLogin();

                    if (usuariosBean == null) {
                        return;
                    }

                    final AgendaBean agendaBean = new AgendaBean();
                    agendaBean.setDescricion(recorddatorio);
                    agendaBean.setFecha(fecha);
                    agendaBean.setIdUsuario(usuariosBean.getId());
                    guardaRecordatorio(agendaBean);
                    dialog.cancel();
                }
            });
            negativeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.cancel();
                }
            });

            dialog.show();
            dialog.getWindow().setAttributes(lp);
        }
    }


    private void guardaRecordatorio(AgendaBean agendaBean ){
        final AgendaDao agendaDao = new AgendaDao();
        agendaDao.save(agendaBean);
        setData();
    }

    private void loadData(){
        final LinearLayoutManager manager = new LinearLayoutManager(AgendaActivity.this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        mData = (List<AgendaBean>) (List<?>) new AgendaDao().list();
        adapter = new AdapterAgenda(mData, new AdapterAgenda.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                final AgendaBean agendaBean = mData.get(position);
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(AgendaActivity.this);
                dialogo1.setTitle("Eliminar");
                dialogo1.setMessage("¿ Deseas eliminar el recordatorio?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        final AgendaDao agendaDao = new AgendaDao();
                        agendaDao.delete(agendaBean);
                        setData();
                    }
                });
                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        dialogo1.dismiss();
                    }
                });
                dialogo1.show();


            }
        });
        recyclerView.setAdapter(adapter);
        showHideText();
    }

    private void setData(){
        mData = (List<AgendaBean>) (List<?>) new AgendaDao().list();
        adapter.setData(mData);
        showHideText();
    }

    private void showHideText(){
        if (mData.isEmpty()){
            textViewMensaje.setVisibility(View.VISIBLE);
        }else {
            textViewMensaje.setVisibility(View.GONE);
        }
    }

}