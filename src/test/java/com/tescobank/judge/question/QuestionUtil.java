package com.tescobank.judge.question;

/**
 * Created by pabloarroyo on 06/12/2016.
 */
public class QuestionUtil {
    public static String formatCurrency(String amount) {
        if (amount==null || amount.isEmpty()) return amount;
        String pounds, pence;
        if (amount.indexOf('.') >= 0) {
            String[] parts = amount.split("\\.");
            pounds = parts[0];
            pence = parts[1].length() == 1 ? parts[1] + "0" : parts[1].substring(0,2);
        } else {
            pounds = amount;
            pence = "00";
        }

        // DRY: Just pre-calculating positions
        int billion = pounds.length() - 9;
        int million = pounds.length() - 6;
        int thousands = pounds.length() - 3;

        if (pounds.length() > 9) {
            return "£" + pounds.substring(0, billion) + "," + pounds.substring(billion, million) + "," + pounds.substring(million, thousands) + "," + pounds.substring(thousands) + "." + pence;
        } else if (pounds.length() > 6) {
            return "£" + pounds.substring(0, million) + "," + pounds.substring(million, thousands) + "," + pounds.substring(thousands) + "." + pence;
        } else if (pounds.length() > 3) {
            return "£" + pounds.substring(0, thousands) + "," + pounds.substring(thousands);
        }
        return "£" + pounds + "." + pence;
    }
}
