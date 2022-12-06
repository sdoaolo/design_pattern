package singleton_pattern.printer_6_1;

//1번만 인스턴스가 생성되어야 하는 프린터 class
public class Printer {
    //static변수로 선언함으로써, class 자체에 속하고, 인스턴스를 통하지 않고도 실행할 수 있음.

    private static Printer printer = null;
    private Printer() { }


    //싱글톤의 목적이 단 하나의 객체만 생성해서 어디에서든지 참조 가능하게 만드는 것이므로, static 메서드로 만들어주어야함.
    public static Printer getPrinter(){
        if(printer == null) {
            printer = new Printer();
        }
        return printer;
    }
    public void print(String str) {
        System.out.println(str);
    }
}
