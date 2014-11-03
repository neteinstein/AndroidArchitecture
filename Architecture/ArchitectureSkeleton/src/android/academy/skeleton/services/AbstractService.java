package android.academy.skeleton.services;

import android.academy.skeleton.tasks.GenericAsyncTask;
import android.academy.skeleton.utils.CompatibilityUtils;
import android.app.Service;
import android.content.Intent;
import android.os.Build;

/**
 * Abstract Service which implements generic methods that should be used by all services
 * 
 */
public abstract class AbstractService extends Service {

    /**
     * boolean that can be used to check if service is running
     */
    public static boolean isServiceRunning = false;
    /**
     * boolean that is used to initialize the service as sticky or not
     */
    private boolean mSticky = true;

    /**
     * @param name
     */
    public AbstractService(boolean isSticky) {
        super();
        this.mSticky = isSticky;
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.app.Service#onCreate()
     */
    @Override
    public void onCreate() {
        super.onCreate();
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.app.Service#onStartCommand(android.content.Intent, int, int)
     */
    public int onStartCommand(Intent intent, int flags, int startID) {

        // Restore state if service has been initialized after being killed by the OS.
        if (intent == null) {
            restoreState();
        }

        int value;

        if (mSticky) {
            // START_STICKY = 1 & START_STICKY_COMPATIBILITY = 0
            value = getApplicationInfo().targetSdkVersion > Build.VERSION_CODES.DONUT ? 1 : 0;
        } else {
            value = START_NOT_STICKY;
        }

        return value;
    }

    /**
     * Restore state of the Service when it returns from being killed by the OS.
     * 
     * This needs to have an AsyncTask because it is run on the UI Thread. All the other methods are invoked by bind and
     * run on the thread that invokes them, and as the Managers use background threads they run in background threads
     */
    private void restoreState() {
        GenericAsyncTask.GenericBackgroundCallback background = new GenericAsyncTask.GenericBackgroundCallback() {

            @Override
            public Object doInBackgroundThread(Object[] object) {
                // Restore state, if needed here..
                restoreServiceState();
                return null;
            }
        };

        GenericAsyncTask task = new GenericAsyncTask(background);
        CompatibilityUtils.executeOnExecutor(task);
    }

    /**
     * This is a method that is called if the app was killed (and the service with it) and is restarted by the OS. Each
     * services needs to have the capability to restore it's state
     */
    public abstract void restoreServiceState();

}
