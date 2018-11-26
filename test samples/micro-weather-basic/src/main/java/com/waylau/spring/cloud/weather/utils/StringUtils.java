package com.waylau.spring.cloud.weather.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

public class StringUtils {
	/**
     * 处理 Gizp 压缩的数据.
     * 
     * @param str
     * @return
     * @throws IOException
     */
    public static String conventFromGzip(String str) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in;
        GZIPInputStream gunzip = null;

        in = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
        gunzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n;
        while ((n = gunzip.read(buffer)) >= 0) {
            out.write(buffer, 0, n);
        }

        return out.toString();
    }
}
