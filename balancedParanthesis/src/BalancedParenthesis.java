import java.util.Stack;

public class BalancedParenthesis {
	public boolean balancedParenthesis(String str){
		Stack<Character> stk = new Stack<Character>();
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='{'||str.charAt(i)=='('||str.charAt(i)=='['){
				stk.add(str.charAt(i));
			}
			else if(str.charAt(i)=='}'||str.charAt(i)==')'||str.charAt(i)==']'){
				if(stk.isEmpty())
					return false;
				char c = stk.pop();
				switch (str.charAt(i)){
					case '}':
						if(c!='{')
							return false;
						break;
					case ')':
						if(c!='(')
							return false;
						break;
					case ']':
						if(c!='[')
							return false;
						break;
					default : 
				}
			}
		}
		if(stk.isEmpty())
			return true;
		return false;
	}
	public static void main(String args[]){
		BalancedParenthesis obj = new BalancedParenthesis();
		String str="{()}[](88796)";
		boolean result = obj.balancedParenthesis(str);
		System.out.println("The parenthesis is balanced : "+ result);
	}
}
