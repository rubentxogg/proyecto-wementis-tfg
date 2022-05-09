<template>
  <div class="app container-fluid">
    <div class="row">
      <side-nav-menu v-if="this.isAuthenticated" class="col-3" />
      <spinner v-if="this.isLoading"/>
      <router-view v-else class="col bg-standard" />
    </div>
  </div>
</template>

<script>
import SideNavMenu from '@/components/SideNavMenu.vue';
import Spinner from '@/components/Spinner.vue';
import axios from 'axios';

export default {
  name: "App",
  data() {
    return {
      isAuthenticated: false,
      isLoading: false
    }
  },
  components: {
    SideNavMenu,
    Spinner
  },
  methods: {
    checkIsAuthenticated() {
      this.$router.beforeEach(async (to) => {
        this.isLoading = true;

        await axios.get("wementis/auth/isauthenticated")
          .then((response) =>  this.isAuthenticated = response.data )
          .catch(() => this.isAuthenticated = false)
          .finally(() => this.isLoading = false);

        if (!this.isAuthenticated && to.name !== 'Home') {
          return { name: 'Home' }
        }
      })
    }
  },
  mounted() {
    this.checkIsAuthenticated();
  }
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500&display=swap');

* {
  font-family: 'Ubuntu', sans-serif;
}

.bg-standard {
  background: rgb(255, 251, 251)
}

input[type="date"], 
input[type="radio"] {
  cursor: pointer;
}

tbody > tr:hover > * {
  background-color: #d5e6ff;
}

li {
  cursor: pointer;
}

.bg-pink {
  background-color: #d63384;
}

.bg-indigo {
  background-color: #6610f2;
}

.text-indigo {
  color: #6610f2;
}

.bg-teal {
  background-color: #20c997;
}

.text-teal {
  color: #20c997;
}

.accordion-button::after {
  display: none;
}

table {
  text-align: center;
}

.table {
  border-radius: 7px;
}

.input-group i{
  z-index: 100000;
}
</style>
