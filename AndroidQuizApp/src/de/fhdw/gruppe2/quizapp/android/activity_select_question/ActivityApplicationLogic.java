// @author Cedric Lüke
package de.fhdw.gruppe2.quizapp.android.activity_select_question;

import de.fhdw.gruppe2.quizapp.android.constants.Constants;
import de.fhdw.gruppe2.quizapp.android.dbconnection.DatabaseConnection;
import de.fhdw.gruppe2.quizapp.android.dbconnection.QSession;
import de.fhdw.gruppe2.quizapp.android.dbconnection.QSessionQuestion;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;



public class ActivityApplicationLogic {

	private ActivityData mData;


	public ActivityApplicationLogic(ActivityData mData) {
		this.mData = mData;
		setUserDetails();
		getSession();
		removeAnsweredQuestions();
		startQuestionActivity(mData.getmSession().getAndRemoveQuestion());
		
	}
	
	public void removeAnsweredQuestions(){
		for (int i = 0; i<mData.getmAnsweredQuestions(); i++){
			mData.getmSession().getAndRemoveQuestion();
		}
	}
	
    public void startQuestionActivity(QSessionQuestion pQuestion){
        Intent intent;
        intent = new Intent();
        intent.setClass(mData.getActivity(), getClassForQuestionType(pQuestion.getmQuestionType()));
        intent.putExtra(Constants.INTENT_QUESTION_ID, pQuestion.getmQuestionID());
        mData.getActivity().startActivityForResult(intent, Constants.INTENT_PARAMETER_START_QUESTION_ACTIVITY);
    }

    public void processActivityReturnValues(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK){
            switch (requestCode){
                case Constants.INTENT_PARAMETER_START_QUESTION_ACTIVITY:
                	boolean correctlyAnswered = data.getExtras().getBoolean(Constants.INTENT_ANSWER_CORRECT);
                	boolean cont = data.getExtras().getBoolean(Constants.INTENT_ANSWER_CONTINUE);
                	String answer = data.getExtras().getString(Constants.INTENT_ANSWER);
                	int qid = data.getExtras().getInt(Constants.INTENT_ANSWER_QID);
                	
                	// TODO: Save Result (Question answered correctly, not correctly) in the db
                	DatabaseConnection.updateSessionFrage(mData.getmSession().getmSessionID(), qid, (correctlyAnswered) ? 1:-1, answer);
                	
                	QSessionQuestion nextQuestion = mData.getmSession().getAndRemoveQuestion();
                
                	if (cont && nextQuestion != null){
                		startQuestionActivity(nextQuestion);
                	} else {
                		Intent intent;
                        intent = new Intent();
                        intent.setClass(mData.getActivity(), Constants.ACTIVITY_MENU_CLASS);
                        mData.getActivity().startActivity(intent);
                		
                	}
                    break;
            }
        }

    }
	
    // helpers
    
    private Class<?> getClassForQuestionType(int questionType){
    	switch(questionType){
    	default:
    	case 1:
    		return Constants.ACTIVITY_QUESTION_NO1_CLASS;
    	case 2:
    		return Constants.ACTIVITY_QUESTION_NO2_CLASS;
    	case 3:
    		return Constants.ACTIVITY_QUESTION_NO3_CLASS;
    	case 4:
    		return Constants.ACTIVITY_QUESTION_NO4_CLASS;
    	case 5:
    		return Constants.ACTIVITY_QUESTION_NO5_CLASS;
    	}
    }
    
    private void setUserDetails(){
		String username;
		SharedPreferences prefs = mData.getActivity().getSharedPreferences(
			      Constants.SHAREDPREF_ID, Context.MODE_PRIVATE);
		username = prefs.getString(Constants.SHAREDPREF_USER_NAME, "Gatil");
		mData.setmUserName(username);
		if(username != ""){
			mData.setmUserId(DatabaseConnection.getUser(username));
		}
	}
    
	private void getSession(){
		QSession session = DatabaseConnection.getSession(mData.getmUserId());
		mData.setmSession(session);
	}
}
