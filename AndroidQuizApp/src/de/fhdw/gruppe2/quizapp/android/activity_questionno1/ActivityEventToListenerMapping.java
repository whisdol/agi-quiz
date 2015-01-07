package de.fhdw.gruppe2.quizapp.android.activity_questionno1;

import android.view.View;
import android.view.View.OnClickListener;

public class ActivityEventToListenerMapping implements OnClickListener {

	private ActivityApplicationLogic mApplicationLogic;
	private ActivityGUI mGUI;
	
	public ActivityEventToListenerMapping (ActivityGUI gui, ActivityApplicationLogic appLogic) {
		this.mGUI = gui;
		this.mApplicationLogic = appLogic;
		
		mGUI.getmAnswerButton0().setOnClickListener(this);
		mGUI.getmAnswerButton1().setOnClickListener(this);
		mGUI.getmAnswerButton2().setOnClickListener(this);
		mGUI.getmAnswerButton3().setOnClickListener(this);
		mGUI.getmContinueButton().setOnClickListener(this);
		mGUI.getmExitButton().setOnClickListener(this);
		
	}

	
	public void onClickAnswer0(View v) {
		mApplicationLogic.onAnswer0ButtonClicked();	
	}
	
	public void onClickAnswer1(View v) {
		mApplicationLogic.onAnswer1ButtonClicked();	
	}
	
	public void onClickAnswer2(View v) {
		mApplicationLogic.onAnswer2ButtonClicked();	
	}
	
	public void onClickAnswer3(View v) {
		mApplicationLogic.onAnswer3ButtonClicked();	
	}
	
	public void onClickContinue(View v) {
		mApplicationLogic.onContinueButtonClicked();	
	}
	
	public void onClickExit(View v) {
		mApplicationLogic.onExitButtonClicked();	
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
