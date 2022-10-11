package Client;
import Server.Methods;

import java.util.ArrayList;
import java.util.Scanner;
public class RPCClient {


    static Scanner sc = new Scanner(System.in);

    static ArrayList<Methods> vehiculo = new ArrayList<Methods>();

    public static void main(String[] args){
        leerVehiculos();
        System.out.println("\nVehiculos introducidos:");
        for(int i = 0; i< vehiculo.size(); i++)
            System.out.println(vehiculo.get(i));
    }
    public static void leerVehiculos(){
        String modelo;
        String marca;
        String color;
        int numSerie;

            Methods aux;
            int i, N;
         do {
        System.out.print("Número de coches? ");
        N = sc.nextInt();
    } while (N < 0);
        sc.nextLine();

            for (i = 1; i <= N; i++) {

                System.out.println("Vehiculo " + i);
                System.out.print("Modelo: ");
                modelo = sc.nextLine();
                System.out.print("Marca: ");
                marca = sc.nextLine();
                System.out.print("color: ");
                color = sc.nextLine();
                System.out.print("Número de serie: ");
                numSerie = sc.nextInt();
                sc.nextLine();
                aux = new Methods();
                aux.setModelo(modelo);
                aux.setMarca(marca);
                aux.setColor(color);
                aux.setnumSerie(numSerie);

                vehiculo.add(aux);
            }
        }
}