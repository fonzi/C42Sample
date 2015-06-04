/**
 * Main class, load project into Intellij Idea and run this class to run project under Windows Machine
 */
public class Main
{
    public static void main (String [] args) throws Exception
    {
        Navigate navigate = new Navigate();
        navigate.NavigateToDownload();
        navigate.myDriver.quit();

        CrashPlanSignUp signUp = new CrashPlanSignUp();
        signUp.SignUpFailedWrongEmail();
        signUp.SignUpMismatchPass();
        signUp.SignUpPass();
    }
}
