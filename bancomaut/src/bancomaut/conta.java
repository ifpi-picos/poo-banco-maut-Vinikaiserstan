package bancomaut;

public class conta {
    private int numeroAgencia;
    private int numeroConta;
    private double saldo;
    private cliente cliente;

    public conta(int numeroAgencia, int numeroConta, double saldo, cliente cliente) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public cliente getCliente() {
        return cliente;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }

    public void transferir(conta contaDestino, double valor) {
        saldo -= valor;
        contaDestino.depositar(valor);
    }
}