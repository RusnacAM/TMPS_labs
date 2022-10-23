package Lab2.Singleton;

public class Database {
    private static Database instance;

    private Database(){
    }

    public static Database getInstance(int id){
        if(Database.instance == null){
            Database.instance = new Database();
        }
        return Database.instance;
    }
}
