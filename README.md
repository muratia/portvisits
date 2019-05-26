## Project Port-Visit



The project is developed using Spring Framework, Spring Boot 

I have used Postman to test the endpoints. The method I have used is Post.

The SQL code I have developed for the importing data and other I shall send them via email.

For first task it returns the Json.

URL: http://localhost:8080/api/vesseltracking/vesselsatportadtime

## Task A: 

It returns the Json data as required

URL: http://localhost:8080/api/vesseltracking/vesselsatportwithlengthgreaterthan

Params: port = 2, length= 300 

## Task B:

it does not return the Json data as required

URL:http://localhost:8080/api/vesseltracking/summarbyimoandportsanddates

Params: portId = 2, imo = 9501370, timeStarted = 2015-01-01 00:00, timeEnded = 2016-01-01 23:59

## Task D:

it does not return the Json data as required

URL: http://localhost:8080/api/vesseltracking/monthysummarybyportandmonthandyear

Params: portId = 2, month= 2, year 2015