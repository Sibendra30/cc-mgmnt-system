import axios from "axios";

const CARD_BASE_URI = 'http://localhost:8083/cards'

export const addNewCard = (cardData) => {
    return axios.post(CARD_BASE_URI, cardData);
};

export const getCards = () => {
    return axios.get(CARD_BASE_URI);
}
