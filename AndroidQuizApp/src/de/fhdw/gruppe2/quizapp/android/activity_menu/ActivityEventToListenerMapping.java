package de.fhdw.gruppe2.quizapp.android.activity_menu;

import android.view.View;
import android.view.View.OnClickListener;

public class ActivityEventToListenerMapping implements OnClickListener {

	private ActivityApplicationLogic mApplicationLogic;
	private ActivityGUI mGUI;
	
	public ActivityEventToListenerMapping (ActivityGUI gui, ActivityApplicationLogic appLogic) {
		this.mGUI = gui;
		this.mApplicationLogic = appLogic;
		
		mGUI.getmQuestionsButton().setOnClickListener(this);
		mGUI.getmScoreboardButton().setOnClickListener(this);
		mGUI.getmStatisticsButton().setOnClickListener(this);
	}

	
	public void onClickQuestion(View v) {
		mApplicationLogic.onQuestionsButtonClicked();	
	}
	
	
	public void onClickStatistics(View v) {
		mApplicationLogic.onStatisticsButtonClicked();	
	}
	
	
	public void onClickScoreboard(View v) {
		mApplicationLogic.onScoreboardButtonClicked();	
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
