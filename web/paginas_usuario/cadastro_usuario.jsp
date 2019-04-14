<%-- 
    Document   : cadastro_usuario
    Created on : 01/11/2018, 20:33:51
    Author     : nelson_amaral
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- IMPORTANDO CABECALHO DA PAGINA -->
<jsp:include page="/paginas_utilitarias/cabecalho_02.jsp" />

<!DOCTYPE html>
<main>
    <div class="container">
        <div class="row">            
            <div class="card z-depth-2">
                <div class="card-content">
                    <span class="card-title titulo-tabela center-align">Cadastro Paciente</span>
                    <form action="../ControleUsuario" method="POST" ><br/>
                        <div class="row">
                            <div class="col s12 input-field hoverable">
                                <input type="text" name="txtNome" id="txtNome" class="hoverable validate" placeholder="Maximo 30 caracteres" size="30" maxlength=30 required>
                                <label class="black-text" for="txtNome">Nome<i class="material-icons left">account_box</i></label>                                   
                            </div>
                            <div class="col s4 input-field hoverable">
                                <input type="text" name="txtIdade" id="txtIdade" class="hoverable validate" placeholder="Idade" size="3" maxlength=3 required>
                                <label class="black-text" for="txtIdade">Idade<i class="material-icons left">account_box</i></label>                                   
                            </div>
                            <div class="col s4 input-field hoverable">
                                <input type="text" name="txtCpf" id="txtCpf" pattern="[0-9]+$" class="hoverable validate" placeholder="CPF" size="11" maxlength=11 required>
                                <label class="black-text" for="txtCpf">Cpf<i class="material-icons left">account_box</i></label>                                   
                            </div>
                            <div class="col s4 input-field hoverable">
                                <input type="text" name="txtRg" id="txtRg" pattern="[0-9]+$" class="hoverable validate" placeholder="RG" size="10" maxlength=10 required>
                                <label class="black-text" for="txtRg">RG<i class="material-icons left">account_box</i></label>                                   
                            </div>

                            <div class="row">
                                <div class="col s4 input-field hoverable">
                                    <input type="text" name="txtTelefone" id="telefone" class="hoverable validate" required>
                                    <label class="black-text" for="txtTelefone">Telefone<i class="material-icons left">phone</i></label>                                   
                                </div>
                                <div class="col s4 input-field hoverable">
                                    <input type="text" name="txtCelular" id="celular" class="telefone hoverable validate" required>
                                    <label class="black-text" for="txtCelular">Celular<i class="material-icons left">phone</i></label>                                   
                                </div>
                                <div class='col s4'>
                                    <label class="black-text left-align" for="txtTiposague">Tipo Sanguineo<i class="material-icons left">assignment</i></label>
                                    <select class="browser-default" name="txtTiposague">
                                        <option value="" disabled selected>Selecione um tipo sanguineo...</option>
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
                                    <input type="password" name="txtSenha" id="txtSenha" class="hoverable validate" placeholder="Senha" size="30" maxlength=30 required>
                                    <label class="black-text" for="txtSenha">Senha<i class="material-icons left">vpn_key</i></label>                                   
                                </div>
                                <div class='col s6'>
                                    <label class="black-text left-align" for="optPerfil">Perfil Usuario<i class="material-icons left">people_outline</i></label>
                                    <select class="browser-default" name="optPerfil" required>
                                        <option value="" disabled selected>Selecione um perfil...</option>
                                        <option value="USUARIO">USUARIO</option>
                                    </select>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col s3 input-field hoverable">
                                    <input type="text" name="txtPeso" id="txtPeso" class="hoverable validate" placeholder="Peso" size="5" maxlength=5>
                                    <label class="black-text" for="txtPeso">Peso<i class="material-icons left">account_box</i></label>                                   
                                </div>
                                <div class="col s3 input-field hoverable">
                                    <input type="text" name="txtAtura" id="txtAtura" class="hoverable validate" placeholder="Altura" size="5" maxlength=5>
                                    <label class="black-text" for="txtAtura">Altura<i class="material-icons left">account_box</i></label>                                   
                                </div>
                                <label class="black-text left" for="txtDate">Data de nascimento<i class="material-icons left">perm_contact_calendar</i></label>                                                   

                                <div class="col s3 input-field hoverable">

                                    <input type="Date" name="txtDate" id="data" class="hoverable validate" required>


                                </div>                         
                            </div>

                            <div class="row">
                                <h4 class="center-align">Endereço</h4>
                            </div>

                            <div class="card z-depth-2">
                                <div class="card-content">
                                    <div class="row">
                                        <div class="col s10 input-field hoverable">
                                            <input type="text" name="txtLog" id="txtLog" class="hoverable validate" placeholder="Maximo 30 caracteres" size="30" maxlength=30 required>
                                            <label class="black-text" for="txtLog">Logradouro<i class="material-icons left">hotel</i></label>                                   
                                        </div>

                                        <div class="col s2 input-field hoverable">
                                            <input type="text" name="txtNumero" id="txtNumero" class="hoverable validate" placeholder="Maximo 30 caracteres" size="30" maxlength=30 required>
                                            <label class="black-text" for="txtNumero">Numero<i class="material-icons left">filter_1</i></label>                                   
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col s4 input-field hoverable">
                                            <input type="text" name="txtCidade" id="txtCidade" class="hoverable validate" placeholder="Maximo 30 caracteres" size="30" maxlength=30 required>
                                            <label class="black-text" for="txtCidade">Cidade<i class="material-icons left">assignment</i></label>                                   
                                        </div>


                                        <div class="col s4 input-field hoverable">
                                            <input type="text" name="txtBairro" id="txtBairro" class="hoverable validate" placeholder="Maximo 30 caracteres" size="30" maxlength=30 required>
                                            <label class="black-text" for="txtBairro">Bairro<i class="material-icons left">assignment</i></label>                                   
                                        </div>

                                        <div class="col s4 input-field hoverable">
                                            <input type="text" name="txtComplemento" id="txtComplemento" class="hoverable validate" placeholder="Maximo 30 caracteres" size="30" maxlength=30 required>
                                            <label class="black-text" for="txtComplemento">Complemento<i class="material-icons left">assignment</i></label>                                   
                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="col s6 input-field hoverable">
                                            <input type="text" name="txtCep" id="txtCep" class="hoverable validate" placeholder="Maximo 15 caracteres" size="15" maxlength=15 required>
                                            <label class="black-text" for="txtCep">Cep<i class="material-icons left">assignment</i></label>                                   
                                        </div>

                                        <div class='col s4'>
                                            <label class="black-text left-align" for="txtUf">UF<i class="material-icons left">assignment</i></label>
                                            <select class="browser-default" name="txtUf" required>
                                                <option value="" disabled selected>Selecione um nível de acesso...</option>
                                                <option value="AC">AC</option>
                                                <option value="AL">AL</option>
                                                <option value="AP">AP</option>
                                                <option value="AM">AM</option>
                                                <option value="BA">BA</option>
                                                <option value="CE">CE</option>
                                                <option value="DF">DF</option>
                                                <option value="ES">ES</option>
                                                <option value="GO">GO</option>
                                                <option value="MA">MA</option>
                                                <option value="MT">MT</option>
                                                <option value="MS">MS</option>
                                                <option value="MG">MG</option>
                                                <option value="PA">PA</option>
                                                <option value="PB">PB</option>
                                                <option value="PR">PR</option>
                                                <option value="PE">PE</option>
                                                <option value="PI">PI</option>
                                                <option value="RJ">RJ</option>
                                                <option value="RN">RN</option>
                                                <option value="RO">RO</option>
                                                <option value="RR">RR</option>
                                                <option value="SC">SC</option>
                                                <option value="SP">SP</option>
                                                <option value="SE">SE</option>
                                                <option value="TO">TO</option>                                                                                                                       
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row center-align">
                                <input class="btn waves-effect center-align" type="submit" value="Cadastrar" name="acao" >
                            </div>
                        </div>
                    </form>                    
                </div>
            </div>
        </div>
    </div>
</main>
</body>

<!-- IMPORTANDO RODAPE DA PAGINA -->
<jsp:include page="/paginas_utilitarias/rodape_02.jsp" />

</html>