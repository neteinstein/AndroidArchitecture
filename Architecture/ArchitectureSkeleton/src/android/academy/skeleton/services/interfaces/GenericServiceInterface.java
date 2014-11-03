package android.academy.skeleton.services.interfaces;

import android.academy.skeleton.managers.interfaces.BusinessLogicManagerAInterface;
import android.academy.skeleton.managers.interfaces.BusinessLogicManagerBInterface;

/**
 * This is an interface to be implemented by both the GeenericService and GenericServiceBinder
 * 
 */
public interface GenericServiceInterface {

    public void registerManager(BusinessLogicManagerAInterface manager);

    public void registerManager(BusinessLogicManagerBInterface manager);

    // TODO Add methods here
    
    public boolean doAlotOfStuff();
}
