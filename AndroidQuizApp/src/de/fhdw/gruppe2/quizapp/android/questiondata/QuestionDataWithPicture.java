package de.fhdw.gruppe2.quizapp.android.questiondata;

import java.util.List;

public class QuestionDataWithPicture extends QuestionData {
	
	private String mPicturePath;
	
	public QuestionDataWithPicture(int pID, String pQuestion, List<AnswerData> pAnswers,int pTime, String pPicturePath) {
		super(pID, pQuestion, pAnswers, 0,pTime);
		for(int i = 0;i<pAnswers.size(); i++)
		{
			if(pAnswers.get(i).getmRichtig() == 1)
			{
				this.setmCorrectAnswer(i);
			}
		}
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
