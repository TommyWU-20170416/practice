<template>
  <div class="container">
    <div class="memo" draggable="true" @dragstart="dragStart">
      <div class="frame1">
        <img
          src="https://aheioqhobo.cloudimg.io/v7/_playground-bucket-v2.teleporthq.io_/a85dfbf6-4147-4ea4-84a3-5f09a7cf78e6/afa2a5f1-d4a2-48f3-b373-34af052dbcbe?org_if_sml=16828"
          alt="Rectangle131051"
          class="rectangle13"
        />
        <img
          src="https://aheioqhobo.cloudimg.io/v7/_playground-bucket-v2.teleporthq.io_/a85dfbf6-4147-4ea4-84a3-5f09a7cf78e6/19ec443e-a0bf-4e29-95bb-cefa10b1c081?org_if_sml=1255"
          alt="image91051"
          class="image9"
        />
        <span class="text"><span>VUE專案建置</span></span>
      </div>
    </div>
  </div>
</template>
<!-- 舊式寫法 專門用 vue2 輸出 component
<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  methods: {
    dragStart(event: DragEvent) {
      event.dataTransfer!.setData("componentType", "memo1");
    },
  },
});
</script> -->

<script setup lang="ts">
import { defineProps, ref } from "vue";
import NewComponent from "@/components/interface/NewComponent";

const props = defineProps({
  columnId: {
    type: String,
    required: true,
    default: "-1", // 在這裡指定預設值
  },
  memoIndex: {
    type: String,
    required: true,
  },
});
const memo = ref<NewComponent>({
  type: "memo1",
  memoIndex: props.memoIndex,
  fromColumnId: "-1",
  nowColumnId: "",
});
const dragStart = (event: DragEvent) => {
  console.log("memo1", event);
  memo.value!.fromColumnId = props.columnId;
  event.dataTransfer?.setData("component", JSON.stringify(memo.value));
};
</script>

<style scoped>
.container {
  width: 100%;
  display: flex;
  overflow: auto;
  min-height: 100vh;
  align-items: flex-start;
  flex-direction: row;
  justify-content: center;
  box-sizing: border-box;
}
.memo {
  gap: 10px;
  width: 100%;
  height: auto;
  display: flex;
  padding: 48px 39px;
  overflow: hidden;
  flex-wrap: wrap;
  align-items: center;
  justify-content: center;
  background-color: rgba(255, 255, 255, 1);
}
.frame1 {
  gap: 10px;
  display: flex;
  position: relative;
  align-items: center;
  flex-direction: column;
  justify-content: center;
}
.rectangle13 {
  width: 228px;
  height: 66px;
  border-radius: 10px;
}
.image9 {
  top: 18px;
  left: 36px;
  width: 29px;
  height: 29px;
  z-index: 1;
  position: absolute;
}
.text {
  top: 21px;
  left: 65px;
  color: rgba(0, 0, 0, 1);
  height: auto;
  z-index: 2;
  position: absolute;
  font-size: 20px;
  font-style: Regular;
  text-align: left;
  font-family: Inter;
  font-weight: 400;
  line-height: normal;
  font-stretch: normal;
  text-decoration: none;
}
</style>
