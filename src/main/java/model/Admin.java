package model;

public class Admin {
    private int id_adm;
    private String login;
    private String password;

    public Admin() {
    }
    
    public int getIdAdmin() {
        return id_adm;
    }

    public void setIdAdmin(int id_adm) {
        this.id_adm = id_adm;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}