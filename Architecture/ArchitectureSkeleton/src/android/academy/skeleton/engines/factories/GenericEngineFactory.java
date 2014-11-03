package android.academy.skeleton.engines.factories;

import android.academy.skeleton.engines.GenericEngine;
import android.academy.skeleton.engines.interfaces.GenericEngineInterface;
import android.academy.skeleton.interfaces.ServerLayerInterface;

public class GenericEngineFactory {

    public enum TYPE {
        PROD, MOCKUP
    }

    public static GenericEngineInterface getInstance(GenericEngineFactory.TYPE type, ServerLayerInterface storageLayer) {
        GenericEngineInterface instance = null;

        switch (type) {
        case PROD:
            instance = new GenericEngine(storageLayer);
            break;

        default:
            instance = new GenericEngine(storageLayer);
            break;
        }

        return instance;
    }

}
