//Creator Cedric Lüke
package de.fhdw.gruppe2.quizapp.android.activity_scoreboard;

import android.content.Intent;
import android.widget.ArrayAdapter;
import de.fhdw.gruppe2.quizapp.android.R;
import de.fhdw.gruppe2.quizapp.android.constants.Constants;


public class ActivityApplicationLogic {

	private ActivityData mData;
	private ActivityGUI mGUI;

	public ActivityApplicationLogic(ActivityData mData, ActivityGUI mGUI) {
		this.mData = mData;
		this.mGUI = mGUI;
		setUpLayout();
	}


	private void setUpLayout(){
		mGUI.getmUserName().setText(mData.getmName());
		mGUI.getmUserScore().setText(mData.getmScore());
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(mData.getActivity(), R.layout.scoreboard_item, mData.getmRanking());
		mGUI.getmScoreList().setAdapter(listAdapter);
	}
	
	// event handling
	public void onBackButtonClicked() {
		Intent intent;
		intent = new Intent();
		intent.setClass(mData.getActivity(), Constants.ACTIVITYMENUCLASS);
		mData.getActivity().startActivity(intent);
	}

}
