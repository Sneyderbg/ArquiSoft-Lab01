import React, { useState } from "react";
import "../styles/PriceRange.css";

export default function PriceRange() {
  const [range, setRange] = useState({ from: 0, to: 100 });

  const handleInput = (e) => {
    e.preventDefault();
    const reg = /^[0-9]+/;
    if (e.target.value.length === 0 || reg.test(e.target.value)) {
      setRange((prev) => {
        return { ...prev, [e.target.id.replace("Price", "")]: e.target.value };
      });
    }
  };

  return (
    <div className="priceRange">
      <div className="priceLabels">
        <label htmlFor="fromPrice">Desde</label>
        <label htmlFor="toPrice">Hasta</label>
      </div>
      <div className="priceInputs">
        <input
          value={range.from}
          id="fromPrice"
          type="number"
          onInput={handleInput}
        ></input>
        <span> - </span>
        <input
          value={range.to}
          id="toPrice"
          type="number"
          onInput={handleInput}
        ></input>
      </div>
    </div>
  );
}
