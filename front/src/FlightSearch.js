import axios from "axios";
import React, { useState } from "react";

function FlightSearch() {
  const [startDate, setStartDate] = useState("2024-01-01");
  const [endDate, setEndDate] = useState("2024-01-01");

  const [response, setResponse] = useState({
    flights: [],
    loading: false,
    success: false,
    error: "",
  });

  const handleSearch = () => {
    setResponse({ flights: [], loading: true, success: false, error: "" });
    axios
      .get(
        `http://localhost:8080/flights/search?startDate=${startDate}&endDate=${endDate}`
      )
      .then((res) => {
        setResponse({
          flights: res.data[0],
          loading: false,
          success: true,
          error: "",
        });
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
      <div>
        <label>Fecha de inicio:</label>
        <input
          type="date"
          value={startDate}
          onChange={({ target: { value } }) => {
            setStartDate(value);
          }}
        ></input>
        <label>Fecha de fin:</label>
        <input
          type="date"
          value={endDate}
          onChange={({ target: { value } }) => {
            setEndDate(value);
          }}
        ></input>
        <button onClick={handleSearch}>Buscar</button>
      </div>
      <div>
        {response.loading && <p>Cargando...</p>}
        {response.error.length > 0 && <h3>response.error</h3>}
        {response.flights.length === 0 && response.success && (
          <p>No hay vuelos programados para estas fechas</p>
        )}
        {response.flights.length > 0 && (
          <ul>
            {response.flights.map((flight, idx) => {
              return (
                <>
                  <li id={`flight#${idx}`} key={flight.id}>
                    {`[${flight.id}] de ${flight.origin} a ${flight.destination}`}
                    <ul>
                      <li>{`Aerolinea: ${flight.airline}`}</li>
                      <li>{`Sale el ${flight.departureDate}`}</li>
                      <li>{`Llega el ${flight.arrivalDate}`}</li>
                      <li>{`Cuesta $${flight.price}`}</li>
                    </ul>
                  </li>
                </>
              );
            })}
          </ul>
        )}
      </div>
    </div>
  );
}

export { FlightSearch };
