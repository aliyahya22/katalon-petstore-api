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


//GET - CARI PET YANG TIDAK ADA (ID Tidak Terdaftar)
GlobalVariable.petId = 99999999
def responseGetNotExists = WS.sendRequest(findTestObject('Object Repository/GET_PetById'))
WS.verifyResponseStatusCode(responseGetNotExists, 404)
WS.verifyElementPropertyValue(responseGetNotExists, 'message', 'Pet not found')

//POST - TAMBAH PET DENGAN PAYLOAD KOSONG
GlobalVariable.petId = 0
GlobalVariable.petName = ''
def responsePostInvalid = WS.sendRequest(findTestObject('Object Repository/POST_AddPet'))
WS.verifyResponseStatusCode(responsePostInvalid, 200)

// DELETE - HAPUS PET DENGAN ID YANG TIDAK ADA (Expect 404)
GlobalVariable.petId = 88888888
def responseDeleteNotExists = WS.sendRequest(findTestObject('Object Repository/DELETE_Pet'))
WS.verifyResponseStatusCode(responseDeleteNotExists, 404)

// GET LAGI - MEMASTIKAN PET TETAP TIDAK ADA (Expect 404)
GlobalVariable.petId = 99999999

def responseGetAgain = WS.sendRequest(findTestObject('Object Repository/GET_PetById'))

WS.verifyResponseStatusCode(responseGetAgain, 404)
WS.verifyElementPropertyValue(responseGetAgain, 'message', 'Pet not found')