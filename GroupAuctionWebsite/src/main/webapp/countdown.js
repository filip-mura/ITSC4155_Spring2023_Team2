// Setting initial values (default time of 1 week)
let days = 7;
let hours = 0;
let minutes = 0;
let seconds = 0;

// Calculating total seconds
let totalSeconds = (days * 24 * 60 * 60) + (hours * 60 * 60) + (minutes * 60) + seconds;

// Updating timer
const countdown = setInterval(function() {

  totalSeconds--;

  // Calculate the remaining time
  days = Math.floor(totalSeconds / (24 * 60 * 60));
  hours = Math.floor((totalSeconds % (24 * 60 * 60)) / (60 * 60));
  minutes = Math.floor((totalSeconds % (60 * 60)) / 60);
  seconds = Math.floor(totalSeconds % 60);

  // Displaying countdown in the element with id="countdown"
  const countdownElement = document.getElementById("countdown");
  countdownElement.innerHTML = `${days}d ${hours}h ${minutes}m ${seconds}s`;

  // If the countdown is over, display "Auction Ended"
  if (totalSeconds < 1) {
    clearInterval(countdown);
    countdownElement.innerHTML = "Auction Ended";
  }
}, 1000);