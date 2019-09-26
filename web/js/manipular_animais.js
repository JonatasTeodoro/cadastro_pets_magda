buscarTabela();

function excluirAnimal(id, nomeAnimal) {

    var alert = document.getElementById("divAlert");


    var clique = confirm("Você deseja excluir " + nomeAnimal + "?");
    if (clique == true) {

        var retorno = false;
        var a;
        $.ajax({
            url: 'ExcluirAnimal?id=' + id,
            //async: false,
            success: function (data)
            {
                var obj = $.parseJSON(data);

                if (obj.status == 0) {
                    alert.innerHTML = alert.innerHTML + "<div class='alert alert alert-primary alert-dismissible fade show' role='alert'><strong>Sucesso!</strong> Animal deletado.<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>";
                } else if (obj.status == 1) {
                    alert.innerHTML = alert.innerHTML + "<div class='alert alert-danger alert-dismissible fade show' role='alert'><strong>Erro!</strong> Erro ao deletar animal.<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>";
                } else if (obj.status == 4) {
                    alert.innerHTML = alert.innerHTML + "<div class='alert alert-warning alert-dismissible fade show' role='alert'><strong>Erro!</strong> Sessão expirada! Refaça o login!.<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>";
                }

                buscarTabela();

            }
        }).done(function () {
            a = true;
        });
        console.log(a);
        return retorno;
    }
}


function buscarTabela() {

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
        url: 'BuscarTabela',
        //async: false,
        success: function (data)
        {
            var obj = $.parseJSON(data);

            for (var cont = 0; cont < obj.cadastro.length; cont++) {
                novaTabela = novaTabela + '<tr><td>' + obj.cadastro[cont].proprietario + '</td><td>' + obj.cadastro[cont].nomeanimal + '</td><td>' + obj.cadastro[cont].tipo + '</td><td><a href="javascript:editarAnimal(' + obj.cadastro[cont].id + ', \'' + obj.cadastro[cont].nomeanimal + '\')" class="btn btn-warning btn-circle"><i class="fas fa-exclamation-triangle"></i></a><a style=\'margin-left: 3px\' href="javascript:excluirAnimal(' + obj.cadastro[cont].id + ', \'' + obj.cadastro[cont].nomeanimal + '\')" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a></td></tr>';
            }

            tb.innerHTML = novaTabela;

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

function atualizarTabela() {
    var alert = document.getElementById("divAlert");
    try {
        buscarTabela();
        alert.innerHTML = alert.innerHTML + "<div class='alert alert-success alert-dismissible fade show' role='alert'><strong>Sucesso!</strong> Tabela atualizada com sucesso!<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>";
    } catch (a) {
        alert.innerHTML = alert.innerHTML + "<div class='alert alert-danger alert-dismissible fade show' role='alert'><strong>Erro!</strong> Erro ao atualizar tabela!<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>";
    }
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