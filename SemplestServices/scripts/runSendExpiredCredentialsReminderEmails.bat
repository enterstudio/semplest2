@echo off

echo Current Time: %DATE%, %TIME%
echo JAVA_HOME: %JAVA_HOME%
set CLASSPATH=Z:\JavaReleases\SEMplestBatches\Job<need to add version>.jar
echo CLASSPATH: %CLASSPATH%
set COMMAND=java semplest.server.job.ExpiredCredentialsEmailSender
echo COMMAND: %COMMAND%
%COMMAND%

