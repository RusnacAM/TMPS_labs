package Lab3.FirstProject.Adapter;

public class Azw4Format implements FileFormat {
    @Override
    public void readPdf(String bookName) {

    }

    @Override
    public void readAzw4(String bookName) {
        System.out.println("Reading azw4 file. Book Name: " + bookName);
    }
}
