package API_Testing;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.containsString;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
 
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class GetRequestDemo {
	public static void main(String[] args) {

        // Base URI
        RestAssured.baseURI = "https://gorest.co.in/";

        System.out.println("============== GET REQUEST ==============");

        // GET Request
        Response getResponse = given().when().get("/public/v2/users/8056479");

        // Print Response
        System.out.println("Status Code : "
                + getResponse.getStatusCode());

        System.out.println("Response Body : ");
        System.out.println(getResponse.getBody().asString());

        System.out.println("Response Time : "
                + getResponse.getTime());

        System.out.println("Content Type : "
                + getResponse.getContentType());



      //  System.out.println("\n============== VALIDATIONS ==============");

        // Validations
//     given().when().get("/public/v2/users/8052292").then().statusCode(200).body("data.name",
//                    equalTo("Brajendra Khatri")).body("data.email",
//                    equalTo("khatri_brajendra@baumbach.test")).time(lessThan(5000L))
//            .header("Content-Type",
//             containsString("application/json"))
//             .log().all();

     // Validations
//     given()
//     .when()
//     .get("/public/v2/users")
//     .then()
//     .statusCode(200)
//     .body("status", equalTo("active"))
//     .header("Content-Type",
//     containsString("application/json"))
//     .log().all();
//
//     Agar ye error de:
//  it is for multiple users
//     Expected: active
//     Actual: [active, inactive, active...]
        given()
        .when()
        .get("/public/v2/users/8056479")
        .then()
        .statusCode(200)
        .body("name", equalTo("Sarada Devar"))
        .body("email", equalTo("devar_sarada@schultz.test"))
        .time(lessThan(5000L))
        .header("Content-Type",
        containsString("application/json"))
        .log().all();
//
//
//
        System.out.println("\n============== JSON EXTRACTION ==============");

     // JSON Extraction
     JsonPath jsonPath =
             getResponse.jsonPath();

     int id =
             jsonPath.getInt("id");

     String email =
             jsonPath.getString("email");

     String name =
             jsonPath.getString("name");

     String gender =
             jsonPath.getString("gender");

     String status =
             jsonPath.getString("status");

     System.out.println("ID : " + id);

     System.out.println("Email : " + email);

     System.out.println("Name : " + name);

     System.out.println("Gender : " + gender);

     System.out.println("Status : " + status);
     
     
     System.out.println("\n============== POST REQUEST ==============");

  // Request Body
  String postRequestBody = "{ "
          + "\"user_id\":8477478,"
          + "\"title\":\"API Testing with RestAssured\","
          + "\"body\":\"This is my first post created using RestAssured POST request.\""
          + "}";

  // Bearer Token
  String token = "0a147dfa745ec4acfbb3078f73f51ed59b333f35725caee357419d777aac2272";

  // POST Request
  Response postResponse =
          given()
              .header("Authorization", "Bearer " + token)
              .contentType(ContentType.JSON)
              .body(postRequestBody)
          .when()
              .post("/public/v2/posts");

  // Print Response
  System.out.println("Status Code : " + postResponse.getStatusCode());

  System.out.println("Response Body : ");
  System.out.println(postResponse.getBody().asString());

  // Variable outside if block
  int postId = 0;

  if(postResponse.getStatusCode() == 201)
  {
      postId = postResponse.jsonPath().getInt("id");

      System.out.println("Generated Post ID : " + postId);
  }
  else
  {
      System.out.println("Post Request Failed");
  }

  // ================= PUT REQUEST =================

  System.out.println("\n============== PUT REQUEST ==============");

  // PUT Request Body
  String putRequestBody = "{ "
          + "\"title\":\"Updated API Testing with RestAssured\","
          + "\"body\":\"This post has been updated using RestAssured PUT request.\""
          + "}";

  // PUT Request
  given()

      .header("Authorization", "Bearer " + token)

      .contentType(ContentType.JSON)

      .body(putRequestBody)

  .when()

      .put("/public/v2/posts/" + postId)

  .then()

      .statusCode(200)

      .log().all();
//
//
////
//     System.out.println("\n============== POST REQUEST ==============");
//     
//	 	// Request Body
//	    String postRequestBody = "{ "
//	            + "\"user_id\":8477478,"
//	            + "\"title\":\"API Testing with RestAssured\","
//	            + "\"body\":\"This is my first post created using RestAssured POST request.\""
//	            + "}";
//
//	    // Bearer Token
//	    String token = "d9cf95bf79ad70206819ace259a2d0b0dc0e3548e5a6367483a498c493144cd0";
//
//	    // POST Request
//	    Response postResponse =
//	            given()
//	                .header("Authorization", "Bearer " + token)
//	                .contentType(ContentType.JSON)
//	                .body(postRequestBody)
//	            .when()
//	                .post("/public/v2/posts");
//
//	    // Print Response
//	    System.out.println("Status Code : " + postResponse.getStatusCode());
//	    System.out.println("Response Body : ");
//	    System.out.println(postResponse.getBody().asString());
//	    if(postResponse.getStatusCode() == 201)
//	    {
//	        int postId = postResponse.jsonPath().getInt("id");
//
//	        System.out.println("Generated Post ID : " + postId);
//	    }
//	    else
//	    {
//	        System.out.println("Post Request Failed");
//	    }

  	
//     // POST Request
//     Response postResponse =
//
//             given()
//
//                 .header("Authorization",
//                         "Bearer YOUR_TOKEN")
//
//                 .contentType(ContentType.JSON)
//
//                 .body(postRequestBody)
//
//             .when()
//
//                 .post("/public/v2/users");
//
//        // POST Validation
//        postResponse.then()
//
//                .statusCode(201)
//
//                .log().all();
//
//        // Extract Generated ID
//        String generatedId =
//                postResponse.jsonPath().getString("id");
//
//        System.out.println("Generated ID : "
//                + generatedId);
//
//
//
//     System.out.println("\n============== PUT REQUEST ==============");

	 // PUT Request Body
//	 String putRequestBody = "{ "
//	         + "\"title\":\"Updated API Testing with RestAssured\","
//	         + "\"body\":\"This post has been updated using RestAssured PUT request.\""
//	         + "}";
//
//	 // PUT Request
//	 given()
//
//	     .header("Authorization", "Bearer " + token)
//
//	     .contentType(ContentType.JSON)
//
//	     .body(putRequestBody)
//
//	 .when()
//
//	     .put("/public/v2/posts/" + postId)
//
//	 .then()
//
//	     .statusCode(200)
//
//	     .log().all();
//
//
//        System.out.println("\n============== DELETE REQUEST ==============");
//
//        // DELETE Request
//        given()
//
//        .when()
//
//            .delete("/api/users/2")
//
//        .then()
//
//            .statusCode(204)
//
//            .log().all();
//
//
//
//        System.out.println("\n============== PATH PARAMETER ==============");
//
//        // Path Parameter
//        given()
//
//            .pathParam("id", 2)
//
//        .when()
//
//            .get("/api/users/{id}")
//
//        .then()
//
//            .statusCode(200)
//
//            .log().all();
//
//
//
//        System.out.println("\n============== QUERY PARAMETER ==============");
//
//        // Query Parameter
//        given()
//
//            .queryParam("page", 2)
//
//        .when()
//
//            .get("/api/users")
//
//        .then()
//
//            .statusCode(200)
//
//            .log().all();
//
//
//
//        System.out.println("\n============== HEADERS ==============");
//
//        // Headers Example
//        given()
//
//            .header("Content-Type",
//                    "application/json")
//
//        .when()
//
//            .get("/api/users/2")
//
//        .then()
//
//            .statusCode(200)
//
//            .log().headers();
//
//
//
//        System.out.println("\n============== BEARER TOKEN AUTH ==============");
//
//        // Bearer Token Example
//
//        String token = ;
//
//        given()
//
//            .header("Authorization",
//                    "Bearer " + token)
//
//        .when()
//
//            .get("https://gorest.co.in/public/v2/users")
//
//        .then()
//
//            .statusCode(200)
//
//            .log().all();
//
//
//
//        System.out.println("\n============== REQUEST CHAINING ==============");
//
//        // POST Request
//        Response chainResponse =
//
//                given()
//
//                    .contentType(ContentType.JSON)
//
//                    .body(postRequestBody)
//
//                .when()
//
//                    .post("/api/users");
//
//        // Extract ID
//        String chainId =
//                chainResponse.jsonPath().getString("id");
//
//        System.out.println("Chain ID : "
//                + chainId);
//
//        // GET using same ID
//        given()
//
//            .pathParam("id", chainId)
//
//        .when()
//
//            .get("/api/users/{id}")
//
//        .then()
//
//            .log().all();
//
//
//
//        System.out.println("\n============== JSON SCHEMA VALIDATION ==============");
//
//        // Schema Validation
//        given()
//
//        .when()
//
//            .get("/api/users/2")
//
//        .then()
//
//            .assertThat()
//
//            .body(matchesJsonSchemaInClasspath(
//                    "schema.json"))
//
//            .log().all();
//
//
//
//        System.out.println("\n============== PRINT HEADERS ==============");
//
//        // Print Headers
//        getResponse.getHeaders().forEach(
//                System.out::println);
//
//
//
//        System.out.println("\n============== PRINT COOKIES ==============");
//
//        // Print Cookies
//        getResponse.getCookies().forEach(
//                (k,v) -> System.out.println(
//                        k + " : " + v));
//
//
//
//        System.out.println("\n============== TEST COMPLETED ==============");
//    }

	}
}