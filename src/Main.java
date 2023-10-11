import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {

        ArrayList<Livro> listaLivro = new ArrayList<>();

        System.out.println("Bem vindo ao sistema de cadastro de Livros!");

        Scanner leitor = new Scanner(System.in);

        String opcao;

        do {
            System.out.println("Escolha uma opção: 1 - Cadastrar Livro / 2 - Listar Livro / 0 - Sair");
            opcao = leitor.nextLine();

            switch (opcao){

                case "1":

                    Livro novoLivro = new Livro();

                    System.out.println("Digite o título do livro: ");
                    novoLivro.tituloLivro = leitor.nextLine();

                    System.out.println("Digite o nome do autor: ");
                    novoLivro.AutorLivro = leitor.nextLine();

                    System.out.println("Digite o local de nascimento do autor: ");
                    novoLivro.localNasc = leitor.nextLine();

                    System.out.println("Digite o preço do livro: ");
                    novoLivro.valorLivro = leitor.nextFloat();

                    System.out.println("Digite a data de lançamento do livro: ");
                    novoLivro.lancamentoLivro = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    Period idade = Period.between(novoLivro.lancamentoLivro, LocalDate.now());

                    if (idade.getYears() >= 5){
                        System.out.println("Idade Válida!");
                    }else{
                        System.out.println("O livro não pode ser cadastrado! (Motivo: Idade mínima é de 5 anos");
                    }

                    listaLivro.add(novoLivro);

                    System.out.println("Cadastrado realizado com sucesso!");

                    break;

                case "2":

                    if (listaLivro.size() > 0){
                        for (Livro cadaLivro : listaLivro){
                            System.out.println("Título do livro: " + cadaLivro.tituloLivro);
                            System.out.println("Nome do(a) autor(a): "+ cadaLivro.AutorLivro);
                            System.out.println("Local de nascimento do(a) autor(a): " + cadaLivro.localNasc);
                            System.out.println("Preço do livro: " + cadaLivro.valorLivro);
                            System.out.println("Data de lançamento do livro: " + cadaLivro.lancamentoLivro);

                            System.out.println();
                            System.out.println("Aperte ENTER para continuar");
                            leitor.nextLine();
                        }
                    }else{
                        System.out.println("Nenhum livro cadastrado!");
                    }
                    break;


                default:
                    System.out.println("Opção inválida!");
                    break;

            }

        }while (!opcao.equals("0"));

    }
}