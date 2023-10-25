package bancomaut;

public class Conta implements Notificacao{
    private int agencia;
    private int numero;
    private double saldo;
    private Cliente cliente;

    public Conta(int agencia, int numero, double saldo, Cliente cliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void deposita(double valor) {
        saldo += valor;
        enviarNotificacao("Depósito", valor);
    }

    public double saca(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            enviarNotificacao("Saque", valor);
            return valor;
        } else {
            return 0; 
        }
    }

    public void transfere(double valor, Conta contaDestino) {
        if (saca(valor) > 0) {
            contaDestino.deposita(valor);
            enviarNotificacao("Transferência", valor);
        }
    }

    @Override
    public void enviarNotificacao(String operacao, double valor) {
        
        System.out.println("Notificação: Operação " + operacao + ", Valor: " + valor);
    }
}