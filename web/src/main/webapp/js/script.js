$(document).ready(function() {$('#search').keyup(function()
{
    var txt =  new RegExp($(this).val(), "i");
    $('#data > tbody > tr').each(function() {
        var child = $(this).text();
        child = child.replace("<td>", " ");
        child = child.replace("</td>", " ");
        child = child.trim();

        if(child.search(txt) == -1 )
        {
            $(this).hide();
        }
        else
        {
            $(this).show();
        }
    });

    return false;
})});