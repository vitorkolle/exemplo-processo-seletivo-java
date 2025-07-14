package br.com.dio;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"Lucas", "Mariana", "João", "Isabela", "Carlos"};

        for (String candidato : candidatos){
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;

            if (continuarTentando){
                tentativasRealizadas++;
            }
            else {
                System.out.println("Contato realizado com sucesso");
            }
        }
        while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu){
            System.out.printf("Conseguimos contato com o candidato %s na tentativa %s\n", candidato, tentativasRealizadas);
        }
        else {
            System.out.printf("Não conseguimos contato com o candidato %s, número máximo de tentativas %s realizadas \n", candidato, tentativasRealizadas);
        }
    }

    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados(){
        String [] candidatos = {"Lucas", "Mariana", "João", "Isabela", "Carlos"};
        System.out.println("Imprimindo a lista de candidatos informando o índice de cada um");

        for (int i = 0; i <  candidatos.length; i++){
            System.out.printf("O candidato de n° %s é %s \n", i + 1, candidatos[i]);
        }
    }

    static void selecaoDeCandidatos(){
        String [] candidatos = {"Lucas", "Mariana", "João", "Isabela", "Carlos", "Ana", "Pedro", "Larissa", "Mateus", "Beatriz"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.printf("O candidato %s solicitou o seguinte valor de salário: %s \n", candidato, salarioPretendido);

            if(salarioBase >= salarioPretendido){
                candidatosSelecionados++;
                System.out.printf("O candidato %s foi selecionado para a vaga \n", candidato);
            }

            System.out.println("--------------------------------------------------");

            candidatoAtual++;
        }

    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato");
        }

        else if(salarioBase == salarioPretendido){
            System.out.println("Ligar para o candidato com contraproposta");
        }

        else {
            System.out.println("Aguardando os demais candidatos");
        }
    }

}
