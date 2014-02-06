(function ($) {

  window.Application = window.Application || {};
  
  window.Application.model = Application.model || {};
  
  window.Application.model.musicas = Application.model.musicas || {};
  
  var CONFIG = Application.CONFIG || {};

  CONFIG.URL_BASE = "http://localhost:9000/";

  

  $(document).ready(function(){


    $.ajax({
      type: 'GET',
      dataType: "json",
      url: CONFIG.URL_BASE + "musics",
      success: function (responseData, textStatus, jqXHR) {
          console.log("in");
          window.Application.model.musicas = responseData;
      },
      error: function (responseData, textStatus, errorThrown) {
          alert('POST failed.');
      }
    });

//    $.get(CONFIG.URL_BASE + "musics", function( data ) {
  //        registros = data;          
    //    },
    //"json" );
    
  });

})(jQuery);
