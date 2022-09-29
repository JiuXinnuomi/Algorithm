package alorithmtest.stack;

import java.util.Scanner;

/**
 * @author: knigh
 * 用栈实现括号匹配
 */
public class BracketsStack {

    /**
     * 判断输入的括号字符串是否能匹配
     * @param s
     * @return
     */
    public static boolean isOk(String s){
        MyStack<Character> brackets = new ArrayStack<>(20);
        char[] c = s.toCharArray();
        Character top;
        for (char x: c){
            switch (x){
                case '(':
                case '[':
                case '{':
                    brackets.push(x);
                    break;
                case ')':
                    top = brackets.pop();
                    if(top == null){
                        return false;
                    }
                    if (top == '('){
                        break;
                    }else {
                        return false;
                    }
                case ']':
                    top = brackets.pop();
                    if(top == null){
                        return false;
                    }
                    if (top == '['){
                        break;
                    }else {
                        return false;
                    }
                case '}':
                    top = brackets.pop();
                    if(top == null){
                        return false;
                    }
                    if (top == '{'){
                        break;
                    }else {
                        return false;
                    }
                default:
                    break;
            }
        }
        return brackets.isEmpty();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String msg = scanner.next();
            System.out.println("S的匹配结果" + isOk(msg));
        }
    }

}
