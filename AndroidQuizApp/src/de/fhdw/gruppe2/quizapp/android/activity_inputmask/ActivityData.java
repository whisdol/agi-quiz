//Creator Daniel Gnech
package de.fhdw.gruppe2.quizapp.android.activity_inputmask;

import de.fhdw.gruppe2.quizapp.android.constants.Constants;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class ActivityData {
	
	private static final String KEY_NAME_VALUE = "K1";
	
	private String mName;
	private ActivityInit mActivity;

	public ActivityData (Bundle savedInstanceState, ActivityInit act) {
		mActivity = act;
		if ( savedInstanceState == null ) {  // no data to restore
			getNameFromPref();			
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}
	
	// save and restore
	
	public void saveDataInBundle(Bundle b) {
		b.putString(KEY_NAME_VALUE, mName);
	}
	
	public void restoreDataFromBundle(Bundle b) {
		mName = b.getString(KEY_NAME_VALUE);
	}
	
	public void saveNameToPref(){
		SharedPreferences sharedPref = getActivity().getSharedPreferences(Constants.SHAREDPREF_ID, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPref.edit();
		editor.putString(Constants.SHAREDPREF_USER_NAME, mName);
		editor.commit();
	}
	
	public void getNameFromPref(){
		SharedPreferences prefs = mActivity.getSharedPreferences(
			      Constants.SHAREDPREF_ID, 0);
		mName = prefs.getString(Constants.SHAREDPREF_USER_NAME, "");
	}
	
	// getter
	
	public ActivityInit getActivity() {
		return mActivity;
	}

	public String getmName() {
		return mName;
	}
	
	// setter
	
	public void setmName(String mName) {
		this.mName = mName;
	}
}
