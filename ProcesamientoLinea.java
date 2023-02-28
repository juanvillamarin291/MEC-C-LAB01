import java.util.*;

public class ProcesamientoLinea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una línea de texto: ");
        String linea = scanner.nextLine();

        // Encontrar el carácter más frecuente
        Map<Character, Integer> frecuencia = new HashMap<>();
        for (char c : linea.toCharArray()) {
            if (Character.isLetter(c)) {
                frecuencia.put(c, frecuencia.getOrDefault(c, 0) + 1);
            }
        }
        char caracterFrecuente = Collections.max(frecuencia.entrySet(), Map.Entry.comparingByValue()).getKey();

        // Sustituir las vocales por el carácter más frecuente
        String reemplazado = linea.replaceAll("[aeiouAEIOU]", String.valueOf(caracterFrecuente));
        System.out.println("Vocales reemplazadas: " + reemplazado);

        // Invertir la línea
        String invertido = new StringBuilder(linea).reverse().toString();
        System.out.println("Invertido: " + invertido);
    }
}