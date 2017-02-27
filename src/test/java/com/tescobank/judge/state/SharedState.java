package com.tescobank.judge.state;

import java.util.HashMap;

/**
 * Created by pabloarroyo on 09/07/16.
 */
public class SharedState {
    private static HashMap<StateKey, Object> state;

    private static HashMap<StateKey,Object> getState() {
        if (state==null) state = new HashMap<>();
        return state;
    }

    public static void reset() {
        state = null;
    }

    public static void put(StateKey key, Object value) {
        getState().put(key, value);
    }

    public static Object get(StateKey key) {
        return getState().get(key);
    }
}
