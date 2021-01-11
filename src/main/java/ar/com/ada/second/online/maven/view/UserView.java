package ar.com.ada.second.online.maven.view;

import ar.com.ada.second.online.maven.model.dao.UserDAO;
import ar.com.ada.second.online.maven.model.dto.UserDTO;
import ar.com.ada.second.online.maven.utils.CommandLineTable;
import ar.com.ada.second.online.maven.utils.Keyboard;

import java.util.HashMap;
import java.util.List;

public class UserView {
    private static UserView userView;

    private UserView() {
    }

    public static UserView getInstance() {
        if (userView == null) userView = new UserView();
        return userView;
    }

    // Ada Social Network: Usuarios => showTitleUsermodule
    public void showTitleUserModule() {
        System.out.println("#####################################");
        System.out.println("#   Ada Social Network: Usuarios  #");
        System.out.println("#####################################\n");
    }
    
    // userMenuSelectOption: Que desea realizar, 1 Crear Usuario, 5 Regresar al menú principal
    public Integer userMenuSelectOption() {
        System.out.println("Que desea realizar: ");
        System.out.println("| 1 | Crear usuario");
        System.out.println("| 2 | Lista de usuarios");
        System.out.println("| 5 | Regresar al menú principal");
        return Keyboard.getInputInteger();

    }

    // HashMap<String, String> getDataNewUser (capturar info que introduzca el usuario y la va a guardar en un mapa
    public HashMap<String, String> getDataNewUser() {
        System.out.println("#####################################");
        System.out.println("#   Ada Social Network: Nuevo Usuario  #");
        System.out.println("#####################################\n");

        HashMap<String, String> data = new HashMap<>();

        System.out.println("Ingrese el nuevo nickname ");
//        String nickname = Keyboard.getInputString();
//        data.put("nickname", nickname);
        data.put("nickname", Keyboard.getInputString());

        System.out.println("Ingrese el nuevo email ");
        data.put("email", Keyboard.getInputEmail());

        return data;
    }

    public void existingUser(){
        System.out.println("Oops!! el usuario ya existe en la base de datos");
        Keyboard.pressEnterKeyToContinue();
    }

    public void showNewUser(UserDTO dto) {
        System.out.println("\nUsuario creado con exito:");
        System.out.printf("id: %d", dto.getId());
        System.out.printf("\nEmail: %s", dto.getEmail());
        System.out.printf("\nNickname: %s\n\n", dto.getNickname());
    }

    public String printUsersPerPage(List<UserDAO> users, List<String> paginator, String optionSelectEditOrDelete, boolean isHeaderShown) {
        if (isHeaderShown){
            System.out.println("#####################################");
            System.out.println("#   Ada Social Network: Lista de usuarios  #");
            System.out.println("#####################################\n");
        }

        CommandLineTable st = new CommandLineTable();
        st.setShowVerticalLines(true);

        st.setHeaders("ID", "Nickname", "Email");
        users.forEach(userDAO -> {
            st.addRow(
                    userDAO.getId().toString(),
                    userDAO.getNickname(),
                    userDAO.getEmail()
            );
        });
        st.print();

        if (optionSelectEditOrDelete != null && !optionSelectEditOrDelete.isEmpty())
            paginator.set(paginator.size() - 2, optionSelectEditOrDelete);

        System.out.println("\n+----------------------------------------+");
        paginator.forEach(page -> System.out.print(page + " "));
        System.out.println("\n+----------------------------------------+");


        return Keyboard.getInputString();
    }

    public void usersListNotFound() {
        System.out.println("No hay usuarios registrados en la base de datos");
        Keyboard.pressEnterKeyToContinue();
    }
}

