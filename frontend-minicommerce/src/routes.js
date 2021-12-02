import React from "react";
import { Route, Switch, Redirect } from "react-router-dom";
import Cart from "./containers/cart";
import ItemList from "./containers/itemlist";

export const AppRoutes = () => {
    return (
        <div>
            <Switch>
                <Route exact path="/itemlist" component={ItemList}/>
                <Route exact path="/cart" component={Cart}/>
                <Route exact path="/">
                    <Redirect to="/itemlist"/>
                </Route>
            </Switch>
        </div>
    )
}