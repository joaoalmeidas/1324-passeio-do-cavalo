import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tabuleiro extends JPanel {
	
	private int[][] acessabilidade = {{2, 3, 4, 4, 4, 4, 3, 2},
			  {3, 4, 6, 6, 6, 6, 4, 3},
			  {4, 6, 8, 8, 8, 8, 6, 4},
			  {4, 6, 8, 8, 8, 8, 6, 4},
			  {4, 6, 8, 8, 8, 8, 6, 4},
			  {4, 6, 8, 8, 8, 8, 6, 4},
			  {3, 4, 6, 6, 6, 6, 4, 3},
			  {2, 3, 4, 4, 4, 4, 3, 2}
			  };
	
	private JTextField[][] casaTabuleiro;
	
	public Tabuleiro() {
		
		setLayout(new GridLayout(8, 8));
		casaTabuleiro = new JTextField[8][8];
		
		for(int i = 0; i < casaTabuleiro.length; i++) {
			
			for(int j = 0; j < casaTabuleiro[0].length; j++) {
				
				casaTabuleiro[i][j] = new JTextField();
				//casaTabuleiro[i][j].setEditable(false);
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
	
	
	
}
