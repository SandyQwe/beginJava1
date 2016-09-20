package geekbrains.java2.lesson3.homework;


public class Memo {
    private String name;
    private String phoneNumber;
    private String email;

    Memo (String name, String phoneNumber, String email){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public boolean equals (String name){
        return this.name.equals(name);
    }
}
