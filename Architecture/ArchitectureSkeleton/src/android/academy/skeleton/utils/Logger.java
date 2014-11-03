package android.academy.skeleton.utils;

import android.academy.skeleton.utils.interfaces.LoggerInterface;
import android.util.Log;

public class Logger implements LoggerInterface {

    @Override
    public void log(Class<?> clazz, TYPE type, String text) {
        switch (type) {
        case VERBOSE:
            Log.v(clazz.getSimpleName().toString(), text);
            break;
        case WARN:
            Log.w(clazz.getSimpleName().toString(), text);
            break;
        case ASSERT:
            Log.wtf(clazz.getSimpleName().toString(), text);
            break;
        case ERROR:
            Log.e(clazz.getSimpleName().toString(), text);
            break;
        case DEBUG:
            Log.d(clazz.getSimpleName().toString(), text);
            break;
        case INFO:
            Log.i(clazz.getSimpleName().toString(), text);
            break;
        default:
            Log.wtf(clazz.getSimpleName().toString(), text);
            break;
        }
    }

    @Override
    public void log(Class<?> clazz, TYPE type, String text, Throwable t) {
        switch (type) {
        case VERBOSE:
            Log.v(clazz.getSimpleName().toString(), text, t);
            break;
        case WARN:
            Log.w(clazz.getSimpleName().toString(), text, t);
            break;
        case ASSERT:
            Log.wtf(clazz.getSimpleName().toString(), text, t);
            break;
        case ERROR:
            Log.e(clazz.getSimpleName().toString(), text, t);
            break;
        case DEBUG:
            Log.d(clazz.getSimpleName().toString(), text, t);
            break;
        case INFO:
            Log.i(clazz.getSimpleName().toString(), text, t);
            break;
        default:
            Log.wtf(clazz.getSimpleName().toString(), text, t);
            break;
        }
    }

}
