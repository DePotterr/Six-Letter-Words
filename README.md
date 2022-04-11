# Six Letter Words API

Exercise by One16 created by Robin de Potter.

## Getting started

### Version

This jar is compiled in java 11.

### Requirements

* Clone this project
* Have Postman installed for easy API calls. (or use curl).

### Executing program

Clone:

* Clone the git repository
* Go to the root folder of this project and run the application with this command:

```console
foo@bar:~$ mvn spring-boot:run
```

Or execute jar:

```console
foo@bar:~$ java -jar target/sollicitatie-0.0.1-SNAPSHOT.jar
```

### Test program

* Make a request to localhost:3000/api/list (Use postman or curl).
  
curl command:

```console
foo@bar:~$ curl --request POST 'http://localhost:3000/api/file' --data '@input.txt' --header "Content-Type: text/plain" >> output.txt
```
