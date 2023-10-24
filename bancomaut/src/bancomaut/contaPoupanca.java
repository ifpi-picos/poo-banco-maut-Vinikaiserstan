package bancomaut;

public class contaPoupanca extends conta {
    private double taxaTransferencia;
    private double taxaSaque;
    private double rendimento;

    public contaPoupanca(int numeroAgencia, int numeroConta, double saldo, cliente cliente, double rendimento) {
        super(numeroAgencia, numeroConta, saldo, cliente);
        this.taxaTransferencia = 0.10;
        this.taxaSaque = 0.05;
        this.rendimento = rendimento;
    }

    @Override
    public void transferir(conta contaDestino, double valor) {
        double taxa = valor * taxaTransferencia;
        super.sacar(taxa);
        contaDestino.depositar(valor - taxa);
    }

    public void sacar(double valor) {
        double taxa = valor * taxaSaque;
        super.sacar(valor + taxa);
    }

    public void calcularRendimento() {
        double rendimentoAtual = getSaldo() * rendimento;
        depositar(rendimentoAtual);
    }
}
