package ar.com.ada.second.online.maven.controller;

import ar.com.ada.second.online.maven.model.dto.UserDTO;
import ar.com.ada.second.online.maven.view.MainView;
import ar.com.ada.second.online.maven.view.UserView;

import java.util.HashMap;

public class UserController {
    private static UserController userController;
    private MainView mainView = MainView.getInstance();
    private UserView userView = UserView.getInstance();


    private UserController() {
    }

    public static UserController getInstance() {
        if (userController == null) userController = new UserController();
        return userController;
    }

    // init: showTitleUserModule => while =>
    // userMenuSelectOption
    // 1 createNewUser,
    // 5 showTitleReturnMenu (MainView)
    public void init() {
        boolean shouldItStay = true;
        userView.showTitleUserModule();

        while (shouldItStay) {
            Integer option = userView.userMenuSelectOption();
            switch (option) {
                case 1:
                    createNewUser();
                    break;
                case 5:
                    shouldItStay = false;
                    mainView.showTitleReturnMenu();
                    break;
                default:
                    mainView.invalidOption();
            }
        }

    }

    // createNewUser: getDataNewUser => new UserDTO
    private void createNewUser(){
        HashMap<String, String> dataNewUser = userView.getDataNewUser();
//         1ra
//        String nickname = dataNewUser.get("nickname");
//        String email = dataNewUser.get("email");
//        new UserDTO(nickname, email);

//        2da A
        String nickname = dataNewUser.get("nickname");
        String email = dataNewUser.get("email");

        UserDTO userDTO = new UserDTO();
        userDTO.setNickname(nickname);
        userDTO.setEmail(email);
//        2da B
//

    }


}
