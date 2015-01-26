// @author Cedric Lüke
package de.fhdw.gruppe2.quizapp.android.questiondata;

import java.util.List;
import java.util.Set;

public class QuestionDataNumeric extends QuestionData {
	
	private float mDeviation;
	private boolean mDeviationIsPercent;
	private int mMinValue;


	private int mMaxValue;

	public QuestionDataNumeric(int pID, String pQuestion, List<AnswerData> pAnswers,
			int pCorrectAnswer, float pDeviation, boolean pDeviationIsPercent,int pTime, int pMinValue, int pMaxValue) {
		super(pID, pQuestion, pAnswers, pCorrectAnswer,pTime);
		mDeviation = pDeviation;
		mDeviationIsPercent = pDeviationIsPercent;
		mMinValue = pMinValue;
		mMaxValue = pMaxValue;
	}
	
	public QuestionDataNumeric(int pID, String pQuestion, List<AnswerData> pAnswers, int pTime){
		// TODO: Check if all values have been initialized
		super(pID, pQuestion, pAnswers, 0,pTime);
		for (int i = 0; i < pAnswers.size(); i++){
			AnswerData curAnswer = pAnswers.get(i);
			switch (curAnswer.getmRichtig()){
			case 1:
				mMinValue = Integer.parseInt(curAnswer.getmText());
				break;
			case 2:
				mMaxValue = Integer.parseInt(curAnswer.getmText());
				break;
			case 3:
				this.setmCorrectAnswer(Integer.parseInt(curAnswer.getmText()));
				break;
			case 4:
				mDeviation = Float.parseFloat(curAnswer.getmText());
				break;
			case 5:
				if (curAnswer.getmText() == "absolute"){
					mDeviationIsPercent = false;
				} else { // == "percent"
					mDeviationIsPercent = false;
				}
				break;
			default:
				break;
			}
		}
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

	public int getmMinValue() {
		return mMinValue;
	}

	public int getmMaxValue() {
		return mMaxValue;
	}
}
