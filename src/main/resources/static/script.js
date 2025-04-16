
let itemIndex = 0;

function addItem(name = "", weight = "", value = "", fragile = false) {
    const container = document.getElementById("items");
    const div = document.createElement("div");
    div.innerHTML = `
    <input placeholder="Name" id="name-${itemIndex}" value="${name}" />
    <input type="number" placeholder="Weight" id="weight-${itemIndex}" value="${weight}" />
    <input type="number" placeholder="Value" id="value-${itemIndex}" value="${value}" />
    <label>Fragile: <input type="checkbox" id="fragile-${itemIndex}" ${fragile ? "checked" : ""} /></label>
  `;
    container.appendChild(div);
    itemIndex++;
}

async function fetchDefaults() {
    const res = await fetch("/api/packing/defaults");
    const items = await res.json();
    items.forEach(item =>
        addItem(item.name, item.weight, item.value, item.fragile)
    );
}

async function submitData() {
    const maxWeight = document.getElementById("maxWeight").value;
    const items = [];

    for (let i = 0; i < itemIndex; i++) {
        const name = document.getElementById(`name-${i}`)?.value;
        const weight = parseFloat(document.getElementById(`weight-${i}`)?.value);
        const value = parseFloat(document.getElementById(`value-${i}`)?.value);
        const fragile = document.getElementById(`fragile-${i}`)?.checked;
        if (name && !isNaN(weight) && !isNaN(value)) {
            items.push({ name, weight, value, fragile });
        }
    }

    const response = await fetch('/api/packing', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ maxWeight, items })
    });

    const result = await response.json();
    displayResult(result);
}

function displayResult(result) {
    const table = document.getElementById("output-table");
    const tbody = document.getElementById("output-body");
    const summary = document.getElementById("summary");

    // Clear previous results
    tbody.innerHTML = "";

    result.optimal.forEach(item => {
        const row = document.createElement("tr");
        row.innerHTML = `
      <td>${item.name}</td>
      <td>${item.weight}</td>
      <td>${item.value}</td>
      <td>${item.fragile ? "Yes" : "No"}</td>
    `;
        tbody.appendChild(row);
    });

    table.style.display = "table";
}
