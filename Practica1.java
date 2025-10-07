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
        List<Set<T>> sets = new ArrayList<>();
        while (it.hasNext()){
            boolean encontrado = false;
            T elem = it.next();
            for (Set<T> set : sets){
                if (!set.contains(elem)){
                    set.add(elem);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                Set<T> nuevo = new HashSet<>();
                nuevo.add(elem);
                sets.add(nuevo);
            }
        }
        return sets;
    }

    //EJERCICIO 4
    public static<T> Collection<Set<T>> coverageSet2 (Set<T> u,ArrayList<Set<T>> col) {
        //TODO
        if (col == null || col.size() < 2) {
            return new ArrayList<>();
        }
        for (int i = 0; i < col.size(); i++) {
            for (int j = i + 1; j < col.size(); j++) {
                Set<T> set1 = col.get(i);
                Set<T> set2 = col.get(j);
                Set<T> union = new HashSet<>(set1);
                union.addAll(set2);
                if (union.equals(u)) {
                    Collection<Set<T>> result = new ArrayList<>();
                    result.add(set1);
                    result.add(set2);
                    return result;
                }
            }
        }
        return new ArrayList<>();
    }
}
