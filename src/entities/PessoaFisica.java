package entities;

public class PessoaFisica extends Pessoa{

	private Double gastoComSaude;
	
	public PessoaFisica() {
		super();
	}
	
	public PessoaFisica(String nome, Double rendaAnual, Double gastoComSaude) {
		super(nome, rendaAnual);
		this.gastoComSaude = gastoComSaude;
	}

	public Double getGastoComSaude() {
		return gastoComSaude;
	}

	public void setGastoComSaude(Double gastoComSaude) {
		this.gastoComSaude = gastoComSaude;
	}

	@Override
	public double imposto() {
		double sum = 0.0;
		
		if (super.getRendaAnual() < 20000.00) {
			sum += super.getRendaAnual() * 0.15;
		} else {
			sum += super.getRendaAnual() * 0.25;
		}
		
		if (gastoComSaude > 0) {
			sum -= (gastoComSaude * 0.50);
		}
		
		return sum;
	}
}
