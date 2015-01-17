/**
 * Creator: Alexander Frese
 */
package de.fhdw.gruppe2.quizapp.android.activity_questionno2;

import android.os.Bundle;

public class ActivityData {
	private boolean[] mSelectedAnswer;
	private ActivityInit mActivity;

	public ActivityData (Bundle savedInstanceState, ActivityInit act) {
		mSelectedAnswer = new boolean[4];
		mActivity = act;
	}
	
	// getter
	
	public ActivityInit getActivity() {
		return mActivity;
	}
	
	public boolean[] getmSelectedAnswer() {
		return mSelectedAnswer;
	}

	//setter
	
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
