package de.fhdw.gruppe2.quizapp.android.questiondata;

import java.util.List;

public class QuestionDataOrder extends QuestionData {
	public QuestionDataOrder(int pID, String pQuestion, List<AnswerData> pAnswers,
			int pCorrectAnswer,int pTime) {
		super(pID, pQuestion, pAnswers, pCorrectAnswer,pTime);
	}

	@Override
	public boolean isCorrectAnswer(int pAnswer) {
		return (pAnswer == this.getCorrectAnswer());
	}

}
