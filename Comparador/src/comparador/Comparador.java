/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparador;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Karen
 */
public class Comparador {
    
    public static <E> List<Diferenca> comparar(E velho, E novo) throws Exception {
        List<Diferenca> difs = new ArrayList<>();
        
        Class<?> clazz = velho.getClass();
        
        for (Method m : clazz.getMethods()) {
            if (m.getName().startsWith("get") && m.getParameterCount() == 0 && m.getReturnType() != void.class && !m.isAnnotationPresent(IgnorarComparacao.class)) {
                
                Object valorVelho = m.invoke(velho);
                Object valorNovo = m.invoke(novo);
                
                if (!valorNovo.equals(valorVelho)) {
                    Diferenca d = new Diferenca(m.getName(), valorNovo, valorVelho);
                    difs.add(d);
                }
            }
            
        }
        
        return difs;
    }
    
}
