package android.academy.skeleton.utils.factories;

import android.academy.skeleton.utils.Logger;
import android.academy.skeleton.utils.interfaces.LoggerInterface;

public class LoggerFactory {
    public enum TYPE {
        PROD, MOCKUP
    }

    public static LoggerInterface getInstance(TYPE type) {
        LoggerInterface instance = null;

        switch (type) {
        case PROD:
            instance = new Logger();
            break;

        default:
            instance = new Logger();
            break;
        }

        return instance;
    }
}
