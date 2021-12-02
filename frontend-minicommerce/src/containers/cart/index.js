import React from 'react';
import APIConfig from '../../api/APIConfig';
import Item from '../../components/Item';

export default class Cart extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            shopItems: [],
            cartItems: [],
        };
    }

    componentDidMount() {
        this.loadData();
        console.log("panggil");
    }

    async loadData() {
        try {
        const { data } = await APIConfig.get("/cart");
        this.setState({ cartItems: data.result });
        } catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
        }
    }


    render() {
            return (
                <div className="container-fluid">
                    <h1 className="text-center mt-3 mb-0">Cart Items</h1>

                    <div className="container pt-3">
                        <div className="row mt-3">
                        <div>
                    {this.state.cartItems.map((item) => (
                    <Item
                        key={item.id}
                        id={item.id}
                        title={item.title}
                        price={item.price}
                        description={item.description}
                        category={item.category}
                        quantity={item.quantity}
                    />
                ))}
                </div>    
                        </div>
                    </div>

                </div>
            );
    }
}