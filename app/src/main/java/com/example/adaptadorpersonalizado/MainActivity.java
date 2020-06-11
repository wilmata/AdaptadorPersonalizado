package com.example.adaptadorpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static ArrayList<Persona> alp = new ArrayList<Persona>();
    ListView listPersonas;
    PersonaAdapter recAdap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listPersonas = (ListView)this.findViewById(R.id.listPersonas);
        recAdap = new PersonaAdapter(this, R.layout.modelo_lista, alp);

        alp.add(new Persona(1, "Denis Espinoza", "85771254", 0));
        alp.add(new Persona(2, "Patricia Rojas", "82375422", 1));
        alp.add(new Persona(3, "Wilmer Matamoros", "89256712", 0));
        alp.add(new Persona(4, "Sofia Moncada", "85789079", 1));
        alp.add(new Persona(5, "Juan Perez", "4565675", 0));

        listPersonas.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listPersonas.setAdapter(recAdap);
        listPersonas.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getBaseContext(), "Se selecionó " + alp.get(position).getNombre() + " su id es " + id, Toast.LENGTH_LONG).show();
    }
}
