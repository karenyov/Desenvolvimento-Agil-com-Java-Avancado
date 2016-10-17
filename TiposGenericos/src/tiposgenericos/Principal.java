/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiposgenericos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Karen
 */
public class Principal {

    public static void main(String[] args) {
        Cesta<Fruta> frutas = new Cesta<>();
        frutas.adiciona(new Fruta("Maça"));
        frutas.adiciona(new Fruta("Banana"));
        frutas.adiciona(new Fruta("Mamão"));
        frutas.adiciona(new Fruta("Pêra"));
        frutas.adiciona(new Fruta("Uva"));
        
        frutas.adiciona(new FrutaVermelha("Morango"));
        
        List<FrutaVermelha> vermelhas = new ArrayList<>();
        vermelhas.add(new FrutaVermelha("Amora"));
        vermelhas.add(new FrutaVermelha("Cereja"));

        frutas.adicionaTodos(vermelhas);
        
        while (frutas.temItens()) {
            System.out.println(frutas.retira());
        }
    }
}
