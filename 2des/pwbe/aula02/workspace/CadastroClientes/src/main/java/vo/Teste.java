package vo;

public class Teste {

	public static void main(String[] args) {
		
		CPF cpf = new CPF();
		cpf.geraCpf();
		System.out.println(cpf.getCpf());
		System.out.println(cpf.geraDigitos());

	}

}
