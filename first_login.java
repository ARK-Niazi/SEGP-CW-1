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
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class first_login extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			first_login dialog = new first_login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public first_login() {
		setBounds(100, 100, 450, 320);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(102, 205, 170));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblLogin = new JLabel("Login");
			lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblLogin.setBounds(157, 11, 95, 22);
			contentPanel.add(lblLogin);
		}
		{
			JButton btnNewButton = new JButton("SSO Login");
			btnNewButton.setForeground(new Color(34, 139, 34));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Login log =new Login();
					log.setVisible(true);
			
					close();
				}
			});
			btnNewButton.setBounds(107, 71, 195, 43);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("Registrar Login");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Login log =new Login();
					log.setVisible(true);
			
					close();
				}
			});
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewButton_1.setForeground(new Color(0, 128, 0));
			btnNewButton_1.setBounds(107, 125, 195, 43);
			contentPanel.add(btnNewButton_1);
		}
	}
	public void close(){
		this.dispose();
	}

}
