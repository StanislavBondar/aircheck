package ua.cooperbroth.aircheck.presenter.impl;

import ua.cooperbroth.aircheck.presenter.IChartFragmentPresenter;
import ua.cooperbroth.aircheck.view.IChartFragmentView;

/**
 * @author Stas
 * @since 23.04.16.
 */
public class ChartFragmentPresenter implements IChartFragmentPresenter {

    IChartFragmentView mView;

    public ChartFragmentPresenter(IChartFragmentView view) {
        mView = view;
    }

}
