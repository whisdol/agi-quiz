// @author Cedric Lüke & Ben Schulze
package de.fhdw.gruppe2.quizapp.android.activity_questionno4;

import de.fhdw.gruppe2.quizapp.android.R;
import de.fhdw.gruppe2.quizapp.android.constants.Constants;
import de.fhdw.gruppe2.quizapp.android.dbconnection.DatabaseConnection;
import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionDataNumeric;
import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;


public class ActivityApplicationLogic {

	private ActivityData mData;
	private ActivityGUI mGUI;

	public ActivityApplicationLogic(ActivityData mData, ActivityGUI mGUI) {
		this.mData = mData;
		this.mGUI = mGUI;
		mData.setmQuestion((QuestionDataNumeric) DatabaseConnection.getFrage(mData.getmQuestionId()));
		setUpLayout();
		mData.setmTimer(createTimer(mData.getmQuestion().getmTime()).start());
	}
	private CountDownTimer createTimer (long time){
		long runTime=time;
		if (time==-1){
			runTime=10500; //10 sec + 0,5 sec deviation tolerance
		}
		final long newrunTime=runTime-mData.getmAlreadyRunnedTime();
		mGUI.getmBar().setProgress((int) (mData.getmAlreadyRunnedTime()/100));
		return new CountDownTimer(newrunTime, 100) {	

		     public void onTick(long millisUntilFinished) {			    	 
		    	 mData.setmAlreadyRunnedTime( mData.getmAlreadyRunnedTime() +100 );
		    	 mGUI.getmBar().setProgress((int) ((mData.getmAlreadyRunnedTime())/100));
		     }
		     public void onFinish() {
		    	boolean correct = evaluateAnswers();
		 		defineActivityReturnValues(correct, true);
		 		mData.getActivity().finish();
		     }
		  };
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
	
	
	private void defineActivityReturnValues(boolean correct, boolean continueOrExit){
        Intent intent;
        intent = new Intent();
        intent.putExtra(Constants.INTENT_ANSWER_CORRECT, correct);
        intent.putExtra(Constants.INTENT_ANSWER_CONTINUE, continueOrExit);
        intent.putExtra(Constants.INTENT_ANSWER, Integer.toString(mData.getmSeekBarValue()));
        intent.putExtra(Constants.INTENT_ANSWER_QID, mData.getmQuestionId());
        mData.getActivity().setResult(Activity.RESULT_OK, intent);
	}
	
	private boolean evaluateAnswers(){
		String answerstring;
		boolean correct;
		if (mData.getmQuestion().isCorrectAnswer(mData.getmSeekBarValue() + mData.getmQuestion().getmMinValue())){
			answerstring = mData.getActivity().getString(R.string.question_answered_correctly);
			correct = true;
		} else {
			answerstring = mData.getActivity().getString(R.string.question_answered_incorrectly);
			correct = false;
		}
		Toast.makeText(mData.getActivity().getContext(), answerstring, Toast.LENGTH_SHORT).show();
		return correct;
	}


	public void onContinueButtonClicked() {
		boolean correct = evaluateAnswers();
		defineActivityReturnValues(correct, true);
		mData.getActivity().finish();
		mData.getmTimer().cancel();
	}

	public void onExitButtonClicked() {
		boolean correct = evaluateAnswers();
		defineActivityReturnValues(correct, false);
		mData.getActivity().finish();
		mData.getmTimer().cancel();
	}
}
