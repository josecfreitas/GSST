<%-- 
    Autor: Jos� Carlos de Freitas
    Data: 11/07/2016, 12:09:22
    Arquivo: processos
--%>

<!DOCTYPE html>
<html>
    <head>
        <title>GSST - Seguran�a � vida</title>

        <%@include file="/WEB-INF/jsp/estrutura/importMetaCss.jsp" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    </head>
    <body>
        <div class="wraper">
            <!--Cabe�alho-->
            <%@include file="/WEB-INF/jsp/estrutura/cabecalho.jsp" %>

            <!--Conte�do-->
            <div class="conteudo">

                <h2>Processos</h2>
                <div class="row">
                    <c:choose>
                        <c:when test="${processos == null}">
                            <div class="col-xs-12">
                                <div class="alert alert-warning">
                                    <h4>N�o h� processos</h4>
                                    N�o h� processos cadastrados.
                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${processos}" var="p">
                                <div class="col-xs-12 col-sm-6 col-md-4">
                                    <a href="visualizar/${p.idProcesso}">
                                        <div class="box">
                                            <c:if test="${p.numFotos > 0}">
                                                <img width="100%" src="<%=request.getContextPath()%>/processoFoto?processo=${p.idProcesso}&img=1&mod=t" />
                                            </c:if>
                                            ${p.idProcesso}<br>
                                            Localiza��o: ${p.localizacao}<br>
                                            Setor: ${p.setor}<br>
                                            Medida Corretiva: ${p.medidaCorretiva}<br>
                                            Relatado em: <fmt:formatDate pattern="dd/MM/yyyy" type="date" value="${p.data}" /><br>
                                            Prazo: <fmt:formatDate pattern="dd/MM/yyyy" type="date" value="${p.prazo}" />
                                        </div>
                                    </a>
                                </div>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </div>

                <div class="text-right">
                    <a href="novo" class="btn btn-primary">Novo processo</a>
                </div>
            </div><!--Fim conte�do-->

            <!--Footer-->
            <%@include file="/WEB-INF/jsp/estrutura/rodape.jsp" %>
        </div>
        <!--ImportJS-->
        <%@include file="/WEB-INF/jsp/estrutura/importJs.jsp" %>
    </body>
</html>