import java.util.ArrayList;
import java.util.List;

class Serial extends Circuit {
    private List<Circuit> circuits = new ArrayList<>();

    public void add(Circuit c) {
        circuits.add(c);
    }

    @Override
    public double getResistance() {
        double total = 0;
        for (Circuit c : circuits) {
            total += c.getResistance();
        }
        return total;
    }  
    @Override
    public String toString() {
        return "Série" + circuits.toString();
    }
}