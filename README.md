# Github Client
##Running locally
1. All you need to do is to run script `run-locally.sh`. It should:
    * run docker container with database (and run sql scripts available in `./database/sql-scripts`).
    * run service on `http://localhost:8080/`
2. You can stop container with database by using: `docker-compose down`
    * take a note data is additionally stored in folder `./database/dump-data` on your host machine
      so even if you stop the container data should be loaded in next start
3. More info for available endpoints you can find in swagger documentation: `http://localhost:8080/api-ui.html` (available when service is running)

## Running test
1.To run test just run command in project root dir: `./gradlew test`

##Troubleshooting
1. Make sure ports used to run db and service are not allocated
    * db port: `3306`
    * service port: `8080`
    
2. First start of DB can take a little bit longer because of added pause to start script (service was starting to fast with compare to db)