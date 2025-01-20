package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HerokuAppDropdownPage extends HerokuAppTestBase {
    @FindBy(css = "#dropdown")
    WebElement dropdownList;
    @FindBy(css = "#dropdown > option:nth-child(2)")
    WebElement option1;
    @FindBy(css = "#dropdown > option:nth-child(3)")
    WebElement option2;

    public HerokuAppDropdownPage()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean validateDropdownOptions(){
        dropdownList.click();
        Select optionSelect = new Select(dropdownList);
        optionSelect.selectByVisibleText("Option 1");

        logger.info("Selected option from dropdown list is "+optionSelect.getFirstSelectedOption().getText());
        return optionSelect.getFirstSelectedOption().getText().equals("Option 1");
    }

}
