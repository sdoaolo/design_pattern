package proxy_pattern.aop;

import proxy_pattern.aop.entity.Exam;
import proxy_pattern.aop.entity.FinalExam;
import proxy_pattern.aop.entity.ProxyExam;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Program {
    public static void main(String[] args) {


        //01) use reflect.Proxy, 익명객체
        Exam examtest = new FinalExam(5,5,5,5);
        Exam exam1 = (Exam) Proxy.newProxyInstance(FinalExam.class.getClassLoader(), new Class[]{Exam.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                long start = System.currentTimeMillis();

                Object result = method.invoke(examtest, args);

                long end = System.currentTimeMillis();
                String timeMessage = (end-start) + "ms 시간이 걸렸습니다.";
                System.out.println(timeMessage);
                return result;
            }
        });

        System.out.println(exam1.avg());
        System.out.println();
        System.out.println(exam1.total());


        //02) ProxyExam Class
        //아까 실습에서 사용했던 방법은 - 한 메서드에 국한된다.
        //결국 프록시 Reflect.Proxy로 클래스를 받고,
        //모든 메소드를 invoke 할 수 있는 위의 방식이 좀 더 좋은 방식인듯!
        //리플렉션으로 직접 클래스 찾아서 하는거가 이런식으로 응용될 수 있다는 걸 깨달았다.
        /*
        Exam exam2 = new ProxyExam(3,3,3,3);
        System.out.printf("total is %d\n", exam2.total());
        System.out.println();
        System.out.printf("avg is %f\n", exam2.avg());
        */
    }
}
