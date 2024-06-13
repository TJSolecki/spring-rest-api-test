<script lang="ts">
    export let label: string;
    export let name: string;
    export let type: string;
    export let value: string;
</script>

<div>
    <label for={name}>{label}</label>
    {#if type === "datetime-local"}
        <input bind:value type="datetime-local" id={name} {name} required />
    {:else if type === "email"}
        <input bind:value type="email" id={name} {name} required />
    {:else if type === "text"}
        <input bind:value type="text" id={name} {name} required />
    {/if}
</div>

<style>
    div {
        width: 100%;
        display: flex;
        gap: 0.5em;
        flex-direction: column;
    }
    label {
        font-size: 0.8em;
        color: gray;
        font-weight: 500;
    }
    input {
        outline: none;
        border: solid 1px lightgray;
        border-radius: 0.3em;
        padding: 0.2em;
        box-shadow: rgba(99, 99, 99, 0.08) 0px 2px 8px 0px;
    }
</style>
