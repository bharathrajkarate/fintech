import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Login from "./pages/Login";
import Dashboard from "./pages/Dashboard";
import ProtectedRoute from "./security/ProtectedRoute";
import CustomerBilling from "./pages/CustomerBilling";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login/>}/>
        <Route path="/login" element={<Login/> }/>
        <Route path="/dashboard" element={<ProtectedRoute> <Dashboard/> </ProtectedRoute> }/>
        <Route path="/hft_billing" element={<ProtectedRoute> <CustomerBilling/> </ProtectedRoute> }/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
