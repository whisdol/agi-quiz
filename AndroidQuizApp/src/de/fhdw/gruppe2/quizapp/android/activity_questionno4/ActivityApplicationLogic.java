// @author Cedric Lüke
package de.fhdw.gruppe2.quizapp.android.activity_questionno4;

import java.util.Arrays;

import de.fhdw.gruppe2.quizapp.android.dbconnection.DatabaseConnection;
import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionDataNumeric;
import android.widget.TextView;
import android.widget.Toast;


public class ActivityApplicationLogic {

	private ActivityData mData;
	private ActivityGUI mGUI;

	public ActivityApplicationLogic(ActivityData mData, ActivityGUI mGUI) {
		this.mData = mData;
		this.mGUI = mGUI;
		//TODO: get question id from bundle
		mData.setmQuestion((QuestionDataNumeric) DatabaseConnection.getFrage(3));
		setUpLayout();
	}
	
	private void setUpLayout()
	{
		QuestionDataNumeric q = mData.getmQuestion();
		this.mGUI.getmQuestionTextView().setText(q.getQuestion());
		this.mGUI.getmMinValue().setText(Integer.toString(q.getmMinValue()));
		this.mGUI.getmMaxValue().setText(Integer.toString(q.getmMaxValue()));
		this.mGUI.getmSeekBarValueEditText().setText(Integer.toString(q.getmMinValue()), TextView.BufferType.EDITABLE);
		
		// Seekbar Min value is always 0
		this.mGUI.getmSlider().setMax(q.getmMaxValue() - q.getmMinValue());
		
	}
	
	private void applySeekBarValueToEditText() {
		int seekBarEditTextValue = calculateEditTextValueFromSeekBarValue(mData.getmSeekBarValue());
		this.mGUI.getmSeekBarValueEditText().setText(Integer.toString(seekBarEditTextValue));
	}
	
	private void applyEditTextValueToSeekBar() {
		this.mGUI.getmSlider().setProgress(mData.getmSeekBarValue());
	}
	
	
	// Helpers
	public int calculateSeekBarValueFromEditTextValue(int pEditTextValue){
		return pEditTextValue - mData.getmQuestion().getmMinValue();
	}
	
	public int calculateEditTextValueFromSeekBarValue(int pSeekBarValue){
		return pSeekBarValue + mData.getmQuestion().getmMinValue();
	}
	
	// event handling

	public void onSeekBarValueTextChanged(int pProgress) {
		this.mData.setmSeekBarValue(pProgress);
		applySeekBarValueToEditText();
	}
	
	public void mSeekBarValueEditTextValueChanged(String pStringValue){
		int intValue;
		try {
		      intValue = Integer.parseInt(pStringValue);
		} catch (NumberFormatException e) {
		      intValue = mData.getmQuestion().getmMinValue();
		}
		this.mData.setmSeekBarValue(calculateSeekBarValueFromEditTextValue(intValue));
		applyEditTextValueToSeekBar();
	}


	public void onContinueButtonClicked() {
		// TODO Replace with real code
		String answerstring;
		if (mData.getmQuestion().isCorrectAnswer(mData.getmSeekBarValue() + mData.getmQuestion().getmMinValue())){
			answerstring = "Richtig!";
		} else {
			answerstring = "Falsch!";
		}
		Toast.makeText(mData.getActivity().getContext(), answerstring, Toast.LENGTH_SHORT).show();		
	}

	public void onExitButtonClicked() {
		// TODO Auto-generated method stub
		
	}
}
