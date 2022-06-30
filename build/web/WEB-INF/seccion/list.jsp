<%@page import="controlador.util.Mensaje"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Intranet</title>
  <%@include file="/WEB-INF/base/header.jsp" %>
  </head>
      <body class="hold-transition skin-blue sidebar-mini ">
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
                ${modulo.getTitulo()} - <small><a class="btn btn-sm bg-olive" href="?accion=agregar">Agregar ${modulo.getTitulo()}</a></small>
              </h1>
              <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
                <li class="active"><a href="${modulo.getPathUrl()}">${modulo.getTitulo()}</a></li>
              </ol>
            </section>

            <!-- Main content -->
            <section class="content">
                <%@include file="/WEB-INF/base/mensaje.jsp" %>  
              <div class="box">
                <div class="box-header">
                  <h3 class="box-title">${modulo.getTitulo()}</h3>
                </div>
                <div class="box-body">                                                                     
                    

              <form method="post" action="" id="form_result_list">

                    <div class="row form-group">
                        <div class="col-sm-6"></div>
                        <div class="col-sm-6">
                          <div class="text-right">
                            Total: ${listado.size()}
                          </div>
                        </div>
                      </div>
                  <div class="row">
                    <div class="col-sm-12">
                      <div class="table-responsive">
                        <table id="example1" class="table table-bordered table-striped">
                          <thead>
                            <tr>
                              <th width="14%">Acciones</th>
                              <th>ID</th>
                              <th>Secciones</th>
                              <th width="8%">Estado</th>
                              <th width="10%">Creado</th>
                            </tr>
                          </thead>
                          <tbody>
                              <c:forEach items="${listado}" var="item">                                                                
                            <tr>
                              <td class="td-btns">
                                <div class="btn-group">
                                    <a href="?accion=editar&id=${item.getIdSeccion()}" title="Editar" class="btn bg-green"><span class="fa fa-fw fa-edit"></span> </a>
                                    <a href="javascript:void(confirmarAccion('?accion=eliminar&id=${item.getIdSeccion()}'))" title="Eliminar" class="btn btn-danger"><span class="fa fa-fw fa-remove"></span> </a>
                                  </div>
                              </td>
                              <td>${item.getIdSeccion()}</td>
                              <td>${item.getNombreSeccion()}</td>
                              <td>${item.getEstadoString()}</td>
                              <td>${item.getCreadoString()}</td>
                            </tr>
                            </c:forEach>
                          </tbody>
                        </table>
                        <div class="navigation text-center">

                        </div>
                      </div>
                    </div>
                  </div>
                </form>
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
    <script type="text/javascript">
      function filtrar(e){
      var fields = {};
      fields.scontiene = $("#scontiene").val();
      fields.sdesde = $("#sdesde").val();
      fields.shasta = $("#shasta").val();
      fields.sordenado1 = $("#sordenado1").val();
      fields.sordenado2 = $("#sordenado2").val();
      fields.sestado = $("#sestado").val();
      fields.spaciente = $("#spaciente").val();
      url = $("#form_result_list").attr('action')+ '?' +jQuery.param( fields );
      $(e).addClass('disabled');
      redireccion(url);
    }
    function filtrar_restart(e){
      var fields = {};
      fields.scontiene = '';
      fields.sdesde = '';
      fields.shasta = '';
      fields.sordenado1 = '';
      fields.sordenado2 = '';
      fields.sestado = '';
      fields.spaciente = '';
      url = $("#form_result_list").attr('action')+ '?' +jQuery.param( fields );
      $(e).addClass('disabled');
      redireccion(url);
    }
    </script>
  </body>
</html>
