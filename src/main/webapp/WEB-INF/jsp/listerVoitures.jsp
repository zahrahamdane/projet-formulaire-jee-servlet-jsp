<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>    
<%@ page import="fr.eni.beans.Voiture" %>    
      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des voitures</title>

	<!-- CSS Bootstrap 4 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
	<div class="container">
		<div class="py-5 text-center">
			<h2>Liste des voitures</h2>
		</div>

		<div class="row">
			<div class="col-md-12 order-md-1">
				<%
					List<Voiture> voitures = (List<Voiture>) application.getAttribute("voitures");
					if(voitures != null){
				%>
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Marque</th>
									<th>Modèle</th>
									<th>Kilométrage</th>
									<th>Immatriculation</th>
									<th>Année</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<% 
									for(Voiture v:voitures) {
								%>
								
										<tr>
											<td><%= v.getMarque() %></td>
											<td><%= v.getModele() %></td>
											<td><%= v.getKilometrage() %></td>
											<td><%= v.getImmatriculation() %></td>
											<td><%= v.getAnnee() %></td>

											<td>
												<a href="<%= request.getContextPath() %>/SupprimerServlet?immatriculation=<%= v.getImmatriculation()%>"><i class="bi bi-trash"></i></a>
												<a href="<%= request.getContextPath() %>/EditerServlet?immatriculation=<%= v.getImmatriculation()%>"><i class="bi bi-pencil-square"></i></a>
											</td>
										</tr>
								<%
									}
								%>
							</tbody>
						</table>
				<%		
					}else {
				%>
						<p>Aucune voiture n'est présente dans la liste.</p>
				<%		
					}
				%>

				<a class="btn btn-primary btn-lg btn-block" href="<%= request.getContextPath()%>/AjouterServlet">Ajouter Voiture</a>
			</div>
		</div>
		
		<footer class="my-5 pt-5 text-muted text-center text-small">
        	<p class="mb-1">&copy; 2024 Editions ENI</p>
      	</footer>
	</div>
	
</body>
</html>