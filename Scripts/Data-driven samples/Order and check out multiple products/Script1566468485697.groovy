import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.stream.Collectors

import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import sample.Login as GlobalVariable



/*Login login = new Login()

login.loginIntoApplicationWithGlobalVariable() */

CustomKeywords.'sample.Login.loginIntoApplicationWithGlobalVariable'()

WebUI.waitForElementPresent(findTestObject('Pages/Shop page/lnkShop'), GlobalVariable.waitPresentTimeout)

WebUI.click(findTestObject('Pages/Shop page/lnkShop'))

TestData product = findTestData(GlobalVariable.dataFile)
List<String> productList = product.getAllData().stream()
							.map{data -> data[0]}/*get first column of each row in data file */
							.collect(Collectors.toList())/*add collect and parse to list*/

for(def productName : productList){
	CustomKeywords.'sample.Shop.addToCart'(productName.toString(), GlobalVariable.urlProduct)
}
CustomKeywords.'sample.Checkout.CheckoutShopWithGlobalVariable'()
WebUI.closeBrowser()