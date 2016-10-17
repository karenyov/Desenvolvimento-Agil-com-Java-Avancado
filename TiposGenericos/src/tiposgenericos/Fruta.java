/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiposgenericos;

/**
 *
 * @author Karen
 */
public class Fruta {
    
    protected String nome;

    public Fruta(String nome) {
        super();
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Fruta{" + "nome=" + nome + '}';
    }
    
}
