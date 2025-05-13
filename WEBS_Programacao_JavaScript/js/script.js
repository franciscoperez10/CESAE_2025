/* let myFirstVar = "Olá Mundo!";
let jsIsCool = true;

console.log(jsIsCool);
jsIsCool= "aborreci-me dele";
console.log(jsIsCool);
jsIsCool= "12";
console.log(jsIsCool+1); */

/* let day1 = "segunda-feira";
let day2 = "terça-feira";
let day3 = "quarta-feira";

let weekDays = ['segunda-feira', 'terça-feira', 'quarta-feira'];
console.log(weekDays[0]);

let shoppingList = ['banana', 'maçã', 'laranja'];
let item = prompt("Qual o item que quer adicionar à lista?");
newShoppingList.push(item);
console.log(shoppingList); */

/* let planets = ['Mercúrio', 'Vénus', 'Terra', 'Mart', 'Júpiter', 'Saturno', 'Urano', 'Neptuno', 'Plutão'];
planets [3] = planets[3].replace('Mart', 'Marte');
console.log(planets[3]);

planets.pop();
console.log(planets);

planets.unshift('Galaxy');
console.log(planets); */


/* for (let i = 1; i < 7; i++) {
    console.log("Da ba dee da ba da");
}

for (let i = 25; i>= 5; i -= 5) {
    console.log(i);
} */

/* const people = ["Scooby", "Velma", "Daphne", "Shaggy", "Fred"];
const uppercasedPeople = [];
for (let i = 0; i < people.length; i++) {
    uppercasedPeople.push(people[i].toUpperCase());
}
console.log(uppercasedPeople); */

/*EXERCÍCIO 1

const shoppingList = [];
let adicionarItem = true;

while (adicionarItem) {
    const item = prompt("Qual o item que quer adicionar à lista? (Digite 'fim' para terminar)");
    if (item && item.toLowerCase() === "fim") {
        adicionarItem = false; // Termina o ciclo se o utilizador digitar "fim"
    } else if (item) {
        shoppingList.push(item); // Adiciona o item à lista se for válido
    } else {
        alert("Por favor, insira um item válido."); // Alerta para entradas inválidas
    }
}

console.log("Lista de compras:", shoppingList); */

/*EXERCÍCIO 2*/

const shoppingList = [];
let adicionarItem = true;
while (adicionarItem) {
    const item = prompt("Qual o item que quer adicionar à lista? (Digite 'fim' para terminar)");
    if (item && item.toLowerCase() === "fim") {
        adicionarItem = false; 
    } else if (item) {
        shoppingList.push(item); 
    } else {
        alert("Por favor, insira um item válido."); 
    }
}

console.log("Lista de compras:", shoppingList);
