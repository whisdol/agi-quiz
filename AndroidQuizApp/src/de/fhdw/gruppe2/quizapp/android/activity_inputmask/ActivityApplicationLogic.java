package de.fhdw.gruppe2.quizapp.android.activity_inputmask;

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
		
	}
	
	
	
	// event handling
	
	public void onConfirmButtonClicked() {
		Intent intent;
		intent = new Intent();
		intent.setClass(mData.getActivity(), Constants.ACTIVITYMENUCLASS);
		mData.getActivity().startActivityForResult(intent, Constants.REQUESTCODEVALUE);
		
	}

	public void onEditTextChanged() {
		// TODO Auto-generated method stub
		
	}
	


}
