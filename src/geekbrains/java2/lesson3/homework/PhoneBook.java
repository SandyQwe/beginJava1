package geekbrains.java2.lesson3.homework;

import java.util.ArrayList;

public class PhoneBook {
    private ArrayList<Memo> phoneBook = new ArrayList<>();

    public void add (String name, String phoneNumber, String email) {
        this.phoneBook.add(new Memo(name, phoneNumber,email));
    }

    public ArrayList <String> searchPhoneNumber (String name) {
        ArrayList <String> phones = new ArrayList<>();
        for (int i = 0; i < phoneBook.size(); i++) {
            if (this.phoneBook.get(i).getName().equals(name)) phones.add(this.phoneBook.get(i).getPhoneNumber());
        }
        return phones;
    }

    public ArrayList <String> searchEmail (String name) {
        ArrayList <String> emails = new ArrayList<>();
        for (int i = 0; i < phoneBook.size(); i++) {
            if (this.phoneBook.get(i).equals(name)) emails.add(this.phoneBook.get(i).getEmail());
        }
        return emails;
    }
}
