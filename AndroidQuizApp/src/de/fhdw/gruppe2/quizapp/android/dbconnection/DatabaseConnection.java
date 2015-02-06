package de.fhdw.gruppe2.quizapp.android.dbconnection;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import de.fhdw.gruppe2.quizapp.android.questiondata.AnswerData;
import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionData;
import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionDataMultipleAnswer;
import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionDataNumeric;
import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionDataOrder;
import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionDataSingleAnswer;
import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionDataWithPicture;


public class DatabaseConnection
{
       
    public static QuestionData getFrage(int idFrage)
    {
    	System.out.println("----------idFrage: " + idFrage);
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
        System.out.println(sFragenTyp + " " + iFragenTyp);
        
        QuestionData questionObj;
        questionObj = null;
        
        switch(iFragenTyp){
        case 1:
        	questionObj = new QuestionDataSingleAnswer(iFragenID,sFragenText,lAntworten,iZeit);
            break;
        case 2:
        	questionObj = new QuestionDataMultipleAnswer(Integer.parseInt(sFragenID),sFragenText,lAntworten,1,Integer.parseInt(sZeit));
            break;
        case 3:
        	questionObj = new QuestionDataWithPicture(iFragenID, sFragenText, lAntworten, iZeit,sPicturePath);
            break;
        case 4:
            questionObj = new QuestionDataNumeric(iFragenID, sFragenText, lAntworten, iZeit);
            break;
        case 5:
        	questionObj = new QuestionDataOrder(iFragenID, sFragenText, lAntworten, iZeit);
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
    
    public static QSession getSession(int pUserID)
    {
        try
        {
            Document document;
            HandleXML parsedXMLobj = new HandleXML("http://a-o-w.lima-city.de/QuizApp/GetSession.php?userID=" + pUserID);
            parsedXMLobj.fetchXML();
            while(parsedXMLobj.isParsingStillRunning());
            document = parsedXMLobj.getmParsedDocument();
            
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            
            String sSessionID;
            String sTempQuestionID;
            String sTempQuestionType;
            String sRichtig;
            List<QSessionQuestion> questions = new ArrayList<QSessionQuestion>();
            
            
            sSessionID = xpath.evaluate("/session_info/sessionID", document);
            sTempQuestionID = xpath.evaluate("/session_info/fragen/Frage0/idFrage", document);
            sTempQuestionType = xpath.evaluate("/session_info/fragen/Frage0/Fragentyp", document);
            sRichtig = xpath.evaluate("/session_info/fragen/Frage0/richtig", document);
            int i = 0;
            while(sTempQuestionID != "")
            {
            	questions.add(new QSessionQuestion(convertToInt(sTempQuestionID, 0), convertToInt(sTempQuestionType, 0),convertToInt(sRichtig, 0)));
                i++;
                sTempQuestionID = xpath.evaluate("/session_info/fragen/Frage" + i + "/idFrage", document);
                sTempQuestionType = xpath.evaluate("/session_info/fragen/Frage" + i + "/Fragentyp", document);
                sRichtig = xpath.evaluate("/session_info/fragen/Frage" + i + "/richtig", document);
            }
            
            return new QSession(convertToInt(sSessionID, -1), questions);
            
            
        }catch(Exception e)
        {
            System.out.println(e);
            List<QSessionQuestion> questions = new ArrayList<QSessionQuestion>();
            return new QSession(-1, questions);
        }
        
    }
    
    public static void updateSessionFrage(int pSessionID, int pFragenID, int pRichtig, String pAntwort)
    {
        try
        {
        	System.out.print("http://a-o-w.lima-city.de/QuizApp/UpdateSessionFrage.php?sessionID=" + pSessionID + "&fragenID=" + pFragenID + "&richtig=" + pRichtig + "&antwort=" + pAntwort);
            HandleXML parsedXMLobj = new HandleXML("http://a-o-w.lima-city.de/QuizApp/UpdateSessionFrage.php?sessionID=" + pSessionID + "&fragenID=" + pFragenID + "&richtig=" + pRichtig + "&antwort=" + pAntwort );
            parsedXMLobj.fetchXML();
        }catch(Exception e)
        {
            System.out.println(e);
            return;
        }
    }
    
    public static ArrayList<String> getScoreBoard(){
    	ArrayList<String> userList = new ArrayList<String>();
    	try
        {
            Document document;
            HandleXML parsedXMLobj = new HandleXML("http://a-o-w.lima-city.de/QuizApp/GetStatistic.php");
            parsedXMLobj.fetchXML();
            while(parsedXMLobj.isParsingStillRunning());
            document = parsedXMLobj.getmParsedDocument();
            
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            
            String tmpName;
            String tmpScore;
            
            tmpName = xpath.evaluate("/scoreboard/User/User0/Name", document);
            tmpScore = xpath.evaluate("/scoreboard/User/User0/Count", document);
            int i = 0;
            while(tmpName != "")
            {
            	String listString = (i+1) + ": " + tmpName + " - " + tmpScore + " richtige Anworten"; // just a little bit too static 
            	userList.add(listString);
            	i++;
                tmpName = xpath.evaluate("/scoreboard/User/User" + i + "/Name", document);
                tmpScore = xpath.evaluate("/scoreboard/User/User" + i + "/Count", document);
            }
            
            return userList;
            
            
        }catch(Exception e)
        {
            System.out.println(e);
            userList.add("None");
            return userList;
        }	
    }
    
    public static String getUserScore(int userid){
    	String score = "";
    	try
        {
            Document document;
            HandleXML parsedXMLobj = new HandleXML("http://a-o-w.lima-city.de/QuizApp/GetScore.php?userID=" + userid);
            parsedXMLobj.fetchXML();
            while(parsedXMLobj.isParsingStillRunning());
            document = parsedXMLobj.getmParsedDocument();
            
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            
            score = xpath.evaluate("/scoreboard/User/Antwort0/Count", document);         
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    	return score;
    }
}
