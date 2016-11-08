import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by Mohamed on 06-Nov-16.
 */
class Machine {
    char[] language;
    int[] states;
    int[][] transitions;
    int initialState;
    int[] finalStates;
    int currentState;

    public Machine(char[] language, int[] states, int[][] transitions, int initialState, int[] finalStates) {
        this.language = language;
        this.states = states;
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalStates = finalStates;
    }
    int getIndex(char c)
    {
        int index = -1;

        for (int i = 0; (i < language.length) && (index == -1); i++) {
            if (language[i] == c) {
                index = i;
            }
        }
        return index;
    }
    int getState(int s,char newchar)
    { int state;
        try {
            int charIndex=getIndex(newchar);
      state =transitions[s][charIndex];
        }
        catch (ArrayIndexOutOfBoundsException  e)
        {
            return -1;
        }
        return state;
    }


    boolean isAccepted(String input)
    {
        this.currentState=this.initialState;
        for (int i = 0; i <input.length() ; i++) {
        char c=input.charAt(i);
            currentState=getState(currentState,c);
            if (currentState==-1) return false;
        }
        return IntStream.of(finalStates).anyMatch(x -> x == currentState);
    }
}
