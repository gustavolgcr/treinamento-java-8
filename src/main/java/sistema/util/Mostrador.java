package sistema.util;

import java.util.function.Consumer;

import sistema.modelo.Usuario;

public class Mostrador implements Consumer<Usuario>{

	public void accept(Usuario u) {
		System.out.println(u.getNome());
	}
	
}
