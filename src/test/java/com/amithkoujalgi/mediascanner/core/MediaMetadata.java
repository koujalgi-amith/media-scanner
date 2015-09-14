package com.amithkoujalgi.mediascanner.core;

import java.io.Serializable;

public class MediaMetadata implements Serializable {

    private static final long serialVersionUID = 1L;
    private MediaType mediaType;
    private VideoInfo videoInfo = new VideoInfo();
    private AudioInfo audioInfo = new AudioInfo();
    private Platform platform = new Platform();
    private String filepath;
    private String fileName;
    private String extension;
    private String encoding;
    private double sizeInBytes;
    private String fileSizeReadable;
    private long metadataCreatedOn;

    public String getFileSizeReadable()
    {
        return fileSizeReadable;
    }

    public void setFileSizeReadable( String fileSizeReadable )
    {
        this.fileSizeReadable = fileSizeReadable;
    }

    public VideoInfo getVideoInfo()
    {
        return videoInfo;
    }

    public void setVideoInfo( VideoInfo videoInfo )
    {
        this.videoInfo = videoInfo;
    }

    public AudioInfo getAudioInfo()
    {
        return audioInfo;
    }

    public void setAudioInfo( AudioInfo audioInfo )
    {
        this.audioInfo = audioInfo;
    }

    public long getMetadataCreatedOn()
    {
        return metadataCreatedOn;
    }

    public void setMetadataCreatedOn( long metadataCreatedOn )
    {
        this.metadataCreatedOn = metadataCreatedOn;
    }

    public MediaType getMediaType()
    {
        return mediaType;
    }

    public void setMediaType( MediaType mediaType )
    {
        this.mediaType = mediaType;
    }

    public String getFilepath()
    {
        return filepath;
    }

    public Platform getPlatform()
    {
        return platform;
    }

    public void setPlatform( Platform platform )
    {
        this.platform = platform;
    }

    public void setFilepath( String filepath )
    {
        this.filepath = filepath;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName( String fileName )
    {
        this.fileName = fileName;
    }

    public String getExtension()
    {
        return extension;
    }

    public void setExtension( String extension )
    {
        this.extension = extension;
    }

    public String getEncoding()
    {
        return encoding;
    }

    public void setEncoding( String encoding )
    {
        this.encoding = encoding;
    }

    public double getSizeInBytes()
    {
        return sizeInBytes;
    }

    public void setSizeInBytes( double sizeInBytes )
    {
        this.sizeInBytes = sizeInBytes;
    }
}