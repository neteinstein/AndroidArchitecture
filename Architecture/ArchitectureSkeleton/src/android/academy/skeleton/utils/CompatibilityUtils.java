package android.academy.skeleton.utils;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;

public class CompatibilityUtils {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    // API 11
    public static void executeOnExecutor(AsyncTask<Object, Void, Object> asyncTask) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        else
            asyncTask.execute();
    }
}
