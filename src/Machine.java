import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by Mohamed on 06-Nov-16.
 */
class Machine {
    //array of chars for language, array of int for states (index 0 means q0 etc)
    char[] language;
    int[] states;
    //this is a transition table, row is state, column is input character's index in the language array
    int[][] transitions;
    int initialState;
    int[] finalStates;
    //used to iterate
    int currentState;

    public Machine(char[] language, int[] states, int[][] transitions, int initialState, int[] finalStates) {
        this.language = language;
        this.states = states;
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalStates = finalStates;
    }
    //this gets the index of the character in the language
    int getIndex(char c)
    {
        //defaulted to -1 in case input wasn't in the language
        int index = -1;

        for (int i = 0; (i < language.length) && (index == -1); i++) {
            if (language[i] == c) {
                index = i;
            }
        }
        return index;
    }//this gets the new state, given the current state and the input
    int getState(int s,char newchar)
    { int state;
        try {
            int charIndex=getIndex(newchar);
      state =transitions[s][charIndex];
        }
        catch (ArrayIndexOutOfBoundsException  e)
        {
            //if there was no transition, returns -1
            return -1;
        }
        return state;
    }

//this checks if the input is accepted or not
    boolean isAccepted(String input)
    {
        this.currentState=this.initialState;
        for (int i = 0; i <input.length() ; i++) {
        char c=input.charAt(i);
            currentState=getState(currentState,c);
            //if the input character doesn't exist, or there was no available transition for it, then the input is rejected
            if (currentState==-1) return false;
        }
        //try to find the state we're in after finishing the input in the final states, if it is, then input is accepted
        return IntStream.of(finalStates).anyMatch(x -> x == currentState);
    }
}
