package model;

import view.BinOpButton;

import javax.swing.*;

public class Situation {
    public State state = State.Input1;
    public JLabel display;
    public BinOpButton binaryOp;
    public int leftOperand;

    public Situation(JLabel display) {
        this.display = display;
    }
}
