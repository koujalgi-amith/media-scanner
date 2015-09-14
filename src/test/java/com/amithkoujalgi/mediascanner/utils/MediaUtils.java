package com.amithkoujalgi.mediascanner.utils;

import java.io.File;
import com.amithkoujalgi.mediascanner.core.MediaType;

public class MediaUtils {

    public static MediaType getMediaType( String filePath )
    {
        String fileExtension = getFileExtension(filePath);
        String[] audioExtensionTypes = new String[] { "mp3", "m4a", "ogg", "wma", "wav", "mid" };
        String[] videoExtensionTypes = new String[] { "mp4", "mkv", "avi", "wmv", "flv", "m4v" };

        if( CollectionUtils.belongsTo(audioExtensionTypes, fileExtension) )
        {
            return MediaType.AUDIO;
        }
        else if( CollectionUtils.belongsTo(videoExtensionTypes, fileExtension) )
        {
            return MediaType.VIDEO;
        }
        else
        {
            return MediaType.UNKNOWN;
        }
    }

    public static String getFileExtension( String filePath )
    {
        if( !filePath.contains(".") )
        {
            return "";
        }
        String ext = filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length());
        return ext;
    }

    public static boolean isFileToBeIgnored( String filePath )
    {
        if( new File(filePath).getName().startsWith(".") )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
