package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.CommonMethods;

import javax.swing.*;
import java.util.List;

public class EmployeeSearchSteps extends CommonMethods {

    @When("user clicks on EmployeeList option")
    public void user_clicks_on_employee_list_option() {
        WebElement empListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        click(empListOption);
    }

    @When("user enter valid employee id")
    public void user_enter_valid_employee_id(String validId) {
        /*WebElement empIdField = driver.findElement(By.id("empsearch_id"));
        sendText(empIdField, "45154A");*/
        sendText(employeeList.empSearchIdField, validId);

    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        /*WebElement searchButton = driver.findElement(By.id("searchBtn"));
        click(searchButton);*/
        click(employeeList.searchButton);

    }

    @Then("user see employee information is displayed")
    public void user_see_employee_information_is_displayed(String expectedFirstName) throws InterruptedException {
        System.out.println("employee information is displayed");

        boolean firstNameVerified = false;

        int index=0;

        List<WebElement> resultTablehearders = driver.findElements(By.xpath("//table/thead/tr/th"));
        for (int hIndex = 0; hIndex < resultTablehearders.size(); hIndex++) {
            String headerText = resultTablehearders.get(hIndex).getText();
            System.out.println("header****:" + headerText);
            if (headerText.equalsIgnoreCase("First (& Middle) Name")) {
                index = hIndex;
                System.out.println(index);
                break;

            }
        }
                List<WebElement> resultTableRows = driver.findElements(By.xpath("//table/tbody/tr"));

                for (int rIndex = 0; rIndex < resultTableRows.size(); rIndex++) {
                    WebElement resultTableCol = driver.findElement(By.xpath("//table/tbody/tr["+(rIndex+1)+"]/td["+(index+1)+"]"));
                    String actualFirstName = resultTableCol.getText();
                    System.out.println(actualFirstName);
                    if (expectedFirstName.equalsIgnoreCase(actualFirstName)) {
                        firstNameVerified = true;
                        System.out.println(firstNameVerified);
                    }
                }
                Assert.assertTrue(firstNameVerified);
            }





    @When("user enters valid employee name")
    public void user_enters_valid_employee_name(String validName) {
        //WebElement searchNameField = driver.findElement(By.id("empsearch_employee_name_empName"));
      sendText(employeeList.empSearchIdField, validName);



    }
}
