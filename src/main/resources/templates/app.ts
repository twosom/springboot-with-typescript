import axios, {AxiosResponse} from 'axios'
import {HelloModel} from "./models/helloModel";

function fetchHelloModel() {
    return axios.get('/hello');
}

async function getHello(): Promise<AxiosResponse<HelloModel>> {
    return await fetchHelloModel();
}

async function main() {
    const {data} = await getHello();
    console.log(data);
}

main();
