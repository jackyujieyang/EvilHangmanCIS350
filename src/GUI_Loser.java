import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

public class GUI_Loser implements ActionListener
{
    private JFrame parentFrame;
    private JFrame resultFrame;
    private JLabel secretWordLabel;
    private JLabel gameResultLabel;
    private JButton returnBtn;

    public GUI_Loser(String Letters, JFrame frame)
    {
       
        parentFrame = frame; //
        resultFrame = new JFrame("You are the loser!"); //
        resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //
        resultFrame.setSize(new Dimension(300,470)); //
        resultFrame.setLayout(new FlowLayout()); //
        
        secretWordLabel = new JLabel("The answer is "+Letters+"."); //
        gameResultLabel = new JLabel("You are the Loser!"); //
        returnBtn = new JButton("Return to the main menu"); //
        
        returnBtn.addActionListener(this); //
        
        ImageIcon icon = new ImageIcon("loser.gif"); //
        JLabel loserPic = new JLabel(icon); //

        
        resultFrame.add(secretWordLabel); //
        resultFrame.add(gameResultLabel); //
        resultFrame.add(returnBtn); //
        resultFrame.add(loserPic); //
        
        resultFrame.setVisible(true); //
    }
    
    public void actionPerformed(ActionEvent e)
    {
        resultFrame.dispose(); //close the window
        parentFrame.dispose(); // and the parent
    	new Start().createAndShowGUI(); // start over
    }
}