package com.company;

public class Medic {
    private String medicName, medicSecondName, medicSurname;

    public Medic(String medicName, String medicSecondName, String medicSurname){
        this.medicName = medicName;
        this.medicSecondName = medicSecondName;
        this.medicSurname = medicSurname;
    }

    public String getMedicName() { return medicName; }

    public String getMedicSecondName() {return medicSecondName; }

    public String getMedicSurname() {return  medicSurname; }

    public String getMedicFullName() { return (getMedicSurname() + getMedicName() + getMedicSecondName() );}
}
