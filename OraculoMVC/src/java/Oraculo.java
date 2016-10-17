
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Karen
 */
public class Oraculo {
    
    public List<String> melhoresProdutos(String tipo){
        List<String> lista = new ArrayList<>();
        if(tipo.equals("doce de leite")){
            lista.add("Viçosa");
            lista.add("Boreal");
        } else if(tipo.equals("queijo mineiro")){
            lista.add("Candido Tostes");
            lista.add("Humaitá");
            lista.add("O da minha Tia Totônia");
        }
        return lista;
    }
    
}
