package Lab3.FirstProject.Bridge;

public class PDF implements FileType{
    @Override
    public String write() {
        return "pdf";
    }
}
