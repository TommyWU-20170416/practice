<template>
  <div class="layout">
    <h1>layout</h1>
    <div class="columns">
      <column
        v-for="(column, columnIndex) in columns"
        :keys="columnIndex"
        :columnIndex="String(columnIndex)"
        :memos="column"
        @dropComponent="dropComponent"
      />
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from "vue";
import column from "@/components/draggable/Column.vue";
import NewComponent from "@/components/interface/NewComponent";
const columns = ref([
  [] as NewComponent[], // First column
  [] as NewComponent[], // Second column
  [] as NewComponent[], // Third column
]);

const dropComponent = (event: DragEvent, columnIndex: String) => {
  console.log(event, columnIndex);

  /** TODO 要做可以多種類的memo放值 */
  const component: NewComponent = JSON.parse(event.dataTransfer!.getData("component"));
  if (component.type == "memo1") {
    /** 從新的地方拉進來 */
    if ("-1" == component.fromColumnId) {
      component.memoIndex = String(columns.value[Number(columnIndex)].length);
      component.nowColumnId = columnIndex;
      component.fromColumnId = component.nowColumnId;
      columns.value[Number(columnIndex)].push(component);
    } else if (columnIndex != component.fromColumnId) {
      /** 從別的欄位拉過來 */
      /** 新增 */
      columns.value[Number(columnIndex)].push(component);
      /** 移除 */
      columns.value[Number(component.fromColumnId)].splice(Number(component.memoIndex));
    }
  }
};
</script>

<style scoped>
.layout {
  background: green;
  width: 100%;
  height: 100%;
}
.columns {
  display: flex;
}
.canvas {
  /* 畫布樣式 */
  background: rgb(167, 209, 167);
  width: 90%;
  height: 100px;
}
</style>
