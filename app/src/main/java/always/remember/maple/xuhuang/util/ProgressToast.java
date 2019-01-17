package always.remember.maple.xuhuang.util;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;

import com.maning.mndialoglibrary.MProgressBarDialog;
import com.maning.mndialoglibrary.MProgressDialog;
import com.maning.mndialoglibrary.MStatusDialog;
import com.maning.mndialoglibrary.MToast;
import com.maning.mndialoglibrary.config.MDialogConfig;
import com.maning.mndialoglibrary.config.MToastConfig;
import com.maning.mndialoglibrary.listeners.OnDialogDismissListener;

import always.remember.maple.xuhuang.R;

public class ProgressToast {


    public MProgressBarDialog mProgressBarDialog;
    /**
     * MProgressDialog 加载Dialog代码使用
     * @param context
     */
    public static void MProgressDialog(final Context context){
        //默认
        MProgressDialog.showProgress(context);
        //自定义文字
        MProgressDialog.showProgress(context,"自定义文字");
        //不需要文字
        MProgressDialog.showProgress(context,"");

        //自定义背景
        MDialogConfig mDialogConfig = new MDialogConfig.Builder()
                //点击外部是否可以取消
                .isCanceledOnTouchOutside(true)
                //物理返回键可以取消
                .isCancelable(true)
                //全屏背景窗体的颜色
                .setBackgroundWindowColor(context.getResources().getColor(R.color.colorDialogWindowBg))
                //View背景的颜色
                .setBackgroundViewColor(context.getResources().getColor(R.color.colorDialogViewBg))
                //View背景的圆角
                .setCornerRadius(20)
                //View 边框的颜色
                .setStrokeColor(context.getResources().getColor(R.color.colorAccent))
                //View 边框的宽度
                .setStrokeWidth(2)
                //Progress 颜色
                .setProgressColor(context.getResources().getColor(R.color.colorDialogProgressBarColor))
                //Progress 宽度
                .setProgressWidth(3)
                //Progress 内圈颜色
                .setProgressRimColor(Color.YELLOW)
                //Progress 内圈宽度
                .setProgressRimWidth(4)
                //文字的颜色
                .setTextColor(context.getResources().getColor(R.color.colorDialogTextColor))
                //ProgressBar 颜色
                .setProgressColor(Color.GREEN)
                //dialog动画
                .setAnimationID(R.style.animate_dialog_custom)
                //文字的大小：sp
                .setTextSize(15)
                //padding
                .setPadding(40, 10, 40, 10)
                //关闭的监听
                .setOnDialogDismissListener(new OnDialogDismissListener() {
                    @Override
                    public void onDismiss() {
                        MToast.makeTextShort(context,"监听到了ProgressDialog关闭了");
                    }
                })
                .build();
        MProgressDialog.showProgress(context,"数据上传中...",mDialogConfig);

    }

    /**
     * 状态Dialog代码使用
     * @param context
     */
    public static void MStatusDialog(final Context context){
        //默认
        MStatusDialog mStatusDialog = new MStatusDialog(context);
        //显示
        mStatusDialog.show("保存成功", context.getResources().getDrawable(R.drawable.mn_icon_dialog_ok));
        //手动取消
        mStatusDialog.dismiss();

        //自定义
        MDialogConfig mDialogConfig = new MDialogConfig.Builder()
                //全屏背景窗体的颜色
                .setBackgroundWindowColor(context.getResources().getColor(R.color.colorDialogWindowBg))
                //View背景的颜色
                .setBackgroundViewColor(context.getResources().getColor(R.color.colorDialogViewBg2))
                //字体的颜色
                .setTextColor(context.getResources().getColor(R.color.colorAccent))
                //View边框的颜色
                .setStrokeColor(context.getResources().getColor(R.color.white))
                //View边框的宽度
                .setStrokeWidth(2)
                //View圆角大小
                .setCornerRadius(10)
                //dialog动画
                .setAnimationID(R.style.animate_dialog_custom)
                //文字的大小：sp
                .setTextSize(15)
                //padding
                .setPadding(40, 10, 40, 10)
                //图片的宽高dp
                .setImgWidthAndHeight(60, 60)
                //关闭的监听
                .setOnDialogDismissListener(new OnDialogDismissListener() {
                    @Override
                    public void onDismiss() {
                        MToast.makeTextShort(context,"监听到了MStatusDialog关闭了");
                    }
                })
                .build();
        new MStatusDialog(context,mDialogConfig).show("提交数据失败,请重新尝试!", context.getResources().getDrawable(R.mipmap.ic_launcher), 1000);
    }


    /**
     * MToast 吐司代码使用
     * @param context
     */
    public static void MToast (final Context context,String toastcontent){
        MToastConfig config = new MToastConfig.Builder()
                //设置显示的位置
                .setGravity(MToastConfig.MToastGravity.CENTRE)
//                //文字的颜色
//                .setTextColor(context.getResources().getColor(R.color.colorAccent))
//                //背景色
//                .setBackgroundColor(context.getResources().getColor(R.color.colorDialogTest))
//                //背景圆角
//                .setBackgroundCornerRadius(10)
//                //背景边框的颜色
//                .setBackgroundStrokeColor(Color.WHITE)
//                //背景边框的宽度
//                .setBackgroundStrokeWidth(1)
//                //文字的大小：sp
//                .setTextSize(15)
//                //padding
//                .setPadding(40, 10, 40, 10)
//                //图片的宽高dp
//                .setImgWidthAndHeight(60, 60)
                .build();
        //多种方法
        MToast.makeTextShort(context, toastcontent, config);
    }

    /**
     * MProgressBarDialog 进度条Dialog代码使用
     * @param context
     */
    public  void MProgressBarDialog(final Context context){
        //新建一个Dialog
        mProgressBarDialog = new MProgressBarDialog.Builder(context)
                .setStyle(MProgressBarDialog.MProgressBarDialogStyle_Circle)
//                //全屏背景窗体的颜色
//                .setBackgroundWindowColor(context.getResources().getColor(R.color.colorDialogWindowBg))
//                //View背景的颜色
//                .setBackgroundViewColor(context.getResources().getColor(R.color.colorDialogViewBg2))
//                //字体的颜色
//                .setTextColor(context.getResources().getColor(R.color.colorAccent))
//                //View边框的颜色
//                .setStrokeColor(context.getResources().getColor(R.color.white))
//                //View边框的宽度
//                .setStrokeWidth(2)
//                //View圆角大小
//                .setCornerRadius(10)
//                //ProgressBar背景色
//                .setProgressbarBackgroundColor(Color.BLUE)
//                //ProgressBar 颜色
//                .setProgressColor(Color.GREEN)
//                //圆形内圈的宽度
//                .setCircleProgressBarWidth(4)
//                //圆形外圈的宽度
//                .setCircleProgressBarBackgroundWidth(4)
//                //水平进度条Progress圆角
//                .setProgressCornerRadius(0)
//                //水平进度条的高度
//                .setHorizontalProgressBarHeight(10)
//                //dialog动画
//                .setAnimationID(R.style.animate_dialog_custom)
                .build();
    }

    public void MProgressBarDialogshow(String content,int current){
        mProgressBarDialog.showProgress(current,content,true);
    }


    public void MProgressBarDialogstop(){
        //关闭
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mProgressBarDialog.dismiss();
            }
        }, 1000);
    }

}
