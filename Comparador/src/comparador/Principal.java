/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparador;

import java.util.List;

/**
 *
 * @author Karen
 */
public class Principal {

    public static void main(String[] args) throws Exception {
        Pessoa p1 = new Pessoa("Eduardo", "Guerra", 36, "Pesquisador");
        Pessoa p2 = new Pessoa("Eduardo", "War", 37, "Coordenador");

        List<Diferenca> difs = Comparador.comparar(p1, p2);

        difs.forEach(System.out::println);

    }

}
