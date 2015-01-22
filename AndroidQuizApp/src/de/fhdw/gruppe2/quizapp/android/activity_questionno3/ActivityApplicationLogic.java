package de.fhdw.gruppe2.quizapp.android.activity_questionno3;

import de.fhdw.gruppe2.quizapp.android.questiondata.QuestionDataSingleAnswer;
import android.graphics.Color;


public class ActivityApplicationLogic {

	private ActivityData mData;
	private ActivityGUI mGUI;

	public ActivityApplicationLogic(ActivityData mData, ActivityGUI mGUI) {
		this.mData = mData;
		this.mGUI = mGUI;
		applyDataToGUI();
		//QuestionDataSingleAnswer question = DB.GetQuestion(mData.getIdQuestion());
		setUpLayout(new QuestionDataSingleAnswer(0, null, null, 0, 0));
	}

	private void applyDataToGUI() {
		this.mGUI.changeButtonColor(this.mGUI.getmAnswerButton3(),Color.GRAY);
		this.mGUI.changeButtonColor(this.mGUI.getmAnswerButton2(),Color.GRAY);
		this.mGUI.changeButtonColor(this.mGUI.getmAnswerButton1(),Color.GRAY);
		this.mGUI.changeButtonColor(this.mGUI.getmAnswerButton0(),Color.GRAY);
	}
	
	private void setUpLayout(QuestionDataSingleAnswer pData)
	{
		this.mGUI.getmQuestionTextView().setText(pData.getQuestion());
		this.mGUI.getmAnswerButton0().setText(pData.getAnswers().get(0));
		this.mGUI.getmAnswerButton1().setText(pData.getAnswers().get(1));
		this.mGUI.getmAnswerButton2().setText(pData.getAnswers().get(2));
		this.mGUI.getmAnswerButton3().setText(pData.getAnswers().get(3));
	}
	
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

	public void onContinueButtonClicked() {
		// TODO Auto-generated method stub
		
	}

	public void onExitButtonClicked() {
		// TODO Auto-generated method stub
		
	}

	


}
