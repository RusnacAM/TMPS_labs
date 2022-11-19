package Lab3.FirstProject;

import Lab3.FirstProject.Adapter.Kindle;
import Lab3.FirstProject.Bridge.*;

public class Main {
    public static void main(String[] args) {
        Ebook fantasy = new Fantasy(new EPUB());
        Ebook romance = new Romance(new AZW3());
        Ebook romance1 = new Romance(new AZW4());
        Ebook fantasy1 = new Fantasy(new PDF());

        String fantasyFileType = fantasy.toString();
        String romanceFileType = romance.toString();
        String romance1FileType = romance1.toString();
        String fantasy1FileType = fantasy1.toString();

        Kindle kindle = new Kindle();

        //Adapter Demo

        kindle.read(fantasy1FileType, "Little Women");
        kindle.read(romance1FileType, "Pride and Prejudice");
        kindle.read(romanceFileType, "Wuthering Heights");
        kindle.read(fantasyFileType, "Lolita");
        kindle.read("docx", "War and Peace");
    }

}
