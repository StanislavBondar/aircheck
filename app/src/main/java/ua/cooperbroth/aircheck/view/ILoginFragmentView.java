package ua.cooperbroth.aircheck.view;

/**
 * @author Stas
 * @since 23.04.16.
 */
public interface ILoginFragmentView {
    boolean verifyLogin(String login);
    boolean verifyPass(String pass);
    void showSnackBar(int textResource);
}
