import axios from "axios";
import React, { useState } from "react";
import { FlightsTable } from "./FlightsTable";

function FlightSearch() {
  const [startDate, setStartDate] = useState("2024-01-01");
  const [endDate, setEndDate] = useState("2024-01-01");

  const [response, setResponse] = useState({
    flights: [],
    loading: false,
    success: false,
    error: "",
  });

  const handleSearch = (e) => {
    e.preventDefault();
    setResponse({ flights: [], loading: true, success: false, error: "" });
    axios
      .get(
        `http://localhost:8080/flights/search?startDate=${startDate}&endDate=${endDate}`
      )
      .then((res) => {
        setResponse({
          flights: res.data,
          loading: false,
          success: true,
          error: "",
        });
        console.log(res)
      })
      .catch((err) => {
        console.error(err);
        setResponse({
          flights: [],
          loading: false,
          success: false,
          error: "Error con el servidor",
        });
      });
  };

  return (
    <div>
      <h1>Buscar vuelos</h1>
      <form onSubmit={handleSearch}>
        <div>
          <label>Fecha de inicio:</label>
          <input
            type="date"
            value={startDate}
            onChange={({ target: { value } }) => {
              setStartDate(value);
            }}
          ></input>
        </div>
        <div>
          <label>Fecha de fin:</label>
          <input
            type="date"
            value={endDate}
            onChange={({ target: { value } }) => {
              setEndDate(value);
            }}
          ></input>
        </div>
        <div>
          <button type="submit">Buscar</button>
        </div>
      </form>
      <div>
        {response.loading && <p>Cargando...</p>}
        {response.error.length > 0 && <h3>response.error</h3>}
        {response.flights.length === 0 && response.success && (
          <p>No hay vuelos programados para estas fechas</p>
        )}
      </div>
      {response.flights.length > 0 && (
        <FlightsTable flights={response.flights}></FlightsTable>
      )}
    </div>
  );
}

export { FlightSearch };
