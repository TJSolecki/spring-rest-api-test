<script lang="ts">
    export let label: string;
    export let type: "button" | "submit" | "reset" | null | undefined;
</script>

<button {type}>{label}</button>

<style>
    button {
        background-color: black;
        color: white;
        width: 10em;
        padding: 0.7em 0;
        outline: none;
        border: none;
        border-radius: 0.6em;
        font-weight: 600;
        display: inline-block;
        transition: all ease-in-out 0.2s;
        scale: 1;
    }
    button:hover,
    button:active {
        opacity: 0.8;
        scale: 0.95;
        cursor: pointer;
    }
</style>
