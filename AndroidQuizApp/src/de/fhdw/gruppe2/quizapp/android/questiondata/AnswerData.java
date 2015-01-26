package de.fhdw.gruppe2.quizapp.android.questiondata;

public class AnswerData {
	private int mRichtig;
	private String mText;
	
	
	public AnswerData(){
		this(0, "");
	}
	
	public AnswerData(int mRichtig, String mText) {
		this.mRichtig = mRichtig;
		this.mText = mText;
	}
	
	public AnswerData(String pRichtig, String pText) {
		try {
			this.mRichtig = Integer.parseInt(pRichtig);
		} catch (Exception e) {
			mRichtig = 0;
		}
		this.mText = pText;
	}

	public int getmRichtig() {
		return mRichtig;
	}
	public void setmRichtig(int mRichtig) {
		this.mRichtig = mRichtig;
	}
	public String getmText() {
		return mText;
	}
	public void setmText(String mText) {
		this.mText = mText;
	}
	
	
}
