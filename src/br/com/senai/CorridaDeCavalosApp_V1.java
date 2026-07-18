package br.com.senai;

import java.util.Scanner;

public class CorridaDeCavalosApp_V1 {
    void main() {
        //Recursos
        Scanner scanner = new Scanner(System.in);
        int cavaloApostado;
        int[] posicaoCavalos = new int[8];
        int tempo = 0;
        boolean continuarCorrendo = true;
        int indiceVencedor = 0;

        //Saudações
        IO.println("Bem-vindo à Corrida de Cavalos Rochas !");

        //Acolhendo o apostador
        IO.println("Por favor digite o número do cavalo que deseja apostar (1 a 8): ");
        cavaloApostado = scanner.nextInt();

        while (cavaloApostado < 1 || cavaloApostado > 8) {
            IO.println("Escolha um Cavalo para apostar de 1 até 8");
            cavaloApostado = scanner.nextInt();
            scanner.nextLine();
        }

        IO.println("Você apostou no cavalo número: " + cavaloApostado + ", Boa sorte!");
        IO.println("Preciione \"ENTER\" para dar a Largada ");
        scanner.nextLine();

        IO.println("A corrida comeca em 3...");
        IO.println("A corrida comeca em 2...");
        IO.println("A corrida comeca em 1...");
        IO.println("A corrida comeca em 0... \n ");

        while (continuarCorrendo){
            tempo++;

            for (int i = 0; i < posicaoCavalos.length; i++) {

                posicaoCavalos[i] += Math.random() * 6;
                IO.println("O cavalo " + (i + 1) + " está na posição: " + mostrarEvolucao(posicaoCavalos[i]));

                if(posicaoCavalos[i] >= 100){
                    indiceVencedor = i + 1;
                    continuarCorrendo = false;
                }
            }


            if (tempo == 10) {
                IO.println("Gostaria de mudar sua aposta? (S/N)");
                String repsosta = scanner.next();
                scanner.nextLine();

                if (repsosta.equalsIgnoreCase("S") || repsosta.equalsIgnoreCase("Sim")) {

                    IO.println("Por favor digite o número do cavalo que deseja apostar (1 a 8): ");
                    cavaloApostado = scanner.nextInt();
                    scanner.nextLine();

                    while (cavaloApostado < 1 || cavaloApostado > 8) {

                        IO.println("Escolha um Cavalo para apostar de 1 até 8");
                        cavaloApostado = scanner.nextInt();
                        scanner.nextLine();
                    }

                    IO.println("Você apostou no cavalo número: " + cavaloApostado + ", Boa sorte!");
                }
            }

            if (continuarCorrendo){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                }

                IO.println();
            }
        }

        IO.println("FIM DE JOGO!");
        IO.println("");

        int vencedor = indiceVencedor + 1;
        IO.println("Parabéns!! O cavalo " + vencedor + " venceu a corrida!");
        IO.println("Você apostou no cavalo " + cavaloApostado + " e o vencedor foi o cavalo " + vencedor);

        if (cavaloApostado == vencedor){
            IO.println("Parabéns você ganhou a aposta!");
        } else {
            IO.println("Infelizmente você perdeu a aposta, tente novamente!");
        }
    }

    public static String mostrarEvolucao(int n) {

        String barra = "";
        for (int i = 0; i < n; i++) {
            barra = barra.concat(".");
        }

        String chegada = "|";
        for (int i = 0; i < 100 - n; i++) {
            chegada = " " + chegada;
        }

        return barra + "\uD800\uDC83" + chegada;
    }
}
