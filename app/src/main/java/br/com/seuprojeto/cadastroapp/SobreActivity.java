package br.com.seuprojeto.cadastroapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SobreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
        Log.i("SobreActivity", "onCreate chamado");
    }

    @Override protected void onStart(){super.onStart();Log.i("SobreActivity","onStart chamado");}
    @Override protected void onResume(){super.onResume();Log.d("SobreActivity","onResume chamado");}
    @Override protected void onPause(){super.onPause();Log.w("SobreActivity","onPause chamado");}
    @Override protected void onDestroy(){super.onDestroy();Log.e("SobreActivity","onDestroy chamado");}
}
