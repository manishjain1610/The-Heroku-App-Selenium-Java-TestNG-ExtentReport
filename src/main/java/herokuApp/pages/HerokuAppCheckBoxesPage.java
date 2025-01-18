package herokuApp.pages;
import herokuApp.base.HerokuAppTestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HerokuAppCheckBoxesPage extends HerokuAppTestBase {
    @FindBy(css = "#checkboxes > input[type=checkbox]:nth-child(1)")
    WebElement checkBox1;
    @FindBy(css = "#checkboxes > input[type=checkbox]:nth-child(3)")
    WebElement checkBox2;

    public HerokuAppCheckBoxesPage()
    {
        PageFactory.initElements(driver, this);
    }

    public Boolean validateCheckBoxesStatus(){
        boolean checkbox1Status = checkBox1.isSelected();
        boolean checkbox2Status = checkBox2.isSelected();
        checkBox1.click();
        checkBox2.click();
        return (checkbox1Status != checkBox1.isSelected()) && (checkbox2Status != checkBox2.isSelected());
    }
}
