package controll;

import java.util.ArrayList;
import java.util.List;

public class Mensagem {
	private static List<String> mensagens = new ArrayList<>();

	public static void addMensagem(String m) {
		mensagens.add(m);
	}

	public static List<String> getMensagens() {
		return mensagens;
	}

	public static String getMensagem() {
		if (!mensagens.isEmpty()) {
			return mensagens.remove(0);
		}
		return null;
	}
}