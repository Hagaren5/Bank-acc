import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main (String[] args) {

        Scanner teclado = new Scanner (System.in);
        int eleccion = 0;
        Usuario user = new Usuario();
        int edad = 0;
        Cuenta cuenta = new Cuenta ();
        double valorGasto=0;
        double valorIngreso=0;


        System.out.println ("Introduce el nombre del usuario");
        String nombre = teclado.next();
        user.setNombre (nombre);


        System.out.println ("Introduce la edad del usuario");
        do {
            try{
                edad = Integer.parseInt (teclado.next ());
            }catch (Exception e){
                System.err.println ("La edad escrita en números por favor:");
            }
        } while ( edad == 0 );
        user.setEdad (edad);

        System.out.println ("Introduce el DNI del usuario");
            String DNI = "";
        while (!user.setDNI (DNI)) {
            DNI = teclado.next ();
            System.out.println ("Introduce el DNI del usuario válido");
        }

        do {
            System.out.println("Realiza una nueva acción.");
            System.out.println("1.Introduce un nuevo gasto.");
            System.out.println("2.Introduce un nuevo ingreso.");
            System.out.println("3.Mostrar gastos.");
            System.out.println("4.Mostrar ingresos.");
            System.out.println("5.Mostrar saldo.");
            System.out.println("0.Salir.");
            eleccion = teclado.nextInt();
            switch (eleccion) {
                case 0:
                    System.out.println("Salir.");
                    break;
                case 1:
                    System.out.println("Introduce el concepto");
                    String conceptoGasto = teclado.next();

                    System.out.println ("Introduce la cantidad:");
                    String valorGastoString = teclado.next();

                    try {
                        valorGasto =  Double.parseDouble (valorGastoString);
                        Gasto gasto = new Gasto (valorGasto, conceptoGasto);
                        cuenta.addGasto (gasto);
                        } catch ( GastoException e ) {
                            System.err.println (e.getMessage ());
                        }catch (NumberFormatException f){
                            System.err.println (f.getMessage ());
                        }
                        System.out.println ("El saldo restante es: " + cuenta.getSaldo ());

                    break;
                case 2:
                    System.out.println("Introduce el concepto");
                    teclado.next();
                    String conceptoIngreso = teclado.nextLine();

                    System.out.println("Introduce la cantidad");
                    String valorIngresoString = teclado.next();

                    try {
                        valorIngreso =  Double.parseDouble (valorIngresoString);
                        Ingreso ingreso = new Ingreso (valorIngreso, conceptoIngreso);
                        cuenta.addIngreso (ingreso);
                    } catch (NumberFormatException f){
                        System.err.println (f.getMessage ());
                    }
                    /*double valorIngreso = teclado.nextDouble ();
                    Ingreso ingreso = new Ingreso(valorIngreso, conceptoIngreso);
                    cuenta.anyadirIngreso (ingreso);*/
                    System.out.println("Saldo restante: " + cuenta.getSaldo ());
                    break;
                case 3:
                    ArrayList<Gasto> valorGastoActual = cuenta.getGastos ();
                    System.out.println (valorGastoActual);
                    break;
                case 4:
                    ArrayList<Ingreso> valorIngresoActual = cuenta.getIngresos ();
                    System.out.println (valorIngresoActual);
                    teclado.next ();
                    break;
                case 5:
                    System.out.println (cuenta.toString ());
                    break;
                default:
                    System.err.println("Introduzca un valor válido.");
            }
        } while (eleccion != 0);





        System.out.println("Fin del programa.");
        System.out.println("Gracias por utilizar la aplicación.");


    }
}
