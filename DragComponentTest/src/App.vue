<script setup lang="ts">
import layout from "@/components/Layout.vue";
// import memo from "@/components/draggable/Memo.vue";
import memo1 from "@/components/draggable/Memo1.vue";
</script>

<template>
  <layout />
  <!-- <memo /> -->
  <memo1 />
</template>

<style scoped>
.logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}
.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}
.logo.vue:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
}
</style>
