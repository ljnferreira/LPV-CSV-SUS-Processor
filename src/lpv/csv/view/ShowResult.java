package lpv.csv.view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.awt.BorderLayout;
<<<<<<< HEAD
import java.awt.Font;
import javax.swing.JButton;
=======
import java.awt.Color;
import java.awt.Font;
>>>>>>> 3758432 (feat(calculateSUSAverages): added validations on csv read and changed interface)
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
<<<<<<< HEAD
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
=======
>>>>>>> 3758432 (feat(calculateSUSAverages): added validations on csv read and changed interface)
import java.awt.Label;

public class ShowResult extends JDialog {

<<<<<<< HEAD
	/**
	 * 
	 */
=======
>>>>>>> 3758432 (feat(calculateSUSAverages): added validations on csv read and changed interface)
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	/**
	 * Create the dialog.
	 */
	public ShowResult(Double aux) {
		setType(Type.POPUP);
		setFont(new Font("Tahoma", Font.BOLD, 12));
		setTitle("Resultados SUS");
		
		int inteiro = (int) Math.round(aux);
<<<<<<< HEAD
		String nota = converteNota(inteiro);
		
		setBounds(100, 100, 470, 281);
=======
		
		JProgressBar barraDeNota = new JProgressBar();
		
		String nota = converteNota(inteiro, barraDeNota);
		
		setBounds(200, 200, 470, 240);
>>>>>>> 3758432 (feat(calculateSUSAverages): added validations on csv read and changed interface)
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
<<<<<<< HEAD
		JButton btnNewButton = new JButton("Sair"); //Botao de sair da janela (inferior)
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			System.exit(0);
			}
		});
		
		
		btnNewButton.setBounds(150, 180, 119, 41);
		contentPanel.add(btnNewButton);
		
=======
		//Widget
>>>>>>> 3758432 (feat(calculateSUSAverages): added validations on csv read and changed interface)
		Label notaEncontrada = new Label(nota);
		notaEncontrada.setFont(new Font("Tahoma", Font.BOLD, 14));
		notaEncontrada.setBounds(51, 58, 500, 41);
		contentPanel.add(notaEncontrada);
		
<<<<<<< HEAD
		JProgressBar barraDeNota = new JProgressBar();
=======
>>>>>>> 3758432 (feat(calculateSUSAverages): added validations on csv read and changed interface)
		barraDeNota.setStringPainted(true);
		barraDeNota.setBounds(51, 105, 316, 37);
		barraDeNota.setValue(inteiro);
		contentPanel.add(barraDeNota);
		
		Label mediaEncontrada = new Label("A media encontrada foi: ");
		mediaEncontrada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mediaEncontrada.setBounds(77, 22, 169, 48);
		contentPanel.add(mediaEncontrada);
		
	    BigDecimal duasCasas = new BigDecimal(aux).setScale(2, RoundingMode.HALF_UP); //para exibir em apenas duas casas decimais a nota	    
		Label mediaDouble = new Label (duasCasas.toString());
		mediaDouble.setFont(new Font("Tahoma", Font.BOLD, 20));
		mediaDouble.setBounds(252, 34, 108, 22);
		contentPanel.add(mediaDouble);
	}
	
<<<<<<< HEAD
 public String converteNota(int inteiro) {
 String nota;
 if (inteiro <= 50) {
    nota = "A media foi F, ou seja, INACEITAVEL | PIOR IMAGINAVEL";
	}
	else
	 	if (inteiro <= 60) {
	   	nota = "A media foi D, ou seja, MARGINAL | OK";
	   	}
	   	else
	   		if (inteiro <= 70) {
	   		nota = "A media foi C, ou seja, MARGINAL | BOM";
	   		}
	   		else
	   			if (inteiro <= 80)
	   				nota = "A media foi B, ou seja, ACEITAVEL | EXCELENTE";
     			else
     				nota = "A media foi A, ou seja, ACEITAVEL | MELHOR IMAGINAVEL";
 return nota;
=======
 public String converteNota(int inteiro, JProgressBar barraDeNota) {
 String nota;
 if (inteiro <= 50) {
	 	nota = "A media foi F, ou seja, INACEITAVEL | PIOR IMAGINAVEL";
    	barraDeNota.setForeground(Color.RED);
	}
	else
	 	if (inteiro <= 60) {
	 		nota = "A media foi D, ou seja, MARGINAL | OK";
	   		barraDeNota.setForeground(Color.ORANGE);
	   	}
	   	else
	   		if (inteiro <= 70) {
	   			nota = "A media foi C, ou seja, MARGINAL | BOM";
	   			barraDeNota.setForeground(Color.YELLOW);
	   		}
	   		else
	   			if (inteiro <= 80) {
	   				nota = "A media foi B, ou seja, ACEITAVEL | EXCELENTE";
 					barraDeNota.setForeground(Color.BLUE);
	   			}else {
     				nota = "A media foi A, ou seja, ACEITAVEL | MELHOR IMAGINAVEL";
     				barraDeNota.setForeground(Color.GREEN);
	   			}
 	return nota;
>>>>>>> 3758432 (feat(calculateSUSAverages): added validations on csv read and changed interface)

 }
}
