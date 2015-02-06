// @ author Cedric Lueke
package de.fhdw.gruppe2.quizapp.android.dbconnection;

public class QSessionQuestion {
	private int mQuestionID;
	private int mQuestionType;
	private int mAnswered;
	
	public QSessionQuestion(int pQuestionID, int pQuestionType,int pAnswered){
		mQuestionID = pQuestionID;
		mQuestionType = pQuestionType;
		mAnswered = pAnswered;
	}

	public int getmQuestionID() {
		return mQuestionID;
	}

	public int getmQuestionType() {
		return mQuestionType;
	}

	public int getmAnswered() {
		return mAnswered;
	}


	public void setmQuestionID(int mQuestionID) {
		this.mQuestionID = mQuestionID;
	}

	public void setmQuestionType(int mQuestionType) {
		this.mQuestionType = mQuestionType;
	}

	public void setmAnswered(int mAnswered) {
		this.mAnswered = mAnswered;
	}
}
