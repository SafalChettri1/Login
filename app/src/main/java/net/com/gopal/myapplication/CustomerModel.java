package net.com.gopal.FoodApp;

public class CustomerModel {
    private String name;
    private String username;
    private int phone_no;
    private String Email;
    private String password;

    @Override
    public String toString() {
        return "CustomerModel{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", phone_no=" + phone_no +
                ", Email='" + Email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(int phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CustomerModel(String name, String username, int phone_no, String email, String password) {
        this.name = name;
        this.username = username;
        this.phone_no = phone_no;
        this.Email = email;
        this.password = password;
    }


}
