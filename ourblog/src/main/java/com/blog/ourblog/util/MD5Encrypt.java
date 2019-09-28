package com.blog.ourblog.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Encrypt {
    final static String algorithmName = "MD5";
    final static int hashIterations = 1024;
    public static Object encrypt( String username,Object password){
        ByteSource credentialaSalt = ByteSource.Util.bytes(username);

        return new SimpleHash(algorithmName,password,credentialaSalt,hashIterations);
    }


}
