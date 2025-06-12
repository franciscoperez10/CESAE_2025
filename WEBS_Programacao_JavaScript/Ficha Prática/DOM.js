// Exercício 1
function changeColor(element, color) {
    element.style.backgroundColor = color;
}

document.getElementById('btn1').addEventListener('click', function () {
    changeColor(this, 'red');
});
document.getElementById('btn2').addEventListener('click', function () {
    changeColor(this, 'green');
});
document.getElementById('btn3').addEventListener('click', function () {
    changeColor(this, 'blue');
});

// Exercício 2
let christmasGifts = [
    { name: 'perfume', price: 40 },
    { name: 'chocolate', price: 10 },
    { name: 'creme', price: 10 }
];

const newChristmasGifts = christmasGifts.filter(gift => gift.price < 20);
console.log(newChristmasGifts);

// Exercício 3
const users = [
    { nome: "Rafaela", idade: 22, curso: "JS Avançado" },
    { nome: "Bruno", idade: 30, curso: "UI/UX Design" },
    { nome: "Carla", idade: 25, curso: "AWS" }
];

const userDescriptions = users.map(user =>
    `${user.nome} tem ${user.idade} anos e está inscrito no curso de Software Developer`
);
console.log(userDescriptions);

// Exercício 4, 5 & 6
document.getElementById('btn4').addEventListener('click', escrever);

function escrever() {
    const div = document.querySelector('div');
    const p = document.createElement('p');
    p.innerText = 'É só mais um esforço para tirar o curso de Software Developer e serei um grande programador.';

    const btnAumentar = document.createElement('button');
    btnAumentar.innerText = 'Aumentar texto e centralizar';
    btnAumentar.addEventListener('click', () => {
        p.style.fontSize = '20px';
        p.style.textAlign = 'center';
    });

    const btnDiminuir = document.createElement('button');
    btnDiminuir.innerText = 'Diminuir texto e alinhar à direita';
    btnDiminuir.addEventListener('click', () => {
        p.style.fontSize = '10px';
        p.style.textAlign = 'right';
    });

    div.appendChild(btnAumentar);
    div.appendChild(btnDiminuir);
    div.appendChild(p);
}

// Exercício 7
document.getElementById('mostraBtn').addEventListener('click', mostraSolucao);

function mostraSolucao() {
    const paragrafo = document.getElementById('solucao');
    const botao = document.getElementById('mostraBtn');
    
    if (paragrafo.style.display === 'none') {
        paragrafo.style.display = 'block';
        botao.textContent = 'Esconder';
    } else {
        paragrafo.style.display = 'none';
        botao.textContent = 'Mostrar';
    }
}

// Exercício 8
let contador = 0;

document.getElementById('aumentar').addEventListener('click', () => alterarContador('aumentar'));
document.getElementById('diminuir').addEventListener('click', () => alterarContador('diminuir'));
document.getElementById('reset').addEventListener('click', () => alterarContador('zero'));

function alterarContador(operacao) {
    if (operacao === 'aumentar') contador++;
    else if (operacao === 'diminuir') contador--;
    else if (operacao === 'zero') contador = 0;

    atualizarEcrã();
}

function atualizarEcrã() {
    document.getElementById('contador').textContent = contador;
}

// Exercício 9
document.getElementById('btnEscreverAprendido').addEventListener('click', escreverAprendido);

function escreverAprendido() {
    const lista = document.getElementById('lista');
    const itens = lista.getElementsByTagName('li');
    
    for (let i = 0; i < itens.length; i++) {
        if (!itens[i].textContent.includes('– aprendido')) {
            itens[i].textContent += ' – aprendido';
        }
    }
}

// Exercício 10
document.getElementById('btnAdicionarItem').addEventListener('click', adicionarItem);

function adicionarItem() {
    const novoItem = prompt('Digite o nome do novo item:');
    if (novoItem) {
        const lista = document.getElementById('lista');
        const li = document.createElement('li');
        li.textContent = novoItem;
        lista.appendChild(li);
    }
}
