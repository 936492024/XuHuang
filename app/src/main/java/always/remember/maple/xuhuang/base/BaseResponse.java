package always.remember.maple.xuhuang.base;


/**
 * 作者：senon on 2017/12/28 11:19
 * 邮箱：a1083911695@163.com
 */

public class BaseResponse<T> {

    private String msg;
    private int status;   //0 没有互相关注  1 互相关注了
    private String method;
    private boolean success;
    private T data;
    private int count;
    private int support_down;
    private String trade_no;
    private String circle_id;//圈子id
    private String marker;//直播列表查询游标

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public String getCircle_id() {
        return circle_id;
    }

    public void setCircle_id(String circle_id) {
        this.circle_id = circle_id;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSupport_down() {
        return support_down;
    }

    public void setSupport_down(int support_down) {
        this.support_down = support_down;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "BaseResponse{" +
                "msg='" + msg + '\'' +
                ", status=" + status +
                ", success=" + success +
                ", data=" + data +
                ", count=" + count +
                ", support_down=" + support_down +
                ", trade_no='" + trade_no + '\'' +
                '}';
    }
}
