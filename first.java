// package myapp;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class first {
    public static void main(String[] args){
        
        List<Integer> arrList = Arrays.asList(5, 7, 9, 3, 11, 19, 1, -5);

        List<User> users = Arrays.asList(
            new User("Alice", 28, LocalDate.of(2020, 5, 15), 75000),
            new User("Bob", 35, LocalDate.of(2018, 3, 10), 85000),
            new User("Charlie", 32, LocalDate.of(2019, 11, 22), 78000),
            new User("Diana", 41, LocalDate.of(2017, 7, 30), 95000),
            new User("Evan", 25, LocalDate.of(2021, 2, 5), 65000)
        );

        System.out.println(users);
        System.out.println();
        users.forEach(System.out::println);

        users.sort(Comparator.comparing(User::getName));
        Collections.sort(arrList);
        System.out.println(arrList);
        users.stream().filter(n -> n.getName().startsWith("D")).forEach(System.out::println);
        
        users.stream()
        .sorted(Comparator.comparing(User::getAge))
        .map(u -> u.getAge())
        .forEach(System.out::println);

        users.stream()
        .map(u -> {
            return u.getName().toUpperCase();
        })
        .forEach(u -> System.out.println(u));
    
        LinkedList<User> list = users.stream()
        .map(u -> u)
        .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(list);

        System.out.println("++++++++++++=");
        users.stream().map(u -> u.getName()).distinct().forEach(System.out::println);
        System.out.println("++++++++++++=");
        Boolean bool = users.stream().anyMatch(u -> u.getAge() > 30);
        System.out.println(bool);

        double avg = users.stream().mapToInt(e -> e.getAge()).average().orElse(0);
        System.out.println(avg);

        Map <Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "one");
        hashMap.put(3, "three");
        hashMap.put(7, "seven");
        hashMap.put(-3, "Negative three");
        hashMap.put(-50, "Negative fifty");
        hashMap.put(100, "one hundred");
        Optional <String> op = hashMap.entrySet().stream()
                                .map(es -> es.getValue()).skip(5).findFirst();
        System.out.println(op.get());

        
        users.stream()
        .sorted(Comparator.comparing(User::getName).reversed())
        .distinct()
        .forEach(System.out::println);


        System.out.println("---------------------------");

        
        List<String> words = Arrays.asList(
            "apple", "banana", "apple", "orange", "banana", 
            "apple", "grape", "orange", "kiwi", "banana"
        );

        Optional<Map.Entry<String, Long>> secondMostFrequent = words.stream()
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .skip(1)
                .findFirst();        

        System.out.println("Second most frequent word: " + 
                          secondMostFrequent.map(e -> e.getKey() + " (count: " + e.getValue() + ")")
                          .orElse("None"));
        
        String text = "ABCDEJSFDLKSDKLFJSKDLFJDKLS";

        Map<Character, Long> charFrequency = text.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(
                                                Function.identity(), 
                                                LinkedHashMap::new, 
                                                Collectors.counting()
                                                ));
        
System.out.println("+++++++++++++++++++++++++++++++++++++=");
        Map <String, Long> mp = words.stream()
        .collect(Collectors.groupingBy(w -> w ,Collectors.counting()));
        System.out.println(mp);

        mp.entrySet().stream()
        .sorted(Map.Entry.<String, Long>comparingByValue())
        .forEach(System.out::println);;
    }   
/*
 * OUTPUT for the above

 [Alice 28 2020-05-15 75000.0, Bob 35 2018-03-10 85000.0, Charlie 32 2019-11-22 78000.0, Diana 41 2017-07-30 95000.0, Evan 25 2021-02-05 65000.0]
Alice 28 2020-05-15 75000.0
Bob 35 2018-03-10 85000.0
Charlie 32 2019-11-22 78000.0
Diana 41 2017-07-30 95000.0
Evan 25 2021-02-05 65000.0
[-5, 1, 3, 5, 7, 9, 11, 19]
Diana 41 2017-07-30 95000.0
25
28
32
35
41
ALICE
BOB
CHARLIE
DIANA
EVAN
[Alice 28 2020-05-15 75000.0, Bob 35 2018-03-10 85000.0, Charlie 32 2019-11-22 78000.0, Diana 41 2017-07-30 95000.0, Evan 25 2021-02-05 65000.0]
++++++++++++=
Alice
Bob
Charlie
Diana
Evan
++++++++++++=
true
32.2
seven
Evan 25 2021-02-05 65000.0
Diana 41 2017-07-30 95000.0
Charlie 32 2019-11-22 78000.0
Bob 35 2018-03-10 85000.0
Alice 28 2020-05-15 75000.0
---------------------------
Second most frequent word: apple (count: 3)
+++++++++++++++++++++++++++++++++++++=
{orange=2, banana=3, apple=3, kiwi=1, grape=1}
kiwi=1
grape=1
orange=2
banana=3
apple=3
 */


}