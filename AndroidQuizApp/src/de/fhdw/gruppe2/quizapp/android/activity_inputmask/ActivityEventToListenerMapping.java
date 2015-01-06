package de.fhdw.gruppe2.quizapp.android.activity_inputmask;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;

public class ActivityEventToListenerMapping implements OnClickListener, TextWatcher {

	private ActivityApplicationLogic mApplicationLogic;
	private ActivityGUI mGUI;
	
	public ActivityEventToListenerMapping (ActivityGUI gui, ActivityApplicationLogic appLogic) {
		this.mGUI = gui;
		this.mApplicationLogic = appLogic;
		
		mGUI.getConfirmButton().setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		mApplicationLogic.onConfirmButtonClicked();	
	}

	@Override
	public void afterTextChanged(Editable s) {
		mApplicationLogic.onEditTextChanged();
		
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
