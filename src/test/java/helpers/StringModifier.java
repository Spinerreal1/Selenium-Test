package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringModifer {
    public static String getUniqueString(String str){
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }
}
