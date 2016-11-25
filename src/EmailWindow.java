import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmailWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailWindow frame = new EmailWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmailWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageWindow message = new MessageWindow(); //create new window object
				
				setVisible(false); //hides this window
				
				message.setVisible(true); //opens the next window
			}
		});
		btnBack.setBounds(6, 243, 117, 29);
		contentPane.add(btnBack);
		
		JLabel lblEmails = new JLabel("Emails");
		lblEmails.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblEmails.setBounds(192, 17, 80, 29);
		contentPane.add(lblEmails);
	}

}
