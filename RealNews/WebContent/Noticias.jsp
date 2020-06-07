<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="service.NoticiaService"%>
<%@ page import="dao.NoticiasDAO"%>
<%@ page import="dao.ComentarioDAO"%>
<%@ page import="model.Noticias"%>
<%@ page import="model.Comentarios"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
NoticiasDAO n = new NoticiasDAO();
ComentarioDAO c = new ComentarioDAO();
ArrayList<Noticias> lista = n.listarNoticias();  
Noticias noticias = new Noticias();
int id = noticias.getIdNoticia();
ArrayList<Comentarios> listaComent = c.listarComentario(id);
%>

	<h1>Real News</h1>
	<form action="Controller.do" method="post">

		<%for (Noticias not : lista) {
		%>
		<h2><%= not.getTitulo() %>
		</h2>
		<p><%= not.getTextoNoticia() %></p>
		<% for (Comentarios com : listaComent){ %>
		<p><%= com.getNome() %></p>
		<p><%= com.getDescricao()%></p>	
		
		<% }%> 
		<input name="nome" type="text"/>	
		<textarea name="coment">
		</textarea>
		<input type="submit" value="enviar" /> <input type="hidden"
			name="command" value="CadastrarComent">
		<%}%>
	</form>
</body>
</html>