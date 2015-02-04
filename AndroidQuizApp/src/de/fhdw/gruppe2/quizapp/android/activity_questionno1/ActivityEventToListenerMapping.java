//Author: Daniel Gnech
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(mGUI.getmAnswerButton0().getId() == v.getId())
		{
			mApplicationLogic.onAnswer0ButtonClicked();
		}else if(mGUI.getmAnswerButton1().getId() == v.getId())
		{
			mApplicationLogic.onAnswer1ButtonClicked();	
		}else if(mGUI.getmAnswerButton2().getId() == v.getId())
		{
			mApplicationLogic.onAnswer2ButtonClicked();
		}else if(mGUI.getmAnswerButton3().getId() == v.getId())
		{
			mApplicationLogic.onAnswer3ButtonClicked();
		}else if(mGUI.getmContinueButton().getId() == v.getId())
		{
			mApplicationLogic.onContinueButtonClicked();
		}else if(mGUI.getmExitButton().getId() == v.getId())
		{
			mApplicationLogic.onExitButtonClicked();
		}
	}

	
	
	
	
}
