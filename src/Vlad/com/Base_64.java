package Vlad.com;

import java.util.Base64;

public class Base_64 {
    public void Base64(){}

    protected String codeToBase64(String code){
        String coded = Base64.getEncoder().encodeToString(code.getBytes());
        return coded;
    }
    protected String encodeFromBase64(String code){
        byte[] actualByte= Base64.getDecoder().decode(code);
        return new String(actualByte);
    }
}