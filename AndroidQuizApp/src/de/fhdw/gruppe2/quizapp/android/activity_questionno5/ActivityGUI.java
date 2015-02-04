//Author: Kim Gerstein
package de.fhdw.gruppe2.quizapp.android.activity_questionno5;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import de.fhdw.gruppe2.quizapp.android.R;

public class ActivityGUI {

	private Button mContinueButton;
	private Button mExitButton;
	private TextView mQuestionTextView;
	private ProgressBar mBar;
	private Button[] mAnswerButton;
	

	public ActivityGUI(ActivityInit act) {
		act.setContentView(R.layout.activity_questionno5);
		mContinueButton = (Button) act.findViewById(R.id.continue_button);
		mExitButton = (Button) act.findViewById(R.id.exit_button);
		mQuestionTextView = (TextView) act.findViewById(R.id.question_textview);
		mBar = (ProgressBar) act.findViewById(R.id.progressBar1);
		mAnswerButton = new Button[4];
		mAnswerButton[0] = (Button) act.findViewById(R.id.answer_button_0);
		mAnswerButton[1] = (Button) act.findViewById(R.id.answer_button_1);
		mAnswerButton[2] = (Button) act.findViewById(R.id.answer_button_2);
		mAnswerButton[3] = (Button) act.findViewById(R.id.answer_button_3);
	}

	// getter to access views
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
	public ProgressBar getmBar() {
		return mBar;
	}

	public void setmBar(ProgressBar mBar) {
		this.mBar = mBar;
	}
	
	public Button[] getmAnswerButton() {
		return mAnswerButton;
	}

	public void setmAnswerButton(Button[] mAnswerButton) {
		this.mAnswerButton = mAnswerButton;
	}

	
	
}
