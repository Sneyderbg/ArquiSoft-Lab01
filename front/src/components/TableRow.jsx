import "../styles/TableRow.css";
export const TableRow = ({ flight }) => {
  return (
    <>
      <div className="cel">{flight.id}</div>
      <div className="cel">{flight.origin}</div>
      <div className="cel">{flight.destination}</div>
      <div className="cel">{flight.airline}</div>
      <div className="cel">{flight.departureDate}</div>
      <div className="cel">{flight.arrivalDate}</div>
      <div className="cel">{flight.price}</div>
    </>
  );
};
