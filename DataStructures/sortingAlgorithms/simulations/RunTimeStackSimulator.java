package simulations;

import java.util.Stack;


//import sorters.InvocationRecord;

public class RunTimeStackSimulator<E extends Comparable<E>> {
	
	private Stack<MergeSortRunTimeSimulation<E>.InvocationRecord> _stack;
	
	public RunTimeStackSimulator() {
		_stack = new Stack<MergeSortRunTimeSimulation<E>.InvocationRecord>();
	}
	
	public void push(MergeSortRunTimeSimulation<E>.InvocationRecord s) {
		_stack.push(s);
		printStack("After pushing invocation record onto stack --- ");
	}
	
	public void pop() {
		_stack.pop();
		printStack("After popping invocation record from stack --- ");
	}
	
	public void printStack(String s) {	
		System.out.println("\n"+s+"Invocation records on the runtime stack:");
		for (MergeSortRunTimeSimulation<E>.InvocationRecord invocRec : _stack) {
			System.out.println(" << "+invocRec+" >>");
		}
	}

}
