package quanLyBanAoNam.Validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    public static boolean isNumber(String x){
        try {
            Double m = Double.parseDouble(x);
            if(m > 0){
                return(true);
            }
            else{
                return(false);
            }
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
    
    public static boolean isYear(String year){
        String regex = "\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(year);
        if(matcher.find()){
            return(true);
        }
        else{
            return(false);
        }
    }

    public static boolean ngayLe(String ngay){
        String[] txt = ngay.split("-");
        if((txt[0] + "-" + txt[1]).equals("20-11")){
            return(true);
        }
        else if((txt[0] + "-" + txt[1]).equals("11-11")){
            return(true);
        }
        else if((txt[0] + "-" + txt[1]).equals("21-11")){
            return(true);
        }
        else if((txt[0] + "-" + txt[1]).equals("20-10")){
            return(true);
        }
        else if((txt[0] + "-" + txt[1]).equals("1-1")){
            return(true);
        }
        else if((txt[0] + "-" + txt[1]).equals("30-11")){    //cô có test phần giảm giá cô sửa ngày thành ngày hôm nay giúp tụi iem nhaa cô
            return(true);                                            // thank iu so muchh <333
        }
        return(false);
    }
}
