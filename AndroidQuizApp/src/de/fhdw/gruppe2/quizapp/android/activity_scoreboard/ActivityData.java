//Creator Cedric Lüke
package de.fhdw.gruppe2.quizapp.android.activity_scoreboard;

import java.util.ArrayList;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import de.fhdw.gruppe2.quizapp.android.constants.Constants;
import de.fhdw.gruppe2.quizapp.android.dbconnection.DatabaseConnection;

public class ActivityData {
	
	private static final String KEY_NAME_VALUE = "K1";
	private static final String KEY_SCORE_VALUE = "K2";
	private static final String KEY_RANKING_VALUE = "K3";
	
	private String mName;
	private String mScore;
	private ArrayList<String> mRanking;
	private ActivityInit mActivity;

	public ActivityData (Bundle savedInstanceState, ActivityInit act) {
		mActivity = act;
		if ( savedInstanceState == null ) {  // no data to restore
			getData();			
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}
	
	// save and restore
	
	public void saveDataInBundle(Bundle b) {
		b.putString(KEY_NAME_VALUE, mName);
		b.putString(KEY_SCORE_VALUE, mScore);
		b.putStringArrayList(KEY_RANKING_VALUE, mRanking);
	}
	
	public void restoreDataFromBundle(Bundle b) {
		mName = b.getString(KEY_NAME_VALUE);
		mScore = b.getString(KEY_SCORE_VALUE);
		mRanking = b.getStringArrayList(KEY_RANKING_VALUE);
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
	
	private void getData(){
		SharedPreferences prefs = getActivity().getSharedPreferences(
			      Constants.SHAREDPREF_ID, 0);
		setmName(prefs.getString(Constants.SHAREDPREF_USER_NAME, "Gatil"));
		int uid = DatabaseConnection.getUser(getmName());
		setmScore(DatabaseConnection.getUserScore(uid));
		setmRanking(DatabaseConnection.getScoreBoard());
	}
	
	
	// getter
	
	public ActivityInit getActivity() {
		return mActivity;
	}

	public String getmName() {
		return mName;
	}
	
	public String getmScore() {
		return mScore;
	}

	public ArrayList<String> getmRanking() {
		return mRanking;
	}

	
	// setter
	
	public void setmName(String mName) {
		this.mName = mName;
	}

	public void setmScore(String mScore) {
		this.mScore = mScore;
	}

	public void setmRanking(ArrayList<String> mRanking) {
		this.mRanking = mRanking;
	}
}
