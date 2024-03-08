import React, { useState } from "react";

function FlightSearch({ handleSearch }) {
  const [startDate, setStartDate] = useState("2024-01-01");
  const [endDate, setEndDate] = useState("2024-01-01");

  return (
    <div>
      <h3>Buscar vuelos</h3>
      <div>
        <label>Fecha de inicio:</label>
        <input
          type="date"
          id="startDate"
          value={startDate}
          onChange={({ target: { value } }) => {
            setStartDate(value);
          }}
        ></input>
        <label>Fecha de fin:</label>
        <input
          type="date"
          id="endDate"
          value={endDate}
          onChange={({ target: { value } }) => {
            setEndDate(value);
          }}
        ></input>
        <button onClick={handleSearch}>Buscar</button>
      </div>
    </div>
  );
}

export { FlightSearch };
