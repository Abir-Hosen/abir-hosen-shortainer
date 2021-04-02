# shortainer

Clone or download this repository.
```
https://gitlab.com/abir71.hosen/shortainer.git
```
### Prerequisites
- Java 11
- Eclipse IDE
- Mysql

### Steps to follow
- Import project in Eclipse IDE
- Set your mysql Database according to application.properties.
- Update Maven project
- Then run

### Feature list(Example)

1. An POST endpoint which will consume long url, short url domain, some optional parameters
as json format and on success it will return short url as json format and a unique id of the
record. Short url path length is exactly six characters long. Every long url have
an unique short URL

- [ ] API
```
http://localhost:8080/api/shortainer?param1=abc&param2=pqr
```
- [ ] body
```
{
"long_url": "http://example.com/path1/path2/path3?arg=value&arg1=value",
"short_url_domain": "short.io",
"parameters": {
        "param1": "value1",
        "param2": "value2"
    }
}
```

2. An GET endpoint which will return record using unique id returned from endpoint 1
- [ ] API
```
get - http://localhost:8080/api/shortainer/1
get - http://localhost:8080/api/shortainer
get - localhost:8080/short.io/rwzpon
```

These are two feature example showed above with api. Other api and feature is documented in Postman in details.

