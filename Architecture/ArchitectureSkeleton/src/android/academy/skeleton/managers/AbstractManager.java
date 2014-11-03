package android.academy.skeleton.managers;

import android.academy.skeleton.app.ApplicationSingleton;

/**
 * All Managers are stateless so no abstract restore method is needed
 * 
 */
public abstract class AbstractManager {

    public AbstractManager() {

        ApplicationSingleton app = ApplicationSingleton.getInstance();
        app.getEventBus().register(this);
    }
}
