package cursoSpringBoot.domain;


public class Customer {

    private int id;
    private String name, userName, password;

    public Customer(int id, String name, String usaerName, String password) {
        this.id = id;
        this.name = name;
        this.userName = usaerName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsaerName() {
        return userName;
    }

    public void setUsaerName(String usaerName) {
        this.userName = usaerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
