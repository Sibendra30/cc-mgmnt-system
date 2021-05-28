import React from 'react';

function TextBoxWithLabel({label, id, inputValue, onChangeHandler}) {
    return (
        <div className="textbox-group my-3">
            <div>{label}</div>
            <input type="text"
                   className="form-control textbox"
                   id={id}
                   value={inputValue}
                   onChange={e => onChangeHandler ? onChangeHandler(id, e.target.value) : ''} />
        </div>
    );
}

export default TextBoxWithLabel;
