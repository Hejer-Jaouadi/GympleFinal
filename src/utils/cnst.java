/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class cnst {
 
    
public static final Pattern VALID_NAME_REGEX = Pattern.compile("^[A-Z][A-Za-z-]+$", Pattern.CASE_INSENSITIVE);
public static final Pattern VALID_PRIX_REGEX = Pattern.compile("^[0-9]+$", Pattern.CASE_INSENSITIVE);
public static final Pattern VALID_PRIXX_REGEX = Pattern.compile("^[0-9]{2,7}+$", Pattern.CASE_INSENSITIVE);
 

public boolean testfacility(String facility) {

        Matcher matcher = cnst.VALID_NAME_REGEX.matcher(facility);
        return matcher.find();

    }


}
