package com.example.zengziqiang.daggerffff;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author zengziqiang
 * @e-mail iszengziqiang@163.com
 * @date on 2018/3/29
 * @desc
 */

public class LoadingDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialog_load = new Dialog(getActivity(), R.style.AlertDialogStyle);

        View view_load = LayoutInflater.from(getActivity()).inflate(R.layout.layout_loading, null);

        dialog_load.addContentView(view_load, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        dialog_load.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {

                System.out.println("执行了返回操作");
                if (keyCode == KeyEvent.KEYCODE_BACK) {

                    if (dialog_load != null && dialog_load.isShowing()) {
                        dialog_load.dismiss();
                        getActivity().finish();
                    }
                }

                return false;
            }
        });

        return dialog_load;
    }
}
