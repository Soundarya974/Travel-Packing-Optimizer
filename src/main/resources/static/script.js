let itemIndex = 0;

function addItem(id = "", name = "", weight = "", importance = "", isFragile = false) {
    const container = document.getElementById("items");
    let div = document.createElement("div");
    const elementId = `item-id-${id}`;
    const existingDiv = document.getElementById(elementId);
    if (existingDiv) {
        div = existingDiv;
    }
    div.id = `item-id-${id}`
    div.innerHTML = `
    <input placeholder="Name" id="name-${itemIndex}" value="${name}" />
    <input type="number" placeholder="Weight" id="weight-${itemIndex}" value="${weight}" />
    <input type="number" placeholder="Importance" id="importance-${itemIndex}" value="${importance}" />
    <label>isFragile: <input type="checkbox" id="isFragile-${itemIndex}" ${isFragile ? "checked" : ""} /></label>
    `;
    container.appendChild(div);
    itemIndex++;
}

async function fetchDefaults() {
    const res = await fetch("/api/items/defaults");
    const items = await res.json();
    items.forEach(item =>
        addItem(item.id, item.name, item.weight, item.importance, item.isFragile)
    );
}

async function fetchOptions(endpoint, selectId) {
    const response = await fetch(`/api/${endpoint}`);
    const data = await response.json();
    const select = document.getElementById(selectId);
    data.forEach(item => {
        const option = document.createElement('option');
        option.value = item.id;
        option.textContent = item.name || item.reason;
        select.appendChild(option);
    });
}

async function loadSuggestedItems() {
    const travelTypeId = document.getElementById("travelType").value;
    const seasonId = document.getElementById("season").value;

    const response = await fetch(
        `/api/items/suggestions?travelTypeId=${travelTypeId}&seasonId=${seasonId}`
    );
    const items = await response.json();
    items.forEach(item =>
        addItem(item.id, item.name, item.weight, item.importance, item.isFragile)
    );
}

async function findOptimalPacking() {
    const maxWeight = document.getElementById("maxWeight").value;
    const items = [];

    for (let i = 0; i < itemIndex; i++) {
        const name = document.getElementById(`name-${i}`)?.value;
        const weight = parseFloat(document.getElementById(`weight-${i}`)?.value);
        const importance = parseFloat(document.getElementById(`importance-${i}`)?.value);
        const isFragile = document.getElementById(`isFragile-${i}`)?.checked;
        if (name && !isNaN(weight) && !isNaN(importance)) {
            items.push({name, weight, importance, isFragile});
        }
    }

    const response = await fetch('/api/packing/optimal', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({maxWeight, items})
    });

    const result = await response.json();
    displayResult(result);
}

async function findGreedyPacking() {
    const maxWeight = document.getElementById("maxWeight").value;
    const items = [];

    for (let i = 0; i < itemIndex; i++) {
        const name = document.getElementById(`name-${i}`)?.value;
        const weight = parseFloat(document.getElementById(`weight-${i}`)?.value);
        const importance = parseFloat(document.getElementById(`importance-${i}`)?.value);
        const isFragile = document.getElementById(`isFragile-${i}`)?.checked;
        if (name && !isNaN(weight) && !isNaN(importance)) {
            items.push({name, weight, importance, isFragile});
        }
    }

    const response = await fetch('/api/packing/greedy/value', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({maxWeight, items})
    });

    const result = await response.json();
    displayResult(result);
}

async function comparePackingApproaches() {
    const maxWeight = document.getElementById("maxWeight").value;
    const items = [];

    for (let i = 0; i < itemIndex; i++) {
        const name = document.getElementById(`name-${i}`)?.value;
        const weight = parseFloat(document.getElementById(`weight-${i}`)?.value);
        const importance = parseFloat(document.getElementById(`importance-${i}`)?.value);
        const isFragile = document.getElementById(`isFragile-${i}`)?.checked;
        if (name && !isNaN(weight) && !isNaN(importance)) {
            items.push({name, weight, importance, isFragile});
        }
    }

    const response = await fetch('/api/packing/compare', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({maxWeight, items})
    });

    const result = await response.json();
    displayComparison(result);
}


function displayComparison(resultMap) {
    const table = document.getElementById("comparison-table");
    const tbody = document.getElementById("comparison-body");
    const outputTable = document.getElementById("output-table");
    const outputBody = document.getElementById("output-body");
    const summary = document.getElementById("results-summary");
    const results = document.getElementById("results");

    // Clear previous results
    outputBody.innerHTML = "";
    summary.innerHTML = "";
    tbody.innerHTML = "";
    outputTable.style.display = "none";
    results.style.display = "none";

    for (const [approach, result] of Object.entries(resultMap)) {
        const totalItems = result.selectedItems.length;
        const totalWeight = result.totalWeight;
        const totalImportance = result.totalImportance;
        const itemNames = result.selectedItems.map(item => item.name).join(", ");

        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${approach}</td>
            <td>${totalItems}</td>
            <td>${totalWeight}</td>
            <td>${totalImportance}</td>
            <td>${itemNames}</td>
        `;
        tbody.appendChild(row);
    }

    table.style.display = "table";
}

function displayResult(result) {
    const comparisionTable = document.getElementById("comparison-table");
    const comparisionBody = document.getElementById("comparison-body");
    const table = document.getElementById("output-table");
    const tbody = document.getElementById("output-body");
    const summary = document.getElementById("results-summary");
    const results = document.getElementById("results");

    // Clear previous results
    tbody.innerHTML = "";
    comparisionBody.innerHTML = "";
    comparisionTable.style.display = "none";

    result.selectedItems.forEach(item => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${item.name}</td>
            <td>${item.weight}</td>
            <td>${item.importance}</td>
            <td>${item.isFragile ? "Yes" : "No"}</td>
        `;
        tbody.appendChild(row);
    });

    // Update summary section
    const totalItems = result.selectedItems.length;
    const totalWeight = result.totalWeight;
    const totalImportance = result.totalImportance;

    summary.innerHTML = `
        <strong>Summary:</strong><br>
         <div className="result-card">
            <h4>Total Value</h4>
            <p id="totalValue">${totalImportance}</p>
        </div>
        <div className="result-card">
            <h4>Total Weight</h4>
            <p id="totalWeight">${totalWeight} kg</p>
        </div>
        <div className="result-card">
            <h4>Items Selected</h4>
            <p id="itemsCount">${totalItems}</p>
        </div>
    `;

    table.style.display = "table";
    summary.style.display = "block";
    results.style.display = "block";
}

window.onload = () => {
    fetchOptions("seasons", "season");
    fetchOptions("travel-types", "travelType");
};