package pe.edu.dependencyinjection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        base
        AppPoolWatcher appPoolWatcher = new AppPoolWatcher();
        appPoolWatcher.notify("Ocurrio el evento");
        */

        //Inyeccion de constructor
        /*
        EmailSender action = new EmailSender();
        AppPoolWatcher appPoolWatcher = new AppPoolWatcher(action);

        appPoolWatcher.notify("ocurrio el evento");
        */
        //Inyeccion de metodo
        /*
        SmsSender action = new SmsSender();
        AppPoolWatcher appPoolWatcher = new AppPoolWatcher();
        appPoolWatcher.notify(action,"ocurrio el mensaje");
        */

        //Inyecion de propiedad
        EventLogWriter action = new EventLogWriter();
        AppPoolWatcher appPoolWatcher = new AppPoolWatcher();

        appPoolWatcher.setAction(action);
        appPoolWatcher.notify("ocurrio un evento");

    }
}
