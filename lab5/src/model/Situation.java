package model;

import view.BinOpButton;

import javax.swing.*;
import java.util.function.BinaryOperator;

public class Situation {
    public State state = State.Input1;
    public JLabel display;
    public BinOpButton binaryOp;
    public int leftOperand;

    public Situation(JLabel display) {
        this.display = display;
    }
}
