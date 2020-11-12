
var bracketMatching = function (str) 
{

    var stack = [];
    // creating an object(dictionary) to store the equivalent closing bracket
    // of an opening bracket
    var map = 
    {
        '(': ')',
        '[': ']',
        '{': '}'
    }

    for (let i = 0; i < str.length; i++) 
    {

        // If character is an opening brace add it to a stack
        if (str[i] === '(' || str[i] === '{' || str[i] === '[' ) 
        {
            stack.push(str[i]);
        }
        //  If that character is a closing brace, pop from the stack
        else 
        {
            let last = stack.pop();

            //If the popped element from the stack,  doesn’t match the corresponding 
            // closing bracket in the map, then return false
            if (str[i] !== map[last]) 
            {
                return false;
            }
        }
    }
    // By the completion of the for loop after checking all the
    // brackets of the str, at the end, if the stack is not empty then 
    //return false
    if (stack.length !== 0) 
    {
        return false;
    }
    
    // if all above checks are satisfied, return true
    return true;
}


var inputString = prompt("Enter any string containing {,(,[,],)or }:");

console.log(bracketMatching(inputString));


