package br.senai.sp.jandira.tabuada.model;

import java.util.Scanner;

public class Tabuada {

    public int multiplicando;
    public int multiplicadorInicial;
    public int multiplicadorFinal;
    public String[] tabuada;

    public void receberDados(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("============TABUADA===========\n");

        System.out.print("Qual o número multiplicando? ");
        multiplicando = scanner.nextInt();

        System.out.print("Qual o número multiplicador inicial? ");
        multiplicadorInicial = scanner.nextInt();

        System.out.print("Qual o número multiplicador final? ");
        multiplicadorFinal = scanner.nextInt();
        System.out.println(" ");

        calcularTabuada();
    }

    public String[] calcularTabuada(){
        int apoio = 0;

        if (multiplicadorFinal < multiplicadorInicial) {
            apoio = multiplicadorFinal;
            multiplicadorFinal = multiplicadorInicial;
            multiplicadorInicial = apoio;
        }

        int tamanho = multiplicadorFinal - multiplicadorInicial + 1;
        tabuada = new String[tamanho];

        int i = 0;

        while (i < tamanho) {
            int produto = multiplicando * multiplicadorInicial;
            tabuada[i] = multiplicando + " x " + multiplicadorInicial + " = " + produto;
            i = i + 1;
            multiplicadorInicial = multiplicadorInicial + 1;
        }

        return tabuada;
    }

    public void exibirTabuada() {

        System.out.println("------------------------------\n");
        System.out.println("===Resultado da sua tabuada===\n");
        int i = 0;
        while ( i < tabuada.length) {
            System.out.println(tabuada[i]);
            i = i + 1;
        }
        System.out.println(" ");
        System.out.println("------------------------------\n");

    }
}
