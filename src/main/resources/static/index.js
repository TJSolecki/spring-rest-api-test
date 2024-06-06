const submit_button = document.querySelector("form .submit-button");
const email_input = document.getElementById("email");
const message_input = document.getElementById("message");
const remind_date_input = document.getElementById("remind_date");
const blur_background = document.querySelector(".blur-background");
const close_popup = document.querySelector(".close-button");

if (submit_button) {
    addEventListener("submit", (e) => {
        e.preventDefault();
        const form_data = new FormData();
        form_data.append("email", email_input.value);
        form_data.append("message", message_input.value);
        form_data.append("remind_date", remind_date_input.value);
        fetch("/reminders/", {
            body: form_data,
            method: "post",
        })
            .then((resp) => {
                if (resp.status === 201) {
                    blur_background.classList.remove("hidden");
                } else {
                    alert("Failed to create reminder");
                }
            })
            .catch(() => {
                alert("Failed to create reminder");
            });
    });
}

if (close_popup) {
    close_popup.addEventListener("click", () => {
        blur_background.classList.add("hidden");
    });
}
