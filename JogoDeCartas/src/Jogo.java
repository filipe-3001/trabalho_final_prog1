import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Jogo!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Iniciar Jogo");
            System.out.println("2. Sair do Jogo");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    iniciarJogo();
                    break;
                case 2:
                    System.out.println("Obrigado por jogar. Até logo!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void iniciarJogo() {
        //Instaciamento de classe
        Tabuleiro tabuleiro = new Tabuleiro();
        Baralho baralho = new Baralho();
        MaoJogadores maoJogadores = new MaoJogadores();
        Scanner scanner = new Scanner(System.in);

        //Listas
        List<String> nomesJogadores = new ArrayList<>();
        List<Integer> ordemDeJogada = new ArrayList<>();
        List<Integer> cartaQueDeveSerJogada = new ArrayList<>();


        //Matriz
        int cartasSelecionadas[][] = new int[6][1];

        //Variaveis
        int numJogadores = 0;
        int selecaoDeCartas = 0;
        int ordenamentoDeJogada = 0;
        int xTabela = 0;
        int yTabela = 0;


        //Trata as exeções caso algo inválido seja digitado na hora da seleção da quantidade de jogadores
        while (numJogadores < 3 || numJogadores > 6) {
            try {
                System.out.println("Informe a quantidade de jogadores (3 a 6): ");
                numJogadores = scanner.nextInt();

                if (numJogadores < 3 || numJogadores > 6) {
                    System.out.println("Número de jogadores inválido. O número deve estar entre 3 e 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite um número válido.");
                scanner.nextLine(); 
            }
        }

        //Informa o nome dos jogadores
        for (int i = 0; i < numJogadores; i++) {
            System.out.print("\nInforme o nome do jogador " + i + ": ");
            nomesJogadores.add(scanner.next());
            System.out.println("  ");
        }

        //Essa classe precisa do nome dos jogadores para ser instanciada
        Jogador jogadores = new Jogador(numJogadores, nomesJogadores);

        //Inicia o bralho
        baralho.embaralhar();

        //Distribui as cartas entre os jogadores
        try {
            for(int controlador = 0; controlador < numJogadores; controlador++){
                for(int c = 0; c <= 11; c++){
                    maoJogadores.adicionarCarta(controlador, c, baralho.getCarta());
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());

        }

        //Definindo as cartas iniciais do tabuleiro
        for(int iDois = 0; iDois < 5; iDois++){
            tabuleiro.setTabuleiro(iDois, 0, baralho.getCarta());
        }

        //Inicio do jogo
        System.out.println("Inicio do Jogo: ");
        while(true){
            //Impressão do tabuleiro
            System.out.println("Tabuleiro: ");
            tabuleiro.ImpressaoTabuleiro();

            //Seleção de cartas
            for(int iTres = 0; iTres < numJogadores; iTres++){
                jogadores.mostrarJogador(iTres);
                System.out.println(" ");
                //Mostrando as cartas
                for(int iQuatro = 0; iQuatro <= 11; iQuatro++){
                    System.out.print(maoJogadores.getCartas(iTres, iQuatro) + "  ");
                }

                //Espaço de formatação fo terminal
                System.out.println("");

                //Menu para seleção de cartas
                try {
                    System.out.println("Selicione a carta que você deseja, digitando o número dela.");
                    selecaoDeCartas = scanner.nextInt();

                    if (selecaoDeCartas == 0) {
                        System.out.println("Número inválido. O número deve estar entre 1 e 12.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Erro: Digite um número válido.");
                    scanner.nextLine(); 
                }
                //Salvando cartas selecionadas
                cartasSelecionadas[iTres][0] = selecaoDeCartas;

                //Retirando a "carta" da mao do jogador
                for(int iCinco = 0; iCinco <= 11; iCinco++){
                        int improviso = maoJogadores.getCartas(iTres, iCinco);
                        if(selecaoDeCartas == improviso){
                            maoJogadores.retirarCarta(iTres, iCinco);
                        }
                }
            }


            
            //Criando a ordem de jogada 
            for(int c = 0; c < numJogadores; c++){
                ordenamentoDeJogada = 150;
                if(cartasSelecionadas[0][0] < ordenamentoDeJogada){
                    ordenamentoDeJogada = cartasSelecionadas[0][0];
                }
                //Encontra a menor carta
                for(int iSeis = 0; iSeis < numJogadores; iSeis++){
                    if(cartasSelecionadas[iSeis][0] < ordenamentoDeJogada){
                        ordenamentoDeJogada = cartasSelecionadas[iSeis][0]; 
                    } 
                }
                //Salva a menor carta em ordem
                for (int iSete = 0; iSete < numJogadores; iSete++) {
                    if (cartasSelecionadas[iSete][0] == ordenamentoDeJogada) {
                        ordemDeJogada.add(iSete); 
                        cartaQueDeveSerJogada.add(cartasSelecionadas[iSete][0]);
                        cartasSelecionadas[iSete][0] = 150;
                    }
                }
            }
            
            //Imprimir ordem de jogada
            System.out.println("Ordem de jogada: ");
            for(int iOito = 0; iOito < numJogadores; iOito++){
                jogadores.mostrarJogador(ordemDeJogada.get(iOito));
            }
            System.out.println("   ");

            //Imprimindo o tabuleiro
            tabuleiro.ImpressaoTabuleiro();;
            System.out.println(" ");

            //Escolher a posição da na tabela para colocar a carta
            for(int iNove = 0; iNove < numJogadores; iNove++){
                //Selecionando o jogador
                jogadores.mostrarJogador(ordemDeJogada.get(iNove));
                System.out.println(" ");

                System.out.println("Digite o número da linha da  tabela, para colocar a carta.");
                xTabela = scanner.nextInt();


                //Colocando o número na tabela
                

            }
            

            

        }
        

        }
}
