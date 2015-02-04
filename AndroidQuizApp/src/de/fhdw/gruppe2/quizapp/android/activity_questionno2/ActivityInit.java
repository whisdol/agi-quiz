// @author Alexander Frese
 
package de.fhdw.gruppe2.quizapp.android.activity_questionno2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class ActivityInit extends Activity {

	private ActivityData mData;
	private ActivityGUI mGUI;
	private ActivityApplicationLogic mApplicationLogic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData(savedInstanceState);
		initGUI();
		initApplicationLogic();
		initEventToListenerMapping();
	}

	private void initData(Bundle savedInstanceState) {
		mData = new ActivityData(savedInstanceState, this);
	}
	
	private void initGUI() {
		mGUI = new ActivityGUI(this);
	}

	private void initApplicationLogic() {
		mApplicationLogic = new ActivityApplicationLogic(mData, mGUI);
	}
	
	private void initEventToListenerMapping() {
		new ActivityEventToListenerMapping(mGUI, mApplicationLogic);
	}

	public Context getContext() {
		return this;
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		mData.saveDataInBundle(outState);
		super.onSaveInstanceState(outState);
	}
	
}
