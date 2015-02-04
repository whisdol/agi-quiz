package de.fhdw.gruppe2.quizapp.android.questiondata;

import java.util.List;

public class QuestionDataOrder extends QuestionData {
	public QuestionDataOrder(int pID, String pQuestion, List<AnswerData> pAnswers,int pTime) {
		super(pID, pQuestion, pAnswers, 0,pTime);
		int pCorrectAnswer = 0;
		for(int i=3;i<pAnswers.size() && i>=0; i--)
		{
			pCorrectAnswer += Math.pow(10, 3)*pAnswers.get(i).getmRichtig();
		}
		this.setmCorrectAnswer(pCorrectAnswer);
	}

	@Override
	public boolean isCorrectAnswer(int pAnswer) {
		return (pAnswer == this.getCorrectAnswer());
	}

}
