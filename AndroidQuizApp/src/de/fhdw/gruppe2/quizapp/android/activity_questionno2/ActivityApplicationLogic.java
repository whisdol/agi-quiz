// @author Alexander Frese & Ben Schulze
 
package de.fhdw.gruppe2.quizapp.android.activity_questionno2;


import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.Toast;
import de.fhdw.gruppe2.quizapp.android.R;
import de.fhdw.gruppe2.quizapp.android.constants.Constants;
import de.fhdw.gruppe2.quizapp.android.dbconnection.DatabaseConnection;
import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionDataMultipleAnswer;

public class ActivityApplicationLogic {

	private ActivityData mData;
	private ActivityGUI mGUI;

	public ActivityApplicationLogic(ActivityData mData, ActivityGUI mGUI) {
		this.mData = mData;
		this.mGUI = mGUI;
		applyDataToGUI();
		mData.setmQuestion((QuestionDataMultipleAnswer)  DatabaseConnection.getFrage(mData.getmQuestionID()));
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
		 		boolean correct = checkAnswers(mData.getmSelectedAnswer());
				defineActivityReturnValues(correct, true);
				mData.getActivity().finish();
		     }
		  };
	}
	
	private void applyDataToGUI() {
		this.mGUI.getmCheckBox0().setChecked(false);
		this.mGUI.getmCheckBox1().setChecked(false);
		this.mGUI.getmCheckBox2().setChecked(false);
		this.mGUI.getmCheckBox3().setChecked(false);
	}
	
	private void setUpLayout()
	{
		QuestionDataMultipleAnswer question = mData.getmQuestion();
		this.mGUI.getmQuestionTextView().setText(question.getQuestion());
		this.mGUI.getmCheckBox0().setText(question.getAnswers().get(0));
		this.mGUI.getmCheckBox1().setText(question.getAnswers().get(1));
		this.mGUI.getmCheckBox2().setText(question.getAnswers().get(2));
		this.mGUI.getmCheckBox3().setText(question.getAnswers().get(3));
	}
	
	// event handling

	public void onCheckBox0Clicked() {
		if (mGUI.getmCheckBox0().isChecked() == false) {
			this.mGUI.getmCheckBox0().setChecked(false);
			this.mData.setmSelectedAnswer(true, 0);
		}
		else if (mGUI.getmCheckBox0().isChecked() == true) {
			this.mGUI.getmCheckBox0().setChecked(true);
			this.mData.setmSelectedAnswer(false, 0);
		}	
	}

	public void onCheckBox1Clicked() {
		if (mGUI.getmCheckBox1().isChecked() == false) {
			this.mGUI.getmCheckBox1().setChecked(false);
			this.mData.setmSelectedAnswer(true, 1);
		}
		else if (mGUI.getmCheckBox1().isChecked() == true) {
			this.mGUI.getmCheckBox1().setChecked(true);
			this.mData.setmSelectedAnswer(false, 1);
		}
	}

	public void onCheckBox2Clicked() {
		if (mGUI.getmCheckBox2().isChecked() == false) {
			this.mGUI.getmCheckBox2().setChecked(false);
			this.mData.setmSelectedAnswer(true, 2);
		}
		else if (mGUI.getmCheckBox2().isChecked() == true){
			this.mGUI.getmCheckBox2().setChecked(true);
			this.mData.setmSelectedAnswer(false, 2);
		}
	}

	public void onCheckBox3Clicked() {
		if (mGUI.getmCheckBox3().isChecked() == false) {
			this.mGUI.getmCheckBox3().setChecked(false);
			this.mData.setmSelectedAnswer(true, 3);
		}
		else if (mGUI.getmCheckBox3().isChecked() == true){
			this.mGUI.getmCheckBox3().setChecked(true);
			this.mData.setmSelectedAnswer(false, 3);
		}			
	}

	public boolean checkAnswers(boolean pSelectedAnswer[]){
		int tempAnswer = 0;
		String answerstring;
		boolean correct = false;
		for(int i=0; i<4; i++){
			if (pSelectedAnswer[i]){
				tempAnswer += Math.pow(2, i);
			}
		}
		
		if (mData.getmQuestion().isCorrectAnswer(tempAnswer)){
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
        intent.putExtra(Constants.INTENT_ANSWER, this.mData.getmSelectedAnswers());
        intent.putExtra(Constants.INTENT_ANSWER_QID, mData.getmQuestionID());
        mData.getActivity().setResult(Activity.RESULT_OK, intent);
	}
	
	public void onContinueButtonClicked() {
		boolean correct = checkAnswers(mData.getmSelectedAnswer());
		defineActivityReturnValues(correct, true);
		mData.getActivity().finish();
		mData.getmTimer().cancel();
	}

	public void onExitButtonClicked() {
		boolean correct = checkAnswers(mData.getmSelectedAnswer());
		defineActivityReturnValues(correct, false);
		mData.getActivity().finish();	
		mData.getmTimer().cancel();
	}

	
}
