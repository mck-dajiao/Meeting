(function ($) {
    "use strict";

    $(document).ready(function(){
        //open outgoing links in new window
        $('a[href^="http://"]').add('a[href^="https://"]').attr('target','_blank');
    });
}(jQuery));