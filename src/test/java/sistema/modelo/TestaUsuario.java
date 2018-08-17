package sistema.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class TestaUsuario {

	public static void main(String[] args) {
		
		Usuario user1 = new Usuario("Paulo Silveira", 150);
		Usuario user2 = new Usuario("Rodrigo Turini", 120);
		Usuario user3 = new Usuario("Alex Melo", 789);
		Usuario user4 = new Usuario("Guilherme Silveira", 190);
		Usuario user5 = new Usuario("Sofia Barros", 50);
		Usuario user6 = new Usuario("Gabrielly Sousa", 111);

		
		
		
		System.out.println("\nLISTA IMUTÁVEL DE USUÁRIOS");
		List<Usuario> usuariosImutaveis = Arrays.asList(user1, user2, user3, user4, user5, user6);

		usuariosImutaveis.forEach(u -> System.out.println(u.getNome()));
		
//		usuariosImutaveis.forEach(u -> u.tornaModerador());
		usuariosImutaveis.forEach(Usuario::tornaModerador);
		
		Consumer<Usuario> mostraMensagem = u -> System.out.println("Antes de imprimir os nomes");
		Consumer<Usuario> imprimeNome = u -> System.out.println(u.getNome());
		
		usuariosImutaveis.forEach(mostraMensagem.andThen(imprimeNome));
		
		usuariosImutaveis.forEach(u -> System.out.println(u.getNome()));

		
		
		
		System.out.println("\nLISTA MUTÁVEL DE USUÁRIOS");
		
		List<Usuario> usuariosMutaveis = new ArrayList<>();
		usuariosMutaveis.add(user1);
		usuariosMutaveis.add(user2);
		usuariosMutaveis.add(user3);
		usuariosMutaveis.add(user4);
		usuariosMutaveis.add(user5);
		usuariosMutaveis.add(user6);
		
		
		usuariosMutaveis.removeIf(u -> u.getPontos() > 160);
		
		usuariosMutaveis.sort(Comparator.comparingInt(Usuario::getPontos).thenComparing(Usuario::getNome));
		
		usuariosMutaveis.forEach(u -> System.out.println(u.getNome()));
		
		usuariosMutaveis.forEach(System.out::println);
		
	}
}
