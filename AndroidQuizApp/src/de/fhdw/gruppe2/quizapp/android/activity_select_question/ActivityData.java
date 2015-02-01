// @author Cedric Lüke
package de.fhdw.gruppe2.quizapp.android.activity_select_question;

import de.fhdw.gruppe2.quizapp.android.dbconnection.DatabaseConnection;
import de.fhdw.gruppe2.quizapp.android.dbconnection.QSession;
import android.os.Bundle;

public class ActivityData {
	
	private final String KEY_SESSION_ID = "K1";
	private final String KEY_USER_ID = "K2";
	private final String KEY_USER_NAME = "K3";
	
	private ActivityInit mActivity;
	private QSession mSession;
	private int mUserId;
	private String mUserName;
	
	public ActivityData (Bundle savedInstanceState, ActivityInit act) {
		mActivity = act;
		if ( savedInstanceState == null ) {  // no data to restore
            mUserName = "";
            mUserId = -1;
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}
	
	public void saveDataInBundle(Bundle b) {
		b.putInt(KEY_USER_ID, mUserId);
		b.putString(KEY_USER_NAME, mUserName);
	}
	
	public void restoreDataFromBundle(Bundle b) {
		mUserId = b.getInt(KEY_SESSION_ID);
		mUserName = b.getString(KEY_USER_NAME);
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
}
