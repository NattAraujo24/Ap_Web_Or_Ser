package Server;
import java.util.Arrays;
public class Methods {
    //Ejercicio 1
    public double IMC (double weight, double height){
        return weight/((height*height));
    }
    //Ejercicio 2
    public float suma (float num1, float num2, float num3, float num4){
        return (num1+num2+num3+num4);
    }

    public static float promedio (float num1, float num2, float num3, float num4){
        return (num1+num4+num3+num4)/4;
    }
    //Ejercicio 3
    public int rango (int num1ran, int num2ran, int i, int sumarango){
        for(i = num1ran+1; i < num2ran; i++)
        {
            sumarango += i;
        };
        return sumarango;
    }
    //Ejercicio 4
    public int[] ordArray (int[] array){
        Arrays.sort(array);
        return array;
    }
}
