package com.psiconnect.mobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MedicoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medico);

        String nome = getIntent().getStringExtra("nome");
        String especialidade = getIntent().getStringExtra("especialidade");
        String crp = getIntent().getStringExtra("crp");
        String preco = getIntent().getStringExtra("preco");

        TextView txtNome = findViewById(R.id.txtNome);
        TextView txtCrpEspecialidade = findViewById(R.id.txtCrpEspecialidade);
        TextView txtPreco = findViewById(R.id.txtPreco);

        txtNome.setText(nome);
        txtCrpEspecialidade.setText(crp + " · " + especialidade);
        txtPreco.setText(preco);

        Button btnAgendar = findViewById(R.id.btnAgendar);
        btnAgendar.setOnClickListener(v -> {
            Intent intent = new Intent(MedicoActivity.this, AgendamentoActivity.class);
            intent.putExtra("nome", nome);
            startActivity(intent);
        });
    }
}
