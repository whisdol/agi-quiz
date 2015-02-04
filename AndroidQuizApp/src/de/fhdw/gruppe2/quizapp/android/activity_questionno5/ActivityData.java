// @author Kim Gerstein
package de.fhdw.gruppe2.quizapp.android.activity_questionno5;

import android.content.Intent;
import android.os.Bundle;
import de.fhdw.gruppe2.quizapp.android.constants.Constants;
import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionDataOrder;

public class ActivityData {
	
	private final String KEY_SEEKBAR_VALUE = "K5_1";
	private final String KEY_QUESTION_ID = "K5_2";
	
	private int[] mSelectedValue;
	private int mSessionID;
	private int mQuestionId;
	private QuestionDataOrder mQuestion;
	private ActivityInit mActivity;

	public ActivityData (Bundle savedInstanceState, ActivityInit act) {
		mActivity = act;
		if ( savedInstanceState == null ) {  // no data to restore
			mSelectedValue = new int[4];
			for(int i = 0; i<mSelectedValue.length;i++)
				mSelectedValue[i] = 5;
            Intent intent = mActivity.getIntent();
            mQuestionId = intent.getIntExtra(Constants.INTENT_QUESTION_ID, mQuestionId);
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}
	
	public void saveDataInBundle(Bundle b) {
		b.putIntArray(KEY_SEEKBAR_VALUE, mSelectedValue);
		b.putInt(KEY_QUESTION_ID, mQuestionId);
	}
	
	public void restoreDataFromBundle(Bundle b) {
		mSelectedValue = b.getIntArray(KEY_SEEKBAR_VALUE);
		mQuestionId = b.getInt(KEY_QUESTION_ID);
	}
	
	// getter
	public ActivityInit getActivity() {
		return mActivity;
	}

	public int[] getmSelectedValue() {
		return mSelectedValue;
	}

	public QuestionDataOrder getmQuestion() {
		return mQuestion;
	}
	
	public int getmQuestionId() {
		return mQuestionId;
	}
	
	public int getmSessionID() {
		return mSessionID;
	}

	//setter
	public void setmQuestion(QuestionDataOrder mQuestion) {
		this.mQuestion = mQuestion;
	}	
	public void setmSessionID(int mSessionID) {
		this.mSessionID = mSessionID;
	}
	
	public void setmSelectedValue(int pSelectedValue, int pPosition)
	{
		mSelectedValue[pPosition] = pSelectedValue;
	}

}
