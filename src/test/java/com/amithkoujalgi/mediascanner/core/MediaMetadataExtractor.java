package com.amithkoujalgi.mediascanner.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import com.amithkoujalgi.mediascanner.utils.MediaUtils;
import com.amithkoujalgi.mediascanner.utils.PlatformUtils;
import com.amithkoujalgi.mediascanner.utils.WebUtils;

public class MediaMetadataExtractor {

    private String filePath;
    private File file;

    public MediaMetadataExtractor( String filePath )
    {
        this.filePath = filePath;
    }

    public MediaMetadata extract() throws Exception
    {
        file = new File(filePath);
        if( !file.exists() )
        {
            throw new FileNotFoundException("Media file '" + filePath + "' not found.");
        }
        if( file.isDirectory() )
        {
            throw new Exception("'" + filePath + "' is a directory.");
        }
        if( MediaUtils.isFileToBeIgnored(filePath) )
        {
            throw new Exception(file.getName() + " is going to be ignored.");
        }
        MediaMetadata m = new MediaMetadata();
        m.setMetadataCreatedOn(new Date().getTime());
        m.setExtension(MediaUtils.getFileExtension(filePath));
        m.setFilepath(filePath);
        m.setFileName(file.getName());
        m.setMediaType(MediaUtils.getMediaType(filePath));
        m.getPlatform().setOs(PlatformUtils.getOS());
        m.getPlatform().setOsVersion(PlatformUtils.getOSVersion());
        m.getPlatform().setUsername(PlatformUtils.getUsername());
        m.setSizeInBytes(getFileSizeBytes());
        m.setFileSizeReadable(getFileSizeReadable());
        if( m.getMediaType().equals(MediaType.AUDIO) )
        {
            m.setVideoInfo(null);
        }
        m.setVideoInfo(getVideoInfo());
        return m;
    }

    public double getFileSizeBytes()
    {
        return file.length();
    }

    public String getFileSizeReadable()
    {
        double filesize = getFileSizeBytes();
        String fileSizeReadable = "bytes";
        while( true )
        {
            if( filesize < 1024 )
            {
                break;
            }
            else
            {
                if( fileSizeReadable.equals("bytes") )
                {
                    fileSizeReadable = "kilobytes";
                }
                else if( fileSizeReadable.equals("kilobytes") )
                {
                    fileSizeReadable = "megabytes";
                }
                else if( fileSizeReadable.equals("megabytes") )
                {
                    fileSizeReadable = "gigabytes";
                }
                filesize = filesize / 1000;
            }
        }
        return filesize + " " + fileSizeReadable;
    }

    public String getEncoding()
    {
        return filePath;
    }

    public String getProperName()
    {
        return filePath;
    }

    public String getFileNameWithoutExtension()
    {
        return file.getName().substring(0, file.getName().lastIndexOf("."));
    }

    public VideoInfo getVideoInfo()
    {
        VideoInfo v = new VideoInfo();
        // remove dots from the file string
        String mediaName = getFileNameWithoutExtension();
        mediaName = mediaName.replace(".", " ");
        MovieNameResolver r = new MovieNameResolver();
        try
        {
            String properName = r.resolve(mediaName);
            v.setReadableName(properName);
            v.setMovieInfo(OMDBAPI.getInfo(properName));
            if( v.getMovieInfo().getPoster() != null && !v.getMovieInfo().getPoster().isEmpty() )
            {
                String coverFileExtension = v.getMovieInfo().getPoster().substring(
                        v.getMovieInfo().getPoster().lastIndexOf("."), v.getMovieInfo().getPoster().length());
                WebUtils.downloadContent(v.getMovieInfo().getPoster(),
                        file.getParent() + File.separator + "cover" + coverFileExtension);
            }
        }
        catch( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return v;
    }

    public AudioInfo getAudioInfo()
    {
        return null;
    }
}