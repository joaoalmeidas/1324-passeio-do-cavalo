import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CavaloFrame extends JFrame {
	
	private JPanel panelControle;
	
	private JButton botaoIniciar;
	
	private JLabel labelTabuleiro;
	
	private Tabuleiro panelTabuleiro;
	
	public CavaloFrame() {
		
		panelControle = new JPanel();
		labelTabuleiro = new JLabel();
		botaoIniciar = new JButton("Iniciar");
		panelTabuleiro = new Tabuleiro();
		
		panelControle.add(botaoIniciar);
		panelControle.add(labelTabuleiro);
		
		add(panelControle, BorderLayout.NORTH);
		add(panelTabuleiro, BorderLayout.CENTER);
		
		
		
	}
	
}
