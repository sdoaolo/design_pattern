# [Design Patten] Proxy

<br><br>

<aside>

๐๏ธ ๋์์ธ ํจํด์ ๊ฐ์ธ์ ์ผ๋ก ๊ณต๋ถํด ์ ๋ฆฌํ ๋ด์ฉ์๋๋ค.

</aside>

<br>

---

<br><br>

## **โย Proxy pattern**

Proxy : ๋๋ฆฌ์, ๋๋ณ์ธ ์ด๋ผ๋ ๋ป
ํ๋ก์์๊ฒ ์ด๋ค ์ผ์ ๋์  ์ํค๋ ๊ฒ

- ์ด๋ค ๊ฐ์ฒด๋ฅผ ์ฌ์ฉํ๊ณ ์ ํ ๋, ๊ฐ์ฒด๋ฅผ ์ง์ ์ ์ผ๋ก ์ฐธ์กฐ ํ๋๊ฒ์ด ์๋๋ผ, **`ํด๋น ๊ฐ์ฒด๋ฅผ ๋ํ(๋๋ฆฌ, proxy)ํ๋ ๊ฐ์ฒด๋ฅผ ํตํด ๋์ ๊ฐ์ฒด์ ์ ๊ทผํ๋ ๋ฐฉ์`**
- ํด๋น ๊ฐ์ฒด๊ฐ ๋ฉ๋ชจ๋ฆฌ์ ์กด์ฌํ์ง ์์๋ ๊ธฐ๋ณธ์ ์ธ ์ ๋ณด๋ฅผ ์ฐธ์กฐํ๊ฑฐ๋ ์ค์ ํ  ์ ์๊ณ  ๋ํ ์ค์  ๊ฐ์ฒด์ ๊ธฐ๋ฅ์ด ๋ฐ๋์ ํ์ํ ์์ ๊น์ง ๊ฐ์ฒด์ ์์ฑ์ ๋ฏธ๋ฃฐ ์ ์๋ค.

<br>

- `์๋ ํ๋ ค๋ ๊ธฐ๋ฅ์ ์ํํ๋ฉฐ ๊ทธ ์ธ์ ๋ถ๊ฐ์ ์ธ ์์(๋ก๊น, ์ธ์ฆ, ๋คํธ์ํฌ ํต์  ๋ฑ)์ ์ํ`ํ๊ธฐ์ ์ข๋ค. 
- `๋น์ฉ์ด ๋ง์ด ๋๋ ์ฐ์ฐ(DB ์ฟผ๋ฆฌ, ๋์ฉ๋ ํ์คํธ ํ์ผ ๋ฑ)์ ์ค์ ๋ก ํ์ํ ์์ ์ ์ํ`ํ  ์ ์๋ค. 
- ์ฌ์ฉ์ ์์ฅ์์๋ ํ๋ก์ ๊ฐ์ฒด๋ ์ค์  ๊ฐ์ฒด๋ ์ฌ์ฉ๋ฒ์ ์ ์ฌํ๋ฏ๋ก ์ฌ์ฉ์ฑ์ด ์ข๋ค.

<br>

## โบ ๋ด๊ฐ ์ดํดํ ํ๋ฆ
![](src/file01.png)
1) client๊ฐ interface๋ฅผ ๋ฐ๋ผ๋ณด๊ณ ์๊ณ , ํด๋น interface๋ฅผ ์์๋ฐ๋ ์ด๋ค <**๊ฐ์ฒด**>๋ฅผ ์ฌ์ฉํ๊ณ ์ ํ  ๋,
2) ํด๋น Interface๋ฅผ ์์๋ฐ์ผ๋ฉด์ ๋์์ <**๊ฐ์ฒด**>๊ฐ ์ฌ์ฉ๋๋ <**ํ๋ก์ ๊ฐ์ฒด**>๋ฅผ ํ๋ ์์ฑํ๋ค.
3) ๋ถ๊ฐ์์์ ํ๊ฒ ๋๋ ๊ฒฝ์ฐ์ <**ํ๋ก์ ๊ฐ์ฒด**>๋ฅผ ํธ์ถํ๋ค.
4) ๋ถ๊ฐ์์์ด ํ์ ์๋ ๊ฒฝ์ฐ์ ์๋ <**๊ฐ์ฒด**>๋ฅผ ํธ์ถํ๋ค.

<br>

### ๐ป example 01
์ฉ๋์ด ํฐ ์ด๋ฏธ์ง์ ๊ธ์ด ํจ๊ป ์๋ ๋ฌธ์๋ฅผ ๋ชจ๋ํฐ์ ๋์ฐ๋ ์ํฉ

![](src/screenshot03.png)

- ํ์คํธ๋ ์ฉ๋์ด ์์๋ฐ ์ด๋ฏธ์ง ์ฉ๋์ด ์ปค์ ์ด๋ฏธ์ง๊ฐ ์ฝ๊ฐ ๋๋ฆฌ๊ฒ ๋ก๋ฉ๋๋ ๊ฒฝ์ฐ๊ฐ ์๋ค
- ๋ง์ฝ ๋ชจ๋ ๋ก๋ฉ์ด ๋ ํ์ ํ๋ฉด์ด ๋์ค๋ฉด ์๋ฏธ์๋ ๊ธฐ๋ค๋ฆผ์ด ์๊ธด๋ค
- ๋จผ์  ๋ก๋ฉ์ด ๋๋ ํ์คํธ๋ผ๋ ๋จผ์  ๋์ค๋๊ฒ ์ข๊ณ , ์ด๋ฐ ๋ฐฉ์์ ์ทจํ๊ธฐ ์ํด ํ์คํธ ์ฒ๋ฆฌ ํ๋ก์ธ์ / ๊ทธ๋ฆผ ์ฒ๋ฆฌ ํ๋ก์ธ์ค๋ฅผ ๋ณ๋๋ก ์ด์ํ๊ฒ ๋๋ค.

- ๊ฒฐ๊ตญ ํ๋ก์ ํจํด์ ๋ค๋ฅธ ๋ฌด์ธ๊ฐ์ ์ด์ด์ง๋ ์ธํฐํ์ด์ค์ ์ญํ ์ ํ๋ค.


<br>

### ๐ป example 02
ํ๊ธ๊ณผ ์นด๋์ ์ํฉ : ํ๊ธ์ผ๋ก ๋์ฉ๋(10์ต์ด ์๋ค๊ณ  ํ์๋)์ ๋ค๊ณ ๋ค๋๊ธฐ์ ๋๋ฌด ๋ถํธํ๋ค.
![](src/screenshot02.png)
- ํ๊ธ์ ๊ฒฐ์ ํ  ๋ ์ธ์ ์ฌ์ฉํ์ง ์์ง๋ง ๋ค๊ณ ๋ค๋๊ธฐ ๋ถํธํ๊ณ  ์ํํ๋ค.
- ์นด๋๋ ์์ ํ๊ณ  ๋ค๊ณ  ๋ค๋๊ธฐ์ ๋ถ๋ด์ด ์์ผ๋ฉฐ ํ๊ธ์ ๋์ ํ  ์ ์๋ค.


๋ง ์์ฒญ ์์๊ฐ ์๋ฟ์ง๋ ์๋๋ค.
์ฝ๋ ์์ ๋ฅผ ๋ณด๋ฉด์ ๊ณต๋ถ๋ฅผ ํด๋ณด์.



<br>

---

<br>

## โ ์ฝ๋ ์ค๋ช

<br>

### ๐ป Image (Interface)
```java
public interface Image {
    void displayImage();
}
```

<br>

### ๐ป Real_image
```java
package proxy_pattern.ExampleImage;

public class Real_Image implements Image{

    private String fileName;
    private String filepath;

    public Real_Image(String filepath) {
        this.filepath = filepath;
        fileName = loadFromDisk(filepath);
    }

    private String loadFromDisk(String filepath) {
        System.out.println("Loading... -> " + filepath);
        String[] pathName = filepath.split("/");
        String name = pathName[pathName.length-1];
        System.out.println("finished -> " + name);
        System.out.println();
        return name;
    }

    @Override
    public void displayImage() {
        System.out.println("Displaying -> " + fileName);
    }
}


```

<br>

### ๐ป Proxy_Image

```java
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
```

<br>

### ๐ป Main

```java
package proxy_pattern.ExampleImage;

public class Main {
    public static void main(String[] args) {

        /*
        // ํ๋ก์ ๋ฏธ์ฌ์ฉ
        Image img1 = new Real_Image("../src/file01");
        Image img2 = new Real_Image("../src/screenshot02");
        Image img3 = new Real_Image("../src/screenshot03");
        */


        //ํ๋ก์ ์ฌ์ฉ
        // 1) ํด๋ผ์ด์ธํธ๋ Real_Image์ ์ง์  ์ ๊ทผํ์ง ์๋๋ค.
        // 2) Proxy_Image ๊ฐ์ฒด๋ฅผ ์์ฑํ๋ค. Proxy๋ Real_Image์ displayImage()๋ฅผ ํธ์ถํ๋ค.
        Image img1 = new Proxy_Image("../src/file01");
        Image img2 = new Proxy_Image("../src/screenshot02");
        Image img3 = new Proxy_Image("../src/screenshot03");

        img1.displayImage();
        img2.displayImage();
        img3.displayImage();

    }
}
```

<br><br>



### โ๏ธ ํ๋ก์ ๋ฏธ์ฌ์ฉ ๊ฒฐ๊ณผ (Real_Image)
![](src/Use Class_Real_Image.png)

<br>

### โ๏ธ ํ๋ก์ ์ฌ์ฉ ๊ฒฐ๊ณผ (Proxy_Image)

![](src/Use Class_Proxy_Image.png)

1) Proxy_Main์์ Real_Image์ ์ง์  ์ ๊ทผํ์ง ์๊ณ  Proxy_Image ๊ฐ์ฒด๋ฅผ ์์ฑํ์ฌ ๋์  ์ํด. 
2) Proxy๋ displayImage() ๋ฉ์๋๋ฅผ ํธ์ถํ๊ณ  ๊ทธ ๋ฐํ๊ฐ์ Main์ ๋ฐํํจ




<br><br><br>

---


### references

<aside>

- https://coding-factory.tistory.com/711
- https://jdm.kr/blog/235

</aside>