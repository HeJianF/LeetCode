import stack.MyStack;

import java.util.Stack;

public class MyTest {

    /*private volatile static MyTest mInstance;

    private MyTest() {
    }

    public static MyTest getInstance() {
        if (mInstance == null) {
            synchronized (MyTest.class) {
                if (mInstance == null) {
                    mInstance = new MyTest();
                }
            }
        }
        return mInstance;
    }*/

    public static void main(String[] args) {
        MyTest myTest = new MyTest();
        myTest.add("a");
        myTest.add("b");
        myTest.add("c");
        myTest.add("d");
        System.out.println(myTest.remove());
        System.out.println(myTest.remove());
        System.out.println(myTest.remove());
        System.out.println(myTest.remove());
    }

    private Stack<String> stack1 = new Stack<>();
    private Stack<String> stack2 = new Stack<>();

    public void add(String string) {
        stack1.add(string);
    }

    public String remove() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
