
package android.academy.skeleton.managers;

import android.academy.skeleton.managers.interfaces.BusinessLogicManagerAInterface;

public class BusinessLogicManagerA extends AbstractManager implements BusinessLogicManagerAInterface {

    
    public BusinessLogicManagerA() {
        // DO NOT REMOVE THIS, IT HAS EVENTBUS LOGIC.
        super();
    }
    
    
    /*
     * (non-Javadoc)
     * 
     * @see com.vodafone.backupplus.managers.interfaces.SystemEventsInterface#onConnectivityAction(int, int)
     */
    @Override
    public void onConnectivityAction(int wifiState, int networkState) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.vodafone.backupplus.managers.interfaces.SystemEventsInterface#onSystemEventBatteryChanged(int)
     */
    @Override
    public void onSystemEventBatteryChanged(int batteryPercentage) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.vodafone.backupplus.managers.interfaces.SystemEventsInterface#onSystemEventPowerConnected()
     */
    @Override
    public void onSystemEventPowerConnected() {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.vodafone.backupplus.managers.interfaces.SystemEventsInterface#onSystemEventPowerDisconnected()
     */
    @Override
    public void onSystemEventPowerDisconnected() {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.vodafone.backupplus.managers.interfaces.SystemEventsInterface#onSystemEventMediaScannerFinished()
     */
    @Override
    public void onSystemEventMediaScannerFinished() {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.vodafone.backupplus.managers.interfaces.SystemEventsInterface#onSystemEventMediaMounted()
     */
    @Override
    public void onSystemEventMediaMounted() {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.vodafone.backupplus.managers.interfaces.SystemEventsInterface#onSystemEventMediaUnmounted()
     */
    @Override
    public void onSystemEventMediaUnmounted() {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.vodafone.backupplus.managers.interfaces.SystemEventsInterface#onSystemEventMediaEject()
     */
    @Override
    public void onSystemEventMediaEject() {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.vodafone.backupplus.managers.interfaces.SystemEventsInterface#onSystemEvenStorageLow()
     */
    @Override
    public void onSystemEventStorageLow() {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.vodafone.backupplus.managers.interfaces.SystemEventsInterface#onSystemEvenStorageOk()
     */
    @Override
    public void onSystemEventStorageOk() {
        // TODO Auto-generated method stub

    }


}
