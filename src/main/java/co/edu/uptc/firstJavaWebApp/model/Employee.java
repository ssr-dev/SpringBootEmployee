package co.edu.uptc.firstJavaWebApp.model;

public class Employee {
    private int id;
    private String name;
    private String email;
    private long phone;

    public Employee() {
    }

    public Employee(int id, String name, String email, long phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public long getPhone() {
        return phone;
    }

    @Override
    public String toString(){
        return "Employee [id=" + id +", name="+name+", email="+email+", phone="+phone+ "]";
    }

}
