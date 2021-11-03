package ExercicioGuiado;

import java.util.HashMap;
import java.util.Map;

public class ComputerFactory {
    private static Map<String, Computer> macFliweight = new HashMap<>();

    public Computer getComputer(int ram, int disco) {
        String id = "id: " + ram + ":" + disco;
        System.out.println(id);

        if (macFliweight.containsKey(id)) {
            macFliweight.put(id, new Computer(ram, disco));
            System.out.println("Pc criado");
            return macFliweight.get(id);
        }

        System.out.println("Pc obtido");

        return macFliweight.get(id);
    }
}
