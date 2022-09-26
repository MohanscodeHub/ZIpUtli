package Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.util.LinkedHashMap;

public class deployZip {

    public static void main(String[] args) {
        deployFilesIntoArtifactory("D:\\clipimprovements.zip","test1.zip");
        
    }

    public static String deployFilesIntoArtifactory(String path,String artifactoryfileName){

        File zipfile = new File(path);
        LinkedHashMap<String,String> head = new LinkedHashMap<>();
        head.put("Authorization","Basic bWpqLmtyaXNobmFuM0BnbWFpbC5jb206UGFzc3Bhc3M0MzIj");
        String downloadURi=null;
        Response response;
        try{

            RestAssured.baseURI = "https://mohan112.jfrog.io";
            response = RestAssured.given().contentType(ContentType.BINARY).headers(head).body(zipfile).relaxedHTTPSValidation().put("/artifactory/example-repo-local/"+artifactoryfileName);
            System.out.println(response.getBody().asString());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;

    }

}
