// 1. JavaScript Basics & Setup
console.log("Welcome to the Community Portal");
window.addEventListener('load', function() {
    alert("Page fully loaded!");
});

// 2. Syntax, Data Types, and Operators
const eventName = "Summer Festival";
const eventDate = "2024-06-15";
let availableSeats = 100;

// Template literals for event info
const eventInfo = `Event: ${eventName}, Date: ${eventDate}, Available Seats: ${availableSeats}`;
console.log(eventInfo);

// Function to manage seat count
function registerForEvent() {
    availableSeats--; // Decrement seats on registration
    return `Seat reserved! Remaining seats: ${availableSeats}`;
}

// 3. Conditionals, Loops, and Error Handling
const events = [
    { name: "Summer Festival", date: "2024-06-15", seats: 100, category: "festival" },
    { name: "Art Exhibition", date: "2024-07-22", seats: 50, category: "art" },
    { name: "Food Fair", date: "2024-08-05", seats: 0, category: "food" },
    { name: "Music Concert", date: "2024-09-18", seats: 200, category: "music" },
    { name: "Sports Day", date: "2024-10-09", seats: 150, category: "sports" },
    { name: "Charity Run", date: "2024-11-12", seats: 75, category: "charity" }
];

function displayEvents() {
    const currentDate = new Date();
    const validEvents = events.filter(event => {
        const eventDate = new Date(event.date);
        return eventDate >= currentDate && event.seats > 0;
    });
    
    validEvents.forEach(event => {
        console.log(`${event.name} - ${event.date} - Seats: ${event.seats}`);
    });
    
    try {
        renderEvents(validEvents);
    } catch (error) {
        console.error("Error rendering events:", error.message);
    }
}

// 4. Functions, Scope, Closures, Higher-Order Functions
function addEvent(name, date, seats, category) {
    events.push({ name, date, seats, category });
    console.log(`Event "${name}" added successfully`);
}

function registerUser(eventId, userName) {
    try {
        if (eventId >= 0 && eventId < events.length) {
            if (events[eventId].seats > 0) {
                events[eventId].seats--;
                console.log(`${userName} registered for ${events[eventId].name}`);
                return true;
            } else {
                throw new Error("No seats available");
            }
        } else {
            throw new Error("Invalid event ID");
        }
    } catch (error) {
        console.error(`Registration error: ${error.message}`);
        return false;
    }
}

function filterEventsByCategory(category) {
    // Closure to track registrations for this category
    let registrationsCount = 0;
    
    return {
        getEvents: function() {
            return events.filter(event => event.category === category);
        },
        registerForEvent: function(eventId, userName) {
            const success = registerUser(eventId, userName);
            if (success) registrationsCount++;
            return success;
        },
        getRegistrationsCount: function() {
            return registrationsCount;
        }
    };
}

// Higher-order function example
function searchEvents(criteria) {
    return events.filter(criteria);
}

// 5. Objects and Prototypes
function Event(name, date, seats, category) {
    this.name = name;
    this.date = date;
    this.seats = seats;
    this.category = category;
}

Event.prototype.checkAvailability = function() {
    return this.seats > 0;
};

// Create an event using the constructor
const workshopEvent = new Event("Workshop on Baking", "2024-08-20", 30, "workshop");
console.log(Object.entries(workshopEvent));

// 6. Arrays and Methods
function addNewEvent(event) {
    events.push(event);
}

function getMusicEvents() {
    return events.filter(event => event.category === "music");
}

function formatEventCards() {
    return events.map(event => `${event.name} on ${event.date}`);
}

// 7. DOM Manipulation
document.addEventListener('DOMContentLoaded', function() {
    const eventGallery = document.getElementById('eventGallery');
    
    if (eventGallery) {
        events.forEach(event => {
            const eventCard = document.createElement('div');
            eventCard.className = 'gallery-item card-hover';
            
            const eventDate = document.createElement('div');
            eventDate.className = 'event-date';
            
            const dateObj = new Date(event.date);
            const month = dateObj.toLocaleString('default', { month: 'short' }).toUpperCase();
            const day = dateObj.getDate();
            
            eventDate.innerHTML = `
                <span class="month">${month}</span>
                <span class="day">${day}</span>
            `;
            
            eventCard.appendChild(eventDate);
            
            const caption = document.createElement('div');
            caption.className = 'gallery-caption';
            caption.innerHTML = `
                <h3>${event.name}</h3>
                <p>Available seats: ${event.seats}</p>
                <button class="register-btn">Register</button>
            `;
            
            eventCard.appendChild(caption);
            eventGallery.appendChild(eventCard);
        });
    }
});

// 8. Event Handling
document.addEventListener('DOMContentLoaded', function() {
    // Register button click handler
    document.addEventListener('click', function(e) {
        if (e.target && e.target.classList.contains('register-btn')) {
            const eventCard = e.target.closest('.gallery-item');
            const eventIndex = Array.from(eventCard.parentNode.children).indexOf(eventCard);
            registerUser(eventIndex, "Guest User");
        }
    });
    
    // Category filter change handler
    const categoryFilter = document.getElementById('eventType');
    if (categoryFilter) {
        categoryFilter.addEventListener('change', function() {
            filterEventsByCategory(this.value).getEvents();
        });
    }
    
    // Quick search by name
    document.addEventListener('keydown', function(e) {
        if (e.target.tagName !== 'INPUT' && e.target.tagName !== 'TEXTAREA') {
            const key = e.key.toLowerCase();
            if (/^[a-z]$/.test(key)) {
                const matchingEvents = events.filter(event => 
                    event.name.toLowerCase().startsWith(key));
                console.log("Quick search results:", matchingEvents);
            }
        }
    });
});

// 9. Async JS, Promises, Async/Await
function fetchEvents() {
    // Show loading spinner
    const eventGallery = document.getElementById('eventGallery');
    if (eventGallery) {
        eventGallery.innerHTML = '<div class="loading-spinner">Loading events...</div>';
    }
    
    // Using Promise
    fetch('https://jsonplaceholder.typicode.com/posts')
        .then(response => response.json())
        .then(data => {
            console.log("Events fetched:", data.slice(0, 5));
            // Process the data
            if (eventGallery) {
                eventGallery.innerHTML = '';
                // Render events here
            }
        })
        .catch(error => {
            console.error("Error fetching events:", error);
            if (eventGallery) {
                eventGallery.innerHTML = '<div class="error">Failed to load events</div>';
            }
        });
}

// Using async/await
async function fetchEventsAsync() {
    const eventGallery = document.getElementById('eventGallery');
    if (eventGallery) {
        eventGallery.innerHTML = '<div class="loading-spinner">Loading events...</div>';
    }
    
    try {
        const response = await fetch('https://jsonplaceholder.typicode.com/posts');
        const data = await response.json();
        console.log("Events fetched:", data.slice(0, 5));
        
        if (eventGallery) {
            eventGallery.innerHTML = '';
            // Render events here
        }
    } catch (error) {
        console.error("Error fetching events:", error);
        if (eventGallery) {
            eventGallery.innerHTML = '<div class="error">Failed to load events</div>';
        }
    }
}

// 10. Modern JavaScript Features
// Using let, const, default parameters
function createEvent(name, date, seats = 50, category = "other") {
    return { name, date, seats, category };
}

// Destructuring
function displayEventDetails(event) {
    const { name, date, seats, category } = event;
    console.log(`Event: ${name}, Date: ${date}, Seats: ${seats}, Category: ${category}`);
}

// Spread operator
function filterAndSortEvents(category) {
    const eventsCopy = [...events];
    return eventsCopy
        .filter(event => event.category === category)
        .sort((a, b) => new Date(a.date) - new Date(b.date));
}

// 11. Working with Forms
document.addEventListener('DOMContentLoaded', function() {
    const registrationForm = document.getElementById('registrationForm');
    
    if (registrationForm) {
        registrationForm.addEventListener('submit', function(event) {
            event.preventDefault();
            
            const formElements = this.elements;
            const name = formElements.name.value;
            const email = formElements.email.value;
            const selectedEvent = formElements.eventType.value;
            
            // Validate inputs
            if (!name || !email || !selectedEvent) {
                showError("Please fill in all required fields");
                return;
            }
            
            if (!validateEmail(email)) {
                showError("Please enter a valid email address");
                return;
            }
            
            console.log("Registration submitted:", { name, email, selectedEvent });
            showSuccess("Registration successful!");
        });
    }
    
    function validateEmail(email) {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(email);
    }
    
    function showError(message) {
        const output = document.getElementById('formOutput');
        if (output) {
            output.textContent = message;
            output.className = 'error';
        }
    }
    
    function showSuccess(message) {
        const output = document.getElementById('formOutput');
        if (output) {
            output.textContent = message;
            output.className = 'success';
        }
    }
});

// 12. AJAX & Fetch API
function submitRegistration(userData) {
    // Show loading state
    const submitBtn = document.getElementById('submitBtn');
    if (submitBtn) {
        submitBtn.disabled = true;
        submitBtn.textContent = 'Submitting...';
    }
    
    fetch('https://jsonplaceholder.typicode.com/posts', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData)
    })
    .then(response => response.json())
    .then(data => {
        console.log("Registration successful:", data);
        showMessage("Registration successful!");
        
        // Simulate delayed response
        setTimeout(() => {
            if (submitBtn) {
                submitBtn.disabled = false;
                submitBtn.textContent = 'Register Now';
            }
        }, 1000);
    })
    .catch(error => {
        console.error("Registration failed:", error);
        showMessage("Registration failed. Please try again.", true);
        
        if (submitBtn) {
            submitBtn.disabled = false;
            submitBtn.textContent = 'Register Now';
        }
    });
    
    function showMessage(message, isError = false) {
        const output = document.getElementById('formOutput');
        if (output) {
            output.textContent = message;
            output.className = isError ? 'error' : 'success';
        }
    }
}

// 13. Debugging and Testing
function debugRegistration() {
    console.log("Starting registration process");
    
    const form = document.getElementById('registrationForm');
    if (!form) {
        console.error("Form not found");
        return;
    }
    
    console.log("Form found, checking fields");
    
    const formData = {
        name: form.elements.name.value,
        email: form.elements.email.value,
        eventType: form.elements.eventType.value
    };
    
    console.log("Form data:", formData);
    
    if (!formData.name || !formData.email || !formData.eventType) {
        console.error("Missing required fields");
        return;
    }
    
    console.log("All fields valid, submitting form");
    
    // Set breakpoint here to inspect variables
    submitRegistration(formData);
}

// 14. jQuery and JS Frameworks
document.addEventListener('DOMContentLoaded', function() {
    // Check if jQuery is available
    if (typeof jQuery !== 'undefined') {
        // jQuery implementation
        $('#registerBtn').click(function() {
            console.log("Register button clicked (jQuery)");
        });
        
        // Fade effects
        $('.gallery-item').fadeIn(1000);
        $('.gallery-item').fadeOut(1000);
        
        // Note about frameworks
        console.log("Benefits of frameworks like React or Vue include: component-based architecture, virtual DOM for performance, state management, and developer tools.");
    } else {
        // Vanilla JS fallback
        const registerBtn = document.getElementById('registerBtn');
        if (registerBtn) {
            registerBtn.addEventListener('click', function() {
                console.log("Register button clicked (Vanilla JS)");
            });
        }
    }
});

// Function to render events (missing implementation from earlier)
function renderEvents(events) {
    const eventGallery = document.getElementById('eventGallery');
    if (!eventGallery) return;
    
    eventGallery.innerHTML = '';
    
    events.forEach(event => {
        const eventCard = document.createElement('div');
        eventCard.className = 'gallery-item card-hover';
        
        const eventDate = document.createElement('div');
        eventDate.className = 'event-date';
        
        const dateObj = new Date(event.date);
        const month = dateObj.toLocaleString('default', { month: 'short' }).toUpperCase();
        const day = dateObj.getDate();
        
        eventDate.innerHTML = `
            <span class="month">${month}</span>
            <span class="day">${day}</span>
        `;
        
        eventCard.appendChild(eventDate);
        
        const caption = document.createElement('div');
        caption.className = 'gallery-caption';
        caption.innerHTML = `
            <h3>${event.name}</h3>
            <p>Available seats: ${event.seats}</p>
            <button class="register-btn">Register</button>
        `;
        
        eventCard.appendChild(caption);
        eventGallery.appendChild(eventCard);
    });
}

// Initialize the application
document.addEventListener('DOMContentLoaded', function() {
    console.log("Community Event Portal initialized");
    displayEvents();
    
    // Call fetchEventsAsync to demonstrate async/await
    fetchEventsAsync();
    
    // Connect form submission to AJAX
    const registrationForm = document.getElementById('registrationForm');
    if (registrationForm) {
        registrationForm.addEventListener('submit', function(event) {
            event.preventDefault();
            const formData = {
                name: this.elements.name.value,
                email: this.elements.email.value,
                eventType: this.elements.eventType.value,
                date: this.elements.date.value
            };
            submitRegistration(formData);
        });
    }
});