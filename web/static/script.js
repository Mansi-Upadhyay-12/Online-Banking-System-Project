// Get the form element by its ID
document.getElementById("userForm").addEventListener("submit", function(event){
    // Get the values of the username, email, and password fields
    let username = document.getElementById("username").value;
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    // Check if any of the fields are empty
    if(username === "" || email === "" || password === "") {
        // If any field is empty, show an alert and prevent the form from submitting
        alert("All fields must be filled out");
        event.preventDefault();  // Prevent the form from submitting
    }
    let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email)) {
        alert("Please enter a valid email.");
        return;
    }

    alert("Registration successful!");
});
