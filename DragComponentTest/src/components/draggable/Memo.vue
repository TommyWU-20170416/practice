<template>
  <div class="memo">
    <h2>memo</h2>
    <div class="draggable-item" draggable="true" @dragstart="dragStart">
      <!-- 元件內容 -->
      <div class="bottomComponent"></div>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  methods: {
    dragStart(event: DragEvent) {
      event.dataTransfer!.setData("componentType", "memo");
    },
  },
});
</script>

<style scoped>
.memo {
  background: rgb(68, 68, 180);
  width: 300px;
  height: 300px;
}
.draggable-item {
  box-sizing: border-box;
}
.bottomComponent {
  background: blue;
  width: 100%;
  height: 170px;
}
</style>
