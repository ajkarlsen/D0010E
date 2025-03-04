package view;

import model.Situation;
import model.State;

import java.awt.*;
import java.awt.event.ActionEvent;

public class DigitButton extends CalculatorButton {

    public DigitButton(String text, Situation situation) {
        super(text, situation);
    }

    @Override
    public void transition(){
        switch(situation.state){
            case Input1:
                if (situation.display.getText() == "0") {
                    situation.display.setText(super.getText());
                    situation.leftOperand = Integer.parseInt(super.getText());
                } else {
                    situation.leftOperand = Integer.parseInt(situation.display.getText() + super.getText());
                    situation.display.setText(String.valueOf(situation.leftOperand));
                }
                break;
            case OpReady:
                situation.state = State.Input2;
                situation.display.setText(super.getText());
                break;

            case Input2:
                situation.display.setText(situation.display.getText() + super.getText());
                break;

            case HasResult:
                situation.state = State.Input1;
                situation.display.setText(super.getText());
                break;


        }


    }
}