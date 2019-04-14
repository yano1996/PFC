<%-- 
    Document   : exibir_usuario
    Created on : 25/11/2018, 05:52:21
    Author     : nelson_amaral
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- IMPORTANDO CABECALHO DA PAGINA -->
<jsp:include page="../paginas_utilitarias/cabecalho.jsp" />

<!DOCTYPE html>
<main>
    <div class="container">
        <div class="row">            
            <div class="card z-depth-2">
                <div class="card-content">
                    <span class="card-title titulo-tabela center-align">Consultar Vacinas</span>
                            <table class="responsive-table">
                                <TR>
                                    <td class="center-align letra">Vacina</td>
                                    <td class="center-align letra">Doses</td>
                                    <td class="center-align letra">Intervalo</td> 
                                    <td class="center-align letra">Tipo</td> 
                                    <td class="center-align letra">Opção</td>   
                                </TR>
                                <c:forEach var="vacinas" items="${listavacina}">

                                    <TR>
                                        <td class="center-align"><c:out value="${vacinas.nome}"/></td>
                                        <td class="center-align"><c:out value="${vacinas.dose}"/></td>
                                        <td class="center-align"><c:out value="${vacinas.intervalo}"/></td>
                                        <td class="center-align"><c:out value="${vacinas.tipo}"/></td>

                                        <td class="center-align">
                                            <form action="ControleVacina" method="POST">
                                                <button class="btn waves-effect waves-teal red" type="submit" name="acao" value="Deletar"><i class="material-icons">delete</i></button>
                                                <button class="btn waves-effect waves-teal blue" type="submit" name="acao" value="Editar Vacina"><i class="material-icons">edit</i></button>
                                                <input type="text" name="id_vacina" value="${vacinas.id_vacina}" hidden/>
                                            </form>
                                        </td>
                                    </TR>
                                </c:forEach>
                            </table>
                    <div class="row">
                        <br>
                        <!--<a class="btn" href="paginas_vacina/cadastrar_vacina.jsp">Cadastrar</a>-->
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
</body>

<!-- IMPORTANDO RODAPE DA PAGINA -->
<jsp:include page="../paginas_utilitarias/rodape.jsp" />

</html>
