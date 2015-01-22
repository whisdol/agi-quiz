package de.fhdw.gruppe2.quizapp.android.activity_questionno3;

import android.os.Bundle;

public class ActivityData {
	private int mSelectedAnswer;

	private ActivityInit mActivity;

	public ActivityData (Bundle savedInstanceState, ActivityInit act) {
		mSelectedAnswer = -1;
		mActivity = act;
	}
	
	// getter
	
	public ActivityInit getActivity() {
		return mActivity;
	}
	
	public int getmSelectedAnswer() {
		return mSelectedAnswer;
	}

	//setter
	
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


}
