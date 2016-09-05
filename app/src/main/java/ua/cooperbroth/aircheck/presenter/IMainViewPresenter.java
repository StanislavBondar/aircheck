package ua.cooperbroth.aircheck.presenter;

public interface IMainViewPresenter {
    void onGoButtonPressed();
    void onSearchButtonPressed();
    void dataLoad(String text);
    void setQueryText(String text);
    void loadChart(String token);
}