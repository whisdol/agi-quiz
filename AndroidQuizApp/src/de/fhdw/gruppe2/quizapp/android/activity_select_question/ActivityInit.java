// @author Cedric Lüke
package de.fhdw.gruppe2.quizapp.android.activity_select_question;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class ActivityInit extends Activity {

	private ActivityData mData;
	private ActivityApplicationLogic mApplicationLogic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData(savedInstanceState);
		initApplicationLogic();
	}

	private void initData(Bundle savedInstanceState) {
		mData = new ActivityData(savedInstanceState, this);
	}

	private void initApplicationLogic() {
		mApplicationLogic = new ActivityApplicationLogic(mData);
	}

	public Context getContext(){
		return this;
	}
	
}
