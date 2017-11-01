package Tzadikim;

public enum TaxLevel{// enum for calculating a tax for member
    FIRST ,SECOND, THIRD , FORTH ,FIFTH ,SIXTH ,MAX;

    public int levelToTax() {
        switch (this) {
            case FIRST:
                return 0;
            case SECOND:
                return 5280;
            case THIRD:
                return 9010;
            case FORTH:
                return 14000;
            case FIFTH:
                return 20000;
            case SIXTH:
                return 41830;
            case MAX:
                return 67630;
            default:
                return 0;
        }
    }
}
