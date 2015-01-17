/**
 * Creator: Alexander Frese
 */
package de.fhdw.gruppe2.quizapp.android.activity_questionno2;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import de.fhdw.gruppe2.quizapp.android.R;

public class ActivityGUI {

	private CheckBox mCheckBox0;
	private CheckBox mCheckBox1;
	private CheckBox mCheckBox2;
	private CheckBox mCheckBox3;
	private Button mContinueButton;
	private Button mExitButton;
	private TextView mQuestionTextView;
	
	public ActivityGUI(ActivityInit act) {
		act.setContentView(R.layout.activity_questionno2);
		mCheckBox0 = (CheckBox) act.findViewById(R.id.question2_check1);
		mCheckBox1 = (CheckBox) act.findViewById(R.id.question2_check2);
		mCheckBox2 = (CheckBox) act.findViewById(R.id.question2_check3);
		mCheckBox3 = (CheckBox) act.findViewById(R.id.question2_check4);
		mContinueButton = (Button) act.findViewById(R.id.continue_button);
		mExitButton = (Button) act.findViewById(R.id.exit_button);
		mQuestionTextView = (TextView) act.findViewById(R.id.question_textview);
	}

	// getter to access views

	public CheckBox getmCheckBox0() {
		return mCheckBox0;
	}

	public CheckBox getmCheckBox1() {
		return mCheckBox1;
	}

	public CheckBox getmCheckBox2() {
		return mCheckBox2;
	}

	public CheckBox getmCheckBox3() {
		return mCheckBox3;
	}

	public Button getmContinueButton() {
		return mContinueButton;
	}

	public Button getmExitButton() {
		return mExitButton;
	}
	
	public TextView getmQuestionTextView() {
		return mQuestionTextView;
	}

	public void setmQuestionTextView(TextView mQuestionTextView) {
		this.mQuestionTextView = mQuestionTextView;
	}
	
	
}
