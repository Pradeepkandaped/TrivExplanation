package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangehrmLoginPage {
	
	@FindBy(name="username")
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath="//p[text()='Forgot your password? ']")
	private WebElement forgotPassword;
	
	@FindBy(xpath="//a[text()='OrangeHRM, Inc']")
	private WebElement orangehrmLink;
	
	public OrangehrmLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public  void enterUsername(String un) {
		
		userName.sendKeys(un);
	}
	
	public void enterPassword(String pw) {
		password.sendKeys(pw);
	}
	
	public void clickloginButton() {
		loginButton.click();
		
	}
	
	public void clickOrange() {
		orangehrmLink.click();
	}
	
	public void clickForgotPasswordLink() {
		forgotPassword.click();
	}
	
	public void clearUsername() {
		userName.clear();
	}
	
	public void clearPassword() {
		password.clear();
	}
	

}
