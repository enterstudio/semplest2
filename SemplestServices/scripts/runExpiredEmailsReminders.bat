@echo off

echo JAVA_HOME: %JAVA_HOME%
set CLASSPATH=Z:\JavaReleases\SEMplestBatches\Job<seend to add version>.jar
echo CLASSPATH: %CLASSPATH%

java semplest.server.job.ExpiredEmailSender

