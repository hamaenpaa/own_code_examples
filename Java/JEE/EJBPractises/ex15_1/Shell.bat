@setlocal
@echo off
set CLASSPATH=build\classes;client-config

for /R %JBOSS_HOME%\client\lib %%v IN (*.jar) DO @call setClasspath %%v
for /R %JBOSS_HOME%\server\default\lib %%v IN (*.jar) DO @call setClasspath %%v
for /R %JBOSS_HOME%\lib %%v IN (*.jar) DO @call setClasspath %%v
for /R %JBOSS_HOME%\server\default\deploy\ejb3.deployer %%v IN (*.jar) DO @call setClasspath %%v
for /R %JBOSS_HOME%\server\default\deploy\jboss-aop-jdk50.deployer %%v IN (*.jar) DO @call setClasspath %%v

java  com.titan.clients.TravelAgentShell
