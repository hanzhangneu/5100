import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class TwoNumbersCalculator extends JFrame {

private double numbers1;
private double numbers2;
private byte number = -1;


private JTextField result;

public TwoNumbersCalculator() {

    JButton[] numberButtons = new JButton[10];

    for ( int i = 9; i >= 0; i--) {
        numberButtons[i] = new JButton(Integer.toString(i));
    }



    JButton calculation = new JButton("calculate");

    JButton multiply = new JButton("*");

    JButton divide = new JButton("/");

    JButton add = new JButton("+");

    JButton substract = new JButton("-");







    result = new JTextField();

        result.setPreferredSize(new Dimension(250, 40));





    JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));



    JPanel textP = new JPanel();

        textP.setPreferredSize(new Dimension(160, 20));

        textP.add(result);



    JPanel numberP = new JPanel();

        numberP.setPreferredSize(new Dimension(160, 100));



        for(int i = 9; i>=0; i--) {

            numberP.add(numberButtons[i]);

        }



    JPanel functionP = new JPanel();

        functionP.setPreferredSize(new Dimension(160, 35));

        functionP.add(calculation);

        functionP.add(multiply);

        functionP.add(divide);

        functionP.add(add);

        functionP.add(substract);



    numberButtonsAction[] numberButtonActions = new numberButtonsAction[10];

    for ( int i = 0; i < 10; i++ ) {

        numberButtonActions[i] = new numberButtonsAction(numberButtons[i]);

        numberButtons[i].addActionListener(numberButtonActions[i]);

    }



    EnterButton calculate = new EnterButton();

        calculation.addActionListener(calculate);



    MultiplyButton multiplyFunction = new MultiplyButton();

        multiply.addActionListener(multiplyFunction);



    DivideButton divideFunction = new DivideButton();

        divide.addActionListener(divideFunction);



    AddButton addFunction = new AddButton();

        add.addActionListener(addFunction);



    SubtractButton subtractFunction = new SubtractButton();

        substract.addActionListener(subtractFunction);



    panel.add(textP);

    panel.add(numberP);

    panel.add(functionP);

    add(panel);



    setSize(500, 500);

    setVisible(true);



}



private class numberButtonsAction implements ActionListener {



    private String c;



    public numberButtonsAction(JButton a) {

        this.c = a.getText();

    }



    public void actionPerformed(ActionEvent e) {

        if (!result.getText().equals("0.0")) {

            result.setText(result.getText() + c);

        } else {

            result.setText("");

            actionPerformed(e);

        }

    }

}



private class EnterButton implements ActionListener {



    @Override

    public void actionPerformed(ActionEvent e) {

        numbers2 = Double.parseDouble(result.getText());



        if (number == 0) {

            result.setText(Double.toString((Math.round((numbers1 / numbers2) * 100)) / 100));

        } else if (number == 1) {

            result.setText(Double.toString(numbers1 * numbers2));

        } else if (number == 2) {

            result.setText(Double.toString(numbers2 + numbers1));

        } else if (number == 3) {

            result.setText(Double.toString(numbers1 - numbers2));

        } else {

            result.setText(String.valueOf(numbers1));

        }

            numbers1 = Double.parseDouble(result.getText());

    }





}





private class DivideButton implements ActionListener {



    @Override

    public void actionPerformed(ActionEvent e) {

        if (numbers1 == 0) {

            numbers1 = Double.parseDouble(result.getText());

            result.setText("");

        } else {

        	numbers2 = Double.parseDouble(result.getText());

            result.setText("");

        }

        number = 0;

    }



}



private class MultiplyButton implements ActionListener {



    @Override

    public void actionPerformed(ActionEvent e) {

        if (numbers1 == 0) {

            numbers1 = Double.parseDouble(result.getText());

            result.setText("");

        } else {

            numbers2 = Double.parseDouble(result.getText());

            result.setText("");

        }

        number = 1;

    }





}





private class AddButton implements ActionListener {



    @Override

    public void actionPerformed(ActionEvent e) {

        if (numbers1 == 0) {

            numbers1 = Double.parseDouble(result.getText());

            result.setText("");

        } else {

            numbers2 = Double.parseDouble(result.getText());

            result.setText("");

        }

        number = 2;

    }



}



private class SubtractButton implements ActionListener {



    @Override

    public void actionPerformed(ActionEvent e) {

        if (numbers1 == 0) {

            numbers1 = Double.parseDouble(result.getText());

            result.setText("");

        } else {

            numbers2 = Double.parseDouble(result.getText());

            result.setText("");

        }

        number = 3;

    }



}

public static void main(String[] args) {

	new TwoNumbersCalculator();



}

}