package de.fhdw.gruppe2.quizapp.android.questiondata;

import java.util.Arrays;
import java.util.List;

public abstract class QuestionData /* implements Parcelable */ {
	
	// Vorgabe SET: alle Instanzvariablen muessen private sein
	private int mID;
	private String mQuestion;
	private List<String> mAnswers;
	private int mCorrectAnswer;
	
	
	public QuestionData(int pID, String pQuestion, List<String> pAnswers, int pCorrectAnswer){
		mID = pID;
		mQuestion = pQuestion;
		mAnswers = pAnswers;
		mCorrectAnswer = pCorrectAnswer;
	}
	
	public QuestionData(int pID, String pQuestion, String[] pAnswers, int pCorrectAnswer){
		mID = pID;
		mQuestion = pQuestion;
		mAnswers = Arrays.asList(pAnswers);
		mCorrectAnswer = pCorrectAnswer;
	}
	
	public int getID(){
		return mID;
	}
		
	public String getQuestion() {
		return mQuestion;
	}

	public List<String> getAnswers() {
		return mAnswers;
	}

	public int getCorrectAnswer() {
		return mCorrectAnswer;
	}

	public abstract boolean isCorrectAnswer(int pAnswer);
}