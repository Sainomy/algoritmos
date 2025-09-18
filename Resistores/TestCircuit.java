public class TestCircuit {
    public static void main(String[] args) {
        // Série  300, 500, 1200Ω
        Serial serie1 = new Serial();
        serie1.add(new Resistor(300));
        serie1.add(new Resistor(500));
        serie1.add(new Resistor(1200));

        System.out.println("Circuito Série (300,500,1200Ω): " + serie1.getResistance() + "Ω");

        // Paralelo com 50, 100, 300Ω
        Parallel paralelo1 = new Parallel();
        paralelo1.add(new Resistor(50));
        paralelo1.add(new Resistor(100));
        paralelo1.add(new Resistor(300));

        System.out.println("Circuito Paralelo (50,100,300Ω): " + paralelo1.getResistance() + "Ω");

    //  Paralelo entre resistor e um circuito série
        Parallel combinado = new Parallel();
        combinado.add(new Resistor(100));

        Serial serie2 = new Serial();
        serie2.add(new Resistor(200));
        serie2.add(new Resistor(300));

        combinado.add(serie2);

        System.out.println("Circuito Combinado (100Ω || (200Ω + 300Ω)): " 
                           + combinado.getResistance() + "Ω");

        // ( (100Ω || 200Ω) + (300Ω || 600Ω) )
        Serial serie3 = new Serial();

        Parallel paralelo2 = new Parallel();
        paralelo2.add(new Resistor(100));
        paralelo2.add(new Resistor(200));

        Parallel paralelo3 = new Parallel();
        paralelo3.add(new Resistor(300));
        paralelo3.add(new Resistor(600));

        serie3.add(paralelo2);
        serie3.add(paralelo3);

        System.out.println("Circuito Série entre dois paralelos ((100||200) + (300||600)): " 
                           + serie3.getResistance() + "Ω");
    }
}
