//Author: Bastian Sold
package de.fhdw.gruppe2.quizapp.android.activity_questionno3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.Toast;
import de.fhdw.gruppe2.quizapp.android.R;
import de.fhdw.gruppe2.quizapp.android.constants.Constants;
import de.fhdw.gruppe2.quizapp.android.dbconnection.DatabaseConnection;
import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionDataWithPicture;


public class ActivityApplicationLogic {

	private ActivityData mData;
	private ActivityGUI mGUI;

	public ActivityApplicationLogic(ActivityData mData, ActivityGUI mGUI) {
		this.mData = mData;
		this.mGUI = mGUI;
		
		mData.setQuestion((QuestionDataWithPicture) DatabaseConnection.getFrage(mData.getmQuestionID()));
		applyDataToGUI();
		setUpLayout();
		mData.setmTimer(createTimer(mData.getmQuestion().getmTime()).start());
	}
	
	private CountDownTimer createTimer (long time){
		long runTime=time;
		if (time==-1){
			runTime=10000;
		}	
		 return new CountDownTimer(runTime, 10) {

		     public void onTick(long millisUntilFinished) {
		    	 if ((10000-millisUntilFinished) % 100 == 0){
			         mGUI.getmBar().setProgress((int) ((10000-millisUntilFinished)/100));
			    	 }
		     }

		     public void onFinish() {
		 		boolean correct = evaluateAnswers();
				defineActivityReturnValues(correct, true);
				mData.getActivity().finish();
		     }
		  };
	}
	
	private void applyDataToGUI() {
		this.mGUI.changeButtonColor(this.mGUI.getmAnswerButton3(),Color.GRAY);
		this.mGUI.changeButtonColor(this.mGUI.getmAnswerButton2(),Color.GRAY);
		this.mGUI.changeButtonColor(this.mGUI.getmAnswerButton1(),Color.GRAY);
		this.mGUI.changeButtonColor(this.mGUI.getmAnswerButton0(),Color.GRAY);
	}
	
	private void setUpLayout()
	{
		QuestionDataWithPicture q = this.mData.getmQuestion();
		this.mGUI.getmQuestionTextView().setText(q.getQuestion());
		this.mGUI.getmAnswerButton0().setText(q.getAnswers().get(0));
		this.mGUI.getmAnswerButton1().setText(q.getAnswers().get(1));
		this.mGUI.getmAnswerButton2().setText(q.getAnswers().get(2));
		this.mGUI.getmAnswerButton3().setText(q.getAnswers().get(3));
		switch(mData.getmSelectedAnswer()){
		default:
			break;
		case 0:
			mGUI.changeButtonColor(this.mGUI.getmAnswerButton0(),Color.BLUE);
			break;
		case 1:
			mGUI.changeButtonColor(this.mGUI.getmAnswerButton1(),Color.BLUE);
			break;
		case 2:
			mGUI.changeButtonColor(this.mGUI.getmAnswerButton2(),Color.BLUE);
			break;
		case 3:
			mGUI.changeButtonColor(this.mGUI.getmAnswerButton3(),Color.BLUE);
			break;
		}
		LoadImage task = new LoadImage(this.mData, this.mGUI.getmImageQuestionView());
		task.execute(mData.getmQuestion().getmPicturePath());
	}
		//set Image 
	
	
	// event handling

	public void onAnswer0ButtonClicked() {
		this.mData.setmSelectedAnswer(0);
		applyDataToGUI();
		this.mGUI.changeButtonColor(this.mGUI.getmAnswerButton0(),Color.BLUE);
	}

	public void onAnswer1ButtonClicked() {
		// TODO Auto-generated method stub
		this.mData.setmSelectedAnswer(1);
		applyDataToGUI();
		this.mGUI.changeButtonColor(this.mGUI.getmAnswerButton1(),Color.BLUE);
	}

	public void onAnswer2ButtonClicked() {
		// TODO Auto-generated method stub
		this.mData.setmSelectedAnswer(2);
		applyDataToGUI();
		this.mGUI.changeButtonColor(this.mGUI.getmAnswerButton2(),Color.BLUE);
	}

	public void onAnswer3ButtonClicked() {
		// TODO Auto-generated method stub
		this.mData.setmSelectedAnswer(3);
		applyDataToGUI();
		this.mGUI.changeButtonColor(this.mGUI.getmAnswerButton3(),Color.BLUE);
		
	}
	
	private boolean evaluateAnswers(){
		String answerstring;
		boolean correct;
		if (mData.getmQuestion().isCorrectAnswer(mData.getmSelectedAnswer())){
			answerstring = mData.getActivity().getString(R.string.question_answered_correctly);
			correct = true;
		} else {
			answerstring = mData.getActivity().getString(R.string.question_answered_incorrectly);
			correct = false;
		}
		Toast.makeText(mData.getActivity().getContext(), answerstring, Toast.LENGTH_SHORT).show();
		return correct;
	}
	
	private void defineActivityReturnValues(boolean correct, boolean continueOrExit){
        Intent intent;
        intent = new Intent();
        intent.putExtra(Constants.INTENT_ANSWER_CORRECT, correct);
        intent.putExtra(Constants.INTENT_ANSWER_CONTINUE, continueOrExit);
        intent.putExtra(Constants.INTENT_ANSWER, this.mData.getmSelectedAnswer());
        intent.putExtra(Constants.INTENT_ANSWER_QID, mData.getmQuestionID());
        mData.getActivity().setResult(Activity.RESULT_OK, intent);
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
