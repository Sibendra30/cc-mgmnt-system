import './App.css';
import React, {useEffect, useState} from 'react';
import CardList from './components/CardList';
import AddCardForm from './components/AddCardForm';
import {getCards} from './services/CardService';

function App() {
    const [cards, setCards] = useState([]);
    const [errMsg, setErrMsg] = useState('');
    useEffect(() => {
        getCards().then(successResponse => {
            setCards(successResponse.data);
            setErrMsg('')
        })
            .catch(error => errHandler(error));
    }, [])

    const addCardSuccessHandler = () => {
        getCards().then(successResponse => {
            setCards(successResponse.data);
            setErrMsg('')
        });
    }

    const errHandler = (error) => {
        setErrMsg("There is something wrong. Please try again later");
    }

    return (
        <div className="cc-app mx-2">
            <h3>Credit Card Management System</h3>
            <div className="err-msg">{errMsg}</div>
            <AddCardForm
                errHandler={errHandler}
                addCardSuccessHandler={addCardSuccessHandler} />
            <CardList cards={cards} />
        </div>
    );
}

export default App;
