package sample;

public class teachers {
    public String tName;
    public String tpass;



    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getTpass() {
        return tpass;
    }

    public void setTpass(String tpass) {
        this.tpass = tpass;
    }

    public teachers() {
        this.tName = tName;
        this.tpass = tpass;
    }
    public teachers(String tName, String tpass) {
        this.tName = tName;
        this.tpass = tpass;
    }
    @Override
    public String toString() {
        return ("teacher's name:"+this.tName+
                " passwors: "+ this.tpass);
    }
}
