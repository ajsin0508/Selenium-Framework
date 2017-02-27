package com.tescobank.judge.state;

/**
 * Created by pabloarroyo on 17/07/16.
 */
public class Actor {

    public static void reset() throws Throwable {
        SharedState.reset();
        SingletonFactory.reset();
    }

    public static void startWith(String userName) throws Exception {
        PersonaDB.appendPersonaState(userName);
    }

    public static String getString(StateKey key) {
        String result = (String) SharedState.get(key);
        return result==null?"not defined":result;
    }

    public static Object get(StateKey key) {
        return SharedState.get(key);
    }
}
