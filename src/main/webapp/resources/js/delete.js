window.addEventListener("load", () => {
    document.querySelectorAll("button.delete").forEach(button => {
        button.addEventListener("click", e => {
            const { id } = e.target.dataset;

            alert(`확인 ${id}`);

            fetch(`/users/${id}`, {
                method: "DELETE"
            }).then(resp => {
                if(resp.ok) {
                    alert("확인 완료");

                    const button = document.querySelector(`button.delete[data-id='${id}']`);
                    button.closest("div").remove();
                }
            });
        });
    });
});