package onJava8.enums;

enum Shrubbery {GROUND, CRAWLING, HAVING}  // 这句话就是一个类啊

public class EnumClass {

    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            System.out.println(s + " " + s.ordinal());
            System.out.println(s.getDeclaringClass());
        }
    }
}
