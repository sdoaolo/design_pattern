package proxy_pattern.ExampleImage;

public class Main {
    public static void main(String[] args) {

        /*
        // 프록시 미사용
        Image img1 = new Real_Image("../src/file01");
        Image img2 = new Real_Image("../src/screenshot02");
        Image img3 = new Real_Image("../src/screenshot03");
        */


        //프록시 사용
        // 1) 클라이언트는 Real_Image에 직접 접근하지 않는다.
        // 2) Proxy_Image 객체를 생성한다. Proxy는 Real_Image의 displayImage()를 호출한다.
        Image img1 = new Proxy_Image("../src/file01");
        Image img2 = new Proxy_Image("../src/screenshot02");
        Image img3 = new Proxy_Image("../src/screenshot03");

        img1.displayImage();
        img2.displayImage();
        img3.displayImage();

    }
}
