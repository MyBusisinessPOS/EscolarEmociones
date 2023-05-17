package com.example.escolar.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escolar.R;
import com.example.escolar.database.bean.AgendaBean;

import org.w3c.dom.Text;

import java.util.List;

public class AdapterAgenda extends RecyclerView.Adapter<AdapterAgenda.Holder> {

    private List<AgendaBean> mData;
    private OnItemClickListener onItemClickListener;

    public AdapterAgenda(List<AgendaBean> mData, OnItemClickListener onItemClickListener) {
        this.mData = mData;
        this.onItemClickListener = onItemClickListener;
    }

    public AdapterAgenda(List<AgendaBean> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public AdapterAgenda.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_agenda, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAgenda.Holder holder, int position) {
        holder.bind(mData.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
       TextView textViewdia;
       TextView textViewmes;
       TextView textViewanio;
       TextView textViewrecordatorio;
        CardView cardview;
        public Holder(@NonNull View itemView) {
            super(itemView);
            textViewdia = itemView.findViewById(R.id.tv_dia);
            textViewmes = itemView.findViewById(R.id.tv_mes);
            textViewanio = itemView.findViewById(R.id.tv_anio);
            textViewrecordatorio = itemView.findViewById(R.id.tv_recordatorio);
            cardview = itemView.findViewById(R.id.cardview);
        }


        private void bind(AgendaBean item, OnItemClickListener onItemClickListener){
            String fecha  = item.getFecha();
            textViewdia.setText("" + fecha.substring(0,2));
            textViewmes.setText("" + fecha.substring(3,5));
            textViewanio.setText("" + fecha.substring(6));
            textViewrecordatorio.setText("" + item.getDescricion());

            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(getAdapterPosition());
                    }
                }
            });
        }
    }

    public void setData(List<AgendaBean> list){
        mData = list;
        notifyDataSetChanged();
    }
    public interface OnItemClickListener{
        void onItemClick(int position);
    }


}
