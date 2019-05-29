package pe.edu.cibertec.permisos;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnPermissios;
    private TextView textViewPermissios;
    private int valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPermissios = findViewById(R.id.btnPermissios);
        textViewPermissios = findViewById(R.id.textViewPermissios);

        btnPermissios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPermissios();
            }
        });
    }

    private void showPermissios() {
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            requestPermission();
            valor = 0;
            writeText(valor);
        }else{
            valor = 1;
            writeText(valor);
        }
    }

    private void writeText(int valor) {
        if(valor == 0){
            textViewPermissios.setText("¡Por favor acepta todos los permisos!");
        }else{
            textViewPermissios.setText("¡Todos los permisos fueron aceptados!");
        }
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 1){
            if((grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) &&
                    (grantResults.length > 0 && grantResults[1] == PackageManager.PERMISSION_GRANTED) &&
                    (grantResults.length > 0 && grantResults[2] == PackageManager.PERMISSION_GRANTED)){
                valor = 1;
                writeText(valor);
            }else{
                showPermissios();
            }
        }
    }
}
