package sistema.modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestaStreams {
	public static void main(String[] args) {
		Usuario user1 = new Usuario("Paulo Silveira", 150);
		Usuario user2 = new Usuario("Rodrigo Turini", 120);
		Usuario user3 = new Usuario("Alex Melo", 789);
		Usuario user4 = new Usuario("Guilherme Silveira", 190);
		Usuario user5 = new Usuario("Sofia Barros", 50);
		Usuario user6 = new Usuario("Gabrielly Sousa", 111);
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(user1);
		usuarios.add(user2);
		usuarios.add(user3);
		usuarios.add(user4);
		usuarios.add(user5);
		usuarios.add(user6);
		
		usuarios.sort(Comparator.comparing(Usuario::getPontos).reversed());
		usuarios.subList(0, 4).forEach(Usuario::tornaModerador);
	
		
		usuarios
			.stream()
			.filter(u -> u.getPontos() > 100)
			.forEach(Usuario::tornaModerador);
		
		List<Usuario> maisQue100 = usuarios.stream().filter(u -> u.getPontos() > 100).
				collect(Collectors.toList());
		
		maisQue100.forEach(System.out::println);
		
	}
}
