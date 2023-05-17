package com.example.escolar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.escolar.database.bean.UsuariosBean;
import com.example.escolar.database.dao.UsuariosDao;
import com.google.android.material.textfield.TextInputLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegisterActivity extends AppCompatActivity {

    private CircleImageView perfil_actualiza_img;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_IMAGE_PICK = 2;
    private static final int PERMISSION_REQUEST_CODE = 3;
    private Uri imageUri = null;

    private String imagePath = "NO";
    EditText editTextNombre, editTextEdad, editTextFecha, editTextEmail, editTextPassword, editTextConfirmarPassword;
    Button buttonRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        iniciaControles();
    }

    private void iniciaControles(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_registro);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Registrar");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        perfil_actualiza_img = findViewById(R.id.perfil_actualiza_img);
        perfil_actualiza_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImageDialog();
            }
        });
        editTextNombre = findViewById(R.id.nombre);
        editTextEdad = findViewById(R.id.edad);
        editTextFecha = findViewById(R.id.fecha);
        editTextFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                Calendar min = Calendar.getInstance();
                min.add(Calendar.DAY_OF_YEAR, -2);
                DatePickerDialog dialog = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        Calendar now = Calendar.getInstance();
                        now.set(Calendar.YEAR, year);
                        now.set(Calendar.MONTH, monthOfYear);
                        now.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        String myFormat = "yyyy-MM-dd";
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                        //((TextInputLayout) findViewById(R.id.layout_date)).setError(null);
                        editTextFecha.setText(sdf.format(now.getTime()));
                    }

                },
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH));
                dialog.getDatePicker().setMaxDate(now.getTimeInMillis());
                dialog.show();

            }
        });

        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.contrasenia);
        editTextConfirmarPassword = findViewById(R.id.confirmar_contrasenia);
        buttonRegistrar = findViewById(R.id.button_registrar_usuario);

        buttonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String nombre = editTextNombre.getText().toString();
               String edad = editTextEdad.getText().toString();
               String fecha = editTextFecha.getText().toString();
               String email = editTextEmail.getText().toString();
               String password = editTextPassword.getText().toString();
               String confirmar_password = editTextConfirmarPassword.getText().toString();

               if (nombre.isEmpty()){
                   Toast.makeText(RegisterActivity.this, "Nombre requerido", Toast.LENGTH_SHORT).show();
                   return;
               }
                if (edad.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Edad requerida", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (fecha.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Fecha de nacimiento requerida", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (email.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Email requerido", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Contraseña requerido", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (confirmar_password.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Confirmar contraseña requerido", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.compareToIgnoreCase(confirmar_password) != 0){
                    Toast.makeText(RegisterActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    return;
                }

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(RegisterActivity.this);
                dialogo1.setTitle("Registro");
                dialogo1.setMessage("¿ Deseas registrarte?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {

                            UsuariosBean usuariosBean = new UsuariosBean();
                            usuariosBean.setNombre(nombre);
                            usuariosBean.setEdad(Integer.parseInt(edad));
                            usuariosBean.setFecha_nacimiento(fecha);
                            usuariosBean.setCorreo(email);
                            usuariosBean.setContrasenia(confirmar_password);
                            usuariosBean.setIsLogin(1);
                            usuariosBean.setPath_image(imagePath);

                        registrarUsuario(usuariosBean);
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
    }

    private void showImageDialog() {
        Dialog dialog = new Dialog(RegisterActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog_show_camera_galery);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        if (dialog.getWindow() != null) {
            lp.copyFrom(dialog.getWindow().getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

            ImageView cameraImage = dialog.findViewById(R.id.camera_image);
            ImageView galleryImage = dialog.findViewById(R.id.gallery_image);

            cameraImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dispatchPickImageIntent();
                    dialog.dismiss();
                }
            });

            galleryImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dispatchTakePictureIntent();
                    dialog.dismiss();
                }
            });

            dialog.show();
            dialog.getWindow().setAttributes(lp);
        }
    }


    private void dispatchTakePictureIntent() {

        // Comprobar si los permisos necesarios están concedidos
        if (checkPermission()) {
            // Crear un archivo para almacenar la imagen tomada
            File photoFile = createImageFile();

            // Crear el intent para la cámara
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            // Asegurarse de que hay una aplicación de cámara disponible para manejar el intent
            if (takePictureIntent.resolveActivity(getPackageManager()) != null && photoFile != null) {
                // Obtener la Uri del archivo de imagen y añadirla al intent
                Uri photoURI = FileProvider.getUriForFile(
                        this,
                        BuildConfig.APPLICATION_ID + ".provider",
                        photoFile
                );
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);

                imagePath = photoURI.getPath();
                // Iniciar la actividad de la cámara
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        } else {
            // Solicitar permisos necesarios
            requestPermissionCamera();
        }
    }

    private boolean checkPermission() {
        // Comprobar si los permisos necesarios están concedidos
        return ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED;
    }

    private void dispatchPickImageIntent() {

        if (checkPermission()) {
            // Crear el intent para la selección de imagen de la galería
            Intent pickImageIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            pickImageIntent.setType("image/*"); // Solo seleccionar imágenes

            // Iniciar la actividad de la galería
            startActivityForResult(pickImageIntent, REQUEST_IMAGE_PICK);
        } else {
            // Solicitar permisos necesarios
            requestPermissionGelery();
        }
    }

    private void registrarUsuario(UsuariosBean usuariosBean){

        final UsuariosDao usuariosDao = new UsuariosDao();
        usuariosDao.save(usuariosBean);


        finish();
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(intent);
    }



    private void requestPermissionCamera() {
        requestCameraPermission();
        ActivityCompat.requestPermissions(
                this,
                new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                PERMISSION_REQUEST_CODE
        );
    }

    private void requestPermissionGelery() {
        requestStoragePermission();
        ActivityCompat.requestPermissions(
                this,
                new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                PERMISSION_REQUEST_CODE
        );
    }

    private void requestCameraPermission() {
        // Solicitar permiso para usar la cámara si no está concedido
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA}, REQUEST_IMAGE_CAPTURE);
        } else {
            takePicture();
        }
    }

    private void requestStoragePermission() {
        // Solicitar permiso para acceder al almacenamiento si no está concedido
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_IMAGE_PICK);
        } else {
            pickImage();
        }
    }

    private void pickImage() {
        // Crear un intent para seleccionar una imagen de la galería
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_IMAGE_PICK);
    }

    private void takePicture() {
        // Crear un intent para tomar una foto con la cámara
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File photoFile = createImageFile();

        if (photoFile != null) {
            imageUri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".provider", photoFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    }


    private File createImageFile() {
        // Crear un archivo de imagen para almacenar la foto tomada
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        try {
            File imageFile = File.createTempFile("JPEG_" + timeStamp + "_", ".jpg", storageDir);
            // Guardar la ruta del archivo en una variable para su uso posterior
            imageUri = Uri.fromFile(imageFile);
            imagePath = imageFile.getPath();
            return imageFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case REQUEST_IMAGE_CAPTURE:
                    imagePath = imageUri.getPath();
                    perfil_actualiza_img.setImageURI(imageUri);
                    break;
                case REQUEST_IMAGE_PICK:


                    Uri imageUri = data.getData();
                    File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

                    try {
                        File imageFile = File.createTempFile("IMG_", ".jpg", storageDir);
                        copyImageToStorage(getContentResolver(), imageUri, imageFile);

                        Uri savedImageUri = Uri.fromFile(imageFile);
                        imagePath = savedImageUri.getPath();
                        perfil_actualiza_img.setImageURI(savedImageUri);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    private void copyImageToStorage(ContentResolver contentResolver, Uri imageUri, File imageFile) throws IOException {
        InputStream inputStream = contentResolver.openInputStream(imageUri);
        OutputStream outputStream = new FileOutputStream(imageFile);
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        outputStream.close();
    }
}