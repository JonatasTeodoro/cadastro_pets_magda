buscarTipo();
var idAlert = 0;

function excluirTipo(id, nomeAnimal) {

    var alert = document.getElementById("divAlert");


    var clique = confirm("Voc\u00ea deseja excluir " + nomeAnimal + "?");
    if (clique == true) {

        var retorno = false;
        var a;
        $.ajax({
            url: 'ExcluirTipo?id=' + id,
            //async: false,
            success: function (data)
            {
                var obj = $.parseJSON(data);

                if (obj.status == 0) {
                    alert.innerHTML = alert.innerHTML + "<div id='alert" + idAlert + "' class='alert alert alert-primary alert-dismissible fade show' role='alert'><strong>Sucesso!</strong> Tipo deletado.<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>";
                } else if (obj.status == 1) {
                    alert.innerHTML = alert.innerHTML + "<div id='alert" + idAlert + "' class='alert alert-danger alert-dismissible fade show' role='alert'><strong>Erro!</strong> Erro ao deletar tipo.<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>";
                } else if (obj.status == 4) {
                    alert.innerHTML = alert.innerHTML + "<div id='alert" + idAlert + "' class='alert alert-warning alert-dismissible fade show' role='alert'><strong>Erro!</strong> Sess\u00e3o expirada! Refa\u00e7a o login!.<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>";
                } else if (obj.status == 3) {
                    alert.innerHTML = alert.innerHTML + "<div id='alert" + idAlert + "' class='alert alert-danger alert-dismissible fade show' role='alert'><strong>Erro!</strong> Existem animais com este TIPO cadastrados ainda.<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>";
                }

                buscarTipo();

                hello('alert' + idAlert);
                idAlert = idAlert + 1;

            }
        }).done(function () {
            a = true;
        });
        console.log(a);
        return retorno;
    }
}

function editarTipo(id, tipo) {

    var alert = document.getElementById("divAlert");

    document.getElementById("btnSalvar").disabled = true;
    document.getElementById("btnSalvar").innerHTML = "Editando";

    var retorno = false;
    var a;
    $.ajax({
        url: 'EditarTipo?id=' + id.value + "&descricao=" + ascii_to_hexa(tipo.value),
        //async: false,
        success: function (data)
        {
            var obj = $.parseJSON(data);

            if (obj.status == 0) {
                alert.innerHTML = alert.innerHTML + "<div id='alert" + idAlert + "' class='alert alert alert-primary alert-dismissible fade show' role='alert'><strong>Sucesso!</strong> Tipo editado.<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>";
            } else if (obj.status == 1) {
                alert.innerHTML = alert.innerHTML + "<div id='alert" + idAlert + "' class='alert alert-danger alert-dismissible fade show' role='alert'><strong>Erro!</strong> Erro ao editar tipo.<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>";
            } else if (obj.status == 4) {
                alert.innerHTML = alert.innerHTML + "<div id='alert" + idAlert + "' class='alert alert-warning alert-dismissible fade show' role='alert'><strong>Erro!</strong> Sess\u00e3o expirada! Refa\u00e7a o login!.<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>";
            }

            document.getElementById("btnSalvar").disabled = false;
            document.getElementById("btnSalvar").innerHTML = "Salvar";

            buscarTipo();

            $('#myModal').modal('hide');

            hello('alert' + idAlert);
            idAlert = idAlert + 1;

        }
    }).done(function () {
        a = true;
    });
    console.log(a);
    return retorno;

}

function cadastrarTipo(tipo) {

    var alert = document.getElementById("divAlert");

    document.getElementById("btnCadastrar").disabled = true;
    document.getElementById("btnCadastrar").innerHTML = "Editando";

    var retorno = false;
    var a;
    $.ajax({
        url: 'CadastrarTipo?descricao=' + ascii_to_hexa(tipo.value),
        //async: false,
        success: function (data)
        {
            var obj = $.parseJSON(data);

            if (obj.status == 0) {
                alert.innerHTML = alert.innerHTML + "<div id='alert" + idAlert + "' class='alert alert alert-primary alert-dismissible fade show' role='alert'><strong>Sucesso!</strong> Tipo cadastrado.<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>";
            } else if (obj.status == 1) {
                alert.innerHTML = alert.innerHTML + "<div id='alert" + idAlert + "' class='alert alert-danger alert-dismissible fade show' role='alert'><strong>Erro!</strong> Erro ao cadastrar tipo.<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>";
            } else if (obj.status == 4) {
                alert.innerHTML = alert.innerHTML + "<div id='alert" + idAlert + "' class='alert alert-warning alert-dismissible fade show' role='alert'><strong>Erro!</strong> Sess\u00e3o expirada! Refa\u00e7a o login!.<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>";
            }

            document.getElementById("btnCadastrar").disabled = false;
            document.getElementById("btnCadastrar").innerHTML = "Salvar";

            buscarTipo();

            $('#modalCadastro').modal('hide');
            tipo.value = "";

            hello('alert' + idAlert);
            idAlert = idAlert + 1;

        }
    }).done(function () {
        a = true;
    });
    console.log(a);
    return retorno;

}


function buscarTipo() {

    var alert = document.getElementById("divAlert");
    var tb = document.getElementById("resultTabela");
    var novaTabela = "";
    var msg = document.getElementById("msgAtualizarTabela");
    var btn = document.getElementById("btnAtualizarTabela");

    msg.innerHTML = "Preenchendo...";
    btn.disabled = true;

    var retorno = false;
    var a;
    $.ajax({
        url: 'BuscarTabelaTipo',
        //async: false,
        success: function (data)
        {
            var obj = $.parseJSON(data);

            $('#dataTable').DataTable().destroy();


            $('#dataTable').DataTable({
                "aaData": obj,
                "aoColumns": [
                    {"mDataProp": "descricao"},
                    {"mDataProp": "botao"}
                ],
                "language": {
                    "lengthMenu": "Mostrar _MENU_ linhas por p\u00e1gina",
                    "zeroRecords": "Nada encontrado",
                    "info": "Mostrando _PAGE_ de _PAGES_",
                    "infoEmpty": "Nenhum registro dispon\u00edvel",
                    "infoFiltered": "(filtrado de _MAX_ linhas no total)",
                    "search": "Buscar:",
                    "paginate": {
                        "first": "Primeira",
                        "last": "\u00daltima",
                        "next": "Pr\u00f3ximo",
                        "previous": "Anterior"
                    }

                },
                dom: 'Bfrtip',
                buttons: [
                    {
                        extend: 'copy',
                        exportOptions: {
                            columns: [0]
                        },
                        text: '<i>Copiar</i>',
                        titleAttr: 'Copiar dados da tabela'
                    },
                    {
                        extend: 'excel',
                        exportOptions: {
                            columns: [0]
                        },
                        text: '<i>EXCEL</i>',
                        titleAttr: 'Exportar para Excel'
                    },
                    {
                        extend: 'csv',
                        exportOptions: {
                            columns: [0]
                        },
                        text: '<i>CSV</i>',
                        titleAttr: 'Exportar para CSV'
                    },
                    {
                        extend: 'pdf',
                        exportOptions: {
                            columns: [0]
                        },
                        text: '<i>PDF</i>',
                        titleAttr: 'Exportar para PDF'

                    }
                ],
                columnDefs: [
                    {width: '10%', targets: 1}
                ],

            });



            $('#dataTable').DataTable();

//            for (var cont = 0; cont < obj.cadastro.length; cont++) {
//                novaTabela = novaTabela + '<tr><td>' + obj.cadastro[cont].proprietario + '</td><td>' + obj.cadastro[cont].nomeanimal + '</td><td>' + obj.cadastro[cont].tipo + '</td><td><a href="javascript:editarAnimal(' + obj.cadastro[cont].id + ', \'' + obj.cadastro[cont].nomeanimal + '\')" class="btn btn-warning btn-circle"><i class="fas fa-exclamation-triangle"></i></a><a style=\'margin-left: 3px\' href="javascript:excluirAnimal(' + obj.cadastro[cont].id + ', \'' + obj.cadastro[cont].nomeanimal + '\')" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a></td></tr>';
//            }
//
//            tb.innerHTML = novaTabela;

            msg.innerHTML = "Atualizar tabela";
            btn.disabled = false;

            //alert.innerHTML = alert.innerHTML + "<div class='alert alert-success alert-dismissible fade show' role='alert'><strong>Sucesso!</strong> Tabela atualizada com sucesso!<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>";

        }
    }).done(function () {
        a = true;
    });
    console.log(a);
    return retorno;

}

function atualizarTipo() {
    var alert = document.getElementById("divAlert");
    try {
        buscarTipo();
        alert.innerHTML = alert.innerHTML + "<div id='alert" + idAlert + "' class='alert alert-success alert-dismissible fade show' role='alert'><strong>Sucesso!</strong> Tabela atualizada com sucesso!<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>";
    } catch (a) {
        alert.innerHTML = alert.innerHTML + "<div id='alert" + idAlert + "' class='alert alert-danger alert-dismissible fade show' role='alert'><strong>Erro!</strong> Erro ao atualizar tabela!<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>";
    }
    hello('alert' + idAlert);
    idAlert = idAlert + 1;
}

function wait(ms) {
    return new Promise(r => setTimeout(r, ms));
}

async function hello(id) {
    await wait(7000);
    var el = document.getElementById(id);
    el.parentNode.removeChild(el);
}

function ascii_to_hexa(str)
{
    var arr1 = [];
    for (var n = 0, l = str.length; n < l; n++)
    {
        var hex = Number(str.charCodeAt(n)).toString(16);
        arr1.push(hex);
    }
    return arr1.join('');
}