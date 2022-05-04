package sample;

import java.util.Date;

public class students {
    String name ;
    String lastNAme;
    Date bDay;
    String sClass;
    String email;

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastNAme() {
        return lastNAme;
    }

    public void setLastNAme(String lastNAme) {
        this.lastNAme = lastNAme;
    }

    public Date getbDay() {
        return bDay;
    }

    public void setbDay(Date bDay) {
        this.bDay = bDay;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public students() {
    }
    public students(String name, String lastNAme, Date bDay, String sClass, String email) {
        this.name = name;
        this.lastNAme = lastNAme;
        this.bDay = bDay;
        this.sClass = sClass;
        this.email = email;
    }
@Override
public String toString() {
    return ("student's full name: "+this.name+" "+this.lastNAme+
            " born in : "+ this.bDay.toString()+" studying in : "+" email : "+this.email);
}
}
