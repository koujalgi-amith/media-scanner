package com.amithkoujalgi.mediascanner.core;

import java.io.File;
import java.io.FileNotFoundException;
import com.amithkoujalgi.mediascanner.utils.MediaUtils;

public class MediaFileOrganiser {

    public String organise( String filePath ) throws Exception
    {
        if( MediaUtils.isFileToBeIgnored(filePath) )
        {
            throw new Exception(new File(filePath).getName() + " is going to be ignored.");
        }
        MediaType t = MediaUtils.getMediaType(filePath);
        if( !t.equals(MediaType.VIDEO) )
        {
            return filePath;
        }
        // TODO - add checks for movies. If movies, organize; If general videos,
        // do nothing.
        File file = new File(filePath);
        String target = "";
        if( !file.exists() )
        {
            throw new FileNotFoundException();
        }
        else
        {
            if( !file.getName().contains(file.getParentFile().getName()) )
            {
                String extensionStrippedFileName = filePath.substring(0,
                        (filePath.length() - 1) - MediaUtils.getFileExtension(filePath).length());
                File f = new File(extensionStrippedFileName);
                f.mkdirs();
                System.out.println("Created dirs: " + f.getAbsolutePath());
                target = f + file.separator + file.getName();
                file.renameTo(new File(target));
                System.out.println("Moved file '" + file.getName() + "' to " + extensionStrippedFileName);
                return target;
            }
            else
            {
                // already organised
                return filePath;
            }
        }
    }
}