import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import layout from "@/components/Layout.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    component: layout,
  },
  // 其他路由配置...
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
