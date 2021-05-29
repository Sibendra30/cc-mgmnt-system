import React from 'react';

function TextBoxWithLabel({label, id, inputValue, onChangeHandler, onKeyPressHanlder, maxLength}) {
    const onChange = (e) => {
        const isValid = onKeyPressHanlder ? onKeyPressHanlder(e.target.value) : true;
        if (onChangeHandler && isValid) {
            onChangeHandler(id, e.target.value)
        }
    }
    return (
        <div className="textbox-group my-3">
            <div>{label}</div>
            <input type="text"
                   maxLength={maxLength}
                   className="form-control textbox"
                   id={id}
                   value={inputValue}
                   onChange={onChange} />
        </div>
    );
}

export default TextBoxWithLabel;
