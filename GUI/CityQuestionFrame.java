/*
  CityQuestionFrame.java
  The CityQuestionFrame class models a question, specifically, the city of residence.
  Instruction to fellow coder: (The golden star) "⭐" Represents the different sections of the code "⭐" (this makes it easier to find different sections; they act like subheadings)

  Programmed by: Krish Patel
  Date Created: May 11, 2023
  Last Modified By: Krish Patel
  Date Modified: May 20, 2023
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CityQuestionFrame extends JFrame implements ActionListener{

  private String theQuestion = "City of Residence";
  private String response;
  private User theUser;
  private int adminTest;

  //color scheme and fonts used
  private Color green = new Color(115,192,123);
  private Color blue = new Color(181,207,236);
  private Color darkBlue = new Color(53,63,158);
  private Font title = new Font("Arial", Font.BOLD, 48);
  private Font defaultF = new Font("Arial", Font.BOLD, 16);
  private Font subTitle = new Font("Arial", Font.BOLD, 24);

  private JButton submit;
  private JLabel question;
  private JTextField textField;
  private JPanel box;

// ⭐Contrustor methods
  /**
  * Constructor that sets the info By: Krish
  * @param user The User object
  */
  CityQuestionFrame(int a, User user){

    theUser = new User(user);
    adminTest = a;
   
    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    this.setSize(800,600);
    this.getContentPane().setBackground(blue);
    this.setTitle("Preferences Questionnaire");
    this.setLocationRelativeTo(null);
    this.setLayout(null);

    box = new JPanel();
    box.setBackground(green);
    box.setBounds(100,80,600,400);

    question = new JLabel(theQuestion);
    question.setBounds(250,130,300,50);
    question.setFont(subTitle);
    question.setVerticalAlignment(JLabel.TOP);
    question.setHorizontalAlignment(JLabel.CENTER);

    textField = new JTextField();
    textField.setBounds(250,210,300,50);
    textField.setPreferredSize(new Dimension(250,40));
    textField.setFont(defaultF);
    textField.setHorizontalAlignment(JTextField.LEFT);
    textField.setForeground(darkBlue);
    textField.setBackground(new Color(255,255,255));
    textField.setCaretColor(darkBlue);

    submit = new JButton("Submit");
    submit.setBounds(250,290,300,50);
    submit.setFocusable(false);
    submit.setFont(defaultF);
    submit.setHorizontalAlignment(JButton.CENTER);
    submit.setBackground(darkBlue);
    submit.setForeground(Color.white);
    submit.addActionListener(this);

    this.add(question);
    this.add(textField);
    this.add(submit);
    this.add(box);
    
    this.setVisible(true);
    
  }

// ⭐Public instance methods
  /**
  * Method that checks for user input By: Krish
  * @param e The ActionEvent of the user
  */
  public void actionPerformed(ActionEvent e){
    if(e.getSource()==submit){
      submit.setEnabled(false);
      response = textField.getText();
      if(textField.getText().equals("")){
        response = "N/A";
      }
      //System.out.println(response);
      this.dispose();
      User userCopy = new User(theUser);
      CountryQuestionFrame question2 = new CountryQuestionFrame(adminTest, userCopy, response);
    }
  }//end actionPerformed

}//end CityQuestionFrame class