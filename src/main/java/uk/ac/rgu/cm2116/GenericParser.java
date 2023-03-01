package uk.ac.rgu.cm2116;

import uk.ac.rgu.cm2116.AbstractStack.StackOverflowException;
import uk.ac.rgu.cm2116.AbstractStack.StackUnderFlowException;

/**
 * Generalised implementation of the parser. The pair of characters are given as constructor parameters
 */
public class GenericParser {
    
    char c1, c2;

    public GenericParser(char c1, char c2){
        this.c1 = c1;
        this.c2 = c2;
    }

    public boolean parse(String input){
        Stack<Character> stack = new Stack<>();
        for(char c : input.toCharArray()){
            if(c == this.c1){
                try{
                    stack.push(c);
                }catch(StackOverflowException ex){
                    System.out.println(ex.getMessage());
                    return false;
                }
            }else if(c == this.c2){
                try{
                    stack.pop();
                }catch(StackUnderFlowException ex){
                    return false;
                }
            }
        }
    
        /* If we get this far, the stack has to be empty; if it's not, the parse fails */
        return stack.isEmpty();
    }

}
