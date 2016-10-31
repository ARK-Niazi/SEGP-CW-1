package segp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class forget_password extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			forget_password dialog = new forget_password();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public forget_password() {
		setType(Type.POPUP);
		setBounds(100, 100, 450, 255);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(102, 205, 170));
		contentPanel.setBorder(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblEnterFavouriteCity = new JLabel("enter favourite city name :");
		lblEnterFavouriteCity.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnterFavouriteCity.setBounds(49, 42, 179, 25);
		contentPanel.add(lblEnterFavouriteCity);
		
		textField = new JTextField();
		textField.setBounds(221, 43, 158, 25);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterYourNickname = new JLabel("enter your nickname :");
		lblEnterYourNickname.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnterYourNickname.setBounds(49, 101, 179, 14);
		contentPanel.add(lblEnterYourNickname);
		
		textField_1 = new JTextField();
		textField_1.setBounds(221, 97, 158, 25);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				close();
				
			}
		});
		btnNewButton.setForeground(new Color(34, 139, 34));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(290, 143, 89, 25);
		contentPanel.add(btnNewButton);
	}
	public void close(){
		this.dispose();
	}

}
