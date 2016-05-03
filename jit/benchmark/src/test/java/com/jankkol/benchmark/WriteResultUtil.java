package com.jankkol.benchmark;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by jan on 03.05.16.
 */
public class WriteResultUtil {

    public static void writeResult(String url, String clazzName, String content) {
        try {
            FileUtils.write(new File(url + "/" + clazzName + new Timestamp(new Date().getTime())), content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
