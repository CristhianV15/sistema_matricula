package controlador.util;

public class Modulo {
    private String pathView;
    private String pathUrl;
    private String titulos;
    private String titulo;
    private String menuItem;

    public Modulo() {
    }

    public Modulo(String pathView, String pathUrl, String titulos, String titulo, String menuItem) {
        this.pathView = pathView;
        this.pathUrl = pathUrl;
        this.titulos = titulos;
        this.titulo = titulo;
        this.titulo = menuItem;
    }   

    public String getPathView() {
        return pathView;
    }

    public void setPathView(String pathView) {
        this.pathView = pathView;
    }

    public String getPathUrl() {
        return pathUrl;
    }

    public void setPathUrl(String pathUrl) {
        this.pathUrl = pathUrl;
    }

    public String getTitulos() {
        return titulos;
    }

    public void setTitulos(String titulos) {
        this.titulos = titulos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(String menuItem) {
        this.menuItem = menuItem;
    }
    
}
