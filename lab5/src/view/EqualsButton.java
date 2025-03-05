package view;

import model.Situation;
import model.State;

import java.awt.*;

public class EqualsButton extends CalculatorButton {
    public EqualsButton(String text, Situation situation) {
        super(text, situation);
    }
    @Override
    public void transition() {
        switch (situation.state){
            case Input1:
                break;
            case OpReady:
                break;
            case HasResult:
                break;
            case Input2:
                int rightOp = Integer.parseInt(situation.display.getText());
                try {
                    int result = situation.binaryOp.operator.applyAsInt(situation.leftOperand, rightOp);
                    situation.display.setText(String.valueOf(result));
                } catch (Exception e) {
                    situation.display.setText("Erorr");
                }
                situation.state = State.HasResult;
                situation.binaryOp.setColor(Color.WHITE);
                break;

        }
    }
}