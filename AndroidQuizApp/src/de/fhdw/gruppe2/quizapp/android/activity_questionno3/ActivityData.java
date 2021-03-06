//Author: Bastian Sold & Ben Schulze
package de.fhdw.gruppe2.quizapp.android.activity_questionno3;

import de.fhdw.gruppe2.quizapp.android.constants.Constants;
import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionDataWithPicture;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class ActivityData {
	private final String KEY_SELECTED_ANSWER = "K3_1";
	private final String KEY_QUESTION_ID = "K3_2";
	private final String KEY_ALREADY_RUNNED_TIME = "K1_3";
	
	private QuestionDataWithPicture question;
	private int mSelectedAnswer;
	private ActivityInit mActivity;
	private int mSessionID;
	private int mQuestionID;
	private CountDownTimer mTimer;
	private long mAlreadyRunnedTime;
	

	public ActivityData (Bundle savedInstanceState, ActivityInit act) {
		mSelectedAnswer = -1;
		mActivity = act;
		if ( savedInstanceState == null ) {  // no data to restore
			mAlreadyRunnedTime=0;
			Intent intent = mActivity.getIntent();
            mQuestionID = intent.getIntExtra(Constants.INTENT_QUESTION_ID, mQuestionID);
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}
	
	public void saveDataInBundle(Bundle b) {
		b.putInt(KEY_SELECTED_ANSWER, mSelectedAnswer);
		b.putInt(KEY_QUESTION_ID, mQuestionID);
		b.putLong(KEY_ALREADY_RUNNED_TIME, mAlreadyRunnedTime);
		mTimer.cancel();
	}
	
	public void restoreDataFromBundle(Bundle b) {
		mSelectedAnswer = b.getInt(KEY_SELECTED_ANSWER);
		mQuestionID = b.getInt(KEY_QUESTION_ID);
		b.putLong(KEY_ALREADY_RUNNED_TIME, mAlreadyRunnedTime);
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
	
	public int getmSelectedAnswer() {
		return mSelectedAnswer;
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
	
	public int setmSelectedAnswer(int mSelectedAnswer) {
		if(mSelectedAnswer == this.mSelectedAnswer)
		{
			this.mSelectedAnswer = -1;
		}else
		{
			this.mSelectedAnswer = mSelectedAnswer;
		}
		
		return this.mSelectedAnswer;
	}

	public QuestionDataWithPicture getmQuestion() {
		return question;
	}

	public void setQuestion(QuestionDataWithPicture question) {
		this.question = question;
	}


}
