package pe.edu.dependencyinjection;

public class AppPoolWatcher {

    iNotificationAction action;


    //Inyeccion de constructor

    public AppPoolWatcher(iNotificationAction action) {
        this.action = action;
    }

    public AppPoolWatcher() {

    }

    //Inyecion de Atributo

    public iNotificationAction getAction() {
        return action;
    }

    public void setAction(iNotificationAction action) {
        this.action = action;
    }
    //-----------------------------------------------

    public void notify(String message)
    {
        action.write(message);
    }

    //Inyeccion de metodo

    public void notify(iNotificationAction action, String message)
    {
        this.action = action;
        this.action.write(message);
    }

    /*
    public void notify(String message)
    {
        if (action == null)
        {
            //eventLogWriter = new EventLogWriter();

            action = new EventLogWriter();
            action = new SmsSender();
            action = new EmailSender();
        }

        action .write(message);

    }*/
}
