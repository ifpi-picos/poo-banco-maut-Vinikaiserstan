package bancomaut;

public class ContaPoupanca extends  Conta {
    private double rendimento;

    public ContaPoupanca(int agencia, int numero, double saldo, Cliente cliente, double rendimento) {
        super(agencia, numero, saldo, cliente);
        this.rendimento = rendimento;
    }

    @Override
    public void deposita(double valor) {
        double rendimentoCalculado = valor * rendimento;
        super.deposita(valor + rendimentoCalculado);
        enviarNotificacao("Depósito com rendimento", rendimentoCalculado);
    }

    @Override
    public double saca(double valor) {

        double taxa = valor * 0.05;
        double valorSacado = super.saca(valor + taxa);
        if (valorSacado > 0) {
            enviarNotificacao("Saque", valor);
        }
        return valorSacado;
    }
}