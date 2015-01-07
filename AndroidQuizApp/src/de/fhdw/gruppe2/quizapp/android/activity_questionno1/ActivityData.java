package de.fhdw.gruppe2.quizapp.android.activity_questionno1;

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

}
