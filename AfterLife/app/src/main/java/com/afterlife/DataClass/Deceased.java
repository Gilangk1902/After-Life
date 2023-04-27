package com.afterlife.DataClass;

import java.util.Calendar;
import java.util.Date;

public class Deceased {
    String name;
    int SIN;
    Date date_of_birth;
    Date date_of_death;
    String gender;
    String religion;

    public Deceased(String name, int SIN, Date date_of_birth, Date date_of_death, String gender, String religion) {
        this.name = name;
        this.SIN = SIN;
        this.date_of_birth = date_of_birth;
        this.date_of_death = date_of_death;
        this.gender = gender;
        this.religion = religion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSIN() {
        return SIN;
    }

    public void setSIN(int SIN) {
        this.SIN = SIN;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(int day, int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.YEAR, year);

        Date new_date_of_birth = cal.getTime();
        this.date_of_birth = new_date_of_birth;
    }

    public void set_step1(String name, int SIN, Calendar birth, Calendar death, String gender, String religion){
        setName(name);
        setSIN(SIN);
        setDate_of_birth(birth.get(Calendar.DAY_OF_MONTH),
                        birth.get(Calendar.MONTH),
                        birth.get(Calendar.YEAR));
        setDate_of_death(death.get(Calendar.DAY_OF_MONTH),
                        death.get(Calendar.MONTH),
                        death.get(Calendar.YEAR));
        setReligion(religion);
        setGender(gender);
    }

    public Date getDate_of_death() {
        return date_of_death;
    }

    public void setDate_of_death(int day, int month, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.YEAR, year);

        Date new_date_of_death = cal.getTime();
        this.date_of_death = new_date_of_death;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }
}
