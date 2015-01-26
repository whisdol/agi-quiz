// @author Cedric Lüke
package de.fhdw.gruppe2.quizapp.android.activity_select_question;

import de.fhdw.gruppe2.quizapp.android.dbconnection.DatabaseConnection;
import android.os.Bundle;

public class ActivityData {
	
	private final String KEY_SESSION_ID = "K1";
	private final String KEY_USER_ID = "K2";
	private final String KEY_USER_NAME = "K3";
	
	private ActivityInit mActivity;
	private int mSessionId;
	private int mUserId;
	private String mUserName;
	private int currentQuestionCounter;
	private int[][] mQuestions;
	// mQuestions[0][0] -> Question1 id
	// mQuestions[0][1] -> Question1 type
	// mQuestions[1][0] -> Question2 id
	// mQuestions[1][1] -> Question2 type	
	

	public ActivityData (Bundle savedInstanceState, ActivityInit act) {
		mActivity = act;
		if ( savedInstanceState == null ) {  // no data to restore
            mSessionId = -1;
            mUserName = ""; // get User name. prerequisite: Save Username in other activity in a shared_pref file
            mUserId = DatabaseConnection.getUser(mUserName);
            setmQuestions(new int[2][2]); // 2 Question/Session? -> Kim
            currentQuestionCounter = 0;
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}
	
	public void saveDataInBundle(Bundle b) {
		b.putInt(KEY_SESSION_ID, mSessionId);
		b.putInt(KEY_USER_ID, mUserId);
		b.putString(KEY_USER_NAME, mUserName);
	}
	
	public void restoreDataFromBundle(Bundle b) {
		mSessionId = b.getInt(KEY_SESSION_ID);
		mUserId = b.getInt(KEY_SESSION_ID);
		mUserName = b.getString(KEY_USER_NAME);
	}
	
	// getter
	
	public ActivityInit getActivity() {
		return mActivity;
	}

	protected int getmSessionId() {
		return mSessionId;
	}
	
	public int[][] getmQuestions() {
		return mQuestions;
	}

	// setter
	protected void setmSessionId(int mSessionId) {
		this.mSessionId = mSessionId;
	}

	public void setmQuestions(int[][] mQuestions) {
		this.mQuestions = mQuestions;
	}





}
