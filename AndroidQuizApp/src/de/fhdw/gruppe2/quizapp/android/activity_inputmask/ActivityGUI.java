package de.fhdw.gruppe2.quizapp.android.activity_inputmask;

import android.widget.Button;
import de.fhdw.gruppe2.quizapp.android.R;

public class ActivityGUI {

	private Button mConfirmButton;

	public ActivityGUI(ActivityInit act) {
		act.setContentView(R.layout.activity_inputmask);
		mConfirmButton = (Button) act.findViewById(R.id.inputmask_button_confirm);
	}

	// getter to access views
	
	public Button getConfirmButton() {
		return mConfirmButton;
	}
	
}
