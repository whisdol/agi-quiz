package de.fhdw.gruppe2.quizapp.android.dbconnection;

import java.util.List;

public class Session {
	private int mSessionID;
	private List<SessionQuestion> mQuestions;
	
	public Session(int pSessionID, List<SessionQuestion> pQuestions){
		mSessionID = pSessionID;
		mQuestions = pQuestions;
	}
	
	public int getmSessionID() {
		return mSessionID;
	}

	public List<SessionQuestion> getmQuestions() {
		return mQuestions;
	}

	public void setmSessionID(int mSessionID) {
		this.mSessionID = mSessionID;
	}

	public void setmQuestions(List<SessionQuestion> mQuestions) {
		this.mQuestions = mQuestions;
	}
	
	public void addQuestion(SessionQuestion pQuestion){
		mQuestions.add(pQuestion);
	}
	
	public SessionQuestion getAndRemoveQuestion(){
		SessionQuestion retQuestion = null;
		if (mQuestions.size() > 0) {
			retQuestion = mQuestions.get(0);
			mQuestions.remove(0);
		}
		return retQuestion;
	} 
}
