package de.fhdw.gruppe2.quizapp.android.activity_menu;

import android.widget.Button;
import de.fhdw.gruppe2.quizapp.android.R;

public class ActivityGUI {

	private Button mQuestionsButton;
	private Button mStatisticsButton;
	private Button mScoreboardButton;
	

	public ActivityGUI(ActivityInit act) {
		act.setContentView(R.layout.activity_inputmask);
		mQuestionsButton = (Button) act.findViewById(R.id.questions_button);
		mStatisticsButton = (Button) act.findViewById(R.id.statistics_button);
		mScoreboardButton = (Button) act.findViewById(R.id.scoreboard_button);
		
	}


	public Button getmQuestionsButton() {
		return mQuestionsButton;
	}


	public Button getmStatisticsButton() {
		return mStatisticsButton;
	}


	public Button getmScoreboardButton() {
		return mScoreboardButton;
	}

	// getter to access views
	

	
}
