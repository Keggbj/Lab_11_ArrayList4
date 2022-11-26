import java.util.ArrayList;
import java.util.Scanner;



public class Main {

    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        final String menu = "A = Add D = Delete P = Print Q = Quit";
        boolean done = false;
        String cmd = "";

        do {
            displayList();

            cmd = SafeInput.getRegExString(console, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();



            //execute the choice
            switch (cmd)
            {

                case "A":
                    add(console, list);
                    System.out.println("");


                    break;
                case "D":
                    delete(console, list);
                    if (list.size()==0)
                    {
                        System.out.println("No items in the list");
                    }
                    break;
                case "P":
                    print(list);
                    break;
                case "Q":
                    System.exit(0);
                    break;
            }
        } while (!done);
    }
    private static void displayList()
    {
        System.out.println("--------------------------------------");
        if (list.size() !=0)
            for (int i = 0; i < list.size(); i++)
            {
                System.out.printf("%3d%35s", i+1, list.get(i));
                System.out.println("");
            }
        else
            System.out.println("---         List is empty          ---");
        System.out.println("");

    }

    public static void add(Scanner in, ArrayList list)
    {
        String item = SafeInput.getNonZeroLengthString(in, "What item do you want to add?");
        list.add(item);

    }
    public static void delete(Scanner in, ArrayList list)
    {
        int item = SafeInput.getRangedInt(in, "What item do you want to remove?", 1, 1000);
        list.remove(item-1);
    }
    public static void print(ArrayList list)
    {
        for (int i=0; i<list.size(); i++)
        {
            System.out.println((i+1) + " " + list.get(i));
        }
        System.out.println();
    }

}