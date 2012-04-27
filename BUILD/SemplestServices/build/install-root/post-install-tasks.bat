@echo off
rem This file gets parsed by the install variable substitution system 
rem so properties can be used here such as:
rem ${db.service.name}

if  "%JAVA_HOME%" == "" goto nojava
set COMMAND=%JAVA_HOME%\bin\java.exe

rem set current drive in case this is being called across drive letters
set current.drive=%~d0
%current.drive%

rem  set to directory batch file is in
set current.dir=%~dp0
cd %current.dir%

echo *** Installing the Service and starting it ***

"%COMMAND%" -jar "%current.dir%\YAJSW_11_0\wrapper.jar" -i "%current.dir%\YAJSW_11_0\conf\wrapper.conf"
rem do not start "%COMMAND%" -jar "%current.dir%\YAJSW_11_0\wrapper.jar" -t "%current.dir%\YAJSW_11_0\conf\wrapper.conf"
goto end

:nojava
echo you must install java and set the JAVA_HOME environment variable to run this application

:end

echo ___________________________________
echo    Post-Install Tasks - Done