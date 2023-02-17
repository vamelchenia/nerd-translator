package com.llcompany.nerdtranslator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

public class ExtendsEditText extends EditText{

    public ExtendsEditText(Context context) {
        super(context);
    }

    public ExtendsEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExtendsEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onKeyPreIme( int key_code, KeyEvent event )
    {
        if ( key_code == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP )
            this.clearFocus();

        return super.onKeyPreIme( key_code, event );
    }
}
