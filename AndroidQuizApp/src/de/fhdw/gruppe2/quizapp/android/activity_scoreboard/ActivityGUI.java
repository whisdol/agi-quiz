//Creator Daniel Gnech
package de.fhdw.gruppe2.quizapp.android.activity_scoreboard;

import android.widget.Button;
import android.widget.EditText;
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
		
	}

	// getter to access views
	

	
}
