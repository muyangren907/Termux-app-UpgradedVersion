package main.java.com.termux.app.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.termux.R;

import androidx.annotation.NonNull;
import main.java.com.termux.app.TermuxActivity;
import main.java.com.termux.utils.UUtils;

/**
 * @author ZEL
 * @create By ZEL on 2020/10/20 17:05
 **/
public class TextShowDialog extends BaseDialogCentre {
    public TextView start;
    public TextView edit_text;
    public TextShowDialog(@NonNull Context context) {
        super(context);
    }

    public TextShowDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    void initViewDialog(View mView) {
        start = mView.findViewById(R.id.start);
        edit_text = mView.findViewById(R.id.edit_text);





        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @Override
    int getContentView() {
        return R.layout.dialog_text_show;
    }
}
