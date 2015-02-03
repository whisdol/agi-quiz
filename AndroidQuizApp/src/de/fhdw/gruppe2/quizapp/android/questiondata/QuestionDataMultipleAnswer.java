package de.fhdw.gruppe2.quizapp.android.questiondata;

import java.util.List;

public class QuestionDataMultipleAnswer extends QuestionData {
	public QuestionDataMultipleAnswer(int pID, String pQuestion, List<AnswerData> pAnswers,
			int pCorrectAnswer,int pTime) {
		super(pID, pQuestion, pAnswers, pCorrectAnswer,pTime);
	}

	@Override
	public boolean isCorrectAnswer(int pAnswer) {
		int dbAnswer = 0;
		List<String> checkDBAnswer;
		checkDBAnswer = getAnswers();
		for(int i=0; i<checkDBAnswer.size(); i++){
			String listEntry = checkDBAnswer.get(i);
			if ( listEntry == "1" ) {
				dbAnswer += Math.pow(2, i);
			}
		}
		this.setmCorrectAnswer(dbAnswer);
		return (pAnswer == this.getCorrectAnswer());
	}
}
