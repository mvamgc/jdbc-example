How to run
--------------

Start Postgres:
```shell 
docker run --rm --name test-postgres -e POSTGRES_PASSWORD=123 -d -p 5432:5432 postgres
```

Run:
```shell
mvn test
```
