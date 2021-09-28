const api = {
    url: "http://localhost:8080/api/v1/mandarin"
}

 Vue.createApp({
    data() {
        return {
            vocab: [],
            showDetails: false,
            selectedVocab: ''
        }
    },
    methods: {
            showVocab(item) {
                this.selectedVocab = item;
                this.showDetails = true;
            }
        },
    created(){
        fetch(api.url)
        .then((response) => {
            return response.json();
        })
        .then((data) => {   
            this.vocab = data;
        })
    }
}).mount("#app")