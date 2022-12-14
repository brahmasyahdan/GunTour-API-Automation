package GunTour.StepDefinitions.User;

import GunTour.API.GunTourAPI_Login;
import GunTour.API.GunTourAPI_User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
//import org.assertj.core.api.Assertions;
import org.junit.Assert;

import java.io.File;

public class PostUserRegisterStepDef {

    @Steps
    GunTourAPI_User gunTourAPIUser;

    @Given("Post register user with valid json file")
    public void postRegisterUserWithValidJsonFile(){
        File json = new File(GunTourAPI_User.JSON_FILE_USER+"/RequestBody/UserRegisRequestbody/UserValidRegisterBodyValidation.json");
        gunTourAPIUser.postUserRegister(json);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(GunTourAPI_User.POST_REGISTER);
    }

    @Then("API response status code should be {int} created")
    public void apiResponseStatusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @Given("Post register user without full name in json file")
    public void postRegisterUserWithoutFullNameInJsonFile() {
        File json = new File(GunTourAPI_User.JSON_FILE_USER+"/RequestBody/UserRegisRequestbody/UserInvalidRegisterWithoutFullName.json");
        gunTourAPIUser.postUserRegister(json);
    }

    @Then("API response status code should be {int} bad request")
    public void apiResponseStatusCodeShouldBeBadRequest(int BadRequest) {
        SerenityRest.then().statusCode(BadRequest);
    }

    @Given("Post register user without email in json file")
    public void postRegisterUserWithoutEmailInJsonFile() {
        File json = new File(GunTourAPI_User.JSON_FILE_USER+"/RequestBody/UserRegisRequestbody/UserInvalidRegisterWithoutEmail.json");
        gunTourAPIUser.postUserRegister(json);
    }

    @Given("Post register user without password in json file")
    public void postRegisterUserWithoutPasswordInJsonFile() {
        File json = new File(GunTourAPI_User.JSON_FILE_USER+"/RequestBody/UserRegisRequestbody/UserInvalidRegisterWithoutPassword.json");
        gunTourAPIUser.postUserRegister(json);
    }

    @Given("Post register user without all data in json file")
    public void postRegisterUserWithoutAllDataInJsonFile() {
        File json = new File(GunTourAPI_User.JSON_FILE_USER+"/RequestBody/UserRegisRequestbody/UserInvalidRegisterWithoutAllData.json");
        gunTourAPIUser.postUserRegister(json);
    }

    @When("Send request post register user invalid path")
    public void sendRequestPostRegisterUserInvalidPath() {
        SerenityRest.when().post(GunTourAPI_User.BASE_URL_USER+"//usertok");
    }

    @Then("API response status code should be {int} not found")
    public void apiResponseStatusCodeShouldBeNotFound(int notfound) {
        SerenityRest.then().statusCode(notfound);
    }

    //Put
    @Given("Set request update user with all valid data")
    public void setRequestUpdateUserWithAllValidData() {
        File json = new File(GunTourAPI_User.JSON_FILE_USER+"/RequestBody/UserRegisRequestbody/UserValidBodyRequestPut.json");
        gunTourAPIUser.updatePutUser(json);
    }

    @When("Send request update user")
    public void sendRequestUpdateUser() {
        SerenityRest.when().put(GunTourAPI_User.PUT_USER);
    }

    @Then("API response status code should be {int} Accepted")
    public void apiResponseStatusCodeShouldBeAccepted(int accepted) {
        SerenityRest.then().statusCode(accepted);
    }


    //Background
    @Given("Post login user update with valid json file")
    public void postLoginUserUpdateWithValidJsonFile() {
        File json = new File(GunTourAPI_Login.JSON_FILE_LOGIN+"/RequestBody/UserRegisRequestbody/LoginUserValidUpdate.json");
        gunTourAPIUser.loginUpdateUser(json);
    }

    @When("Send request post update login user")
    public void sendRequestPostUpdateLoginUser() {
        SerenityRest.when().post(GunTourAPI_Login.POST_LOGIN);
    }

    @Then("API response status login user update code should be {int} accepted")
    public void apiResponseStatusLoginUserUpdateCodeShouldBeAccepted(int accepted) {
        SerenityRest.then().statusCode(accepted);
    }
    @And("Get auth token")
    public void getAuthToken() {
        gunTourAPIUser.AUTH_USER= SerenityRest.then().extract().path("data.token");
    }

    @And("Auth token not null")
    public void authTokenNotNull() {
        Assert.assertNotNull(gunTourAPIUser.AUTH_USER);
    }

    //Delete
    @Given("Set request delete user with already registered")
    public void setRequestDeleteUserWithAlreadyRegistered() {
        gunTourAPIUser.deleteUser();
    }
    @When("Send request delete user valid path")
    public void sendRequestDeleteUserValidPath() {
        SerenityRest.when().delete(GunTourAPI_User.DELETE_USER);
    }


    @Then("API response status code should be {int} ok")
    public void apiResponseStatusCodeShouldBeOk(int ok) {
        SerenityRest.then().statusCode(ok);
    }
}
