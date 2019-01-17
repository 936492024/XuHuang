package always.remember.maple.xuhuang.contract;

import java.util.HashMap;

import always.remember.maple.xuhuang.base.BasePresenter;
import always.remember.maple.xuhuang.base.BaseResponse;
import always.remember.maple.xuhuang.base.BaseView;
import always.remember.maple.xuhuang.entity.Login;
import io.reactivex.ObservableTransformer;


/**
 * 主页面契约层
 */
public interface MainContract {

    interface View extends BaseView {

        void result(BaseResponse<Login> data);

        void setMsg(String msg);

        <T> ObservableTransformer<T, T> bindLifecycle();

    }

    abstract class Presenter extends BasePresenter<View> {

        public abstract void Login(HashMap<String, String> map, boolean isDialog, boolean cancelable);

    }
}
