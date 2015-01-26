package de.fhdw.gruppe2.quizapp.android.questiondata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class QuestionData /* implements Parcelable */ {
	
	// Vorgabe SET: alle Instanzvariablen muessen private sein
	private int mID;
	private String mQuestion;
	private List<AnswerData> mAnswers;
	private int mCorrectAnswer; // maybe remove this property later?
	private int mTime;
	
	
	public QuestionData(int pID, String pQuestion, List<AnswerData> pAnswers, int pCorrectAnswer,int pTime){
		mID = pID;
		mQuestion = pQuestion;
		mAnswers = pAnswers;
		mCorrectAnswer = pCorrectAnswer;
		mTime = pTime;
	}
	
	public int getID(){
		return mID;
	}
		
	public String getQuestion() {
		return mQuestion;
	}

	public List<String> getAnswers() {
		List<String> answerText = new ArrayList<String>();
		for (int i = 0; i < mAnswers.size(); i++){
			answerText.add(mAnswers.get(i).getmText());
		}
		return answerText;
	}

	public int getCorrectAnswer() {
		return mCorrectAnswer;
	}
	
	public void setmCorrectAnswer(int pCorrectAnswer){
		this.mCorrectAnswer = pCorrectAnswer;
	}

	public abstract boolean isCorrectAnswer(int pAnswer);
}