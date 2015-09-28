package com.amithkoujalgi.mediascanner.utils;

public class PlatformUtils {

    public static String getOS()
    {
        return System.getProperty("os.name");
    }

    public static String getOSVersion()
    {
        // System.getProperties().list(System.out);
        return System.getProperty("os.version");
    }

    public static String getUsername()
    {
        return System.getProperty("user.name");
    }
}
