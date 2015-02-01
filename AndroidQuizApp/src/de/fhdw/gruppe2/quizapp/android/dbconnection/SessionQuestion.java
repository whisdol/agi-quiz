package de.fhdw.gruppe2.quizapp.android.dbconnection;

public class SessionQuestion {
	private int mQuestionID;
	private int mQuestionType;
	
	public SessionQuestion(int pQuestionID, int pQuestionType){
		mQuestionID = pQuestionID;
		mQuestionType = pQuestionType;
	}

	public int getmQuestionID() {
		return mQuestionID;
	}

	public int getmQuestionType() {
		return mQuestionType;
	}

	public void setmQuestionID(int mQuestionID) {
		this.mQuestionID = mQuestionID;
	}

	public void setmQuestionType(int mQuestionType) {
		this.mQuestionType = mQuestionType;
	}
}
