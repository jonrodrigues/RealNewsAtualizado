package command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticiasDAO;
import model.Noticias;


@WebServlet("/ExcluirNoticias.do")
public class ExcluirNoticia implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idNoticia =(Integer.parseInt(request.getParameter("idNoticia")));
		Noticias n = new Noticias();
		NoticiasDAO nDAO = new NoticiasDAO();
		
		n.setIdNoticia(idNoticia);
		nDAO.excluir(n);
		PrintWriter saida = response.getWriter();
		saida.print("<h1>"+ "Excluido com Sucesso" +"</h1>");
	}

	}


