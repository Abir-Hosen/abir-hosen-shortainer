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

**_shortainer - create:_**
```
http://localhost:8080/api/shortainer?param1=abc&param2=pqr
```

> here parameter in url is optional
- body
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
##### response
```
{
    "id": 6,
    "longUrl": "http://example.com/path1/path2/path3?arg=value&arg1=value",
    "shortUrlDomain": "short.io",
    "shortUrl": "CiwlD2",
    "parameters": {
        "id": 7,
        "param1": "param1",
        "param2": "param2"
    }
}
```
2. An GET endpoint which will return record using unique id returned from endpoint 1

**_shortainer - get by id:_**
```
http://localhost:8080/api/shortainer/3
```
##### response
```
{
    "id": 3,
    "longUrl": "http://example.com/path1/path2/path3?arg=value&arg1=value",
    "shortUrlDomain": "short.io",
    "shortUrl": "hqXPP2",
    "parameters": {
        "id": 4,
        "param1": "param1",
        "param2": "param2"
    }
}
```
**_shortainer - get all:_**
```
http://localhost:8080/api/shortainer
```
##### response
```
[
    {
        "id": 3,
        "longUrl": "http://example.com/path1/path2/path3?arg=value&arg1=value",
        "shortUrlDomain": "short.io",
        "shortUrl": "hqXPP2",
        "parameters": {
            "id": 4,
            "param1": "param1",
            "param2": "param2"
        }
    },
    {
        "id": 6,
        "longUrl": "http://example.com/path1/path2/path3?arg=value&arg1=value",
        "shortUrlDomain": "short.io",
        "shortUrl": "CiwlD2",
        "parameters": {
            "id": 7,
            "param1": "param1",
            "param2": "param2"
        }
    }
]
```
3. An GET endpoint which will be used when a user clicks on a short url and shortener server
will redirect a short url to long url. Note that on click you have to store the user browser, device
and ip information. Also when you redirect to a long url you have to append all optional
parameters in the query parts of long URL.

**_shortainer - hit short url(example):_**
```
localhost:8080/short.io/CiwlD2
```
##### response redirect
```
http://example.com/path1/path2/path3?arg=value&arg1=value
```
4. An GET endpoint which will send a list of all click data.

**_Tracker - get all:_**
```
 http://localhost:8080/api/tracker
```
##### response 
```
[
    {
        "id": 5,
        "browser": "Chrome",
        "os": "Linux",
        "ip": "0:0:0:0:0:0:0:1",
        "shortainer": {
            "id": 3,
            "longUrl": "http://example.com/path1/path2/path3?arg=value&arg1=value",
            "shortUrlDomain": "short.io",
            "shortUrl": "hqXPP2",
            "parameters": {
                "id": 4,
                "param1": "param1",
                "param2": "param2"
            }
        }
    }
]
```
5. An GET endpoint which will return total count on short url

**_Tracker - get total click by shortainer id:_**
```
http://localhost:8080/api/tracker/counter/6
```
##### response 
```
1
```
6. Extra feature (Individual short url click history)

**_Tracker - get by id:_**
```
http://localhost:8080/api/tracker/shortainer/3
```
##### response 
```
[
    {
        "id": 5,
        "browser": "Chrome",
        "os": "Linux",
        "ip": "0:0:0:0:0:0:0:1",
        "shortainer": {
            "id": 3,
            "longUrl": "http://example.com/path1/path2/path3?arg=value&arg1=value",
            "shortUrlDomain": "short.io",
            "shortUrl": "hqXPP2",
            "parameters": {
                "id": 4,
                "param1": "param1",
                "param2": "param2"
            }
        }
    }
]
```

These are feature example showed above with api. All api and feature is well documented in Postman in details.

