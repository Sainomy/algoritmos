import java.util.ArrayList;
import java.util.List;

class Parallel extends Circuit {
    private List<Circuit> circuits = new ArrayList<>();

    public void add(Circuit c) {
        circuits.add(c);
    }

    @Override
    public double getResistance() {
        double inverseSum = 0;
        for (Circuit c : circuits) {
            inverseSum += 1.0 / c.getResistance();
        }
        return 1.0 / inverseSum;
    }

    @Override
    public String toString() {
        return "Paralelo" + circuits.toString();
    }
}
