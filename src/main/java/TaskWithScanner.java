import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskWithScanner extends Task {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input any amounts of names in any register. " +
                "When you want to stop just input 'stop' in the input field.");

        List<String> inputList = new ArrayList<>();
        System.out.println("Input any name in any register: ");
        String inputName = scanner.nextLine();

        checkInput(inputName, inputList);

        while (!Objects.equals(inputName, "stop")){
            System.out.println("Input any name in any register: ");
            inputName = scanner.nextLine();
            checkInput(inputName, inputList);
        }
        inputList.remove(inputList.size() - 1);
        System.out.println(inputList);

        output(sortedInput(registerFix(inputList)));
    }

    public static void checkInput(String input, List<String> inputList){
        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher m = p.matcher(input);

        if (m.matches()){
            inputList.add(input);
        } else {
            System.out.println("You put a wrong name!");
        }
    }
}
