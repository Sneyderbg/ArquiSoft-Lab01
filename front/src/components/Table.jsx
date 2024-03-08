import { TableRow } from "./TableRow";
import "../styles/Table.css";

export const Table = ({ flights }) => {
  return (
    <div className="tableBox">
      <div>id</div>
      <div>Origen</div>
      <div>Destino</div>
      <div>Aerolinea</div>
      <div>Fecha de salida</div>
      <div>Fecha de llegada</div>
      <div>Precio</div>
      {flights.map((flight) => (
        <TableRow flight={flight} />
      ))}
    </div>
  );
};
