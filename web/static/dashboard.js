// Function to handle deposit action
function handleDeposit() {
    const depositAmount = parseFloat(document.getElementById("deposit-amount").value);
    if (depositAmount > 0) {
        alert(`You have successfully deposited $${depositAmount}`);
        updateBalance(depositAmount); // Update balance after deposit
    } else {
        alert("Please enter a valid amount.");
    }
}

// Function to handle withdraw action
function handleWithdraw() {
    const withdrawAmount = parseFloat(document.getElementById("withdraw-amount").value);
    const currentBalance = parseFloat(document.getElementById("balance").textContent.split('$')[1]);

    if (withdrawAmount > 0 && withdrawAmount <= currentBalance) {
        alert(`You have successfully withdrawn $${withdrawAmount}`);
        updateBalance(-withdrawAmount); // Update balance after withdrawal
    } else if (withdrawAmount > currentBalance) {
        alert("Insufficient balance!");
    } else {
        alert("Please enter a valid amount.");
    }
}

// Function to check balance
function checkBalance() {
    const currentBalance = parseFloat(document.getElementById("balance").textContent.split('$')[1]);
    alert(`Your current balance is $${currentBalance}`);
}

// Function to update the balance on the dashboard
function updateBalance(amount) {
    const balanceElement = document.getElementById("balance");
    const currentBalance = parseFloat(balanceElement.textContent.split('$')[1]);
    const newBalance = currentBalance + amount;
    balanceElement.textContent = `Current Balance: $${newBalance.toFixed(2)}`;
}

// Function to log out
function logout() {
    alert("You have been logged out.");
    window.location.href = "index.html"; // Redirect to login page
}
