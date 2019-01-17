package always.remember.maple.xuhuang.base;

/**
 * 作者：senon on 2017/12/27 10:10
 * 邮箱：a1083911695@163.com
 */

public abstract class BasePresenter<V extends BaseView>{

    private V mView;

    public V getView(){
        return mView;
    }

    public void attachView(V v){
        mView = v;
    }

    public void detachView(){
        mView = null;
    }
}
