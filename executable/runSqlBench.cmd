SET user=postgres
SET password=postgres

java -jar -Dspring.datasource.username=%user% -Dspring.datasource.password=%password% sqlbench-0.0.1-SNAPSHOT.war