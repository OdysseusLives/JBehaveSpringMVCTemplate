package org.jbehave.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.id;

public class PageUtils {

	private WebDriver webDriver;
	
	public void open(String url) {
		webDriver.get(url);
	}

	public void fillFormField(String fieldId, String content) {
		WebElement element = webDriver.findElement(id(fieldId));
		element.clear();
		element.sendKeys(content);
	}
	
	public void submitForm(String submitId) {
		WebElement element = webDriver.findElement(id(submitId));
		element.submit();
	}
	
	public String getElementText(String elementId) {
		WebElement element = webDriver.findElement(id(elementId));
		return element.getText();
	}
	
	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

    public void close() {
        webDriver.quit();
    }
}
