function inputChooseOneQuestion(group, choice) {
    $('#choice-' + group).val(choice);
}

function inputChooseManyQuestion(group, choice) {
    var choices = $('#checkbox-' + group).val();
    var arrChoices = choices.split(',').filter(function(i) {return i !== ''});
    var ind = arrChoices.indexOf('' + choice);
    if(ind === -1) {
        arrChoices.push(choice);
    } else {
        arrChoices.splice(ind, 1);
    }
    $('#checkbox-' + group).val(arrChoices.join(','));
}
