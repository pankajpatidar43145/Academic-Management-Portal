package org.example;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        System.out.println("Enter 1 to open Admin");
        System.out.println("Enter 2 to open faculty");
        System.out.println("Enter 3 to open student");
        String str=s.nextLine();
        if(str.equals("1")){
            Admin ad=new Admin();
            ad.Authentication();

        } else if (str.equals("2")) {
            faculty fac=new faculty();
            fac.Authentication();
        } else if (str.equals("3")) {
            student st=new student();
            st.Authentication();
        }else{
            System.out.println("Enter valid number");
        }
    }
}
