package lpv.csv.view;

import static lpv.csv.controller.DataController.*;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class RootScreen {

	private JFrame frmAplicativo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RootScreen window = new RootScreen();
					window.frmAplicativo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public RootScreen() {
		initialize();
	}

	private void initialize() {
		
<<<<<<< HEAD
=======
		//Container of application
>>>>>>> 3758432 (feat(calculateSUSAverages): added validations on csv read and changed interface)
		frmAplicativo = new JFrame();
		frmAplicativo.setTitle("Calcular SUS");
		frmAplicativo.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmAplicativo.setFont(new Font("Dialog", Font.PLAIN, 10));
		frmAplicativo.setBounds(100, 100, 435, 253);
		frmAplicativo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAplicativo.getContentPane().setLayout(null);
		
<<<<<<< HEAD
=======
		//widget that displays a text to the user
>>>>>>> 3758432 (feat(calculateSUSAverages): added validations on csv read and changed interface)
		JLabel lblNome = new JLabel("Selecione o arquivo .csv que contem os dados da pesquisa SUS");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(16, 45, 393, 23);
		frmAplicativo.getContentPane().add(lblNome);
		
		//Widget
		JButton btnAbrirArquivo = new JButton("Abrir Arquivo\r\n");
		
		btnAbrirArquivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		//Associating a callback function to the click event 
		btnAbrirArquivo.addActionListener(new ActionListener() {
			//Callback Function that handle the click on button and calls specific functionality
			public void actionPerformed(ActionEvent e) {
				String pathArquivo = abrirArquivos();
				if(pathArquivo != "") {
					try {
<<<<<<< HEAD
						ShowResult newWindow = new ShowResult(getSUSFinalGrade(pathArquivo));
						newWindow.setVisible(true);
=======
						double result = getSUSFinalGrade(pathArquivo);
						if(result >=0) {
							ShowResult newWindow = new ShowResult(result);
							newWindow.setVisible(true);
						}else {
							if(result == -1) {
								JOptionPane.showMessageDialog(frmAplicativo, "Arquivo CSV vazio!", "Erro na abertura do arquivo", JOptionPane.ERROR_MESSAGE);
							}else {
								if(result== -2) {
									JOptionPane.showMessageDialog(frmAplicativo, "Formato de CSV invalido!", "Erro na abertura do arquivo", JOptionPane.ERROR_MESSAGE);
								}else {
									if(result == -3) {
										JOptionPane.showMessageDialog(frmAplicativo, 
																"Algum registro foi preenchido incorretamente, favor verificar no arquivo se todos os valores estão entre 1 e 5!",
																"Erro na leitura do arquivo",
																JOptionPane.ERROR_MESSAGE);
									}
								}
							}
						}
						
>>>>>>> 3758432 (feat(calculateSUSAverages): added validations on csv read and changed interface)
					}catch (Exception exc) {
						exc.printStackTrace();
					}
				}
			}
		});
		btnAbrirArquivo.setBounds(127, 125, 143, 23);
		frmAplicativo.getContentPane().add(btnAbrirArquivo);
	}
	
	private String abrirArquivos() {
		//File chooser widget
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".csv", "csv"));
		fileChooser.setAcceptAllFileFilterUsed(false);
	    int returnValue = fileChooser.showOpenDialog(null);
	    if (returnValue == JFileChooser.CANCEL_OPTION) {
	    	return "";
	    }
	    File selectedFile = fileChooser.getSelectedFile();
    	return selectedFile.getPath();
	}
}
