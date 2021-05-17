import axios from 'axios'

const http = axios.create({
    baseURL: "http://localhost:8080/ws"
});

http.interceptors.request.use(config => {
    return config;
});

http.interceptors.response.use(response => {
    return response;
}, config => {
    throw config.response;
});

export default http;
