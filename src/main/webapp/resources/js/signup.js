function signup() {
    const form = document.getElementById("signup");

    if (!form.id.value) {
        alert("아이디를 입력해 주시기 바랍니다");
        return;
    }

    if (form.id.value.length < 2) {
        alert("아이디는 최소 4자리 이상 입력하여야 합니다");
        return;
    }

    if (!id_check) {
        alert("아이디 중복검사를 하셔야 합니다");
        return;
    }

    if (!form.passwd.value || !form.passwd_check.value) {
        alert("비밀번호와 비밀번호 확인을 입력해 주시기 바랍니다");
        return;
    }

    if (form.passwd.value != form.passwd_check.value) {
        alert("비밀번호와 비밀번호 확인이 일치하도록 입력해 주시기 바랍니다");
        return;
    }

    if (!form.name.value) {
        alert("성명을 입력해 주시기 바랍니다");
        return;
    }

    if (!form.tel.value) {
        alert("전화번호를 입력해 주시기 바랍니다");
        return;
    }

    form.submit();
}