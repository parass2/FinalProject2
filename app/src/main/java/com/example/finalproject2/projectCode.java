package com.example.finalproject2;

import android.os.Environment;
import android.util.Log;

import jxl.*;
import jxl.read.biff.BiffException;
import java.util.Random;
import java.io.File;
import java.io.IOException;
//import java.util.Date;

public class projectCode {
    public static String singleCellValue = "";
    public static String card1Val;
    public static String card2Val;
    public static String card3Val;
    public static String card4Val;

    public static String getVal1() {
        //readFile();
        return card1Val;
    }
    public static String getVal2() {
        return card2Val;
    }
    public static String getVal3() {
        return card3Val;
    }
    public static String getVal4() { return card4Val; }
    public static void readFile() {
        Workbook workbook = null;
        try {
            String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Data.xls";
            Log.d("asdf", path);
            workbook = Workbook.getWorkbook(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        Log.d("helloWorld", singleCellValue);
        Random rand = new Random();
        int toPick = rand.nextInt(100);
        Sheet sheet = workbook.getSheet(0);
        Cell toRead = sheet.getCell(0,toPick);
        singleCellValue = toRead.getContents();
        Log.d("derpderdefgdsawsdasadas", singleCellValue);
        //singleCellValue = "1 1 1 8";
        saveToVar(singleCellValue);

        }



    public static void saveToVar(String thingy) {
        String[] value = thingy.split("\\s+");
        int[] newArray = new int[value.length];
        for (int i = 0; i < value.length; i++) {
            newArray[i] = Integer.parseInt(value[i]);
            card1Val = value[0];
            card2Val = value[1];
            card3Val = value[2];
            card4Val = value[3];

        }
    }
}
