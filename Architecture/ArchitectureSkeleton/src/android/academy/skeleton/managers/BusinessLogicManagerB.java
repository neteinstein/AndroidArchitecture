package android.academy.skeleton.managers;

import android.academy.skeleton.app.ApplicationSingleton;
import android.academy.skeleton.bus.events.LoginEvent;
import android.academy.skeleton.managers.interfaces.BusinessLogicManagerBInterface;
import android.academy.skeleton.services.GenericService;
import android.academy.skeleton.services.GenericService.GenericServiceBinder;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

public class BusinessLogicManagerB extends AbstractManager implements BusinessLogicManagerBInterface {

    private boolean mGenericServiceBounded = false;
    private GenericServiceBinder mGenericServiceBinder = null;

    /** Defines callbacks for service binding, passed to bindService() */
    private ServiceConnection mRemoteServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            mGenericServiceBinder = (GenericServiceBinder) service;
            mGenericServiceBounded = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName className) {
            mGenericServiceBounded = false;
        }
    };

    public BusinessLogicManagerB() {
        // DO NOT REMOVE THIS, IT HAS EVENTBUS LOGIC.
        super();

        bindServices();
    }

    /**
     * 
     */
    private void bindServices() {
        Context context = ApplicationSingleton.getInstance().getApplicationContext();

        if (GenericService.isServiceRunning) {
            Intent intent = new Intent(context, GenericService.class);
            context.bindService(intent, mRemoteServiceConnection, Context.BIND_AUTO_CREATE);
        }

    }

    /** Defines callbacks for service binding, passed to bindService() */
    private ServiceConnection mLocalServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            mGenericServiceBinder = (GenericServiceBinder) service;
            mGenericServiceBounded = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName className) {
            mGenericServiceBounded = false;
        }
    };

    /**
     * Event Bus method receiver. Because of the method name "onEvent ASYNC" it already enters this method on a
     * background thread (a thread from a thread pool created by EventBus)
     * 
     * @param event
     */
    public void onEventAsync(LoginEvent event) {
        ApplicationSingleton app = ApplicationSingleton.getInstance();
        Context context = app.getApplicationContext();
        context.startService(new Intent(context, GenericService.class));
    }

    @Override
    public void onConnectivityAction(int wifiState, int networkState) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onSystemEventBatteryChanged(int batteryPercentage) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onSystemEventPowerConnected() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onSystemEventPowerDisconnected() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onSystemEventMediaScannerFinished() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onSystemEventMediaMounted() {
        if (mGenericServiceBounded) {
            mGenericServiceBinder.doAlotOfStuff();
        }
    }

    @Override
    public void onSystemEventMediaUnmounted() {
    	if (mGenericServiceBounded) {
            mGenericServiceBinder.doAlotOfStuff();
        }

    }

    @Override
    public void onSystemEventMediaEject() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onSystemEventStorageLow() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onSystemEventStorageOk() {
        // TODO Auto-generated method stub

    }

}
