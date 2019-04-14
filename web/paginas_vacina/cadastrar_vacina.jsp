<%-- 
    Document   : cadastar_vacina
    Created on : 25/11/2018, 11:21:48
    Author     : nelson_amaral
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- IMPORTANDO CABECALHO DA PAGINA -->
<jsp:include page="../paginas_utilitarias/cabecalho.jsp" />

<!DOCTYPE html>
<html>
    <body>
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <div class="card z-depth-2">
                        <div class="card-content">
                            <span class="card-title titulo-tabela center-align">Cadastrar Vacina</span>
                            <form action="ControleVacina" method="POST" ><br/>
                                <div class="row">
                                    <div class="col s4 input-field hoverable">
                                        <input type="text" name="txtNome" id="txtNome" class="hoverable validate" placeholder="Maximo 30 caracteres" size="30" maxlength=30 required>
                                        <label class="black-text" for="txtNome">Vacina<i class="material-icons left">account_box</i></label>                                   
                                    </div>
                                    <div class="col s4 input-field hoverable">
                                        <input type="text" name="txtDose" id="txtTipo" class="hoverable validate" placeholder="Maximo 30 caracteres" size="30" maxlength=30 required>
                                        <label class="black-text" for="txtDose">Dose<i class="material-icons left">account_box</i></label>                                   
                                    </div>
                                       <div class="col s4 input-field hoverable">
                                        <input type="text" name="txtTipo" id="txtTipo" class="hoverable validate" placeholder="Maximo 30 caracteres" size="30" maxlength=30 required>
                                        <label class="black-text" for="txtTipo">Tipo<i class="material-icons left">account_box</i></label>                                   
                                    </div>
                                    <div class="col s6">
                                          <label class="black-text" for="txtIntervalo">Intervalo de Dose<i class="material-icons left">account_box</i></label>       
                                        <select class="browser-default" name="txtIntervalo" required>
                                            <option value="0" disabled selected>0</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                        </select>
                                    </div>
                                    <div class="col s6 input-field">

                                        <select name="txtRestricaoFK" multiple>
                                            <option value="" disabled selected>Restrições...</option>
                                            
                                            <!-- Listando Restricoes para cadastrar na vacina -->
                                            <c:forEach var="restricao" items="${listarestricao}">
                                            <option value="${restricao.restricao_id}">${restricao.restricao_nome}</option>
                                           </c:forEach>
                                            
                                        </select>
                                        <label class="black-text" for="txtRestricaoFK">Restricao<i class="material-icons left">account_box</i></label>                                   

                                    </div>
                                </div>


                                <input class="btn left" type="submit" value="Cadastrar" name="acao" >


                            </form>
                            <br><br><br>
                            <form action="../ControleVacina" method="POST">
                                <input name="acao" value="Consultar Vacinas" hidden>
                                <button type="submit" class="btn red right">Voltar</button>
                            </form>
                            <br>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

    <!-- IMPORTANDO RODAPE DA PAGINA -->
    <jsp:include page="../paginas_utilitarias/rodape.jsp" />

</html>
