package singleton_pattern.printer_6_1;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void print() {
        Printer printer = Printer.getPrinter(); //싱글톤 객체 생성
        printer.print(this.name + " print  ::  using " + printer.toString());
    }
}
