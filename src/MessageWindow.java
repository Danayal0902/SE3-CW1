import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MessageWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtHeader;
	private JTextField txtBody;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessageWindow frame = new MessageWindow();
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
	public MessageWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtHeader = new JTextField();
		txtHeader.setToolTipText("Enter a header here...");
		txtHeader.setBounds(111, 79, 234, 26);
		contentPane.add(txtHeader);
		txtHeader.setColumns(10);
		
		JLabel lblHeader = new JLabel("Header:");
		lblHeader.setBounds(38, 84, 61, 16);
		contentPane.add(lblHeader);
		
		JLabel lblBody = new JLabel("Body:");
		lblBody.setBounds(38, 147, 61, 16);
		contentPane.add(lblBody);
		
		txtBody = new JTextField();
		txtBody.setToolTipText("Enter your Message here...");
		txtBody.setBounds(111, 117, 234, 114);
		contentPane.add(txtBody);
		txtBody.setColumns(10);
		
		JButton btnSendMessage = new JButton("Send Message");
		btnSendMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MessageProcessor mp = new MessageProcessor(); //creates a new message processor object
				
				//the message object becomes the contents of the header and body
				Message m = new Message(txtHeader.getText(), txtBody.getText()); 
				
				//process the message and output to file in src
				mp.ProcessMessage(m);
				
				
			}
		});
		
		
		btnSendMessage.setToolTipText("Send Message");
		btnSendMessage.setBounds(162, 243, 117, 29);
		contentPane.add(btnSendMessage);
		
		JLabel lblNapier = new JLabel("Napier Bank");
		lblNapier.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNapier.setBounds(162, 28, 135, 34);
		contentPane.add(lblNapier);
	}
}
