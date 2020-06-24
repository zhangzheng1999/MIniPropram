$(function(){
	// tab切换
	// $('.left-box li').on('click',function(){
	// 	var $this = $(this);
	// 	var $iframe = $('iframe');
	// 	$this.addClass('active').siblings().removeClass('active');
	// 	// $iframe.attr('src', $this.data('url'));
	// });

	// 呼入呼出效果
	$('.index-control').on('click',function(){
		var $this = $(this);
		if( $this.hasClass('index-control-click') ){

			$this.removeClass('index-control-click');
			$('.left-box').removeClass('left-box-click');
			$('.right-box').removeClass('right-box-click');
		} else {

			$this.addClass('index-control-click');
			$('.left-box').addClass('left-box-click');
			$('.right-box').addClass('right-box-click');
		}
	});
})