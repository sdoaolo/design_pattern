package singleton_pattern.printer_6_1;

public class Main {
    public static void main(String[] args) {
        User[] users = new User[]{
                new User("강지은"),
                new User("심규선"),
                new User("이찬혁"),
                new User("이수현"),
                new User("자우림")
        };

        for(int i=0;i<users.length; i++) {
            users[i].print();
        }
    }
}
