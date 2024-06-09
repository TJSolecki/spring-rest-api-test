const submit_button = document.querySelector("form .submit-button");
const email_input = document.getElementById("email");
const message_input = document.getElementById("message");
const remind_date_input = document.getElementById("remind_date");
const blur_background = document.querySelector(".blur-background");
const success_close_popup_button = document.getElementById(
    "close-success-button",
);
const success_popup = document.querySelector(".success-popup");
const error_close_popup_button = document.getElementById("close-error-button");
const error_popup = document.querySelector(".error-popup");

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
                    success_popup.classList.remove("hidden");
                    setTimeout(() => {
                        blur_background.classList.add("full-opacity");
                        success_popup.classList.add("full-opacity");
                    }, 10);
                } else {
                    blur_background.classList.remove("hidden");
                    error_popup.classList.remove("hidden");
                    setTimeout(() => {
                        blur_background.classList.add("full-opacity");
                        error_popup.classList.add("full-opacity");
                    }, 10);
                }
            })
            .catch(() => {
                blur_background.classList.remove("hidden");
                error_popup.classList.remove("hidden");
                setTimeout(() => {
                    blur_background.classList.add("full-opacity");
                    error_popup.classList.add("full-opacity");
                }, 100);
            });
    });
}

if (success_close_popup_button) {
    success_close_popup_button.addEventListener("click", () => {
        blur_background.classList.remove("full-opacity");
        success_popup.classList.remove("full-opacity");
        setTimeout(() => {
            blur_background.classList.add("hidden");
            success_popup.classList.add("hidden");
        }, 300);
    });
}

if (error_close_popup_button) {
    error_close_popup_button.addEventListener("click", () => {
        blur_background.classList.remove("full-opacity");
        error_popup.classList.remove("full-opacity");
        setTimeout(() => {
            blur_background.classList.add("hidden");
            error_popup.classList.add("hidden");
        }, 300);
    });
}
