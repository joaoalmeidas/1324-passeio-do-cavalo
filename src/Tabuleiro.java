import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
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
	
	private JPanel[][] casaTabuleiro;
	
	private Random aleatorio = new Random();
	
	private Cavalo2 cavalo;
	
	private Timer tempo ;
	
	private int linhaAtual, colunaAtual, jogada, maximoTabuleiro, minimoTabuleiro, linhaAcessabilidade, colunaAcessabilidade; 
	
	
	public Tabuleiro() {
		
		setLayout(new GridLayout(8, 8));
		casaTabuleiro = new JPanel[8][8];
		
		tempo = new Timer(1000, this);
		tempo.start();
		
		cavalo = new Cavalo2();
		
		linhaAtual = aleatorio.nextInt(8);
		colunaAtual = aleatorio.nextInt(8);	
		jogada = 0;
		tabuleiro = new int[8][8];
		maximoTabuleiro = acessabilidade[0].length - 1;
		minimoTabuleiro = 0;
		
		for(int i = 0; i < casaTabuleiro.length; i++) {
			
			for(int j = 0; j < casaTabuleiro[0].length; j++) {
				
				
				casaTabuleiro[i][j] = new JPanel();
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
			System.out.printf("Jogada nº%d\n", i+1);
			
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
			
			System.out.println(linhaAtual);
			System.out.println(colunaAtual);
			
			}
		

	}
	
	@Override
	public void paintComponent(Graphics g) {

		

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		casaTabuleiro[aleatorio.nextInt(8)][aleatorio.nextInt(8)].setBackground(Color.BLUE);
		
		repaint();
		
	}
	
	
	
	
	
}
