// @author Alexander Frese
 
package de.fhdw.gruppe2.quizapp.android.activity_questionno2;

import android.view.View;
import android.view.View.OnClickListener;

public class ActivityEventToListenerMapping implements OnClickListener {

	private ActivityApplicationLogic mApplicationLogic;
	private ActivityGUI mGUI;
	
	public ActivityEventToListenerMapping (ActivityGUI gui, ActivityApplicationLogic appLogic) {
		this.mGUI = gui;
		this.mApplicationLogic = appLogic;
		
		mGUI.getmCheckBox0().setOnClickListener(this);
		mGUI.getmCheckBox1().setOnClickListener(this);
		mGUI.getmCheckBox2().setOnClickListener(this);
		mGUI.getmCheckBox3().setOnClickListener(this);
		mGUI.getmContinueButton().setOnClickListener(this);
		mGUI.getmExitButton().setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		if(mGUI.getmCheckBox0().getId() == v.getId())
		{
			mApplicationLogic.onCheckBox0Clicked();
		}else if(mGUI.getmCheckBox1().getId() == v.getId())
		{
			mApplicationLogic.onCheckBox1Clicked();	
		}else if(mGUI.getmCheckBox2().getId() == v.getId())
		{
			mApplicationLogic.onCheckBox2Clicked();
		}else if(mGUI.getmCheckBox3().getId() == v.getId())
		{
			mApplicationLogic.onCheckBox3Clicked();
		}else if(mGUI.getmContinueButton().getId() == v.getId())
		{
			mApplicationLogic.onContinueButtonClicked();
		}else if(mGUI.getmExitButton().getId() == v.getId())
		{
			mApplicationLogic.onExitButtonClicked();
		}
	}

	
	
	
	
}
