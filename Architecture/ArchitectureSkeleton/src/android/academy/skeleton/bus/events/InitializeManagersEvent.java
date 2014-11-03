package android.academy.skeleton.bus.events;

import java.util.List;

import android.academy.skeleton.app.ManagersEnum;

public class InitializeManagersEvent {

    List<ManagersEnum> mManagersToInitialize = null;

    public InitializeManagersEvent(List<ManagersEnum> managers) {
        this.mManagersToInitialize = managers;
    }

    public List<ManagersEnum> getManagersToInitialize() {
        return mManagersToInitialize;
    }
}
