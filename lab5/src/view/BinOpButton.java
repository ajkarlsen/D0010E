package view;

import model.Situation;
import model.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.IntBinaryOperator;


public class BinOpButton extends CalculatorButton {

    protected IntBinaryOperator operator;

    public BinOpButton(String text, Situation situation, IntBinaryOperator operator) {
        super(text, situation);
        this.operator = operator;

    }

    @Override
    public void transition() {
        switch (situation.state) {
            case Input1:
                situation.leftOperand = Integer.parseInt(situation.display.getText());

                situation.state = State.OpReady;
                if (situation.binaryOp != null) {
                    situation.binaryOp.setColor(Color.WHITE);
                }
                setColor(Color.CYAN);
                situation.binaryOp = this;
                break;
            case OpReady:
                if (situation.binaryOp != null) {
                    situation.binaryOp.setColor(Color.WHITE);
                }
                setColor(Color.CYAN);
                situation.binaryOp = this;

                break;
            case Input2:
                break;

            case HasResult:
                situation.leftOperand = Integer.parseInt(situation.display.getText());
                situation.binaryOp = this;

                situation.state = State.OpReady;
        }
    }

}
