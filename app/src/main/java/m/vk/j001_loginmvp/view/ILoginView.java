package m.vk.j001_loginmvp.view;


import java.util.List;

import m.vk.j001_loginmvp.model.ProductModel;

public interface ILoginView {
    //Presenter ตัวนั้นส่งค่าอะไรไปให้ View ตัวที่ถืออยู่แสดงผล หรือ ให้ View แสดงผล/ทำ อะไรบ้าง
    void onClearText();
    void onLoginResult(Boolean result, int code, List<ProductModel> arrProduct);
    void onSetProgressBarVisibility(int visibility);
}
