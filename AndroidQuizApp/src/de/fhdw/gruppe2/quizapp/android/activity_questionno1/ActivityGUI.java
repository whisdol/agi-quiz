//Author: Daniel Gnech
package de.fhdw.gruppe2.quizapp.android.activity_questionno1;

import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import de.fhdw.gruppe2.quizapp.android.R;

public class ActivityGUI {

	private Button mAnswerButton0;
	private Button mAnswerButton1;
	private Button mAnswerButton2;
	private Button mAnswerButton3;
	private Button mContinueButton;
	private Button mExitButton;
	private TextView mQuestionTextView;
	private ProgressBar mBar;
	
	public ActivityGUI(ActivityInit act) {
		act.setContentView(R.layout.activity_questionno1);
		mAnswerButton0 = (Button) act.findViewById(R.id.answer_button_0);
		mAnswerButton1 = (Button) act.findViewById(R.id.answer_button_1);
		mAnswerButton2 = (Button) act.findViewById(R.id.answer_button_2);
		mAnswerButton3 = (Button) act.findViewById(R.id.answer_button_3);
		mContinueButton = (Button) act.findViewById(R.id.continue_button);
		mExitButton = (Button) act.findViewById(R.id.exit_button);
		mQuestionTextView = (TextView) act.findViewById(R.id.question_textview);
		mBar = (ProgressBar) act.findViewById(R.id.progressBar1);
	}

	// getter to access views
	public ProgressBar getmBar() {
		return mBar;
	}

	public void setmBar(ProgressBar mBar) {
		this.mBar = mBar;
	}
	public Button getmAnswerButton0() {
		return mAnswerButton0;
	}

	public Button getmAnswerButton1() {
		return mAnswerButton1;
	}

	public Button getmAnswerButton2() {
		return mAnswerButton2;
	}

	public Button getmAnswerButton3() {
		return mAnswerButton3;
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
	
	public void changeButtonColor(Button pButton,int pColor)
	{
		pButton.setBackgroundColor(pColor);
	}

	
	
}
