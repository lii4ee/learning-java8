package myapp;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class second {

    public static void main(String [] args){
        String str = "ALEXANDER";

        str.chars().mapToObj(i -> (char)i).forEach(System.out::println);
        str.chars().map(i -> (char)i).forEach(System.out::println);

        Map <Character, Long> mp =str.chars().mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(
            Function.identity(),
            LinkedHashMap::new,
            Collectors.counting()
        ));
        System.out.println(mp);

        /*
         * Output
A
L
E
X
A
N
D
E
R
65
76
69
88
65
78
68
69
82
{A=2, L=1, E=2, X=1, N=1, D=1, R=1}
         */

         
    }
}
