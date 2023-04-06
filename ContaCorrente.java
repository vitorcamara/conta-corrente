package com.vitorcamara.projetos;

public class ContaCorrente {

	String numeroConta = "123456";
	String senha = "1234";
	double saldo;
	boolean especial;
	double limiteEspecial;
	double valorEspecialUsado;
	double limite;
	boolean podeSacar;
	double saque;

	boolean realizarSaque(double quantiaASacar) { // método com parâmetro
		// verificando se tem saldo na conta
		if (saldo >= quantiaASacar) {
			saldo -= quantiaASacar;
			return true;
		} else {
			// não tem saldo na conta
			if (especial) {
				// verificar se o limite especial tem saldo
				double limite = limiteEspecial + saldo;

				if (limite >= quantiaASacar) {
					saldo -= quantiaASacar;
					return true;
				} else {
					return false;
				}
			} else {
				// nao é especial e não tem saldo suficiente
				return false;
			}
		}
	}

	void depositarDinheiro(double valorDepositado) { //método simples
		saldo += valorDepositado;

	}

	void consultarSaldo() {
		System.out.println("Saldo atual = " + saldo + " reais."); //método simples
	}

	boolean verificarUsoChequeEspecial() {
		return saldo < 0;
	}

}
