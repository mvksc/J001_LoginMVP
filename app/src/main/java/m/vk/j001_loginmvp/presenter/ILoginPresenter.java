package m.vk.j001_loginmvp.presenter;

public interface ILoginPresenter {
    //เพื่อให้ View ตัวนั้นสามารถสั่งให้ Presenter ที่ถืออยู่ทำอะไรเมื่อเกิด Event ขึ้น หรือให้ Presenter อะไรบ้าง
    void clear();
    void doLoin(String name,String passwd);
    void setProgressBarVisibility(int visibility);
}
