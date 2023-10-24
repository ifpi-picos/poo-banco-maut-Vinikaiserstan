package bancomaut;

public class cliente {
    private String nome;
    private String CPF;
    private String dataNascimento;
    private String endereco;
    
    public cliente(String nome, String CPF, String dataNascimento, String endereco) {
        this.nome = nome;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getCPF() {
        return CPF;
    }
    
    public String getDataNascimento() {
        return dataNascimento;
    }
    
    public String getEndereco() {
        return endereco;
    }
}