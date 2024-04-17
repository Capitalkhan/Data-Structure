import java.util.Stack;

public class DuplicateBracket {

    static boolean isDuplicateBracket(String exp){
        Stack<Character> s = new Stack<>();

        char[] c = exp.toCharArray();

        for (char i: c){

            if (i == ')'){
                char top = s.peek();
                s.pop();

                // if inside bracket dos,nt element exit then duplicate bracket found
                int insideEle = 0;
                while (top != '('){
                    insideEle++;
                    top = s.peek();
                    s.pop();
                }

                // if inside bracket dos,nt element exit then duplicate bracket found
                if (insideEle < 1){
                    return true;
                }
            }else{
                s.push(i);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        String str = "(((a+(b)))+(c+d))"; // have duplicate bracket
//        String s = "((a+b)+(c+d))"; // dos,nt have duplicate bracket

        System.out.println(isDuplicateBracket(str));
    }
}
