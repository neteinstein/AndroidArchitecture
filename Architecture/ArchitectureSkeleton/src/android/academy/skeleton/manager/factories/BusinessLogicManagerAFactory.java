package android.academy.skeleton.manager.factories;

import android.academy.skeleton.managers.BusinessLogicManagerA;
import android.academy.skeleton.managers.interfaces.BusinessLogicManagerAInterface;


public class BusinessLogicManagerAFactory {

    public enum TYPE {
        PROD, MOCKUP
    }

    public static BusinessLogicManagerAInterface getInstance(TYPE type) {
    	BusinessLogicManagerAInterface instance = null;

        switch (type) {
        case PROD:
            instance = new BusinessLogicManagerA();
            break;

        default:
            instance = new BusinessLogicManagerA();
            break;
        }

        return instance;
    }

}
