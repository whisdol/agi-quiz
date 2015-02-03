//Creator Daniel Gnech
package de.fhdw.gruppe2.quizapp.android.activity_scoreboard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.ArrayAdapter;
import de.fhdw.gruppe2.quizapp.android.R;
import de.fhdw.gruppe2.quizapp.android.constants.Constants;
import de.fhdw.gruppe2.quizapp.android.dbconnection.DatabaseConnection;


public class ActivityApplicationLogic {

	private ActivityData mData;
	private ActivityGUI mGUI;

	public ActivityApplicationLogic(ActivityData mData, ActivityGUI mGUI) {
		this.mData = mData;
		this.mGUI = mGUI;
		getData();
		applyDataToGUI();
	}

	private void applyDataToGUI() {
		//mGUI.getmEditText().setText(mData.getmName());
	}
	
	private void setUpLayout(){
		mGUI.getmUserName().setText(mData.getmName());
		mGUI.getmUserScore().setText(mData.getmScore());
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(mData.getActivity(), R.layout.scoreboard_item, mData.getmRanking());
		mGUI.getmScoreList().setAdapter(listAdapter);
	}
	
	private void getData(){
		SharedPreferences prefs = mData.getActivity().getSharedPreferences(
			      Constants.SHAREDPREF_ID, 0);
		mData.setmName(prefs.getString(Constants.SHAREDPREF_USER_NAME, "Gatil"));
		int uid = DatabaseConnection.getUser(mData.getmName());
		mData.setmScore(DatabaseConnection.getUserScore(uid));
		mData.setmRanking(DatabaseConnection.getScoreBoard());
	}
	
	// event handling
	public void onConfirmButtonClicked() {
		mData.saveNameToPref();
		Intent intent;
		intent = new Intent();
		intent.setClass(mData.getActivity(), Constants.ACTIVITYMENUCLASS);
		mData.getActivity().startActivityForResult(intent, Constants.REQUESTCODEVALUE);
	}

	public void onEditTextChanged() {
		String name;
		//name = mGUI.getmEditText().getText().toString().trim();
        //mData.setmName(name);
	}
}
