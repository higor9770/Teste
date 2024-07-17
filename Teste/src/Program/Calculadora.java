package Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Entities.Poligono;

public class Calculadora {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos polígonos deseja calcular (Triângulos e Quadrados): ");
        int qtdPoligonos = sc.nextInt();

        List<Poligono> poligonos = new ArrayList<>();

        for (int i = 0; i < qtdPoligonos; i++) {
            System.out.println("\nDigite os dados do polígono " + (i + 1) + "\n");
            System.out.print("Quantidade de lados (3 para Triângulo, 4 para Quadrado): ");
            int lados = sc.nextInt();
            sc.nextLine(); 

            if (lados != 3 && lados != 4) {
                System.out.println("\nPolígono não reconhecido. Por favor, tente novamente.");
                break;
                
            }

            System.out.print("Digite o tamanho do lado em cm: ");
            double tamanho = sc.nextDouble();
            sc.nextLine();

            poligonos.add(new Poligono(lados, tamanho));
        }


        for (int i = 0; i < poligonos.size(); i++) {
            Poligono poligono = poligonos.get(i);
            double area = poligono.calcularArea();
            String nomePoligono = poligono.getNome();
            double tamanhoLado = poligono.getTamanho();

            System.out.printf("%s de lado %.2f cm e área %.2f cm²\n", nomePoligono, tamanhoLado, area);
        }

        double somaAreas = poligonos.stream().mapToDouble(Poligono::calcularArea).sum();
        System.out.printf("\nÁrea total %.2f cm²\n", somaAreas);

        sc.close();
    }
}
