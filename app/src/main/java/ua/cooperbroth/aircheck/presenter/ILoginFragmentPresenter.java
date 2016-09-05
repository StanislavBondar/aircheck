package ua.cooperbroth.aircheck.presenter;

/**
 * @author Stas
 * @since 23.04.16.
 */
public interface ILoginFragmentPresenter {
    void onLoginPressed(String login, String pass);
    boolean loginRegex(String login);
    boolean passRegex(String pass);
}
