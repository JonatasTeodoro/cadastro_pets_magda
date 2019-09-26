<!DOCTYPE html>
<html lang="pt-br">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="img/favicon.png">

        <title>Login</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">


    </head>

    <body class="bg-gradient-primary">

        <div  class="container">

            <!-- Outer Row -->
            <div  class="row justify-content-center" >

                <div  class="col-xl-10 col-lg-12 col-md-9" >

                    <div  class="card o-hidden border-0 shadow-lg my-5" >
                        <div style=" border: #658067 solid 2px"  class="card-body p-0" >
                            <!-- Nested Row within Card Body -->
                            <div class="row" >
                                <div style=" border-left: #658067 solid 12px" class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                                <div class="col-lg-6">
                                    <div class="p-5">
                                        <div class="text-center">
                                            <h1 style="color: #178024" class="h4 mb-4">Seja bem vindo!</h1>
                                        </div>
                                        <form id="formLogin" action="EfetuarLogin" onsubmit="return validarLogin()" class="user" accept-charset="iso-8859-1" method="post">
                                            <div class="form-group">
                                                <input autocomplete="off" required="" type="text" class="form-control form-control-user" name="usuario" id="usuario" aria-describedby="emailHelp" placeholder="Usuário">
                                            </div>
                                            <div class="form-group">
                                                <input autocomplete="off" required="" type="password" class="form-control form-control-user" name="senha" id="senha" placeholder="Senha">
                                            </div>

                                            <div class="col-md-12">
                                                <label style="color: red" id="infoLogin"></label>
                                            </div>

                                            <button id='btnEntrar' type="submit" class="btn btn-success btn-block" style="background-color: #668069; border-color: #668069">Entrar</button>
                                        </form>

                                        <center>
                                            <img src="img/logo.png" style="width: 200px; margin-top: 30px;">
                                            <!--<h2 style=" color: #668069">Cadastro de animais Magda-SP</h2>-->
                                        </center>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>
        <script src="js/validar_login.js?version=2"></script>

    </body>

</html>
