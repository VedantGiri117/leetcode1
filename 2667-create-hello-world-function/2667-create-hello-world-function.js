// const HelloWorld = function(){
//     return function(){
//         return "hello world"
//     }
// }
// console.log(HelloWorld())

// const createHelloWorld = function(...arg){
//     return function(){
//         return "Hello World"
//     }
// }

// console.log(createHelloWorld())

function createHelloWorld(){
    return function(...args){
        return "Hello World";
    };
}


