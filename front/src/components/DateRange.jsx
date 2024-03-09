import React, { useState } from "react";

import "../styles/DateRange.css";

export default function DateRange() {
  const [startDate, setStartDate] = useState("2024-01-01");
  const [endDate, setEndDate] = useState("2024-01-01");

  return (
    <div className="dateRange">
      <div className="datesLbls">
        <label>Fecha de inicio</label>
        <label>Fecha de fin</label>
      </div>
      <div className="datesInputs">
        <input
          type="date"
          id="startDate"
          value={startDate}
          onChange={({ target: { value } }) => {
            setStartDate(value);
          }}
        ></input>
        <span> - </span>
        <input
          type="date"
          id="endDate"
          value={endDate}
          onChange={({ target: { value } }) => {
            setEndDate(value);
          }}
        ></input>
      </div>
    </div>
  );
}
