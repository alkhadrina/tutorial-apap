import React from "react";
// import Button from "../button";
import classes from "./styles.module.css";

const Search = (props) => {
    const { onChange } = props;
    return (
        <form>
                <input
                    className={classes.textField}
                    type="text"
                    placeholder="Nama Item"
                    name="title"
                    onChange={onChange}
                    />
                </form>
    );
};
export default Search;