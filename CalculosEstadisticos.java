import java.util.Arrays;
import java.util.Scanner;

public class CalculosEstadisticos {
    public static void main(String[] args) {
        // Pedir tamaño del arreglo
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del arreglo: ");
        int n = sc.nextInt();
        
        // Crear arreglo con números aleatorios
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Math.random() * 100;
        }
        
        // Calcular la media y la mediana
        double media = Arrays.stream(arr).average().orElse(Double.NaN);
        Arrays.sort(arr);
        double mediana = n % 2 == 0 ? (arr[n/2 - 1] + arr[n/2]) / 2 : arr[n/2];
        
        // Calcular la varianza y la desviación estándar
        double varianza = 0;
        for (double x : arr) {
            varianza += Math.pow(x - media, 2);
        }
        varianza /= n;
        double desviacion = Math.sqrt(varianza);
        
        // Calcular la moda
        double moda = Double.NaN;
        int maxCount = 0;
        for (double x : arr) {
            int count = 0;
            for (double y : arr) {
                if (x == y) {
                    count++;
                }
            }
            if (count > maxCount) {
                moda = x;
                maxCount = count;
            }
        }
        
        // Imprimir resultados
        System.out.println("Arreglo: " + Arrays.toString(arr));
        System.out.println("Media: " + media);
        System.out.println("Mediana: " + mediana);
        System.out.println("Varianza: " + varianza);
        System.out.println("Desviación estándar: " + desviacion);
        System.out.println("Moda: " + moda);
    }
}
