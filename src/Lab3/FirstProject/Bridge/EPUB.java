package Lab3.FirstProject.Bridge;

public class EPUB implements FileType {

    @Override
    public String write() {
        return "epub";
    }
}
