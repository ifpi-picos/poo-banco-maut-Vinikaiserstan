import java.util.ArrayList;
import java.util.List;

class Cliente {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String endereco;
    private List<Conta> contas;

    public Cliente(String nome, String cpf, String dataNascimento, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public List<Conta> getContas() {
        return contas;
    }

}

class Conta {
    private final int agencia;
    private final int numero;
    private double saldo;
    private Cliente cliente;
    private List<Transacao> transacoes;

    public Conta(int agencia, int numero, double saldo, Cliente cliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
        this.transacoes = new ArrayList<>();
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        transacoes.add(new Transacao("Depósito", valor));
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            transacoes.add(new Transacao("Saque", -valor));
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void transferir(Conta destino, double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            destino.depositar(valor);
            transacoes.add(new Transacao("Transferência para conta " + destino.getNumero(), -valor));
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public List<Transacao> getExtrato() {
        return transacoes;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

}

class Transacao {
    private String descricao;
    private double valor;

    public Transacao(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
}

public class BancoMautApp {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("João", "123.456.789-00", "01/01/1990", "Rua ABC, 123");
        Conta conta = new Conta(1, 1001, 1000.0, cliente);
        conta.depositar(500.0);
        conta.sacar(200.0);
        System.out.println("Saldo da conta: " + conta.getSaldo());
        System.out.println("Extrato da conta:");
        List<Transacao> extrato = conta.getExtrato();
        for (Transacao transacao : extrato) {
            System.out.println(transacao.getDescricao() + ": " + transacao.getValor());
        }
    }
}
