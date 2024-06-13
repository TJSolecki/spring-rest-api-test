<script lang="ts">
    import Button from "./components/Button.svelte";
    import FormInput from "./components/FormInput.svelte";
    let email = "";
    let message = "";
    let remind_date = "";

    function handle_submit() {
        alert(JSON.stringify({ email, message, remind_date }));
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
</main>

<style>
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
