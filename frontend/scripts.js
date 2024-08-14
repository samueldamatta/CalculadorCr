let notas = [];
let cargas = [];

document.getElementById('adicionar').addEventListener('click', () => {
    const nota = parseFloat(document.getElementById('nota').value);
    const carga = parseFloat(document.getElementById('carga').value);

    if (!isNaN(nota) && !isNaN(carga)) {
        notas.push({ valor: nota });
        cargas.push({ horas: carga });
        adicionarMateriaNaTela(nota, carga);
        document.getElementById('nota').value = '';
        document.getElementById('carga').value = '';
    } else {
        alert('Por favor, insira valores válidos.');
    }
});

document.getElementById('calcular').addEventListener('click', () => {
    const requestData = {
        notas: notas,
        cargaHoraria: cargas
    };

    fetch('http://localhost:8080/api/calculo-cr', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestData)
    })
    .then(response => response.json())
    .then(data => {
        if (typeof data === 'number') {
            const resultado = data.toFixed(2);
            console.log('CR Calculado:', resultado);
            document.getElementById('resultado').innerText = `CR: ${resultado}`;
        } else {
            console.error('O backend retornou um tipo inesperado:', data);
        }
    })
    .catch(error => console.error('Erro:', error));
    });

function adicionarMateriaNaTela(nota, carga) {
    const materiaList = document.getElementById('materias-list');
    const listItem = document.createElement('li');
    listItem.textContent = `Nota: ${nota}, Carga Horária: ${carga}`;
    materiaList.appendChild(listItem);
}

