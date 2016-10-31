package segp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Window.Type;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setBounds(100, 100, 450, 320);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(102, 205, 170));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName : ");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setBackground(Color.ORANGE);
		lblUsername.setBounds(47, 59, 79, 22);
		contentPanel.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(136, 59, 220, 25);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(47, 113, 79, 22);
		contentPanel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(136, 113, 220, 25);
		contentPanel.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setForeground(new Color(34, 139, 34));
		btnLogin.setBounds(136, 191, 72, 25);
		contentPanel.add(btnLogin);
		
		JButton btnForgetPassword = new JButton("Forget password");
		btnForgetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forget_password f= new forget_password();
				f.setVisible(true);
				close();
				
			}
		});
		btnForgetPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnForgetPassword.setForeground(new Color(34, 139, 34));
		btnForgetPassword.setBounds(218, 191, 138, 25);
		contentPanel.add(btnForgetPassword);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLogin.setBounds(185, 11, 94, 25);
		contentPanel.add(lblLogin);
		
		JLabel wrong_username = new JLabel("wrong username");
		wrong_username.setFont(new Font("Tahoma", Font.PLAIN, 10));
		wrong_username.setForeground(new Color(255, 0, 0));
		wrong_username.setHorizontalAlignment(SwingConstants.RIGHT);
		wrong_username.setBounds(218, 86, 138, 14);
		contentPanel.add(wrong_username);
		
		JLabel wrong_pass = new JLabel("wrong password");
		wrong_pass.setFont(new Font("Tahoma", Font.PLAIN, 10));
		wrong_pass.setForeground(new Color(255, 0, 0));
		wrong_pass.setHorizontalAlignment(SwingConstants.RIGHT);
		wrong_pass.setBounds(218, 140, 138, 14);
		contentPanel.add(wrong_pass);
	}
	public void close()
	{
		this.dispose();
	}
}
