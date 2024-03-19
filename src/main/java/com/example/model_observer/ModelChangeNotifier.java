package com.example.model_observer;

import java.util.ArrayList;
import java.util.List;

public class ModelChangeNotifier {
    
    // the models are responsible for listening to changes made
    private static List<ModelChangeListener> listeners = new ArrayList<>();

    private static ModelChangeNotifier instance;

    private ModelChangeNotifier() {}

    public static ModelChangeNotifier getInstance() {
        if (instance == null) {
            instance = new ModelChangeNotifier();
        }
        return instance;
    }

    public void add(ModelChangeListener listener) {
        listeners.add(listener);
    }

    public void notify(String attributeName, String newValue) {
        for (ModelChangeListener listener : listeners) {
            listener.onModelChange(attributeName, newValue);
        }
    }

    public static<T extends ModelChangeListener> T findListenerByClass(Class<T> listenerClass) {
        int index = listeners.size() - 1;
        while (index >= 0) {
            ModelChangeListener listenerTemp = listeners.get(index);
            if(listenerTemp.getClass().equals(listenerClass)) {
                return listenerClass.cast(listenerTemp);
            }
        }
        return null;
    }
}
