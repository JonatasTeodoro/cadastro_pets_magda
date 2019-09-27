<%@page import="MODEL.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="MODEL.Cadastro"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="img/favicon.png">

        <title>Registro de animais do município de Magda-SP</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/sb-admin-2.min.css?version=2" rel="stylesheet">

        <!-- Custom styles for this page -->





        <script src="vendor/jquery/jquery.min.js"></script>
        <script type="text/javascript">
            function handleInput(e) {
                var ss = e.target.selectionStart;
                var se = e.target.selectionEnd;
                e.target.value = e.target.value.toUpperCase();
                e.target.selectionStart = ss;
                e.target.selectionEnd = se;
            }


        </script>


        <script type="text/javascript">
            function sleep(milliseconds) {
                var start = new Date().getTime();
                for (var i = 0; i < 1e7; i++) {
                    if ((new Date().getTime() - start) > milliseconds) {
                        break;
                    }
                }
            }


            function msg() {
                sleep(2000);
                alert("Foi");
            }
        </script>

        <style type="text/css">
            #divAlert{
                position: fixed;
                _position:absolute;
                _margin-bottom:0;
                _margin-right:0;
                right:0;
                bottom:0;
                z-index:100;
            }
        </style>


    </head>

    <body id="page-top">
        <%
            Usuario usuario = (Usuario) session.getAttribute("autenticado");

            if (usuario == null || usuario.getId() == 0) {
                usuario = new Usuario();
                response.sendRedirect("sessao_expirada.jsp");
            }


        %>

        <!-- Page Wrapper -->
        <div  id="wrapper">

            <!-- Sidebar -->
            <ul style="background-color: #022700" class="navbar-nav  sidebar sidebar-dark accordion toggled" id="accordionSidebar">



                <!-- Nav Item - Dashboard -->
                <jsp:include page="menu_lateral.jsp" />

                <!-- Sidebar Toggler (Sidebar) -->
                <!--<div style="margin-top: 30px" class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>-->

            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->


                    <!-- Begin Page Content -->
                    <div class="container-fluid">


                        <div style="margin-top: 10px" class="row">


                            <!-- Card Header - Dropdown -->
                            <!-- Card Body -->
                            <div class="card-body">
                                <div class="card shadow mb-4">

                                    <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                        <h6 class="m-0 font-weight-bold text-primary">Consulta</h6>
                                        <div class="dropdown no-arrow">
                                            <label>Usuário: <%=usuario.getNome()%></label>
                                        </div>
                                    </div>

                                    <div class="card-body">
                                        <div class="table-responsive">

                                            <button id="btnAtualizarTabela" style="margin-bottom: 30px; background-color: #022700" onclick="atualizarTabela()" class="btn btn-primary btn-icon-split">
                                                <span class="icon text-white-50">
                                                    <i class="fas fa-flag"></i>
                                                </span>
                                                <span id="msgAtualizarTabela" class="text">Atualizar tabela</span>
                                            </button>
                                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                                <thead>
                                                    <tr>
                                                        <th>Proprietário</th>
                                                        <th>Animal</th>
                                                        <th>Tipo</th>
                                                        <th>Ação</th>
                                                    </tr>
                                                </thead>
                                                <tfoot>
                                                    <tr>
                                                        <th>Proprietário</th>
                                                        <th>Animal</th>
                                                        <th>Tipo</th>
                                                        <th>Ação</th>
                                                    </tr>
                                                </tfoot>
                                                <tbody>
                                                    <tr>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                        <td></td>
                                                    </tr>

                                                </tbody>
                                            </table>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <!-- /.container-fluid -->

                    </div>
                    <!-- End of Main Content -->


                    <!-- End of Footer -->

                </div>
                <!-- End of Content Wrapper -->

            </div>
            <!-- End of Page Wrapper -->

            <!-- Scroll to Top Button-->
            <a class="scroll-to-top rounded" href="#page-top">
                <i class="fas fa-angle-up"></i>
            </a>

            <!-- Logout Modal-->
            <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span>
                            </button>
                        </div>
                        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                        <div class="modal-footer">
                            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                            <a class="btn btn-primary" href="login.html">Logout</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="divAlert" class="col-md-5">

        </div>

        <script type="text/javascript">




            function editarAnimal(id, nomeAnimal) {
                var clique = confirm("Você deseja editar " + nomeAnimal + "?");
                if (clique == true) {
                    location.href = 'EditarAnimal?id=' + id;
                }
            }
        </script>

        <!-- Bootstrap core JavaScript-->

        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js?version=2"></script>

        <!-- Page level plugins -->
        <script src="vendor/datatables/jquery.dataTables.js"></script>
        <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="js/demo/datatables-demo.js"></script>
        <script src="js/manipular_animais.js?version=58"></script>
        <script src="js/sumir_alerts.js?version=1"></script>


        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link href="https://cdn.datatables.net/buttons/1.5.6/css/buttons.dataTables.min.css" rel="stylesheet">

        <script src="https://cdn.datatables.net/buttons/1.5.6/js/dataTables.buttons.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.flash.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
        <script src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.html5.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.print.min.js"></script>










    </body>

</html>







