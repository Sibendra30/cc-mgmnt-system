import React, {useState} from 'react';
import TextBoxWithLabel from "./TextBoxWithLabel";
import {addNewCard} from "../services/CardService";

function AddCardForm({addCardSuccessHandler, errHandler}) {
    const [errMsg, setErrMsg] = useState('');
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

    const numberOnly = (value) => {
        const numbers = /^[0-9]+$/;
        if (value.match(numbers)) {
            return true
        }
        return false;
    }

    const addCard = () => {
        if (!name || !ccNumber || !limit) {
            setErrMsg('Mandatory field missing');
            return ;
        }
        setErrMsg('');
        addNewCard({name, ccNumber, limit})
            .then(() => {
                setLimit('');
                setCCNumber('');
                setName('');
                addCardSuccessHandler();
            })
            .catch(errResponse => {
                console.log(errResponse);
                errHandler && errHandler(errResponse);
            });
    }

    return (
        <div className="add-card">
            <h5 className="my-3">Add new card</h5>
            <div className="err-msg">{errMsg}</div>
            <TextBoxWithLabel label="Name*"
                              id="name"
                              inputValue={name}
                              maxLength={40}
                              onChangeHandler={onFormValueChange}/>
            <TextBoxWithLabel label="Credit Card Number*"
                              id="ccNumber"
                              inputValue={ccNumber}
                              maxLength={19}
                              onKeyPressHanlder={numberOnly}
                              onChangeHandler={onFormValueChange} />
            <TextBoxWithLabel label="Limit*"
                              id="limit"
                              inputValue={limit}
                              onKeyPressHanlder={numberOnly}
                              maxLength={10}
                              onChangeHandler={onFormValueChange} />
            <button className="my-3 btn btn-primary w-100" onClick={addCard}>Add</button>
        </div>
    );
}

export default AddCardForm;
