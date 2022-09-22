package Client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import Server.Methods;

import java.util.Scanner;

import java.net.MalformedURLException;
import java.net.URL;
public class RPCClient {
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        Scanner input = new Scanner (System.in);
        System.out.println("Selecciona el ejercicio al que quieres acceder: ");
        System.out.println("1.Saber tu IMC");
        System.out.println("2.Suma y promedio de 4 variables");
        System.out.println("3.Suma entre un rango de valores");
        System.out.println("4.Array ordenado de manera ascendente");
        int elecciona = input.nextInt();
        Methods funcion = new Methods();

        switch (elecciona){
            case 1:
                System.out.println("introduce tu nombre");
                String name = input.next();
                System.out.println("introduce tu altura");
                Double height = input.nextDouble();
                System.out.println("introduce tu peso");
                Double weight = input.nextDouble();

                System.out.println("Hola su nombre es "+ name+ " su altura es "+height+" su peso es "+ weight);
                XmlRpcClient client = new XmlRpcClient();
                client.setConfig(config);

                Double imc = funcion.IMC(weight, height);
                System.out.println("Su IMC es " + imc);
                break;
            case 2:
                Methods funcion_suma = new Methods();
                Methods funcion_promedio = new Methods();

                System.out.println("Introduce el primer numero");
                float num1 = input.nextFloat();

                System.out.println("Introduce el segundo numero");
                float num2 = input.nextFloat();

                System.out.println("Introduce el tercer numero");
                float num3 = input.nextFloat();

                System.out.println("Introduce el cuarto numero");
                float num4 = input.nextFloat();

                float suma = funcion_suma.suma(num1, num2, num3, num4);
                System.out.println("La suma de todos los numeros es de: "+ suma);

                float promedio = funcion_promedio.promedio(num1, num2, num3, num4);
                System.out.println("El promedio de todos los numeros es de: " +promedio);
                break;
            case 3:
                int sumarango = 0;
                int i=0;

                Methods funcionrango = new Methods();

                System.out.print("Introduce el primer numero: ");
                int num1ran = input.nextInt();
                System.out.print("Introduce el segundo numero: ");
                int num2ran = input.nextInt();

                int rango =funcionrango.rango(num1ran, num2ran, i, sumarango);
                System.out.println("La suma de los numeros entre el rango es de: "+rango);

                if(rango==0)System.out.println("Error: La suma es igual a 0 por que no hay ningun numero entre el rango");
                break;
            case 4:
                int iterador;
                int[] array = new int[5];

                System.out.println("Ahora introduce por teclado los elementos del array");
                for (iterador = 0; iterador < 4; iterador++) {
                    System.out.print("Introduce el array en la posicion ["+iterador+"]: ");
                    array[iterador] = input.nextInt();
                    System.out.println("num introducido = "+ array[iterador]);
                }
                int[] ordArray = funcion.ordArray(array);
                System.out.println("Array ordenado es: " + array);
                break;
        }
    }
}
