package android.academy.skeleton.factories;

import android.academy.skeleton.connectors.ServerLayerXPTO;
import android.academy.skeleton.interfaces.ServerLayerInterface;

public class ServerLayerFactory {

    public enum TYPE {
        PROD, MOCKUP
    }

    public static ServerLayerInterface getInstance(ServerLayerFactory.TYPE type) {
        ServerLayerInterface instance = null;

        switch (type) {
        case PROD:
            instance = new ServerLayerXPTO();
            break;

        default:
            instance = new ServerLayerXPTO();
            break;
        }

        return instance;
    }

}
