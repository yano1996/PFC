<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : cadastar_vacina
    Created on : 25/11/2018, 11:21:48
    Author     : nelson_amaral
--%>

<%@page import="model.Vacina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- IMPORTANDO CABECALHO DA PAGINA -->
<jsp:include page="../paginas_utilitarias/cabecalho.jsp" />

<!DOCTYPE html>

<%
    Vacina vacina = (Vacina) request.getAttribute("vacina");
%>

<main>
    <div class="container">
        <div class="row">            
            <div class="card z-depth-2">
                <div class="card-content">
                    <span class="card-title titulo-tabela center-align">Atualizar Vacina</span>
                    <form action="ControleVacina" method="POST" ><br/>
                        <div class="row">
                            <div class="col s4 input-field hoverable">
                                <input type="text" name="txtNome" id="txtNome" value="<%= vacina.getNome()%>" class="hoverable validate" size="30" maxlength=30 required>
                                <label class="black-text" for="txtNome">Vacina<i class="material-icons left">account_box</i></label>                                   
                            </div>
                            <div class="col s4 input-field hoverable">
                                <input type="number" name="txtDose" id="tx" value="<%= vacina.getDose()%>" class="hoverable validate" size="30" maxlength=30 required>
                                <label class="black-text" for="txtDose">Dose<i class="material-icons left">account_box</i></label>                                   
                            </div>
                            <div class="col s4 input-field hoverable">
                                <input type="text" name="txtTipo" id="txtTipo" value="<%= vacina.getTipo()%>" class="hoverable validate" placeholder="Maximo 30 caracteres" size="30" maxlength=30 required>
                                <label class="black-text" for="txtTipo">Tipo<i class="material-icons left">account_box</i></label>                                   
                            </div>
                            <div class="col s6">
                                <label class="black-text" for="txtIntervalo">Intervalo de Dose<i class="material-icons left">account_box</i></label>       
                                <select class="browser-default" name="txtIntervalo" required>
                                    <option value="<%= vacina.getIntervalo()%>" selected><%= vacina.getIntervalo()%></option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                </select>
                            </div>
                            <div class="col s6"></div>


                            <!-- INPUT PARA RECEBER VALOR DO ID DO REGISTRO A SER EDITADO -->
                            <input name="txtId" value="<%= vacina.getId_vacina()%>" hidden>
                        </div> 
                        <div class="row center-align">
                            <input class="btn left" type="submit" value="Confirma" name="acao" >
                        </div>

                    </form>

                    <form action="ControleVacina" method="POST">
                        <input name="acao" value="Consultar Vacinas" hidden>
                        <button type="submit" class="btn red right">Voltar</button>
                    </form>
                    <br>
                </div>
            </div>
        </div>
</main>
</body>

<!-- IMPORTANDO RODAPE DA PAGINA -->
<jsp:include page="../paginas_utilitarias/rodape.jsp" />

</html>
