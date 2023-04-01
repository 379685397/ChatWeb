var url = "http://kod.utrycc.com/kodexplorer4.25/?explorer/search&accessToken=2114Kq64XDgy72lb6g3Gndq1Q5K5vPh1EFYGCc4NilGP55WT5rKCHE1rKtQno9i_pY8QIZ0j7LFgEg1LIA";
var parameter = "search=手册&path=%7BgroupPath%7D%3A1%2F&is_content=0&is_case=0&ext=";

const app = new Vue({
    el: '#app',
    data: {
        organization: {}
    },
    methods: {
        load: function () {
            axios.get(url)
                .then(response => {
                    this.organization = response.data;
                    console.log(response.data);

                })
        }
    },
    beforeMount() {
        this.load()
    }
})