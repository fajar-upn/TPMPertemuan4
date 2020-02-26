package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.model.ModelPahlawan;

public class DetailPahlawan extends AppCompatActivity {

    public static String DATA = "data";
    private ImageView ivPhoto;
    private TextView tvName, tvDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pahlawan);

        ivPhoto = findViewById(R.id.iv_photo_detail);
        tvName = findViewById(R.id.tv_name_detail);
        tvDescription = findViewById(R.id.tv_description_detail);

        ModelPahlawan pahlawan = getIntent().getParcelableExtra(DATA);
        if (pahlawan!=null){
            Glide.with(this).load(pahlawan.getImage()).into(ivPhoto);
            tvName.setText(pahlawan.getName());
            tvDescription.setText(pahlawan.getDescription());
        }

    }
}
