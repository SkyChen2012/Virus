package com.benson.Tools.XXUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * com.benson.Tools.XXUtils
 * Created by Benson on 2017/11/16-上午9:16.
 */

public class XXTimeUtils {

    public static String getStringDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(date);
    }

    /**
     *
     * @return
     */
    public static String getCurTime()
    {
        Calendar c = Calendar.getInstance();
        String curTime = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH) + " " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
        return formatTime(curTime);
    }

    public static String formatTime(String time)
    {
        String returnTime = "";
        String[] first = time.split(" ");
        String[] hour = first[1].split(":");
        String[] years = first[0].split("-");

        for (String s : years)
        {
            if (Integer.parseInt(s) < 10)
            {
                if (s.equals("00"))
                {
                    returnTime += s + "-";
                }
                else if (Integer.parseInt(s) == 0)
                {
                    returnTime += "0" + s + "-";
                }
                else if (s.contains("0"))
                {
                    returnTime += s + "-";
                }
                else
                {
                    returnTime += "0" + s + "-";
                }
            }
            else
            {
                returnTime += s + "-";
            }
        }
        returnTime = returnTime.substring(0, returnTime.length() - 1);
        returnTime = returnTime + " ";
        for (String s : hour)
        {
            if (Integer.parseInt(s) < 10)
            {
                if (s.equals("00"))
                {
                    returnTime += s + ":";
                }
                else if (Integer.parseInt(s) == 0)
                {
                    returnTime += "0" + s + ":";
                }
                else if (s.contains("0"))
                {
                    returnTime += s + ":";
                }
                else
                {
                    returnTime += "0" + s + ":";
                }
            }
            else
            {
                returnTime += s + ":";
            }
        }
        returnTime = returnTime.substring(0, returnTime.length() - 1);
        return returnTime;
    }
}
