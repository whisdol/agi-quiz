//Creator Daniel Gnech
package de.fhdw.gruppe2.quizapp.android.activity_scoreboard;

import android.content.Intent;
import de.fhdw.gruppe2.quizapp.android.constants.Constants;


public class ActivityApplicationLogic {

	private ActivityData mData;
	private ActivityGUI mGUI;

	public ActivityApplicationLogic(ActivityData mData, ActivityGUI mGUI) {
		this.mData = mData;
		this.mGUI = mGUI;
		applyDataToGUI();
	}

	private void applyDataToGUI() {
		//mGUI.getmEditText().setText(mData.getmName());
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
