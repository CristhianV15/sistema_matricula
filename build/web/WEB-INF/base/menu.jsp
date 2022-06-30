<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside class="main-sidebar">
            <!-- sidebar: style can be found in sidebar.less -->
            <section class="sidebar">
              <!-- Sidebar user panel -->
              <div class="user-panel">
                <div class="pull-left image">
                  <img src="media/backend/images/ico_user.png" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                  <p>admin</p>
                  <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
              </div>
              <!-- sidebar menu: : style can be found in sidebar.less -->
              <ul class="sidebar-menu">
                  <li class="header">NAVEGACI&Oacute;N</li>
                      <li class="treeview <c:if test="${modulo.getMenuItem() == 'inicio'}">active</c:if> ">
                        <a href="./inicio">
                          <i class="fa fa-dashboard"></i> <span>Inicio</span>
                        </a>
                      </li>
<!--                      <li class="treeview  ">
                        <a href="./crud">
                          <i class="fa fa-circle-o"></i> <span>Crud</span>
                        </a>
                      </li>-->
<!--                      <li class="treeview <c:if test="${modulo.getMenuItem() == 'matricula'}">active</c:if> ">
                        <a href="./matricula">
                          <i class="fa fa-circle-o"></i> <span>Matriculas</span>
                        </a>
                      </li>-->
                      <li class="treeview <c:if test="${modulo.getMenuItem() == 'salon'}">active</c:if> ">
                        <a href="./salon">
                          <i class="fa fa-circle-o"></i> <span>Salones</span>
                        </a>
                      </li>
<!--                      <li class="treeview <c:if test="${modulo.getMenuItem() == 'alumno'}">active</c:if> ">
                        <a href="./alumno">
                          <i class="fa fa-circle-o"></i> <span>Alumnos</span>
                        </a>
                      </li>-->
                      <li class="treeview <c:if test="${modulo.getMenuItem() == 'ciclo'}">active</c:if> ">
                        <a href="./ciclo">
                          <i class="fa fa-circle-o"></i> <span>Ciclos</span>
                        </a>
                      </li>
                      <li class="treeview <c:if test="${modulo.getMenuItem() == 'grado'}">active</c:if> ">
                        <a href="./grado">
                          <i class="fa fa-circle-o"></i> <span>Grados</span>
                        </a>
                      </li>
                      <li class="treeview <c:if test="${modulo.getMenuItem() == 'turno'}">active</c:if> ">
                        <a href="./turno">
                          <i class="fa fa-circle-o"></i> <span>Turnos</span>
                        </a>
                      </li>
                      <li class="treeview <c:if test="${modulo.getMenuItem() == 'seccion'}">active</c:if> ">
                        <a href="./seccion">
                          <i class="fa fa-circle-o"></i> <span>Secciones</span>
                        </a>
                      </li>
                      <li class="treeview <c:if test="${modulo.getMenuItem() == 'usuario'}">active</c:if> ">
                        <a href="./usuario">
                          <i class="fa fa-circle-o"></i> <span>Usuarios</span>
                        </a>
                      </li>
<!--                      <li class="treeview <c:if test="${modulo.getMenuItem() == 'micuenta'}">active</c:if> ">
                        <a href="./micuenta">
                          <i class="fa fa-circle-o"></i> <span>Mi Cuenta</span>
                        </a>
                      </li>-->
                      <li class="treeview">
                        <a href="./">
                          <i class="fa fa-circle-o"></i> <span>Salir</span>
                        </a>
                      </li>
                    </ul>
            </section>
            <!-- /.sidebar -->
          </aside>