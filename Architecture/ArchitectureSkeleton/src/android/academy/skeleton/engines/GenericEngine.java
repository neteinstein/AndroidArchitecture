package android.academy.skeleton.engines;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import android.academy.skeleton.app.ApplicationSingleton;
import android.academy.skeleton.engines.interfaces.GenericEngineInterface;
import android.academy.skeleton.interfaces.ServerLayerInterface;
import android.academy.skeleton.utils.interfaces.LoggerInterface;

public class GenericEngine implements GenericEngineInterface {

    private final int MAX_THREAD = 3;

    private ServerLayerInterface mServerLayer = null;

    private ConcurrentHashMap<String, Future<?>> tasks;

    private ThreadPoolExecutor executor;

    public GenericEngine(ServerLayerInterface storageLayer) {
        this.mServerLayer = storageLayer;

        initializeThreadPool();
    }

    private void initializeThreadPool() {
        this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(MAX_THREAD);

    }

    public void addToQueue(GenericTask task) {
        final Future<?> future = tasks.putIfAbsent(task.getKey(), executor.submit(task));

        ApplicationSingleton app = ApplicationSingleton.getInstance();

        if (future != null) {
            app.getLogger().log(GenericEngine.class, LoggerInterface.TYPE.DEBUG, "Task added...");
        } else {
            app.getLogger().log(GenericEngine.class, LoggerInterface.TYPE.DEBUG, "Task already on queue, not readded");
        }
    }

    public int getQueueSize() {
        return tasks.size();
    }

    public void runTask(Object object, String key) {
        // Remove from queue before processing.
        tasks.remove(key);

        // TODO According to type of object or something like it, decide what method to go to.
        if (object != null) {
        	doStuff();
        } else {
        	doMoreStuff();
        }
    }

    /**
     * 
     */
    private void doStuff() {
    	//Use the serverLayer if needed.
    	mServerLayer.hashCode();
        // TODO Auto-generated method stub

    }

    /**
     * 
     */
    private void doMoreStuff() {
        // TODO Auto-generated method stub

    }

    public ThreadPoolExecutor getExecutor() {
        return executor;
    }
}
