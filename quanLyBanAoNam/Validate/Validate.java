package quanLyBanAoNam.Validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    public static boolean isNumber(String x){
        try {
            Double m = Double.parseDouble(x);
            return(true);
        } catch (Exception e) {
            return(false);
        }
    }

    public static boolean isSize(String size){
        if(size.equals("S") ||size.equals("M") ||size.equals("L") ||
        size.equals("XL") ||size.equals("XXL")){
            return(true);
        }
        else{
            return(false);
        }
    }

    public static boolean isPhoneNumber(String pN){
        String regex = "\\d{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pN);
        if(matcher.find()){
            return(true);
        }
        else{
            return(false);
        }
    }

    public static boolean isEmail(String email){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.find()){
            return(true);
        }
        else{
            return(false);
        }
    }
    
    public static boolean isNam(String year){
        String regex = "\\\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(year);
        if(matcher.find()){
            return(true);
        }
        else{
            return(false);
        }
    }

    public static boolean isQuy(String quy){
        if(quy.equals("1") || quy.equals("2") ||quy.equals("3") ||quy.equals("4")){
            return(true);
        }
        return(false);
    }

    public static boolean isThang(String Thang){
        if(Thang.equals("1") || Thang.equals("2") || Thang.equals("3") || 
        Thang.equals("4") || Thang.equals("5") || Thang.equals("6") || 
        Thang.equals("7") || Thang.equals("8") || Thang.equals("9") || 
        Thang.equals("10") || Thang.equals("11") || Thang.equals("12")){
            return(true);
        }
        return(false);
    }
}
