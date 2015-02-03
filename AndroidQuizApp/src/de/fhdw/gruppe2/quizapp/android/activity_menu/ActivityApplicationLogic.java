package de.fhdw.gruppe2.quizapp.android.activity_menu;

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
	
	public void onQuestionsButtonClicked() {
	        Intent intent;
	        intent = new Intent();
	        intent.setClass(mData.getActivity(), Constants.ACTIVITY_QUESTION_ACTIVITY_SELECT_QUESTION);
	        mData.getActivity().startActivity(intent );	
	}
	
	public void onStatisticsButtonClicked() {
		
		
	}

	public void onScoreboardButtonClicked() {
        Intent intent;
        intent = new Intent();
        intent.setClass(mData.getActivity(), Constants.ACTIVITY_QUESTION_ACTIVITY_SCOREBOARD);
        mData.getActivity().startActivity(intent);	
	}

	


}
