document.getElementById('crForm').addEventListener('submit', function(e) {
    e.preventDefault();
    
    const grades = document.getElementById('grades').value.split(',').map(valor => parseFloat(valor.trim()));
    const credits = document.getElementById('credits').value.split(',').map(valor => parseFloat(valor.trim()));

    if (grades.some(isNaN) || credits.some(isNaN)) {
        alert('Insira apenas números válidos para notas e créditos.');
        return;
    }

    if (grades.length !== credits.length) {
        alert('Notas e créditos devem ter a mesma quantidade.');
        return;
    }

    const data = {
        notas: grades.map(valor => ({ valor })),
        cargasHorarias: credits.map(valor => ({ valor }))
    };

    fetch('http://localhost:8080/api/calculo-cr', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(cr => {
        console.log('Resposta do servidor:', cr);

        if (isNaN(cr)) {
            document.getElementById('result').innerText = `O cálculo falhou. Verifique se os dados inseridos estão corretos.`;
        } else {
            document.getElementById('result').innerText = `Seu Coeficiente de Rendimento é: ${cr.toFixed(2)}`;
        }
    })
    .catch(error => {
        console.error('Erro:', error);
        document.getElementById('result').innerText = `Ocorreu um erro ao tentar calcular o CR.`;
    });
});


