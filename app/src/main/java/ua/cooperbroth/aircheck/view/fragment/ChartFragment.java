package ua.cooperbroth.aircheck.view.fragment;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import ua.cooperbroth.aircheck.R;
import ua.cooperbroth.aircheck.dagger.components.DaggerViewComponent;
import ua.cooperbroth.aircheck.dagger.components.DataServiceComponent;
import ua.cooperbroth.aircheck.dagger.components.ViewComponent;
import ua.cooperbroth.aircheck.dagger.module.ViewModule;
import ua.cooperbroth.aircheck.data.model.ChartData;
import ua.cooperbroth.aircheck.presenter.IChartFragmentPresenter;
import ua.cooperbroth.aircheck.view.IChartFragmentView;
import ua.cooperbroth.aircheck.view.chart.BarView;

/**
 * @author Stas
 * @since 21.04.2016.
 */
@SuppressLint("ValidFragment")
public class ChartFragment extends BaseFragment implements IChartFragmentView {

    @Bind(R.id.chart_title)
    TextView mChartTitle;

    @Bind(R.id.chart_unit)
    TextView mChartUnit;

   /* @Bind(R.id.chart_header)
    TextView mHeader;*/

    private ChartData mChartData;

    public static ChartFragment getInstance(ChartData data) {
        return new ChartFragment(data);
    }

    public ChartFragment() {

    }

    @SuppressLint("ValidFragment")
    private ChartFragment(ChartData data) {
        mChartData = data;
    }
    @Inject
    IChartFragmentPresenter mPresenter;

    @Bind(R.id.line_view)
    BarView mLineView;

    @Override
    protected void updateView(View view) {

        mChartTitle.setText(mChartData.getDescription().getQuery());
//        mHeader.setText(mChartData.getDescription().getQuery());
//        mLineView.setDrawDotLine(false); //optional
//        mLineView.setShowPopup(LineView.SHOW_POPUPS_All); //optional
        ArrayList<String> mStrings = new ArrayList<>();
        ArrayList<Integer> mIntegers = new ArrayList<>();
        for (Object string : mChartData.getRows()) {
            mStrings.add(((ArrayList<String>)string).get(0));
            Double mDouble = ((ArrayList<Double>) string).get(1);
            mIntegers.add(mDouble.intValue());
        }

        mChartUnit.setText(mChartData.getFields().get(0).getUnit());
        mLineView.setBottomTextList(mStrings);

        ArrayList<ArrayList<Integer>> mChart = new ArrayList<>();
        mChart.add(mIntegers);
        mLineView.setDataList(mIntegers, 100);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_chart;
    }

    @Override
    protected void setUpComponent(DataServiceComponent component) {
        ViewComponent viewComponent = DaggerViewComponent.builder()
                .dataServiceComponent(component)
                .viewModule(new ViewModule(this))
                .build();

        viewComponent.inject(this);
    }





    @Override
    public void buildChart() {

    }
}
