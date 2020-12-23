## Multi-Agents System

A simple implementation of a multi-agents system where different users can sign up and then sign in and exchange documents.

To run the project you need to:  
1- Download and install Eclipse from http://www.eclipse.org/downloads (or use any other java IDE).

2- Install JADE:
Download the file JADE-all-3.6.zip from http://jade.tilab.com/download.php, unzip it and the four files:  
`JADE-bin-3.6.zip` , `JADE-doc-3.6.zip`, `JADE-examples-3.6.zip`, `JADE-src-3.6.zip`.    
Add a new classpath variable with the following line as value:  
`C:\JADE-all-3.6\JADE-bin-3.6\jade\lib\http.jar;C:\JADE-all-3.6\JADE-bin-3.6\jade\lib\iiop.jar; C:\JADE-all-3.6\JADE-bin-3.6\jade\lib\jade.jar;C:\JADE-all-3.6\JADE-bin-3.6\jade\lib\jadeTools.jar`

In order to confirm that JADE is working fine, run the following command in the command line: Java jade.Boot -gui
You should see the JADE Remote Agent Management client window opening
