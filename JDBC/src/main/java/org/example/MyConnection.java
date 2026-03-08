package org.example;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.sql.Date;
import java.util.Scanner;

public class MyConnection {
    public static void main(String[] args) {
        try {
            //Allow to connect to Databse
            Class.forName("com.mysql.cj.jdbc.Driver");//creates obj at runtime,loads the driver
            System.out.println("Driver Loaded.....");
            Connection con =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Sk@24sql");
            Statement stat = con.createStatement();
            System.out.println("Connected.....");
            ResultSet rs = stat.executeQuery("select * from emp");
            rs.next();//return boolean value, move pointer to next row and gives true if it has moved otherwise gives false
            while(rs.next()){

            System.out.println(rs.getString("ENAME")+"\t"+rs.getString(6)+"\t"+rs.getDate(5));
            rs.next();
            }

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Employee ID");
            int eid = sc.nextInt();

            PreparedStatement ps = con.prepareStatement("select * from emp where empno=? and deptno=?");//? - parameter ned to be set so dont use concatenation
            //ResultSet rs = stat.executeQuery("select * from emp where empno="+eid);
            ps.setInt(2,20);
            ps.setInt(1,7566);//if u have dynamic parameter
            ResultSet rs1 = ps.executeQuery();
            if(rs.next()){
                System.out.println(rs1.getString("ename")+"\t"+rs1.getString("job"));
            }else {
                System.out.println("employee not found");
            }

//            write the data
            PreparedStatement ps1 = con.prepareStatement("insert into emp values(?,?,?,?,?,?,?,?)");
            ps1.setInt(1,7134);
            ps1.setString(2,"Sakshi");
            ps1.setString(3,"Developer");
            ps1.setInt(4,7788);
            ps1.setDate(5,new Date(2026,2,24));
            ps1.setBigDecimal(6, BigDecimal.valueOf(70000.00));
            ps1.setBigDecimal(7, BigDecimal.valueOf(0.00));
            ps1.setInt(8,20);

            int row = ps1.executeUpdate();
            if(row>0){
                System.out.println("emp created");
            }
            else
                System.out.println("emp not created");

//            get their experience years

            ResultSet rs2 = stat.executeQuery("Select * from emp");
            while (rs2.next()){
                Date hire_d = rs2.getDate(5);
                LocalDate ls = ((java.sql.Date) hire_d).toLocalDate();
                //Period p = Period.between(ls,LocalDate.now()); //
                long c = ChronoUnit.YEARS.between(ls,LocalDate.now());
                System.out.println(c);
            }
        PreparedStatement ps3 = con.prepareStatement("delete from emp where empno=?");
        ps3.setInt(1,7900);
        ps3.execute();
        System.out.println("employee data deleted.....");

        PreparedStatement ps2 = con.prepareStatement("update emp set ename = 'Rohit' where empno = 7934");
        ps2.execute();
        System.out.println("Data Updated.........");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
