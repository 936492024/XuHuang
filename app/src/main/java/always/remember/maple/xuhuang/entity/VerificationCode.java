package always.remember.maple.xuhuang.entity;

/**
 * Created by asus on 2018/3/2.
 */

public class VerificationCode {
    /**
     * success : true
     * msg : 提交成功
     * captcha : 7818
     * mobile : 18380460190
     */

    private boolean success;
    private String msg;
    private int captcha;
    private String mobile;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCaptcha() {
        return captcha;
    }

    public void setCaptcha(int captcha) {
        this.captcha = captcha;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
