package m.vk.j001_loginmvp.view;

public interface ILoginView {
    //View จะให้ทำอะไรบ้าง
    void onClearText();
    void onLoginResult(Boolean result,int code);
    void onSetProgressBarVisibility(int visibility);
}
