package de.fhdw.gruppe2.quizapp.android.questiondata;

import java.util.List;

public class QuestionDataWithPicture extends QuestionData {
	
	private String mPicturePath;
	
	public QuestionDataWithPicture(int pID, String pQuestion, List<AnswerData> pAnswers,
			int pCorrectAnswer,int pTime, String pPicturePath) {
		super(pID, pQuestion, pAnswers, pCorrectAnswer,pTime);
		setmPicturePath(pPicturePath);
	}

	@Override
	public boolean isCorrectAnswer(int pAnswer) {
		return (pAnswer == this.getCorrectAnswer());
	}

	public String getmPicturePath() {
		return mPicturePath;
	}

	public void setmPicturePath(String mPicturePath) {
		this.mPicturePath = mPicturePath;
	}

}
