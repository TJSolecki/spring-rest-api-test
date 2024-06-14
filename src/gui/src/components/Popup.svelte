<script lang="ts">
    import Button from "./Button.svelte";
    export let message: string;
    export let description: string;
</script>

<dialog>
    <slot name="icon" />
    <div>
        <h2>{message}</h2>
        <p>{description}</p>
    </div>
    <Button on:click label="Close" type="button" />
</dialog>

<style>
    div {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        gap: 0.2em;
        align-self: center;
    }
    h2 {
        padding: 0;
        margin: 0;
        font-size: 1.2em;
        font-weight: 600;
    }
    p {
        font-size: 0.8em;
        padding: 0;
        margin: 0;
    }
    dialog {
        display: flex;
        flex-direction: column;
        align-items: flex-end;
        gap: 1em;
        max-width: 300px;
        width: 80%;
        text-align: center;
        background: white;
        box-shadow: rgba(99, 99, 99, 0.3) 0px 2px 8px 0px;
        border-radius: 1em;
        padding: 1.2em;
        border: none;
    }
</style>
