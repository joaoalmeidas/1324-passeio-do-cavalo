import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
		maximoTabuleiro = acessabilidade[0].length;
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
		

	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		for(int i = 0; i < 8; i++) {
			
			for(int j = 0; j < 8; j++) {
				
				
				
			}
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
		
	}
	
	
	
	
	
}
