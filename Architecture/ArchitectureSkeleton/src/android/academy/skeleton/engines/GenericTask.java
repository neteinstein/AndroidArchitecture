package android.academy.skeleton.engines;

import android.academy.skeleton.app.ApplicationSingleton;
import android.academy.skeleton.engines.interfaces.GenericEngineInterface;
import android.academy.skeleton.utils.interfaces.LoggerInterface;

public final class GenericTask implements Runnable {
    GenericEngineInterface genericEngine;
    private Object object;
    private String key;

    public GenericTask(GenericEngineInterface uploadEngine, Object object) {
        this.object = object;
        // TODO Create a method to define a key in a better way. Maybe because of the Object type.
        this.key = String.valueOf(object.hashCode());
        this.genericEngine = uploadEngine;
    }

    @Override
    public void run() {
    	genericEngine.runTask(object, key);


        ApplicationSingleton app = ApplicationSingleton.getInstance();
        app.getLogger().log(GenericEngine.class, LoggerInterface.TYPE.DEBUG, "#Tasks:[" + genericEngine.getQueueSize() + "]");
    }

    public String getKey() {
        return key;
    }
}
