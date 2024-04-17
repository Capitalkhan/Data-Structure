import java.util.Stack;

public class Brackets {

    static Stack<Character> s = new Stack<>();

    static boolean check(Character a,Character b){
        return a == '(' && b == ')';
    }
    static int lengthOfValidParenthesis (String str){

        int count = 0;
        for (int i = 0; i<str.length(); i++){
            char c = str.charAt(i);

            if (c == '('){
                s.push(c);
            }else{
                if (s.isEmpty() && c == ')'){
                    continue;
                }
                if (check(s.peek(),c)){
                    count += 2;
                    s.pop();
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {

//        String str = "()(()))))";
        String str = ")()())";
        System.out.println(lengthOfValidParenthesis(str));

    }
}
