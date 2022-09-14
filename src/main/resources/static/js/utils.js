
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