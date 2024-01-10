# Read Me First

Here are the steps necessary to get you up and running, with the rest API and maven.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.0/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.0/reference/htmlsingle/index.html#web)

Inside the code you will come across the following, which is a template in order to better document and automate the process of documentation
of REST-FULL API'S:

```
/**
 * This is a template for the commenting and documentation of endpoints in our api
 *
 * @param  paramname  this marks a parameter our endpoint accepts and describes its use.
 * @param  paramname2  if we have more than one.
 * @return      this marks what our endpoint returns
*/

 
/**
 * Include tags in the following order:
 *
 * @author (classes and interfaces only, required)
 * @version (classes and interfaces only, required. See footnote 1)
 * @param (methods and constructors only)
 * @return (methods only)
 * @exception (@throws is a synonym added in Javadoc 1.2)
 * @see
 * @since
 * @serial (or @serialField or @serialData)
 * @deprecated (see How and When To Deprecate APIs)
 */
```

### From Zero to Hero

Here we have the steps needed for you to be able to fire up the project if you just have a blank, brand new pc.

1. **First and foremost** you will need a java JDK, this can be downloaded
   from the integrated java versioning manager the IntelliJ IDEA has,
   or from a vendor of your choice. **THIS PROJECT IS BUILD WITH THE LATEST VERSION AMAZON USES AND SUPPORTS FOR LONG TERM USE,
   THIS IS THE VERSION 11**
2. Next step (Optional) would be for you to download the maven this can be done following this tutorial, https://www.digitalocean.com/community/tutorials/install-maven-mac-os (On mac)
   https://www.digitalocean.com/community/tutorials/install-maven-linux-ubuntu (Linux Ubuntu)
3. There is also an other way to run the project, this is to use the maven wrapper that we have already build and included in the app for the end
   user to be abe to use. (mvnw for linux and mac, mvnw.cmd for windows)


### Executing the app with Docker(Suggested)
In order to run the app with docker-compose you will need the following:

1. Have docker & docker compose installed in your pc.
2. Create a copy of the file `example.env` with the name `.env` and fill the variables
3. Run the following command `docker compose -p agro-disaster-app up -d --build` when you are at the root directory of the project.
4. Now to stop the application and clean up the containers you need to run, `docker compose -p agro-disaster-app down`.

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)


## Contributing
Pull requests are welcome.

This project was created by the students Athanasios Chourlias and Chris Maikos of the Harokopio University of Athens.

## License
[MIT](https://choosealicense.com/licenses/mit/)


## Git Init Actions

```
echo "# agro-disaster-system-UI" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin git@github.com:Athanasioschourlias/agro-disaster-system-UI.git
git push -u origin main
```


---

<h1 id="openapi-definition">OpenAPI definition v1.0</h1>

> Scroll down for code samples, example requests and responses. Select a language for code samples from the tabs above or the mobile navigation menu.

Base URLs:

* <a href="http://localhost:8081">http://localhost:8081</a>

<h1 id="openapi-definition-compensation-forms-submit">compensation-forms-submit</h1>

## updateFormById

<a id="opIdupdateFormById"></a>

> Code samples

```java
URL obj = new URL("http://localhost:8081/farmer/compensation/edit/form/{form_id}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PUT");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`PUT /farmer/compensation/edit/form/{form_id}`

> Body parameter

```json
{
  "id": 0,
  "user": {
    "id": 0,
    "tinNumber": "string",
    "firstName": "string",
    "lastName": "string",
    "password": "string",
    "roles": [
      {
        "id": 0,
        "name": "string"
      }
    ],
    "email": "string"
  },
  "location": "string",
  "damageDescription": "string",
  "acres": 0,
  "cropType": "string",
  "status": "PENDING"
}
```

<h3 id="updateformbyid-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|form_id|path|integer(int32)|true|none|
|body|body|[CompensationReqForm](#schemacompensationreqform)|true|none|

> Example responses

> 200 Response

<h3 id="updateformbyid-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|string|

<aside class="success">
This operation does not require authentication
</aside>

## saveNewForm

<a id="opIdsaveNewForm"></a>

> Code samples

```java
URL obj = new URL("http://localhost:8081/farmer/compensation/create");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`POST /farmer/compensation/create`

> Body parameter

```json
{
  "id": 0,
  "user": {
    "id": 0,
    "tinNumber": "string",
    "firstName": "string",
    "lastName": "string",
    "password": "string",
    "roles": [
      {
        "id": 0,
        "name": "string"
      }
    ],
    "email": "string"
  },
  "location": "string",
  "damageDescription": "string",
  "acres": 0,
  "cropType": "string",
  "status": "PENDING"
}
```

<h3 id="savenewform-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[CompensationReqForm](#schemacompensationreqform)|true|none|

> Example responses

> 200 Response

<h3 id="savenewform-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|string|

<aside class="success">
This operation does not require authentication
</aside>

## getAllFormsForFarmer

<a id="opIdgetAllFormsForFarmer"></a>

> Code samples

```java
URL obj = new URL("http://localhost:8081/farmer/compensation/get-forms");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /farmer/compensation/get-forms`

> Example responses

> 200 Response

<h3 id="getallformsforfarmer-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="getallformsforfarmer-responseschema">Response Schema</h3>

Status Code **200**

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|*anonymous*|[[CompensationReqForm](#schemacompensationreqform)]|false|none|none|
|» id|integer(int32)|false|none|none|
|» user|[User](#schemauser)|false|none|none|
|»» id|integer(int32)|false|none|none|
|»» tinNumber|string|false|none|none|
|»» firstName|string|false|none|none|
|»» lastName|string|false|none|none|
|»» password|string|false|none|none|
|»» roles|[[Role](#schemarole)]|false|none|none|
|»»» id|integer(int64)|false|none|none|
|»»» name|string|false|none|none|
|»» email|string|false|none|none|
|» location|string|false|none|none|
|» damageDescription|string|false|none|none|
|» acres|integer(int32)|false|none|none|
|» cropType|string|false|none|none|
|» status|string|false|none|none|

#### Enumerated Values

|Property|Value|
|---|---|
|status|PENDING|
|status|REJECTED|
|status|COMPLETED|

<aside class="success">
This operation does not require authentication
</aside>

## deleteFormById

<a id="opIddeleteFormById"></a>

> Code samples

```java
URL obj = new URL("http://localhost:8081/farmer/compensation/delete/form/{form_id}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("DELETE");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`DELETE /farmer/compensation/delete/form/{form_id}`

<h3 id="deleteformbyid-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|form_id|path|integer(int32)|true|none|

> Example responses

> 200 Response

<h3 id="deleteformbyid-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|string|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="openapi-definition-form-manager">form-manager</h1>

## updateFormById_1

<a id="opIdupdateFormById_1"></a>

> Code samples

```java
URL obj = new URL("http://localhost:8081/employee/manager/edit/form/{form_id}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PUT");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`PUT /employee/manager/edit/form/{form_id}`

> Body parameter

```json
{
  "id": 0,
  "user": {
    "id": 0,
    "tinNumber": "string",
    "firstName": "string",
    "lastName": "string",
    "password": "string",
    "roles": [
      {
        "id": 0,
        "name": "string"
      }
    ],
    "email": "string"
  },
  "location": "string",
  "damageDescription": "string",
  "acres": 0,
  "cropType": "string",
  "status": "PENDING"
}
```

<h3 id="updateformbyid_1-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|form_id|path|integer(int32)|true|none|
|body|body|[CompensationReqForm](#schemacompensationreqform)|true|none|

> Example responses

> 200 Response

<h3 id="updateformbyid_1-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|string|

<aside class="success">
This operation does not require authentication
</aside>

## getAllProcessedForms

<a id="opIdgetAllProcessedForms"></a>

> Code samples

```java
URL obj = new URL("http://localhost:8081/employee/manager/get-forms/processed");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /employee/manager/get-forms/processed`

> Example responses

> 200 Response

<h3 id="getallprocessedforms-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="getallprocessedforms-responseschema">Response Schema</h3>

Status Code **200**

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|*anonymous*|[[CompensationReqForm](#schemacompensationreqform)]|false|none|none|
|» id|integer(int32)|false|none|none|
|» user|[User](#schemauser)|false|none|none|
|»» id|integer(int32)|false|none|none|
|»» tinNumber|string|false|none|none|
|»» firstName|string|false|none|none|
|»» lastName|string|false|none|none|
|»» password|string|false|none|none|
|»» roles|[[Role](#schemarole)]|false|none|none|
|»»» id|integer(int64)|false|none|none|
|»»» name|string|false|none|none|
|»» email|string|false|none|none|
|» location|string|false|none|none|
|» damageDescription|string|false|none|none|
|» acres|integer(int32)|false|none|none|
|» cropType|string|false|none|none|
|» status|string|false|none|none|

#### Enumerated Values

|Property|Value|
|---|---|
|status|PENDING|
|status|REJECTED|
|status|COMPLETED|

<aside class="success">
This operation does not require authentication
</aside>

## getAllUnProcessedForms

<a id="opIdgetAllUnProcessedForms"></a>

> Code samples

```java
URL obj = new URL("http://localhost:8081/employee/manager/get-forms/pending");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /employee/manager/get-forms/pending`

> Example responses

> 200 Response

<h3 id="getallunprocessedforms-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="getallunprocessedforms-responseschema">Response Schema</h3>

Status Code **200**

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|*anonymous*|[[CompensationReqForm](#schemacompensationreqform)]|false|none|none|
|» id|integer(int32)|false|none|none|
|» user|[User](#schemauser)|false|none|none|
|»» id|integer(int32)|false|none|none|
|»» tinNumber|string|false|none|none|
|»» firstName|string|false|none|none|
|»» lastName|string|false|none|none|
|»» password|string|false|none|none|
|»» roles|[[Role](#schemarole)]|false|none|none|
|»»» id|integer(int64)|false|none|none|
|»»» name|string|false|none|none|
|»» email|string|false|none|none|
|» location|string|false|none|none|
|» damageDescription|string|false|none|none|
|» acres|integer(int32)|false|none|none|
|» cropType|string|false|none|none|
|» status|string|false|none|none|

#### Enumerated Values

|Property|Value|
|---|---|
|status|PENDING|
|status|REJECTED|
|status|COMPLETED|

<aside class="success">
This operation does not require authentication
</aside>

## getAllForms

<a id="opIdgetAllForms"></a>

> Code samples

```java
URL obj = new URL("http://localhost:8081/employee/manager/get-forms/all");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /employee/manager/get-forms/all`

> Example responses

> 200 Response

<h3 id="getallforms-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="getallforms-responseschema">Response Schema</h3>

Status Code **200**

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|*anonymous*|[[CompensationReqForm](#schemacompensationreqform)]|false|none|none|
|» id|integer(int32)|false|none|none|
|» user|[User](#schemauser)|false|none|none|
|»» id|integer(int32)|false|none|none|
|»» tinNumber|string|false|none|none|
|»» firstName|string|false|none|none|
|»» lastName|string|false|none|none|
|»» password|string|false|none|none|
|»» roles|[[Role](#schemarole)]|false|none|none|
|»»» id|integer(int64)|false|none|none|
|»»» name|string|false|none|none|
|»» email|string|false|none|none|
|» location|string|false|none|none|
|» damageDescription|string|false|none|none|
|» acres|integer(int32)|false|none|none|
|» cropType|string|false|none|none|
|» status|string|false|none|none|

#### Enumerated Values

|Property|Value|
|---|---|
|status|PENDING|
|status|REJECTED|
|status|COMPLETED|

<aside class="success">
This operation does not require authentication
</aside>

## deleteFormById_1

<a id="opIddeleteFormById_1"></a>

> Code samples

```java
URL obj = new URL("http://localhost:8081/employee/manager/delete/form/{form_id}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("DELETE");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`DELETE /employee/manager/delete/form/{form_id}`

<h3 id="deleteformbyid_1-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|form_id|path|integer(int32)|true|none|

> Example responses

> 200 Response

<h3 id="deleteformbyid_1-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|string|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="openapi-definition-admin">admin</h1>

## updateUserByTin

<a id="opIdupdateUserByTin"></a>

> Code samples

```java
URL obj = new URL("http://localhost:8081/admin/users/modify/{user_tin}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("PUT");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`PUT /admin/users/modify/{user_tin}`

> Body parameter

```json
{
  "id": 0,
  "tinNumber": "string",
  "firstName": "string",
  "lastName": "string",
  "password": "string",
  "roles": [
    {
      "id": 0,
      "name": "string"
    }
  ],
  "email": "string"
}
```

<h3 id="updateuserbytin-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|user_tin|path|string|true|none|
|body|body|[User](#schemauser)|true|none|

> Example responses

> 200 Response

<h3 id="updateuserbytin-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="updateuserbytin-responseschema">Response Schema</h3>

<aside class="success">
This operation does not require authentication
</aside>

## saveUsers

<a id="opIdsaveUsers"></a>

> Code samples

```java
URL obj = new URL("http://localhost:8081/admin/users/register");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`POST /admin/users/register`

> Body parameter

```json
{
  "id": 0,
  "tinNumber": "string",
  "firstName": "string",
  "lastName": "string",
  "password": "string",
  "roles": [
    {
      "id": 0,
      "name": "string"
    }
  ],
  "email": "string"
}
```

<h3 id="saveusers-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[User](#schemauser)|true|none|

> Example responses

> 200 Response

<h3 id="saveusers-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|string|

<aside class="success">
This operation does not require authentication
</aside>

## getAllUsers

<a id="opIdgetAllUsers"></a>

> Code samples

```java
URL obj = new URL("http://localhost:8081/admin/users/get_all");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /admin/users/get_all`

> Example responses

> 200 Response

<h3 id="getallusers-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="getallusers-responseschema">Response Schema</h3>

Status Code **200**

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|*anonymous*|[[User](#schemauser)]|false|none|none|
|» id|integer(int32)|false|none|none|
|» tinNumber|string|false|none|none|
|» firstName|string|false|none|none|
|» lastName|string|false|none|none|
|» password|string|false|none|none|
|» roles|[[Role](#schemarole)]|false|none|none|
|»» id|integer(int64)|false|none|none|
|»» name|string|false|none|none|
|» email|string|false|none|none|

<aside class="success">
This operation does not require authentication
</aside>

## deleteUserByTin

<a id="opIddeleteUserByTin"></a>

> Code samples

```java
URL obj = new URL("http://localhost:8081/admin/users/delete/{user_tin}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("DELETE");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`DELETE /admin/users/delete/{user_tin}`

<h3 id="deleteuserbytin-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|user_tin|path|string|true|none|

> Example responses

> 200 Response

<h3 id="deleteuserbytin-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|string|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="openapi-definition-login-controller">login-controller</h1>

## login

<a id="opIdlogin"></a>

> Code samples

```java
URL obj = new URL("http://localhost:8081/auth/login");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`POST /auth/login`

> Body parameter

```json
{
  "username": "string",
  "password": "string"
}
```

<h3 id="login-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[LoginRequest](#schemaloginrequest)|true|none|

> Example responses

> 200 Response

<h3 id="login-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

<h3 id="login-responseschema">Response Schema</h3>

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="openapi-definition-health-check">health-check</h1>

## health_check

<a id="opIdhealth_check"></a>

> Code samples

```java
URL obj = new URL("http://localhost:8081/health/check/{key}");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

`GET /health/check/{key}`

<h3 id="health_check-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|key|path|string|true|none|

> Example responses

> 200 Response

<h3 id="health_check-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|string|

<aside class="success">
This operation does not require authentication
</aside>

# Schemas

<h2 id="tocS_CompensationReqForm">CompensationReqForm</h2>

<a id="schemacompensationreqform"></a>
<a id="schema_CompensationReqForm"></a>
<a id="tocScompensationreqform"></a>
<a id="tocscompensationreqform"></a>

```json
{
  "id": 0,
  "user": {
    "id": 0,
    "tinNumber": "string",
    "firstName": "string",
    "lastName": "string",
    "password": "string",
    "roles": [
      {
        "id": 0,
        "name": "string"
      }
    ],
    "email": "string"
  },
  "location": "string",
  "damageDescription": "string",
  "acres": 0,
  "cropType": "string",
  "status": "PENDING"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|integer(int32)|false|none|none|
|user|[User](#schemauser)|false|none|none|
|location|string|false|none|none|
|damageDescription|string|false|none|none|
|acres|integer(int32)|false|none|none|
|cropType|string|false|none|none|
|status|string|false|none|none|

#### Enumerated Values

|Property|Value|
|---|---|
|status|PENDING|
|status|REJECTED|
|status|COMPLETED|

<h2 id="tocS_Role">Role</h2>

<a id="schemarole"></a>
<a id="schema_Role"></a>
<a id="tocSrole"></a>
<a id="tocsrole"></a>

```json
{
  "id": 0,
  "name": "string"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|integer(int64)|false|none|none|
|name|string|false|none|none|

<h2 id="tocS_User">User</h2>

<a id="schemauser"></a>
<a id="schema_User"></a>
<a id="tocSuser"></a>
<a id="tocsuser"></a>

```json
{
  "id": 0,
  "tinNumber": "string",
  "firstName": "string",
  "lastName": "string",
  "password": "string",
  "roles": [
    {
      "id": 0,
      "name": "string"
    }
  ],
  "email": "string"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|id|integer(int32)|false|none|none|
|tinNumber|string|false|none|none|
|firstName|string|false|none|none|
|lastName|string|false|none|none|
|password|string|false|none|none|
|roles|[[Role](#schemarole)]|false|none|none|
|email|string|false|none|none|

<h2 id="tocS_LoginRequest">LoginRequest</h2>

<a id="schemaloginrequest"></a>
<a id="schema_LoginRequest"></a>
<a id="tocSloginrequest"></a>
<a id="tocsloginrequest"></a>

```json
{
  "username": "string",
  "password": "string"
}

```

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|username|string|false|none|none|
|password|string|false|none|none|



