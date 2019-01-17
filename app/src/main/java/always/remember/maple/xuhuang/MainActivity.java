package always.remember.maple.xuhuang;

import android.view.View;
import com.maning.mndialoglibrary.MProgressDialog;
import com.maning.mndialoglibrary.MToast;
import java.util.HashMap;
import always.remember.maple.xuhuang.base.BaseActivity;
import always.remember.maple.xuhuang.base.BaseResponse;
import always.remember.maple.xuhuang.contract.MainContract;
import always.remember.maple.xuhuang.entity.Login;
import always.remember.maple.xuhuang.presenter.MainPresenter;
import always.remember.maple.xuhuang.util.ApkUpDate;
import always.remember.maple.xuhuang.util.CreateMD5;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

public class MainActivity extends BaseActivity<MainContract.View, MainContract.Presenter>
        implements MainContract.View {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainContract.Presenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public MainContract.View createView() {
        return this;
    }

    @Override
    public void init() {

    }


    @Override
    public void result(BaseResponse<Login> data) {
        MProgressDialog.dismissProgress();
    }

    @Override
    public void setMsg(String msg) {
        MToast.makeTextShort(MainActivity.this, "登录成功");
    }


    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }



    @OnClick({R.id.hell, R.id.xiazai})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.hell:
                MProgressDialog.showProgress(MainActivity.this);
                String mobile = "18123318217";
                String password = "123456";
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("mobile", "18123318217");
                hashMap.put("password", "123456");
                hashMap.put("secret", CreateMD5.getMd5(mobile + password + "xfh"));
                getPresenter().Login(hashMap, true, true);
                break;
            case R.id.xiazai:
                ApkUpDate apkUpDate = new ApkUpDate(this);
                apkUpDate.startdownload();
                break;
        }
    }
}
