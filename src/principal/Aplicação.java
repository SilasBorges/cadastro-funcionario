package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import empresa.Funcionario;

public class Aplicação {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		List<Funcionario> lista = new ArrayList<>();
		
		
		System.out.println("Informe a quantidade de funcionarios que vai ser cadastrado:");
	    Integer quantidade = sc.nextInt();
	    
	    for(int i = 0; i < quantidade; i++) {
	    	
	    	
	    	
	    	System.out.print("Informe a id do funcionario:");
	    	int id = sc.nextInt();
	    	
	    	while(idConfirm(lista ,id)) {
	    		
	    		System.out.println("Essa id já existe! Tente novamente:");
	    		id = sc.nextInt();
	    		
	    	}
	    	
	    	sc.nextLine();
	    	
	    	System.out.print("Informe o nome:");
	    	String nome = sc.nextLine();
	    	
	    	
	    	System.out.print("Informe o salario:");
	    	double salario = sc.nextDouble();
	    	
	        Funcionario func = new Funcionario(id, nome, salario);
	        
	        lista.add(func);
	        
	        System.out.println("");
	        
	    	}
	    

	    
	    System.out.print("Informe a id do funcionario que vai receber o aumento:");
	    int id = sc.nextInt();
	    
	    Integer posição = posicaoId(lista, id);
	    
	    	if(posição == null) {
	    	
	    	System.out.println("Essa id não existe");
	    	
	    }	
	    	else {
	    	
	    	System.out.println();
		    System.out.print("Informe a porcentagem do aumento:");
		    double porcentagem = sc.nextDouble();
		    
		   lista.get(posição).aumentoSalario(porcentagem);
	    	
	    }
	    
	    
	    for(Funcionario obj : lista ) {
	    	
	    	System.out.println(obj);
	    	
	    }
	    
	    sc.close();
	    
	    }
	
	public static Integer posicaoId(List<Funcionario> lista, int id) {
		
		for(int i = 0; i < lista.size(); i++) {
			
			if(lista.get(i).getId() == id) {
				
				return i;
			}
			
		}
		
		return null;
	}
	public static boolean idConfirm(List<Funcionario> lista, int id) {
		
		Funcionario func = lista.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		
		return func != null;
		
	}
		

	}


