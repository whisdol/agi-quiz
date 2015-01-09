package de.fhdw.gruppe2.quizapp.android.questiondata;

import java.util.List;

public class QuestionDataNumeric extends QuestionData {
	
	private float mDeviation;
	private boolean mDeviationIsPercent;

	public QuestionDataNumeric(int pID, String pQuestion, List<String> pAnswers,
			int pCorrectAnswer, float pDeviation, boolean pDeviationIsPercent) {
		super(pID, pQuestion, pAnswers, pCorrectAnswer);
		mDeviation = pDeviation;
		mDeviationIsPercent = pDeviationIsPercent;
		
	}

	@Override
	public boolean isCorrectAnswer(int pAnswer) {
		int minValue;
		int maxValue;
		
		if (mDeviationIsPercent){
			minValue = (int) Math.floor(super.getCorrectAnswer()  * (1 - mDeviation));
			maxValue = (int) Math.ceil(super.getCorrectAnswer() * (1 + mDeviation));
		} else {
			minValue = super.getCorrectAnswer() - Math.round(mDeviation);
			maxValue = super.getCorrectAnswer() + Math.round(mDeviation);	
		}
		
		return (pAnswer >= minValue && pAnswer <=maxValue);
	}

}
