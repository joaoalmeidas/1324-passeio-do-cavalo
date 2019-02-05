import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Tabuleiro extends JPanel implements ActionListener{
	
	private int[][] acessabilidade = {{2, 3, 4, 4, 4, 4, 3, 2},
			  {3, 4, 6, 6, 6, 6, 4, 3},
			  {4, 6, 8, 8, 8, 8, 6, 4},
			  {4, 6, 8, 8, 8, 8, 6, 4},
			  {4, 6, 8, 8, 8, 8, 6, 4},
			  {4, 6, 8, 8, 8, 8, 6, 4},
			  {3, 4, 6, 6, 6, 6, 4, 3},
			  {2, 3, 4, 4, 4, 4, 3, 2}
			  };
	
	private int[][] tabuleiro;
	
	private JTextField[][] casaTabuleiro;
	
	private Random aleatorio = new Random();
	
	
	private Timer tempo ;
	
	private int linhaAtual, colunaAtual, jogada, maximoTabuleiro, minimoTabuleiro, linhaAcessabilidade, colunaAcessabilidade, jogadaAtual = 1; 
	
	
	public Tabuleiro() {
		
		setLayout(new GridLayout(8, 8));
		casaTabuleiro = new JTextField[8][8];
		
		tempo = new Timer(1000, this);
		tempo.start();
		
		
		linhaAtual = aleatorio.nextInt(8);
		colunaAtual = aleatorio.nextInt(8);	
		jogada = 0;
		tabuleiro = new int[8][8];
		maximoTabuleiro = acessabilidade[0].length - 1;
		minimoTabuleiro = 0;
		
		for(int i = 0; i < casaTabuleiro.length; i++) {
			
			for(int j = 0; j < casaTabuleiro[0].length; j++) {
				
				
				casaTabuleiro[i][j] = new JTextField();
				casaTabuleiro[i][j].setFont(new Font("Arial", Font.BOLD, 90));
				
				if(j%2 == 0  && i%2 == 0 ) {
					
					casaTabuleiro[i][j].setBackground(Color.BLACK);
					casaTabuleiro[i][j].setForeground(Color.WHITE);
					
				}else if(j%2 != 0  && i%2 != 0 ) {
					
					casaTabuleiro[i][j].setBackground(Color.BLACK);
					casaTabuleiro[i][j].setForeground(Color.WHITE);
					
				}
				
				
				add(casaTabuleiro[i][j]);
				
			}
			
		}
		
		for(int i = 0; i < 64; i++){
			
			jogada = 0;
			
			//Atualiza os valores do array acessabilidade, de acordo com a posição do cavalo.
			for(int x = 0; x < 8; x++){
				if(linhaAtual + Cavalo2.getHorizontal()[x] >= minimoTabuleiro 
				   && linhaAtual + Cavalo2.getHorizontal()[x] <= maximoTabuleiro 
				   && colunaAtual + Cavalo2.getVertical()[x] >= minimoTabuleiro
			       && colunaAtual + Cavalo2.getVertical()[x] <= maximoTabuleiro){
					if(acessabilidade[linhaAtual + Cavalo2.getHorizontal()[x]][colunaAtual + Cavalo2.getVertical()[x]] > 0){
						acessabilidade[linhaAtual + Cavalo2.getHorizontal()[x]][colunaAtual + Cavalo2.getVertical()[x]]--;
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
					if(linhaAtual + Cavalo2.getHorizontal()[x] >= minimoTabuleiro 
					   && linhaAtual + Cavalo2.getHorizontal()[x] <= maximoTabuleiro 
					   && colunaAtual + Cavalo2.getVertical()[x] >= minimoTabuleiro
					   && colunaAtual + Cavalo2.getVertical()[x] <= maximoTabuleiro){
						
						linhaAcessabilidade = linhaAtual + Cavalo2.getHorizontal()[x];
						colunaAcessabilidade = colunaAtual + Cavalo2.getVertical()[x];
						
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
				
				
			
				
			}while(linhaAtual + Cavalo2.getHorizontal()[jogada] < minimoTabuleiro 
					|| linhaAtual + Cavalo2.getHorizontal()[jogada] > maximoTabuleiro 
					|| colunaAtual + Cavalo2.getVertical()[jogada] < minimoTabuleiro
					|| colunaAtual + Cavalo2.getVertical()[jogada] > maximoTabuleiro);
			
			
			
			linhaAtual += Cavalo2.getHorizontal()[jogada];
			colunaAtual += Cavalo2.getVertical()[jogada];
			
			tabuleiro[linhaAtual][colunaAtual] = i+1;
			
			
			}
		

	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(jogadaAtual <= 64) {
			
			final int[] casaAtual = retornaProximaJogada();
			
			casaTabuleiro[casaAtual[0]][casaAtual[1]].setText(String.format("%d", jogadaAtual++));
			
			repaint();
		}else {
			
			tempo.stop();
			
		}
		
	
		
		
	}
	
	public int[] retornaProximaJogada() {
		
		int[] posicao = new int[2];
		
		for(int i = 0; i < 8; i++) {
			
			for(int j = 0; j < 8; j++) {
				
				if(tabuleiro[i][j] == jogadaAtual) {
					
					posicao[0] = i;
					posicao[1] = j;
					return posicao;
					
				}
				
			}
			
		}
		
		return posicao;
	}
	
	
	
}
