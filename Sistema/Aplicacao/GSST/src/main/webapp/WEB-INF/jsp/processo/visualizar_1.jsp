<%-- 
    Autor: Jos� Carlos de Freitas
    Data: 14/08/2016, 12:56:42
    Arquivo: visualizar
--%>

<!DOCTYPE html>
<html>
    <head>
        <title>GSST - Seguran�a � vida</title>

        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

        <%@include file="/WEB-INF/jsp/estrutura/importMetaCss.jsp" %>
        <link href="<%=request.getContextPath()%>/resources/plugins/FlexSlider-2.6.2/flexslider.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wraper">
            <!--Cabe�alho-->
            <%@include file="/WEB-INF/jsp/estrutura/cabecalho.jsp" %>

            <!--Conte�do-->
            <div class="conteudo">

                <h2>Processos</h2>
                <div class="box">
                    <div class="box-title">
                        Processo ${p.idProcesso}
                    </div>

                    <div class="row">
                        <div class="col-md-4 col-sm-6 col-xs-12">
                            <b>M�quina:</b> ${p.maquina.descricao} (${p.maquina.numPatrimonio})
                        </div>
                        <div class="col-md-4 col-sm-6 col-xs-12">
                            <b>Localizada:</b> ${p.localizacao}
                        </div>
                        <div class="col-md-4 col-sm-6 col-xs-12">
                            <b>Setor:</b> ${p.setor}
                        </div>
                        <div class="col-md-4 col-sm-6 col-xs-12">
                            <b>Medida Corretiva:</b> ${p.medidaCorretiva}
                        </div>
                        <div class="col-md-4 col-sm-6 col-xs-12">
                            <b>Relatado por:</b> ${p.funcionarioByIdRelator.nome}
                        </div>
                        <div class="col-md-4 col-sm-6 col-xs-12">
                            <b>Relatado em:</b> <fmt:formatDate pattern="dd/MM/yyyy" type="date" value="${p.data}" />
                        </div>
                        <c:if test="${p.funcionarioByIdRespCorrecao.nome != null}">
                            <div class="col-md-4 col-sm-6 col-xs-12">
                                <b>Repons�vel pela corre��o:</b> ${p.funcionarioByIdRespCorrecao.nome}
                            </div>
                        </c:if>
                        <c:if test="${p.prazo != null}">
                            <div class="col-md-4 col-sm-6 col-xs-12">
                                <b>Meta de corre��o:</b> <fmt:formatDate pattern="dd/MM/yyyy" type="date" value="${p.prazo}" />
                            </div>
                        </c:if>
                    </div>

                    <c:if test="${p.numFotos > 0}">
                        <div class="slider">
                            <ul class="slides">
                                <c:forEach begin="1" end="${p.numFotos}" var="i">
                                    <li>
                                        <img src="<%=request.getContextPath()%>/processoFoto?processo=${p.idProcesso}&img=${i}" />
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </c:if>
                </div>
            </div><!--Fim conte�do-->

            <!--Footer-->
            <%@include file="/WEB-INF/jsp/estrutura/rodape.jsp" %>
        </div>
        <!--ImportJS-->
        <%@include file="/WEB-INF/jsp/estrutura/importJs.jsp" %>
        <script src="<%=request.getContextPath()%>/resources/plugins/FlexSlider-2.6.2/jquery.flexslider-min.js" type="text/javascript"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                $('.slider').flexslider({
                    animation: "slide"
                });
            });
        </script>
    </body>
</html>