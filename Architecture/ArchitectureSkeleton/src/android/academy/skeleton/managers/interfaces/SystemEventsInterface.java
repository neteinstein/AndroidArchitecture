package android.academy.skeleton.managers.interfaces;

/**
 * This is an interface to enable Managers to receive System Events from SystemEvents Broadcast Receiver Although not
 * all receive all events, all must have all method to have a generic interface to send the notification Those which are
 * interested in the event, add code to treat it, the others simply leave the method with log error message to detect
 * when events arrive on places that are not supposed to.
 * 
 */
public interface SystemEventsInterface {

    public void onConnectivityAction(int wifiState, int networkState);

    public void onSystemEventBatteryChanged(int batteryPercentage);

    public void onSystemEventPowerConnected();

    public void onSystemEventPowerDisconnected();

    public void onSystemEventMediaScannerFinished();

    public void onSystemEventMediaMounted();

    public void onSystemEventMediaUnmounted();

    public void onSystemEventMediaEject();

    public void onSystemEventStorageLow();

    public void onSystemEventStorageOk();
}
