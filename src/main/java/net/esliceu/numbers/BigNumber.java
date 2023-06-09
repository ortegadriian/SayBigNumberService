package net.esliceu.numbers;

import static java.lang.Integer.*;
import static java.lang.Long.parseLong;

public class BigNumber {

    String valor;

    // Constructor 1
    public BigNumber(String s) {
        this.valor = s;
        this.valor = eliminaCeros();
    }

    // Constructor 2
    public BigNumber(BigNumber b) {
    }

    // Suma
    public BigNumber add(BigNumber other) {
        BigNumber b = other;
        añadeCeros(b);
        String retorno = suma(this.valor, b.valor);
        return new BigNumber(retorno);
    }

    // Resta
    public BigNumber sub(BigNumber other) {
        BigNumber b = other;
        añadeCeros(other);
        String resultado = resta(this.valor, b.valor);
        return new BigNumber(resultado);
    }

    private String resta(String parametro1, String parametro2) {
        int residuo = 0;
        int resta = 0;
        String resultado = "";
        for (int i = parametro1.length() - 1; i >= 0; i--) {
            String numero1 = "" + parametro1.charAt(i);
            int num1 = parseInt(numero1);
            String numero2 = "" + parametro2.charAt(i);
            int num2 = parseInt(numero2);

            if (residuo == 1) {
                num1 = num1 - 1;
            }
            resta = num1 - num2;
            if (resta < 0) {
                num1 = num1 + 10;
                resta = num1 - num2;
                resultado = resta + resultado;
                residuo = 1;
            } else {
                resultado = resta + resultado;
                residuo = 0;
            }
        }

        return (resultado);
    }

    // Multiplica
    public BigNumber mult(Object other) {
        BigNumber b = (BigNumber) other;
        String resultado = multiplicacion(this.valor, b.valor);
        return new BigNumber(resultado);
    }

    // Divideix
    public BigNumber div(Object other) {
        BigNumber b = (BigNumber) other;

        int division = 0;
        int comparar = comparar(this.valor, b.valor);

        //Parametro 1 == dividendo Parametro 2 == divisor
        String parametro1 = this.valor;
        String parametro2 = b.valor;

        String dividendo = "";
        String resDividendo;
        String cociente = "";

        String rest;


        if (comparar == -1) {
            return new BigNumber("0");
        }
        if (comparar == 0) {
            return new BigNumber("1");
        } else {
            for (int i = 0; i < parametro1.length(); i++) {
                dividendo = dividendo + parametro1.charAt(i);
                if (comparar(dividendo, parametro2) == -1) {
                    dividendo = dividendo + parametro1.charAt(i + 1);
                    i++;
                }
                int j;
                for (j = 1; j < 10; j++) {
                    resDividendo = multiplicacion(parametro2, String.valueOf(j));
                    if (comparar(dividendo, resDividendo) == 0) {
                        cociente = cociente + j;
                        break;
                    } else if (comparar(dividendo, resDividendo) == -1) {
                        cociente = cociente + (j - 1);
                        break;
                    }

                }
                dividendo = resta(dividendo, multiplicacion(parametro2, Integer.toString(j)));

                while (dividendo.charAt(0) == '0' && dividendo.length() > 1) {
                    dividendo = dividendo.substring(1);
                }

            }

        }
        return new BigNumber((cociente));
    }


    // Arrel quadrada
    public BigNumber sqrt() {
        return null;
    }

    // Potència
    public BigNumber power(int n) {
        String resultado = this.valor;
        for (int i = 0; i < n - 1; i++) {
            resultado = multiplicacion(resultado, this.valor);
        }
        return new BigNumber(resultado);
    }

    // Factorial
    public BigNumber factorial() {
        String result = this.valor;
        int s = Integer.parseInt(this.valor);
        for (int i = 1; i < s; i++) {
            result = multiplicacion(result, String.valueOf(i));
        }
        return new BigNumber(result);
    }

    // MCD. Torna el Màxim comú divisor
    public BigNumber mcd(BigNumber other) {
        return null;
    }

    // Compara dos BigNumber. Torna 0 si són iguals, -1
// si el primer és menor i torna 1 si el segon és menor
    public int compareTo(BigNumber other) {
        BigNumber b = other;
        return comparar(this.valor, b.valor);
    }

    private int comparar(String parametro1, String parametro2) {
        if (parametro1.length() == parametro2.length()) {
            for (int i = 0; i < parametro1.length(); i++) {
                if (parametro1.charAt(i) < parametro2.charAt(i)) return -1;
                else if (parametro1.charAt(i) > parametro2.charAt(i)) return 1;
            }
            return 0;
        } else if (parametro1.length() > parametro2.length()) return 1;
        else return -1;
    }

    // Torna un String representant el número
    public String toString() {
        return this.valor;
    }

    // Mira si dos objectes BigNumber són iguals
    public boolean equals(Object other) {
        BigNumber b = (BigNumber) other;
        return b.valor.equals(this.valor);
    }

    public String eliminaCeros() {
        while (this.valor.charAt(0) == '0' && this.valor.length() > 1) {
            this.valor = this.valor.substring(1);
        }
        return this.valor;
    }

    private void añadeCeros(Object other) {
        BigNumber b = (BigNumber) other;
        while (this.valor.length() != b.valor.length()) {
            if (this.valor.length() > b.valor.length()) {
                b.valor = "0" + b.valor;
            } else {
                this.valor = "0" + this.valor;
            }
        }
    }

    public String suma(String parametro1, String parametro2) {
        int suma;
        int sobrante;
        int residuo = 0;

        String resultado = "";

        for (int k = parametro1.length() - 1; k >= 0; k--) {
            String numtxt1 = "" + parametro1.charAt(k);
            int num1 = Integer.parseInt(numtxt1);
            String numtxt2 = "" + parametro2.charAt(k);
            int num2 = Integer.parseInt(numtxt2);
            suma = num1 + num2;
            sobrante = suma % 10;
            if (sobrante + residuo >= 10) {
                resultado = 0 + resultado;
                residuo = 1;
            } else {
                resultado = (sobrante + residuo) + resultado;
                residuo = suma / 10;
            }
            if (residuo == 1 && k == 0) {
                resultado = residuo + resultado;
            }
        }
        return resultado;
    }

    private String multiplicacion(String parametro1, String parametro2) {

        String numMult1 = "";
        String numMult2 = "";

        int mult;
        int residuo = 0;
        int ceros = 0;

        for (int i = parametro2.length() - 1; i >= 0; i--) {
            for (int j = parametro1.length() - 1; j >= 0; j--) {
                String numero1 = "" + parametro1.charAt(j);
                int num1 = parseInt(numero1);
                String numero2 = "" + parametro2.charAt(i);
                int num2 = parseInt(numero2);

                mult = num1 * num2 + residuo;

                if (mult >= 10) {
                    numMult1 = (mult % 10) + numMult1;

                } else {
                    numMult1 = mult + numMult1;
                }
                residuo = mult / 10;

                if (residuo != 0 && j == 0) {
                    numMult1 = residuo + numMult1;
                    residuo = 0;
                }
            }
            if (parametro2.length() == 1) {
                return numMult1;
            } else {
                numMult1 = numMult1 + "0".repeat(ceros);
                ceros += 1;
                while (numMult2.length() != numMult1.length()) {
                    if (numMult2.length() >= numMult1.length()) {
                        numMult1 = "0" + numMult1;
                    } else {
                        numMult2 = "0" + numMult2;
                    }
                }
                numMult2 = suma(numMult1, numMult2);
                numMult1 = "";

            }
        }
        return numMult2;
    }
}


