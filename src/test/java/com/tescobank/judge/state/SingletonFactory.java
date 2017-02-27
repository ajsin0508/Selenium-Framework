package com.tescobank.judge.state;

import com.tescobank.tests.tbcukesupport.Hooks;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.util.HashMap;

/**
 * Created by pabloarroyo on 17/07/16.
 */
public class SingletonFactory {
    private static HashMap<Class, Object> instances = new HashMap<>();

    public static void reset() throws Throwable {
        instances.clear();
    }

    public static Object getOrCreate(Class clazz) {
        if (!instances.containsKey(clazz)) {
            try {
                Constructor<?> ctor = clazz.getConstructor();
                Object object = ctor.newInstance();
                instances.put(clazz, object);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instances.get(clazz);
    }

    public static Object getOrCreateWithWebDriver(Class clazz) {
        if (!instances.containsKey(clazz)) {
            try {
                Constructor<?> ctor = clazz.getConstructor(WebDriver.class);
                Object object = ctor.newInstance(new Object[]{Hooks.getDriver()});
                instances.put(clazz, object);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instances.get(clazz);
    }
}
