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

import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionData;
import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionDataMultipleAnswer;


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
        String sFragenID = "";
        String sFragenText = "";
        String sRichtig = "";
        String sZeit = "";
        String sFragenTyp = "";
        int i = 0;
        List<String> lAntworten = new ArrayList<String>();
        //String sUrl = "http://a-o-w.lima-city.de/QuizApp/GetFrage.php?fragenID=" + idFrage;
        //String sUrl = "http://a-o-w.lima-city.de/Rezept/";
        //String sXML = getXMLString(sUrl);
        //System.out.println("\u00D6");
        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("http://a-o-w.lima-city.de/QuizApp/GetFrage.php?fragenID=" + idFrage);
            
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            
            sFragenID = xpath.evaluate("/fragen_info/fragenID", document);
            sFragenText = xpath.evaluate("/fragen_info/frageText", document);
            sZeit = xpath.evaluate("/fragen_info/zeit", document);
            sFragenTyp = xpath.evaluate("/fragen_info/frageTyp", document);
            String tempAntwort = xpath.evaluate("/fragen_info/antworten/Antwort0/antwortText", document);
            String tempRichtig = xpath.evaluate("/fragen_info/antworten/Antwort0/richtig", document);
            while(tempAntwort != "")
            {
                sRichtig += tempRichtig;
                lAntworten.add(tempAntwort);
                i++;
                tempAntwort = xpath.evaluate("/fragen_info/antworten/Antwort" + i + "/antwortText", document);
                tempRichtig = xpath.evaluate("/fragen_info/antworten/Antwort" + i + "/richtig", document);
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
        for(int a = 0; a<lAntworten.size(); a++)
        {
            System.out.println(lAntworten.get(a));
        }
        System.out.println("Frage: " + sFragenID + " " +sFragenText+ " " +sRichtig+ " " +sZeit + " " + sFragenTyp);
        return new QuestionDataMultipleAnswer(Integer.parseInt(sFragenID),sFragenText,lAntworten,1,Integer.parseInt(sZeit));
    }
    
    public static int getUser(String pUser)
    {
        String sUserId = "";
        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("http://a-o-w.lima-city.de/QuizApp/GetUser.php?userName=" + pUser);
            
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
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("http://a-o-w.lima-city.de/QuizApp/GetSession.php?userID=" + pUserID);
            
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
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("http://a-o-w.lima-city.de/QuizApp/UpdateSessionFrage.php?sessionID=" + pSessionID + "&fragenID=" + pFragenID + "&richtig=" + pRichtig + "&antwort=" + pAntwort );
            
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