## Requirements

- Java 17
- Docker image: phpmyadmin:5.2.1 ( this is automatically downloaded on building module)
- Docker image: mysql:8.0.33 ( this is automatically downloaded on building module)

## Starting services

* On terminal from framework: docker-compose up
* Or on IDE run: docker-compose.yml run services.
* Then, run the app.

## Stopping services
* on terminal from framework: docker-compose down
* on IDE stop DockerApp


## Endpoints
- #### To execute PhpMyAdmin + MySQL
```
  localhost:8090
```
http://localhost:8762/user/index
http://localhost:8762/user/signup
http://localhost:8762/admin/getall

## Usage:
```
- localhost:8762/v1/test
- localhost:8762/v1/search/id_to_search
```
## Project modules.
* [Tamaraw-LoginServices](README.md)<br>


## Running Test
- UserControllerTest: should running docker-compose

## Contact info:

> ascii274@gmail.com || Joel Cabatay

## License:

[MIT](https://opensource.org/licenses/MIT)