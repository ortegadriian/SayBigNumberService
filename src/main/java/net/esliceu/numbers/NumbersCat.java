package net.esliceu.numbers;

public class NumbersCat {
    public static String say(long n) {
        if (n < 0) {
            return validarNegativo(n);
        }

        switch ((int) (n)) {
            case 0:
                return "Zero";
            case 1:
                return "Un";
            case 2:
                return "Dos";
            case 3:
                return "Tres";
            case 4:
                return "Quatre";
            case 5:
                return "Cinc";
            case 6:
                return "Sis";
            case 7:
                return "Set";
            case 8:
                return "Vuit";
            case 9:
                return "Nou";
            case 10:
                return "Deu";
            case 20:
                return "Vint";
            case 30:
                return "Trenta";
            case 40:
                return "Quaranta";
            case 50:
                return "Cinquanta";
            case 60:
                return "Seixanta";
            case 70:
                return "Setanta";
            case 80:
                return "Vuitanta";
            case 90:
                return "Noranta";
        }

        if (n > 20 && n < 100) {
            return del20al100(n);
        }

        if (n >= 100 && n < 1000) {
            return CalcularNum("Cent", "-cents", n, 100);
        } else if (n >= 1000 && n < 1_000_000) {
            return CalcularNum("Mil", " mil", n, 1000);
        } else {
            return null;
        }
    }

    public static String del20al100(long n) {
        if (n > 20 && n < 100) {
            int unidad = (int) n % 10;
            int decena = 10 * ((int) n / 10);
            if (n >= 21 && n <= 29) {
                return say(decena) + "-i-" + say(unidad).toLowerCase();
            }
            return say(decena) + "-" + say(unidad).toLowerCase();
        }
        return null;
    }

    public static String validarNegativo(long n) {
        if (n < 0) {
            return "Menys " + say(-n).toLowerCase();
        } else return "";
    }

    public static String CalcularNum(String UDtextEscala, String textEscala, long n, int div) {
        int numEscala = (int) (n / div);
        int rest = (int) n % div;
        String resFinal;
        resFinal = numEscala == 1 ? UDtextEscala : say(numEscala) + textEscala;
        resFinal += rest != 0 ? " " + say(rest).toLowerCase() : "";
        return resFinal;
    }
}
