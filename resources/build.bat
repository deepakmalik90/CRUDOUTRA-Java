cd C:\Users\devma\Projects\crudoutra-java
javac -cp lib/* @resources/sources.txt -d "C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\crudoutra\WEB-INF\classes"
@REM call "C:\Program Files\Apache Software Foundation\Tomcat 9.0\bin\shutdown.bat"
@REM call "C:\Program Files\Apache Software Foundation\Tomcat 9.0\bin\startup.bat"
call "C:\Program Files\Apache Software Foundation\Tomcat 9.0\bin\catalina.bat" run