package lpv.csv.view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Label;

public class ShowResult extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args, double Double) {
		try {
			ShowResult dialog = new ShowResult(Double);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ShowResult(Double aux) {
		setType(Type.POPUP);
		setFont(new Font("Tahoma", Font.BOLD, 12));
		setTitle("Resultados SUS");
		
		int inteiro = (int) Math.round(aux);
		String nota = converteNota(inteiro);
		
		setBounds(100, 100, 470, 281);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("Sair"); //Botao de sair da janela (inferior)
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			System.exit(0);
			}
		});
		
		
		btnNewButton.setBounds(150, 180, 119, 41);
		contentPanel.add(btnNewButton);
		
		Label notaEncontrada = new Label(nota);
		notaEncontrada.setFont(new Font("Tahoma", Font.BOLD, 14));
		notaEncontrada.setBounds(51, 58, 500, 41);
		contentPanel.add(notaEncontrada);
		
		JProgressBar barraDeNota = new JProgressBar();
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

 }
}
