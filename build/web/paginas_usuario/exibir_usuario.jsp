<%-- 
    Document   : exibir_usuario
    Created on : 25/11/2018, 05:52:21
    Author     : nelson_amaral
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- IMPORTANDO CABECALHO DA PAGINA -->
<jsp:include page="../paginas_utilitarias/cabecalho.jsp" />

<br>
    <main>
        <div class="container">
            <div class="row">            
                <div class="card z-depth-2">
                    <div class="card-content">
                        <span class="card-title titulo-tabela center-align">Tabela Paciente</span>
                        <table class="responsive-table">
                            <tr>
                                <td class="center-align letra">Nome</td>  
                                <td class="center-align letra">Idade</td>
                                <td class="center-align letra">CPF</td>
                                <td class="center-align letra">RG</td>
                                <td class="center-align letra">Celular</td>
                                <td class="center-align letra">Telefone</td>
                                <td class="center-align letra">Tiposague</td>
                                <td class="center-align letra">Peso</td>
                                <td class="center-align letra">Altura</td>
                                <td class="center-align letra">Nascimento</td>
                                <td class="center-align letra">Acesso</td>
                                <td class="center-align letra">Opção</td>
                            </tr>
                            <c:forEach var="usuario" items="${lista}">
                                <tr>

                                    <td class="center-align"><c:out value="${usuario.nome}"/></td>
                                    <td class="center-align"><c:out value="${usuario.idade}"/></td>
                                    <td class="center-align"><c:out value="${usuario.cpf}"/></td>
                                    <td class="center-align"><c:out value="${usuario.rg}"/></td>
                                    <td class="center-align"><c:out value="${usuario.telefone}"/></td>
                                    <td class="center-align"><c:out value="${usuario.celular}"/></td>
                                    <td class="center-align"><c:out value="${usuario.tiposague}"/></td>
                                    <td class="center-align"><c:out value="${usuario.peso}"/></td>
                                    <td class="center-align"><c:out value="${usuario.altura}"/></td>
                                    <td class="center-align"><c:out value="${usuario.nascimento}"/></td>
                                    <td class="center-align"><c:out value="${usuario.acesso}"/></td>

                                    <td class="center-align">
                                        <form action="ControleUsuario" method="POST">
                                            <button class="btn waves-effect waves-teal red" type="submit" name="acao" value="Deletar"><i class="material-icons">delete</i></button>
                                            <button class="btn waves-effect waves-teal blue" type="submit" name="acao" value="Editar"><i class="material-icons">edit</i></button>
                                            <input type="text" name="id" value="${usuario.id}" hidden/>
                                        </form>
                                    </td>

                                </tr>
                            </c:forEach>
                        </table>
                        <br>
                        <div class="container">
                            <div class="row right">
                                <form action="ControleAcesso" method="POST">
                                    <input value="Voltar" name="acao" hidden>
                                    <button class="btn" type="submit">Voltar</button>
                                </form>
                            </div>
                            <div class="row left">
                                <a class="btn red" href="paginas_usuario/cadastro_usuario.jsp"><li class="material-icons">add</li></a>
                            </div>
                        </div>
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
