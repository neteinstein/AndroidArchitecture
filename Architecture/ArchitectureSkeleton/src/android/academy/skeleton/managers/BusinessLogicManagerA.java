
package android.academy.skeleton.managers;

import android.academy.skeleton.managers.interfaces.BusinessLogicManagerAInterface;

public class BusinessLogicManagerA extends AbstractManager implements BusinessLogicManagerAInterface {

    
    public BusinessLogicManagerA() {
        // DO NOT REMOVE THIS, IT HAS EVENTBUS LOGIC.
        super();
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
        // TODO Auto-generated method stub

    }

    @Override
    public void onSystemEventMediaUnmounted() {
        // TODO Auto-generated method stub

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
