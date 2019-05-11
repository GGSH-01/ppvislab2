package com.company;

public class Pacient {
    private String name, street, secondName, surname, DOB, DER, resume;
    private int house;

    public Pacient(String name, String secondName, String surname, String street,
                    int house, String DOB, String DER,String resume) {
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
        this.street = street;
        this.house = house;
        this.DOB = DOB;
        this.DER = DER;
        this.resume = resume;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() { return secondName; }

    public String getSurname() { return surname; }

    public String getStreet() { return  street; }

    public int getHouse() {return house; }

    public String getDOB() { return DOB; }

    public String getDER() { return DER; }

    public String getResume() { return resume; }

    public String getFullName() { return (getSurname() + getName() + getSecondName()); }

    public String getAddress() { return (getStreet() + getHouse()); }

    }


