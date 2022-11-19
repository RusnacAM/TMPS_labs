package Lab3.FirstProject.Bridge;

public abstract class Ebook {
    protected FileType fileType;

    public Ebook(FileType fileType) {
        this.fileType = fileType;
    }

    abstract public String getFile();

    @Override
    public String toString() {
        return fileType.write();
    }
}
