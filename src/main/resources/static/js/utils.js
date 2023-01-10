
/**
 * Verifica se a string esta null
 * @param {} value 
 * @returns 
 */
function stringIsNull(value){
    if(value === undefined)return true;
    if(value === '')return true;
    if(value === null)return true;
    if(value === 'null')return true;
    return false;
}

/**
 * Verifica se a string nao esta null
 * @param {*} value 
 * @returns 
 */
function stringIsNotNull(value){
    return !stringIsNull(value);
}


/**
 * Monta data no formato 
 */
function parseDate(data){
	var day   = zeroPad(data.date.day, 2);
	var month = zeroPad(data.date.month, 2);
	var year  = data.date.year;
	var hora  = zeroPad(data.time.hour,2);
	var min   = zeroPad(data.time.minute, 2);
	return day+'/'+month+'/'+year + ' '+hora+':'+min;
}

function zeroPad(num, places) {
  var zero = places - num.toString().length + 1;
  return Array(+(zero > 0 && zero)).join("0") + num;
}




            

