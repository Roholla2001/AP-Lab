public enum Operator {
    ADD, SUBTRACT, MULTIPLY, DIVIDE, MOD;
//    SIN, COS, TAN, COT, EXP, LOG, PI, E;

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
        }
        return "###";
    }
}
