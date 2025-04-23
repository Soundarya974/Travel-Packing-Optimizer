
let itemIndex = 0;

function addItem(name = "", weight = "", importance = "", isFragile = false) {
    const container = document.getElementById("items");
    const div = document.createElement("div");
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
        addItem(item.name, item.weight, item.importance, item.isFragile)
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
        addItem(item.name, item.weight, item.importance, item.isFragile)
    );
}

async function submitData() {
    const maxWeight = document.getElementById("maxWeight").value;
    const items = [];

    for (let i = 0; i < itemIndex; i++) {
        const name = document.getElementById(`name-${i}`)?.value;
        const weight = parseFloat(document.getElementById(`weight-${i}`)?.value);
        const importance = parseFloat(document.getElementById(`importance-${i}`)?.value);
        const isFragile = document.getElementById(`isFragile-${i}`)?.checked;
        if (name && !isNaN(weight) && !isNaN(importance)) {
            items.push({ name, weight, importance, isFragile });
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
            <td>${item.weight}</td>
            <td>${item.importance}</td>
            <td>${item.isFragile ? "Yes" : "No"}</td>
    `;
        tbody.appendChild(row);
    });

    table.style.display = "table";
}

window.onload = () => {
    fetchOptions("seasons", "season");
    fetchOptions("travel-types", "travelType");
};