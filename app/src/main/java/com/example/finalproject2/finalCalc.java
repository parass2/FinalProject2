package com.example.finalproject2;

public class finalCalc {

    public static boolean value = false;
    //Display value being the string shown when buttons are pressed
    public static boolean finalResult(String displayValue) {
        int result = 0;
        //BASIC OP ONLY CHECK
        //String modifiedString = displayValue.replace("-", "+-");
         String[] toChar = displayValue.split(" ");
        //char equationArray[] = toChar.toCharArray();
//        if (!displayValue.contains("/") && !displayValue.contains("*")) {
//            for (int i = 0; i < equationArray.length; i++) {
//                int intArray[] = new int[0];
//                intArray[i] = Integer.parseInt(equationArray[i]);
//                result = result + intArray[i];
//            }
//        }
        int firstVal = Integer.parseInt(toChar[0]);
        result = firstVal;
        for (int j = 1; j < toChar.length; j = j + 2) {
            int toOperate = Integer.parseInt(toChar[j + 1]);
            switch (toChar[j]) {
                case "-" :
                    result = result - toOperate;
                    break;
                case "+" :
                    result = result + toOperate;
                    break;
                case "/" :
                    result = result / toOperate;
                    break;
                case "x" :
                    result = result * toOperate;
                    break;
            }
        }
        if (result == 24) {
            value = true;
            result = 0;
            return value;
        } else {
            value = false;
            result = 0;
            return value;
        }
    }
    // Multiplication
    //Division
    //Addition
    //Subtraction
}
