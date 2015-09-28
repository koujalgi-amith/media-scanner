package com.amithkoujalgi.mediascanner.utils;

public class CollectionUtils {

    public static boolean belongsTo( String[] elements, String testString )
    {
        for( String s : elements )
        {
            if( testString.equalsIgnoreCase(s) )
            {
                return true;
            }
        }
        return false;
    }
}
