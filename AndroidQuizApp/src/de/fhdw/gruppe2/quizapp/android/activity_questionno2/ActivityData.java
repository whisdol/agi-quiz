/**
 * Creator: Alexander Frese
 */
package de.fhdw.gruppe2.quizapp.android.activity_questionno2;

import android.os.Bundle;

public class ActivityData {
	private boolean[] mSelectedAnswer;
	private ActivityInit mActivity;
	private int mSessionID;
	private int mQuestionID;

	public ActivityData (Bundle savedInstanceState, ActivityInit act) {
		mSelectedAnswer = new boolean[4];
		mActivity = act;
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

	//setter
	public void setmSessionID(int mSessionID) {
		this.mSessionID = mSessionID;
	}


	public void setmQuestionID(int mQuestionID) {
		this.mQuestionID = mQuestionID;
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
