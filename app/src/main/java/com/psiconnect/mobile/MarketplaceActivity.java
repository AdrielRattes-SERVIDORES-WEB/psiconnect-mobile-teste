package com.psiconnect.mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

public class MarketplaceActivity extends AppCompatActivity {

    private final String[] nomes = {
            "Dra. Ana Beatriz Silva",
            "Dr. Rafael Souza",
            "Dra. Carla Nunes",
            "Dr. Bruno Alves"
    };

    private final String[] especialidades = {
            "Ansiedade · TCC",
            "Terapia de Casal",
            "Psicologia Infantil",
            "Empresas · Burnout"
    };

    private final String[] crps = {
            "CRP 06/12345",
            "CRP 06/22233",
            "CRP 06/33344",
            "CRP 06/44455"
    };

    private final String[] precos = {
            "R$ 180",
            "R$ 200",
            "R$ 170",
            "R$ 220"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketplace);

        RecyclerView recyclerView = findViewById(R.id.listPsicologos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PsicologoAdapter());

        MaterialButton btnNavAgendamentos = findViewById(R.id.btnNavAgendamentos);
        MaterialButton btnNavCarteira = findViewById(R.id.btnNavCarteira);
        MaterialButton btnNavPerfil = findViewById(R.id.btnNavPerfil);

        View.OnClickListener emBreve = v ->
                Toast.makeText(this, R.string.nav_em_breve, Toast.LENGTH_SHORT).show();

        btnNavAgendamentos.setOnClickListener(emBreve);
        btnNavCarteira.setOnClickListener(emBreve);
        btnNavPerfil.setOnClickListener(emBreve);
    }

    private class PsicologoAdapter extends RecyclerView.Adapter<PsicologoAdapter.ViewHolder> {

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_psicologo, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.txtNome.setText(nomes[position]);
            holder.txtEspecialidade.setText(especialidades[position]);
            holder.txtPreco.setText(precos[position]);

            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(MarketplaceActivity.this, MedicoActivity.class);
                intent.putExtra("nome", nomes[position]);
                intent.putExtra("especialidade", especialidades[position]);
                intent.putExtra("crp", crps[position]);
                intent.putExtra("preco", precos[position]);
                startActivity(intent);
            });
        }

        @Override
        public int getItemCount() {
            return nomes.length;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView txtNome;
            TextView txtEspecialidade;
            TextView txtPreco;

            ViewHolder(@NonNull View itemView) {
                super(itemView);
                txtNome = itemView.findViewById(R.id.txtNome);
                txtEspecialidade = itemView.findViewById(R.id.txtEspecialidade);
                txtPreco = itemView.findViewById(R.id.txtPreco);
            }
        }
    }
}
