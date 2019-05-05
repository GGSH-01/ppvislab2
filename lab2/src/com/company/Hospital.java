package com.company;

public class Hospital {
    private String name, address, secondName, surname, DOB, DER, medicName, medicSecondName, medicSurname, resume;

    public Hospital(String name, String secondName, String surname, String address, String DOB, String DER, String medicName, String medicSecondName, String medicSurname, String resume) {
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
        this.address = address;
        this.DOB = DOB;
        this.DER = DER;
        this.medicName = medicName;
        this.medicSecondName = medicSecondName;
        this.medicSurname = medicSurname;
        this.resume = resume;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() { return secondName; }

    public String getSurname() { return surname; }

    public String getAddress() { return address; }

    public String getDOB() { return DOB; }

    public String getDER() { return DER; }

    public String getMedicName() { return medicName; }

    public String getMedicSecondName() {return medicSecondName; }

    public String getMedicSurname() {return  medicSurname; }

    public String getResume() { return resume; }


    }


