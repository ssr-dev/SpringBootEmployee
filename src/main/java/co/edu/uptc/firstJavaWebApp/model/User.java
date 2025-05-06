package co.edu.uptc.firstJavaWebApp.model;

public class User {
    private String username;
    private String password;

    public User() {
        username ="username";
        password = "1234567";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkUserInput(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
