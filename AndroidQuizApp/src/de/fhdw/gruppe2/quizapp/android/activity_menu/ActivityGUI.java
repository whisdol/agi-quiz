//Creator Ben Schulze
package de.fhdw.gruppe2.quizapp.android.activity_menu;

import android.widget.Button;
import de.fhdw.gruppe2.quizapp.android.R;

public class ActivityGUI {

	private Button mQuestionsButton;
	private Button mScoreboardButton;
	

	public ActivityGUI(ActivityInit act) {
		act.setContentView(R.layout.activity_menu);
		mQuestionsButton = (Button) act.findViewById(R.id.questions_button);
		mScoreboardButton = (Button) act.findViewById(R.id.scoreboard_button);
		
	}


	public Button getmQuestionsButton() {
		return mQuestionsButton;
	}



	public Button getmScoreboardButton() {
		return mScoreboardButton;
	}

	// getter to access views
	

	
}
