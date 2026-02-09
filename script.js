const signInTab = document.getElementById("signInTab");
const signUpTab = document.getElementById("signUpTab");
const form = document.getElementById("authForm");
const button = form.querySelector("button");

signInTab.onclick = () => {
  signInTab.classList.add("active");
  signUpTab.classList.remove("active");
  button.textContent = "Sign In";
};

signUpTab.onclick = () => {
  signUpTab.classList.add("active");
  signInTab.classList.remove("active");
  button.textContent = "Create Account";
};