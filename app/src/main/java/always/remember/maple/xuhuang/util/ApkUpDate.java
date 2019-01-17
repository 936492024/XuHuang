package always.remember.maple.xuhuang.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;

import com.maning.mndialoglibrary.MProgressBarDialog;
import com.maning.mndialoglibrary.MToast;
import com.maning.updatelibrary.InstallUtils;

public class ApkUpDate {

    private Context context;
    private String apkDownloadPath;
    private ProgressToast progressToast;
    private Handler mHandler = new Handler();

    public ApkUpDate(Context context) {
        this.context = context;
    }

    public void startdownload(){
        //下载APK
        InstallUtils.with(context)
                //必须-下载地址
                .setApkUrl("http://hbhz1.sesdf.org/xfh-xfh")
                //非必须-下载保存的文件的完整路径+/name.apk，使用自定义路径需要获取读写权限
//                .setApkPath(Constants.APK_SAVE_PATH)
                //非必须-下载回调
                .setCallBack(new InstallUtils.DownloadCallBack() {
                    @Override
                    public void onStart() {
                        MToast.makeTextShort(context,"下载开始");
                        progressToast= new ProgressToast();
                        progressToast.MProgressBarDialog(context);
                        //下载开始
                    }

                    @Override
                    public void onComplete( String path) {
                        progressToast.MProgressBarDialogstop();
                        apkDownloadPath=path;
                        //下载完成
                        //先判断有没有安装权限---适配8.0
                        //如果不想用封装好的，可以自己去实现8.0适配
                        InstallUtils.checkInstallPermission((Activity) context, new InstallUtils.InstallPermissionCallBack() {
                            @Override
                            public void onGranted() {
                                //去安装APK
                                installApk(apkDownloadPath);
                            }

                            @Override
                            public void onDenied() {
                                //弹出弹框提醒用户
                                AlertDialog alertDialog = new AlertDialog.Builder(context)
                                        .setTitle("温馨提示")
                                        .setMessage("必须授权才能安装APK，请设置允许安装")
                                        .setNegativeButton("取消", null)
                                        .setPositiveButton("设置", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                //打开设置页面
                                                InstallUtils.openInstallPermissionSetting((Activity) context, new InstallUtils.InstallPermissionCallBack() {
                                                    @Override
                                                    public void onGranted() {
                                                        //去安装APK
                                                        installApk(apkDownloadPath);
                                                    }

                                                    @Override
                                                    public void onDenied() {
                                                        //还是不允许咋搞？
                                                        ProgressToast.MToast(context,"不允许安装咋搞？强制更新就退出应用程序吧");
                                                    }
                                                });
                                            }
                                        })
                                        .create();
                                alertDialog.show();
                            }
                        });

                    }

                    @Override
                    public void onLoading(long total, long current) {
                        progressToast.MProgressBarDialogshow("当前进度为:"+((int) (current * 100 / total))+"%", ((int) (current * 100 / total)));
                        //下载中
                    }

                    @Override
                    public void onFail(Exception e) {
                        MToast.makeTextShort(context,"下载失败"+e);
                        //下载失败
                    }

                    @Override
                    public void cancle() {
                        MToast.makeTextShort(context,"下载取消");
                        //下载取消
                    }
                })
                //开始下载
                .startDownload();


    }

    private void installApk(String path) {
        InstallUtils.installAPK((Activity) context, path, new InstallUtils.InstallCallBack() {
            @Override
            public void onSuccess() {
                //onSuccess：表示系统的安装界面被打开
                //防止用户取消安装，在这里可以关闭当前应用，以免出现安装被取消
                ProgressToast.MToast(context,"正在安装程序");
            }

            @Override
            public void onFail(Exception e) {
                ProgressToast.MToast(context,"安装失败");
            }
        });
    }
}
