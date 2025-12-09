import { useEffect, useState, useRef } from "react";
import { Navigate } from "react-router-dom";

function ProtectedRoute({ children }) {
  const [auth, setAuth] = useState(null);
  const [errorMsg, setErrorMsg] = useState("");
  const alerted = useRef(false); // 👉 only alert once

  useEffect(() => {
    fetch("http://localhost:8089/api/Lkj_dkjfi_6767_67TUsf_sfjskfLKG", {
      method: "GET",
      credentials: "include",
    })
      .then(async (res) => {
        if (res.ok) {
          setAuth(true);
        } else {
          const data = await res.json();
          setErrorMsg(data.message);
          setAuth(false);
        }
      })
      .catch((err) => {
        setErrorMsg("Server Error");
        setAuth(false);
      });
  }, []);

  if (auth === null) {
    return null; // Loading
  }

  if (auth === false) {
    if (!alerted.current) {
      alerted.current = true;  // 👉 only once
      alert(errorMsg);
    }
    return <Navigate to="/login" replace />;
  }

  return children;
}

export default ProtectedRoute;
