import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI_Result implements ActionListener {

	private JFrame parentFrame;
	private JFrame resultFrame; // The original winner- or loserFrame
	private JLabel secretWordLabel;
	private JLabel gameResultLabel;
	private JButton returnBtn;
	// The following two fields are used only for Winner
	private ImageIcon background;
	private JPanel imagePanel;

	public GUI_Result(String Letters, JFrame frame, boolean isWin) {
		parentFrame = frame;
		secretWordLabel = new JLabel("The answer is " + Letters + ".");

		if (isWin) {
			resultFrame = new JFrame("You are the winner!!!");
		
			background = new ImageIcon("Congrats.gif");
			JLabel label = new JLabel(background);
			label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
			imagePanel = (JPanel) resultFrame.getContentPane();
			imagePanel.setOpaque(false);
			imagePanel.setLayout(new FlowLayout());
			
			resultFrame.getLayeredPane().setLayout(null);
			resultFrame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
			resultFrame.setSize(background.getIconWidth(), background.getIconHeight());
			resultFrame.setResizable(false);
			
			secretWordLabel.setFont(new Font("Default", Font.PLAIN, 23));
			secretWordLabel.setForeground(Color.red);
			gameResultLabel = new JLabel("You are winner!");
		} else {
			resultFrame = new JFrame("You are the loser!");
			gameResultLabel = new JLabel("You are the Loser!");
			resultFrame.setSize(new Dimension(300, 470));
			resultFrame.setLayout(new FlowLayout());
			ImageIcon icon = new ImageIcon("loser.gif");
			JLabel loserPic = new JLabel(icon);
			resultFrame.add(loserPic);
		}

		returnBtn = new JButton("Return to the main menu");
		returnBtn.addActionListener(this);

		resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		resultFrame.add(secretWordLabel);
		resultFrame.add(gameResultLabel);
		resultFrame.add(returnBtn);
		resultFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		resultFrame.dispose(); // close the window
		parentFrame.dispose(); // and the parent
		new Start().createAndShowGUI(); // start over

	}

}
