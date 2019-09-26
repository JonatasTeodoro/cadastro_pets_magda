function validarLogin() {

    var usuario = document.getElementById("usuario");
    var senha = document.getElementById("senha");
    var info = document.getElementById("infoLogin");
    var btn = document.getElementById("btnEntrar");

    btn.innerHTML = "Entrando...";
    btn.disabled = true;


    var retorno = false;
    var a;
    $.ajax({
        url: 'ValidarLogin?usuario=' + ascii_to_hexa(usuario.value) + "&senha=" + ascii_to_hexa(senha.value),
        //async: false,
        success: function (data)
        {
            var obj = $.parseJSON(data);

            if (obj.status == 1) {
                retorno = false;
                info.innerHTML = "Login ou Senha incorretos!";
                btn.innerHTML = "Entrar";
                btn.disabled = false;
            } else {
                document.getElementById('formLogin').submit();
                retorno = true;
            }


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
