package com.amithkoujalgi.mediascanner.core;

import java.net.URLEncoder;
import com.amithkoujalgi.mediascanner.utils.JSONUtils;
import com.amithkoujalgi.mediascanner.utils.WebUtils;

public class OMDBAPI {

    private static String API_KEY = "8c014227";

    public static MovieInfo getInfo( String title ) throws Exception
    {
        String omdbURL = "http://www.omdbapi.com/?apikey=" + API_KEY + "&t=" + URLEncoder.encode(title);
        System.out.println("Fetching movie info: " + omdbURL);
        String result = WebUtils.getContent(omdbURL);
        if( result.contains("Movie not found") )
        {
            if( title.contains("(") || title.contains(")") )
            {
                title = title.replace("(", "");
                title = title.replace(")", "");
                title = title.replaceAll("\\d{4}", "").trim();
                omdbURL = "http://www.omdbapi.com/?apikey=" + API_KEY + "&t=" + URLEncoder.encode(title);
                System.out.println("Movie info not found. Trying it minimsed. " + omdbURL);
                result = WebUtils.getContent(omdbURL);
                if( result.contains("Movie not found") )
                {
                    throw new Exception("Couldn't get info. Giving up");
                }
            }
        }
        MovieInfo mi = (MovieInfo) JSONUtils.fromJson(result, MovieInfo.class);
        if( mi.getPoster() == null || mi.getPoster().trim().isEmpty() || mi.getPoster().equalsIgnoreCase("n/a") )
        {
            mi.setPoster("");
        }
        return mi;
    }
}
