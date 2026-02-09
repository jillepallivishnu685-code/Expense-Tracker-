const ctx = document.getElementById("expenseChart");

new Chart(ctx, {
  type: "doughnut",
  data: {
    labels: [
      "Food & Dining",
      "Transport",
      "Entertainment",
      "Shopping",
      "Utilities"
    ],
    datasets: [{
      data: [42.5, 15, 89.99, 156, 75],
      backgroundColor: [
        "#2ecc71",
        "#3498db",
        "#f39c12",
        "#9b59b6",
        "#e74c3c"
      ],
      borderWidth: 4,
      borderColor: "#ffffff"
    }]
  },
  options: {
    cutout: "70%",
    plugins: {
      legend: { display: false }
    }
  }
});