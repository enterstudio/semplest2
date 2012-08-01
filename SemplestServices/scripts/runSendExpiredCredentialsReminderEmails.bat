@echo off

echo Current Time: %DATE%, %TIME%
echo JAVA_HOME: %JAVA_HOME%
set CLASSPATH=C:\SemplestAdengineService\lib\*;C:\SemplestAdengineService\properties;C:\SemplestAdengineService\bin;C:\SemplestAdengineService
echo CLASSPATH: %CLASSPATH%
set COMMAND=java semplest.server.job.ExpiredCredentialsEmailSender
echo COMMAND: %COMMAND%
%COMMAND%

