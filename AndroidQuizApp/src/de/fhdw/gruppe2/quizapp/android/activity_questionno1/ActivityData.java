//Author: Daniel Gnech & Ben Schulze
package de.fhdw.gruppe2.quizapp.android.activity_questionno1;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import de.fhdw.gruppe2.quizapp.android.constants.Constants;
import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionDataSingleAnswer;

public class ActivityData {
	
	private final String KEY_SELECTED_ANSWER = "K1_1";
	private final String KEY_QUESTION_ID = "K1_2";
	private final String KEY_ALREADY_RUNNED_TIME = "K1_3";
	
	private int mSelectedAnswer;

	private ActivityInit mActivity;
	private int mSessionID;
	private int mQuestionID;
	private CountDownTimer mTimer;
	private QuestionDataSingleAnswer mQuestion;
	private long mAlreadyRunnedTime;

	public ActivityData (Bundle savedInstanceState, ActivityInit act) {
		mActivity = act;
		if ( savedInstanceState == null ) {  // no data to restore
			mSelectedAnswer = -1;
			mAlreadyRunnedTime=0;
            Intent intent = mActivity.getIntent();
            mQuestionID = intent.getIntExtra(Constants.INTENT_QUESTION_ID, mQuestionID);
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}
	
	public void saveDataInBundle(Bundle b) {
		System.out.println("Data before save: " + mSelectedAnswer + " & " + mQuestionID+ " & "+ mAlreadyRunnedTime);
		b.putInt(KEY_SELECTED_ANSWER, mSelectedAnswer);
		b.putInt(KEY_QUESTION_ID, mQuestionID);
		b.putLong(KEY_ALREADY_RUNNED_TIME, mAlreadyRunnedTime);
		mTimer.cancel();
	}
	
	public void restoreDataFromBundle(Bundle b) {
		System.out.println("Data before restore: " + mSelectedAnswer + " & " + mQuestionID + " & " + mAlreadyRunnedTime);
		mSelectedAnswer = b.getInt(KEY_SELECTED_ANSWER);
		mQuestionID = b.getInt(KEY_QUESTION_ID);
		mAlreadyRunnedTime = b.getLong(KEY_ALREADY_RUNNED_TIME);
		System.out.println("Data after restore: " + mSelectedAnswer + " & " + mQuestionID + " & " + mAlreadyRunnedTime);	
	}
	
	// getter
	
	public int getmQuestionID() {
		return mQuestionID;
	}
	public int getmSessionID() {
		return mSessionID;
	}
	
	public ActivityInit getActivity() {
		return mActivity;
	}
	
	public int getmSelectedAnswer() {
		return mSelectedAnswer;
	}
	
	public QuestionDataSingleAnswer getmQuestion() {
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

	public void setmTimer(CountDownTimer pTimer) {
		this.mTimer = pTimer;
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


	public void setmQuestion(QuestionDataSingleAnswer mQuestion) {
		this.mQuestion = mQuestion;
	}


}
