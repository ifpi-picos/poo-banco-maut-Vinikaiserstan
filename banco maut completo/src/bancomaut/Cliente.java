package bancomaut;
import java.util.Date;
public class Cliente {
    private String cpf;
    private String nome;
    private Date dataNascimento;
    private Endereco endereco;

    public Cliente(String cpf, String nome, Date dataNascimento, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}