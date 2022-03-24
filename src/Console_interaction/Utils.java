package Console_interaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    static int characters = 60;
    public static Scanner sn  = new Scanner(System.in);

    static public void header(String title) {
        System.out.println("=".repeat(characters));
        System.out.println("\t\t\t" + title);
        System.out.print("=".repeat(characters));
    }

    static public void subheader(String title) {
        System.out.println("\n");
        System.out.println("-".repeat(characters));
        System.out.println("\t\t\t" + title);
        System.out.println("-".repeat(characters));
    }

    static public int getOption(){
        System.out.print("Option: ");
        return sn.nextInt();
    }

    static public void showSimpleLine(){
        System.out.println("-".repeat(characters));
    }

    static public void showOptions(String[] optionsList){
        for (int index = 0; index < optionsList.length; index++) {
            System.out.println("\t" + (index + 1) + ". " + optionsList[index]);
        }
    }

    public static List<String> getCustomerInfo(){
        List<String> customerData = new ArrayList<>(4); // only 4 items!!!
        System.out.println("Please enter the following information");
        showSimpleLine();
        System.out.print("CI: ");          customerData.add(sn.next());
        System.out.print("Full Name: ");   customerData.add(sn.next());
        System.out.print("Nationality: "); customerData.add(sn.next());
        System.out.print("Birth Date(DD/MM/AAAA): ");  customerData.add(sn.next()); // Specify date format
        return customerData;
    }
}
