import java.util.Scanner;

public class Main{
    Scanner input = new Scanner(System.in);
    void main() {
        int tamVetor = 100;
        int qtdLivro = 0;
        int qtdLeitor = 0;
        int opcao;

        Livro [] livros = new Livro[tamVetor];
        Leitor [] leitores = new Leitor[tamVetor];

        do {
            imprimirMenu();
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao){
                case 1:
                    System.out.println("CADASTRAR LIVRO");
                    livros[qtdLivro] = cadastrarLivro();
                    qtdLivro ++;
                    break;
                case 2:
                    System.out.println("CADASTRAR LEITOR");
                    leitores[qtdLeitor] = cadastrarLeitor();
                    qtdLeitor ++;
                    break;
                case 3:
                    System.out.println("CONSULTAR LIVRO");
                    consultarLivros(livros, qtdLivro);
                    break;
                case 4:
                    System.out.println("CONSULTAR LEITOR");
                    consultarLeitores(leitores, qtdLeitor);
                    break;
                case 5:
                    System.out.println("REALIZAR EMPRÉSTIMO");
                    realizarEmprestimo(livros, qtdLivro);
                    break;
                case 6:
                    System.out.println("REALIZAR DEVOLUÇÃO");
                    realizarDevolucao(livros, qtdLivro);
                    break;
                case 7:
                    System.out.println("CONSULTAR LIVROS DISPONÍVEIS");
                    consultarDisponibilidade(livros, qtdLivro);
                    break;
                case 8:
                    System.out.println("ENCERRANDO PROGRAMA...");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }

        }
        
        while (opcao != 8);
        input.close();
    }
        
    void imprimirMenu(){
        System.out.println("MENU DE OPÇÕES");
        System.out.println("1 - Cadastrar Livro");
        System.out.println("2 - Cadastrar Leitor");
        System.out.println("3 - Consultar Livro");
        System.out.println("4 - Consultar Leitor");
        System.out.println("5 - Realizar Empréstimo");
        System.out.println("6 - Realizar Devolução");
        System.out.println("7 - Controlar Livros Disponíveis");
        System.out.println("8 - Encerrar Programa");
    }

    Livro cadastrarLivro(){
        System.out.println("Digite o id do livro: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Digite o titulo do livro:");
        String titulo = input.nextLine();
        System.out.println("Digite o autor do livro: ");
        String autor = input.nextLine();
        return new Livro(id, titulo, autor);
    }

    Leitor cadastrarLeitor(){
        System.out.println("Digite o id do leitor: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Digite o nome do leitor: ");
        String nome = input.nextLine();
        return new Leitor(id, nome);
    }

    void consultarLivros(Livro [] livros, int qtdLivro){
        System.out.println("Digite o id do livro: ");
        int id = input.nextInt();
        input.nextLine();
        boolean encontrado = false;

        for (int i = 0; i <qtdLivro; i++){
            if (livros[i].id == id) {                
                System.out.println("ID: " + livros[i].id);
                System.out.println("Título: " + livros[i].titulo);
                System.out.println("Autor: " + livros[i].autor);
                System.out.println("Status: " + livros[i].status);

                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Livro não encontrado!");
        }
    }

    void consultarLeitores(Leitor [] leitores, int qtdLeitor){
        System.out.println("Digite o id do leitor: ");
        int id = input.nextInt();
        input.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < qtdLeitor; i ++){
            if (leitores[i].id == id){
                System.out.println("ID: " + leitores[i].id);
                System.out.println("Nome: " + leitores[i].nome);
                encontrado = true;
            }
        }
            if (!encontrado){
                System.out.println("Leitor não encontrado!");
        }
    }

    void realizarEmprestimo(Livro [] livros, int qtdLivro){
        System.out.println("Digite o id do livro: ");
        int id = input.nextInt();
        input.nextLine();

        for (int i = 0; i < qtdLivro; i ++){
            if (livros[i].id == id){
                if (livros[i].status.equals("Disponível")){
                    System.out.println("Digite o nome do leitor: ");

                    String leitor = input.nextLine();

                    livros[i].status = "Emprestado";
                    livros[i].leitor = leitor;

                    System.out.println("Empréstimo realizado com sucesso!");
                }
            
            else{
                System.out.println("O livro não está disponível");
            }
            

            return;

            
            }
        }

        System.out.println("Livro não encontrado");
    }

    void realizarDevolucao(Livro [] livros, int qtdLivro){
        System.out.println("Digite o id do livro: ");
        int id = input.nextInt();
        input.nextLine();

        for (int i = 0; i < qtdLivro; i ++){
            if (livros[i].id == id){
                if (livros[i].status.equals("Emprestado")){

                    livros[i].status = "Disponível";
                    livros[i].leitor = "";

                    System.out.println("Devolução realizada com sucesso!");

                }
            else {
                System.out.println("O livro não está emprestado!");
            }

            return;
            }
        }

        System.out.println("Livro não encontrado!");

    }
    
    void consultarDisponibilidade(Livro [] livros, int qtdLivro){
        for (int i = 0; i < qtdLivro; i ++){
            if (livros[i].status.equals("Disponível")){
                System.out.println("ID: " + livros[i].id);
                System.out.println("Título: " + livros[i].titulo);
                System.out.println("Autor: " + livros[i].autor);
            }
        }
    }
}