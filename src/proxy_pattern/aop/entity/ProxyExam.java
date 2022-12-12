package proxy_pattern.aop.entity;

public class ProxyExam implements Exam{

    private FinalExam finalExam;
    private int kor;
    private int eng;
    private int math;
    private int com;

    public ProxyExam(int kor, int eng, int math, int com) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.com = com;
    }


    @Override
    public int total() {

        if (finalExam == null) {
            finalExam = new FinalExam(kor,eng,math,com);
        }

        long start = System.currentTimeMillis();

        int result = finalExam.total();

        long end = System.currentTimeMillis();
        String message = (end-start) + "ms 시간이 걸렸습니다.";
        System.out.println(message);

        return result;
    }

    @Override
    public float avg() {
        return 0;
    }
}
