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

    public static ArrayList<String> fibonacci(int iC, int iM, int iS, int iR, double sN0, double sN1) {
        int count = 2, m = iM, s = iS, r = iR;
        ArrayList<Double> array = new ArrayList<>();
        ArrayList<Double> arrayU = new ArrayList<>();
        ArrayList<String> total = new ArrayList<>();
        array.add(sN0);
        array.add(sN1);
        while (count < iC) {
            double operacion = (array.get(count - s) + array.get(count - r)) % m;
            array.add(operacion);
            arrayU.add(operacion / m);
            System.out.println("Operación= " + operacion + ", U= " + operacion / m);
            total.add("Operación= " + operacion + ", U= " + operacion / m);
            count++;
        }
        return total;
    }

    public static ArrayList<String> whichmannHill(int iC, int iX, int iY, int iZ) {
        int count = 1;
        double x = iX, y = iY, z = iZ;
        ArrayList<Double> arrayX = new ArrayList<>();
        ArrayList<Double> arrayY = new ArrayList<>();
        ArrayList<Double> arrayZ = new ArrayList<>();
        ArrayList<Double> arrayU = new ArrayList<>();
        ArrayList<String> total = new ArrayList<>();
        arrayX.add(x);
        arrayY.add(y);
        arrayZ.add(z);
        while (count < iC) {
            double operacionX = (171 * arrayX.get(count - 1)) % 30269;
            double operacionY = (172 * arrayY.get(count - 1)) % 30307;
            double operacionZ = (170 * arrayZ.get(count - 1)) % 30323;
            double operacionU = (operacionX / 30269) + (operacionY / 30307) + (operacionZ / 30323);
            arrayX.add(operacionX);
            arrayY.add(operacionY);
            arrayZ.add(operacionZ);
            arrayU.add(operacionU);
            total.add("x= " + operacionX
                    + ", y= " + operacionY
                    + ", z= " + operacionZ
                    + ", U= " + operacionU);
            count++;
        }
        return total;
    }

    public static ArrayList<String> ecuyer(int iC, int iX, int iY) {
        int count = 1;
        double x = iX, y = iY;
        ArrayList<Double> arrayX = new ArrayList<>();
        ArrayList<Double> arrayY = new ArrayList<>();
        ArrayList<Double> arrayZ = new ArrayList<>();
        ArrayList<Double> arrayU = new ArrayList<>();
        ArrayList<String> total = new ArrayList<>();
        arrayX.add(x);
        arrayY.add(y);
        while (count < iC) {
            double operacionX = (40014 * arrayX.get(count - 1)) % 2147483563;
            double operacionY = (40692 * arrayY.get(count - 1)) % 2147483399;
            double operacionZ = (operacionX - operacionY) % 2147483562;
            double operacionU = 0.0;
            if (operacionZ >= 0) {
                operacionU = (operacionZ + 1) / 2147483563;
            } else if (operacionZ == 0) {
                operacionU = (2147483562) / 2147483563;
            }
            arrayX.add(operacionX);
            arrayY.add(operacionY);
            arrayZ.add(operacionZ);
            arrayU.add(operacionU);
            total.add("x= " + operacionX
                    + ", y= " + operacionY
                    + ", z= " + operacionZ
                    + ", U= " + operacionU);
            count++;
        }
        return total;
    }

    public static void main(String[] args) {

    }
}
