#!/bin/sh

CLASSPATH=build/classes:client-config

for i in $(ls $JBOSS_HOME/client/lib/*.jar)
do CLASSPATH=$CLASSPATH:$i
done

for i in $(ls $JBOSS_HOME/server/default/lib/*.jar)
do CLASSPATH=$CLASSPATH:$i
done

for i in $(ls $JBOSS_HOME/lib/*.jar)
do CLASSPATH=$CLASSPATH:$i
done

for i in $(ls $JBOSS_HOME/server/default/deploy/ejb3.deployer/*.jar)
do CLASSPATH=$CLASSPATH:$i
done

for i in $(ls $JBOSS_HOME/server/default/deploy/jboss-aop-jdk50.deployer/*.jar)
do CLASSPATH=$CLASSPATH:$i
done

java com.titan.clients.TravelAgentShell

  