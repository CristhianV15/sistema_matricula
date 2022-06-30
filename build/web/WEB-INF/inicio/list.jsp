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
                ${modulo.getTitulos()} 
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
