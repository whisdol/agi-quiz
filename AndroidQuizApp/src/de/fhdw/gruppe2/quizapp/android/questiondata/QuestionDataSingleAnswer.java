package de.fhdw.gruppe2.quizapp.android.questiondata;

import java.util.List;

public class QuestionDataSingleAnswer extends QuestionData {
	public QuestionDataSingleAnswer(int pID, String pQuestion, List<AnswerData> pAnswers,
			int pTime) {
		super(pID, pQuestion, pAnswers, 0,pTime);
		for (int i = 0; i<pAnswers.size(); i++){
			if (pAnswers.get(i).getmRichtig() == 0)
				setmCorrectAnswer(i);
		}
	}

	@Override
	public boolean isCorrectAnswer(int pAnswer) {
		return (pAnswer == this.getCorrectAnswer());
	}

}
