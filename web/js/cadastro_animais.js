function cadastrarAnimal() {

    var proprietario = document.getElementById("proprietario");
    var nomeanimal = document.getElementById("nomeanimal");
    var tipo = document.getElementById("tipo");
    var id = document.getElementById("id");

    var alert = document.getElementById("divAlert");

    var botao = document.getElementById("btnSalvar");

    botao.disabled = true;
    botao.innerHTML = " <span class='icon text-white-50'><i class='fas fa-check'></i></span><span class='text'>Salvando...</span>";



    var retorno = false;
    var a;
    $.ajax({
        url: 'CadastrarAnimal?proprietario=' + ascii_to_hexa(proprietario.value) + "&nomeAnimal=" + ascii_to_hexa(nomeanimal.value) + "&tipo=" + ascii_to_hexa(tipo.value) + "&id=" + id.value,
        //async: false,
        success: function (data)
        {
            var obj = $.parseJSON(data);

            if (obj.status == 0) {
                alert.innerHTML = alert.innerHTML + "<div class='alert alert-success alert-dismissible fade show' role='alert'><strong>Sucesso!</strong> Animal cadastrado.<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>";
            } else if (obj.status == 1) {
                alert.innerHTML = alert.innerHTML + "<div class='alert alert-danger alert-dismissible fade show' role='alert'><strong>Erro!</strong> Erro ao cadastrar animal.<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>";
            } else if (obj.status == 2) {
                alert.innerHTML = alert.innerHTML + "<div class='alert alert-success alert-dismissible fade show' role='alert'><strong>Sucesso!</strong> Animal editado.<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>";
            } else if (obj.status == 3) {
                alert.innerHTML = alert.innerHTML + "<div class='alert alert-danger alert-dismissible fade show' role='alert'><strong>Erro!</strong> Erro ao editar animal.<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>";
            } else if (obj.status == 4) {
                alert.innerHTML = alert.innerHTML + "<div class='alert alert-warning alert-dismissible fade show' role='alert'><strong>Erro!</strong> Sessão expirada! Refaça o login!.<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button></div>";
            }

            limparForm();
            botao.disabled = false;
            botao.innerHTML = " <span class='icon text-white-50'><i class='fas fa-check'></i></span><span class='text'>Salvar</span>";

        }
    }).done(function () {
        a = true;
    });
    console.log(a);
    return retorno;
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

function limparForm() {
    var proprietario = document.getElementById("proprietario").value="";
    var nomeanimal = document.getElementById("nomeanimal").value="";;
    var tipo = document.getElementById("tipo").value="";;
    var id = document.getElementById("id").value=0;
}