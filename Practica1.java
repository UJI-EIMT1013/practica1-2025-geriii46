package practica1;

import java.util.*;

public class Practica1 {

    //EJERCICIO 1
    public static Set<Integer> multiplos(Iterator<Integer> it) {
        List<Integer> numeros = new ArrayList<>();
        while (it.hasNext()) {
            Integer num = it.next();
            if (num != 0) numeros.add(num);
        }
        Set<Integer> resultado = new HashSet<>();
        for (int i = 0; i < numeros.size(); i++) {
            for (int j = 0; j < numeros.size(); j++) {
                if (i != j) {
                    if (numeros.get(j) != 0 &&  numeros.get(i) % numeros.get(j)== 0) {
                        resultado.add( numeros.get(i));
                        break;
                    }
                }
            }
        }
        return resultado;
    }

    //EJERCICIO2
    public static void separate(Set<Integer> cuadrados, Set<Integer> noCuadrados) {
        Set<Integer> originalCuadrados = new HashSet<>(cuadrados);
        Set<Integer> originalNoCuadrados = new HashSet<>(noCuadrados);
        Set<Integer> universo = new HashSet<>(originalCuadrados);
        universo.addAll(originalNoCuadrados);
        Set<Integer> esCuadrado = new HashSet<>();
        for (Integer base : universo) {
            if (base != 0) {
                if (Math.abs(base) <= Integer.MAX_VALUE / Math.abs(base)) {
                    int cuadrado = base * base;
                    if (universo.contains(cuadrado)) {
                        esCuadrado.add(cuadrado);
                    }
                }
            } else {
                if (universo.contains(0)) {
                    esCuadrado.add(0);
                }
            }
        }

        if (esCuadrado.contains(1)) {
            if (!(originalCuadrados.contains(1) && originalNoCuadrados.contains(1))) {
                esCuadrado.remove(1);
            }
        }
        cuadrados.clear();
        noCuadrados.clear();
        for (Integer numero : universo) {
            if (esCuadrado.contains(numero)) {
                cuadrados.add(numero);
            } else {
                noCuadrados.add(numero);
            }
        }
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
