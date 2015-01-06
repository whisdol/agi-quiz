package de.fhdw.gruppe2.quizapp.android.activity_menu;

import android.content.Intent;
import android.os.Bundle;
import de.fhdw.gruppe2.quizapp.android.constants.Constants;

public class ActivityData {
	
	private static final String KEYCOUNTERVALUE = "K1";
	
	private int mCounter;
	private ActivityInit mActivity;

	public ActivityData (Bundle savedInstanceState, ActivityInit act) {
		Intent intent;
		mActivity = act;
		if ( savedInstanceState == null ) {  // no data to restore
			mCounter = 0;   // use default
			intent = act.getIntent();
			mCounter = intent.getIntExtra(Constants.PARAMETERKEYCOUNTERVALUE, mCounter);			
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}
	
	// save and restore
	
	public void saveDataInBundle(Bundle b) {
		b.putInt(KEYCOUNTERVALUE, mCounter);
		
	}
	
	public void restoreDataFromBundle(Bundle b) {
		mCounter = b.getInt(KEYCOUNTERVALUE);
		
	}
	
	// getter
	
	public ActivityInit getActivity() {
		return mActivity;
	}

}
