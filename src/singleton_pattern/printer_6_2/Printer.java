package singleton_pattern.printer_6_2;

public class Printer {
    private static Printer printer = null;
    //private int counter = 0; //(1)상태를 유지해야하는 변수 생성

    private Printer(){}

    public synchronized static Printer getPrinter() {
        if (printer == null) {
            try {
                Thread.sleep(1);
            }
            catch (InterruptedException e) {

            }
            printer = new Printer();
        }
        return printer;
    }
    public void print(String str) {

        //System.out.println(str);

        /*
        synchronized (this) {
            counter++; //(2) 상태 변경
            System.out.println(str + " 현재 " +counter+"번 사용되었습니다.");
        }
        */

    }

}
