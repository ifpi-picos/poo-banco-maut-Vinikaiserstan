
import bancomaut.cliente;
import bancomaut.conta;
import bancomaut.contaCorrente;
import bancomaut.contaPoupanca;

public class main {
    public static void main(String[] args) {
        cliente cliente = new cliente("João da Silva", "12345678901", "01/01/1990", "Rua A, 123");

        contaCorrente contaCorrente = new contaCorrente(1, 101, 1000.0, cliente, 500.0);
        contaPoupanca contaPoupanca = new contaPoupanca(2, 201, 5000.0, cliente, 0.10);

        contaCorrente.transferir(contaPoupanca, 200.0);
        contaPoupanca.sacar(300.0);
        contaCorrente.depositar(100.0);
        contaPoupanca.calcularRendimento();

        System.out.println("Saldo da conta corrente: " + contaCorrente.getSaldo());
        System.out.println("Saldo da conta poupança: " + contaPoupanca.getSaldo());
    }
}
