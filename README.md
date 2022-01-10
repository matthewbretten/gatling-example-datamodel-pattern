Gatling project that uses data model pattern
===========================

This project demonstrates how to use Gatling to call existing data model and data generator Java projects to save having to
write all your test data code in Scala.
The projects it depends upon can be viewed here:
* data model - https://github.com/matthewbretten/example-json-data-model
* data generator - https://github.com/matthewbretten/example-json-test-data-generator

Prerequisites
-------------

* Maven
* Scala 2.13

Running simulations
---------------
Either run by using
```bash
mvn gatling:test
```
Or specify a test (if there are multiple) by using
```bash
mvn gatling:test -Dgatling.simulationClass=simulations.SimpleLoadTest
```

Features
----------------
* Dynamic JSON document generation from pre-existing Java projects

Behaviour
---------------
When this code is run, it will attempt to perform POST HTTP requests to http://localhost:5000 (as I was running a local Python Flask application to test receiving the requests).
As part of the POST request, it will include the generated JSON as part of the request body.

Sample data
---------------
This code will generate JSON data that looks like this as part of each request:
```json
{
  "customer": {
    "name": "Sarah Brown",
    "age": 56,
    "countryCode": "GB"
  },
  "totalPrice": 500,
  "items": [
    {
      "basketItemId": 2,
      "description": "Television",
      "price": 500
    }
  ],
  "dateCreated": "2021-07-09T14:08:35.822Z"
}
```
