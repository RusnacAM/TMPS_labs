package Lab3.FirstProject.Adapter;

public class PdfFormat implements FileFormat {
    @Override
    public void readPdf(String bookName) {
        System.out.println("Reading pdf file. Book Name: " + bookName);
    }

    @Override
    public void readAzw4(String bookName) {

    }
}
