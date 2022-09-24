package Client;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executor;
public class RPCClient {
    static Scanner sc = new Scanner(System.in);
    private static Executor cliente;

    public static void main(String[] arg) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        String option = "", nombre = "", primerApellido = "", segundoApellido = "", sexo = "", estadodenacimiento = "", fechadeNacimiento = "";
        System.out.println("Ingrese los datos para la creacion de su CURP");
        System.out.println("Ingrese su Nombre");
        nombre = sc.next();
        System.out.println("Ingrese su Primer Apellido");
        primerApellido = sc.next();
        System.out.println("Ingrese su Segundo Apellido");
        segundoApellido = sc.next();
        System.out.println("Ingrese su Sexo (Mujer/Hombre)");
        sexo = sc.next();
        System.out.println("Ingrese su Estado de nacimiento");
        estadodenacimiento = sc.next();
        System.out.println("Ingrese su Fecha de Nacimiento (Ejemplo:030824/AAMMDD)");
        fechadeNacimiento = sc.next();

        System.out.println("Su Nombre es: "+nombre);
        System.out.println("Su Primer Apellido es: "+primerApellido);
        System.out.println("Su Segundo Apellido es: "+segundoApellido);
        System.out.println("Su Sexo es: "+sexo);
        System.out.println("Su Estado de nacimiento es: "+estadodenacimiento);
        System.out.println("Su Fecha de Nacimiento es: "+fechadeNacimiento);

        String c1Y2 = primerApellido.substring(0,2);
        char c3 = segundoApellido.charAt(0);
        char c4 = nombre. charAt(0);
        String c5Y6 = fechadeNacimiento;
        char c11 = sexo.charAt(0);
        String c14 = estadodenacimiento.substring(0,3);
        String c12Y13;
        String entidad = "";
        char c7 = primerApellido.charAt(2);
        char c8 = segundoApellido.charAt(1);
        char c9 = nombre. charAt(2);
        char c10 = nombre. charAt(5);
        int nr1 = (int)(Math.random()*10+1);
        int nr2 = (int)(Math.random()*10+1);
        if (entidad=="Aguascalientes");{
            c12Y13 = "AS";
        }elseif (entidad=="Morelos");{
            c12Y13 = "MS";
        }
        System.out.println("Tu CURP es: "+c1Y2+c3+c4+c5Y6+c11+c12Y13+c7+c8+c9+c10+nr1+nr2);
    }

    private static void elseif(boolean b) {
    }
}
//lo intente, hice lo mejor que pude, lo siento =(

