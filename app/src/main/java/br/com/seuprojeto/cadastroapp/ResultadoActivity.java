package br.com.seuprojeto.cadastroapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 Activity responsável por mostrar os dados cadastrados e permitir confirmação ou edição.
 */
public class ResultadoActivity extends AppCompatActivity {

    private TextView textResultado;
    private Button btnSim, btnNao;
    private String nome, idade, endereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        Log.i("ResultadoActivity", "onCreate chamado");

        // Referências dos componentes
        textResultado = findViewById(R.id.textResultado);
        btnSim = findViewById(R.id.btnSim);
        btnNao = findViewById(R.id.btnNao);

        // Receber dados da MainActivity
        Intent intent = getIntent();
        nome = intent.getStringExtra("nome");
        idade = intent.getStringExtra("idade");
        endereco = intent.getStringExtra("endereco");

        // Exibir dados
        textResultado.setText(
                "Nome: " + nome + "\n" +
                        "Idade: " + idade + "\n" +
                        "Endereço: " + endereco
        );

        // Botão SIM → confirma cadastro
        btnSim.setOnClickListener(v -> {
            Toast.makeText(this, R.string.sucesso, Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // limpa pilha
            startActivity(i);
        });

        // Botão NÃO → retorna com dados pré-carregados
        btnNao.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("nome", nome);
            i.putExtra("idade", idade);
            i.putExtra("endereco", endereco);
            startActivity(i);
        });
    }

    // Ciclo de vida com logs
    @Override protected void onStart() { super.onStart(); Log.i("ResultadoActivity", "onStart chamado"); }
    @Override protected void onResume() { super.onResume(); Log.d("ResultadoActivity", "onResume chamado"); }
    @Override protected void onPause() { super.onPause(); Log.w("ResultadoActivity", "onPause chamado"); }
    @Override protected void onDestroy() { super.onDestroy(); Log.e("ResultadoActivity", "onDestroy chamado"); }
}