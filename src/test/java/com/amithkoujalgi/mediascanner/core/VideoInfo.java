package com.amithkoujalgi.mediascanner.core;

public class VideoInfo {

    private String readableName, subtitle;
    private VideoType videoType;
    private int width, height, fps, resolution, duration;
    private MovieInfo movieInfo = new MovieInfo();

    public MovieInfo getMovieInfo()
    {
        return movieInfo;
    }

    public void setMovieInfo( MovieInfo movieInfo )
    {
        this.movieInfo = movieInfo;
    }

    public String getReadableName()
    {
        return readableName;
    }

    public void setReadableName( String readableName )
    {
        this.readableName = readableName;
    }

    public String getSubtitle()
    {
        return subtitle;
    }

    public void setSubtitle( String subtitle )
    {
        this.subtitle = subtitle;
    }

    public VideoType getVideoType()
    {
        return videoType;
    }

    public void setVideoType( VideoType videoType )
    {
        this.videoType = videoType;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth( int width )
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight( int height )
    {
        this.height = height;
    }

    public int getFps()
    {
        return fps;
    }

    public void setFps( int fps )
    {
        this.fps = fps;
    }

    public int getResolution()
    {
        return resolution;
    }

    public void setResolution( int resolution )
    {
        this.resolution = resolution;
    }

    public int getDuration()
    {
        return duration;
    }

    public void setDuration( int duration )
    {
        this.duration = duration;
    }
}
