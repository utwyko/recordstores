import Vue from 'vue'
import Router from 'vue-router'
import Records from '@/components/Records'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Records',
      component: Records
    }
  ]
})
