package pe.edu.cibertec.notificaciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {

    private TextView changedSO;
    private Bundle extras;
    private String mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        changedSO = findViewById(R.id.changedSO);

        if (savedInstanceState == null) {
            extras = getIntent().getExtras();
            mode = extras.getString("mode");

            switch (mode){
                case "airplane":
                    changedSO.setText("¡El teléfono tuvo un cambio en el modo avión!");
                    break;
                case "internet":
                    changedSO.setText("¡El teléfono tuvo un cambio en conexión a internet!");
                    break;
                case "location":
                    changedSO.setText("¡El teléfono tuvo un cambio en la función de localización!");
                    break;
                case "batery":
                    changedSO.setText("¡El teléfono tuvo un cambio en la batería!");
                    break;
                case "ringer":
                    changedSO.setText("¡El teléfono tuvo un cambio en volumen!");
                    break;
            }
        }
    }
}
