// @author Cedric Lüke
package de.fhdw.gruppe2.quizapp.android.activity_questionno5;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActivityEventToListenerMapping implements OnClickListener {

	private ActivityApplicationLogic mApplicationLogic;
	private ActivityGUI mGUI;
	
	public ActivityEventToListenerMapping (ActivityGUI gui, ActivityApplicationLogic appLogic) {
		this.mGUI = gui;
		this.mApplicationLogic = appLogic;
		
		mGUI.getmContinueButton().setOnClickListener(this);
		mGUI.getmExitButton().setOnClickListener(this);
		for(Button  b: mGUI.getmAnswerButton())
		{
			b.setOnClickListener(this);
		}
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (mGUI.getmContinueButton().getId() == v.getId())
		{
			mApplicationLogic.onContinueButtonClicked();
		}else if (mGUI.getmExitButton().getId() == v.getId())
		{
			mApplicationLogic.onExitButtonClicked();
		}else
		{
			for(int i=0;i<4;i++)
			{
				if(mGUI.getmAnswerButton()[i].getId() == v.getId())
				{
					mApplicationLogic.onClickAnswerButtonClick(i);
				}
			}
		}
	}

}
