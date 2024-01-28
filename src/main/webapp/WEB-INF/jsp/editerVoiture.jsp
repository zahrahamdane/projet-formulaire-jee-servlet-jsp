<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="fr.eni.beans.Voiture" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editer une voiture</title>

<!-- CSS Bootstrap 4 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <div class="py-5 text-center">
            <h2>Editer une voiture</h2>
        </div>

        <%
            Voiture voitureAEditer = (Voiture) request.getAttribute("voitureAEditer");
        %>

        <div class="row">
            <%
                if(voitureAEditer != null) {
            %>
                    <div class="col-md-12 order-md-1">
                        <form action="<%= request.getContextPath()%>/EditerServlet" method="post">
                            <div class="mb-3">
                                <label for="marque">Marque</label>
                                <input type="text" class="form-control" name="marque" id="marque" value="<%=voitureAEditer.getMarque()%>">
                            </div>

                            <div class="mb-3">
                                <label for="modele">Modele</label>
                                <input type="text" class="form-control" name="modele" id="modele" value="<%=voitureAEditer.getModele()%>">
                            </div>

                            <div class="mb-3">
                                <label for="kilometrage">Kilometrage</label>
                                <input type="text" class="form-control" name="kilometrage" id="kilometrage" value="<%=voitureAEditer.getKilometrage()%>">
                            </div>

                            <div class="mb-3">
                                <label for="immatriculation">Immatriculation</label>
                                <input type="text" class="form-control" name="immatriculation" id="immatriculation" value="<%=voitureAEditer.getImmatriculation()%>" readonly>
                            </div>

                            <div class="mb-3">
                                <label for="annee">Annee</label>
                                <input type="text" class="form-control" name="annee" id="annee" value="<%=voitureAEditer.getAnnee()%>">
                            </div>

                            <button class="btn btn-primary btn-lg btn-block" type="submit">Editer</button>

                        </form>
                    </div>
                    
            <%
                } else {
            %>
                    <p>Aucune voiture n'est selectionnee</p>
            <%
                } 
            %>
        </div>
        
        <footer class="my-5 pt-5 text-muted text-center text-small">
        	<p class="mb-1">&copy; 2024 Editions ENI</p>
      </footer>
    </div>

</body>
</html>