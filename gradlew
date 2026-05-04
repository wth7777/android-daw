#!/bin/sh

##############################################################################
##  Gradle start up script for UNIX
##############################################################################

# Attempt to set JAVA_HOME if it's not already set
if [ -z "$JAVA_HOME" ] ; then
    JAVA_HOME="$(cd "$(dirname "$0")" && pwd)/jdk"
    export JAVA_HOME
fi

APP_BASE_NAME=`basename "$0"`

# Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
DEFAULT_JVM_OPTS=""

# Find java and set CLASSPATH
CLASSPATH=`ls -1 "$(cd "$(dirname "$0")" && pwd)/gradle/wrapper/gradle-wrapper.jar" 2>/dev/null`

# Determine the Java command to use
if [ -z "$JAVA_HOME" ] ; then
    JAVA_CMD="java"
else
    JAVA_CMD="$JAVA_HOME/bin/java"
fi

# Run Gradle wrapper
exec "$JAVA_CMD" $DEFAULT_JVM_OPTS -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
