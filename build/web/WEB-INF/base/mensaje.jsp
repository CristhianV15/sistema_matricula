<%@page import="controlador.util.Mensaje"%>
<%
Mensaje mensaje = new Mensaje(request);
String men = mensaje.getMsg(); 
if (null!=men && men!="") {
%>
<div class="alert alert-info"><%=men%></div>
<%}%>    