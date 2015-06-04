# README #



This is a Code42 Code Sample for interview. 
This project consist of Selenium and Sikuli, there is only two parts of the framework, 
It navigates in Firefox to CrashPlan Download and downloads the application
It signs up for CrashPlan
There is no installation hence sikuli misbehaves with instillation wizards and also there is no need to automate installations for this type of testing. 

There is a few pre-request required for this program to run,
1) Needs to be a Windows machine

2) The Windows machine needs to have java 1.7 or higher installed.

3) Needs internet connection

4) Firefox 38 or lower needs to be installed in the machine

5) Assumes that CrashPlan is already installed under [C:\Program Files (x86)\CrashPlan\] and no user has logged in

   i) I decided not to automate the install for two reasons

      a)Sikuli does not behave accordingly with setups exe

      b)Setups/Installations are usually never part of Automation

7) Project needs to be loaded into Intellij Idea by Jetbrains

8) Project needs to be ran once, and it will fail, log out of the user session of windows, and log back in.

   i) This sets up the sikuli paths for windows.

9) Re Run the project