import React from 'react';

function CardList({cards}) {
    return (
        <div className="card-list my-3">
            <table className="table">
                <thead>
                    <tr>
                        <td>Name</td>
                        <td>Credit Card Number</td>
                        <td>Balance</td>
                        <td>Limit</td>
                    </tr>
                </thead>
                <tbody>
                    {
                        cards.map(card => <Card cardData={card} />)
                    }
                </tbody>
            </table>
        </div>
    );
}

function Card ({cardData}) {
    return (<tr>
                <td>{cardData.name}</td>
                <td>{formatCard(cardData.ccNumber)}</td>
                <td>{`£ ${cardData.balance.toFixed(2)}`}</td>
                <td>{`£ ${cardData.limit.toFixed(2)}`}</td>
            </tr>);
}

const formatCard = (ccNumber = '') => {
    let formattedRegex = ccNumber.match(/.{1,4}/g);
    return formattedRegex.join(' ');
}

export default CardList;
