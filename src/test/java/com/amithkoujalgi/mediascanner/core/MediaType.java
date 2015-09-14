package com.amithkoujalgi.mediascanner.core;

public enum MediaType {
    VIDEO("video"), AUDIO("audio"), UNKNOWN("unknown");

    private String type = "";

    private MediaType( String type )
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return type;
    }

    public boolean equals( MediaType mtype )
    {
        return mtype.toString().equals(type);
    }
}