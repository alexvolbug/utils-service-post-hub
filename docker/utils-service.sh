#!/usr/bin/env bash

PROFILE=${PROFILE:-prod}

echo "Starting service with profile: $PROFILE"
exec java -jar /srv/utils-service-1.0-SNAPSHOT.jar --spring.profiles.active=$PROFILE