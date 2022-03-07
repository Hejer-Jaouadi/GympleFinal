/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

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
    
}
