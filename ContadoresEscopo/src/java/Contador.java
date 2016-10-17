/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Karen
 */
public class Contador {

    private int numeroAtual = 0;
    private String nome;

    public Contador(String nome) {
        this.nome = nome;
    }

    public void contar() {
        numeroAtual++;
    }

    public String toString() {
        return nome + " = "+numeroAtual;
    }

}
