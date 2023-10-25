import bancomaut.Cliente;
import bancomaut.ContaCorrente;
import bancomaut.ContaPoupanca;
import bancomaut.Endereco;
import bancomaut.Conta;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Endereco endereco = new Endereco("Rua Vou Surta Com Esse Trabalho", 123, "Bairro A", "Cidade B", "UF");
        Cliente cliente = new Cliente("12345678901", "Vinicius Neiva", new Date(), endereco);

        ContaCorrente contaCorrente = new ContaCorrente(1, 101, 1000.0, cliente, 500.0);
        ContaPoupanca contaPoupanca = new ContaPoupanca(2, 202, 1500.0, cliente, 0.10);

        contaCorrente.deposita(500.0);
        contaCorrente.saca(200.0);
        contaCorrente.transfere(300.0, contaPoupanca);

        contaPoupanca.deposita(1000.0);
        contaPoupanca.saca(50.0);

        System.out.println("Extrato da Conta Corrente:");
        contaCorrente.exibirExtrato();

        System.out.println("Extrato da Conta Poupança:");
        contaPoupanca.exibirExtrato();
    }
}
