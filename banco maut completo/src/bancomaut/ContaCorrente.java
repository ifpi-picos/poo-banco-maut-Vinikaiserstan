package bancomaut;

public class ContaCorrente extends Conta {
    private double chequeEspecial;
    private int transferenciasRealizadas;

    public ContaCorrente(int agencia, int numero, double saldo, Cliente cliente, double chequeEspecial) {
        super(agencia, numero, saldo, cliente);
        this.chequeEspecial = chequeEspecial;
        this.transferenciasRealizadas = 0;
    }

    @Override
    public void transfere(double valor, Conta contaDestino) {
        if (saca(valor) > 0) {
            contaDestino.deposita(valor);
            transferenciasRealizadas++;
            if (transferenciasRealizadas > 2) {
                double taxa = valor * 0.1;
                saca(taxa);
            }
            enviarNotificacao("Transferência", valor);
        }
    }
}
