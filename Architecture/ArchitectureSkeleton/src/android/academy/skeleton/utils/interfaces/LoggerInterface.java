package android.academy.skeleton.utils.interfaces;

/**
 * Due to Java not allowing static methods in interfaces, an "interface like" method is to have a abstract class which
 * works like an interface which is extended by the implementation which "override" their methods.
 * 
 */
public interface LoggerInterface {

    public enum TYPE {
        VERBOSE, WARN, ASSERT, ERROR, DEBUG, INFO;
    }

    public void log(Class<?> clazz, TYPE type, String text);

    public void log(Class<?> clazz, TYPE type, String text, Throwable t);
}
