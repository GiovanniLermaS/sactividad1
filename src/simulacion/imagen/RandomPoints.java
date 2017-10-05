package simulacion.imagen;

import java.util.ArrayList;
import java.util.Random;

public class RandomPoints {

    private int n;
    private Double a;
    private Double b;
    private Double m;

    public RandomPoints() {
        this.n = 0;
        this.a = 0.0;
        this.b = 0.0;
        this.m = 0.0;
    }

    public ArrayList<Integer> get100Numbers(int limit) {
        Random rnd = new Random();
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        this.n = 100;
        this.a = 4014.0;
        this.b = 18.0;
        this.m = 397.0;
        Double xn = Double.parseDouble((rnd.nextInt(100) + 600) + "");

        do {
            xn = ((this.a * xn) + b) % this.m;
            if (xn < limit) {
                numbers.add(xn.intValue());
            }
        } while (numbers.size() < n);

        return numbers;
    }
}
