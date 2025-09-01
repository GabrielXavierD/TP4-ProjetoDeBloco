import Modelo.Usuario;
import Servico.GerenciadorDeLogin;
import Utilitario.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner entrada = new Scanner(System.in);
        while (true) {
            System.out.println("\n-- MENU --");
            System.out.println("1 - Realizar Cadastro (cria o arquivo .csv, caso não tenha)");
            System.out.println("2 - Realizar Login");
            System.out.println("3 - Sair");
            System.out.print("Digite uma opção: ");
            String opcao = entrada.nextLine();

            switch(opcao){
                case "1":
                    System.out.print("Deseja cadastrar endereço completo? Digite 'S' ou 'N': ");
                    String resposta = entrada.nextLine().trim().toLowerCase();
                    if(resposta.equals("s")){
                        ValidarEndereco.receberEnderecoCompleto();
                    } else {
                        String nome = Utilitario.receberNome();
                        String senha = Utilitario.receberSenha();
                        String tipo = Utilitario.receberTipoUsuario();
                        Usuario usuario = new Usuario(nome, senha, tipo);
                        GerenciadorDeLogin.registrarUsuario(usuario);
                    }
                    break;
                case "2":
                    String nomeLogin = Utilitario.receberNome();
                    String senhaLogin = Utilitario.receberSenha();
                    String tipoLogin = Utilitario.receberTipoUsuario();
                    GerenciadorDeLogin.buscarUsuario(nomeLogin, senhaLogin, tipoLogin);
                    break;
                case "3":
                    System.out.println("Você saiu! Sistema encerrado!");
                    entrada.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Erro: Digite uma opção válida. Escolha 1, 2 ou 3");
            }
        }
    }
}