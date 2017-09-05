package simulacion;

import java.util.ArrayList;
import java.util.Scanner;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Logic {

    public static ArrayList<String> functions(String expression, int count, int sw) {
        ArrayList<String> array = new ArrayList<>();
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = (int) (Math.random() * 50);
        }
        for (int i = 0; i < count; i++) {
            switch (sw) {
                case 0:
                    if (i - 1 != -1) {
                        array.add(operations(expression, String.valueOf(numbers[i - 1])));
                    }
                    break;
                case 1:
                    array.add(operations(expression, String.valueOf(numbers[i])));
                    break;
            }
        }
        return array;
    }

    private static String operations(String expression, String number) {
        String r = "";
        ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");
        String numberExpression = expression.replace("x", number).
                replace("cos", "Math.cos").
                replace("sin", "Math.sin").
                replace("tan", "Math.tan").
                replace("sqrt", "Math.sqrt").
                replace("sqr", "Math.pow").
                replace("log", "Math.log");
        try {
            Object result = engine.eval(numberExpression);
            System.out.println(numberExpression + " = " + result);
            r = numberExpression + " = " + result;
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return r;
    }
}
