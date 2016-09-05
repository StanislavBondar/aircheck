package ua.cooperbroth.aircheck.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import ua.cooperbroth.aircheck.app.AircheckApplication;
import ua.cooperbroth.aircheck.dagger.components.DataServiceComponent;
/**
 * @author Stas
 * @since 23.04.16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        setUpComponent(AircheckApplication.getInstance().getDataServiceComponent());
        ButterKnife.bind(this);
    }

    abstract protected void setUpComponent(DataServiceComponent component);

    abstract protected int getLayout();

}