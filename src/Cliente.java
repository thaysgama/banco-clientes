public class Cliente implements Autenticador {

    private String nome, sobrenome;
    private String senha;
    private long cpf;
    private boolean status;
    private int numeroCompras;

    public Cliente(String nome, String sobrenome, long cpf, String senha, boolean status) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.senha = senha;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNumeroCompras() {
        return numeroCompras;
    }

    public void setNumeroCompras(int numeroCompras) {
        this.numeroCompras = numeroCompras;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "Nome completo = " + nome + " " + sobrenome +
                ", Senha = '" + senha + '\'' +
                ", Cpf = " + cpf +
                ", Status = " + status +
                ", Compras = "+ getNumeroCompras() +
                '}';
    }


    @Override
    public boolean autentica(String senha) {
        if (!this.senha.equals(senha)) {
            System.out.println("Não autenticado");
            return false;
        } else {
            System.out.println("Autenticado !");
            return true;
        }
    }
}
