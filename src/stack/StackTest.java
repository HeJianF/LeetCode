package stack;

public class StackTest {

    public static void main(String[] args) {
        //System.out.println(StackUtils.isValid("([{{{{[][][()]}}}}])"));
        MyStack queue = new MyStack();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.top());  // 返回 1
        System.out.println(queue.pop());   // 返回 1
        System.out.println(queue.empty()); // 返回 false
    }

}
