package de.fhdw.gruppe2.quizapp.android.activity_inputmask;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import de.fhdw.gruppe2.quizapp.android.constants.Constants;
import de.fhdw.gruppe2.quizapp.android.R;

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
		
		
	}

	public void onEditTextChanged() {
		// TODO Auto-generated method stub
		
	}
	


}
