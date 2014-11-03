package android.academy.skeleton.engines.interfaces;

import java.util.concurrent.ThreadPoolExecutor;

import android.academy.skeleton.engines.GenericTask;

public interface GenericEngineInterface {

    public ThreadPoolExecutor getExecutor();

    public void addToQueue(GenericTask task);

    public void runTask(Object object, String key);
    
    public int getQueueSize();
}
