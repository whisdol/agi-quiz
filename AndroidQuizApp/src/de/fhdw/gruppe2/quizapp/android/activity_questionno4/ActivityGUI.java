// @author Cedric Lüke
package de.fhdw.gruppe2.quizapp.android.activity_questionno4;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import de.fhdw.gruppe2.quizapp.android.R;

public class ActivityGUI {

	private TextView mMinValue;
	private TextView mMaxValue;
	private EditText mSeekBarValueEditText;
	private SeekBar mSlider;
	private Button mContinueButton;
	private Button mExitButton;
	private TextView mQuestionTextView;
	private ProgressBar mBar;
	


	public ActivityGUI(ActivityInit act) {
		act.setContentView(R.layout.activity_questionno4);
		mMinValue = (TextView) act.findViewById(R.id.textView_min);
		mMaxValue = (TextView) act.findViewById(R.id.textView_max);
		mSeekBarValueEditText = (EditText) act.findViewById(R.id.editText_seekBar_value);
		mSlider = (SeekBar) act.findViewById(R.id.seekBar_answer_slider);
		mContinueButton = (Button) act.findViewById(R.id.continue_button);
		mExitButton = (Button) act.findViewById(R.id.exit_button);
		mQuestionTextView = (TextView) act.findViewById(R.id.question_textview);
		mBar = (ProgressBar) act.findViewById(R.id.progressBar1);
	}

	// getter to access views
	public Button getmContinueButton() {
		return mContinueButton;
	}

	protected TextView getmMinValue() {
		return mMinValue;
	}

	protected TextView getmMaxValue() {
		return mMaxValue;
	}

	protected EditText getmSeekBarValueEditText() {
		return mSeekBarValueEditText;
	}

	protected SeekBar getmSlider() {
		return mSlider;
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

	
	
}
