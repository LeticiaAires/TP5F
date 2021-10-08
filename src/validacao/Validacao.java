package validacao;

import java.util.InputMismatchException;

/**
 * Verifica se os dados fornecidos estão no formato esperado.
 * @author Vitor e Leticia
 * @version 1.0 (Out, 2020)
 */

public class Validacao {
	
	/**
	 * Verifica se o CPF fornecido está no formato esperado
	 * @param CPF
	 * @return verdadeiro ou falso indicando se o CPF é valido ou não.
	 */
	public boolean validaCPF(String CPF) {
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0
        // (48 eh a posicao de '0' na tabela ASCII)
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
        }
	
	/**
	 * Validação do atributo dia. Verifica se o dia é valido para determinado mês
	 * @param dia
	 * @param mes
	 * @return verdadeiro ou falso indicando se o dia é valido ou não.
	 */
	public boolean validaDia(int dia, int mes) {
		if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			if(dia < 1 || dia > 31) {
				return false;
			} else {
				return true;
			}
		} else if(mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			if(dia < 1 || dia > 30) {
				return false;
			} else {
				return true;
			}
		} else if(mes == 2) {
			if(dia < 1 || dia > 28) {
				return false;
			} else {
				return true;
			}
		}
		
		return true;
	}
	
	/**
	 * Validação do atributo mes. Verifica se o mês é compativel.
	 * @param mes
	 * @return verdadeiro ou falso indicando se o mês é valido ou não.
	 */
	public boolean validaMes(int mes) {
		if(mes < 1 || mes > 12) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Valida um atributo double.
	 * @param d
	 * @return true ou false dependendo do valor de d.
	 */
	public boolean validaDouble(double d) {
		if(d < 0) {
			return false;
		}	
		return true;
	}
	
	

}
