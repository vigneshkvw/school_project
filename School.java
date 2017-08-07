/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author viki
 */
class School {
    private static Connection Connection;
    static void getConnection() throws SQLException{
    Connection =DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/Banking?useSSL=false","root", "viki");
}
Scanner in=new Scanner(System.in);
    private Connection conn;

    void create() throws SQLException {
        System.out.print("1.student\t2.staff");
        int ch=in.nextInt();
        switch(ch){
            case 1:
                student();
                break;
            case 2:
                staff();
                break;
            case 3:
                System.exit(ch);
        }
    System.out.println("entry created");
   in.close();
    }

    void update() throws SQLException {
    System.out.print("1.update student\t2.update staff");
        int ch=in.nextInt();
        switch(ch){
            case 1:
                update_student();
                break;
            case 2:
                update_staff();
                break;
        }
in.close();
    }

    void view() throws SQLException {
    System.out.print("1.view student\t2.view staff");
        int ch=in.nextInt();
        switch(ch){
            case 1:
                view_student();
                break;
            case 2:
                view_staff();
                break;
        }

in.close();
    }

    private  void staff() throws SQLException {
          System.out.println("enter your id");
         backend.setId(in.next());
    System.out.println("enter your name :");
    backend.setName(in.next());
    System.out.println("enter date of Birth :");
    backend.setDoB(in.next());
    System.out.println("enter address :");
    backend.setaddress(in.next());
    System.out.println("enter  phone :");
    backend.setphone(in.next());
  getConnection();
             conn=Connection;
     String insertTableSQL = "INSERT INTO banking.staff"+"(id,Staff_name,DOB,address,phone) VALUES"+"(?,?,?,?,?)";
       PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
        preparedStatement.setString(1,backend.getId());
       preparedStatement.setString(2, backend.getName());
       preparedStatement.setString(3, backend.getDoB());
       preparedStatement.setString(4, backend.getaddress());
       preparedStatement.setString(5, backend.getphone());
       preparedStatement.executeUpdate();

    }

     private void student() throws SQLException {
         System.out.println("enter your id");
         backend.setId(in.next());
         System.out.println("enter your name :");
    backend.setName(in.next());
    System.out.println("enter date of Birth :");
    backend.setDoB(in.next());
    System.out.println("enter address :");
    backend.setaddress(in.next());
    System.out.println("enter  phone :");
    backend.setphone(in.next());
     getConnection();
             conn=Connection;
     String insertTableSQL = "INSERT INTO banking.student"+"(id,Student_name,DOB,address,phone) VALUES"+"(?,?,?,?,?)";
       PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
        preparedStatement.setString(1,backend.getId());
       preparedStatement.setString(2, backend.getName());
       preparedStatement.setString(3, backend.getDoB());
       preparedStatement.setString(4, backend.getaddress());
       preparedStatement.setString(5, backend.getphone());
       preparedStatement.executeUpdate();

     }

    private void update_Staff_address() throws SQLException {
        getConnection();
        conn=Connection;
        System.out.println("enter name :");
        backend.setName(in.next());
        System.out.println("enter address :");
        backend.setaddress(in.next());
            PreparedStatement ps = conn.prepareStatement("update banking.staff set address = ?  where Staff_name = ?");
System.out.println("hahaha");
                    ps.setString(2,backend.getName() );
                    ps.setString(1, backend.getaddress());
                    ps.executeUpdate();

    System.out.println(backend.getaddress()       +backend.getName()+   " address changed");
    }

    private void update_Student_address() throws SQLException {
        getConnection();
        conn=Connection;
        System.out.println("enter name :");
        backend.setName(in.next());
        System.out.println("enter address :");
        backend.setaddress(in.next());
            PreparedStatement ps = conn.prepareStatement("update banking.student set address = ?  where Student_name = ?");
System.out.println("hahaha");
                    ps.setString(2,backend.getName() );
                    ps.setString(1, backend.getaddress());
                    ps.executeUpdate();

    System.out.println(backend.getaddress()       +backend.getName()+   " address changed");

    }

    private void update_Student_phone() throws SQLException {
    getConnection();
        conn=Connection;
        System.out.println("enter name :");
        backend.setName(in.next());
        System.out.println("enter address :");
        backend.setphone(in.next());
                    PreparedStatement ps = conn.prepareStatement("update banking.student set phone = ?  where Student_name = ?");
                    ps.setString(2,backend.getName() );
                    ps.setString(1, backend.getphone());
                    ps.executeUpdate();

    System.out.println(backend.getphone()       +backend.getName()+   " address changed");


    }

    private void update_phone() throws SQLException {
   getConnection();
        conn=Connection;
        System.out.println("enter name :");
        backend.setName(in.next());
        System.out.println("enter address :");
        backend.setphone(in.next());
            PreparedStatement ps = conn.prepareStatement("update banking.staff set phone = ?  where Staff_name = ?");
System.out.println("hahaha");
                    ps.setString(2,backend.getName() );
                    ps.setString(1, backend.getphone());
                    ps.executeUpdate();

    System.out.println(backend.getphone()       +backend.getName()+   " address changed");

 }

    private void update_staff() throws SQLException {
int ch=in.nextInt();
System.out.println("1.update address\t2update phone");
switch(ch){
    case 1:
        update_Staff_address();
        break;
    case 2:
        update_phone();
break;
    case 3:
        System.exit(ch);
    }
in.close();
    }

    private void update_student() throws SQLException {
int ch=in.nextInt();
System.out.println("1.update address\t2update phone");
switch(ch){
    case 1:
        update_Student_address();
        break;
    case 2:
        update_Student_phone();
break;
    case 3:
        System.exit(ch);
    }
in.close();
    }

    private void view_staff() throws SQLException {
getConnection();
        conn=Connection;
         System.out.println("enter your id");
         backend.setId(in.next());
        String sqlverification = "SELECT * FROM banking.staff where id = ? ";
PreparedStatement preparedSelect = (PreparedStatement) conn.prepareStatement(sqlverification);
            preparedSelect.setString(1, backend.getId());
     System.out.println("sucess");
    ResultSet rs1 = (ResultSet) preparedSelect.executeQuery();
            while (rs1.next()) {
                 int id = rs1.getInt("id");
                  String Student_name = rs1.getString("Staff_name");
                 Date dateofbirth = rs1.getDate("DOB");
                  String address1 = rs1.getString("address");
                    String phonenum = rs1.getString("phone");

                    System.out.format("%s, %s, %s, %s\n", id, Student_name,dateofbirth,address1,phonenum );

            }
    }

    

    private void view_student() throws SQLException {
        getConnection();
        conn=Connection;
         System.out.println("enter your id");
         backend.setId(in.next());
        String sqlverification = "SELECT * FROM banking.student where id = ? ";
PreparedStatement preparedSelect = (PreparedStatement) conn.prepareStatement(sqlverification);
            preparedSelect.setString(1, backend.getId());
     System.out.println("sucess");
    ResultSet rs1 = (ResultSet) preparedSelect.executeQuery();
            while (rs1.next()) {
                 int id = rs1.getInt("id");
                  String Student_name = rs1.getString("Student_name");
                 Date dateofbirth = rs1.getDate("DOB");
                  String address1 = rs1.getString("address");
                    String phonenum = rs1.getString("phone");

                    System.out.format("%s, %s, %s, %s\n", id, Student_name,dateofbirth,address1,phonenum );

            }
    }

}
