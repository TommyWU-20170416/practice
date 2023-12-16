<template>
  <div class="column">
    <h2>column</h2>
    <div class="canvas" @dragover.prevent @drop="dropComponent">
      <!-- <memo v-for="component in memos" :key="component.type" :component="component" /> -->
      <memo1
        v-for="(memo, memoIndex) in props.memos"
        :key="memoIndex"
        :memoIndex="String(memoIndex)"
        :component="memo"
        :columnId="props.columnIndex"
      />
    </div>
  </div>
</template>

<script setup lang="ts">
import { defineProps } from "vue";
// import memo from "@/components/draggable/Memo.vue";
import memo1 from "@/components/draggable/Memo1.vue";
import NewComponent from "@/components/interface/NewComponent";

const props = defineProps({
  columnIndex: String,
  memos: Array as () => NewComponent[],
});

// const memos = ref<NewComponent[]>([]);
// const memos1 = ref<NewComponent[]>([]);
// const memos1_test: NewComponent[] = [
//   {
//     type: "memo1",
//     columnId: "0",
//   },
// ];
// memos1.value = memos1_test;
const emit = defineEmits(["dropComponent"]);
const dropComponent = (event: DragEvent) => {
  console.log(props.columnIndex, event);
  emit("dropComponent", event, props.columnIndex);
};
</script>

<style scoped>
.column {
  background: rgb(185, 223, 82);
  width: 350px;
  height: 100%;
  margin: 10px;
}
.canvas {
  /* 畫布樣式 */
  background: rgb(199, 201, 170);
  width: 100%;
  height: 400px;
  display: flex;
  justify-content: center;
}
</style>
