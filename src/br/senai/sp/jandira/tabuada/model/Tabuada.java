package br.senai.sp.jandira.tabuada.model;

import java.util.Scanner;

public class Tabuada {
    int multiplicando;
    int multiplicadorInicial;
    int multiplicadorFinal;
    int produto;

    public void receberDados() {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Multiplicando: ");
        multiplicando = leitor.nextInt();

        System.out.print("Multiplicador Incial: ");
        multiplicadorInicial = leitor.nextInt();

        System.out.print("Multiplicador Final: ");
        multiplicadorFinal = leitor.nextInt();

        calcularTabuada();

    }

    public void calcularTabuada() {
        if (multiplicadorInicial < multiplicadorFinal) {
            int[] tabuada = new int[multiplicadorInicial];

            while (multiplicadorFinal > tabuada.length) {
                tabuada = new int[multiplicadorInicial];
                produto = multiplicando * tabuada.length;

                System.out.println(multiplicando + "x" + tabuada.length + " = " + produto);
                multiplicadorInicial++;
            }
        } else if(multiplicadorFinal < multiplicadorInicial) {
            int[] tabuada = new int[multiplicadorFinal];

            while(multiplicadorInicial > tabuada.length){
                tabuada = new int[multiplicadorFinal];
                produto = multiplicando * tabuada.length;
                System.out.println(multiplicando +  "x" + tabuada.length + " = " + produto);
                multiplicadorFinal++;
            }
        }else{
            produto = multiplicando * multiplicadorFinal;
            System.out.println(multiplicando +  "x" + multiplicadorFinal + " = " + produto);
        }
    }
}
