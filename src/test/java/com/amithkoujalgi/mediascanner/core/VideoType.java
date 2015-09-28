package com.amithkoujalgi.mediascanner.core;

public enum VideoType {
    MOVIE("movie"), SONG("song"), DOCUMENTARY("documentary"), UNKNOWN("unknown");

    private String type = "";

    private VideoType( String type )
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return type;
    }

    public boolean equals( VideoType mtype )
    {
        return mtype.toString().equals(type);
    }
}