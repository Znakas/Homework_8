package thinkmobiles.com.homework_8;

import java.io.Serializable;

/**
 * Created by Andrii on 12.03.2016.
 */
public class Person implements Serializable{
    private String name;
    private String l_name;
    private String gender;
    private String age;
    private String phone;

    public Person(){}

    public Person(String person_name, String last_name) {
        setName(person_name);
        setLastName(last_name);
    }

    public String getName() {
        return name;
    }
    public void setName(String sName) {
        name = sName;
    }
    public String getLastName() {
        return l_name;
    }
    public void setLastName(String last_n){
        l_name = last_n;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String _gender){
        gender = _gender;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String _age){
        age = _age;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String _phone){
        phone = _phone;
    }
}