package m.vk.j001_loginmvp.presenter;

import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.List;

import m.vk.j001_loginmvp.model.ProductModel;
import m.vk.j001_loginmvp.view.ILoginView;

public class LoginPresenterCompI implements ILoginPresenter{
    ILoginView iLoginView;
    Handler handler;

    public LoginPresenterCompI(ILoginView iLoginView){
        this.iLoginView = iLoginView;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLoin(String name, String passwd) {
        //check login to server for you

        final int code = (((name.trim().equals("admin")) && (passwd.trim().equals("1234"))) ? 0 : -1);
        final boolean result = (code == 0) ? true : false;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //add product to model and send for you
                List<ProductModel> arrProduct = new ArrayList<>();
                if (result){
                    arrProduct.add(new ProductModel("Android",25000));
                    arrProduct.add(new ProductModel("IOS",35000));
                    arrProduct.add(new ProductModel("Window Phone",20000));
                }
                iLoginView.onLoginResult(result,code,arrProduct);
            }
        },5000);
    }

    @Override
    public void setProgressBarVisibility(int visibility) {
        iLoginView.onSetProgressBarVisibility(visibility);
    }
}
