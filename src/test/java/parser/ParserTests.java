package parser;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import utilities.Iterator;

public class ParserTests {

    @Test
    public void getXMLErrorsTest() {
        Assertion assertion = new Assertion();
        XMLParser parser = new XMLParser("src/test/resources/errorUnexpectedTag.xml");
        String expected = "Unexpected closing tag contact";
        parser.parseDocument();
        parser.getErrors();
        Iterator<String> errorsIter = parser.getErrors().iterator();
        String actual = errorsIter.next();
        assertion.assertEquals(actual,expected);
    }

    @Test
    public void getValidXMLTest() {
        Assertion assertion = new Assertion();
        XMLParser parser = new XMLParser("src/test/resources/validXML.xml");
        parser.parseDocument();
        assertion.assertTrue(parser.getErrors().isEmpty());
    }

    @Test
    public void checkValidationRootTagTest() {
        Assertion assertion = new Assertion();
        XMLParser parser = new XMLParser("src/test/resources/errorRootTag.xml");
        String expected = "Document should start from root tag or instruction. ";
        parser.parseDocument();
        parser.getErrors();
        Iterator<String> errorsIter = parser.getErrors().iterator();
        String actual = errorsIter.next();
        assertion.assertEquals(actual,expected);
    }

    @Test
    public void checkValidationCloseRootTagTest() {
        Assertion assertion = new Assertion();
        XMLParser parser = new XMLParser("src/test/resources/errorCloseRootTag.xml");
        String expected = "Instruction tag is not closed";
        parser.parseDocument();
        parser.getErrors();
        Iterator<String> errorsIter = parser.getErrors().iterator();
        String actual = errorsIter.next();
        assertion.assertEquals(actual,expected);
    }

    @Test
    public void checkValidationDataInRootTagTest() {
        Assertion assertion = new Assertion();
        XMLParser parser = new XMLParser("src/test/resources/errorDataInRootTag.xml");
        String expected = "All data should be inside of the root tag";
        parser.parseDocument();
        parser.getErrors();
        Iterator<String> errorsIter = parser.getErrors().iterator();
        String actual = errorsIter.next();
        assertion.assertEquals(actual,expected);
    }

    @Test
    public void checkValidationFormatTagTest() {
        Assertion assertion = new Assertion();
        XMLParser parser = new XMLParser("src/test/resources/errorFormatTag.xml");
        String expected = "Tag contacts name never closed. Tag names must have format <name>.";
        parser.parseDocument();
        parser.getErrors();
        Iterator<String> errorsIter = parser.getErrors().iterator();
        String actual = errorsIter.next();
        assertion.assertEquals(actual,expected);
    }

    @Test
    public void checkValidationCloseTagTest() {
        Assertion assertion = new Assertion();
        XMLParser parser = new XMLParser("src/test/resources/errorCloseTag.xml");
        String expected = "The tag  closed incorrectly. Missing >";
        parser.parseDocument();
        parser.getErrors();
        Iterator<String> errorsIter = parser.getErrors().iterator();
        String actual = errorsIter.next();
        assertion.assertEquals(actual,expected);
    }
}