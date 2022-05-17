package lpv.csv.view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import java.awt.Label;

public class ShowResult extends JDialog {

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
		setBounds(200, 200, 470, 240);

		
		JProgressBar barraDeNota = new JProgressBar();
		
		String nota = converteNota(inteiro, barraDeNota);
		
		setBounds(200, 200, 470, 240);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		Label notaEncontrada = new Label(nota);
		notaEncontrada.setFont(new Font("Tahoma", Font.BOLD, 14));
		notaEncontrada.setBounds(51, 58, 500, 41);
		contentPanel.add(notaEncontrada);
		
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
 }
}
