package com.amithkoujalgi.mediascanner.main;

import java.io.File;
import com.amithkoujalgi.mediascanner.core.MediaFileOrganiser;
import com.amithkoujalgi.mediascanner.core.MediaMetadata;
import com.amithkoujalgi.mediascanner.core.MediaMetadataExtractor;
import com.amithkoujalgi.mediascanner.utils.FileUtils;
import com.amithkoujalgi.mediascanner.utils.JSONUtils;

public class Main {

    public static void main( String[] args ) throws Exception
    {
        // String filePath =
        // "/Users/amith/Desktop/HDD/Movies/Kingsman.The.Secret.Service.2014.HC.HDRip.XViD.AC3-ETRG/Kingsman.The.Secret.Service.2014.HC.HDRip.XViD.AC3-ETRG.avi";
        // MediaMetadataExtractor e = new MediaMetadataExtractor(filePath);
        // MediaMetadata md = e.extract();
        // JSONUtils.printJson(md);

        String directory = "/Users/amith/Desktop/HDD/Movies/";
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
            MediaMetadataExtractor e = new MediaMetadataExtractor(filePathOrg);
            MediaMetadata md = e.extract();
            JSONUtils.printJson(md);
        }
    }
}
