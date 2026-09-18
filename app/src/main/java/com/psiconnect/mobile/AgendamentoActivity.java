package com.psiconnect.mobile;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AgendamentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento);

        String nomeMedico = getIntent().getStringExtra("nome");

        TextView txtComMedico = findViewById(R.id.txtComMedico);
        txtComMedico.setText(getString(R.string.agendamento_com, nomeMedico));

        RadioGroup radioGroupModo = findViewById(R.id.radioGroupModo);
        Spinner spinnerHorario = findViewById(R.id.spinnerHorario);
        EditText edtNome = findViewById(R.id.edtNome);
        EditText edtEmail = findViewById(R.id.edtEmail);
        Button btnConfirmar = findViewById(R.id.btnConfirmar);

        btnConfirmar.setOnClickListener(v -> {
            String nomePaciente = edtNome.getText().toString().trim();
            String email = edtEmail.getText().toString().trim();

            if (TextUtils.isEmpty(nomePaciente) || TextUtils.isEmpty(email)) {
                Toast.makeText(this, R.string.agendamento_erro_campos, Toast.LENGTH_SHORT).show();
                return;
            }

            int modoSelecionadoId = radioGroupModo.getCheckedRadioButtonId();
            RadioButton radioModo = findViewById(modoSelecionadoId);
            String modo = radioModo.getText().toString();
            String horario = spinnerHorario.getSelectedItem().toString();

            String resumo = getString(R.string.agendamento_resumo_texto,
                    nomePaciente, nomeMedico, modo, horario);

            new AlertDialog.Builder(this)
                    .setTitle(R.string.agendamento_resumo_titulo)
                    .setMessage(resumo)
                    .setPositiveButton(R.string.ok, (dialog, which) -> finish())
                    .show();
        });
    }
}
