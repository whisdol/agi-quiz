//Creator Daniel Gnech
package de.fhdw.gruppe2.quizapp.android.activity_inputmask;

import android.widget.Button;
import android.widget.EditText;
import de.fhdw.gruppe2.quizapp.android.R;

public class ActivityGUI {

	private Button mConfirmButton;
	private EditText mEditText;

	public ActivityGUI(ActivityInit act) {
		act.setContentView(R.layout.activity_inputmask);
		mConfirmButton = (Button) act.findViewById(R.id.inputmask_button_confirm);
		mEditText = (EditText) act.findViewById(R.id.intputmask_edittext);
	}

	// getter to access views
	
	public Button getConfirmButton() {
		return mConfirmButton;
	}
	
	public EditText getmEditText() {
		return mEditText;
	}
	
}
