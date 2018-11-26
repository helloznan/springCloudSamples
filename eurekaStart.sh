#!/bin/bash
#nohup java -jar /Users/zhengnan/Desktop/springCloudDemol/micro-weather-eureka-server/build/libs/micro-weather-eureka-server-1.0.0.jar --server.port=8071 &
nohup 
java -jar /Users/zhengnan/Desktop/springCloudDemol/msa-weather-collection-eureka/build/libs/msa-weather-collection-eureka-1.0.0.jar --server.port=8081 &
#java -jar /Users/zhengnan/Desktop/springCloudDemol/msa-weather-collection-eureka/build/libs/msa-weather-collection-eureka-1.0.0.jar --server.port=8082 &
java -jar /Users/zhengnan/Desktop/springCloudDemol/msa-weather-data-eureka/build/libs/msa-weather-data-eureka-1.0.0.jar --server.port=8083 &
#java -jar /Users/zhengnan/Desktop/springCloudDemol/msa-weather-data-eureka/build/libs/msa-weather-data-eureka-1.0.0.jar --server.port=8084 &
java -jar /Users/zhengnan/Desktop/springCloudDemol/msa-weather-city-eureka/build/libs/msa-weather-city-eureka-1.0.0.jar --server.port=8085 &
#java -jar /Users/zhengnan/Desktop/springCloudDemol/msa-weather-city-eureka/build/libs/msa-weather-city-eureka-1.0.0.jar --server.port=8086 &
java -jar /Users/zhengnan/Desktop/springCloudDemol/msa-weather-report-eureka/build/libs/msa-weather-report-eureka-1.0.0.jar --server.port=8087 &
#java -jar /Users/zhengnan/Desktop/springCloudDemol/msa-weather-report-eureka/build/libs/msa-weather-report-eureka-1.0.0.jar --server.port=8088 &
