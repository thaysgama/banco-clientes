import java.util.*;

public class TestaCompra {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Lista com 10 clientes
        Cliente a = new Cliente("Xuxa", "Meneghel", 1, "abc", true);
        a.setNumeroCompras(5);
        Cliente b = new Cliente("Luciano", "Huck", 2, "abc", true);
        b.setNumeroCompras(10);
        Cliente c = new Cliente("Camila", "Pitanga", 3, "abc", true);
        c.setNumeroCompras(1);
        Cliente d = new Cliente("Rodrigo", "Hilbert", 4, "abc", true);
        d.setNumeroCompras(22);
        Cliente e = new Cliente("Wagner", "Moura", 5, "abc", true);
        e.setNumeroCompras(16);
        Cliente f = new Cliente("Renata", "Sorrah", 6, "abc", true);
        f.setNumeroCompras(35);
        Cliente g = new Cliente("Rodrigo", "Lombardi", 7, "abc", true);
        g.setNumeroCompras(9);
        Cliente h = new Cliente("Adriana", "Esteves", 8, "abc", true);
        h.setNumeroCompras(31);
        Cliente i = new Cliente("Lazaro", "Ramos", 9, "abc", true);
        i.setNumeroCompras(25);
        Cliente j = new Cliente("Tais", "Araujo", 10, "abc", true);
        j.setNumeroCompras(40);
        List<Cliente> listaClientes = Arrays.asList(a, b, c, d, e, f, g, h, i, j);

        MostraCliente mc = new MostraCliente();
        listaClientes.forEach(mc);

        String input;
        do {
            Optional<Cliente> streamMax = listaClientes
                    .stream()
                    .max(Comparator.comparing(Cliente::getNumeroCompras));

            Optional<Cliente> streamMin = listaClientes
                    .stream()
                    .min(Comparator.comparing(Cliente::getNumeroCompras));

            int sum = listaClientes
                    .stream()
                    .mapToInt(cli -> cli.getNumeroCompras())
                    .sum();

            System.out.println();
            System.out.println("Qual foi o cliente que fez mais compras?");
            System.out.println(streamMax.get().getNome());
            System.out.println("Qual foi o cliente que fez menos compras?");
            System.out.println(streamMin.get().getNome());
            System.out.println("Qual a média de compras dos clientes da lista?");
            System.out.println(sum / listaClientes.size());
            System.out.println("Deseja adicionar compras a algum cliente? (Digite 'S' para sim e 'N' para Não))");
            input = sc.nextLine();
            switch (input) {
                case "s":
                case "S":
                    System.out.println("Digite o cpf do cliente:");
                    Long clienteCpf = sc.nextLong();
                    sc.nextLine();
                    Cliente clienteSelecionado = null;
                    for (Cliente cliente : listaClientes) {
                        if (Objects.equals(cliente.getCpf(), clienteCpf)) {
                            clienteSelecionado = cliente;
                        }
                    }
                    if (clienteSelecionado == null){
                        System.out.println("Cliente invalido");
                        break;
                    } else {
                        System.out.println("Cliente selecionado: "+clienteSelecionado);
                        System.out.println("Quantas compras deseja adicionar?");
                        Integer comprasAdicionais = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Digite a senha:");
                        String tentativaSenha = sc.nextLine();
                        if (clienteSelecionado.autentica(tentativaSenha)) {
                            clienteSelecionado.setNumeroCompras(clienteSelecionado.getNumeroCompras() + comprasAdicionais);
                            System.out.println("Compras adicionadas com sucesso");
                            listaClientes.forEach(mc);
                        } else {
                            System.out.println("Verifique sua senha!");
                        }
                    } break;
                case "N":
                case "n":
                    System.out.println("Programa finalizado. Até Logo.");
                    break;
            }
        } while (!input.equalsIgnoreCase("n"));
    }
}
