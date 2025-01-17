package herokuApp.pages;

import herokuApp.base.HerokuAppTestBase;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;

public class HerokuAppHomePage extends HerokuAppTestBase {
    @FindBy(css = "#content > h1")
    WebElement pageHeader;
    @FindBy(css = "#content > h2")
    WebElement secondPageHeader;
    @FindBy(css = "#content > ul > li:nth-child(1) > a")
    WebElement abTestingURL;
    @FindBy(css = "#content > ul > li:nth-child(2) > a")
    WebElement addRemoveElementsURL;
    @FindBy(css = "#content > ul > li:nth-child(3) > a")
    WebElement basicAuthURL;
    @FindBy(css = "#content > ul > li:nth-child(4) > a")
    WebElement brokenImagesURL;
    @FindBy(css = "#content > ul > li:nth-child(5) > a")
    WebElement challengingDOMURL;
    @FindBy(css = "#content > ul > li:nth-child(6) > a")
    WebElement checkboxesURL;
    @FindBy(css = "#content > ul > li:nth-child(7) > a")
    WebElement contextMenuURL;
    @FindBy(css = "#content > ul > li:nth-child(8) > a")
    WebElement digestAuthenticationURL;
    @FindBy(css = "#content > ul > li:nth-child(9) > a")
    WebElement disappearingElementsURL;
    @FindBy(css = "#content > ul > li:nth-child(10) > a")
    WebElement dragAndDropElementsURL;
    @FindBy(css = "#content > ul > li:nth-child(11) > a")
    WebElement dropdownURL;
    @FindBy(css = "#content > ul > li:nth-child(12) > a")
    WebElement dynamicContentURL;
    @FindBy(css = "#content > ul > li:nth-child(13) > a")
    WebElement dynamicControlsURL;
    @FindBy(css = "#content > ul > li:nth-child(14) > a")
    WebElement dynamicLoadingURL;
    @FindBy(css = "#content > ul > li:nth-child(15) > a")
    WebElement entryAdURL;
    @FindBy(css = "#content > ul > li:nth-child(16) > a")
    WebElement exitIntentURL;
    @FindBy(css = "#content > ul > li:nth-child(17) > a")
    WebElement fileDownloadURL;
    @FindBy(css = "#content > ul > li:nth-child(18) > a")
    WebElement fileUploadURL;
    @FindBy(css = "#content > ul > li:nth-child(19) > a")
    WebElement floatingMenuURL;
    @FindBy(css = "#content > ul > li:nth-child(20) > a")
    WebElement forgotPasswordURL;
    @FindBy(css = "#content > ul > li:nth-child(21) > a")
    WebElement formAuthenticationURL;
    @FindBy(css = "#content > ul > li:nth-child(22) > a")
    WebElement framesURL;
    @FindBy(css = "#content > ul > li:nth-child(23) > a")
    WebElement geoLocationURL;
    @FindBy(css = "#content > ul > li:nth-child(24) > a")
    WebElement horizontalSliderURL;
    @FindBy(css = "#content > ul > li:nth-child(25) > a")
    WebElement hoversURL;
    @FindBy(css = "#content > ul > li:nth-child(26) > a")
    WebElement infiniteScrollURL;
    @FindBy(css = "#content > ul > li:nth-child(27) > a")
    WebElement inputsURL;
    @FindBy(css = "#content > ul > li:nth-child(28) > a")
    WebElement jqueryUIMenusURL;
    @FindBy(css = "#content > ul > li:nth-child(29) > a")
    WebElement javascriptAlertsURL;
    @FindBy(css = "#content > ul > li:nth-child(30) > a")
    WebElement javascriptOnLoadEventErrorURL;
    @FindBy(css = "#content > ul > li:nth-child(31) > a")
    WebElement keyPressesURL;
    @FindBy(css = "#content > ul > li:nth-child(32) > a")
    WebElement largeAndDeepDOMURL;
    @FindBy(css = "#content > ul > li:nth-child(33) > a")
    WebElement multipleWindowsURL;
    @FindBy(css = "#content > ul > li:nth-child(34) > a")
    WebElement nestedFramesURL;
    @FindBy(css = "#content > ul > li:nth-child(35) > a")
    WebElement notificationMessagesURL;
    @FindBy(css = "#content > ul > li:nth-child(36) > a")
    WebElement redirectLinkURL;
    @FindBy(css = "#content > ul > li:nth-child(37) > a")
    WebElement secureFileDownloadURL;
    @FindBy(css = "#content > ul > li:nth-child(38) > a")
    WebElement shadowDOMURL;
    @FindBy(css = "#content > ul > li:nth-child(39) > a")
    WebElement shiftingContentURL;
    @FindBy(css = "#content > ul > li:nth-child(40) > a")
    WebElement slowResourcesURL;
    @FindBy(css = "#content > ul > li:nth-child(41) > a")
    WebElement sortableDataTableURL;
    @FindBy(css = "#content > ul > li:nth-child(42) > a")
    WebElement statusCodesURL;
    @FindBy(css = "#content > ul > li:nth-child(43) > a")
    WebElement typosURL;
    @FindBy(css = "#content > ul > li:nth-child(44) > a")
    WebElement wysiwygEditorURL;

    public HerokuAppHomePage()
    {
        PageFactory.initElements(driver, this);
    }
    public String validateHomePageTitle()
    {
        return driver.getTitle();
    }

    public String validateHomePageHeader()
    {
        return this.pageHeader.getText();
    }

    public void gotoHomePage(){
        homePage();
    }

    public void gotoABTestingPage ()
    {
      this.abTestingURL.click();
    }

    public void gotoAddRemoveElementsPage ()
    {
        this.addRemoveElementsURL.click();
    }

    public void gotoBasicAuthPage ()
    {
        this.basicAuthURL.click();
    }

    public void gotoBrokenImagesPage ()
    {
        this.brokenImagesURL.click();
    }

    public void gotoChallengingDOMPage ()
    {
        this.challengingDOMURL.click();
    }

    public void gotoCheckboxesPage ()
    {
        this.checkboxesURL.click();
    }

    public void gotoContextMenuPage ()
    {
        this.contextMenuURL.click();
    }

    public void gotoDigestAuthenticationPage ()
    {
        this.digestAuthenticationURL.click();
    }

    public void gotoDisappearingElementsPage ()
    {
        this.disappearingElementsURL.click();
    }

    public void gotoDragAndDropElementsPage ()
    {
        this.dragAndDropElementsURL.click();
    }

    public void gotoDropDownPage ()
    {
        this.dropdownURL.click();
    }

    public void gotoDynamicContentPage ()
    {
        this.dynamicContentURL.click();
    }

    public void gotoDynamicControlPage ()
    {
        this.dynamicControlsURL.click();
    }

    public void gotoDynamicLoadingPage ()
    {
        this.dynamicLoadingURL.click();
    }

    public void gotoEntryAdPage ()
    {
        this.entryAdURL.click();
    }

    public void gotoExitInternalPage ()
    {
        this.exitIntentURL.click();
    }

    public void gotoFileDownloadPage ()
    {
        this.fileDownloadURL.click();
    }

    public void gotoFileUploadPage ()
    {
        this.fileUploadURL.click();
    }

    public void gotoFloatingMenuPage ()
    {
        this.floatingMenuURL.click();
    }

    public void gotoForgotPasswordPage ()
    {
        this.forgotPasswordURL.click();
    }

    public void gotoFormAuthenticationPage ()
    {
        this.formAuthenticationURL.click();
    }

    public void gotoFramesPage ()
    {
        this.framesURL.click();
    }

    public void gotoGeoLocationPage ()
    {
        this.geoLocationURL.click();
    }

    public void gotoHorizontalSliderPage ()
    {
        this.horizontalSliderURL.click();
    }

    public void gotoHoversPage ()
    {
        this.hoversURL.click();
    }

    public void gotoInfiniteScrollPage ()
    {
        this.infiniteScrollURL.click();
    }

    public void gotoInputsPage ()
    {
        this.inputsURL.click();
    }

    public void gotoJQueryPage ()
    {
        this.jqueryUIMenusURL.click();
    }

    public void gotoJavaScriptAlertsPage ()
    {
        this.javascriptAlertsURL.click();
    }

    public void gotoJavaScriptOnLoadEventErrorPage ()
    {
        this.javascriptOnLoadEventErrorURL.click();
    }

    public void gotoKeyPressesPage ()
    {
        this.keyPressesURL.click();
    }

    public void gotoLargeAndDeepDOMPage ()
    {
        this.largeAndDeepDOMURL.click();
    }

    public void gotoMultipleWindowsPage ()
    {
        this.multipleWindowsURL.click();
    }

    public void gotoNestedFramesPage ()
    {
        this.nestedFramesURL.click();
    }

    public void gotoNotificationMessagesPage ()
    {
        this.notificationMessagesURL.click();
    }

    public void gotoRedirectLinkPage ()
    {
        this.redirectLinkURL.click();
    }

    public void gotoSecureFileDownloadPage ()
    {
        this.secureFileDownloadURL.click();
    }

    public void gotoShadowDOMPage ()
    {
        this.shadowDOMURL.click();
    }

    public void gotoShiftingContentPage ()
    {
        this.shiftingContentURL.click();
    }

    public void gotoSlowResourcesPage ()
    {
        this.slowResourcesURL.click();
    }

    public void gotoSortableDataTablePage ()
    {
        this.sortableDataTableURL.click();
    }

    public void gotoTyposPage ()
    {
        this.typosURL.click();
    }

    public void gotoStatusCodesPage ()
    {
        this.statusCodesURL.click();
    }

    public void gotoWYSIWYGEditorPage ()
    {
        this.wysiwygEditorURL.click();
    }

}
