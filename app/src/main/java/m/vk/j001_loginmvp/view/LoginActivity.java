package m.vk.j001_loginmvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import m.vk.j001_loginmvp.R;
import m.vk.j001_loginmvp.model.ProductModel;
import m.vk.j001_loginmvp.presenter.ILoginPresenter;
import m.vk.j001_loginmvp.presenter.LoginPresenterCompI;

public class LoginActivity extends AppCompatActivity implements ILoginView , View.OnClickListener {

    private EditText edUser;
    private EditText edPass;
    private Button btnLogin;
    private Button   btnClear;
    private ILoginPresenter loginPresenter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //find view
        edUser = findViewById(R.id.edUsername);
        edPass = findViewById(R.id.edPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnClear = findViewById(R.id.btnClear);
        progressBar = findViewById(R.id.pbLoading);

        //set listener
        btnLogin.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        //init
        loginPresenter = new LoginPresenterCompI(this);
        loginPresenter.setProgressBarVisibility(View.INVISIBLE);

    }

    @Override
    public void onClearText() {
        edUser.setText("");
        edPass.setText("");
    }

    @Override
    public void onLoginResult(Boolean result, int code, List<ProductModel> arrProduct) {
        loginPresenter.setProgressBarVisibility(View.INVISIBLE);
        btnLogin.setEnabled(true);
        btnClear.setEnabled(true);
        if (result){
            String product = "";
            for (int i = 0; i < arrProduct.size(); i++) {
                if (product.length() > 0){
                    product += "\n";
                }
                product += arrProduct.get(i).getName() + " : " + arrProduct.get(i).getPrice();
            }
            Toast.makeText(this,"Login Success \n" + product,Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Login Fail, code = " + code, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        progressBar.setVisibility(visibility);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnClear:
                loginPresenter.clear();
                break;
            case R.id.btnLogin:
                loginPresenter.setProgressBarVisibility(View.VISIBLE);
                btnLogin.setEnabled(false);
                btnClear.setEnabled(false);
                loginPresenter.doLoin(edUser.getText().toString(), edPass.getText().toString());
                break;
        }
    }
}
