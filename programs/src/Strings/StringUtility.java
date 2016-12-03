package Strings;

import java.util.HashMap;
import java.util.HashSet;

public class StringUtility {
		
		//Method to reverse a String
		public String reverseString(String st){
			if(st==null)
				return st;
			StringBuilder sb = new StringBuilder(st);
			sb = sb.reverse();
			st = sb.toString();
			return st;
		}
		
		//Method to reverse each Word separately in the given string
		public String reverseStringWord(String str){
			if(str==null)
				return null;
			StringBuilder sb = new StringBuilder();
			String arr[] = str.split(" ");
			for(int i=0;i<arr.length;i++){
				arr[i] = reverseString(arr[i]);
				sb.append(arr[i]);
				sb.append(" ");
			}
			return sb.toString();
		}
		
		//Method to reverse the order of the words in the given string
		public String reverseOrderWords(String st){
			if(st==null)
				return null;
			StringBuilder sb = new StringBuilder();
			String arr[] = st.split(" ");
			for(int i=arr.length-1;i>=0;i--){
				sb.append(arr[i]);
				sb.append(" ");
			}
			return sb.toString();
		}
		
		//Method to check if the givcen string is palindrome or not
		public boolean isPalindrome(String str){
			boolean flg = true;
			for(int i=0;i<str.length();i++){
				if(str.charAt(i)!=str.charAt(str.length()-i-1)){
					flg=false;
					break;
				}
			}
			return flg;
		}
		
		//Method to Reverse a given Integer
		public int reverseInt(int num){
			if(num/10==0)
				return num;
			int rev=0;
			while(num>0){
				int d = num%10;
				rev = rev*10+d;
				num=num/10;
			}
			return rev;
		}
		
		//Method to check if the given Integer number is palindrome or not
		public boolean isNumPlaindrome(int num){
			int rev = reverseInt(num);
			if(num==rev)
				return true;
			return false;
		}
		
		//Method to Print the first non repeating character using hashmap
		public char firstNonRepeating(String str){
			//HashSet<Character> hset = new HashSet<>();
			char res='\0';
			HashMap<Character, Integer> hmap = new HashMap<>();
			for(char c: str.toCharArray()){
				if(hmap.containsKey(c))
					hmap.put(c,hmap.get(c)+1);
				else
					hmap.put(c,1);
			}
			System.out.println(hmap);
			for(char c: str.toCharArray()){
				int v = hmap.get(c);
				if(v==1){
					res=c;
					break;
				}
			}
			return res;
		}
		
		//Iterative method to reverse a string
		public String reverseIter(String str){
			//String temp = new String(str);
			//StringBuilder sb = new StringBuilder(str);
			int i=0;
			char temp[] = str.toCharArray();
			while(i<(str.length()/2)){
				char t = temp[i];
				temp[i]=temp[str.length()-i-1];
				temp[str.length()-i-1] = t;
				i++;
			}
			String res =String.valueOf(temp);
			return res;
		}
		
		//Recursive Method to reverse a String
		public String reverseRecur(String str){
			if(str.length()<2)
				return str;
			return (reverseRecur(str.substring(1))+str.charAt(0));
		}
		//Main Method to help run all the utility methods 
		public static void main(String args[]){
			String st = new String("abhilash in hyderabad");
			String s = new String("MALAYALAM");
			StringUtility obj = new StringUtility();
			System.out.println("The first non repeating char is: " + obj.reverseRecur(st));
			//int num = 111000111;
			//System.out.println("The num is Palindrome or not : " + obj.isNumPlaindrome(num));
			//System.out.println(st);
			//st = obj.reverseStringWord(st);
			//st = obj.reverseOrderWords(st);
			//System.out.println("The given string is palindrome :  " + obj.isPalindrome(s));
		}
	}
