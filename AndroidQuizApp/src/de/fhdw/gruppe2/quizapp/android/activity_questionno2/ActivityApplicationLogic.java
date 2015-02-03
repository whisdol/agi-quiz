/**
 * Creator: Alexander Frese
 */
package de.fhdw.gruppe2.quizapp.android.activity_questionno2;

import android.os.CountDownTimer;
import de.fhdw.gruppe2.quizapp.android.Task.Task;
import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionDataMultipleAnswer;


public class ActivityApplicationLogic {

	private ActivityData mData;
	private ActivityGUI mGUI;

	public ActivityApplicationLogic(ActivityData mData, ActivityGUI mGUI) {
		this.mData = mData;
		this.mGUI = mGUI;
		applyDataToGUI();
		//QuestionDataMultipleAnswer question = DB.GetQuestion(mData.getIdQuestion());
		setUpLayout(new QuestionDataMultipleAnswer(0, null, null, 0, 0));
		//createTimer(mData.getmQuestion().getmTime()).start();
	}
	private CountDownTimer createTimer (long time){
		long runTime=time;
		if (time==-1){
			runTime=10000;
		}	
		 return new CountDownTimer(runTime, 10) {

		     public void onTick(long millisUntilFinished) {
		         mGUI.getmBar().setProgress((int) (10000-millisUntilFinished));
		     }

		     public void onFinish() {
		         onContinueButtonClicked();
		     }
		  };
	}
	
	private void applyDataToGUI() {
		this.mGUI.getmCheckBox0().setChecked(false);
		this.mGUI.getmCheckBox1().setChecked(false);
		this.mGUI.getmCheckBox2().setChecked(false);
		this.mGUI.getmCheckBox3().setChecked(false);
	}
	
	private void setUpLayout(QuestionDataMultipleAnswer pData)
	{
		this.mGUI.getmQuestionTextView().setText(pData.getQuestion());
		this.mGUI.getmCheckBox0().setText(pData.getAnswers().get(0));
		this.mGUI.getmCheckBox1().setText(pData.getAnswers().get(1));
		this.mGUI.getmCheckBox2().setText(pData.getAnswers().get(2));
		this.mGUI.getmCheckBox3().setText(pData.getAnswers().get(3));
	}
	
	// event handling

	public void onCheckBox0Clicked() {
		if (mGUI.getmCheckBox0().isChecked() == true) {
			this.mGUI.getmCheckBox0().setChecked(false);
			this.mData.setmSelectedAnswer(false, 0);
		}
		else {
			this.mGUI.getmCheckBox0().setChecked(true);
			this.mData.setmSelectedAnswer(true, 0);
		}
		
	}

	public void onCheckBox1Clicked() {
		if (mGUI.getmCheckBox1().isChecked() == true) {
			this.mGUI.getmCheckBox1().setChecked(false);
			this.mData.setmSelectedAnswer(false, 1);
		}
		else {
			this.mGUI.getmCheckBox1().setChecked(true);
			this.mData.setmSelectedAnswer(true, 1);
		}
	}

	public void onCheckBox2Clicked() {
		if (mGUI.getmCheckBox2().isChecked() == true) {
			this.mGUI.getmCheckBox2().setChecked(false);
			this.mData.setmSelectedAnswer(false, 2);
		}
		else {
			this.mGUI.getmCheckBox2().setChecked(true);
			this.mData.setmSelectedAnswer(true, 2);
		}
	}

	public void onCheckBox3Clicked() {
		if (mGUI.getmCheckBox3().isChecked() == true) {
			this.mGUI.getmCheckBox3().setChecked(false);
			this.mData.setmSelectedAnswer(false, 3);
		}
		else {
			this.mGUI.getmCheckBox3().setChecked(true);
			this.mData.setmSelectedAnswer(true, 3);
		}			
	}

	public int checkAnswers(boolean pSelectedAnswer[]){
		int tempAnswer = 0;
		for(int i=0; i<4; i++){
			if (pSelectedAnswer[i]){
				tempAnswer  += Math.pow(2, i);
			}
		}
		return tempAnswer;
	}
	
	public void onContinueButtonClicked() {
		//int checkAnswert = checkAnswers();
		//QuestionDataMultipleAnswer.isCorrectAnswer
		//continue
	}

	public void onExitButtonClicked() {
		// TODO Auto-generated method stub
		
	}

}
