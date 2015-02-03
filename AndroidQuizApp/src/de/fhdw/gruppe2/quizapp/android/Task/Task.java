package de.fhdw.gruppe2.quizapp.android.Task;

import de.fhdw.gruppe2.quizapp.android.dbconnection.DatabaseConnection;
import android.widget.ProgressBar;

public class Task implements Runnable {
	
	private ProgressBar mBar;
	private int mSessionID;
	private int mQuestionID;
	
	public Task (ProgressBar pBar, int pSessionID, int pQuestionID){
		mBar=pBar;
		mSessionID=pSessionID;
		mQuestionID=pQuestionID;
	}
	
	@Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            final int value = i;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mBar.setProgress(value);

        }
        DatabaseConnection.updateSessionFrage(mSessionID, mQuestionID, 0, "-1");
        //intend zur Session Acticty
        //
        //
        //
	}	
}
