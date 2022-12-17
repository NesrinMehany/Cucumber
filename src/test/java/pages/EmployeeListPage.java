package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class EmployeeListPage extends CommonMethods {
    @FindBy(id="empsearch_id")
    public WebElement empSearchIdField;



    @FindBy(xpath = "//input[@name='empsearch[employee_name][empName]']")
    public WebElement empSearchNameField;

    @FindBy(id="searchBtn")
    public WebElement searchButton;

   /* @FindAll(@FindBy(xpath = "//table/thead/tr/th"))
    public List<WebElement> resultTablehearders;*/

    /*@FindAll(@FindBy(xpath = "//table/tbody/tr["+(bIndex+1])+"]/td"))
    public List<WebElement> resultTableBody;*/

    public EmployeeListPage(){
        PageFactory.initElements(driver,this);
    }

}
