package com.iuh.test;

import com.iuh.singleton.EagerInitializedSingleton;
import com.iuh.singleton.EnumSingleton;

import java.lang.reflect.Constructor;


public class ReflectionSingletonTest {
    public static void main(String[] args) {
//      EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();
//      EagerInitializedSingleton instanceTwo = null;  //phá vỡ singleton

        EnumSingleton instanceOne = EnumSingleton.INSTANCE;
        EnumSingleton instanceTwo = null;

        try {
//          Constructor[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
            Constructor[] constructors = EnumSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
//              instanceTwo = (EagerInitializedSingleton) constructor.newInstance();
                instanceTwo = (EnumSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//      System.out.println(instanceOne.hashCode());
//      System.out.println(instanceTwo.hashCode());

        System.out.println("instanceOne hashCode = " + instanceOne.hashCode());
        System.out.println("instanceTwo hashCode = " + (instanceTwo != null ? instanceTwo.hashCode() : "null"));
    }
 }
