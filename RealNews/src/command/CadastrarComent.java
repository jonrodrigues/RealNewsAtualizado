package command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ComentarioDAO;
import model.Comentarios;
import model.Noticias;
import service.ComentarioService;


@WebServlet("/CadastrarComent.do")
public class CadastrarComent implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String texto = request.getParameter("coment");
		Comentarios c = new Comentarios();
		c.setNome(nome);
		c.setTextoComentario(texto);

		ComentarioService serv = new ComentarioService();
		serv.cadastrar(c);	
	}

}
