import "./SimpleField.css";

const SimpleField = ({ mykey, myvalue  }) => {

    return (
        <div className="wrapper">
            <div className="first"><h4>{mykey}:</h4></div>
            <div className="second">{myvalue}</div>
        </div>
    )
}

export default SimpleField