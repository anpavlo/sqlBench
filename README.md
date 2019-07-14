# About

This application has been done as a test task.<br/>
The requirements are:
- You have to implement simple java application which executes benchmarks on a JDBC compliant database.
- The application MUST evaluate the min/max/avg time of INSERT statements.
- The application MUST evaluate the min/max/avg time of SELECT statements (using the PK of the COLUMN).
- The application MUST issue DML requests using the PreparedStatement API and issuing “commits” every X statements.
- The application will be run on a PostGRE or MS SQLServer database.
- The script to create the table MUST be included in the source code. 

### Instructions
- You must have java 8 installed on your machine
- To build project use: *<b>mvn clean install</b>* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
- To run application you must have running PostgreSQL server with already created databese named *<b>bench_db</b>*
- Application will create needed table on startup automatically by running appropriate sql script included in application
- Location of configuration file is <b>src/main/resources/application.yml</b>
- If you want run application without building, download <b>executable</b> folder, edit <b>runSqlBench.cmd</b> with your database credentials and run it.
- As soon as app starts,open browser and type <b>http://localhost:8080/</b> in address line. You will see the simple dashboard.
- Press button <b>run test</b> and results will appear in the table



# Guides
 

* [Spring guides](https://spring.io/guides)


