package com.amithkoujalgi.mediascanner.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

@SuppressWarnings( "deprecation" )
public class WebUtils {

    public static String getContent( String url ) throws IOException
    {
        System.out.println("URL: " + url);
        @SuppressWarnings( { "resource" } )
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url.trim());
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String content = "";
        String line = "";
        while( (line = rd.readLine()) != null )
        {
            content += line;
        }
        return content;
    }

    public static void downloadContent( String u, String targetFilePath ) throws IOException
    {
        System.out.println("Download URL: " + u);
        URL url = new URL(u);
        InputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while( -1 != (n = in.read(buf)) )
        {
            out.write(buf, 0, n);
        }
        out.close();
        in.close();
        byte[] response = out.toByteArray();
        File f = new File(targetFilePath);
        if( !f.getParentFile().exists() )
        {
            f.getParentFile().mkdirs();
        }
        FileOutputStream fos = new FileOutputStream(targetFilePath);
        fos.write(response);
        fos.close();
        System.out.println("Saved file: " + targetFilePath);
    }
}
