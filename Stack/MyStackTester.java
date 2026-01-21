public class MyStackTester {
    public static void main(String[] args) {
        MyStack s = new MyStack<String>();
        s.push("mango");
        System.out.println(s.size());
        Object str = s.peek();
        System.out.println(str);
        str = s.pop();
        System.out.println(s.empty());
        System.out.println(str);
        s.push("guava");
        s.push("mango");
        s.push("kiwi");
        System.out.println(s.size());
        System.out.println(s.peek());
        System.out.println(s.empty());

    }
}
