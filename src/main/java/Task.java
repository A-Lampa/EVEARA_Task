//Написать функцию которая на вход принимает List<String> и выводит в консоль элементы и количество повторений
// без учета регистра, отсортированные в лексикографическом порядке. Элементы должны быть выведены с большой
// буквы (первая большая, остальные маленькие) для символов латинского алфавита

//input:
//{"Bob", "Alice", "Joe", "bob", "alice", "dEN"}
//output:
//Alice : 2
//Bob : 2
//Den : 1
//Joe : 1
//Также, покрыть тестами свой код.

import java.util.*;

public class Task {
    public static void main(String[] args) {

        List<String> input = new ArrayList<>();
        input.add("Bob");
        input.add("Alice");
        input.add("Joe");
        input.add("bob");
        input.add("alice");
        input.add("dEN");

        output(sortedInput(registerFix(input)));
    }

    public static List<String> registerFix(List<String> inputList){
        String[] stringArray = inputList.toArray(new String[0]);
        String[] fixedStringArray = new String[stringArray.length];

        for (int i = 0; i < stringArray.length; i++){
            String first = stringArray[i].substring(0,1);
            String afterFirst = stringArray[i].substring(1);
            fixedStringArray[i] = first.toUpperCase(Locale.ROOT) + afterFirst.toLowerCase(Locale.ROOT);
        }
        List<String> fixedInput = Arrays.asList(fixedStringArray);
        return fixedInput;
    }

    public static List<String> sortedInput(List<String> inputList){
        Collections.sort(inputList);
        return inputList;
    }

    public static void output(List<String> inputList){
        String[] stringArray = inputList.toArray(new String[0]);

        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < stringArray.length; i++){
            if (map.containsKey(stringArray[i])){
                map.put(stringArray[i], map.get(stringArray[i]) + 1);
            } else {
                map.put(stringArray[i], 1);
            }
        }
        for (Map.Entry<String, Integer> entry: map.entrySet())
        {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }
}
