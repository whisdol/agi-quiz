// @author Cedric Lüke
package de.fhdw.gruppe2.quizapp.android.activity_questionno4;

import de.fhdw.gruppe2.quizapp.android.constants.Constants;
import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionDataNumeric;
import android.content.Intent;
import android.os.Bundle;

public class ActivityData {
	
	private final String KEY_SEEKBAR_VALUE = "K4_1";
	private final String KEY_QUESTION_ID = "K4_2";
	
	private int mSeekBarValue;
	private int mQuestionId;
	private QuestionDataNumeric mQuestion;
	private ActivityInit mActivity;

	public ActivityData (Bundle savedInstanceState, ActivityInit act) {
		mActivity = act;
		if ( savedInstanceState == null ) {  // no data to restore
			mSeekBarValue = 0;
            Intent intent = mActivity.getIntent();
            mQuestionId = intent.getIntExtra(Constants.INTENT_QUESTION_ID, mQuestionId);
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}
	
	public void saveDataInBundle(Bundle b) {
		b.putInt(KEY_SEEKBAR_VALUE, mSeekBarValue);
		b.putInt(KEY_QUESTION_ID, mQuestionId);
	}
	
	public void restoreDataFromBundle(Bundle b) {
		mSeekBarValue = b.getInt(KEY_SEEKBAR_VALUE);
		mQuestionId = b.getInt(KEY_QUESTION_ID);
	}
	
	// getter
	public ActivityInit getActivity() {
		return mActivity;
	}

	public int getmSeekBarValue() {
		return mSeekBarValue;
	}

	public void setmSeekBarValue(int pSeekBarValue) {
		if (pSeekBarValue < mQuestion.getmMinValue()) {
			mSeekBarValue = mQuestion.getmMinValue();
		} else if (pSeekBarValue > mQuestion.getmMaxValue()) {
			mSeekBarValue = mQuestion.getmMaxValue();
		} else {
			mSeekBarValue = pSeekBarValue;
		}
		this.mSeekBarValue = pSeekBarValue;
	}

	public QuestionDataNumeric getmQuestion() {
		return mQuestion;
	}
	
	public int getmQuestionId() {
		return mQuestionId;
	}

	//setter
	public void setmQuestion(QuestionDataNumeric mQuestion) {
		this.mQuestion = mQuestion;
	}	

}
