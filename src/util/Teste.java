package util;

import util.ConexaoBD;

public class Teste {
    public static void main(String[] args) {
        ConexaoBD conexaoBD = new ConexaoBD();
        conexaoBD.conectar();
        conexaoBD.desconectar();
    }
}
