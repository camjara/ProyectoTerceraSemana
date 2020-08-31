package com.example.mascotasrating.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.mascotasrating.Adapters.MascotaAdapter;
import com.example.mascotasrating.Models.Mascota;
import com.example.mascotasrating.R;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView rvListaMascotas;
    ImageButton ibMejoresRating;
    ArrayList<Mascota> listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        miActionBar.setTitle("Petagram");
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ibMejoresRating = (ImageButton) findViewById(R.id.ibMejoresRating);
        ibMejoresRating.setOnClickListener(this);
        listaMascotas = new ArrayList<>();
        rvListaMascotas = (RecyclerView) findViewById(R.id.rvListaMascotas);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaMascotas.setLayoutManager(manager);
        cargarMascotas();
        inicalizarAdaptador();

    }

    private void inicalizarAdaptador(){
        MascotaAdapter adapter = new MascotaAdapter(listaMascotas);
        rvListaMascotas.setAdapter(adapter);
    }

    private void cargarMascotas()
    {
        listaMascotas.add(new Mascota(getNombre(),0,getImagen(),getColor()));
        listaMascotas.add(new Mascota(getNombre(),0,getImagen(),getColor()));
        listaMascotas.add(new Mascota(getNombre(),0,getImagen(),getColor()));
        listaMascotas.add(new Mascota(getNombre(),0,getImagen(),getColor()));
        listaMascotas.add(new Mascota(getNombre(),0,getImagen(),getColor()));
        listaMascotas.add(new Mascota(getNombre(),0,getImagen(),getColor()));
        listaMascotas.add(new Mascota(getNombre(),0,getImagen(),getColor()));
    }

    private String getNombre()
    {
        String listaNombres [] = {"Lester","Manolo","Susy","Toby","Lulú","Simon","Lana"};
        Random r = new Random();
        int numero = r.nextInt(7);
        return  listaNombres[numero];
    }

    private int getImagen()
    {
        int ListaAnimales  [] = {R.drawable.ic_caballo,R.drawable.ic_elefante,R.drawable.ic_mono,R.drawable.ic_perro,R.drawable.ic_tigre,R.drawable.ic_toro,R.drawable.ic_vaca};
        Random r = new Random();
        int numero = r.nextInt(7);
        return ListaAnimales[numero];
    }

    private int getColor()
    {
        int ListaColores  [] = {R.color.azul,R.color.amarillo,R.color.aguamarina,R.color.verde,R.color.rojo,R.color.naranja,R.color.fucsia};
        Random r = new Random();
        int numero = r.nextInt(7);
        return ListaColores[numero];
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.ibMejoresRating:
                mostrarMejoresRating();
                break;
            default:
                break;
        }
    }

    private void mostrarMejoresRating()
    {
        listaMascotas.sort(new Comparator<Mascota>() {
            @Override
            public int compare(Mascota mascota, Mascota t1) {
                int result = -1;
                 if(mascota.getRating() < t1.getRating())
                     result = -1;
                 else if(mascota.getRating() == t1.getRating())
                     result = 0;
                 else
                     result = 1;

                 return result;
            }
        });


        Intent intent = new Intent(this, PrincipalesRatingActivity.class);
        int cont = 1;
        for (int i = listaMascotas.size() - 1; i > 1; i --) {
            String [] mascota = {listaMascotas.get(i).getNombre(),String.valueOf(listaMascotas.get(i).getRating()),String.valueOf(listaMascotas.get(i).getFoto()),String.valueOf(listaMascotas.get(i).getColor())};
            intent.putExtra(String.valueOf(cont), mascota);
            cont++;
        }
        startActivity(intent);
    }
}