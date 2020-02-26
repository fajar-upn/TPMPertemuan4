package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.ModelPahlawan;

import java.util.ArrayList;

public class AdapterPahlawan extends RecyclerView.Adapter<AdapterPahlawan.PahlawanViewHolder> {

    private Context context;
    private ArrayList<ModelPahlawan> list;
    private OnItemClikCallback onItemClikCallback;

    public AdapterPahlawan(Context context) {
        this.context = context;
    }

    public ArrayList<ModelPahlawan> getList() {
        return list;
    }

    public void setList(ArrayList<ModelPahlawan> list) {
        this.list = list;
    }

    public void setOnItemClikCallback(OnItemClikCallback onItemClikCallback) {
        this.onItemClikCallback = onItemClikCallback;
    }

    @NonNull
    @Override
    public PahlawanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        return new PahlawanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PahlawanViewHolder holder, int position) {
        Glide.with(context).load(getList().get(position).getImage()).into(holder.ivPhoto);
        holder.tvname.setText(getList().get(position).getName());
        holder.tvDesc.setText(getList().get(position).getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClikCallback.onItemCliked(list.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return getList().size();
    }

    public class PahlawanViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPhoto;
        private TextView tvname, tvDesc;
        public PahlawanViewHolder(@NonNull View itemView) {
            super(itemView);

            ivPhoto = itemView.findViewById(R.id.iv_photo);
            tvname = itemView.findViewById(R.id.tv_nama);
            tvDesc = itemView.findViewById(R.id.tv_descption);

        }
    }

    public interface OnItemClikCallback{
        void onItemCliked(ModelPahlawan pahlawan);
    }
}
