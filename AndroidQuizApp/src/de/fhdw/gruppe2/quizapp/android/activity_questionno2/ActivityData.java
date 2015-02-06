// @author Alexander Frese
 
package de.fhdw.gruppe2.quizapp.android.activity_questionno2;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import de.fhdw.gruppe2.quizapp.android.constants.Constants;
import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionDataMultipleAnswer;


public class ActivityData {
	private final String KEY_SELECTED_ANSWERS = "K2_1";
	private final String KEY_QUESTION_ID = "K2_2";
	private final String KEY_ALREADY_RUNNED_TIME = "K1_3";
	
	private boolean[] mSelectedAnswer;
	private ActivityInit mActivity;
	private int mSessionID;
	private int mQuestionID;
	private CountDownTimer mTimer;
	private QuestionDataMultipleAnswer mQuestion;
	private long mAlreadyRunnedTime;



	public ActivityData (Bundle savedInstanceState, ActivityInit act) {
		mActivity = act;
		// new instance
		if ( savedInstanceState == null ) {  
			mSelectedAnswer = new boolean[4];
			mAlreadyRunnedTime=0;
            Intent intent = mActivity.getIntent();
            mQuestionID = intent.getIntExtra(Constants.INTENT_QUESTION_ID, mQuestionID);
		}
		// restore bundle
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}
	
	// bundle methods
	public void saveDataInBundle(Bundle b) {
		b.putBooleanArray(KEY_SELECTED_ANSWERS, mSelectedAnswer);
		b.putInt(KEY_QUESTION_ID, mQuestionID);
		b.putLong(KEY_ALREADY_RUNNED_TIME, mAlreadyRunnedTime);
		mTimer.cancel();
	}
	
	public void restoreDataFromBundle(Bundle b) {
		mSelectedAnswer = b.getBooleanArray(KEY_SELECTED_ANSWERS);
		mQuestionID = b.getInt(KEY_QUESTION_ID);
		mAlreadyRunnedTime = b.getLong(KEY_ALREADY_RUNNED_TIME);
	}
	
	// getter
	public int getmSessionID() {
		return mSessionID;
	}
	public int getmQuestionID() {
		return mQuestionID;
	}
	
	public ActivityInit getActivity() {
		return mActivity;
	}
	
	public boolean[] getmSelectedAnswer() {
		return mSelectedAnswer;
	}
	
	public QuestionDataMultipleAnswer getmQuestion() {
		return mQuestion;
	}
	public CountDownTimer getmTimer() {
		return mTimer;
	}
	public long getmAlreadyRunnedTime() {
		return mAlreadyRunnedTime;
	}


	//setter
	public void setmAlreadyRunnedTime(long mAlreadyRunnedTime) {
		this.mAlreadyRunnedTime = mAlreadyRunnedTime;
	}
	public void setmTimer(CountDownTimer timer) {
		this.mTimer = timer;
	}
	
	public void setmSessionID(int mSessionID) {
		this.mSessionID = mSessionID;
	}


	public void setmQuestionID(int mQuestionID) {
		this.mQuestionID = mQuestionID;
	}
	
	//setter
	public void setmQuestion(QuestionDataMultipleAnswer mQuestion) {
		this.mQuestion = mQuestion;
	}	

	
	public void setmSelectedAnswer(boolean mCheckBoxValue, int mCheckBoxNumber) {
		if(mCheckBoxNumber == 0)
		{
			this.mSelectedAnswer[0] = mCheckBoxValue;
		}
		else if (mCheckBoxNumber == 1)
		{
			this.mSelectedAnswer[1] = mCheckBoxValue;
		}
		else if (mCheckBoxNumber == 2)
		{
			this.mSelectedAnswer[2] = mCheckBoxValue;
		}
		else if (mCheckBoxNumber == 3)
		{
			this.mSelectedAnswer[3] = mCheckBoxValue;
		}
		
		
	}


}
