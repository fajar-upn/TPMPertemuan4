package com.example.myapplication.ui.pahlawan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DataPahlawan;
import com.example.myapplication.DetailPahlawan;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.adapter.AdapterPahlawan;
import com.example.myapplication.model.ModelPahlawan;

import java.util.ArrayList;

public class PahlawanFragment extends Fragment {

    private RecyclerView rvPahlawan;
    private ArrayList<ModelPahlawan> list = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_pahlawan, container, false);

        rvPahlawan =root.findViewById(R.id.rv_pahlawan);
        rvPahlawan.setHasFixedSize(true);
        list.addAll(DataPahlawan.getListData());
        recyclerView();

        return root;
    }

    private void recyclerView() {
        rvPahlawan.setLayoutManager(new LinearLayoutManager(getContext()));
        AdapterPahlawan adapterPahlawan = new AdapterPahlawan(getContext());
        adapterPahlawan.setList(list);
        rvPahlawan.setAdapter(adapterPahlawan);

        adapterPahlawan.setOnItemClikCallback(new AdapterPahlawan.OnItemClikCallback() {
            @Override
            public void onItemCliked(ModelPahlawan pahlawan) {
                Toast.makeText(getContext(),"Anda memilih pahlawan : "+ pahlawan.getName(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), DetailPahlawan.class);
                intent.putExtra(DetailPahlawan.DATA,pahlawan);
                startActivity(intent);
            }
        });

    }
}
