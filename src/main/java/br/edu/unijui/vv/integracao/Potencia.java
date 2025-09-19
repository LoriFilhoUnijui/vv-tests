package br.edu.unijui.vv.integracao;

public final class Potencia {
    private Potencia(){}
    public static long calcular(int x, int y) {
        if (y < 0) {
            throw new IllegalArgumentException("O expoente y deve ser >= 0");
        }
        long resultado = 1;
        long base = x;
        int exp = y;
        while (exp > 0) {
            if ((exp & 1) == 1) resultado *= base;
            base *= base;
            exp >>= 1;
        }
        return resultado;
    }
}
