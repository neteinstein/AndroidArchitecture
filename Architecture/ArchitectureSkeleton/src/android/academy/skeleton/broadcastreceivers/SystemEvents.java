package android.academy.skeleton.broadcastreceivers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import android.academy.skeleton.app.ApplicationSingleton;
import android.academy.skeleton.app.ManagersEnum;
import android.academy.skeleton.managers.interfaces.SystemEventsInterface;
import android.academy.skeleton.utils.interfaces.LoggerInterface;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

/**
 * This class should receive all the System Events the app is listening and send it to the Managers who are listening to
 * them.
 */
public class SystemEvents extends BroadcastReceiver {

    private static Map<String, List<ManagersEnum>> listeners = null;

    @Override
    public void onReceive(Context context, Intent intent) {
        
        //TODO This is running on the UI Thread, should be run on a background thread.
        
        defineListeners();

        final ApplicationSingleton app = ApplicationSingleton.getInstance();

        final String action = intent.getAction();

        if (listeners.containsKey(action)) {

            List<SystemEventsInterface> listListeners = new ArrayList<SystemEventsInterface>();

            for (ManagersEnum manager : listeners.get(action)) {
                switch (manager) {
                case BusinessLogicManagerA:
                    listListeners.add(app.getBusinessLogicManagerA());
                    break;
                case BusinessLogicManagerB:
                    listListeners.add(app.getBusinessLogicManagerB());
                    break;
                default:
                    app.getLogger().log(SystemEvents.class, LoggerInterface.TYPE.ERROR,
                            "No manager defined for: " + manager);
                    break;
                }

            }

            sendEvent(intent, listListeners);
        } else {
            app.getLogger().log(SystemEvents.class, LoggerInterface.TYPE.ERROR,
                    "No listener for system event action: " + action);
        }
    }

    /**
     * @param intent
     * @param eventInterface
     */
    private void sendEvent(Intent intent, List<SystemEventsInterface> listListeners) {

        final String action = intent.getAction();

        for (SystemEventsInterface eventInterface : listListeners) {

            if (eventInterface == null) {
                final ApplicationSingleton app = ApplicationSingleton.getInstance();
                app.getLogger().log(SystemEvents.class, LoggerInterface.TYPE.ERROR, "No manager defined for event...");
                return;
            }

            // TODO Send here the data necessary for each event...

            if (ConnectivityManager.CONNECTIVITY_ACTION.equals(action)) {
                eventInterface.onConnectivityAction(0, 0);
            } else if (Intent.ACTION_BATTERY_CHANGED.equals(action)) {
                eventInterface.onSystemEventBatteryChanged(0);
            } else if (Intent.ACTION_POWER_CONNECTED.equals(action)) {
                eventInterface.onSystemEventPowerConnected();
            } else if (Intent.ACTION_POWER_DISCONNECTED.equals(action)) {
                eventInterface.onSystemEventPowerDisconnected();
            } else if (Intent.ACTION_MEDIA_SCANNER_FINISHED.equals(action)) {
                eventInterface.onSystemEventMediaScannerFinished();
            } else if (Intent.ACTION_MEDIA_MOUNTED.equals(action)) {
                eventInterface.onSystemEventMediaMounted();
            } else if (Intent.ACTION_MEDIA_UNMOUNTED.equals(action)) {
                eventInterface.onSystemEventMediaUnmounted();
            } else if (Intent.ACTION_MEDIA_EJECT.equals(action)) {
                eventInterface.onSystemEventMediaEject();
            } else if (Intent.ACTION_DEVICE_STORAGE_LOW.equals(action)) {
                eventInterface.onSystemEventStorageLow();
            } else if (Intent.ACTION_DEVICE_STORAGE_OK.equals(action)) {
                eventInterface.onSystemEventStorageOk();
            }
        }
    }

    /**
     * This method defines who is listen to what.
     */
    private void defineListeners() {
        if (listeners != null)
            return;

        listeners = new ConcurrentHashMap<String, List<ManagersEnum>>();

        /*
         * ConnectivityManager.CONNECTIVITY_ACTION
         */
        listeners.put(ConnectivityManager.CONNECTIVITY_ACTION, getActionConnectivityChangedListeners());
        /*
         * Intent.ACTION_BATTERY_CHANGED
         */
        listeners.put(Intent.ACTION_BATTERY_CHANGED, getActionBatteryChangedListeners());

        /*
         * Intent.ACTION_POWER_CONNECTED
         */
        listeners.put(Intent.ACTION_POWER_CONNECTED, getActionPowerConnectedListeners());

        /*
         * Intent.ACTION_POWER_DISCONNECTED
         */
        listeners.put(Intent.ACTION_POWER_DISCONNECTED, getActionPowerDisconnectedListeners());

        /*
         * Intent.ACTION_MEDIA_SCANNER_FINISHED
         */
        listeners.put(Intent.ACTION_MEDIA_SCANNER_FINISHED, getActionMediaScannerFinishedListeners());
        /*
         * Intent.ACTION_MEDIA_MOUNTED
         */
        listeners.put(Intent.ACTION_MEDIA_MOUNTED, getActionMediaMountedListeners());

        /*
         * Intent.ACTION_MEDIA_UNMOUNTED
         */
        listeners.put(Intent.ACTION_MEDIA_UNMOUNTED, getActionMediaUnmountedListeners());

        /*
         * Intent.ACTION_MEDIA_EJECT
         */
        listeners.put(Intent.ACTION_MEDIA_EJECT, getActionMediaEjectListeners());

        /*
         * Intent.ACTION_DEVICE_STORAGE_LOW
         */
        listeners.put(Intent.ACTION_DEVICE_STORAGE_LOW, getActionDeviceStorageLowListeners());

        /*
         * Intent.ACTION_DEVICE_STORAGE_OK
         */
        listeners.put(Intent.ACTION_DEVICE_STORAGE_OK, getActionDeviceStorageOkListeners());

    }

    /**
     * @return
     */
    private List<ManagersEnum> getActionConnectivityChangedListeners() {
        /*
         * ConnectivityManager.CONNECTIVITY_ACTION
         */
        final List<ManagersEnum> CONNECTIVITY_ACTION = new ArrayList<ManagersEnum>();
        CONNECTIVITY_ACTION.add(ManagersEnum.BusinessLogicManagerA);
        CONNECTIVITY_ACTION.add(ManagersEnum.BusinessLogicManagerB);
        return CONNECTIVITY_ACTION;
    }

    /**
     * @return
     */
    private List<ManagersEnum> getActionMediaMountedListeners() {
        /*
         * Intent.ACTION_MEDIA_MOUNTED
         */
        final List<ManagersEnum> ACTION_MEDIA_MOUNTED_LISTENERS = new ArrayList<ManagersEnum>();
        ACTION_MEDIA_MOUNTED_LISTENERS.add(ManagersEnum.BusinessLogicManagerA);
        ACTION_MEDIA_MOUNTED_LISTENERS.add(ManagersEnum.BusinessLogicManagerB);
        return ACTION_MEDIA_MOUNTED_LISTENERS;
    }

    /**
     * @return
     */
    private List<ManagersEnum> getActionBatteryChangedListeners() {
        /*
         * Intent.ACTION_BATTERY_CHANGED
         */
        final List<ManagersEnum> ACTION_BATTERY_CHANGED = new ArrayList<ManagersEnum>();
        ACTION_BATTERY_CHANGED.add(ManagersEnum.BusinessLogicManagerA);
        ACTION_BATTERY_CHANGED.add(ManagersEnum.BusinessLogicManagerB);
        return ACTION_BATTERY_CHANGED;
    }

    /**
     * @return
     */
    private List<ManagersEnum> getActionPowerConnectedListeners() {
        /*
         * Intent.ACTION_POWER_CONNECTED
         */
        final List<ManagersEnum> ACTION_POWER_CONNECTED = new ArrayList<ManagersEnum>();
        ACTION_POWER_CONNECTED.add(ManagersEnum.BusinessLogicManagerA);
        ACTION_POWER_CONNECTED.add(ManagersEnum.BusinessLogicManagerB);
        return ACTION_POWER_CONNECTED;
    }

    /**
     * @return
     */
    private List<ManagersEnum> getActionPowerDisconnectedListeners() {
        /*
         * Intent.ACTION_POWER_DISCONNECTED
         */
        final List<ManagersEnum> ACTION_POWER_DISCONNECTED = new ArrayList<ManagersEnum>();
        ACTION_POWER_DISCONNECTED.add(ManagersEnum.BusinessLogicManagerA);
        ACTION_POWER_DISCONNECTED.add(ManagersEnum.BusinessLogicManagerB);
        return ACTION_POWER_DISCONNECTED;
    }

    /**
     * @return
     */
    private List<ManagersEnum> getActionMediaScannerFinishedListeners() {
        /*
         * Intent.ACTION_MEDIA_SCANNER_FINISHED
         */
        final List<ManagersEnum> MEDIA_SCANNER_FINISHED = new ArrayList<ManagersEnum>();
        MEDIA_SCANNER_FINISHED.add(ManagersEnum.BusinessLogicManagerA);
        MEDIA_SCANNER_FINISHED.add(ManagersEnum.BusinessLogicManagerB);
        return MEDIA_SCANNER_FINISHED;
    }

    /**
     * @return
     */
    private List<ManagersEnum> getActionMediaUnmountedListeners() {
        /*
         * Intent.ACTION_MEDIA_UNMOUNTED
         */
        final List<ManagersEnum> ACTION_MEDIA_UNMOUNTED = new ArrayList<ManagersEnum>();
        ACTION_MEDIA_UNMOUNTED.add(ManagersEnum.BusinessLogicManagerA);
        return ACTION_MEDIA_UNMOUNTED;
    }

    /**
     * @return
     */
    private List<ManagersEnum> getActionMediaEjectListeners() {
        /*
         * Intent.ACTION_MEDIA_EJECT
         */
        final List<ManagersEnum> ACTION_MEDIA_EJECT = new ArrayList<ManagersEnum>();
        ACTION_MEDIA_EJECT.add(ManagersEnum.BusinessLogicManagerA);
        return ACTION_MEDIA_EJECT;
    }

    /**
     * @return
     */
    private List<ManagersEnum> getActionDeviceStorageLowListeners() {
        /*
         * Intent.ACTION_DEVICE_STORAGE_LOW
         */
        final List<ManagersEnum> ACTION_DEVICE_STORAGE_LOW = new ArrayList<ManagersEnum>();
        ACTION_DEVICE_STORAGE_LOW.add(ManagersEnum.BusinessLogicManagerA);
        return ACTION_DEVICE_STORAGE_LOW;
    }

    /**
     * @return
     */
    private List<ManagersEnum> getActionDeviceStorageOkListeners() {
        /*
         * Intent.ACTION_DEVICE_STORAGE_OK
         */
        final List<ManagersEnum> ACTION_DEVICE_STORAGE_OK = new ArrayList<ManagersEnum>();
        ACTION_DEVICE_STORAGE_OK.add(ManagersEnum.BusinessLogicManagerA);
        return ACTION_DEVICE_STORAGE_OK;
    }

}
