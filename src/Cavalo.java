import java.util.Random;
import java.util.Scanner;

public class Cavalo {

	public static void main(String[] args) {
		
		Random random = new Random();
		Scanner input = new Scanner(System.in);

		int[][] tabuleiro = new int[8][8];
		int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
		int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};
		int[][] acessabilidade = {{2, 3, 4, 4, 4, 4, 3, 2},
								  {3, 4, 6, 6, 6, 6, 4, 3},
								  {4, 6, 8, 8, 8, 8, 6, 4},
								  {4, 6, 8, 8, 8, 8, 6, 4},
								  {4, 6, 8, 8, 8, 8, 6, 4},
								  {4, 6, 8, 8, 8, 8, 6, 4},
								  {3, 4, 6, 6, 6, 6, 4, 3},
								  {2, 3, 4, 4, 4, 4, 3, 2}
								  };
		
		
		int linhaAtual, colunaAtual, jogada, maximoTabuleiro, minimoTabuleiro, linhaAcessabilidade, colunaAcessabilidade; 
		
		System.out.println("O Passeio do Cavalo\n"
				+ "Esse programa busca apresentar uma solução para o problema \"O Passeio do Cavalo\".\n"
				+ "Esse problema consiste em fazer que o Cavalo, do jogo de Xadrez, caminhe por todas as casas do tabuleiro uma única vez, partindo de uma posição aleatória do tabuleiro.\n"
				+ "Cada movimento do Cavalo no tabuleiro indica a sua posição e em qual jogada cada movimentação foi feita.\n"
				+ "Tecle \"Enter\" para iniciar o programa.");
		
		input.nextLine();
		
		
		linhaAtual = random.nextInt(8);
		colunaAtual = random.nextInt(8);

		
		maximoTabuleiro = tabuleiro.length - 1;
		minimoTabuleiro = 0;
		
		inicializaArray(tabuleiro);
		
		
		
		System.out.println("");
		
		for(int i = 0; i < 64; i++){
			
			jogada = 0;
			System.out.printf("Jogada nº%d\n", i+1);
			
			//Atualiza os valores do array acessabilidade, de acordo com a posição do cavalo.
			for(int x = 0; x < 8; x++){
				if(linhaAtual + horizontal[x] >= minimoTabuleiro 
				   && linhaAtual + horizontal[x] <= maximoTabuleiro 
				   && colunaAtual + vertical[x] >= minimoTabuleiro
			       && colunaAtual + vertical[x] <= maximoTabuleiro){
					if(acessabilidade[linhaAtual + horizontal[x]][colunaAtual + vertical[x]] > 0){
						acessabilidade[linhaAtual + horizontal[x]][colunaAtual + vertical[x]]--;
					}
					
				}
			}
			
			//Define a próxima jogada a ser feita, de acordo com as posições que o cavalo pode alcançar 
			//a partir da sua posição atual, e também buscando a posição com a menor acessabilidade, que ainda não foi visitada.
			
			do{
				
				int menorAcessabilidade = 1000, menorAcessabilidadeLinha, menorAcessabilidadeColuna;
				
				
				linhaAcessabilidade = linhaAtual;
				colunaAcessabilidade = colunaAtual;
				
				menorAcessabilidadeLinha = linhaAcessabilidade;
				menorAcessabilidadeColuna = colunaAcessabilidade;
				
				
				for(int x = 0; x < 8; x++){
					if(linhaAtual + horizontal[x] >= minimoTabuleiro 
					   && linhaAtual + horizontal[x] <= maximoTabuleiro 
					   && colunaAtual + vertical[x] >= minimoTabuleiro
					   && colunaAtual + vertical[x] <= maximoTabuleiro){
						
						linhaAcessabilidade = linhaAtual + horizontal[x];
						colunaAcessabilidade = colunaAtual + vertical[x];
						
						if(acessabilidade[linhaAcessabilidade][colunaAcessabilidade] <= menorAcessabilidade){
							if(tabuleiro[linhaAcessabilidade][colunaAcessabilidade] == 0){
								if(acessabilidade[linhaAcessabilidade][colunaAcessabilidade] == menorAcessabilidade){
									
								}
								menorAcessabilidade = acessabilidade[linhaAcessabilidade][colunaAcessabilidade];
								jogada = x;
							}
						}
					}
					
					
				}
				
				
			
				
			}while(linhaAtual + horizontal[jogada] < minimoTabuleiro 
					|| linhaAtual + horizontal[jogada] > maximoTabuleiro 
					|| colunaAtual + vertical[jogada] < minimoTabuleiro
					|| colunaAtual + vertical[jogada] > maximoTabuleiro);
			
			
			
			linhaAtual += horizontal[jogada];
			colunaAtual += vertical[jogada];
			
			tabuleiro[linhaAtual][colunaAtual] = i+1;
			
			exibeArray(tabuleiro);
			
			}
		
	}
	
	final static void inicializaArray(int[][] tabuleiro){
		for(int i = 0; i < tabuleiro.length; i++){
			for( int j = 0; j < tabuleiro[0].length; j++){
				tabuleiro[i][j] = 0;
			}
		}
	}
	
	final static void exibeArray(int[][] tabuleiro){
		for(int i = 0; i < tabuleiro.length; i++){
			for( int j = 0; j < tabuleiro[0].length; j++){
				if(tabuleiro[i][j] == 99){
					System.out.printf("| c ", tabuleiro[i][j]);
				}
				else if(tabuleiro[i][j] == 0){
					System.out.printf("|   ", tabuleiro[i][j]);
				}
				else if(tabuleiro[i][j] > 9){
					System.out.printf("| %d", tabuleiro[i][j]);
				}else{
					System.out.printf("| %d ", tabuleiro[i][j]);
				}
			}
			System.out.println("|");
		}
		System.out.println();
	}
}
