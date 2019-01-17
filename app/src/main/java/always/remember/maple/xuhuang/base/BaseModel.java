package always.remember.maple.xuhuang.base;

import android.content.Context;

import always.remember.maple.xuhuang.progress.ObserverResponseListener;
import always.remember.maple.xuhuang.progress.ProgressObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * M层父类
 */

public class BaseModel<T> {
    /**
     * 封装线程管理和订阅的过程
     * flag  是否添加progressdialog
     */
    public void subscribe(Context context, final Observable observable, ObserverResponseListener<T> listener,
                          ObservableTransformer<T,T> transformer, boolean isDialog, boolean cancelable) {
        final Observer<T> observer = new ProgressObserver(context, listener, isDialog,cancelable);
        observable.compose(transformer)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void subscribe(Context context, final Observable observable, ObserverResponseListener<T> listener,
                          ObservableTransformer<T,T> transformer) {
        subscribe(context,observable,listener,transformer,true,true);
    }

    public void subscribe(Context context, final Observable observable, ObserverResponseListener<T> listener,
                          boolean isDialog, boolean cancelable) {
        final Observer<T> observer = new ProgressObserver(context, listener, isDialog,cancelable);
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
