package bancomaut;
import java.util.ArrayList;
import java.util.Date;

public class Conta implements Notificacao {
    private int agencia;
    private int numero;
    public double saldo;
    private Cliente cliente;
    private ArrayList<Transacao> transacoes;

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

    public void deposita(double valor) {
        saldo += valor;
        registrarTransacao("Depósito", valor);
        enviarNotificacao("Depósito", valor);
    }

    public double saca(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            registrarTransacao("Saque", valor);
            enviarNotificacao("Saque", valor);
            return valor;
        } else {
            return 0;
        }
    }

    public void transfere(double valor, Conta contaDestino) {
        if (saca(valor) > 0) {
            contaDestino.deposita(valor);
            registrarTransacao("Transferência", valor);
            enviarNotificacao("Transferência", valor);
        }
    }

    private void registrarTransacao(String tipo, double valor) {
        Transacao transacao = new Transacao(new Date(), tipo, valor);
        transacoes.add(transacao);
    }

    public void exibirExtrato() {
        System.out.println("Extrato da conta " + agencia + "-" + numero + " para " + cliente.getNome());
        for (Transacao transacao : transacoes) {
            System.out.println(transacao.getData() + " - " + transacao.getTipo() + " - Valor: " + transacao.getValor());
        }
    }

    @Override
    public void enviarNotificacao(String operacao, double valor) {
        
        System.out.println("Notificação: Operação " + operacao + ", Valor: " + valor);
    }
}
