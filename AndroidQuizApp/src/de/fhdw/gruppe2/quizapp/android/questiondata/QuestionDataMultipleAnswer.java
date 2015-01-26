package de.fhdw.gruppe2.quizapp.android.questiondata;

import java.util.List;

public class QuestionDataMultipleAnswer extends QuestionData {
	public QuestionDataMultipleAnswer(int pID, String pQuestion, List<AnswerData> pAnswers,
			int pCorrectAnswer,int pTime) {
		super(pID, pQuestion, pAnswers, pCorrectAnswer,pTime);
	}

	@Override
	public boolean isCorrectAnswer(int pAnswer) {
		return (pAnswer == this.getCorrectAnswer());
	}

}
