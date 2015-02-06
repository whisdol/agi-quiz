//Creator Ben Schulze
package de.fhdw.gruppe2.quizapp.android.activity_menu;

import de.fhdw.gruppe2.quizapp.android.R;
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
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.questions_button)
		{
			mApplicationLogic.onQuestionsButtonClicked();	
		}else if(v.getId() == R.id.scoreboard_button)
		{
			mApplicationLogic.onScoreboardButtonClicked();	
		}
	}

	
	
	
	
}
