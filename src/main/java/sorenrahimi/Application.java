package sorenrahimi;

import sorenrahimi.dao.CatalogoDAO;
import sorenrahimi.dao.PrestitiDAO;
import sorenrahimi.entities.Libro;

public class Application {

    public static void main(String[] args) {
        CatalogoDAO catalogoDAO = new CatalogoDAO();
        PrestitiDAO prestitiDAO = new PrestitiDAO();

        Libro libro = new Libro();
        libro.setISBN("956-2-13-134520-0");
        libro.setTitolo("Il cacciatore ");

        ;
    }
}
