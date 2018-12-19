package math.digitseparation;

public class 整数到二进制 {

    public String toBinary(Integer i) {
        String str = "";
        while (i != 0) {
            str = "" + (i % 2) + str;
            i = i / 2;
        }

        return str;
    }

    public static void main(String[] args) {
        System.out.println(new 整数到二进制().toBinary(4));
        System.out.println("aaa");
    }
}
