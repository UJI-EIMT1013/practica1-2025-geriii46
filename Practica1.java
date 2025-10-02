package practica1;

import java.util.*;

public class Practica1 {

    //EJERCICIO 1
    public static Set<Integer> multiplos (Iterator<Integer> it) {
        //TODO
        Set<Integer> multiplos = new HashSet<>();
        List<Integer> enteros = new ArrayList<>();
        while (it.hasNext()) {
            enteros.add(it.next());
        }
        for (int i = 0; i<enteros.size(); i++){
            for (int j = 0; j<enteros.size(); j++){
                if (i!=j && enteros.get(j) !=0 && enteros.get(i)%enteros.get(j)==0){
                    multiplos.add(j);
                }
            }
        }
        return multiplos;
    }

    //EJERCICIO2
    public static void separate (Set<Integer> cuadrados, Set<Integer> noCuadrados)  {
        //TODO

    }

    //EJERCICIO 3
    public static<T> Collection<Set<T>> divideInSets (Iterator<T> it) {
        //TODO
        return null;
    }

    //EJERCICIO 4
    public static<T> Collection<Set<T>> coverageSet2 (Set<T> u,ArrayList<Set<T>> col) {
        //TODO
        return null;
    }



}
