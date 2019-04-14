<%-- 
    Document   : Atualizar_Usuario
    Created on : 25/11/2018, 12:19:33
    Author     : nelson_amaral
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Usuario"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- IMPORTANDO CABECALHO DA PAGINA -->
<jsp:include page="/paginas_utilitarias/cabecalho.jsp" />

<%
    Usuario usuario = (Usuario) request.getAttribute("user");
%>

<!DOCTYPE html>

<main>
    <div class="container">
        <div class="row">            
            <div class="card z-depth-2">
                <div class="card-content">
                    <span class="card-title titulo-tabela center-align">Atualizar Paciente</span>
                    <form action="ControleUsuario" method="POST" ><br/>
                        <input type="text" name="txtId" value="<%= usuario.getId()%>" hidden>
                        
                        <div class="row">
                            <div class="col s12 input-field hoverable">
                                <input type="text" name="txtNome" value="<%= usuario.getNome()%>" id="txtNome" class="hoverable validate" placeholder="Maximo 30 caracteres" size="30" maxlength=30 required>
                                <label class="black-text" for="txtNome">Nome<i class="material-icons left">account_box</i></label>                                   
                            </div>
                            <div class="col s4 input-field hoverable">
                                <input type="text" name="txtIdade" value="<%= usuario.getIdade()%>" id="txtIdade" class="hoverable validate" placeholder="Idade" size="3" maxlength=3 required>
                                <label class="black-text" for="txtIdade">Idade<i class="material-icons left">account_box</i></label>                                   
                            </div>
                            <div class="col s4 input-field hoverable">
                                <input type="text" name="txtCpf" value="<%= usuario.getCpf()%>" id="txtCpf" class="hoverable validate" placeholder="CPF" size="11" maxlength=11 required>
                                <label class="black-text" for="txtCpf">Cpf<i class="material-icons left">account_box</i></label>                                   
                            </div>
                            <div class="col s4 input-field hoverable">
                                <input type="text" name="txtRg" value="<%= usuario.getRg()%>" id="txtRg" class="hoverable validate" placeholder="RG" size="10" maxlength=10 required>
                                <label class="black-text" for="txtRg">RG<i class="material-icons left">account_box</i></label>                                   
                            </div>

                            <div class="row">
                                <div class="col s4 input-field hoverable">
                                    <input type="text" name="txtTelefone" value="<%= usuario.getTelefone()%>" id="telefone" class="hoverable validate" required>
                                    <label class="black-text" for="txtTelefone">Telefone<i class="material-icons left">phone</i></label>                                   
                                </div>
                                <div class="col s4 input-field hoverable">
                                    <input type="text" name="txtCelular" value="<%= usuario.getCelular()%>" id="celular" class="hoverable validate" required>
                                    <label class="black-text" for="txtCelular">Celular<i class="material-icons left">phone</i></label>                                   
                                </div>
                                <div class='col s4'>
                                    <label class="black-text left-align" for="txtTiposague">Tipo Sanguineo<i class="material-icons left">assignment</i></label>
                                    <select class="browser-default" name="txtTiposague">
                                        <option value="<%= usuario.getTiposague()%>" selected><%= usuario.getTiposague()%></option>
                                        <option value="AB+">AB+</option>
                                        <option value="AB-">AB-</option>
                                        <option value="A+">A+</option>
                                        <option value="A-">A-</option>
                                        <option value="O+">O+</option>
                                        <option value="O-">O-</option>
                                        <option value="B+">B+</option>
                                        <option value="B-">B-</option>
                                    </select>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col s6 input-field hoverable">
                                    <input type="password" name="txtSenha" id="txtSenha" value="<%= usuario.getSenha() %>" class="hoverable validate" placeholder="Senha" size="30" maxlength=30 required>
                                    <label class="black-text" for="txtSenha">Senha<i class="material-icons left">vpn_key</i></label>                                   
                                </div>
                                <div class='col s6'>
                                    <label class="black-text left-align" for="optPerfil">Perfil Usuario<i class="material-icons left">people_outline</i></label>
                                    <select class="browser-default" name="optPerfil" required>
                                        <%--       <option value="<%= usuario.getAcesso()%>" selected><%= usuario.getAcesso()%></option> --%>
                                        <option value="USUARIO">USUARIO</option>                                                
                                    </select>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col s3 input-field hoverable">
                                    <input type="text" name="txtPeso" value="<%= usuario.getPeso()%>" id="txtPeso" class="hoverable validate" placeholder="Peso" size="5" maxlength=5>
                                    <label class="black-text" for="txtPeso">Peso<i class="material-icons left">account_box</i></label>                                   
                                </div>
                                <div class="col s3 input-field hoverable">
                                    <input type="text" value="<%= usuario.getAltura()%>" name="txtAtura" id="txtAtura" class="hoverable validate" placeholder="Altura" size="5" maxlength=5>
                                    <label class="black-text" for="txtAtura">Altura<i class="material-icons left">account_box</i></label>                                   
                                </div>

                                    <label class="black-text left" for="txtDate">Data de nascimento<i class="material-icons left">perm_contact_calendar</i></label>  
                                <div class="col s6 input-field hoverable left">
                                    <input type="date" value="<%= usuario.getNascimento()%>" name="txtDate" id="txtDate" class="hoverable validate left" required>
                                                                                     
                                </div>                         
                            </div>
                        </div>

                        <div class="row center-align">
                            <input class="btn waves-effect" type="submit" value="Comfirma" name="acao">
                        </div>
                    </form> 
                </div>
            </div>
        </div>
    </div>
</main>
</body>   

<!-- IMPORTANDO RODAPE DA PAGINA -->
<jsp:include page="/paginas_utilitarias/rodape.jsp" />

</html>
