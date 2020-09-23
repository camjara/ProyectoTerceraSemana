package com.example.mascotasrating.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mascotasrating.Adapters.MascotaAdapter;
import com.example.mascotasrating.Models.Mascota;
import com.example.mascotasrating.R;

import java.util.ArrayList;


public class PerfilFragment extends Fragment {

    ArrayList<Mascota> listaPerfiles;
    RecyclerView rvListaPerfiles;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        rvListaPerfiles = (RecyclerView) v.findViewById(R.id.rvListaPerfil);
        GridLayoutManager manager = new GridLayoutManager(getActivity(),2);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaPerfiles.setLayoutManager(manager);
        listaPerfiles = new ArrayList<>();
        cargarMascotas();
        inicalizarAdaptador();

        return v;
    }
    private void inicalizarAdaptador(){
        MascotaAdapter adapter = new MascotaAdapter(listaPerfiles);
        rvListaPerfiles.setAdapter(adapter);
    }


    private void cargarMascotas()
    {
        listaPerfiles.add(new Mascota("Manolo",2,R.drawable.ic_caballo,R.color.rojo));
        listaPerfiles.add(new Mascota("Manolo",3,R.drawable.ic_caballo,R.color.rojo));
        listaPerfiles.add(new Mascota("Manolo",1,R.drawable.ic_caballo,R.color.rojo));
        listaPerfiles.add(new Mascota("Manolo",5,R.drawable.ic_caballo,R.color.rojo));
        listaPerfiles.add(new Mascota("Manolo",7,R.drawable.ic_caballo,R.color.rojo));
        listaPerfiles.add(new Mascota("Manolo",2,R.drawable.ic_caballo,R.color.rojo));
        listaPerfiles.add(new Mascota("Manolo",2,R.drawable.ic_caballo,R.color.rojo));
        listaPerfiles.add(new Mascota("Manolo",8,R.drawable.ic_caballo,R.color.rojo));
        listaPerfiles.add(new Mascota("Manolo",9,R.drawable.ic_caballo,R.color.rojo));
        listaPerfiles.add(new Mascota("Manolo",10,R.drawable.ic_caballo,R.color.rojo));
        listaPerfiles.add(new Mascota("Manolo",4,R.drawable.ic_caballo,R.color.rojo));
        listaPerfiles.add(new Mascota("Manolo",5,R.drawable.ic_caballo,R.color.rojo));
    }
}