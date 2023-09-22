package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;

public class student {

    static Scanner sc = new Scanner(System.in);
    static String student_id;
    static Statement st=null;

    public static void Authentication() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "12345678");
        st=conn.createStatement();


        System.out.println("Enter username");
        student_id = sc.nextLine();
        System.out.println("Enter password");
        String password= sc.nextLine();

        String q=String.format("Select * From student_login where student_id='%s';",student_id);
        ResultSet rs = st.executeQuery(q);
        rs.next();
        if(rs.getRow()==0){
            System.out.println("Incorrect UserName!");
            return;
        }
        String pwd = rs.getString("student_pass");

        if(pwd.equals(password)) {
            dashboard();
        }
        else{
            System.out.println("Incorrect Password");
        }

    }
    public static void dashboard() throws SQLException {
        while(true){        System.out.println("Enter 'A' to Add course()");
            System.out.println("Enter 'B' to Drop course");
            System.out.println("Enter 'C' to  view grade");
            System.out.println("Enter '-1' to go Back");
            String input = sc.nextLine();
            if(input.equals("A")){
                Add_course();
            } else if (input.equals("B")) {
                Drop_course();
            } else if (input.equals("C")) {
                view_grade();
            } else if (input.equals("-1")) {
                return;        }else{
                System.out.println("Enter a valid Input");        }
        }}
    public static void Add_course() throws SQLException {
        System.out.println("Enter student id");
        String student_id=sc.nextLine();
        System.out.println("Enter course id");
        String course_id=sc.nextLine();
        String q1= String.format("Select * From student_data where student_id='%s' and course_id='%s';",student_id,course_id);
        ResultSet r1=st.executeQuery(q1);
        r1.next();
        if(r1.getRow()!=0)
        {
            System.out.println("Course already enrolled");
        }
        else {
            String q2 = String.format("Select * From course_offer where course_id='%s';",course_id);
            ResultSet r2 = st.executeQuery(q2);
            r2.next();
            String curr="completed";
            if(r2.getRow() == 0) {
                System.out.println("Course not floated");
                return;
            }
            int z11=0;
            String xy=r2.getString("prerequisite");
            if(xy.equals("NA"))
            {
                z11=-1;
            }
            String q3 = String.format("Select * From student_data where student_id='%s' and current_status='%s' and course_id='%s';",student_id,curr,xy);
            ResultSet r3 = st.executeQuery(q3);
            r3.next();
            if (r3.getRow() == 0 && z11==0) {
                System.out.println("Course not enrolled because of prerequisite");
            } else {
                float x = compute_cgpa();
                String q4 = String.format("Select * From course_offer where course_id='%s';",course_id);
                ResultSet r4 = st.executeQuery(q4);
                r4.next();
                String y = r4.getString("cgpa_requirement");
                float z = Float.parseFloat(y);
                if (x < z) {
                    System.out.println("Course not enrolled because of cgpa_requirement");
                } else {
                    float sc;
                    String q5 =String.format("Select * From student_data where student_id='%s';",student_id);
                    ResultSet r5 = st.executeQuery(q5);
                    while (r5.next()) {
                        String scs = r5.getString("course_credit");
                        sc = Float.parseFloat(scs);
                    }
                    float sy;
                    String q6 =String.format("Select * From student where student_id='%s';",student_id);
                    ResultSet r6 = st.executeQuery(q6);
                    r6.next();
                    String sys = r6.getString("student_batch");
                    int syss = Integer.parseInt(sys);
                    String q7 = String.format("Select * From current_status;");
                    ResultSet r7 = st.executeQuery(q7);
                    r7.next();
                    int student_sem = Integer.parseInt(r7.getString("current_semester"));
                    int student_year = Integer.parseInt(r7.getString("current_year")) - syss;
                    String q8 = String.format("Select * From student_data where student_id='%s' and course_semester='%s' and course_year='%s';",student_id,student_sem,student_year);
                    ResultSet r8 = st.executeQuery(q8);
                    r8.next();
                    float student_credit_com = 0;
                    while (r8.next()) {
                        student_credit_com += Float.parseFloat(r8.getString("course_credit"));
                    }
                    String q9 = String.format("Select * From Total_credit where current_semester='1';");
                    ResultSet r9 = st.executeQuery(q9);
                    r9.next();
                    Float sem11_credit = (float) 0;
                    sem11_credit = Float.parseFloat(r9.getString("Total_credit"));
                    String q10 = String.format("Select * From Total_credit where current_semester='2';");
                    ResultSet r10 = st.executeQuery(q10);
                    r10.next();
                    Float sem21_credit = (float) 0;
                    sem21_credit = Float.parseFloat(r10.getString("Total_credit"));
                    float sem_credit=0;
                    if (student_sem==1 && student_year == 1) {
                        sem_credit = sem11_credit;
                    }
                    if (student_sem == 2 && student_year == 1) {
                        sem_credit = sem21_credit;
                    }
                    if (student_sem == 1 && student_year == 2) {
                        sem_credit = (float) (1.25 * (sem11_credit + sem21_credit));
                        sem_credit = (float) sem_credit / 2;

                    }
                    if (student_sem == 2 && student_year == 2) {
                        sem_credit = (float) (5 * sem11_credit + 13 * sem21_credit);
                        sem_credit = (float) sem_credit / 16;
                    }
                    if (student_sem == 1 && student_year == 3) {
                        sem_credit = (float) (15 * sem11_credit + 23 * sem21_credit);
                        sem_credit = (float) sem_credit / 32;
                    }
                    if (student_sem == 2 && student_year == 3) {
                        sem_credit = (float) (25 * sem11_credit + 49 * sem21_credit);
                        sem_credit = (float) sem_credit / 64;
                    }
                    if (student_sem == 1 && student_year == 4) {
                        sem_credit = (float) (55 * sem11_credit + 95 * sem21_credit);
                        sem_credit = (float) sem_credit / 128;
                    }
                    if (student_sem == 2 && student_year == 4) {
                        sem_credit = (float) (105 * sem11_credit + 193 * sem21_credit);
                        sem_credit = (float) sem_credit / 256;
                    }
                    float avilable_creadit= sem_credit-student_credit_com;
                    String q11 =String.format("Select * From course_offer where course_id='%s' and course_semester='%s' and course_year='%s';",course_id,student_sem,student_year);
                    ResultSet r11 = st.executeQuery(q11);
                    r11.next();
                    float need_credit=0;
                    System.out.println();
                    if(r11.getRow()==0)
                    {
                        System.out.println("Course not enrolled/not floted");
                        return;
                    }
                    need_credit=Float.parseFloat(r11.getString("course_credit"));

                    if(avilable_creadit<need_credit)
                    {
                        System.out.println("Course not enrolled because of credit limit");
                    }
                    else
                    {
                        String q13 = String.format("Select * From course_catalog where course_id='%s';",course_id);
                        ResultSet r13 = st.executeQuery(q13);
                        r13.next();
                        String coursename=r13.getString("course_name");
                        String NA="NA";
                        String Runn="running";
                        String q12=String.format("insert into student_data values ('%s','%s','%s','%s','%s','%s','%s','%s');",student_id,course_id,coursename,Runn,need_credit,student_sem,student_year,NA);
                        st.executeUpdate(q12);
                        System.out.println("Course enrolled successfully");
                    }

                }
            }
        }
    }

    public static void Drop_course() throws SQLException {
        System.out.println("Enter student id");
        String student_id=sc.nextLine();
        System.out.println("Enter course id");
        String course_id=sc.nextLine();
        String q1 =String.format("Select * From student where student_id='%s';",student_id);
        ResultSet r1 = st.executeQuery(q1);
        r1.next();
        String sys = r1.getString("student_batch");
        int syss = Integer.parseInt(sys);
        String q7 = String.format("Select * From current_status;");
        ResultSet r7 = st.executeQuery(q7);
        r7.next();
        int student_sem = Integer.parseInt(r7.getString("current_semester"));
        int student_year = Integer.parseInt(r7.getString("current_year")) - syss;
        String Runn="running";
        String q2 = String.format("Select * From student_data where student_id='%s' and course_id='%s' and current_status='%s' and course_semester='%s' and course_year='%s';",student_id,course_id,Runn,student_sem,student_year);
        ResultSet r2 = st.executeQuery(q2);
        r2.next();
        if(r2.getRow()==0)
        {
            System.out.print("course already withdrawn");
        }
        else
        {
            String q3= String.format("delete from student_data where student_id='%s' and course_id='%s';",student_id,course_id);
            st.executeUpdate(q3);
            System.out.print("course withdrawn successfully");
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
    public static float compute_cgpa() throws SQLException {
        String q1 = String.format("Select * From student_data where student_id='%s';",student_id);
        ResultSet r1 = st.executeQuery(q1);
        float x = 0;
        float y = 0;
        float z = 0;
        while (r1.next()) {
            if (r1.getString("student_grade").equals("A")) {
                String s = r1.getString("course_credit");
                x += Integer.parseInt(s)* 10;
                y = y + Integer.parseInt(s);
            }
            if (r1.getString("student_grade").equals("A-")) {
                String s = r1.getString("course_credit");
                x += Integer.parseInt(s)* 9;
                y = y + Integer.parseInt(s);
            }
            if (r1.getString("student_grade").equals("B")) {
                String s = r1.getString("course_credit");
                x += Integer.parseInt(s)* 8;
                y = y + Integer.parseInt(s);
            }
            if (r1.getString("student_grade").equals("B-")) {

                String s = r1.getString("course_credit");
                x += Integer.parseInt(s)* 7;
                y = y + Integer.parseInt(s);
            }
            if (r1.getString("student_grade").equals("C")) {

                String s = r1.getString("course_credit");
                x += Integer.parseInt(s)* 6;
                y = y + Integer.parseInt(s);
            }
            if (r1.getString("student_grade").equals("C-")) {
                String s = r1.getString("course_credit");
                x += Integer.parseInt(s)* 5;
                y = y + Integer.parseInt(s);
            }
            if (r1.getString("student_grade").equals("D")) {
                String s = r1.getString("course_credit");
                x += Integer.parseInt(s)* 4;
                y = y + Integer.parseInt(s);
            }
        }
        z=x/y;
        return z;
    }

}