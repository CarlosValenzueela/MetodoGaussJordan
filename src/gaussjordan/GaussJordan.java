/**
 * Paquete gaussjordan
 *
 */
package gaussjordan;

/**
 * Imports utilizados en clase
 */
import java.util.Scanner;

/*Nombre del archivo: asignacion08_00000207256
Nombre del proyecto: gaussJordan
Nombre de alumno: Carlos Antonio Valenzuela Valdez
Matricula: 00000207256
Fecha de creación: 29/09/2020 07:18 p.m. */
/**
 * El programa resuelva un sistema de ecuaciones lineales simultáneas por el
 * método de Gauss – Jordan con pivoteo
 */
/**
 * Clase main donde se mandaran a ejecutar los métodos de la clase
 *
 * @author Carlos Antonio Valenzuela Valdez
 */
public class GaussJordan {

    //Atributos de clase
    static double[][] arregloEcuaciones;
    static int cantidadEcuaciones = 0, aux = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Que hace el programa
        System.out.println("El programa resuelva un sistema de ecuaciones lineales simultáneas por el método de\n"
                + "Gauss – Jordan con pivoteo\n");

        //Creación de instancia para llamar al método
        GaussJordan main = new GaussJordan();

        //Llamado a métodos
        main.leeEcuaciones();
        main.gaussJordan();
        main.despliegaSolucion();
    }

    /**
     * Lee el número de ecuaciones (máximo 10) y después los valores de los
     * coeficientes y término independiente para cada ecuación y los almacena en
     * un arreglo bidimensional
     *
     */
    public static void leeEcuaciones() {
        //Declaración de Scanner para ingresar datos de entrada
        Scanner teclado = new Scanner(System.in);

        boolean pasar = true;

        //Si las instrucciones no se cumplen, el ciclo se reinicia
        while (pasar) {
            System.out.println("---Solicitud de datos");
            System.out.print("\nIngrese el número de ecuaciones(Máximo 10): ");
            cantidadEcuaciones = teclado.nextInt();

            if (cantidadEcuaciones <= 0 || cantidadEcuaciones > 10) {
                System.out.println("La cantidad de ecucaciones es en un rango de 0 - 10 . \n");
            } else {
                pasar = false;
            }
        }

        //Declaración de arreglo bidimensional
        arregloEcuaciones = new double[cantidadEcuaciones][cantidadEcuaciones + 1];

        System.out.println("\nSolicitud de coeficientes y terminos independientes para cada ecuación: ");
        for (int i = 0; i < cantidadEcuaciones; i++) {
            System.out.print("\nEcuación número " + (i + 1) + "\n");
            for (int j = 0; j < (cantidadEcuaciones + 1); j++) {
                if (j < cantidadEcuaciones) {
                    System.out.print("Ingrese incognita " + (j + 1) + ": ");
                } else {
                    System.out.print("Ingrese termino independiente: ");

                }
                arregloEcuaciones[i][j] = teclado.nextDouble();

            }

        }
    }

    /**
     * Resuelve el sistema de ecuaciones cuyos coeficientes y términos
     * independientes se encuentran en un arreglo bidimensional y guarda la
     * solución en un arreglo
     */
    public static void gaussJordan() {

        for (int a = 0; a < cantidadEcuaciones; a++) {
            pivotea();

            convertirCeros();

            aux++;
        }
        System.out.println("");
        for (int i = 0; i < cantidadEcuaciones; i++) {
            System.out.printf("\nValor de X%s = %4.6f", (i + 1), arregloEcuaciones[i][cantidadEcuaciones]);
        }

    }

    /**
     * Reacomoda las ecuaciones a partir de la i-ésima para que el elemento
     * pivote sea el mayor de los elementos hacia abajo en su columna. Los
     * coeficientes y términos independientes del sistema de ecuaciones se
     * encuentran en un arreglo bidimensional
     */
    public static void pivotea() {
        double var = 0;
        var = arregloEcuaciones[aux][aux];
        for (int i = 0; i < (cantidadEcuaciones + 1); i++) {

            arregloEcuaciones[aux][i] = arregloEcuaciones[aux][i] / var;
        }
    }

    /**
     * Despliega la solución del sistema de ecuaciones que se encuentra en un
     * arreglo
     */
    public static void despliegaSolucion() {
        System.out.println("\n\nMatriz: ");
        for (int i = 0; i < arregloEcuaciones.length; i++) {
            for (int j = 0; j < arregloEcuaciones.length + 1; j++) {
                if (j < arregloEcuaciones.length) {
                    System.out.print(arregloEcuaciones[i][j] + " X" + (j + 1) + "\t");

                } else {
                    System.out.printf(" = %.6f\t", arregloEcuaciones[i][j]);
                }

            }
            System.out.println("");

        }
    }

    /**
     * Convierte a 0 los digitos de la matriz segun sea el caso, con método
     * GaussJordan
     */
    public static void convertirCeros() {
        for (int i = 0; i < cantidadEcuaciones; i++) {
            if (i != aux) {
                double auxiliar = arregloEcuaciones[i][aux];
                for (int j = 0; j < (cantidadEcuaciones + 1); j++) {
                    arregloEcuaciones[i][j] = ((-1 * auxiliar) * arregloEcuaciones[aux][j]) + arregloEcuaciones[i][j];
                }
            }
        }
    }
}
