package bancomaut;

public class contaCorrente extends conta {
    private double chequeEspecial;
    private int transferenciasRealizadas;

    public contaCorrente(int numeroAgencia, int numeroConta, double saldo, cliente cliente, double chequeEspecial) {
        super(numeroAgencia, numeroConta, saldo, cliente);
        this.chequeEspecial = chequeEspecial;
        this.transferenciasRealizadas = 0;
    }

    @Override
    public void transferir(conta contaDestino, double valor) {
        if (transferenciasRealizadas < 2) {
            super.transferir(contaDestino, valor);
            transferenciasRealizadas++;
        } else {
            double taxa = valor * 0.10;
            super.sacar(taxa);
            contaDestino.depositar(valor - taxa);
        }
    }
}
