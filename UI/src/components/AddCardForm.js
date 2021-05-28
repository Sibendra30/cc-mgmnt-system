import React, {useState} from 'react';
import TextBoxWithLabel from "./TextBoxWithLabel";
import {addNewCard} from "../services/CardService";

function AddCardForm({addCardSuccessHandler}) {
    const [name, setName] = useState('');
    const [ccNumber, setCCNumber] = useState('');
    const [limit, setLimit] = useState('');

    const onFormValueChange = (inputId, value) => {
        if (inputId === 'name') {
            setName(value);
        } else if (inputId === 'ccNumber') {
            setCCNumber(value);
        } else if (inputId === 'limit') {
            setLimit(value);
        }
    }

    const addCard = () => {
        addNewCard({name, ccNumber, limit})
            .then(() => {
                setLimit('');
                setCCNumber('');
                setName('');
                addCardSuccessHandler();
            })
            .catch(errResponse => console.log(errResponse.data));
    }

    return (
        <div className="add-card">
            <h5 className="my-3">Add new card</h5>
            <TextBoxWithLabel label="Name"
                              id="name"
                              inputValue={name}
                              onChangeHandler={onFormValueChange}/>
            <TextBoxWithLabel label="Credit Card Number"
                              id="ccNumber"
                              inputValue={ccNumber}
                              onChangeHandler={onFormValueChange} />
            <TextBoxWithLabel label="Limit"
                              id="limit"
                              inputValue={limit}
                              onChangeHandler={onFormValueChange} />
            <button className="my-3 btn btn-primary w-100" onClick={addCard}>Add</button>
        </div>
    );
}

export default AddCardForm;
