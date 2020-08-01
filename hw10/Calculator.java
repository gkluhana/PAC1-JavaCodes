import java.util.*;
public class Calculator{
	
	//Main Method for User Input
	public static void main(String [] args){

		//Initializa Scanner for User input
		String input ="";
		Scanner sc = new Scanner(System.in);
		
		//Main Program Loop
		while(!input.equals("x")){
			//Print User Menu
			System.out.println("----------------------------"+
								"\nWhat do you want to do:\n"+
								"\tquit program:\t[x]\n"+
								"\tinput infix:\t[i]");
			input = sc.next();
			
			//Handle Illegal Input
			if(!input.equals("x")&&!input.equals("i")){
				System.out.println("\nIllegal Input");
			}
			//User Wants to Input Expression
			else if(input.equals("i")){
				double result;
				System.out.println("Input infix expression: ");

				//try catch block catches incorrect infix Expression
				try{
				String infix = sc.next();
				System.out.println("----------------------------"+
									"\nInfix expression :"+infix);

				//Use PostfixCalculator class with infix expression as instance variable
				PostfixCalculator calculator = new PostfixCalculator(infix);
				result=calculator.calculate();
				System.out.println("Answer is:"+result);
				}
				catch(NumberFormatException ex){
					System.out.println("\nIllegal Input, input a correct infix expression");
					sc.nextLine();
				}
			}
		}
		//Print Exit Message
		System.out.println("Program was terminated by User");
	}
}

//PostfixCalculator Class
class PostfixCalculator{
	//Data Members
	private String infix;
	private String postfix;
	private int result;

	//Constructor
	public PostfixCalculator(String infix){
		this.infix=infix;
	}

	//Calculate method does most of the work
	public double calculate(){

		//Convertor Class for infix to postfix conversion
		PostfixConverter converter = new PostfixConverter(infix);
		postfix=converter.toPostfix();
		System.out.println("Converted to postfix:"+postfix);
		
		//Tokenize Postfix Expression
		char[] mycharArray= postfix.toCharArray();

		//Pass Char Array to ParserHelper method
		List<String> tokenlist = ParserHelper.parse(mycharArray);
		
		//Implement Shunting Yard algorithm
		//Stack for Operators
		ArrayStack<String> calculatorStack = new ArrayStack<>(infix.length());

		//Iterate through tokens
		String tempresult = "";

		for(int i=0;i<tokenlist.size();i++){
			//Current Token as String
			String current = tokenlist.get(i);

			//First Char of Token
			char token=tokenlist.get(i).charAt(0);
			//If it is operand, push it to Stack
			if(Character.isDigit(token)){
				calculatorStack.push(current);
			}

			//If not an operator, evaluate the expression and put it onto Stack
			else{
				String op1 = calculatorStack.pop();
				String op2 = calculatorStack.pop();
				tempresult = evaluate(op1,op2,token);
				calculatorStack.push(tempresult);
			}
		}
		double result = Double.parseDouble(calculatorStack.pop());
		return result;
	}

	//Method to evaluate
	public String evaluate(String op2AsString, String op1AsString, char op){
		double result=0;
		double op1 = Double.parseDouble(op1AsString);
		double op2 = Double.parseDouble(op2AsString);
		switch(op){
			case('+'): result=op1+op2;
			break;
			case('-'): result=op1-op2;
			break;
			case('*'): result=op1*op2;
			break;
			case('/'): result=op1/op2;
			break;
			case('^'): result=Math.pow(op1,op2);
			break;
		}
		String resultAsString=Double.toString(result);
		return resultAsString;
	}
}

//PostfixConverter Class
class PostfixConverter{
	
	//Data Members
	private String infix;
	private String postfix="";

	//Constructor
	public PostfixConverter(String infix){
		this.infix=infix;
	}
	public String toPostfix(){
		
		//String to Char Array
		char[] mycharArray= infix.toCharArray();

		//Pass Char Array to ParserHelper method
		List<String> tokenlist = ParserHelper.parse(mycharArray);
		
		//Implement Shunting Yard algorithm
		//Stack for Operators
		ArrayStack<Character> converterStack = new ArrayStack<>(infix.length());
		
		//Iterate through tokens
		for(int i=0;i<tokenlist.size();i++){

			//Current Token as String
			String current = tokenlist.get(i);

			//First Char of Token
			char token=tokenlist.get(i).charAt(0);
			
			//If it is operand, append whole String current to postfix
			if(Character.isDigit(token)){
				postfix=postfix+" "+current;
			}

			//Not an operand, we can work with token variable

			//If Stack is empty, or token is (, push token to Stack
			else if(converterStack.isEmpty()||token=='('){
				converterStack.push(token);
			}

			//If it's ), pop from Stack until you find (
			else if(token==')'){

				//append all operators on stack until you find (, remove ( from stack
				while(converterStack.top()!='('){
					postfix=postfix+" "+converterStack.pop();
					
				}

				//Remove the ( from stack and discard both ( and )
				converterStack.pop();
			}

			//For Remaining Operators ^, /, *, +, -
			else{

				//Compare token and top of Stack, pop until empty or Higher				
				while(lowerPrec(token,converterStack.top())){
					postfix=postfix+" "+converterStack.pop();
					
					//Break if run out of operands on Stack
					if(converterStack.isEmpty()){break;}
				}
				//push the token onto Stack
				converterStack.push(token);
			}
		}

		//After running out of tokens, append all remaining tokens on Stack to String
		while(converterStack.size()!=0){
			postfix=postfix+" "+converterStack.pop();
		}

		return postfix;
	}
	//Precedence Decider Method (could have also been implemented more easily with Switch cases)
	private boolean lowerPrec(char a,char b){
		if(b=='('){return false;}
		//Rank Binary Operators in Order of Precedence
		char[] precedence = {'^','/','*','+','-'};
		
		//Dummy Variables for 'Precedence Rank' of Operators
		int aprec=0,bprec=0;
		
		//Compare with Rank and Set 'Precedence Value'
		for (int i=0;i<precedence.length;i++){
			if(a==precedence[i]){aprec=i;}
			if(b==precedence[i]){bprec=i;}
		}
		//Equal precedence of *,/ Operators
		if((aprec==1&&bprec==2)||(aprec==2&&bprec==1)){aprec=bprec;}
		//Equal precedence of +,-
		if((aprec==3&&bprec==4)||(aprec==4&&bprec==3)){aprec=bprec;}
		
		return(aprec>=bprec);
	}
}

//Generic ArrayStack Implementation adapted from Book's Code
class ArrayStack<E> implements Stack<E>{
	private E[] array;
	private int topindex=-1;


	public ArrayStack(){
		this(1000);
	}
	@SuppressWarnings({"unchecked"})
	public ArrayStack(int cap){
		
		array = (E[]) new Object[cap];
	}

	public int size(){
		return topindex+1;
	}
	public boolean isEmpty(){
		return topindex==-1;
	}
	public void push(E e) throws IllegalStateException{
		if(size()==array.length) throw new IllegalStateException("StackOverFlow");
		array[++topindex] = e;
	//System.out.println(e+"was pushed onto Stack");
	}

	public E top(){
		if(isEmpty()) return null;
		return array[topindex];
	}
	public E pop(){
		if(isEmpty()) return null;
		E answer = array[topindex];
		array[topindex]=null;
		topindex--;
	//System.out.println(answer+"was popped off Stack");
		return answer;
	}

} 

//Generic Stack Interface adapted from Book's Code
interface Stack<E>{
	int size();
	boolean isEmpty();
	void push(E e);
	E top();
	E pop();
}

//Parser Helper
class ParserHelper {

protected static List<String> parse(char[] input) {
    List<String> parsed = new ArrayList<String>();
    for (int i = 0; i < input.length; ++i) {
        char c = input[i];
        if (Character.isDigit(c)) {
            String number = input[i] + "";
            for (int j = i + 1; j < input.length; ++j) {
                if (Character.isDigit(input[j])) {
                    number += input[j];
                    i = j;
                } else {
                    break;
                }
            }
            parsed.add(number);
        } else if (c == '*' || c == '/' || 
                   c == '+' || c == '^' || 
                   c == '-' || c == '(' || c == ')') {
            parsed.add(c + "");
        }
    }
    return parsed;
}
}