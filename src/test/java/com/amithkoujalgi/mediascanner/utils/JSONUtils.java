package com.amithkoujalgi.mediascanner.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONUtils {

    public static String toJson( Object o )
    {
        return new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create().toJson(o);
    }

    public static void printJson( Object o )
    {
        System.out.println(toJson(o));
    }

    public static Object fromJson( String result, Class<?> clazz )
    {
        return new Gson().fromJson(result, clazz);
    }
}
