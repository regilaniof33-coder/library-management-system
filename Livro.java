public class Livro{
    int id;
    String titulo;
    String autor;
    String status;
    String leitor;

    public Livro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.status = "Disponível";
        this.leitor = "";
    }
}