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
