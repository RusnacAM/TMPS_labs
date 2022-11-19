package Lab3.FirstProject.Adapter;

public class Kindle implements SupportedFormat {
    FormatAdapter formatAdapter;

    @Override
    public void read(String fileType, String bookName) {
        if (fileType.equalsIgnoreCase("epub")) {
            System.out.println("Reading epub file. Book Name: " + bookName);
        } else if (fileType.equalsIgnoreCase("azw3")) {
            System.out.println("Reading epub azw3. Book Name: " + bookName);
        } else if (fileType.equalsIgnoreCase("pdf") || fileType.equalsIgnoreCase("azw4")) {
            formatAdapter = new FormatAdapter(fileType);
            formatAdapter.read(fileType, bookName);
        } else {
            System.out.println("Invalid format type. " + fileType + " format not supported.");
        }
    }

}
