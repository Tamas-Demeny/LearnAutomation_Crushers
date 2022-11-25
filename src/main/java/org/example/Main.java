package org.example;

import java.sql.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numeros = {};

        System.out.println( solution(numeros));
    }

    public static int solution(int[] numbers){
        int i = 1;
        numbers = Arrays.stream(numbers)
                            .sorted()
                            .distinct()
                            .filter(x -> x > 0)
                            .toArray();
        for ( int j : numbers ) {
                if ( i != j ) {
                    return i;
                } i++;
        }
        return i;
    }

}