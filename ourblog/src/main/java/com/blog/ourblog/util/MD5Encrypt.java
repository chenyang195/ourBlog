package com.blog.ourblog.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Encrypt {
    final static String algorithmName = "MD5";
    final static int hashIterations = 1024;
    public static Object encrypt( String username,Object password){
        ByteSource credentialaSalt = ByteSource.Util.bytes(username);

        return new SimpleHash(algorithmName,password,credentialaSalt,hashIterations);
    }

    public static String getMd5(MultipartFile file) {

        try {
            byte[] uploadBytes = file.getBytes();
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(uploadBytes);
            String hashString = new BigInteger(1, digest).toString(16);
            return hashString;
        } catch (Exception e) {

        }
        return null;

    }



}
