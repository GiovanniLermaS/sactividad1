package simulacion;

import java.util.ArrayList;
import java.util.Scanner;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Logic {

    public static ArrayList<Float> functionTn(String expression, int count, float semilla) {
        ArrayList<Float> array = new ArrayList<>();
        array.add(semilla);
        int initial = 1;
        while (initial < count) {
            array.add(operations(expression, String.valueOf(array.get(initial - 1))));
            initial++;
        }
        return array;
    }

    public static ArrayList<Float> functionGn(String expression, int count, float semilla) {
        ArrayList<Float> array = new ArrayList<>();
        array.add(semilla);
        int initial = 0;
        while (initial < count) {
            array.add(operations(expression, String.valueOf(array.get(initial))));
            initial++;
        }
        return array;
    }

    private static float operations(String expression, String number) {
        String r = "";
        float result = 0;
        ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");
        String numberExpression = expression.replace("x", number).
                replace("cos", "Math.cos").
                replace("sin", "Math.sin").
                replace("tan", "Math.tan").
                replace("sqrt", "Math.sqrt").
                replace("sqr", "Math.pow").
                replace("log", "Math.log");
        try {
            result = Float.parseFloat(engine.eval(numberExpression).toString());
            System.out.println(numberExpression + " = " + result);
            r = numberExpression + " = " + result;
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String midsquare(int number) {
        int mul = number * number;
        String result = "";
        int count = 0, principalNum = mul;
        for (; mul != 0; mul /= 10, ++count) {
        }
        if (count % 2 == 0) {
            int iNumber = count / 2;
            System.out.println("One= " + iNumber);
            String sNumber = String.valueOf(principalNum);
            result = "0."
                    + sNumber.charAt(iNumber - 2)
                    + sNumber.charAt(iNumber - 1)
                    + sNumber.charAt(iNumber)
                    + sNumber.charAt(iNumber + 1);
        } else {
            int iNumber = (1 + count) / 2;
            System.out.println("Two= " + iNumber);
            String sNumber = String.valueOf("0" + principalNum);
            result = "0."
                    + sNumber.charAt(iNumber - 2)
                    + sNumber.charAt(iNumber - 1)
                    + sNumber.charAt(iNumber)
                    + sNumber.charAt(iNumber + 1);
        }
        return result;
    }

    public static ArrayList<Float> congruenciaLineal(float a, float b, float m, float semilla, int countArray) {
        ArrayList<Float> list = new ArrayList<>();
        //float a = 3, b = 2, m = 90;
        int count = 1;
        //float semilla = 1;
        list.add(semilla);
        while (count < countArray) {
            float result = (a * list.get(count - 1) + b) % m;
            list.add(result);
            System.out.println(result);
            count++;
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
