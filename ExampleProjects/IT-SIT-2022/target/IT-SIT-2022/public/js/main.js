
function postUserInfo() {
    debugger
    const formData = toJSONString(document.querySelector('form.user-info'));

    fetch('UserEditInfoServlet', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json', 'Accept': 'application/json'
        },
        body: formData
    })
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            var element = document.getElementById('user_info_message');
            element.innerHTML = data.message;
            console.log(data);
            console.log(data.userBean);
        });

    return false;
}

function postUserSkills() {
    debugger
    const formData = toJSONString(document.querySelector('form.user-skill'));

    fetch('UserEditUserSkillServlet', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
        body: formData
    }).then((response) => {
            return response.json();
        }).then((json) => {
            /*
            {
                message: "Записано"
            }
            * */
            var element =
                document.getElementById('user_skill_message');
            element.innerHTML = json.message;
            console.log(json);
        });

    return false;
}

function postUserContact() {
    const formData = toJSONString(document.querySelector('form.user-contact'));
    fetch('usercontact', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json', 'Accept': 'application/json'
        },
        body: formData
    })
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            var element = document.getElementById('user_contact_message');
            element.innerHTML = data.message;
        });

    return false;
}

function toJSONString( form ) {
    console.log(form);
    var obj = {};
    var elements = form
        .querySelectorAll( "input, select, textarea" );

    for( var i = 0; i < elements.length; ++i ) {
        var element = elements[i];
        var name = element.name;
        var value = element.value;

        if( name ) {
            obj[ name ] = value;
        }
    }

    return JSON.stringify( obj );
}

// const editUserInfo = async (e) => {
//     debugger
//     e.preventDefault()
//     debugger
//     const formData = toJSONString(document.querySelector('form.user-info'));
//
//     const response = await fetch('UserEditInfoServlet', {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json', 'Accept': 'application/json'
//         },
//         body: formData
//     });
//
//     const json = await response.json();
//     console.log(json);
//     debugger
//     let element = document.getElementById('user_info_message');
//     element.innerHTML = json.message;
//     console.log(json);
//
//
//     return false;
// }