import Rules.Retry;
import org.testng.Assert;
import org.junit.Test;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.script.*;


public class CrashPlanSignUp
{
    Keyboard myKeyboard = new DesktopKeyboard();



    public static void main(String [] args) throws Exception
    {
        CrashPlanSignUp mySignUp = new CrashPlanSignUp();
        mySignUp.SignUpFailedWrongEmail();
    }

    @Test
    @Retry
    public void  SignUpPass() throws Exception
    {
        Process p = Runtime.getRuntime().exec("C:\\Program Files (x86)\\CrashPlan\\CrashPlanDesktop.exe");
        Thread.sleep(8000);//wait 8 seconds for file to open
        //Send Keyboard FirstName
        myKeyboard.type("Alfonso");
        //Send TAB
        myKeyboard.type(Key.TAB);
        //Send Keyboard LastName
        myKeyboard.type("Vazquez");
        //Send TAB
        myKeyboard.type(Key.TAB);
        //Send Email Address
        myKeyboard.type("alfonso.test@developvazquez.com");
        //Send TAB
        myKeyboard.type(Key.TAB);
        //Send first Password
        myKeyboard.type("P@ssw0rd");
        //Send TAB
        myKeyboard.type(Key.TAB);
        //Send Second Match Password
        myKeyboard.type("P@ssw0rd");
        //Send ENTER
        myKeyboard.type(Key.ENTER);
    }
    @Test
    @Retry
    public void SignUpFailedWrongEmail() throws Exception
    {

        Process p = Runtime.getRuntime().exec("C:\\Program Files (x86)\\CrashPlan\\CrashPlanDesktop.exe");
        Thread.sleep(8000);//wait 8 seconds for file to open

        //Send Keyboard FirstName
        myKeyboard.type("Alfonso");
        //Send TAB
        myKeyboard.type(Key.TAB);
        //Send Keyboard LastName
        myKeyboard.type("Vazquez");
        //Send TAB
        myKeyboard.type(Key.TAB);
        //Send Email Address
        myKeyboard.type("alfonso.test");
        //Send TAB
        myKeyboard.type(Key.TAB);
        //Send first Password
        myKeyboard.type("P@ssw0rd");
        //Send TAB
        myKeyboard.type(Key.TAB);
        //Send Second Match Password
        myKeyboard.type("P@ssw0rd");
        //Send ENTER
        myKeyboard.type(Key.ENTER);
        Screen myScreen = new Screen();
        Pattern pleaseEnterValidEmailAddress = new Pattern("..\\Code42Sample\\SikuliImages\\PleaseEnterValidEmailAddress.png");
        if(myScreen.exists(pleaseEnterValidEmailAddress)!=null)
        {
            System.out.println("The error message appeared");
            Assert.assertTrue(pleaseEnterValidEmailAddress != null);
        }

        Thread.sleep(2000);
        // If you really need to close it forcibly
        p.destroy();

    }
    @Test
    @Retry
    public void SignUpMismatchPass() throws Exception
    {
        Process p = Runtime.getRuntime().exec("C:\\Program Files (x86)\\CrashPlan\\CrashPlanDesktop.exe");
        Thread.sleep(8000);//wait 8 seconds for file to open
        //Send Keyboard FirstName
        myKeyboard.type("Alfonso");
        //Send TAB
        myKeyboard.type(Key.TAB);
        //Send Keyboard LastName
        myKeyboard.type("Vazquez");
        //Send TAB
        myKeyboard.type(Key.TAB);
        //Send Email Address
        myKeyboard.type("alfonso.test");
        //Send TAB
        myKeyboard.type(Key.TAB);
        //Send first Password
        myKeyboard.type("P@ssw0rd");
        //Send TAB
        myKeyboard.type(Key.TAB);
        //Send Second Match Password
        myKeyboard.type("P@ssw0rd");
        //Send ENTER
        myKeyboard.type(Key.ENTER);
        Screen myScreen = new Screen();
        Pattern mismatch = new Pattern("..\\Code42Sample\\SikuliImages\\Mismatch.png");
        if(myScreen.exists(mismatch)!=null)
        {
            System.out.println("The mismatch message appeared");
            Assert.assertTrue(mismatch != null);
        }

        Thread.sleep(2000);
        // If you really need to close it forcibly
        p.destroy();

    }

}
