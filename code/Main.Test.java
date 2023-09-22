import org.example.Admin;
import org.example.student;
import org.example.faculty;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

class mainTest {
    private static final InputStream x = System.in;
    private static final PrintStream y = System.out;

    private static ByteArrayInputStream newIn;
    private static ByteArrayOutputStream newOut;
    public static void SetNewOutput(){
        newOut =  new ByteArrayOutputStream();
        System.setOut(new PrintStream(newOut));
    }

    public static void SetNewInput(String input){

        newIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(newIn);
    }

    public static void restore(){
        System.setIn(x);
        System.setOut(y);
    }


    @Test
    public void auth()throws Exception{
        String a="xyz\nxyz\n";
        SetNewInput(a);
        SetNewOutput();
        Admin.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Incorrect UserName!"));
    }

    @Test
    public void auth1()throws Exception{
        String a="3431\n2334\n";
        SetNewInput(a);
        SetNewOutput();
        Admin.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Incorrect UserName!"));
    }

    @Test
    public void auth2()throws Exception{
        String a="3431@332II\n2334\n";
        SetNewInput(a);
        SetNewOutput();
        Admin.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Incorrect UserName!"));
    }

    @Test
    public void auth3()throws Exception{
        String a="2008IITR1001\n2334\n";
        SetNewInput(a);
        SetNewOutput();
        Admin.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Incorrect Password"));
    }

    @Test
    public void auth4()throws Exception{
        String a="2008IITR1001\nIIITRRR\n";
        SetNewInput(a);
        SetNewOutput();
        Admin.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Incorrect Password"));
    }

    @Test
    public void auth5()throws Exception{
        String a="3431\n2334\n";
        SetNewInput(a);
        SetNewOutput();
        student.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Incorrect UserName!"));
    }

    @Test
    public void auth6()throws Exception{
        String a="IIIUU##\n2334\n";
        SetNewInput(a);
        SetNewOutput();
        student.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Incorrect UserName!"));
    }

    @Test
    public void auth7()throws Exception{
        String a="IIIUU##72772\n2334\n";
        SetNewInput(a);
        SetNewOutput();
        student.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Incorrect UserName!"));
    }

    @Test
    public void auth8()throws Exception{
        String a="2020csb1104\n2334\n";
        SetNewInput(a);
        SetNewOutput();
        student.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Incorrect Password"));
    }

    @Test
    public void auth9()throws Exception{
        String a="2020csb1104\n2334yyyy\n";
        SetNewInput(a);
        SetNewOutput();
        student.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Incorrect Password"));
    }

    @Test
    public void auth10()throws Exception{
        String a="3431\n2334\n";
        SetNewInput(a);
        SetNewOutput();
        faculty.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Incorrect UserName!"));
    }

    @Test
    public void auth11()throws Exception{
        String a="3431GG\n2334\n";
        SetNewInput(a);
        SetNewOutput();
        faculty.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Incorrect UserName!"));
    }

    @Test
    public void auth12()throws Exception{
        String a="3431TTT\n2334\n";
        SetNewInput(a);
        SetNewOutput();
        faculty.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Incorrect UserName!"));
    }

    @Test
    public void auth13()throws Exception{
        String a="2000csb2000\n2334\n";
        SetNewInput(a);
        SetNewOutput();
        faculty.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Incorrect Password"));
    }

    @Test
    public void auth14()throws Exception{
        String a="2000csb2000\n2334IIIT\n";
        SetNewInput(a);
        SetNewOutput();
        faculty.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Incorrect Password"));
    }


    @Test
    public void auth16()throws Exception{
        String a="2008IITR1001\n2008IITR1001\nB\npankaj2022\npankaj\ncse\n-1\n";
        SetNewInput(a);
      SetNewOutput();
      Admin.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("succesfully added"));
    }

    @Test
    public void auth17()throws Exception{
        String a="2008IITR1001\n2008IITR1001\nB\n2000csb2000\npankaj\ncse\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        Admin.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("succesfully added"));
    }

    @Test
    public void auth18()throws Exception{
        String a="2008IITR1001\n2008IITR1001\nB\n2000csb2000\npankaj\ncse\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        Admin.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("instructor already exist"));
    }

    @Test
    public void auth19()throws Exception{
        String a="2008IITR1001\n2008IITR1001\nB\n2000csb2000\npankaj33\ncse\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        Admin.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("instructor already exist"));
    }

    @Test
    public void auth20()throws Exception{
        String a="2008IITR1001\n2008IITR1001\nA\n2020csb1104\nmadhur\ncse\n2020\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        Admin.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Succesfully added."));
    }

    @Test
    public void auth21()throws Exception{
        String a="2008IITR1001\n2008IITR1001\nA\n2020csb1106\npankaj\ncse\n2020\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        Admin.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Succesfully added."));
    }

    @Test
    public void auth22()throws Exception{
        String a="2008IITR1001\n2008IITR1001\nA\n2020csb1104\npankaj\ncse\n2020\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        Admin.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Student already exist"));
    }

    @Test
    public void auth23()throws Exception{
        String a="2008IITR1001\n2008IITR1001\nA\n2020csb1104\npankajiiii\ncse\n2020\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        Admin.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Student already exist"));
    }

    @Test
    public void auth24()throws Exception{
        String a="2008IITR1001\n2008IITR1001\nC\ncs104\nmaths\n3\n3-4-5\nNA\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        Admin.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Course already exists"));
    }

    @Test
    public void auth25()throws Exception{
        String a="2008IITR1001\n2008IITR1001\nC\ncs105\nmaths1\n3\n3-4-5\nNA\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        Admin.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Course already exists"));
    }

    @Test
    public void auth26()throws Exception{
        String a="2008IITR1001\n2008IITR1001\nC\ncs104\nmaths1\n3\n3-4-5\nNA\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        Admin.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Course successfully added"));
    }

    @Test
    public void auth27()throws Exception{
        String a="2008IITR1001\n2008IITR1001\nC\ncs105\nmaths1\n3\n3-4-5\nNA\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        Admin.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Course successfully added"));
    }

    @Test
    public void auth28()throws Exception{
        String a="2008IITR1001\n2008IITR1001\nE\n2020csb1111\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        Admin.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("No such Student in database"));
    }
    @Test
    public void auth29()throws Exception{
        String a="2008IITR1001\n2008IITR1001\nE\n2020csb11991\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        Admin.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("No such Student in database"));
    }

    @Test
    public void auth30()throws Exception{
        String a="2008IITR1001\n2008IITR1001\nE\n2020csb1104\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        Admin.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("student record =="));
    }

    @Test
    public void auth31()throws Exception{
        String a="2008IITR1001\n2008IITR1001\nD\n2020csb1104\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        Admin.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("File created"));
    }

    @Test
    public void auth32()throws Exception{
        String a="2008IITR1001\n2008IITR1001\nD\n2020csb1104\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        Admin.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("File already exists."));
    }

    @Test
    public void auth33()throws Exception{
        String a="2000csb2000\n2000csb2000\nA\ncs304\nrunning\n2\n3\n4\npankaj123\n6\n0\nNA\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        faculty.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Course already offered/float"));
    }

    @Test
    public void auth34()throws Exception{
        String a="2000csb2000\n2000csb2000\nA\ncs304\nrunning\n2\n3\n4\npankaj123\n6\n0\nNA\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        faculty.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Course already offered/float"));
    }

    @Test
    public void auth35()throws Exception{
        String a="2000csb2000\n2000csb2000\nA\ncs303\nrunning\n2\n3\n4\npankaj123\n6\nNA\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        faculty.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Course already offered/float"));
    }

    @Test
    public void auth36()throws Exception{
        String a="2000csb2000\n2000csb2000\nA\ncs304\nrunning\n2\n3\n4\npankaj123\n6\nNA\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        faculty.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Course offered/float"));
    }

    @Test
    public void auth111()throws Exception{
        String a="2000csb2000\n2000csb2000\nA\ncs303\nrunning\n2\n3\n4\npankaj123\n6\nNA\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        faculty.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Course offered/float"));
    }

    @Test
    public void auth37()throws Exception{
        String a="2000csb2000\n2000csb2000\nB\ncs304\nrunning\n2\n3\n4\npankaj123\n6\n0\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        faculty.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Course deregisterd"));
    }

    @Test
    public void auth38()throws Exception{
        String a="2000csb2000\n2000csb2000\nB\ncs303\nrunning\n2\n3\n4\npankaj123\n6\n0\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        faculty.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Course deregisterd"));
    }

    @Test
    public void auth39()throws Exception{
        String a="2000csb2000\n2000csb2000\nB\ncs303\nrunning\n2\n3\n4\npankaj123\n6\n0\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        faculty.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Course already deregisterd"));
    }

    @Test
    public void auth40()throws Exception{
        String a="2000csb2000\n2000csb2000\nB\ncs303\nrunning\n2\n3\n4\npankaj123\n6\n0\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        faculty.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Course already deregisterd"));
    }

    @Test
    public void auth41()throws Exception{
        String a="2000csb2000\n2000csb2000\nC\n2020csb1104\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        faculty.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("student grade =="));
    }

    @Test
    public void auth42()throws Exception{
        String a="2000csb2000\n2000csb2000\nC\n2020csb1105\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        faculty.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("No such Student in database"));
    }

    @Test
    public void auth43()throws Exception{
        String a="2000csb2000\n2000csb2000\nC\n2020csb1106\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        faculty.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("No such Student in database"));
    }

    @Test
    public void auth44()throws Exception{
        String a="2000csb2000\n2000csb2000\nC\n2020csb11066\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        faculty.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("No such Student in database"));
    }

    @Test
    public void auth45()throws Exception{
        String a="2000csb2000\n2000csb2000\nD\n2020csb11066\ncs308\nC:\\Users\\Lenovo\\OneDrive\\Documents\\grade.txt\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        faculty.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("no such student exist with this student id"));
    }

    @Test
    public void auth46()throws Exception{
        String a="2000csb2000\n2000csb2000\nD\n2020csb11099\ncs308\nC:\\Users\\Lenovo\\OneDrive\\Documents\\grade.txt\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        faculty.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("no such student exist with this student id"));
    }

    @Test
    public void auth47()throws Exception{
        String a="2000csb2000\n2000csb2000\nD\n2020csb1104\ncs301\nC:\\Users\\Lenovo\\OneDrive\\Documents\\grade.txt\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        faculty.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Marks are updated successfully"));
    }

    @Test
    public void auth48()throws Exception{
        String a="2000csb2000\n2000csb2000\n99\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        faculty.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Enter a valid input"));
    }

    @Test
    public void auth49()throws Exception{
        String a="2008IITR1001\n2008IITR1001\n99\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        Admin.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Enter a valid Input"));
    }

    @Test
    public void auth50()throws Exception{
        String a="2020csb1104\n2020csb1104\n99\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        student.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Enter a valid Input"));
    }

    @Test
    public void auth51()throws Exception{
        String a="2020csb11033\n2020csb1104\n99\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        student.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Incorrect UserName!"));
    }

    @Test
    public void auth52()throws Exception{
        String a="2020csb11038\n2020csb1104\n99\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        student.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Incorrect UserName!"));
    }

    @Test
    public void auth53()throws Exception{
        String a="2020csb1104\n2020csb1105\n99\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        student.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Incorrect Password"));
    }

    @Test
    public void auth54()throws Exception{
        String a="2020csb1104\n2020csb11044\n99\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        student.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Incorrect Password"));
    }

    @Test
    public void auth55()throws Exception{
        String a="2020csb1104\n2020csb1104\nA\n2020csb1104\ncs302\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        student.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Course already enrolled"));
    }

    @Test
    public void auth56()throws Exception{
        String a="2020csb1104\n2020csb1104\nA\n2020csb1104\ncs301\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        student.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Course already enrolled"));
    }

    @Test
    public void auth57()throws Exception{
        String a="2020csb1104\n2020csb1104\nA\n2020csb1104\ncs307\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        student.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Course not floated"));
    }

    @Test
    public void auth58()throws Exception{
        String a="2020csb1104\n2020csb1104\nA\n2020csb1104\ncs3099\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        student.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Course not floated"));
    }

    @Test
    public void auth59()throws Exception{
        String a="2020csb1104\n2020csb1104\nA\n2020csb1104\ncs30995\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        student.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Course not floated"));
    }

    @Test
    public void auth60()throws Exception{
        String a="2020csb1104\n2020csb1104\nA\n2020csb1104\ncs303\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        student.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Course enrolled successfully"));
    }

    @Test
    public void auth61()throws Exception{
        String a="2020csb1104\n2020csb1104\nA\n2020csb1104\ncs304\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        student.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("Course enrolled successfully"));
    }

    @Test
    public void auth62()throws Exception{
        String a="2020csb1104\n2020csb1104\nB\n2020csb1104\ncs303\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        student.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("course withdrawn successfully"));
    }

    @Test
    public void auth63()throws Exception{
        String a="2020csb1104\n2020csb1104\nB\n2020csb1104\ncs303\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        student.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("course already withdrawn"));
    }

    @Test
    public void auth64()throws Exception{
        String a="2020csb1104\n2020csb1104\nC\n2020csb1104\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        student.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("student grade =="));
    }

    @Test
    public void auth65()throws Exception{
        String a="2020csb1104\n2020csb1104\nC\n2020csb11088\n-1\n";
        SetNewInput(a);
        SetNewOutput();
        student.Authentication();
        restore();
        System.out.println(newOut.toString());
        assertTrue(newOut.toString().contains("No such Student in database"));
    }

}




