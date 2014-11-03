package android.academy.skeleton.tasks;

import android.os.AsyncTask;

public class GenericAsyncTask extends AsyncTask<Object, Void, Object>
{

    public interface GenericBackgroundCallback
    {
        public Object doInBackgroundThread(Object[] object);
    }

    public interface GenericForegroundCallback
    {
        public void onPostExecuteOnUiThread(Object result);
    }

    private GenericBackgroundCallback callback1;
    private GenericForegroundCallback callback2;

    public GenericAsyncTask(GenericBackgroundCallback callback1)
    {
        super();
        this.callback1 = callback1;
    }

    public GenericAsyncTask(GenericBackgroundCallback callback1, GenericForegroundCallback callback2)
    {
        super();
        this.callback1 = callback1;
        this.callback2 = callback2;
    }

    @Override
    protected Object doInBackground(Object... objects)
    {
        if (callback1 != null)
        {
            return callback1.doInBackgroundThread(objects);
        }

        return null;
    }

    @Override
    protected void onPostExecute(Object result)
    {
        super.onPostExecute(result);
        if (callback2 != null)
        {
            callback2.onPostExecuteOnUiThread(result);
        }

    }

}
