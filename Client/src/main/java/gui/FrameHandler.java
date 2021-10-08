package gui;

public class FrameHandler {

    private AddDetailsModel addDetailsModel;
    private LoginModel loginModel;
    private RegisterModel registerModel;
    private MainModel mainModel;
    private static FrameHandler instance;

    public static FrameHandler getInstance() {
        if (instance == null) instance = new FrameHandler();
        return instance;
    }

    private FrameHandler() {
    }

    public void initial(){
//        addDetailsModel = new AddDetailsModel();
        loginModel = new LoginModel();
        registerModel = new RegisterModel();
        mainModel = new MainModel();
    }

    public void start(){
        loginModel.setVisible(true);
    }

    public void swapAuth(){
        loginModel.setVisible(false);
        registerModel.setVisible(true);
    }

    public void swapRegister(){
        registerModel.setVisible(false);
        loginModel.setVisible(true);
    }
}
