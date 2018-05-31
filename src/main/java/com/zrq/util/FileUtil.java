package com.zrq.util;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by zrq on 2018-5-30.
 */
public class FileUtil {
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
            System.out.println("-----上传图片目录创建-----");
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
