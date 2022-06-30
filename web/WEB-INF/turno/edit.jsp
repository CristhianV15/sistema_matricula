<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Sistema de Matr&iacute;cula</title>
  <%@include file="/WEB-INF/base/header.jsp" %>
  </head>
      <body class="hold-transition skin-blue sidebar-mini">
        <!-- Site wrapper -->
        <div class="wrapper">
          <%@include file="/WEB-INF/base/top.jsp" %>
          <!-- =============================================== -->
          <!-- Left side column. contains the sidebar -->
          <!-- Left side column. contains the sidebar -->
          <%@include file="/WEB-INF/base/menu.jsp" %>
          <!-- =============================================== -->
          <!-- Content Wrapper. Contains page content -->
          <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
              <h1>
                ${modulo.getTitulos()} - <small><a class="btn btn-sm bg-olive" href="?accion=editar">Agregar ${modulo.getTitulo()}</a></small>
              </h1>
              <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
                <li class="active"><a href="${modulo.getPathUrl()}">${modulo.getTitulo()}</a></li>
              </ol>
            </section>

            <!-- Main content -->
            <section class="content">
              <div class="row">
                <div class="col-md-8">
                    <!-- general form elements -->
                    <div class="box box-primary">
                      <div class="box-header with-border">
                        <h3 class="box-title">Editar ${modulo.getTitulo()}</h3>
                      </div><!-- /.box-header -->
                      <!-- form start -->
                      <form role="form" action="?accion=editar-guardar&id=${obj.getIdTurno()}" method="post" autocomplete="off">
                        <div class="box-body">
                          <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" class="form-control" name="nombre" required value="${obj.getNombreTurno()}">
                          </div>
                          <div class="form-group">
                           <div class="row">
                            <label class="col-sm-12">Estado</label>
                              <div class="col-sm-6">
                            <select class="form-control input-width-auto" name="estado" required>
                                <option></option>
                              <c:forEach items="${estados}" var="value">
                              <option value="${value.getId()}"
                                      <c:if test="${ value.getId() == obj.getEstado() }"> selected </c:if>
                                      >${value.getNombre()}</option>
                              </c:forEach>
                            </select>
                          </div>
                        </div>
                          </div>
                        </div><!-- /.box-body -->
                        <div class="box-footer">
                          <button type="submit" class="btn btn-sm btn-primary">Guardar</button>
                          &nbsp;&nbsp;
                          <a class="btn btn-sm btn-danger" href="${modulo.getPathUrl()}">Regresar a la lista</a>
                        </div>
                      </form>
                    </div><!-- /.box -->
                  </div>
                </div>
            </section><!-- /.content -->

            </div><!-- /.content-wrapper -->

            <%@include file="/WEB-INF/base/footer-top.jsp" %>

      <!-- Add the sidebar's background. This div must be placed
      immediately after the control sidebar -->
      <div class="control-sidebar-bg"></div>
    </div><!-- ./wrapper -->

    <%@include file="/WEB-INF/base/footer.jsp" %>
  </body>
</html>
