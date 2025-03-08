const API_URL = "http://localhost:8080";  // ✅ Adjust to your backend URL

// ✅ Create Company
document.getElementById("companyForm").addEventListener("submit", async function(event) {
    event.preventDefault();

    let company = {
        name: document.getElementById("companyName").value,
        domain: document.getElementById("companyDomain").value,
        userId: parseInt(document.getElementById("userId").value)
    };

    let response = await fetch(`${API_URL}/api/companies/create`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(company)
    });

    if (response.ok) {
        alert("Company Created!");
        loadCompanies();
    } else {
        alert("Error creating company.");
    }
});

// ✅ Create User
document.getElementById("userForm").addEventListener("submit", async function(event) {
    event.preventDefault();

    let user = {
        name: document.getElementById("userName").value,
        email: document.getElementById("userEmail").value,
        role: document.getElementById("userRole").value,
        password: document.getElementById("userPassword").value,
        companyId: parseInt(document.getElementById("userCompanyId").value)
    };

    let response = await fetch(`${API_URL}/api/users/create`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(user)
    });

    if (response.ok) {
        alert("User Created!");
        loadUsers();
    } else {
        alert("Error creating user.");
    }
});

// ✅ Load Companies & Users
async function loadCompanies() {
    let response = await fetch(`${API_URL}/api/companies`);
    let data = await response.json();
    document.getElementById("companyTable").innerHTML = data.map(c => `<tr><td>${c.id}</td><td>${c.name}</td><td>${c.domain}</td></tr>`).join("");
}

async function loadUsers() {
    let response = await fetch(`${API_URL}/api/users`);
    let data = await response.json();
    document.getElementById("userTable").innerHTML = data.map(u => `<tr><td>${u.id}</td><td>${u.name}</td><td>${u.email}</td><td>${u.role}</td><td>${u.companyName}</td></tr>`).join("");
}

loadCompanies();
loadUsers();
