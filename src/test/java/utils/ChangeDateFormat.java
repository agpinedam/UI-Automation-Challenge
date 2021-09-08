package utils;

import org.apache.commons.lang.StringUtils;
import org.jsoup.internal.StringUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//We want change the date format from "Jan 25, 1896" to Sat Jan 25 00:00:00 COT 1896

public class ChangeDateFormat {
    public Date date(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String [] dateParts=date.split(" ");
        String month = dateParts[0];
        String numberMonth = monthToNumber(month);
        String d = StringUtils.removeEnd(dateParts[1],",") +"/"+numberMonth+"/"+dateParts[2];
        return sdf.parse(d);
    }

    private String monthToNumber(String month){
        String numberMonth;
        switch (month){
            case "Jan" :
                numberMonth = "01";
                break;
            case "Feb":
                numberMonth = "02";
                break;
            case "Mar":
                numberMonth = "03";
                break;
            case "Apr":
                numberMonth = "04";
                break;
            case "May":
                numberMonth = "05";
                break;
            case "Jun":
                numberMonth = "06";
                break;
            case "Jul":
                numberMonth = "07";
                break;
            case "Aug":
                numberMonth = "08";
                break;
            case "Sep":
                numberMonth = "09";
                break;
            case "Oct":
                numberMonth = "10";
                break;
            case "Nov":
                numberMonth = "11";
                break;
            case "Dec":
                numberMonth = "12";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + month);
        }
        return numberMonth;
    }
}
