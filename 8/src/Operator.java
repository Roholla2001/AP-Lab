import java.awt.*;
import java.awt.event.KeyEvent;

public enum Operator {
    ADD, SUBTRACT, MULTIPLY, DIVIDE, MOD,
    SIN, COS, TAN, COT;
//    EXP, LOG;

    public String toString() {
        switch(this) {
            case ADD:
                return " + ";
            case SUBTRACT:
                return " - ";
            case MULTIPLY:
                return " * ";
            case DIVIDE:
                return " / ";
            case MOD:
                return " % ";
            case SIN:
                return "sin";
            case COS:
                return "cos";
            case TAN:
                return "tan";
            case COT:
                return "cot";

        }
        return "###";
    }

    public boolean isSingleInput() {
        return this == SIN || this == COS || this == TAN || this == COT;
    }

    public int toKeyCode() {
        switch(this) {
            case ADD:
                return KeyEvent.VK_EQUALS;
            case SUBTRACT:
                return KeyEvent.VK_MINUS;
            case MULTIPLY:
                return KeyEvent.VK_8;
            case DIVIDE:
                return KeyEvent.VK_SLASH;
            case MOD:
                return KeyEvent.VK_5;
        }
        return 0;
    }
}
