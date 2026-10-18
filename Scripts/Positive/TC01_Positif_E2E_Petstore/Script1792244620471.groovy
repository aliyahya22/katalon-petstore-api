import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import internal.GlobalVariable as GlobalVariable

GlobalVariable.petId = 12345
GlobalVariable.petName = 'DoggieKatalon'

//POST - TAMBAH PET BARU
def responsePost = WS.sendRequest(findTestObject('Object Repository/POST_AddPet'))
WS.verifyResponseStatusCode(responsePost, 200)
WS.verifyElementPropertyValue(responsePost, 'id', GlobalVariable.petId)
WS.verifyElementPropertyValue(responsePost, 'name', GlobalVariable.petName)

//GET - AMBIL DATA PET BERDASARKAN ID
def responseGet = WS.sendRequest(findTestObject('Object Repository/GET_PetById'))
WS.verifyResponseStatusCode(responseGet, 200)
WS.verifyElementPropertyValue(responseGet, 'id', GlobalVariable.petId)
WS.verifyElementPropertyValue(responseGet, 'name', GlobalVariable.petName)

//PUT - UPDATE DATA PET (UBAH NAMA)
GlobalVariable.petName = 'DoggieKatalon_Updated'
def responsePut = WS.sendRequest(findTestObject('Object Repository/PUT_UpdatePet'))
WS.verifyResponseStatusCode(responsePut, 200)
WS.verifyElementPropertyValue(responsePut, 'id', GlobalVariable.petId)
WS.verifyElementPropertyValue(responsePut, 'name', GlobalVariable.petName)

//DELETE - HAPUS DATA PET
def responseDelete = WS.sendRequest(findTestObject('Object Repository/DELETE_Pet'))
WS.verifyResponseStatusCode(responseDelete, 200)
WS.verifyElementPropertyValue(responseDelete, 'message', GlobalVariable.petId.toString())
