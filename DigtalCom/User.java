package DigtalCom;

import java.util.ArrayList;

public class User {
    private String userid;

    public String getUserid() {
        return userid;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void addUser(String userid,String password){
        this.userid = userid;
        this.password = password;

    }

    public boolean IsAuthenticated(String userid,String password){
        IValidate check = (u,p)-> u.equals(this.userid) && p.equals(this.password);


        return check.IsAuthenticated(userid,password);
    }
}
