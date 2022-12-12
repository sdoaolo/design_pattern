package proxy_pattern.ExampleImage;
import java.time.LocalDateTime;

public class Proxy_Image implements Image {
    private Real_Image real_image;
    private String fileName;
    private String filePath;

    public Proxy_Image(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void displayImage() {
        if (real_image == null) {
            real_image = new Real_Image(filePath);
        }

        long startTime = System.currentTimeMillis();

        try {
            real_image.displayImage();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long estimatedTime = System.currentTimeMillis() - startTime;

        System.out.println("Loading Time : " + estimatedTime/1000.0 + " milli seconds");

    }
}
