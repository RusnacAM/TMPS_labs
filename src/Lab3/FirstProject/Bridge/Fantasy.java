package Lab3.FirstProject.Bridge;

public class Fantasy extends Ebook {

    public Fantasy(FileType fileType) {
        super(fileType);
    }

    @Override
    public String getFile() {
        return "Fantasy Book." + fileType.write();
    }
}
