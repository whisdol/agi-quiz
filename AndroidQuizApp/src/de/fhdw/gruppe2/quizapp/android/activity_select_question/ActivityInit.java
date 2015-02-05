// @author Cedric Lüke
package de.fhdw.gruppe2.quizapp.android.activity_select_question;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		mApplicationLogic.processActivityReturnValues(requestCode, resultCode, data);
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		mData.saveDataInBundle(outState);
		super.onSaveInstanceState(outState);
	}
	
}
