- Java 17
- Docker image: phpmyadmin:5.2.1 ( this is automatically downloaded on building module)
- Docker image: mysql:8.0.33 ( this is automatically downloaded on building module)

## Starting services

* on terminal: docker-compose run -d
* on IDE run: DockerApp

## Stopping services
* on terminal: docker-compose down
* on IDE stop DockerApp


## Endpoints
- #### To execute PhpMyAdmin + MySQL
```
  localhost:8090
```

## Usage:
```
- localhost:8762/v1/test
- localhost:8762/v1/search/id_to_search
```
## Project modules.
* [Bahay/login-services](Bahay-login-services/README.md)<br>


## Running Test
- UserControllerTest: should running docker-compose

## Contact info:

> ascii274@gmail.com || Joel Cabatay

## License:

[MIT](https://opensource.org/licenses/MIT)