package Server;

public class Methods {
    private String modelo;
    private String marca;
    private String color;
    private int numSerie;

    public Methods() {
    }

    public int getNumSerie() {
        return numSerie;
    }

    public void setnumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nModelo: ");
        sb.append(modelo);
        sb.append("\nMarca: ");
        sb.append(marca);
        sb.append("\nColor: ");
        sb.append(color);
        sb.append("\nNumero de serie: ");
        sb.append(numSerie);
        return sb.toString();
    }
}
