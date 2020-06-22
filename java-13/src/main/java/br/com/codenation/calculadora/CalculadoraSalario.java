package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {

		double minimumWage = 1039;

		if(salarioBase < minimumWage) {
			return Math.round(0.0);
		}

		return  Math.round(calcularIRRF(salarioBase));
	}

	private double calcularInss(double salarioBase) {

		double discountPercentage = discountBySalaryRangeForINSS(salarioBase);

		double amountToBeDiscounted = discountPercentage * salarioBase;

		double salaryAfterDiscount = salarioBase - amountToBeDiscounted;

		return salaryAfterDiscount;

	}

	private double calcularIRRF(double salarioBase) {

		double salaryAfterINSSDiscount = calcularInss(salarioBase);

		double discountPercentage = discountBySalaryRangeForIRRF(salaryAfterINSSDiscount);

		double amountToBeDiscounted = salaryAfterINSSDiscount - (discountPercentage * salaryAfterINSSDiscount);

		return amountToBeDiscounted;
	}

	private double discountBySalaryRangeForINSS(double grossSalary) {

		if(grossSalary <= 1500) {
			return 8.0 / 100.0;
		} else if (grossSalary > 1500 && grossSalary <= 4000) {
			return 9.0 / 100.0;
		} else {
			return 11.0 / 100.0;
		}

	}

	private double discountBySalaryRangeForIRRF(double referenceValue) {

		if(referenceValue < 3000) {
			return 0.0;
		} else if( referenceValue > 3000 && referenceValue <= 6000) {
			return 7.50 / 100.0;
		} else {
			return 15.0 / 100.0;
		}
	}

}