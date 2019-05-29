package pe.edu.cibertec.notificaciones;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import java.util.Date;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private String action, id;
    private Intent newIntent;
    private PendingIntent pendingIntent;
    private int date;
    private NotificationCompat.Builder notification;
    @Override
    public void onReceive(Context context, Intent intent) {
        action = intent.getAction();
        newIntent = new Intent(context, NotificationActivity.class);
        id = "pe.edu.notification.CHANNEL";
        date = (int) (new Date().getTime()/1000);
        if (action.equals("android.intent.action.AIRPLANE_MODE")) {
            newIntent.putExtra("mode", "airplane");
            pendingIntent = PendingIntent.getActivity(context, 0, newIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            notification = new NotificationCompat
                    .Builder(context, id)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Cambio en el sistema")
                    .setContentText("¡Hubo un cambio en el modo avión!")
                    .setPriority(NotificationCompat.PRIORITY_MAX)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
            managerCompat.notify(date, notification.build());
        }else if(action.equals("android.net.conn.CONNECTIVITY_CHANGE")){
            newIntent.putExtra("mode", "internet");
            pendingIntent = PendingIntent.getActivity(context, 0, newIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            notification = new NotificationCompat
                    .Builder(context, id)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Cambio en el sistema")
                    .setContentText("¡Hubo un cambio en la conexión a internet!")
                    .setPriority(NotificationCompat.PRIORITY_MAX)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
            managerCompat.notify(date, notification.build());
        }else if(action.equals("android.location.PROVIDERS_CHANGED")){
            newIntent.putExtra("mode", "location");
            pendingIntent = PendingIntent.getActivity(context, 0, newIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            notification = new NotificationCompat
                    .Builder(context, id)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Cambio en el sistema")
                    .setContentText("¡Hubo un cambio en la función de localización!")
                    .setPriority(NotificationCompat.PRIORITY_MAX)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
            managerCompat.notify(date, notification.build());
        }else if(action.equals("android.intent.action.ACTION_POWER_CONNECTED") || action.equals("android.intent.action.ACTION_POWER_DISCONNECTED") || action.equals("android.intent.action.ACTION_BATTERY_LOW") || action.equals("android.intent.action.ACTION_BATTERY_OKAY")){
            newIntent.putExtra("mode", "batery");
            pendingIntent = PendingIntent.getActivity(context, 0, newIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            notification = new NotificationCompat
                    .Builder(context, id)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Cambio en el sistema")
                    .setContentText("¡Hubo un cambio en la batería!")
                    .setPriority(NotificationCompat.PRIORITY_MAX)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
            managerCompat.notify(date, notification.build());
        }else if(action.equals("android.media.RINGER_MODE_CHANGED")){
            newIntent.putExtra("mode", "ringer");
            pendingIntent = PendingIntent.getActivity(context, 0, newIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            notification = new NotificationCompat
                    .Builder(context, id)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Cambio en el sistema")
                    .setContentText("¡Hubo un cambio en el volumen!")
                    .setPriority(NotificationCompat.PRIORITY_MAX)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
            managerCompat.notify(date, notification.build());
        }
    }
}
