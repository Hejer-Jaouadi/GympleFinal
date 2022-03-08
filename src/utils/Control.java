/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Asma
 */
public class Control {
    
   
    public boolean trueString(String s){
         if(s.isEmpty()) return false;
        return s.matches("[a-zA-Z]+");
    }
    public boolean trueEmail(String e){
         if(e.isEmpty()) return false;
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(e);

        if(mat.matches()){

            return true;
        }return false;
    }
    public boolean trueInt(String i){
         if(i.isEmpty()) return false;
          try { 
        Integer.parseInt(i); 
    } catch(NumberFormatException e) { 
        return false; 
    } catch(NullPointerException e) {
        return false;
    }
    // only got here if we didn't return false
    return true;

    }
    public boolean trueFloat(String f){
         if(f.isEmpty()) return false;
          try { 
        Float.parseFloat(f); 
    } catch(NumberFormatException e) { 
        return false; 
    } catch(NullPointerException e) {
        return false;
    }
    // only got here if we didn't return false
    return true;

    }
    public boolean truePassword(String p){
       if(p.isEmpty()) return false;
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
        Matcher mat = pattern.matcher(p);

        if(mat.matches()){

            return true;
        }return false;
    }
    public String getHashPassword(String s){
      String generatedPassword = null;

    try 
    {
      // Create MessageDigest instance for MD5
      MessageDigest md = MessageDigest.getInstance("MD5");

      // Add password bytes to digest
      md.update(s.getBytes());

      // Get the hash's bytes
      byte[] bytes = md.digest();

      // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < bytes.length; i++) {
        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
      }

      // Get complete hashed password in hex format
      generatedPassword = sb.toString();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return generatedPassword;
  }
    
    static String chars = "abcdefghijklmnopqrstuvwxyz";
static String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
static String NUMS = "1234567890";
static String SPEC = "@!*+=";


public static String passwordGenerator() {
    int index;
    String pass = "";
    Random rnd = new Random();

    // 2 random chars from 'chars'
    index = rnd.nextInt(chars.length());
    pass += chars.charAt(index);
    index = rnd.nextInt(chars.length());
    pass += chars.charAt(index);

    // 2 random chars from 'CHARS'
    index = rnd.nextInt(CHARS.length());
    pass += CHARS.charAt(index);
    index = rnd.nextInt(CHARS.length());
    pass += CHARS.charAt(index);

    // 2 random chars from 'NUMS'
    index = rnd.nextInt(NUMS.length());
    pass += NUMS.charAt(index);
    index = rnd.nextInt(NUMS.length());
    pass += NUMS.charAt(index);

    // 2 random chars from 'SPEC'
    index = rnd.nextInt(SPEC.length());
    pass += SPEC.charAt(index);
    index = rnd.nextInt(SPEC.length());
    pass += SPEC.charAt(index);

    return pass;
}
    
}
