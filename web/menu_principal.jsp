<%@page import="MODEL.Cadastro"%>
<%@page import="MODEL.Usuario"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="img/favicon.png">

        <title>Menu</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css?version=2" rel="stylesheet">

        <script type="text/javascript">
            function handleInput(e) {
                var ss = e.target.selectionStart;
                var se = e.target.selectionEnd;
                e.target.value = e.target.value.toUpperCase();
                e.target.selectionStart = ss;
                e.target.selectionEnd = se;
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
        <div id="wrapper">

            <!-- Sidebar -->
            <jsp:include page="menu_lateral.jsp" />
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->


                    <!-- Begin Page Content -->
                    <div class="container-fluid">


                        <div style="margin-top: 30px" class="row">

                            <!-- Area Chart -->
                            <div class="col-xl-12 col-lg-12">
                                <div class="card shadow mb-4">
                                    <!-- Card Header - Dropdown -->
                                    <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                        <h6 class="m-0 font-weight-bold text-primary">Novo cadastro</h6>
                                        <div class="dropdown no-arrow">
                                            <label>Usuário: <%=usuario.getNome()%></label>
                                        </div>
                                    </div>
                                    <!-- Card Body -->
                                    <div class="card-body">

                                        <%Cadastro obj = (Cadastro) request.getAttribute("cadastro");
                                            if (obj == null) {
                                                obj = new Cadastro();
                                            }
                                        %>

                                        <form id="formCadastro" onsubmit="return cadastrarAnimal()" class="user">
                                            <input type="hidden" id="id" value="<%=obj.getId()%>">

                                            <div class="row">
                                                <div class="form-group col-md-4">
                                                    <label>Proprietário:</label>
                                                    <input autocomplete="off" required="" value="<%=obj.getProprietario()%>" oninput="handleInput(event)" type="text" class="form-control" id="proprietario" autofocus="">
                                                </div>
                                                <div class="form-group col-md-4">
                                                    <label>Nome do animal:</label>
                                                    <input autocomplete="off" value="<%=obj.getNomeAnimal()%>" required="" oninput="handleInput(event)" type="text" class="form-control" id="nomeanimal">
                                                </div>
                                                <div class="form-group col-md-4">
                                                    <label for="exampleFormControlSelect1">Tipo de animal:</label>
                                                    <select required="" class="form-control" id="tipo">
                                                        <option value="">SELECIONE...</option>
                                                        <option <%if (obj.getTipo().equals("CACHORRO")) {%>selected=""<%}%> value="CACHORRO">CACHORRO</option>
                                                        <option <%if (obj.getTipo().equals("GATO")) {%>selected=""<%}%> value="GATO">GATO</option>
                                                    </select>
                                                </div>
                                            </div>

                                                    <button id="btnSalvar" style="background-color: #668069" class="btn btn-success btn-icon-split">
                                                <span class="icon text-white-50">
                                                    <i class="fas fa-check"></i>
                                                </span>
                                                <span class="text">Salvar</span>
                                            </button>
                                        </form>
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

            <div id="divAlert" class="col-md-5">

            </div>

            <!-- Bootstrap core JavaScript-->
            <script src="vendor/jquery/jquery.min.js"></script>
            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

            <!-- Core plugin JavaScript-->
            <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

            <!-- Custom scripts for all pages-->
            <script src="js/sb-admin-2.min.js?version=2"></script>

            <!-- Page level plugins -->
            <script src="vendor/chart.js/Chart.min.js"></script>

            <!-- Page level custom scripts -->
            <script src="js/demo/chart-area-demo.js"></script>
            <script src="js/demo/chart-pie-demo.js"></script>
            <script src="js/cadastro_animais.js?version=14"></script>
            <script src="js/sumir_alerts.js?version=1"></script>

    </body>

</html>
