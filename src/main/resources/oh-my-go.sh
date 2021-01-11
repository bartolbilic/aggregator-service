#!/usr/bin/env bash
echo 'Starting to wait for temp and humidity services...'
./wait-for-it.sh --timeout=60 --strict humidity-microservice:8081
./wait-for-it.sh --timeout=15 --strict temperature-microservice:8082 -- java -cp /app/resources:/app/classes:/app/libs/* com.rassus.aggregatormicroservice.AggregatorMicroserviceApplication
