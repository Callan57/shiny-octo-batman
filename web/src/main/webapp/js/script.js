//filtrage dynamique des données
$(document).ready(function() {$('#search').keyup(function()
{
    //configuraton de l'expresion régulière avec la valeur saisie dans le champs sans casse(i)
    var txt =  new RegExp($(this).val(), "i");
    //pour chaques lignes
    $('#data > tbody > tr').each(function() {
        var child = $(this).text();
        //on enléve les tr td est espaces inutiles
        child = child.replace("<td>", " ");
        child = child.replace("</td>", " ");
        child = child.trim();
        //si expression ne correspond pas
        if(child.search(txt) == -1 )
        {
            $(this).hide();//on cache la ligne
        }
        else
        {
            $(this).show();// on affiche la ligne
        }
    });

    return false;
})});