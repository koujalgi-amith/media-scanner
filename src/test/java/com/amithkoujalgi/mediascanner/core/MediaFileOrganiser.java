package com.amithkoujalgi.mediascanner.core;

import java.io.File;
import java.io.FileNotFoundException;
import com.amithkoujalgi.mediascanner.utils.FileUtils;
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
            String fileName = file.getName();
            String parentDirName = MediaUtils.stripFileExtension(file.getParentFile().getName());
            if( !fileName.equals(parentDirName) )
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
                System.out.println("Already organised");
                return filePath;
            }
        }
    }

    public void organiseDir( String directory )
    {
        System.out.println("Organising " + directory + "...");
        if( FileUtils.listFiles(directory, false).size() == 0 )
        {
            System.out.println("Directory " + directory + " already up to date.");
            return;
        }
        for( File f : FileUtils.listFiles(directory, false) )
        {
            String filePathOrg = "";
            try
            {
                MediaFileOrganiser o = new MediaFileOrganiser();
                filePathOrg = o.organise(f.getAbsolutePath());
            }
            catch( Exception ex )
            {
                if( ex.getMessage().contains("ignored") )
                {
                    continue;
                }
            }
            System.out.println("Organised " + directory + ".");
        }
    }

    public void moveSampleMediaFiles( String directory )
    {
        System.out.println("Listing " + directory + " recursively for sample media files...");
        if( FileUtils.listFiles(directory, false).size() == 0 )
        {
            System.out.println("Nothing found.");
            return;
        }
        File samplesDir = new File(directory + File.separator + "Samples");
        if( !samplesDir.exists() )
        {
            samplesDir.mkdirs();
        }
        for( File f : FileUtils.listFiles(directory, true) )
        {
            if( f.getName().toLowerCase().contains("sample") )
            {
                f.renameTo(new File(samplesDir.getAbsolutePath() + File.separator + f.getName()));
                System.out.println("Moved " + f.getAbsolutePath() + " to Samples.");
            }
        }
    }
}