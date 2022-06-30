<%@page import="controlador.util.Mensaje"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Sistema de Matr&iacute;cula</title>
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
                ${modulo.getTitulos()} - <small><a class="btn btn-sm bg-olive" href="?accion=agregar">Agregar ${modulo.getTitulo()}</a></small>
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
                  <h3 class="box-title">${modulo.getTitulos()}</h3>
                </div>
                <div class="box-body">                                                                     
                    
                <!-- Bloque principal -->
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
                              <th>Apoderado ID</th>
                              <th>Nombre</th>
                              <th>Apellido Paterno</th>
                              <th>Apellido Materno</th>
                              <th>Tipo de documento</th>
                              <th>Numero de documento</th>
                              <th>Email</th>
                              <th>Celular</th>
                              <th width="8%">Estado</th>
                              <th width="10%">Creado</th>
                              <th width="10%">Modificado</th>
                            </tr>
                          </thead>
                          <tbody>
                              <c:forEach items="${listado}" var="item">                                                                
                            <tr>
                              <td class="td-btns">
                                <div class="btn-group">
                                    <a href="?accion=editar&id=${item.getIdApoderado()}" title="Editar" class="btn bg-green"><span class="fa fa-fw fa-edit"></span> </a>
                                    <a href="javascript:void(confirmarAccion('?accion=eliminar&id=${item.getIdApoderado()}'))" title="Eliminar" class="btn btn-danger"><span class="fa fa-fw fa-remove"></span> </a>
                                  </div>
                              </td>
                              <td>${item.getIdApoderado()}</td>
                              <td>${item.getNombres()}</td>
                              <td>as</td>
                              <td>${item.getTurno().getNombreTurno()}</td>
                              <td>${item.getSeccion().getNombreSeccion()}</td>
                              <td>${item.getVacantes()}</td>
                              <td>${item.getEstadoString()}</td>                              
                              <td>${item.getCreadoString()}</td>
                              <td>${item.getModificadoString()}</td>
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
               <!-- /.Bloque principal -->
               
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
