package android.academy.skeleton.services;

import android.academy.skeleton.managers.interfaces.BusinessLogicManagerAInterface;
import android.academy.skeleton.managers.interfaces.BusinessLogicManagerBInterface;
import android.academy.skeleton.services.interfaces.GenericServiceInterface;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class GenericService extends AbstractService implements
		GenericServiceInterface {

	/**
	 * Defines if this service is sticky or not
	 */
	private static final boolean mSticky = true;

	/**
	 * Binder given to managers which serves as an interface to access the
	 * service
	 */
	private IBinder mBinder;

	/**
	 * This instance can be null (if app gets killed). If so, invoke
	 * ApplicationSingleton.getBusinessLogicManagerA to create manager and it
	 * will rebind and set a new instance here
	 */
	private BusinessLogicManagerAInterface mBusinessLogicManagerA;

	/**
	 * This instance can be null (if app gets killed). If so, invoke
	 * ApplicationSingleton.BusinessLogicManagerB to create manager and it will
	 * rebind and set a new instance here
	 */
	private BusinessLogicManagerBInterface mBusinessLogicManagerB;

	/**
	 * The implementation of the FileSystemObserver
	 */
	// private FileSystemObserver mFileSystemObserver = null;

	/**
	 * @param isSticky
	 */
	public GenericService() {
		super(mSticky);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vodafone.backupplus.services.AbstractService#onCreate()
	 */
	@Override
	public void onCreate() {
		isServiceRunning = true;

		mBinder = new GenericServiceBinder();

		super.onCreate();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vodafone.backupplus.services.AbstractService#onDestroy()
	 */
	@Override
	public void onDestroy() {
		isServiceRunning = false;
		super.onDestroy();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vodafone.backupplus.services.AbstractService#restoreServiceState()
	 */
	@Override
	public void restoreServiceState() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Service#onBind(android.content.Intent)
	 */
	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Service#onUnbind(android.content.Intent)
	 */
	@Override
	public boolean onUnbind(Intent intent) {
		return super.onUnbind(intent);
	}

	public void registerManager(BusinessLogicManagerAInterface manager) {
		this.mBusinessLogicManagerA = manager;
	}

	public void registerManager(BusinessLogicManagerBInterface manager) {
		this.mBusinessLogicManagerB = manager;
	}

	public boolean doAlotOfStuff() {
		// Do stuff here.
		return false;
	}

	/*
	 * This is the translator between the Managers and the Services. It is used
	 * to translate the data of the Managers to the data of the Services.
	 * 
	 * It should have no implementation, just receive the call, translate the
	 * objects if needed and call the methods on the service
	 */
	public class GenericServiceBinder extends Binder implements
			GenericServiceInterface {

		@Override
		public void registerManager(BusinessLogicManagerAInterface manager) {
			GenericService.this.registerManager(manager);
		}

		@Override
		public void registerManager(BusinessLogicManagerBInterface manager) {
			GenericService.this.registerManager(manager);

		}

		@Override
		public boolean doAlotOfStuff() {
			return GenericService.this.doAlotOfStuff();
		}
	}

}
