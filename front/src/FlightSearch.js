import React from "react";
import DateRange from "./components/DateRange";
import PriceRange from "./components/PriceRange";

function FlightSearch({ activeFilter, handleSearch }) {
  const singleInputs = {
    1: { labelTxt: "Nombre de aerolina:", inputId: "airline" },
    2: { labelTxt: "Ciudad de origen:", inputId: "origin" },
    3: { labelTxt: "Ciudad de destino:", inputId: "destination" },
  };

  return (
    <div>
      <form
        onSubmit={(e) => {
          e.preventDefault();
          handleSearch(e);
        }}
      >
        <h3>Buscar vuelos</h3>
        {activeFilter === 0 && <DateRange />}
        {activeFilter > 0 && activeFilter < 4 && (
          <div className="inputField">
            <label htmlFor={singleInputs[activeFilter].inputId}>
              {singleInputs[activeFilter].labelTxt}
            </label>
            <input id={singleInputs[activeFilter].inputId} type="text"></input>
          </div>
        )}
        {activeFilter === 4 && <PriceRange />}
        <button type="submit" className="submitBtn">Buscar</button>
      </form>
    </div>
  );
}

export { FlightSearch };
