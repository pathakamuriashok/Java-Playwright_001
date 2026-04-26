package Dropdown_Handling;

import com.microsoft.playwright.Page;

public class DropDown_04_GetAll_DropDownValues{

	Page page;
	DropDown_03 d3=new DropDown_03();
	
	public DropDown_04_GetAll_DropDownValues()
	{
		page=d3.BrowserLaunch();
		d3.LoadApplication("https://www.wikipedia.org/");
	}
	
	public void GetAllValues_01()
	{
		int NumberOfValues_DropDown=page.locator("#searchLanguage option").count(); 
		System.out.println(NumberOfValues_DropDown); 
	}
	public void PrintAllValues_DropDown() {
		int NumberOfValues_DropDown=page.locator("#searchLanguage option").count(); 
		System.out.println(NumberOfValues_DropDown); 
		
		//String value=page.locator("#searchLanguage").nth(0).textContent();
		//System.out.println(value); 
	
		for(int i=0;i<NumberOfValues_DropDown;i++)
		{
			String value=page.locator("#searchLanguage option").nth(i).textContent();
			System.out.println(value); 
		}
		
	}
	public void CLOSE() {
		d3.Close();
	}
	public static void main(String[] args) {
		
		DropDown_04_GetAll_DropDownValues d=new DropDown_04_GetAll_DropDownValues();

		d.GetAllValues_01();
		d.PrintAllValues_DropDown();
		d.CLOSE();
	}

}
