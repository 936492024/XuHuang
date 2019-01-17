package always.remember.maple.xuhuang.presenter;

import android.content.Context;

import com.maning.mndialoglibrary.MToast;

import java.util.HashMap;

import always.remember.maple.xuhuang.base.BaseResponse;
import always.remember.maple.xuhuang.contract.MainContract;
import always.remember.maple.xuhuang.entity.Login;
import always.remember.maple.xuhuang.model.LoginModel;
import always.remember.maple.xuhuang.progress.ObserverResponseListener;
import always.remember.maple.xuhuang.util.ExceptionHandle;

/**
 * 主页面P层
 */
public class MainPresenter extends MainContract.Presenter {

    private LoginModel model;
    private Context context;

    public MainPresenter(Context context) {
        this.model = new LoginModel();
        this.context = context;
    }

    @Override
    public void Login(HashMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.login(context, map, isDialog, cancelable, getView().bindLifecycle(),new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                if(getView() != null){
                    BaseResponse<Login> BaseResponse = (BaseResponse<Login>) o;
                    if(BaseResponse.isSuccess()){
                        getView().result(BaseResponse);
                    }else {
                        getView().setMsg(BaseResponse.getMsg());
                    }
                }
            }
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if(getView() != null){
                   MToast.makeTextShort(context,ExceptionHandle.handleException(e).message);
                }
            }
        });
    }

}
