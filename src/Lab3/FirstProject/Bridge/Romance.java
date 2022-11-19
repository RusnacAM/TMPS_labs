package Lab3.FirstProject.Bridge;

public class Romance extends Ebook {

    public Romance(FileType fileType) {
        super(fileType);
    }

    @Override
    public String getFile() {
        return "Fantasy Book." + fileType.write();
    }
}
