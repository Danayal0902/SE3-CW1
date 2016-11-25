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

public class TweetWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TweetWindow frame = new TweetWindow();
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
	public TweetWindow() {
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
		btnBack.setBounds(0, 243, 117, 29);
		contentPane.add(btnBack);
		
		JLabel lblTweetScreen = new JLabel("Tweet Screen");
		lblTweetScreen.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTweetScreen.setBounds(173, 25, 143, 29);
		contentPane.add(lblTweetScreen);
	}
}
