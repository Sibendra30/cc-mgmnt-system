import './App.css';
import React, {useEffect, useState} from 'react';
import CardList from './components/CardList';
import AddCardForm from './components/AddCardForm';
import {getCards} from './services/CardService';

function App() {
    const [cards, setCards] = useState([]);
    useEffect(() => {
        getCards().then(successResponse => setCards(successResponse.data));
    }, [])

    const addCardSuccessHandler = () => {
        getCards().then(successResponse => setCards(successResponse.data));
    }

    return (
        <div className="cc-app mx-2">
            <h3>Credit Card Management System</h3>
            <AddCardForm
                addCardSuccessHandler={addCardSuccessHandler} />
            <CardList cards={cards} />
        </div>
    );
}

export default App;
