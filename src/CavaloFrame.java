import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

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
		
		
		panelControle.add(botaoIniciar);
		panelControle.add(labelTabuleiro);
		
		add(panelControle, BorderLayout.NORTH);
		
		botaoIniciar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				panelTabuleiro = new Tabuleiro();
				add(panelTabuleiro);
				
				labelTabuleiro.setText(panelTabuleiro.getPasseio());
				panelControle.repaint();
				System.out.println(panelTabuleiro.getPasseio());
				

				
				System.out.println(panelTabuleiro.getPasseio());
				
			}
			
			
		});
		
		repaint();
		
		
		
		
	}
	
}
