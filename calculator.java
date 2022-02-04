//Advanced security Lab 1
//C18302166
//calculator GUI
//Date of completion: 23/09/2021

package calculator;

//imported packages
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class calculator extends JFrame implements ActionListener { 
    //setting all parts of the GUI
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functioButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, eqButton, delButton, clrButton, negButton;
    JPanel panel;

    //setting font for text on buttons
    Font myFont = new Font("Calibri", Font.BOLD, 30);

    //folowing variables will hond numbers clicked the result of the arithmetic
    double arg1=0,arg2=0, result=0;
    char operator;

    calculator(){
        //setting the frame
        frame = new JFrame("My Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        //setting the textfield
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        //seeting buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        delButton = new JButton("DEL");
        decButton = new JButton(".");
        clrButton = new JButton("CLEAR");
        negButton = new JButton("(-)");

        //function buttons when clicked will run a calculation function
        functioButtons[0] = addButton;
        functioButtons[1] = subButton;
        functioButtons[2] = mulButton;
        functioButtons[3] = divButton;
        functioButtons[4] = eqButton;
        functioButtons[5] = delButton;
        functioButtons[6] = decButton;
        functioButtons[7] = clrButton;
        functioButtons[8] = negButton;

        //for loop that sets the fonts of the text on the buttons
        for(int i = 0; i < 8;i++){
            functioButtons[i].addActionListener(this);
            functioButtons[i].setFont(myFont);
            //remove outline on buttons
            functioButtons[i].setFocusable(false);

        }

        for(int i = 0; i < 10;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            //remove outline on buttons
            numberButtons[i].setFocusable(false);
            
        }

        //sets position for delete,clear and negative buttons
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        //setting up the panel
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.WHITE);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);

        //setting the frame of the GUI
        frame.add(panel);
        frame.add(textfield);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.setVisible(true);

    }


    public static void main(String[] args){
        calculator calc = new calculator();
    }

    public void actionPerformed(ActionEvent e){
        for(int i = 0; i < 10;i++){
            if(e.getSource() == numberButtons[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }

    }
    //puts decimal in the textfield
    if(e.getSource()==decButton){
        textfield.setText(textfield.getText().concat("."));
    }
    //puts plus sign in the text field
    if(e.getSource()==addButton){
        arg1 = Double.parseDouble(textfield.getText());
        operator = '+';
        textfield.setText("");

    }
    //puts minus sign in the the text field
    if(e.getSource()==subButton){
        arg1 = Double.parseDouble(textfield.getText());
        operator = '-';
        textfield.setText("");

    }

    //set functionality to the multiplication button
    if(e.getSource()==mulButton){
        arg1 = Double.parseDouble(textfield.getText());
        operator = 'x';
        textfield.setText("");

    }
    //set functionality to the division button
    if(e.getSource()==divButton){
        arg1 = Double.parseDouble(textfield.getText());
        operator = '/';
        textfield.setText("");

    }

    if(e.getSource()==eqButton){
        arg2 = Double.parseDouble(textfield.getText());
        
        //switch statement that sets the operations of the symbols when the equals sign is clicked
        switch(operator){
            case'+':
                result = arg1 + arg2;
                break;
            case'-':
                result = arg1 - arg2;
                break;
            case'x':
                result = arg1 * arg2;
                break;
            case'/':
                result = arg1 / arg2;
                break;

        }

        textfield.setText(String.valueOf(result));
        arg1=result;
    
    }
    if(e.getSource()==clrButton){
        textfield.setText("");

    }
    //settimg functoonality of the delete buttom
    if(e.getSource()==delButton){
        String string = textfield.getText();
        textfield.setText("");
        for(int i=0;i<string.length() -1;i++){
            textfield.setText(textfield.getText()+string.charAt(i));
        }

    }

    //this code will set the number to a negative number when the neg button is clicked
    if(e.getSource()==negButton){
        double temp = Double.parseDouble(textfield.getText());
        temp*=-1;
        textfield.setText(String.valueOf(temp));

    }
    
}

}
