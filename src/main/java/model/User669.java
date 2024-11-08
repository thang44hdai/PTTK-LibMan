package model;

public class User669 {
    private String userId;
    private String username;
    private String password;
    private String name;
    private int role;

    public User669(){}

    public User669(String user_id, String username, String password, String name, int role) {
        this.userId = user_id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String user_id) {
        this.username = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
