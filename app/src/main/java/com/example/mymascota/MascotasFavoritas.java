package com.example.mymascota;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.appcompat.widget.Toolbar;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.os.Bundle;

        import com.example.mymascota.adapter.AdaptadorMascotasFavoritas;
        import com.example.mymascota.adapter.MascotaAdaptador;
        import com.example.mymascota.db.ConstructorMascota;
        import com.example.mymascota.pojo.Mascota;

        import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {


    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    public AdaptadorMascotasFavoritas adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar miActionBarFavoritos = (Toolbar) findViewById(R.id.miActionBarFavoritos);

        setSupportActionBar(miActionBarFavoritos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);
        obtenerRankingMascotas();
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        adaptador = new AdaptadorMascotasFavoritas(mascotas, this);
        rvMascotas.setAdapter(adaptador);
    }

    public void obtenerRankingMascotas() {
        ConstructorMascota constructorMascotas = new ConstructorMascota(this);
        mascotas = constructorMascotas.obtenerRankingMacotas();
    }

}