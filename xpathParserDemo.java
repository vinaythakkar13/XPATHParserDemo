import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.*;
import javax.xml.xpath.XPathExpression;


public class xpathParserDemo
{
    public void xPathProcessor() throws SAXException,IOException,XPathExpressionException,ParserConfigurationException 
		{
			//Create DocumentBuilderFactory for reading xml file
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();;
			Document doc = builder.parse("xpathparser.xml");

			// Create XPathFactory for creating XPath Object
			XPathFactory xPathFactory = XPathFactory.newInstance();
		
			// Create XPath object from XPathFactory
			XPath xpath = xPathFactory.newXPath();
			String expr = "//sz"+"/text()";
			System.out.println("\n Expression : "+expr);
        
			XPathExpression xPathExpr = xpath.compile(expr);
			Object result = xPathExpr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println("<sz> "+ nodes.item(i).getNodeValue() + " </sz>");
			}  
		}		
		

		public static void main(String[] args) throws  ParserConfigurationException, SAXException, IOException 
		{
			try{
			xpathParserDemo xPathExample = new xpathParserDemo();
			xPathExample.xPathProcessor();
			}
			
			catch (ParserConfigurationException e)
			{
				e.printStackTrace();
			} 
			catch (SAXException e) 
			{
				e.printStackTrace();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			catch (XPathExpressionException e)
			{
				e.printStackTrace();
			}
		}
}

