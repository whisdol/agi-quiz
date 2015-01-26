// @author Cedric Lüke
package de.fhdw.gruppe2.quizapp.android.activity_select_question;

import de.fhdw.gruppe2.quizapp.android.constants.Constants;
import de.fhdw.gruppe2.quizapp.android.dbconnection.DatabaseConnection;
import android.app.Activity;
import android.content.Intent;



public class ActivityApplicationLogic {

	private ActivityData mData;

	public ActivityApplicationLogic(ActivityData mData) {
		this.mData = mData;
		getSession();
		// Call first Question
		// startQuestionActivity(mData.getmQuestions()[0][0], mData.getmQuestions()[0][1]);
		
	}
	
    public void startQuestionActivity(int pNextQuestionId, int pNextQuestionType){
        Intent intent;
        intent = new Intent();
        intent.setClass(mData.getActivity(), getClassForQuestionType(pNextQuestionType));
        intent.putExtra(Constants.INTENT_QUESTION_ID, pNextQuestionId);
        mData.getActivity().startActivityForResult(intent, Constants.INTENT_PARAMETER_START_QUESTION_ACTIVITY);
    }

    public void processActivityReturnValues(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK){
            switch (requestCode){
                case Constants.INTENT_PARAMETER_START_QUESTION_ACTIVITY:
                	// TODO: Implement behavior after answering first question
                	boolean correctlyAnswered = data.getExtras().getBoolean(Constants.INTENT_ANSWER_CORRECT);
                	boolean cont = data.getExtras().getBoolean(Constants.INTENT_ANSWER_CONTINUE);
                	// Save Result (Question answered correctly, not correctly) in the db
                	// DatabaseConnection.updateSessionFrage(pSessionID, pFragenID, pRichtig, pAntwort);
                
                	if (cont /* && noch nicht alle Fragen aus der Session gefragt */){
                		// Call startQuestionActivity() with next QuestionId
                	} else {
                		// exit
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
    	//case 5:
    	//	return Constants.ACTIVITY_QUESTION_NO5_CLASS;
    	}
    }
    
	private void getSession(){
		// TODO: Implement getSession
		// Call DatabaseConnection.getSession()
		// Save QuestionIDs with QuestionType in mQuestions (in mData)
		
	}

}
