package de.fhdw.gruppe2.quizapp.android.questiondata;

import java.util.Arrays;
import java.util.List;

public abstract class QuestionData {
	
	// Vorgabe SET: alle Instanzvariablen müssen private sein
	private String mQuestion;
	private List<String> mAnswers;
	private int mCorrectAnswer;
	
	public QuestionData(String pQuestion, List<String> pAnswers, int pCorrectAnswer){
		mQuestion = pQuestion;
		mAnswers = pAnswers;
		mCorrectAnswer = pCorrectAnswer;
	}
	
	public QuestionData(String pQuestion, String[] pAnswers, int pCorrectAnswer){
		mQuestion = pQuestion;
		mAnswers = Arrays.asList(pAnswers);
		mCorrectAnswer = pCorrectAnswer;
	}
		
	protected String getQuestion() {
		return mQuestion;
	}

	protected List<String> getAnswers() {
		return mAnswers;
	}

	protected int getCorrectAnswer() {
		return mCorrectAnswer;
	}

	public abstract boolean isCorrectAnswer(int pAnswer);
	
	
	

}
