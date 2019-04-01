package com.testautomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class YoutubeSearchPage {

	//https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/FindBy.html
	//https://stackoverflow.com/questions/49171087/how-how-id-in-selenium
	//https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/pagefactory/Annotations.html
	
	WebDriver driver;
	
	//Constructor which accepts WebDriver as argument type
	public YoutubeSearchPage (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//@FindBy(id = "search") WebElement SearchTextbox;
	@FindBy(how=How.ID,using="search")
	public WebElement SearchTextbox;
	
	@FindBy(how=How.XPATH,using="//button[@id='search-icon-legacy']")
	public WebElement SearchButton;
	
	public void NavigateToResultPage(String searchString)
	{
		//SearchTextbox.sendKeys("selenium by bakkappa n");
		SearchTextbox.sendKeys(searchString);
		SearchButton.click();
	}

	
	
	//Source code of the enum How it is defined as
	/*
			 public enum How {
		  CLASS_NAME {
		    @Override
		    public By buildBy(String value) {
		      return By.className(value);
		    }
		  },
		  CSS {
		    @Override
		    public By buildBy(String value) {
		      return By.cssSelector(value);
		    }
		  },
		  ID {
		    @Override
		    public By buildBy(String value) {
		      return By.id(value);
		    }
		  },
		  ID_OR_NAME {
		    @Override
		    public By buildBy(String value) {
		      return new ByIdOrName(value);
		    }
		  },
		  LINK_TEXT {
		    @Override
		    public By buildBy(String value) {
		      return By.linkText(value);
		    }
		  },
		  NAME {
		    @Override
		    public By buildBy(String value) {
		      return By.name(value);
		    }
		  },
		  PARTIAL_LINK_TEXT {
		    @Override
		    public By buildBy(String value) {
		      return By.partialLinkText(value);
		    }
		  },
		  TAG_NAME {
		    @Override
		    public By buildBy(String value) {
		      return By.tagName(value);
		    }
		  },
		  XPATH {
		    @Override
		    public By buildBy(String value) {
		      return By.xpath(value);
		    }
		  },
		  UNSET {
		    @Override
		    public By buildBy(String value) {
		      return ID.buildBy(value);
		    }
		  };
		
		  public abstract By buildBy(String value);
		}
	 */
	
}
