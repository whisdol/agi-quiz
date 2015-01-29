package de.fhdw.gruppe2.quizapp.android.dbconnection;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import de.fhdw.gruppe2.quizapp.android.questiondata.AnswerData;
import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionData;
import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionDataMultipleAnswer;
import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionDataNumeric;
import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionDataWithPicture;


public class DatabaseConnection
{
    public DatabaseConnection()
    {
        
    }
    
    
    private String getXMLString(String url)
    {
        URL u;
        String r = "";
        try
        {
            u = new URL(url);
            try
            {
                r = new Scanner( u.openStream() ).useDelimiter( "\\Z" ).next();
            }catch(IOException e)
            {
            
            }
        }catch(MalformedURLException e)
        {
            System.out.println("Hier?");
        }
        
        System.out.println( r );
        return r;
    }
    
    public static QuestionData getFrage(int idFrage)
    {
    	//TODO: Cleanup
    	System.out.println("QuestionData getFrage called");
        String sFragenID = "";
        String sFragenText = "";
        String sRichtig = "";
        String sZeit = "";
        String sFragenTyp = "";
        String sPicturePath = "";
        int i = 0;
        List<AnswerData> lAntworten = new ArrayList<AnswerData>();
        try
        {
            Document document;
            HandleXML parsedXMLobj = new HandleXML("http://a-o-w.lima-city.de/QuizApp/GetFrage.php?fragenID=" + idFrage);
            parsedXMLobj.fetchXML();
            while(parsedXMLobj.isParsingStillRunning());
            document = parsedXMLobj.getmParsedDocument();
            
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            
            sFragenID = xpath.evaluate("/fragen_info/fragenID", document);
            sFragenText = xpath.evaluate("/fragen_info/frageText", document);
            sZeit = xpath.evaluate("/fragen_info/zeit", document);
            sFragenTyp = xpath.evaluate("/fragen_info/frageTyp", document);
            String tempAntwort = xpath.evaluate("/fragen_info/antworten/Antwort0/antwortText", document);
            String tempRichtig = xpath.evaluate("/fragen_info/antworten/Antwort0/richtig", document);
            sPicturePath = xpath.evaluate("/fragen_info/bildPfad", document);
            while(tempAntwort != "")
            {
                lAntworten.add(new AnswerData(tempRichtig, tempAntwort));
                i++;
                tempAntwort = xpath.evaluate("/fragen_info/antworten/Antwort" + i + "/antwortText", document);
                tempRichtig = xpath.evaluate("/fragen_info/antworten/Antwort" + i + "/richtig", document);
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace(System.out);
            return null;
        }
        for(int a = 0; a<lAntworten.size(); a++)
        {
            System.out.println(lAntworten.get(a).getmText());
        }
        System.out.println("Frage: " + sFragenID + " " +sFragenText+ " " +sRichtig+ " " +sZeit + " " + sFragenTyp);
        
        int iFragenID = convertToInt(sFragenID, -1);
        int iZeit = convertToInt(sZeit, 0);
        int iFragenTyp = convertToInt(sFragenTyp, 1);
        
        QuestionData questionObj;
        questionObj = null;
        
        switch(iFragenTyp){
        case 1:
        	//questionObj = new QuestionDataSingleAnswer(Integer.parseInt(sFragenID),sFragenText,lAntworten,1,Integer.parseInt(sZeit));
            break;
        case 2:
        	//questionObj = new QuestionDataMultipleAnswer(Integer.parseInt(sFragenID),sFragenText,lAntworten,1,Integer.parseInt(sZeit));
            break;
        case 3:
        	questionObj = new QuestionDataWithPicture(iFragenID, sFragenText, lAntworten, iZeit,convertToInt(sRichtig,0),sPicturePath);
            break;
        case 4:
            questionObj = new QuestionDataNumeric(iFragenID, sFragenText, lAntworten, iZeit);
            break;
        case 5:
            break;     	
        }
        
        return questionObj;
    }
    
    private static int convertToInt(String sToInt, int defaultValue){
    	//TODO: eventuell auslagern
    	int iRet;
    	try {
    		iRet = Integer.parseInt(sToInt);
    	} catch (Exception e) {
    		iRet = defaultValue;
    	}
    	
    	return iRet;
    }
    
    public static int getUser(String pUser)
    {
        String sUserId = "";
        try
        {
            Document document;
            HandleXML parsedXMLobj = new HandleXML("http://a-o-w.lima-city.de/QuizApp/GetUser.php?userName=" + pUser);
            parsedXMLobj.fetchXML();
            while(parsedXMLobj.isParsingStillRunning());
            document = parsedXMLobj.getmParsedDocument();
            
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            
            sUserId = xpath.evaluate("/user_info/idUser", document);
            
            
        }catch(Exception e)
        {
            System.out.println(e);
            return -1;
        }
        return Integer.parseInt(sUserId);
    }
    
    public static void getSession(int pUserID)
    {
        String sUserId = "";
        try
        {
            Document document;
            HandleXML parsedXMLobj = new HandleXML("http://a-o-w.lima-city.de/QuizApp/GetSession.php?userID=" + pUserID);
            parsedXMLobj.fetchXML();
            while(parsedXMLobj.isParsingStillRunning());
            document = parsedXMLobj.getmParsedDocument();
            
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            
            //sUserId = xpath.evaluate("/user_info/idUser", document);
            
            
        }catch(Exception e)
        {
            System.out.println(e);
            return;
        }
        //return Integer.parseInt(sUserId);
        
    }
    
    public static void updateSessionFrage(int pSessionID, int pFragenID, int pRichtig, String pAntwort)
    {
    	String sUserId = "";
        try
        {
            Document document;
            HandleXML parsedXMLobj = new HandleXML("http://a-o-w.lima-city.de/QuizApp/UpdateSessionFrage.php?sessionID=" + pSessionID + "&fragenID=" + pFragenID + "&richtig=" + pRichtig + "&antwort=" + pAntwort );
            parsedXMLobj.fetchXML();
            
            //XPathFactory xpathFactory = XPathFactory.newInstance();
            //XPath xpath = xpathFactory.newXPath();
            
            //sUserId = xpath.evaluate("/user_info/idUser", document);
            
            
        }catch(Exception e)
        {
            System.out.println(e);
            return;
        }
    }
}