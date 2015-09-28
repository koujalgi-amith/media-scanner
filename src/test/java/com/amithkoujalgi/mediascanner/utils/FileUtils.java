package com.amithkoujalgi.mediascanner.utils;

import java.io.File;
import java.util.ArrayList;

public class FileUtils {

    public static ArrayList<File> listFiles( String directory, boolean recursive )
    {
        Filewalker fw = new Filewalker(recursive);
        fw.walk(directory);
        return fw.getFiles();
    }
}

class Filewalker {

    private boolean recursive = false;
    private ArrayList<File> files = new ArrayList<File>();

    public Filewalker( boolean recursive )
    {
        this.recursive = recursive;
    }

    public ArrayList<File> getFiles()
    {
        return files;
    }

    public void walk( String path )
    {
        File root = new File(path);
        File[] list = root.listFiles();

        if( list == null )
            return;

        for( File f : list )
        {
            if( f.isDirectory() )
            {
                if( recursive )
                {
                    walk(f.getAbsolutePath());
                }
            }
            else
            {
                files.add(f);
            }
        }
    }
}