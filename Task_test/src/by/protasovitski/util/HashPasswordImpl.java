package by.protasovitski.util;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Named
@ApplicationScoped
public class HashPasswordImpl implements HashPassword{

    @Override
    public  byte[] getHash(String passStr){
        MessageDigest digest=null;
        byte[] hash= null;
        try {
            digest= MessageDigest.getInstance("MD5");
            digest.reset();
            hash=digest.digest(passStr.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return hash;
    }
}
