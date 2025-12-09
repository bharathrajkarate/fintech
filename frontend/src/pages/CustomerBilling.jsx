import { useState } from "react";
import SideBar from "./Sidebar";
import Footer from "./Footer";
import Header from "./Header";

export default function CustomerBilling() {

  return (
<div class="container-scroller">
  <Header />
    <div class="container-fluid page-body-wrapper">
      <SideBar />  
  {/* ------------------ Template Start ------------------ */}

        <div class="main-panel">
            <div class="content-wrapper">
              <h1>Customer Billing</h1>
            </div>
          </div>

  {/* ------------------ Template End ------------------ */}
      <Footer />
    </div>
</div>
  );
}