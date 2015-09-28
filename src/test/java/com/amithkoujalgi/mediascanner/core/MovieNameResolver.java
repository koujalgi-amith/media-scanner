package com.amithkoujalgi.mediascanner.core;

import java.io.IOException;
import java.net.URLEncoder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MovieNameResolver {

    public String resolve( String name ) throws IOException
    {
        String movieName = opensubtitlesLookup(name);
        return movieName;
    }

    private String opensubtitlesLookup( String name ) throws IOException
    {
        String mediaNameResolveURL = "http://www.opensubtitles.org/en/search/sublanguageid-all/tag-"
                + URLEncoder.encode(name);
        System.out.println("Resolving movie name: " + mediaNameResolveURL);
        Document doc = Jsoup.connect(mediaNameResolveURL).get();
        Elements readableName = doc.select("tbody > .even > .sb_star_even > strong > a");
        String movieName = "";
        if( readableName.html().contains("\n") )
        {
            movieName = readableName.html().split("\n")[0];
        }
        System.out.println("Resolved movie name: " + movieName);
        return movieName;
    }
}
