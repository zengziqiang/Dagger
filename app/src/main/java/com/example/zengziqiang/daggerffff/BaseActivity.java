package com.example.zengziqiang.daggerffff;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.zengziqiang.daggerffff.utils.ErrorInterface;

/**
 * @author zengziqiang
 * @e-mail iszengziqiang@163.com
 * @date on 2018/3/26
 * @desc
 */

public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog dialog;
    private PopupWindow popupWindow;
    private LoadingDialog dialog_load;

    protected void showToast(String msg) {
        Toast.makeText(BaseActivity.this, msg, Toast.LENGTH_LONG).show();
    }


    protected void showErrorMsg(Context context, final ViewGroup viewGroup, final ErrorInterface errorInterface) {
        final ViewGroup v_parent = viewGroup;
        final View view_error = LayoutInflater.from(context).inflate(R.layout.layout_error, null);
        Button btn_error = view_error.findViewById(R.id.btn_error);
        btn_error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewGroup.removeView(view_error);
                viewGroup.invalidate();
//                viewGroup.postInvalidate();
                errorInterface.toLoadAgain();
            }
        });
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        System.out.println("几个布局：" + viewGroup.getChildCount());
        viewGroup.addView(view_error, 0, params);

    }


    protected void Loading() {
        dialog_load = new LoadingDialog();
        dialog_load.show(getFragmentManager(), "kkk");

//        CloseDialog();
//        View view_load = LayoutInflater.from(BaseActivity.this).inflate(R.layout.layout_loading, null);
//        popupWindow = new PopupWindow(view_load, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        popupWindow.setOutsideTouchable(false);
//        popupWindow.setFocusable(true);
//        view_load.setFocusable(true);
//        view_load.setFocusableInTouchMode(true);
//        popupWindow.showAtLocation(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
//        view_load.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                System.out.println("点击了返回1111");
//                return true;
//            }
//        });

    }

    protected void CloseDialog() {
//        if (popupWindow != null && popupWindow.isShowing()) {
//            popupWindow.dismiss();
//        }
        dialog_load.dismiss();
    }

    protected void Loading_dialog() {

    }

}
