package de.fhdw.gruppe2.quizapp.android.dbconnection;

import java.util.List;

public class QSession {
	private int mSessionID;
	private List<QSessionQuestion> mQuestions;
	
	public QSession(int pSessionID, List<QSessionQuestion> pQuestions){
		mSessionID = pSessionID;
		mQuestions = pQuestions;
	}
	
	public int getmSessionID() {
		return mSessionID;
	}

	public List<QSessionQuestion> getmQuestions() {
		return mQuestions;
	}

	public void setmSessionID(int mSessionID) {
		this.mSessionID = mSessionID;
	}

	public void setmQuestions(List<QSessionQuestion> mQuestions) {
		this.mQuestions = mQuestions;
	}
	
	public void addQuestion(QSessionQuestion pQuestion){
		mQuestions.add(pQuestion);
	}
	
	public QSessionQuestion getAndRemoveQuestion(){
		QSessionQuestion retQuestion = null;
		if (mQuestions.size() > 0) {
			retQuestion = mQuestions.get(0);
			mQuestions.remove(0);
		}
		return retQuestion;
	}
	
	public void RemoveAnsweredQuestions()
	{
		for(int i = 0;i<mQuestions.size();i++)
		{
			if(mQuestions.get(i).getmAnswered() != 0)
			{
				mQuestions.remove(i);
			}
		}
	}
}
