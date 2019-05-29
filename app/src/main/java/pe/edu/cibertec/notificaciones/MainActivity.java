package pe.edu.cibertec.notificaciones;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private String name, description, id;
    private int importance;
    private NotificationChannel notificationChannel;
    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNotificaionChannel();
        intent = new Intent(getApplicationContext(), NotificationBackgroundService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intent);
        }else{
            startService(intent);
        }
    }

    private void createNotificaionChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            id = "pe.edu.notification.CHANNEL";
            name = "Canal de Notificaciones";
            description = "Canal que permite ver si hay cambios en el sistema";
            importance = NotificationManager.IMPORTANCE_MAX;

            notificationChannel = new NotificationChannel(id, name, importance);
            notificationChannel.setDescription(description);

            notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
