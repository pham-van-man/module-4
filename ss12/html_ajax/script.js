// Lấy các phần tử modal và nút
var modal = document.getElementById("modal");
var btn = document.getElementById("openModal");
var span = document.getElementsByClassName("close")[0];

// Mở modal khi nhấn nút
btn.onclick = function() {
    modal.style.display = "block";
}

// Đóng modal khi nhấn nút đóng
span.onclick = function() {
    modal.style.display = "none";
}

// Lấy các phần tử modal hình ảnh và nút
var imageModal = document.getElementById("imageModal");
var imgBtn = document.getElementById("openImageModal");
var closeImage = document.getElementsByClassName("close-image")[0];

// Mở modal hình ảnh khi nhấn nút
imgBtn.onclick = function() {
    var imageUrl = "https://via.placeholder.com/600"; // Thay thế bằng URL hình ảnh của bạn
    document.getElementById("modalImage").src = imageUrl;
    imageModal.style.display = "block";
}

// Đóng modal hình ảnh khi nhấn nút đóng
closeImage.onclick = function() {
    imageModal.style.display = "none";
}

// Đóng modal hình ảnh khi nhấn ra ngoài modal
window.onclick = function(event) {
    if (event.target == imageModal) {
        imageModal.style.display = "none";
    }
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
