//Author: Kim Gerstein & Ben Schulze
package de.fhdw.gruppe2.quizapp.android.activity_questionno5;

import de.fhdw.gruppe2.quizapp.android.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.Toast;
import de.fhdw.gruppe2.quizapp.android.constants.Constants;
import de.fhdw.gruppe2.quizapp.android.dbconnection.DatabaseConnection;
import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionDataOrder;


public class ActivityApplicationLogic {

	private ActivityData mData;
	private ActivityGUI mGUI;

	public ActivityApplicationLogic(ActivityData mData, ActivityGUI mGUI) {
		this.mData = mData;
		this.mGUI = mGUI;
		//TODO: get question id from bundle
		mData.setmQuestion((QuestionDataOrder) DatabaseConnection.getFrage(mData.getmQuestionId()));
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
		QuestionDataOrder q = mData.getmQuestion();
		this.mGUI.getmQuestionTextView().setText(q.getQuestion());		
		for(int i = 0;i<4;i++)
		{
			this.mGUI.getmAnswerButton()[i].setText(q.getAnswers().get(i));
			this.mGUI.getmAnswerButton()[i].setBackgroundColor(Color.GRAY);
		}
	}
	
	
	// Helpers
	private String arrayToString(int[] pArray) 
	{
		String s = "";
		for(int i = 0;i < pArray.length; i++)
		{
			s += pArray[i];
		}
		return s;
	}
	
	// event handling

	private void defineActivityReturnValues(boolean correct, boolean continueOrExit){
        Intent intent;
        intent = new Intent();
        intent.putExtra(Constants.INTENT_ANSWER_CORRECT, correct);
        intent.putExtra(Constants.INTENT_ANSWER_CONTINUE, continueOrExit);
        intent.putExtra(Constants.INTENT_ANSWER, arrayToString(this.mData.getmSelectedValue()));
        intent.putExtra(Constants.INTENT_ANSWER_QID, mData.getmQuestionId());
        mData.getActivity().setResult(Activity.RESULT_OK, intent);
	}
	
	private boolean evaluateAnswers(){
		String answerstring;
		int selectedAnswers = 0;
		boolean correct;
		for(int i = 0;i<4;i++)
		{
			int answer = this.mData.getmSelectedValue()[i];
			if(answer == 5)
			{
				return false;
			}else
			{
				selectedAnswers += Math.pow(10, 3-i)*(answer + 1);
			}
		}
		if (mData.getmQuestion().isCorrectAnswer(selectedAnswers)){
			answerstring = mData.getActivity().getString(R.string.question_answered_correctly);
			correct = true;
		} else {
			answerstring = mData.getActivity().getString(R.string.question_answered_incorrectly);
			correct = false;
		}
		Toast.makeText(mData.getActivity().getContext(), answerstring, Toast.LENGTH_SHORT).show();
		return correct;
	}

	public void onClickAnswerButtonClick(int pButton)
	{
		if(!arrayToString(this.mData.getmSelectedValue()).contains(String.valueOf(pButton)))
		{
			for(int i = 0;i<4;i++)
			{
				if(this.mData.getmSelectedValue()[i] == 5)
				{
					this.mData.setmSelectedValue(pButton, i);
					this.mGUI.getmAnswerButton()[pButton].setBackgroundColor(Color.rgb(0, 105+50*i, 255));
					break;
				}
			}
		}else
		{
			for(int i = 3;i>-1;i--)
			{
				if(this.mData.getmSelectedValue()[i] != 5)
				{
					this.mData.setmSelectedValue(5, i);
					this.mGUI.getmAnswerButton()[pButton].setBackgroundColor(Color.GRAY);
					break;
				}
			}
		}
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
