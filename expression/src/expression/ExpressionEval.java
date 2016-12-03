package expression;

class ExpIllegalException extends Exception{
	ExpIllegalException(){
	}
	ExpIllegalException(String message){
		super(message);
	}
}

public class ExpressionEval {
	
	public static String evaluator(String prefexp)throws ExpIllegalException{
		String result="";
		prefexp=prefexp.trim();
		String elements[]=prefexp.split(" ");
		if(elements.length<3)
			throw new ExpIllegalException("Format Error");
		if(elements[0].length()!=1)
			throw new ExpIllegalException("Format Error");
		else{
			char operator=elements[0].charAt(0);
			double res=Double.parseDouble(elements[1]);
			switch(operator){
			case '+': for(int i=2;i<elements.length;i++){
				        double num= Double.parseDouble(elements[i]);
				        res+=num;				
			          }
			          break;
			case '-': for(int i=2;i<elements.length;i++){
				       double num= Double.parseDouble(elements[i]);
				       res-=num;				
			          }
	                  break;
			case '*': for(int i=2;i<elements.length;i++){
				       double num= Double.parseDouble(elements[i]);
				       res*=num;				
			          }
	                  break;
			case '/': for(int i=2;i<elements.length;i++){
				       double num= Double.parseDouble(elements[i]);
				       res/=num;				
			          }
	                  break;
	        default: throw new ExpIllegalException("Format Error");    
			          
			}
			result=res+"";
		}
		return result;
	}
	
	public static String evaluate(String exp){
		try{
		do{
			int lastOpenBracePos=exp.lastIndexOf('(');
			if(lastOpenBracePos==-1)
				throw new ExpIllegalException();
			else{
				int corrCloseBracePos=exp.indexOf(")", lastOpenBracePos);
				if(corrCloseBracePos==-1)
					throw new ExpIllegalException();
				else{
					String result=evaluator(exp.substring(lastOpenBracePos+1,corrCloseBracePos));
					exp=exp.substring(0,lastOpenBracePos)+result+exp.substring(corrCloseBracePos+1);					
				}
			}
			
		}while(exp.lastIndexOf('(')!=-1);
		return exp;
		}catch(ExpIllegalException e){
			System.out.println("Format Error");
			return "";
		}		
	}

	public static void main(String[] args) {
		String str1="(+ 6 7 10)";
		String str2="(* 2 (- 7 3 9) 4)";
		String str3="(* 3 (* 5 2 0) (- 6 3))";
		System.out.println(evaluate(str1));
		System.out.println(evaluate(str2));
		System.out.println(evaluate(str3));
		

	}

}
