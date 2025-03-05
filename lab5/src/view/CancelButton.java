package view;

import model.Situation;
import model.State;

import java.awt.*;

public class CancelButton extends CalculatorButton {
    public CancelButton(String text, Situation situation) {
        super(text, situation);
    }

    @Override
    public void transition() {
        situation.binaryOp.setColor(Color.WHITE);
        situation.display.setText("0");
        situation.leftOperand = 0;
        situation.binaryOp = null;
        situation.state = State.Input1;
    }

}