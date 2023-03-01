package uk.ac.rgu.cm2116;

public class Stack<T> implements AbstractStack<T>{

    private Object[] stack;
    private int top;

    public Stack(){
        this.stack = new Object[10];
        this.top = -1;
    }

    @Override
    public boolean push(T element) throws StackOverflowException {
        if(top == stack.length - 1){
            throw new StackOverflowException("Stack is full");
        }

        top++;
        this.stack[top] = element;
        return true;
    }

    @Override
    public T pop() throws StackUnderFlowException {
        if(this.top < 0){
            throw new StackUnderFlowException("Stack is empty");
        }

        T element = (T)this.stack[top];
        this.stack[top] = null;
        top--;
        return element;
    }

    @Override
    public T peek() throws StackUnderFlowException {
        if(this.top < 0){
            throw new StackUnderFlowException("Stack is empty");
        }

        return (T)this.stack[top];
    }

    @Override
    public int size() {
        return this.top + 1;
    }

    @Override
    public boolean isEmpty(){
        return (this.size() == 0);
    }
    
}
