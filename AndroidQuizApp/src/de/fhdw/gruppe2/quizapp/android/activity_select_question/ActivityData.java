// @author Cedric Lüke
package de.fhdw.gruppe2.quizapp.android.activity_select_question;

import android.os.Bundle;
import de.fhdw.gruppe2.quizapp.android.dbconnection.QSession;

public class ActivityData {
	
	private final String KEY_SESSION_ID = "K1";
	private final String KEY_USER_ID = "K2";
	private final String KEY_USER_NAME = "K3";
	private final String KEY_ANSWERED = "K4";
	
	private ActivityInit mActivity;
	private QSession mSession;
	private int mUserId;
	private String mUserName;
	private int mAnsweredQuestions;
	
	public ActivityData (Bundle savedInstanceState, ActivityInit act) {
		mActivity = act;
		if ( savedInstanceState == null ) {  // no data to restore
            mUserName = "";
            mUserId = -1;
            mAnsweredQuestions = 0;
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}
	
	public void saveDataInBundle(Bundle b) {
		b.putInt(KEY_USER_ID, mUserId);
		b.putString(KEY_USER_NAME, mUserName);
		b.putInt(KEY_ANSWERED, mAnsweredQuestions);
	}
	
	public void restoreDataFromBundle(Bundle b) {
		mUserId = b.getInt(KEY_SESSION_ID);
		mUserName = b.getString(KEY_USER_NAME);
		mAnsweredQuestions = b.getInt(KEY_ANSWERED);
	}
	
	// getter
	public ActivityInit getActivity() {
		return mActivity;
	}

	public int getmUserId() {
		return mUserId;
	}

	public String getmUserName() {
		return mUserName;
	}
	
	public QSession getmSession() {
		return mSession;
	}
	
	public int getmAnsweredQuestions(){
		return mAnsweredQuestions;
	}

	// setter
	public void setmUserId(int mUserId) {
		this.mUserId = mUserId;
	}

	public void setmUserName(String mUserName) {
		this.mUserName = mUserName;
	}

	public void setmSession(QSession mSession) {
		this.mSession = mSession;
	}
	
	public void incrementmAnsweredQuestions(){
		mAnsweredQuestions++;
	}
}
