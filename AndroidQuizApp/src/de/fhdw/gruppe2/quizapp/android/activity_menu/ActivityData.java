//Creator Ben Schulze
package de.fhdw.gruppe2.quizapp.android.activity_menu;

import android.os.Bundle;

public class ActivityData {
	
	private ActivityInit mActivity;

	public ActivityData (Bundle savedInstanceState, ActivityInit act) {
		mActivity = act;
	}
	
	// getter
	
	public ActivityInit getActivity() {
		return mActivity;
	}

}
