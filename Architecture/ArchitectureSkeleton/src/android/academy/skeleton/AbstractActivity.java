package android.academy.skeleton;

import java.util.ArrayList;
import java.util.List;

import android.academy.skeleton.app.ApplicationSingleton;
import android.academy.skeleton.fragments.interfaces.FragmentInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import de.greenrobot.event.EventBus;

/**
 * All activities should extend from AbstractActivity.
 * 
 */
public abstract class AbstractActivity extends ActionBarActivity {

    /**
     * This is an instance for Application. It can be used by all Activities.
     */
    protected ApplicationSingleton app;

    /**
     * This is an instance for EventBus. It can be used by all Activities.
     */
    protected EventBus eventBus;

    /**
     * Reference for all the child fragments
     */
    private List<FragmentInterface> mChildFragments = new ArrayList<FragmentInterface>();

    private static boolean mAppInForeground = false;

    /*
     * (non-Javadoc)
     * 
     * @see android.support.v7.app.ActionBarActivity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize App and EventBus
        this.app = ApplicationSingleton.getInstance();
        this.eventBus = app.getEventBus();

        eventBus.register(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.support.v4.app.FragmentActivity#onResume()
     */
    @Override
    protected void onResume() {
        super.onResume();

        mAppInForeground = true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.support.v4.app.FragmentActivity#onPause()
     */
    @Override
    protected void onPause() {
        super.onPause();

        mAppInForeground = false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.support.v4.app.FragmentActivity#onDestroy()
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();

        eventBus.unregister(this);
    }

    public static boolean getIsAppInForeground() {
        return mAppInForeground;
    }

    public void registerFragmentChild(FragmentInterface fragment) {
        mChildFragments.add(fragment);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.vodafone.ubi.activities.ControllerInterface#unregisterActionTaker()
     */
    public void unregisterFragmentChild(FragmentInterface fragment) {
        mChildFragments.remove(fragment);
    }

    public ApplicationSingleton getApp() {
        return app;
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public List<FragmentInterface> getChildFragments() {
        return mChildFragments;
    }
}
