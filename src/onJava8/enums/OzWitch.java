package onJava8.enums;

public enum OzWitch {
    WEST("west"),
    NORTH("north"),
    EAST("east"),
    // 如果你打算定义自己的方法，那么必须在 enum 实例序列的最后添加一个分号
    // 同时，Java 要求你必须先定义 enum 实例
    SOUTH("south");

    private String gouZao;
    private OzWitch(String gouZao) {
        this.gouZao = gouZao;
    }

    public String getGouZao() {
        return gouZao;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            // 相当于是在类里面声明了几个自己的对象
            System.out.println(witch.getGouZao());
        }
    }
}
