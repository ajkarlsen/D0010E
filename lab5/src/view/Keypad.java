package view;

import model.Situation;

import javax.swing.*;
import java.awt.*;
import java.util.function.IntBinaryOperator;

public class Keypad extends JPanel {
    public Keypad(Situation situation) {
        this.setLayout(new GridLayout(4, 4, 5, 5));
        setBackground(Color.GRAY);
        setOpaque(true);

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "=", "C", "+"
        };

        for (String text : buttons) {
            try  {
                Integer.parseInt(text);
                add(new DigitButton(text, situation));
            }
            catch(Exception e) {
                if (text == "=") {
                    add(new EqualsButton(text, situation));
                } else if (text == "C"){
                    add(new CancelButton(text, situation));
                }
                else {
                    if (text == "+") {
                        add(new BinOpButton(text, situation, Integer::sum));
                    } else if (text == "-") {
                        add(new BinOpButton(text, situation, (a, b) -> a - b));
                    } else if (text == "*") {
                        add(new BinOpButton(text, situation, (a, b) -> a * b));
                    } else if (text == "/") {
                        add(new BinOpButton(text, situation, (a, b) -> a / b));
                    }
                }
            }
        }

    }

}
