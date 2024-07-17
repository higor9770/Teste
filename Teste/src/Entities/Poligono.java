package Entities;

public class Poligono {

    public int lados;
    public double tamanho;

    public Poligono(int lados, double tamanho) {
        this.lados = lados;
        this.tamanho = tamanho;
    }
    
    public int getLados() {
        return lados;
    }

    public double getTamanho() {
        return tamanho;
    }

    public String getNome() {
    	if (lados == 3) {
            return "Triângulo";
        } else {
            return "Quadrado";
        }
    }

    public double calcularArea() {
        switch (lados) {
            case 3:
                return calcularAreaTriangulo();
            case 4:
                return calcularAreaQuadrado();
            default:
                throw new IllegalArgumentException("Polígono não suportado para cálculo de área.");
        }
    }

    private double calcularAreaTriangulo() {
        return (Math.sqrt(3) / 4) * Math.pow(tamanho, 2);
    }

    private double calcularAreaQuadrado() {
        return Math.pow(tamanho, 2);
    }
}
