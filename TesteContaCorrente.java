package com.vitorcamara.projetos;

import java.util.Scanner;

public class TesteContaCorrente {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		ContaCorrente conta = new ContaCorrente();

		conta.especial = true;
		conta.limite = 5000;
		conta.saldo = 1000;
		conta.valorEspecialUsado = 0;

		boolean valido = true;
		do {
			System.out.println("Entre com o número da conta (6 dígitos):");
			String numeroConta = scan.next();

			if (numeroConta.equals(conta.numeroConta)) {
				valido = true;
			} else {
				valido = false;
				System.out.println("Número da conta inválido. Tente novamente:");
			}
		} while (!valido);

		do {
			System.out.println("Entre com a senha:");
			String senha = scan.next();

			if (senha.equals(conta.senha)) {
				valido = true;
			} else {
				valido = false;
				System.out.println("Senha inválida. Tente novamente:");
			}

		} while (!valido);

		boolean sair = false;

		do {
			System.out.println("Digite 1 para sacar dinheiro.");
			System.out.println("Digite 2 para depositar dinheiro.");
			System.out.println("Digite 3 para consultar saldo.");
			System.out.println("Digite 4 para verificar uso do cheque especial.");
			int acao = scan.nextInt();

			boolean saqueEfetuado;

			if (acao == 1) {

				System.out.println("Gostaria de sacar quanto?");
				double valorSaque = scan.nextDouble();
				saqueEfetuado = conta.realizarSaque(valorSaque);

				if (saqueEfetuado) {
					System.out.println("Saque efetuado com sucesso!");
					System.out.println("Saldo atual da conta = " + conta.saldo);
				} else {
					System.out.println("Não foi possível realizar saque! Saldo insuficiente!");

				}

				System.out.println(" ");

			} else if (acao == 2) {
				System.out.println("Gostaria de depositar quanto?");
				double valorDeposito = scan.nextDouble();
				conta.depositarDinheiro(valorDeposito);
				conta.consultarSaldo();
				System.out.println(" ");
			}

			else if (acao == 3) {
				conta.consultarSaldo();
				System.out.println(" ");

			}

			else if (acao == 4) {
				if (conta.verificarUsoChequeEspecial()) {
					System.out.println("Está usando cheque especial.");
				} else {
					System.out.println("Não está usando cheque especial!");
				}
				System.out.println(" ");
			}

			System.out.println("Digite 1 para realizar outra ação ou 0 para sair.");
			int resp = scan.nextInt();

			if (resp == 1) {
				sair = false;
			} else {
				System.out.println("Atendimento encerrado.");
				sair = true;
			}

		} while (!sair);

	}
}
