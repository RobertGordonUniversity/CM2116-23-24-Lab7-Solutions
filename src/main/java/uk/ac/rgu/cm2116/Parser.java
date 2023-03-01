package uk.ac.rgu.cm2116;

import uk.ac.rgu.cm2116.AbstractStack.StackOverflowException;
import uk.ac.rgu.cm2116.AbstractStack.StackUnderFlowException;

public class Parser {
    
    public boolean parse(String input){
        Stack<Character> stack = new Stack<>();
        for(char c : input.toCharArray()){
            if(c == '('){
                try{
                    stack.push(c);
                }catch(StackOverflowException ex){
                    System.out.println(ex.getMessage());
                    return false;
                }
            }else if(c == ')'){
                try{
                    stack.pop();
                    //System.out.println("AAAA");
                }catch(StackUnderFlowException ex){
                    return false;
                }
            }
        }
    
        /* If we get this far, the stack has to be empty; if it's not, the parse fails */
        return stack.isEmpty();
    }
}
