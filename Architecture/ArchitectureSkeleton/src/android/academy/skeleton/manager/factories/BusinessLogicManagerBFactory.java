package android.academy.skeleton.manager.factories;

import android.academy.skeleton.managers.BusinessLogicManagerB;
import android.academy.skeleton.managers.interfaces.BusinessLogicManagerBInterface;

public class BusinessLogicManagerBFactory {

    public enum TYPE {
        PROD, MOCKUP
    }

    public static BusinessLogicManagerBInterface getInstance(BusinessLogicManagerBFactory.TYPE type) {
        BusinessLogicManagerBInterface instance = null;

        switch (type) {
        case PROD:
            instance = new BusinessLogicManagerB();
            break;

        default:
            instance = new BusinessLogicManagerB();
            break;
        }

        return instance;
    }
}
