package android.academy.skeleton.app;

import java.util.ArrayList;
import java.util.List;

import android.academy.skeleton.bus.events.InitializeManagersEvent;
import android.academy.skeleton.manager.factories.BusinessLogicManagerAFactory;
import android.academy.skeleton.manager.factories.BusinessLogicManagerBFactory;
import android.academy.skeleton.managers.interfaces.BusinessLogicManagerAInterface;
import android.academy.skeleton.managers.interfaces.BusinessLogicManagerBInterface;
import android.academy.skeleton.utils.factories.LoggerFactory;
import android.academy.skeleton.utils.interfaces.LoggerInterface;
import android.app.Application;
import de.greenrobot.event.EventBus;

public class ApplicationSingleton extends Application {

    private static ApplicationSingleton app = null;

    private LoggerInterface logger = null;

    // Application Event Bus: handles communication between Activities and Managers
    private EventBus mEventBus = null;

    private BusinessLogicManagerAInterface mBLManagerA = null;
    private BusinessLogicManagerBInterface mBLManagerB = null;

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;

        logger = LoggerFactory.getInstance(LoggerFactory.TYPE.PROD);

        // This is running on the UI Thread. To avoid delays to get the first Activity avoid adding here
        // initializations,
        // doing them in background instead.

        // First of all initialize BUS to avoid losing event (this will be the only synchronous as is lightweight and to
        // avoid missing events)
        initializeBus();

        // Then initialize managers to be able to handle logic
        initializeManagers();
    }

    /**
     * Method do initialize EventBus
     */
    private void initializeBus() {
        mEventBus = EventBus.getDefault();
        mEventBus.register(this);

    }

    /**
     * Method to create an event to initialize the Managers needed whenever the Application is created.
     */
    private void initializeManagers() {
        List<ManagersEnum> managers = new ArrayList<ManagersEnum>();
        managers.add(ManagersEnum.BusinessLogicManagerA);
        managers.add(ManagersEnum.BusinessLogicManagerB);

        InitializeManagersEvent event = new InitializeManagersEvent(managers);

        mEventBus.post(event);
    }

    @Override
    public void onTerminate() {
        mEventBus.unregister(this);
        super.onTerminate();

        app = null;
    }

    /**
     * Method to initialize the Managers received through EventBus on the background thread. This uses specifically the
     * background thread to lock the EventBus while all the managers are initialized.
     */
    public void onEventBackgroundThread(InitializeManagersEvent event) {
        for (ManagersEnum manager : event.getManagersToInitialize()) {
            switch (manager) {
            case BusinessLogicManagerA:
                getBusinessLogicManagerA();
                break;
            case BusinessLogicManagerB:
                getBusinessLogicManagerB();
                break;
            default:
                // TODO Add log of error: No such manager
                break;
            }
        }
    }

    public static ApplicationSingleton getInstance() {
        return app;
    }

    public LoggerInterface getLogger() {
        return logger;
    }

    /**
     * Singleton style get of the EventBus instance
     */
    public EventBus getEventBus() {
        if (mEventBus == null) {
            mEventBus = EventBus.getDefault();
        }
        return mEventBus;
    }

    /**
     * Singleton style get of BusinessLogicManagerA
     */
    public synchronize BusinessLogicManagerAInterface getBusinessLogicManagerA() {
        if (mBLManagerA == null) {
        	mBLManagerA = BusinessLogicManagerAFactory.getInstance(BusinessLogicManagerAFactory.TYPE.PROD);
        }
        return mBLManagerA;
    }

    /**
     * Singleton style get of BusinessLogicManagerB
     */
    public synchronize BusinessLogicManagerBInterface getBusinessLogicManagerB() {
        if (mBLManagerB == null) {
        	mBLManagerB = BusinessLogicManagerBFactory.getInstance(BusinessLogicManagerBFactory.TYPE.PROD);
        }
        return mBLManagerB;
    }

    

}
