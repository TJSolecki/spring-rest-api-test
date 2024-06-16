<script lang="ts">
    import { fade } from "svelte/transition";
    import Button from "./components/Button.svelte";
    import CheckmarkIcon from "./components/CheckmarkIcon.svelte";
    import ExclamationIcon from "./components/ExclamationIcon.svelte";
    import FormInput from "./components/FormInput.svelte";
    import Popup from "./components/Popup.svelte";
    let email = "";
    let message = "";
    let remind_date = "";
    let successPopupIsHidden = true;
    let errorPopupIsHidden = true;

    function handle_submit() {
        const form_data = new FormData();
        form_data.append("email", email);
        form_data.append("message", message);
        form_data.append("remind_date", remind_date);
        fetch("/reminders/", {
            body: form_data,
            method: "post",
        })
            .then((resp) => {
                if (resp.status === 201) {
                    successPopupIsHidden = false;
                } else {
                    errorPopupIsHidden = false;
                }
            })
            .catch(() => {
                errorPopupIsHidden = false;
            });
    }
</script>

<main>
    <h1>Create a reminder</h1>
    <form on:submit|preventDefault={handle_submit}>
        <FormInput bind:value={email} label="Email" name="email" type="email" />
        <FormInput
            bind:value={message}
            label="Message"
            name="message"
            type="text"
        />
        <FormInput
            bind:value={remind_date}
            label="Date"
            name="remind_date"
            type="datetime-local"
        />
        <Button label="Create Reminder" type="submit" />
    </form>
    {#if !successPopupIsHidden}
        <div transition:fade={{ duration: 100 }} class="blur-background">
            <Popup
                message="Success"
                description="Reminder successfully created"
                on:click={() => {
                    successPopupIsHidden = true;
                }}><CheckmarkIcon slot="icon" /></Popup
            >
        </div>
    {/if}
    {#if !errorPopupIsHidden}
        <div transition:fade={{ duration: 100 }} class="blur-background">
            <Popup
                message="Error"
                description="There was an issue creating your reminder. Please try again."
                on:click={() => {
                    errorPopupIsHidden = true;
                }}><ExclamationIcon slot="icon" /></Popup
            >
        </div>
    {/if}
</main>

<style>
    .blur-background {
        position: absolute;
        inset: 0;
        z-index: 1;
        backdrop-filter: blur(0.2rem);
        display: grid;
        place-items: center;
    }
    h1 {
        font-weight: 600;
    }
    form {
        display: flex;
        flex-direction: column;
        gap: 1.5em;
    }
    main {
        max-width: 600px;
        width: 80%;
        margin: 0 auto;
    }
</style>
