package m.vk.j001_loginmvp.presenter;

import android.os.Handler;
import android.os.Looper;

import m.vk.j001_loginmvp.model.IUser;
import m.vk.j001_loginmvp.model.UserModel;
import m.vk.j001_loginmvp.view.ILoginView;

public class LoginPresenterCompI implements ILoginPresenter{
    ILoginView iLoginView;
    IUser iUser;
    Handler handler;

    public LoginPresenterCompI(ILoginView iLoginView){
        this.iLoginView = iLoginView;
        initUser();
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLoin(String name, String passwd) {
        //check login to server for you

        final int code = iUser.checkUserValidity(name,passwd);
        final boolean result = (code == 0) ? true : false;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(result,code);
            }
        },5000);
    }

    @Override
    public void setProgressBarVisibility(int visibility) {
        iLoginView.onSetProgressBarVisibility(visibility);
    }

    private void initUser(){
        iUser = new UserModel("admin","1234");
    }

}
