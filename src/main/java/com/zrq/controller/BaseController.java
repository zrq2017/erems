package com.zrq.controller;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.util.Map;

/**
 * Created by zrq on 2018-5-2.
 */
public class BaseController {
    //默认路径
    @Value("${server.servlet.path}")
    protected String path;
    @Value("${image.path}")
    protected String filePath;
    @Value("${admission.path}")
    protected String admissionPath;
    @Value("${admission.per}")
    protected String admissionPer;

    /**
     * 创建导出准考证文件
     * @param tmpFile 模板文件来源
     * @param contentMap 模板文件数据
     * @param exportFile 导出文件
     * @throws Exception
     */
//    protected void build(File tmpFile, Map<String, String> contentMap, String exportFile) throws Exception {
//        FileInputStream tempFileInputStream = new FileInputStream(tmpFile);
//        HWPFDocument document = new HWPFDocument(tempFileInputStream);
//        // 读取文本内容
//        Range bodyRange = document.getRange();
//        System.out.println("getBuild-->"  );
//        // 替换内容
//        for (Map.Entry<String, String> entry : contentMap.entrySet()) {
//            bodyRange.replaceText("${" + entry.getKey() + "}", entry.getValue());
//        }
//        System.out.println("getBuild-->"  );
//        //导出到文件
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        document.write(byteArrayOutputStream);
//        OutputStream outputStream = new FileOutputStream(exportFile);
//        outputStream.write(byteArrayOutputStream.toByteArray());
//        outputStream.close();
//    }
}
