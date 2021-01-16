package ar.com.ada.second.online.maven.view;

import ar.com.ada.second.online.maven.utils.Keyboard;

public class PostView {
    private static PostView postView;

    private PostView(){
    }

    public static PostView getInstance(){
        if (postView == null) postView = new PostView();
        return postView;
    }

    public void showTitlePostModule() {
        System.out.println("#####################################");
        System.out.println("#   Ada Social Network: Posts  #");
        System.out.println("#####################################\n");
    }

    public Integer postMenuSelectOption() {
        System.out.println("Que desea realizar: ");
        System.out.println("| 1 | Crear un post");
        System.out.println("| 2 | Lista de posts");
        System.out.println("| 3 | Editar post");
        System.out.println("| 4 | Eliminar post");
        System.out.println("| 5 | Regresar al menú principal");
        return Keyboard.getInputInteger();

    }
}
