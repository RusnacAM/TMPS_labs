package Lab3.FirstProject.Adapter;

public class FormatAdapter implements SupportedFormat {

   FileFormat unsupportedFormat;

   public FormatAdapter(String fileType) {
       if(fileType.equalsIgnoreCase("pdf")) {
           unsupportedFormat = new PdfFormat();
       } else if(fileType.equalsIgnoreCase("azw4")) {
           unsupportedFormat = new Azw4Format();
       }
   }

    @Override
    public void read(String fileType, String bookName) {
        if(fileType.equalsIgnoreCase("pdf")) {
            unsupportedFormat.readPdf(bookName);
        } else if(fileType.equalsIgnoreCase("azw4")) {
            unsupportedFormat.readAzw4(bookName);
        }
    }
}
