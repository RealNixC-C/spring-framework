<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

  <!-- Sidebar Toggle (Topbar) -->
  <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
      <i class="fa fa-bars"></i>
  </button>

  <!-- Topbar Search -->
  <form
      class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
      <div class="input-group">
          <input type="text" class="form-control bg-light border-0 small" placeholder="검색..."
              aria-label="Search" aria-describedby="basic-addon2">
          <div class="input-group-append">
              <button class="btn btn-primary" type="button">
                  <i class="fas fa-search fa-sm"></i>
              </button>
          </div>
      </div>
  </form>

  <!-- Topbar Navbar -->
  <ul class="navbar-nav ml-auto">

      <!-- Nav Item - Search Dropdown (Visible Only XS) -->
      <li class="nav-item dropdown no-arrow d-sm-none">
          <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
              data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <i class="fas fa-search fa-fw"></i>
          </a>
          <!-- Dropdown - Messages -->
          <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
              aria-labelledby="searchDropdown">
              <form class="form-inline mr-auto w-100 navbar-search">
                  <div class="input-group">
                      <input type="text" class="form-control bg-light border-0 small"
                          placeholder="검색..." aria-label="Search"
                          aria-describedby="basic-addon2">
                      <div class="input-group-append">
                          <button class="btn btn-primary" type="button">
                              <i class="fas fa-search fa-sm"></i>
                          </button>
                      </div>
                  </div>
              </form>
          </div>
      </li>

      <!-- Nav Item - Alerts -->
      <li class="nav-item dropdown no-arrow mx-1">
          <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
              data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <i class="fas fa-bell fa-fw"></i>
              <!-- Counter - Alerts -->
              <span class="badge badge-danger badge-counter">3+</span>
          </a>
          <!-- Dropdown - Alerts -->
          <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
              aria-labelledby="alertsDropdown">
              <h6 class="dropdown-header">
                  알람 센터
              </h6>
              <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="mr-3">
                      <div class="icon-circle bg-primary">
                          <i class="fas fa-file-alt text-white"></i>
                      </div>
                  </div>
                  <div>
                      <div class="small text-gray-500">December 12, 2019</div>
                      <span class="font-weight-bold">연간 계획을 다운로드 할 수 있습니다!</span>
                  </div>
              </a>
              <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="mr-3">
                      <div class="icon-circle bg-success">
                          <i class="fas fa-donate text-white"></i>
                      </div>
                  </div>
                  <div>
                      <div class="small text-gray-500">December 7, 2019</div>
                      300,000원이 계좌로 입금되었습니다.
                  </div>
              </a>
              <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="mr-3">
                      <div class="icon-circle bg-warning">
                          <i class="fas fa-exclamation-triangle text-white"></i>
                      </div>
                  </div>
                  <div>
                      <div class="small text-gray-500">December 2, 2019</div>
                      한달동안 지출 내역이 저번달 지출보다 많습니다.
                  </div>
              </a>
              <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
          </div>
      </li>

      <!-- Nav Item - Messages -->
      <li class="nav-item dropdown no-arrow mx-1">
          <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"
              data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <i class="fas fa-envelope fa-fw"></i>
              <!-- Counter - Messages -->
              <span class="badge badge-danger badge-counter">7</span>
          </a>
          <!-- Dropdown - Messages -->
          <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
              aria-labelledby="messagesDropdown">
              <h6 class="dropdown-header">
                  메세지 센터
              </h6>
              <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                      <img class="rounded-circle" src="img/undraw_profile_1.svg"
                          alt="...">
                      <div class="status-indicator bg-success"></div>
                  </div>
                  <div class="font-weight-bold">
                      <div class="text-truncate">안녕하세요! 궁금한점 문의드리고싶은데 도와주실 수 있나요?</div>
                      <div class="small text-gray-500">잡리 · 58m</div>
                  </div>
              </a>
              <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                      <img class="rounded-circle" src="img/undraw_profile_2.svg"
                          alt="...">
                      <div class="status-indicator"></div>
                  </div>
                  <div>
                      <div class="text-truncate">요청하신 사진 보정이 완료되었습니다. 어디로 보내드릴까요?</div>
                      <div class="small text-gray-500">월일 · 1d</div>
                  </div>
              </a>
              <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                      <img class="rounded-circle" src="img/undraw_profile_3.svg"
                          alt="...">
                      <div class="status-indicator bg-warning"></div>
                  </div>
                  <div>
                      <div class="text-truncate">저번달 보고서는 아주 좋았습니다 앞으로도 힘내 주시길 바래요!</div>
                      <div class="small text-gray-500">존매 · 2d</div>
                  </div>
              </a>
              <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
          </div>
      </li>

      <div class="topbar-divider d-none d-sm-block"></div>

      <!-- Nav Item - User Information -->
      <li class="nav-item dropdown no-arrow">
          <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
              data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <span class="mr-2 d-none d-lg-inline text-gray-600 small">박요한</span>
              <img class="img-profile rounded-circle"
                  src="img/undraw_profile.svg">
          </a>
          <!-- Dropdown - User Information -->
            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#">
                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                    프로틸
                </a>
                <a class="dropdown-item" href="#">
                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                    설정
                </a>
                <a class="dropdown-item" href="#">
                    <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                    활동기록
                </a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                    로그아웃
                </a>
            </div>
        </li>

    </ul>

</nav>