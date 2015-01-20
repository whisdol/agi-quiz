// @author Cedric Lüke
package de.fhdw.gruppe2.quizapp.android.activity_question_numeric;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ActivityEventToListenerMapping implements OnClickListener, OnSeekBarChangeListener, TextWatcher {

	private ActivityApplicationLogic mApplicationLogic;
	private ActivityGUI mGUI;
	
	public ActivityEventToListenerMapping (ActivityGUI gui, ActivityApplicationLogic appLogic) {
		this.mGUI = gui;
		this.mApplicationLogic = appLogic;
		
		
		mGUI.getmSeekBarValueEditText().addTextChangedListener(this);
		mGUI.getmSlider().setOnSeekBarChangeListener(this);
		mGUI.getmContinueButton().setOnClickListener(this);
		mGUI.getmExitButton().setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (mGUI.getmContinueButton().getId() == v.getId())
		{
			mApplicationLogic.onContinueButtonClicked();
		}else if (mGUI.getmExitButton().getId() == v.getId())
		{
			mApplicationLogic.onExitButtonClicked();
		}
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub
		if (fromUser)
			mApplicationLogic.onSeekBarValueTextChanged(progress);
		
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		mApplicationLogic.mSeekBarValueEditTextValueChanged(s.toString());
	}
}
