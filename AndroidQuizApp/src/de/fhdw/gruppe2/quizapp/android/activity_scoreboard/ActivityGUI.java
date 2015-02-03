//Creator Cedric Lüke
package de.fhdw.gruppe2.quizapp.android.activity_scoreboard;

import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import de.fhdw.gruppe2.quizapp.android.R;

public class ActivityGUI {

	private Button mBackButton;
	private ListView mScoreList;
	private TextView mUserName;
	private TextView mUserScore;
	
	public ActivityGUI(ActivityInit act) {
		act.setContentView(R.layout.activity_scoreboard);
		mBackButton = (Button) act.findViewById(R.id.button_back);
		mScoreList = (ListView) act.findViewById(R.id.listScoreboard);
		mUserName = (TextView) act.findViewById(R.id.textView_userName);
		mUserScore = (TextView) act.findViewById(R.id.textView_userScore);
	}

	// getter to access views
	public Button getmBackButton() {
		return mBackButton;
	}

	public ListView getmScoreList() {
		return mScoreList;
	}

	public TextView getmUserName() {
		return mUserName;
	}

	public TextView getmUserScore() {
		return mUserScore;
	}	
}
