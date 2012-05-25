@echo off
cls
color F9

if  "%JAVA_HOME%" == "" goto nojava
set COMMAND=%JAVA_HOME%\bin\java.exe

rem set local variable to PostgreSQL install dir
set installdir=${UserPathPanelVariable}

rem  set to directory batch file is in
set dir=%~dp0
cd %dir%


rem Check for existence of 32-bit directory on 64-bit machine
set installdir=%installdir:Program Files=Program Files (x86)%
if not exist "%installdir%" goto nodir86
echo *** Removing 32-bit PostgreSQL Installation Directory ***
rmdir /s /q "%installdir%"
:nodir86

echo *** Removing Windows Service ***
"%COMMAND%" -jar "$INSTALL_PATH\YAJSW_11_0\wrapper.jar" -p "$INSTALL_PATH\YAJSW_11_0\conf\wrapper.conf"
"%COMMAND%" -jar "$INSTALL_PATH\YAJSW_11_0\wrapper.jar" -r "$INSTALL_PATH\YAJSW_11_0\conf\wrapper.conf"

cd %dir%
cd ..
cd ..

echo *** Running Proxy Server Uninstaller ***
"%COMMAND%" -jar "$INSTALL_PATH\Uninstaller\uninstaller.jar" -c -f
goto end

:nojava
echo you must install java and set the JAVA_HOME environment variable to run this application

:end

echo _____________________________________
echo    Uninstaller - Done
