// @author Cedric Lüke
package de.fhdw.gruppe2.quizapp.android.activity_question_numeric;

import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionDataNumeric;
import android.os.Bundle;

public class ActivityData {
	
	private int mSeekBarValue;
	private QuestionDataNumeric mQuestion;
	private ActivityInit mActivity;

	public ActivityData (Bundle savedInstanceState, ActivityInit act) {
		mSeekBarValue = 0;
		mActivity = act;
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

	//setter
	public void setmQuestion(QuestionDataNumeric mQuestion) {
		this.mQuestion = mQuestion;
	}	



}
