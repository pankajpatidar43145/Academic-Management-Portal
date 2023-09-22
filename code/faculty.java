package org.example;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;

public class faculty {

    static Scanner sc = new Scanner(System.in);
    static Statement st=null;

    static String instructor_id;

    public static void Authentication() throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "12345678");
        st=conn.createStatement();


        System.out.println("Enter username");
        instructor_id = sc.nextLine();
        System.out.println("Enter password");
        String password= sc.nextLine();

        String q=String.format("Select * From faculty_login where instructor_id='%s';",instructor_id);
        ResultSet rs = st.executeQuery(q);
        rs.next();
        if(rs.getRow()==0){
            System.out.println("Incorrect UserName!");
            return;
        }
        String pwd = rs.getString("instructor_pass");

        if(password.equals(pwd)) {
            Dashboard();
        }
        else{
            System.out.println("Incorrect Password");
        }

    }


    public static void Dashboard() throws Exception {
        while(true){
            System.out.println("Enter 'A' for  Register course");
            System.out.println("Enter 'B' to deregister course");
            System.out.println("Enter 'C' to view grade");
            System.out.println("Enter 'D' to update grade");
            System.out.println("Enter '-1' to go back");
            String input =sc.nextLine();
            if(input.equals("A")){
                Register_course();
            } else if (input.equals("B")) {
                deregister_course();
            } else if (input.equals("C")) {

                view_grade();        }
            else if (input.equals("D")) {
                update_grade();       }
            else if (input.equals("-1")) {
                return;        }else{
                System.out.println("Enter a valid input");        }
        }}
    public static void Register_course() throws SQLException {
        System.out.println("Enter course id");
        String course_id=sc.nextLine();
        System.out.println("Enter current status");
        String current_status=sc.nextLine();
        System.out.println("Enter course semester");
        String course_semester=sc.nextLine();
        System.out.println("Enter course year");
        String course_year=sc.nextLine();
        System.out.println("Enter course credit");
        String course_credit=sc.nextLine();
        System.out.println("Enter instructor id");
        String instructor_id=sc.nextLine();
        System.out.println("Enter cgpa requirement");
        String cgpa_requirement=sc.nextLine();
        System.out.println("Enter prerequisite");
        String prerequisite=sc.nextLine();
        String q2= String.format("Select * From course_offer where course_id='%s' and course_semester='%s' and course_year='%s';",course_id,course_semester,course_year);
        ResultSet r2=st.executeQuery(q2);
        r2.next();
        if(r2.getRow()==0){
            System.out.println("Course offered/float");
            String q1= String.format("insert into course_offer values ('%s','%s','%s','%s','%s','%s','%s','%s');",course_id,current_status,course_semester,course_year,course_credit,instructor_id,cgpa_requirement,prerequisite);
            st.executeUpdate(q1);

        }
        else
        {
            System.out.println("Course already offered/float");
        }
    }
    public static void deregister_course() throws SQLException {
        System.out.println("Enter course id");
        String course_id=sc.nextLine();
        System.out.println("Enter current status");
        String current_status=sc.nextLine();
        System.out.println("Enter course semester");
        String course_semester=sc.nextLine();
        System.out.println("Enter course year");
        String course_year=sc.nextLine();
        System.out.println("Enter course credit");
        String course_credit=sc.nextLine();
        System.out.println("Enter instructor id");
        String instructor_id=sc.nextLine();
        System.out.println("Enter cgpa requirement");
        String cgpa_requirement=sc.nextLine();
        System.out.println("Enter prerequisite");
        String prerequisite=sc.nextLine();
        String q2=String.format("Select * From course_offer where course_id='%s' and course_semester='%s' and course_year='%s';",course_id,course_semester,course_year);
        ResultSet r2=st.executeQuery(q2);
        r2.next();
        if(r2.getRow()!=0){
            System.out.println("Course deregisterd");
            String q1= String.format("delete from course_offer where course_id='%s' and course_semester='%s' and course_year='%s';",course_id,course_semester,course_year);
            st.executeUpdate(q1);
        }
        else
        {
            System.out.println("Course already deregisterd");
        }
    }
    public static void view_grade() throws SQLException {
        System.out.println("Enter student id");
        String student_id=sc.nextLine();
        String q1=String.format("Select * From student_data where student_id='%s';",student_id);
        ResultSet r1=st.executeQuery(q1);
        boolean flag = false;
        while(r1.next()) {
            flag = true;
            System.out.println("student grade ==");
            System.out.print("student_id");
            System.out.print("=");
            System.out.print(r1.getString("student_id")+" ");
            System.out.print("course_id");
            System.out.print("=");
            System.out.print(r1.getString("course_id")+" ");
            System.out.print("course_name");
            System.out.print("=");
            System.out.println(r1.getString("course_name")+" ");
            System.out.print("current_status");
            System.out.print("=");
            System.out.println(r1.getString("current_status")+" ");
            System.out.print("course_credit");
            System.out.print("=");
            System.out.println(r1.getString("course_credit")+" ");
            System.out.print("course_semester");
            System.out.print("=");
            System.out.print(r1.getString("course_semester")+" ");
            System.out.print("course_year");
            System.out.print("=");
            System.out.println(r1.getString("course_year")+" ");
            System.out.print("student_grade");
            System.out.print("=");
            System.out.println(r1.getString("student_grade")+" ");
        }
        if(!flag)
        {
            System.out.println("No such Student in database");
        }
    }
    public static void update_grade() throws SQLException, IOException {
        System.out.println("Enter student id");
        String student_id=sc.nextLine();

        System.out.println("Enter course id");
        String course_id=sc.nextLine();
        System.out.println("Enter file address:");
        String gradefile=sc.nextLine();
        String q2=String.format("Select * From student_data where student_id='%s';",student_id);
        ResultSet r1=st.executeQuery(q2);
        r1.next();
        if(r1.getRow()==0)
        {
            System.out.println("no such student exist with this student id");
        }
        else {
            System.out.println("Marks are updated successfully");
            File file = new File(gradefile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] arr;
            while ((line = br.readLine()) != null) {
                arr = line.split(",");
                for (String a : arr) {
                    String q1 = "update student_data set grade=" + arr[1] + "current_status='Completed' where student_id=" + arr[0] + "course_id=" + course_id + ";";
                    st.executeUpdate(q1);
                }

            }
            br.close();

        }
    }

}
