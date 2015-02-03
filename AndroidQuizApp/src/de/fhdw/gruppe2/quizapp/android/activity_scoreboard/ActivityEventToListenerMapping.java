//Creator Cedric Lüke
package de.fhdw.gruppe2.quizapp.android.activity_scoreboard;

import android.view.View;
import android.view.View.OnClickListener;

public class ActivityEventToListenerMapping implements OnClickListener {

	private ActivityApplicationLogic mApplicationLogic;
	private ActivityGUI mGUI;
	
	public ActivityEventToListenerMapping (ActivityGUI gui, ActivityApplicationLogic appLogic) {
		this.mGUI = gui;
		this.mApplicationLogic = appLogic;
		mGUI.getmBackButton().setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		mApplicationLogic.onBackButtonClicked();	
	}
}
