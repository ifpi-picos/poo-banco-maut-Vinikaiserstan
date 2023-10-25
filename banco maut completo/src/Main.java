import bancomaut.Cliente;
import bancomaut.ContaCorrente;
import bancomaut.ContaPoupanca;
import bancomaut.Endereco;

import java.util.Date;
public class Main {
    public static void main(String[] args) {
        Endereco endereco = new Endereco("Rua ABC", 123, "Bairro X", "Cidade Y", "UF");
        Cliente cliente = new Cliente("12345678901", "João da Silva", new Date(), endereco);

        ContaCorrente contaCorrente = new ContaCorrente(1, 101, 1000.0, cliente, 500.0);
        ContaPoupanca contaPoupanca = new ContaPoupanca(2, 201, 5000.0, cliente, 0.10);

        contaCorrente.transfere(200.0, contaPoupanca);
        contaPoupanca.saca(300.0);
        contaCorrente.deposita(100.0);

        System.out.println("Saldo da conta corrente: " + contaCorrente.getSaldo());
        System.out.println("Saldo da conta poupança: " + contaPoupanca.getSaldo());
    }
}