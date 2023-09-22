package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;
import java.io.File;

public class Admin{

    static Scanner sc = new Scanner(System.in);
    static Statement st=null;
    static String Admin_id ;
    public static void Authentication() throws SQLException, ClassNotFoundException, IOException {
        Class.forName("org.postgresql.Driver");
        Connection conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "12345678");
        st=conn.createStatement();

        System.out.println("Enter username");
        Admin_id = sc.nextLine();
        System.out.println("Enter password");
        String password= sc.nextLine();

        String q=String.format("select * from admin where Admin_id='%s';",Admin_id);

        ResultSet rs = st.executeQuery(q);
        rs.next();
        if(rs.getRow()==0){
            System.out.println("Incorrect UserName!");
            return;
        }
        String pwd = rs.getString("Admin_pass");
        if(password.equals(pwd)) {
            dashboard();
        }
        else{
            System.out.println("Incorrect Password");
        }

    }
    public static void dashboard() throws SQLException, IOException {
        while(true){
            System.out.println("Enter 'A' to Add student");
            System.out.println("Enter 'B' to Add instructor");
            System.out.println("Enter 'C' to  Add new course()");
            System.out.println("Enter 'D' to  generate transcript");
            System.out.println("Enter 'E' to  view student record");
            System.out.println("Enter '-1' to go Back");
            String input = sc.nextLine();
            if(input.equals("A")){
                Add_student();
            } else if (input.equals("B")) {
                Add_instructor();
            } else if (input.equals("C")) {
                new_course();
            }
            else if (input.equals("D")) {
                generate_transcript();
            }
            else if (input.equals("E")) {
                view_student_record();
            }else if (input.equals("-1")) {

                return;        }
            else{

                System.out.println("Enter a valid Input");        }
        }}
    public static void Add_student() throws SQLException {
        System.out.println("Enter student id");
        String student_id=sc.nextLine();
        System.out.println("Enter student name");
        String student_name=sc.nextLine();
        System.out.println("Enter student dept name");
        String student_dept_name=sc.nextLine();
        System.out.println("Enter student batch");
        String student_batch=sc.nextLine();
        String q3=String.format("select * from student where student_id='%s';",student_id);
        ResultSet r3=st.executeQuery(q3);
        r3.next();
        if(r3.getRow()==0){
            String q4=String.format("insert into student values ('%s','%s','%s',%s);",student_id,student_name,student_dept_name,student_batch);
            st.executeUpdate(q4);
            String q66=String.format("insert into student_login values ('%s','%s');",student_id,student_id);
            st.executeUpdate(q66);
            System.out.println("Succesfully added.");}
        else
        {
            System.out.println("Student already exist");
        }
    }
    public static void Add_instructor() throws SQLException {
        System.out.println("Enter instructor id");
        String instructor_id=sc.nextLine();
        System.out.println("Enter instructor name");
        String instructor_name=sc.nextLine();
        System.out.println("Enter instructor dept_name");
        String instructor_dept_name=sc.nextLine();
        String q5=String.format("Select * From instructor where instructor_id='%s';",instructor_id);
        ResultSet r4=st.executeQuery(q5);
        r4.next();
        if(r4.getRow()==0){
            String q6=String.format("insert into instructor values ('%s','%s','%s');",instructor_id,instructor_name,instructor_dept_name);
            st.executeUpdate(q6);
            String q9=String.format("insert into faculty_login values ('%s','%s');",instructor_id,instructor_id);
            st.executeUpdate(q9);
            System.out.println("succesfully added");}
        else
        {
            System.out.println("instructor already exist");
        }
    }

    public static void new_course() throws SQLException {
        System.out.println("Enter course id");
        String course_id=sc.nextLine();
        System.out.println("Enter course name");
        String course_name=sc.nextLine();
        System.out.println("Enter course credit");
        String course_credit=sc.nextLine();
        System.out.println("Enter LTP");
        String LTP=sc.nextLine();
        System.out.println("Enter prerequisite");
        String prerequisite=sc.nextLine();
        String q2=String.format("Select * From course_catalog where course_id='%s';",course_id);
        ResultSet r2=st.executeQuery(q2);
        r2.next();
        if(r2.getRow()==0){
            String q1=String.format("insert into course_catalog values ('%s','%s','%s','%s','%s');",course_id,course_name,course_credit,LTP,prerequisite);

            st.executeUpdate(q1);
            System.out.println("Course successfully added");}
        else
        {
            System.out.println("Course already exists");
        }
    }
    public static void generate_transcript() throws IOException, SQLException {
        System.out.println("Enter student id");
        String student_id=sc.nextLine();

//        System.out.println("enter file address:");
//        String file= sc.next();
        File myObj = new File("C:\\Users\\Lenovo\\OneDrive\\Desktop\\Record\\"+"filename.txt");
        if (myObj.createNewFile()) {
            System.out.println("File created: ");
        } else {
            System.out.println("File already exists.");
        }
        String q1=String.format("Select * From student_data where student_id='%s';",student_id);
        ResultSet r1=st.executeQuery(q1);
        if(r1.getRow()==0)
        {
            System.out.println("no such student exist with this student id");
        }
        else{
            while(r1.next()){
                FileWriter myWriter = new FileWriter("filename.txt");
                myWriter.write("student_id");
                myWriter.close();}}


    }
    public static void view_student_record() throws SQLException {
        System.out.println("Enter student id");
        String student_id=sc.nextLine();
        String q7=String.format("Select * From student where student_id='%s';",student_id);
        ResultSet r5=st.executeQuery(q7);
        boolean flag = false;
        while(r5.next()) {
            flag = true;
            System.out.println("student record ==");
            System.out.print("student_id");
            System.out.print("=");
            System.out.print(r5.getString("student_id")+" ");
            System.out.print("student_name");
            System.out.print("=");
            System.out.print(r5.getString("student_name")+" ");
            System.out.print("student_dept_name");
            System.out.print("=");
            System.out.println(r5.getString("student_dept_name")+" ");
            System.out.print("student_batch");
            System.out.print("=");
            System.out.println(r5.getString("student_batch")+" ");
        }
        if(!flag)
        {
            System.out.println("No such Student in database");
        }
    }

}

