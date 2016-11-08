import java.util.Scanner;

/**
 * Created by Mohamed on 07-Nov-16.
 */

public class Main {
    static Scanner in = new Scanner(System.in);

    static Machine getMachine(char[] language, int[] states, int[][] transitions, int initialState, int[] finalStates) {

        return new Machine(language, states, transitions, initialState, finalStates);
    }

    public static void runMachine(Machine m) {
        while (true) {
            System.out.print("input: ");
            String input = in.nextLine().toLowerCase();
            System.out.print("Output: ");
            if (m.isAccepted(input)) System.out.println("accepted");
            else System.out.println("rejected");
        }
    }

    public static void main(String[] args) {
        System.out.println("enter 1 for problem 1, 2 for problem 2");

        String problem = in.nextLine();
        int p = Integer.parseInt(problem);
        if (p == 1) {
            int[] states = {0, 1, 2, 3, 4};
            char[] language = {'a', 'b', 'c'};
            int[][] transitions = new int[][]{
                    {1, 2, 3},
                    {1, -1, 4},
                    {-1, 2, 4},
                    {-1, -1, 3},
                    {-1, -1, -1}
            };
            int initialState = 0;
            int[] finalStates = {3, 4};
            Machine m = getMachine(language, states, transitions, initialState, finalStates);
            runMachine(m);

        } else if (p == 2) {
            int[] states = {0, 1, 2, 3};
            char[] language = {'a', 'b'};
            int[][] transitions = new int[][]{
                    {1, 0},
                    {1, 2},
                    {1, 3},
                    {1, 0},

            };
            int initialState = 0;
            int[] finalStates = {3};
            Machine m = getMachine(language, states, transitions, initialState, finalStates);
            runMachine(m);
        } else System.out.println("invalid input");
    }

}
