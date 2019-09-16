package m.vk.j001_loginmvp.presenter;

public interface ILoginPresenter {
    void clear();
    void doLoin(String name,String passwd);
    void setProgressBarVisibility(int visibility);
}
