package m.vk.j001_loginmvp.model;

public interface IUser {
    String getName();
    String getPasswd();
    int checkUserValidity(String name,String passwd);
}
