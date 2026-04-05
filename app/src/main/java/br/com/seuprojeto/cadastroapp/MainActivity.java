package br.com.seuprojeto.cadastroapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

/**
 * Activity principal responsável pelo cadastro dos dados.
 * Contém campos de Nome, Idade e Endereço, além dos botões
 * Salvar e Sobre.
 *
 * Ciclo de vida é logado para fins didáticos.
 */
public class MainActivity extends AppCompatActivity {

    private EditText editNome, editIdade, editEndereco;
    private Button btnSalvar, btnSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity", "onCreate chamado");

        // Referências dos componentes
        editNome = findViewById(R.id.editNome);
        editIdade = findViewById(R.id.editIdade);
        editEndereco = findViewById(R.id.editEndereco);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnSobre = findViewById(R.id.btnSobre);

        // Pré-carregar dados se vier da tela Resultado (quando usuário clicou "Não")
        Intent intent = getIntent();
        if (intent.hasExtra("nome")) {
            editNome.setText(intent.getStringExtra("nome"));
            editIdade.setText(intent.getStringExtra("idade"));
            editEndereco.setText(intent.getStringExtra("endereco"));
        }

        // Botão Salvar → envia dados para ResultadoActivity
        btnSalvar.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, ResultadoActivity.class);
            i.putExtra("nome", editNome.getText().toString());
            i.putExtra("idade", editIdade.getText().toString());
            i.putExtra("endereco", editEndereco.getText().toString());
            startActivity(i);
        });

        // Botão Sobre → abre a tela SobreActivity
        btnSobre.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, SobreActivity.class);
            startActivity(i);
        });
    }

    // Inflar o menu na Toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Tratar clique no item de menu "Sobre"
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_sobre) {
            startActivity(new Intent(this, SobreActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Ciclo de vida com logs
    @Override protected void onStart() { super.onStart(); Log.i("MainActivity", "onStart chamado"); }
    @Override protected void onResume() { super.onResume(); Log.d("MainActivity", "onResume chamado"); }
    @Override protected void onPause() { super.onPause(); Log.w("MainActivity", "onPause chamado"); }
    @Override protected void onDestroy() { super.onDestroy(); Log.e("MainActivity", "onDestroy chamado"); }
}