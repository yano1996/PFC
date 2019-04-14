<%-- 
    Document   : home_comum
    Created on : 11/11/2018, 14:14:08
    Author     : nelson_amaral
--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- IMPORTANDO CABECALHO DA PAGINA -->
<jsp:include page="../paginas_utilitarias/cabecalho_03.jsp" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h3 class="center-align">Cardeneta</h3>

        <div class="row">
            <div class="col s2">

            </div>
            <div class="col s3">
                <div class="card z-depth-2 blue">
                    <div class="card-content">
                        <a class="black-text">Informação</a>
                    </div>
                </div>
            </div>
            <div class="col s3">
                <div class="card z-depth-2 blue">
                    <div class="card-content">
                        <a class="black-text">Informação</a>
                    </div>
                </div>
            </div>
            <div class="col s3">
                <div class="card z-depth-2 blue">
                    <div class="card-content">
                        <a class="black-text">Informação</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col s2">
                <div class="card z-depth-2 blue">
                    <div class="card-content">
                        <a class="black-text">Vacina 021#</a>
                    </div>
                </div>
            </div>
            <div class="col s3">
                <div class="card z-depth-2">
                    <div class="card-content">
                        <div class="row">
                            <a class="black-text">30/12/2022</a>
                        </div>
                        <a class="black-text">STATUS: <a class="black-text yellow">PENDENTE</a></a>
                    </div>
                </div>
            </div>
            <div class="col s3">
                <div class="card z-depth-2">
                    <div class="card-content">
                        <div class="row">
                            <a class="black-text">30/12/2022</a>
                        </div>
                        <a class="black-text">STATUS: <a class="black-text yellow">PENDENTE</a></a>
                    </div>
                </div>
            </div>
            <div class="col s3">
                <div class="card z-depth-2">
                    <div class="card-content">
                        <div class="row">
                            <a class="black-text">30/12/2022</a>
                        </div>
                        <a class="black-text">STATUS: <a class="black-text yellow">PENDENTE</a></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col s2">
                <div class="card z-depth-2 blue">
                    <div class="card-content">
                        <a class="black-text">Vacina 8911#</a>
                    </div>
                </div>
            </div>
            <div class="col s3">
                <div class="card z-depth-2">
                    <div class="card-content">
                        <div class="row">
                            <a class="black-text">30/12/2022</a>
                        </div>
                        <a class="black-text">STATUS: <a class="black-text green">CONFIRMADO</a></a>
                    </div>
                </div>
            </div>
            <div class="col s3">
                <div class="card z-depth-2">
                    <div class="card-content">
                        <div class="row">
                            <a class="black-text">30/12/2022</a>
                        </div>
                        <a class="black-text">STATUS: <a class="black-text green">CONFIRMADO</a></a>
                    </div>
                </div>
            </div>
            <div class="col s3">
                <div class="card z-depth-2">
                    <div class="card-content">
                        <div class="row">
                            <a class="black-text">30/12/2022</a>
                        </div>
                        <a class="black-text">STATUS: <a class="black-text yellow">PENDENTE</a></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col s2">
                <div class="card z-depth-2 blue">
                    <div class="card-content">
                        <a class="black-text">Vacina 8911#</a>
                    </div>
                </div>
            </div>
            <div class="col s3">
                <div class="card z-depth-2">
                    <div class="card-content">
                        <div class="row">
                            <a class="black-text">30/12/2022</a>
                        </div>
                        <a class="black-text">STATUS: <a class="black-text red">CANCELADO</a></a>
                    </div>
                </div>
            </div>
            <div class="col s3">
                <div class="card z-depth-2">
                    <div class="card-content">
                        <div class="row">
                            <a class="black-text">30/12/2022</a>
                        </div>
                        <a class="black-text">STATUS: <a class="black-text yellow">PENDENTE</a></a>
                    </div>
                </div>
            </div>
            <div class="col s3">
                <div class="card z-depth-2">
                    <div class="card-content">
                        <div class="row">
                            <a class="black-text">30/12/2022</a>
                        </div>
                        <a class="black-text">STATUS: <a class="black-text green">CONFIRMADO</a></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col s2">
                <div class="card z-depth-2 blue">
                    <div class="card-content">
                        <a class="black-text">Vacina 891#</a>
                    </div>
                </div>
            </div>
            <div class="col s3">
                <div class="card z-depth-2">
                    <div class="card-content">
                        <div class="row">
                            <a class="black-text">30/12/2022</a>
                        </div>
                        <a class="black-text">STATUS: <a class="black-text yellow">PENDENTE</a></a>
                    </div>
                </div>
            </div>
            <div class="col s3">
                <div class="card z-depth-2">
                    <div class="card-content">
                        <div class="row">
                            <a class="black-text">30/12/2022</a>
                        </div>
                        <a class="black-text">STATUS: <a class="black-text yellow">PENDENTE</a></a>
                    </div>
                </div>
            </div>
            <div class="col s3">
                <div class="card z-depth-2">
                    <div class="card-content">
                        <div class="row">
                            <a class="black-text">30/12/2022</a>
                        </div>
                        <a class="black-text">STATUS: <a class="black-text red">CANCELADO</a></a>
                    </div>
                </div>
            </div>
        </div>
    </body>

    <!-- IMPORTANDO RODAPE DA PAGINA -->
    <jsp:include page="../paginas_utilitarias/rodape_02.jsp" />
</html>
