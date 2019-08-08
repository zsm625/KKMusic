define("player.js", function(t, n, e) {
	var a = t("js/common/music.js"),
		s = (t("js/common/music/scroller.js"), a.statistics),
		o = t("js/common/module/webplayer.js").interFace,
		l = t("js/common/module/lrcHandler.js"),
		r = t("js/common/module/qrcHandler.js"),
		c = a.$;
	a.jQueryAjax;
	window.MUSIC = a;
	var p = t("js/common/music/storage.js"),
		m = a.widget.user,
		d = a.userAgent,
		g = null,
		u = a.player_storage,
		f = "//y.gtimg.cn/mediastyle/yqq/extra/player_cover.png?max_age=31536000",
		y = function() {
			try {
				window.console && console.log([].slice.call(arguments).join("\t"))
			} catch (t) {}
		},
		b = {
			0: "1",
			13: "1",
			111: "13",
			112: "14",
			113: "15"
		};
	var v = -1,
		h = null,
		k = {
			pos: 0,
			volume: 75,
			trans: 0,
			mode: 3
		};
	_playlistBar = {}, curBoxClassName = "js_full_box", _favlistBar = {};

	function w(n, e, s) {
		a.cookie.set("yplayer_open", 1);
		var l = n && 0 == n.play,
			r = (parseInt(a.cookie.get("yq_index")), a.player.getPlayerOptions().mod);
		a.player.getPlayerOptions().deleteList;
		l || 1 == r && (l = !0);
		var p = [];
		n && (c.each(n.list, function(t, n) {
			n && n.disabled && n.disabled || n.flagCopyrightPay || p.push(n)
		}), n.list = p), e = e || !1;
		var m = function(t) {
			var n, e = "";
			Array.prototype.join;
			e += "";
			var s = t.list;
			for (i = 0; i < s.length; i++) {
				e += '\r\n                            <li mid="' + (null == (n = s[i].songid) ? "" : n) + '" ix="' + (null == (n =
						s[i].ix) ? "" : n) +
					'"  data-page="player" data-stat="y_new.player.songlist.dbclick">\r\n                                <div class="songlist__item">\r\n                                    <div class="songlist__edit sprite">\r\n                                        <input type="checkbox" class="songlist__checkbox">\r\n                                    </div>\r\n                                    <div class="songlist__number',
					i >= 99 && (e += " songlist__number--small"), e += '">' + (null == (n = i + 1) ? "" : n) +
					'</div>\r\n                                    <div class="songlist__songname">\r\n                                        <span class="songlist__songname_txt" title="' +
					(null == (n = s[i].songname) ? "" : _.escape(n)) + '">' + (null == (n = s[i].songname) ? "" : _.escape(n)) +
					'</span>\r\n                                        <div class="mod_list_menu">\r\n\t\t\t\t\t    <a href="javascript:;" class="list_menu__item list_menu__play js_play" data-stat="y_new.player.songlist.playone" data-page="player" title="播放">\r\n\t\t\t\t\t\t<i class="list_menu__icon_play"></i>\r\n\t\t\t\t\t\t<span class="icon_txt">播放</span>\r\n\t\t\t\t\t    </a>\r\n\t\t\t\t\t    <a href="javascript:;" class="list_menu__item list_menu__add js_fav" ',
					s[i].action.fav && 5 != s[i].songtype || (e += 'style="display:none;"'), e +=
					' data-stat="y_new.player.songlist.addone" title="添加到歌单" aria-haspopup="true">\r\n\t\t\t\t\t\t<i class="list_menu__icon_add"></i>\r\n\t\t\t\t\t\t<span class="icon_txt">添加到歌单</span>\r\n\t\t\t\t\t    </a>\t\t\t\t\t    \r\n\t\t\t\t\t\t',
					s[i].pay.pay_month && s[i].pay.pay_month > 0 && s[i].pay.pay_down > 0 ? (e +=
						'\r\n\t\t\t\t\t\t<a href="javascript:;" class="list_menu__item list_menu__down js_down" title="VIP下载" aria-haspopup="true" data-target="menu_down" ',
						(s[i].action.down_lq || s[i].action.down_hq || s[i].action.down_sq) && 5 != s[i].songtype || (e +=
							'style="display:none;"'), e +=
						'>\r\n\t\t\t\t\t\t\t<i class="list_menu__icon_down_vip"></i>\r\n\t\t\t\t\t\t\t<span class="icon_txt">VIP下载</span>\r\n\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t'
					) : (e +=
						'\r\n\t\t\t\t\t\t<a href="javascript:;" class="list_menu__item list_menu__down js_down" title="下载" aria-haspopup="true" data-target="menu_down" ',
						(s[i].action.down_lq || s[i].action.down_hq || s[i].action.down_sq) && 5 != s[i].songtype || (e +=
							'style="display:none;"'), e +=
						'>\r\n\t\t\t\t\t\t    <i class="list_menu__icon_down"></i>\r\n\t\t\t\t\t\t    <span class="icon_txt">下载</span>\r\n\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t'
					), e += '\r\n\t\t\t\t\t    <a href="javascript:;" class="list_menu__item list_menu__share js_share" ', s[i].action
					.share && 5 != s[i].songtype || (e += 'style="display:none;"'), e +=
					' data-stat="y_new.player.songlist.shareone" title="分享" aria-haspopup="true">\r\n\t\t\t\t\t\t<i class="list_menu__icon_share"></i>\r\n\t\t\t\t\t\t<span class="icon_txt">分享</span>\r\n\t\t\t\t\t    </a>\r\n                                        </div>\r\n                                    </div>\r\n\t\t\t\t';
				for (var o = [], l = 0, r = s[i].singer.length; l < r; l++) {
					var c = s[i].singer[l];
					o.push(c.name)
				}
				e += '\r\n\t\t\t\t    <div class="songlist__artist" title="' + (null == (n = o.join(" / ")) ? "" : _.escape(n)) +
					'">\r\n\t\t\t\t\t';
				for (l = 0, r = s[i].singer.length; l < r; l++) {
					c = s[i].singer[l];
					e += "\r\n\t\t\t\t\t", l > 0 && (e += "/"), e += '\r\n\t\t\t\t\t<a href="' + (null == (n = a.util.getSingerUrl(
							c)) ? "" : n) + '" data-singermid="' + (null == (n = c.mid) ? "" : n) + '" data-singerid="' + (null == (n = c
							.id) ? "" : n) + '" title="' + (null == (n = c.name) ? "" : _.escape(n)) +
						'" data-stat="y_new.player.songlist.singername" class="singer_name" data-page="player">' + (null == (n = c.name) ?
							"" : _.escape(n)) + "</a>\r\n\t\t\t\t\t"
				}
				e +=
					'\r\n                                    </div>\r\n                                    <div class="songlist__time">' +
					(null == (n = s[i].playTime) ? "" : n) +
					'</div>\r\n                                    <div class="songlist__other">\r\n\t\t\t\t\t', 1 == s[i].action.soso &&
					(e += '\r\n\t\t\t\t\t<a href="javascript:;" class="icon_sosomusic sprite">无版权</a>\r\n\t\t\t\t\t'), e +=
					'\r\n                                    </div>\r\n                                    <a href="javascript:;" class="songlist__delete js_delete" data-page="player" data-stat="y_new.player.songlist.delete" title="删除"><span class="icon_txt">删除</span></a>\r\n                                    <i class="player_songlist__line"></i>\r\n                                </div>\r\n                            </li>\r\n\t'
			}
			return e += ""
		};
		setTimeout(function() {
			u.getAdd(e ? p : [], !n || 0 == n.play, function(i) {
				if (i.length > 0) {
					for (var l = [], _ = 0; _ < i.length; _++) i[_].flagCopyrightPay || i[_].action && !i[_].action.play || l.push(
						i[_]);
					f = c("#song_box"), y = l, b = [], v = m, h = !!n && !!n.play, void 0 || !1, t.async(
						"js/common/html/songlist.js",
						function(t) {
							t.init({
								container: f,
								specilData: y,
								specialTpl: v,
								reportType: a.reportMap.player,
								actions: T,
								from: 0,
								callback: function() {
									d.webkit ? d.webkit && c(".sb_overview").length > 0 && c(".sb_overview").css({
										height: c(".player__bd").height() - 56
									}) : g = c(".sb_scrollable").scrollbar({
										overviewElement: ".sb_overview",
										barElement: ".scroll_area",
										onScrolled: function(t, n) {}
									});
									var t = [];
									for (var e in y) {
										var i = y[e];
										for (var l in b) i && b[l] && i.songid == b[l].songid && t.push(i)
									}
									var _ = parseInt(a.cookie.get("yq_index")) || 0;
									h && 0 == r || !n ? 4 == k.mode ? !n || 1 == n.list.length && 10050 == n.list[0].toptype ? (o.setPlayerList(
										!1, y, k.mode), setTimeout(function() {
										o.playAnyPos(_)
									}, 500)) : o.setPlayerList(!0, y, k.mode) : (o.setPlayerList(!1, y, k.mode), setTimeout(function() {
										o.playAnyPos(_)
									}, 500)) : o.setPlayerList(!1, y, k.mode), (/Version.(\d+\.\d+)/i.exec(navigator.userAgent) ||
										window.safariHandler) && setTimeout(function() {
										o.playAnyPos(_)
									}, 500), !d.webkit && g && g.scrollbar("scrollToY", 0), d.webkit && (c(".sb_overview")[0].scrollTop = -
										10), s && s(), P._curSongInfo && (c("div.songlist__item", c('li[mid="' + P._curSongInfo.songid +
										'"]')).addClass("songlist__item--playing"), c(".js_play", c('li[mid="' + P._curSongInfo.songid +
										'"]')).attr("title", "暂停").html(
										'<i class="list_menu__icon_pause"></i><span class="icon_txt">暂停</span>'))
								}
							})
						})
				} else s && s();
				var f, y, b, v, h;
				e && u.add(p, !n || 0 == n.play)
			})
		}, 300)
	}
	var j = function() {
		var t, n, e, a = !0;

		function i(t) {
			t.preventDefault(), t.stopPropagation(), a || (c(_oMute).hasClass("btn_big_voice--no") ? (c(_oMute).removeClass(
				"btn_big_voice--no"), c(_oMute).html('<span class="icon_txt">关闭声音[M]</span>')) : (c(_oMute).addClass(
				"btn_big_voice--no"), c(_oMute).html('<span class="icon_txt">打开声音[M]</span>')), o.mutePlayer(), s.pgvClickStat(
				"y_new.player.opbanner.no_voice"))
		}

		function l(t) {
			t.preventDefault(), t.stopPropagation();
			var n = c(e),
				a = t.pageX;
			_change_vol = parseInt(100 * (a - n.offset().left) / n.width(), 10), r(_change_vol)
		}

		function r(n) {
			a || !isNaN(n) && n >= 0 && n < 101 && (t.style.width = n + "%", o.setVolumn(n), k.volume = n, p.set("y_mod", [k.mode,
				k.volume, k.trans
			].join("|")), c(_oMute).hasClass("btn_big_voice--no") && (c(_oMute).removeClass("btn_big_voice--no"), c(_oMute)
				.html('<span class="icon_txt">关闭声音[M]</span>'), o.mutePlayer()))
		}
		return {
			init: function() {
				if (a) {
					a = !1;
					var s = o.getVolumn() || k.volume;
					(s <= 0 || s > 100) && (s = 75), t = c("#spanvolumebar")[0], n = c("#spanvolumeop")[0], e = c("#spanvolume")[0],
						_oMute = c("#spanmute")[0], r(s), c("#voice,#spanvolume").on("click", function(t) {
							t.preventDefault(), t.stopPropagation();
							var n = c(e),
								a = t.pageX;
							_change_vol = parseInt(100 * (a - n.offset().left) / n.width(), 10), r(_change_vol)
						}), c(_oMute).on("click", i), c(n).on("mousedown", function(t) {
							t.preventDefault(), t.stopPropagation(), c("#voice")[0], c(document).off("mousemove").on("mousemove", l), c(
								document).on("mouseup", function() {
								c(document).off("mousemove")
							}), c("#divplayer")
						})
				}
			},
			incVol: function() {
				var t = k.volume || o.getVolumn();
				(t < 0 || t > 100) && (t = 75), r(t += 5)
			},
			decVol: function() {
				var t = k.volume || o.getVolumn();
				(t < 0 || t > 100) && (t = 75), r(t -= 5)
			},
			mute: i
		}
	}();

	function x(t) {
		var n = parseInt(t / 60, 10),
			e = t % 60;
		return (n < 10 ? "0" + n : n) + ":" + (e < 10 ? "0" + e : e)
	}
	var I = !1,
		C = function() {
			var t, n, e, s, i = 0;
			var r = 0;

			function _(t) {
				if (!isNaN(t) && t >= 0 && t < 101) {
					var n = o.getDownloadProgress();
					t = Math.min(t, n), e.style.width = t + "%", i = t, r = t;
					var a = parseInt(c("#time_show").data("total"));
					a > 0 && t % 3 == 0 && (document.getElementById("time_show").innerText = x(parseInt(t * a / 100, 10)) + " / " +
						x(a))
				}
			}

			function p() {
				var t = o.getDownloadProgress(),
					n = r || i;
				n = Math.min(n, t) + 1;
				var e = o.getSongDuration(),
					a = parseInt(n * e / 100);
				P._isPlaying ? (o.setPlayProgress(a), m(a)) : T.play(h, function() {
					o.setPlayProgress(a), m(a)
				})
			}

			function m(t) {
				d.safari || d.chrome || d.isiPad || d.isiPhone;
				if (l.haveLrc) {
					var n = c('p[data-id="line_' + l.lrcItemIndex + '"]');
					if (n.length > 0 && n.removeClass("on"), l.getLyricLineItemByPlayTime(l.ms2playTime(parseInt(1e3 * t)))) {
						var e = l.lrcItemIndex,
							s = 0;
						c.each(c(".qrc_ctn"), function(t, n) {
							if ("none" != c(n).parents(".js_box").css("display")) {
								e = l.lrcItemIndex;
								var o = parseInt(c(n).data("mod"));
								if (curBoxClassName == {
										1: "js_full_box",
										2: "js_simp_box"
									} [o]) {
									for (; e-- > (1 == o ? 1 : 3);) {
										var i = c('p[data-id="line_' + e + '"]', c(n))[0];
										s += i ? i.offsetHeight : 1 == o ? 24 : 0
									}
									s < 0 && (s = 0), a.util.supportCss3("-webkit-transition") && a.util.supportCss3("-webkit-transform") ? (n
										.style.webkitTransition = "-webkit-transform 0.1s ease-out", n.style.webkitTransform = "translateY(" + -
										1 * s + "px)") : a.util.supportCss3("transition") && a.util.supportCss3("transform") ? (n.style.transition =
										"transform 0.1s ease-out", n.style.transform = "translateY(" + -1 * s + "px)") : c(n).parent(
										".js_lyric_box").scrollTop(s)
								}
							}
						}); - 1 == l.preLrcItemIndex || l.preLrcItemIndex;
						var o = l.lrcItemIndex,
							i = c('p[data-id="line_' + o + '"]', "." + curBoxClassName);
						if (i.length > 0) {
							if (o > 0) {
								var r = c("p", "." + curBoxClassName);
								r.length > 0 && r.removeClass("on")
							}
							i.html(l.lrcItem.context).addClass("on"), c(".js_trans_btn").hasClass("btn_lang--select") ? c(".js_trans_line")
								.show() : c(".js_trans_line").hide()
						}
						l.restartAnimFrame("qrc_ctn")
					}
				}
			}
			return {
				init: function() {
					t = c("#spanplayer_bgbar")[0], s = c("#downloadbar")[0], n = c("#spanprogress_op")[0], e = c("#spanplaybar")[0],
						c("#time_show")[0], c(t).width() - c(n).width() - 2 * c(n).offset().left - 1, c(
							"#progress,#downloadbar,#spanplayer_bgbar").on("click", function(t) {
							t.preventDefault(), t.stopPropagation();
							var n = c(s),
								e = t.pageX;
							_(parseInt(100 * (e - n.offset().left) / n.width(), 10)), p()
						}), c(e).on("click", function(n) {
							n.preventDefault(), n.stopPropagation();
							var e = c(t),
								a = n.pageX;
							_(parseInt(100 * (a - e.offset().left) / e.width(), 10)), p()
						}), c(n).on("mousedown", function(e) {
							I = !0, e.preventDefault(), e.stopPropagation();
							var a = (new Date).getTime(),
								s = c(n);
							e.pageX;
							s.offset().left, c(t).offset().left, c("#progress")[0], c(document).off("mousemove").on("mousemove",
								function(n) {
									if (I) {
										if ((new Date).getTime() - a < 300) return !1;
										! function(n, e) {
											n.preventDefault(), n.stopPropagation();
											var a = c("#spanplayer_bgbar").offset().left,
												s = n.pageX;
											_(parseInt(100 * (s - a) / c(t).width(), 10))
										}(n)
									}
								}), c(document).on("mouseup", function(t) {
								I && (c(document).off("mousemove"), p(), I = !1)
							})
						})
				},
				update: _,
				destroy: function() {
					c(t).off("click"), c(e).off("click"), c(n).off("mousedown")
				}
			}
		}(),
		S = !0,
		P = function() {
			var n = "g_first_play",
				e = null,
				i = function(t, e) {
					var a = c("#btnplay"),
						s = e || "g_pause";
					"pause" == (t || "pause") ? (c(".js_play", c("#song_box .songlist__item--playing")).attr("title", "播放").html(
						'<i class="list_menu__icon_play"></i><span class="icon_txt">播放</span>'), c(
						"#song_box .songlist__item--playing").removeClass("songlist__item--playing"), a.removeClass(
						"btn_big_play--pause"), c("span", a).html("播放")) : (P._curSongInfo && (c("div.songlist__item", c('li[mid="' + P
							._curSongInfo.songid + '"]')).addClass("songlist__item--playing"), c(".js_play", c('li[mid="' + P._curSongInfo
							.songid + '"]')).attr("title", "暂停").html(
							'<i class="list_menu__icon_pause"></i><span class="icon_txt">暂停</span>')), a.addClass("btn_big_play--pause"),
						c("span", a).html("暂停")), n = s
				};

			function _(t, n) {
				var e = new Image;
				n = n || "74", e.src = "//c.y.qq.com/tplcloud/fcgi-bin/fcg_reportlsting_web.fcg?musicid=" + n + "&isexit=" + t +
					"&g_tk=" + a.getACSRFToken() + "&_r=" + (new Date).valueOf(), e.style.width = "0", e.style.height = "0"
			}
			return {
				_setQQstatus: _,
				_isPlaying: !1,
				_isFirst: !0,
				_curSongInfo: null,
				_errorPlayId: [],
				clearlist: !1,
				init: function() {
					o.OnSongPlayBegin = function(t, n, e) {
						a.cookie.set("yq_index", n, null, null, 2400), y("OnSongPlayBegin begin:" + (new Date).getUTCMilliseconds()),
							P._isPlaying = !0, P._curSongInfo = t, setTimeout(function() {
								var n = parseInt(parseInt(c(".sb_scrollable").css("height")) / 50) - 2;
								c(".sb_overview").scrollTop() < 50 * (t.ix - n) ? (!d.webkit && g && g.scrollbar("scrollToY", 50 * (t.ix -
										n)), d.webkit && (c(".sb_overview")[0].scrollTop = 50 * (t.ix - n))) : c(".sb_overview").scrollTop() >
									50 * t.ix && (!d.webkit && g && g.scrollbar("scrollToY", 50 * t.ix), d.webkit && (c(".sb_overview")[0].scrollTop =
										50 * t.ix))
							}, 1e3), "mod_songname_menu__like--liked" == t.fav ? (c(".js_btn_fav", "#opbanner").addClass(
								"btn_big_like--like"), c(".js_btn_fav").attr("title", "取消喜欢[V]")) : (c(".js_btn_fav", "#opbanner").removeClass(
								"btn_big_like--like"), c(".js_btn_fav").attr("title", "喜欢[V]")), setTimeout(function() {
								r.clearQrcInfo(), t && r.init({
									songtype: t.songtype,
									songMId: t.songmid,
									songId: t.songid,
									qrcContainer: "qrc_ctn"
								}), l.clearLrcInfo()
							}, 200), p.get("y_mod", function(t) {
								if (t) {
									var n = t.split("|");
									n.length > 0 && (k.mode = parseInt(n[0])), n.length > 1 && (k.volume = parseInt(n[1])), n.length > 2 && (
										k.trans = parseInt(n[2]))
								}
								1 == k.trans ? (c(".js_trans_btn").removeClass("btn_lang--select"), c(".js_trans_line").show()) : (c(
									".js_trans_line").hide(), c(".js_trans_btn").addClass("btn_lang--select")), j.init()
							}), C.init(), P.renderSong(t), setTimeout(function() {
								t && _(!1, t.songid)
							}, 700)
					}, o.OnSongPlayEnd = function(t, n, e) {
						P._isPlaying = !1, i("pause", "g_play"), r.haveqrc ? r.clearQrcInfo() : l.haveLrc && l.clearLrcInfo(),
							document.title = "QQ音乐-千万正版音乐海量无损曲库新歌热歌天天畅听的高品质音乐平台！"
					}, o.OnSongPlaying = function(t, n) {
						if (o.setVolumn(k.volume), -1 == v && (v = 0), !isNaN(t) && !isNaN(n)) {
							var e = !!(d.safari || d.chrome || d.isiPad || d.isiPhone),
								a = e ? parseInt(t / 1e3) : t,
								s = c(".qrc_ctn");
							if (P._isPlaying) {
								if (c("#time_show").data("total", n), I || (c("#time_show").html(x(parseInt(a, 10)) + " / " + x(n)), k.pos =
										parseInt(100 * a / n, 10), c("#spanplaybar").width(k.pos + "%")), r.reqFlag) return;
								var i = c("p", s).length > 1 ? c("p:eq(1)", s) : "";
								if (r.haveqrc && ("歌词正在加载中..." == i || "" == i)) return s.html(
									'<p data-id="line_null" class="on">&nbsp;</p>' + r.printQrcLines()), void r.startAnimFrame("qrc_ctn");
								if (!r.haveqrc && -1 == l.reqFlag) return void l.init(r.playingSongInfo);
								if (!r.haveqrc && 0 == l.reqFlag) return;
								if (!r.haveqrc && 1 == l.reqFlag) {
									if (l.haveLrc && ("歌词正在加载中..." == i || "" == i)) {
										var _ = l.printLrcLines();
										return "" == _ ? (l.haveLrc = !1, void(
											'<p>&nbsp;</p><p><a href="javascript:;" class="js_btn_feedback">该单曲暂无歌词，点击这里进行反馈</a></p>' != s.html() &&
											0 == l.txtLrc && s.html(
												'<p>&nbsp;</p><p><a href="javascript:;" class="js_btn_feedback">该单曲暂无歌词，点击这里进行反馈</a></p>'))) : (s.html(
											'<p data-id="line_null" class="on">&nbsp;</p>' + _), void l.startAnimFrame("qrc_ctn"))
									}
									if (!l.haveLrc) return void(
										'<p>&nbsp;</p><p><a href="javascript:;" class="js_btn_feedback">该单曲暂无歌词，点击这里进行反馈</a></p>' != s.html() &&
										0 == l.txtLrc && s.html(
											'<p>&nbsp;</p><p><a href="javascript:;" class="js_btn_feedback">该单曲暂无歌词，点击这里进行反馈</a></p>'))
								}
								if (l.haveLrc) {
									if (l.getLyricLineItemByPlayTime(l.ms2playTime(e ? t : 1e3 * t))) {
										var p = -1 == l.preLrcItemIndex ? "null" : l.preLrcItemIndex,
											m = l.lrcItemIndex,
											g = c("." + curBoxClassName + ' p[data-id="line_' + m + '"]');
										g.length > 0 && m != p && (m > 0 && c("p", "." + curBoxClassName).removeClass("on"), g.addClass("on"))
									}
								} else '<p>&nbsp;</p><p><a href="javascript:;" class="js_btn_feedback">该单曲暂无歌词，点击这里进行反馈</a></p>' != s.html() &&
									0 == l.txtLrc && s.html(
										'<p>&nbsp;</p><p><a href="javascript:;" class="js_btn_feedback">该单曲暂无歌词，点击这里进行反馈</a></p>')
							}
						}
					}, o.OnPlaying = function() {
						i("play", "g_play"), P._errorPlayId = []
					}, o.OnPlayPause = function() {
						i("pause", "g_pause")
					}, o.OnPlayError = function(t, n) {
						3 == t.type || 0 == t.type && t.action.soso;
						if (!P._errorPlayId[t.playid]) {
							P._errorPlayId[t.playid] = 1;
							var e = c("#song_box");
							if (e.length > 0) {
								var a = c("li", e);
								a && a.length > 1 && o.nextPlayer()
							}
						}
						document.title = "QQ音乐-千万正版音乐海量无损曲库新歌热歌天天畅听的高品质音乐平台！"
					}, o.OnSongDownloading = function(t) {
						var n = c("#downloadbar");
						n.length > 0 && n.width(t + "%")
					}, p.get("y_mod", function(t) {
						if (t) {
							var n = t.split("|");
							n.length > 0 && (k.mode = parseInt(n[0])), n.length > 1 && (k.volume = parseInt(n[1])), n.length > 2 && (k.trans =
								parseInt(n[2]))
						}
						P.realSetPlayWay(k.mode), e = k.mode, k.mode = e, p.set("y_mod", [k.mode, k.volume, k.trans].join("|")), o.setMode(
							e);
						var e;
						o.setVolumn(k.volume)
					}), P.renderSong(), c("#opbanner, #song_info").off("click", ".js_song").on("click", ".js_song", function(t) {
						var n = c(this).data("mid"),
							e = c(this).data("id"),
							s = c(this).data("songtype"),
							o = c(this).data("shareuin"),
							i = c(this).data("disstid"),
							l = {
								mid: n
							};
						return e && (l.id = e), s && (l.songtype = s), o && (l.shareuin = o), i && (l.disstid = i), a.util.gotoSongdetail(
							l), !1
					}).off("click", ".js_singer").on("click", ".js_singer", function(t) {
						var n = c(this).data("singermid"),
							e = c(this).data("stat") || "",
							s = {
								singermid: n
							};
						return e && (s.stat = e), a.util.gotoSinger(s), !1
					}).off("click", ".js_album").on("click", ".js_album", function(t) {
						var n = c(this).data("albummid"),
							e = c(this).data("stat") || "",
							s = {
								albummid: n
							};
						if (e && (s.stat = e), n) return a.util.gotoAlbum(s), !1
					}).on("click", "#btnplay", function(t) {
						S && (s.pgvClickStat("y_new.player.opbanner.play_btn"), S = !0);
						var e = n;
						return "g_first_play" == e ? (t.preventDefault(), t.stopPropagation(), void T.play()) : "g_play" == e ? (t.preventDefault(),
							t.stopPropagation(), o.pausePlayer(), r.haveqrc && r.stopAnimFrame(), void(l.haveLrc && l.stopAnimFrame())
						) : ("g_pause" == e && (t.preventDefault(), t.stopPropagation(), o.startPlayer(), r.haveqrc ? r.startAnimFrame(
							"qrc_ctn") : l.haveLrc && l.startAnimFrame("qrc_ctn")), void("g_wait" == e && o.startPlayer()))
					}).on("click", ".btn_big_prev", function(t) {
						P.prev(t), s.pgvClickStat("y_new.player.opbanner.prev")
					}).on("click", ".btn_big_next", function(t) {
						P.next(t), s.pgvClickStat("y_new.player.opbanner.next")
					}).on("click", "#play_mod", function(t) {
						P.realSetPlayWay()
					}).on("click", "#simp_btn", function(t) {
						s.pgvClickStat("y_new.player.opbanner.clear_mod"), c(this).hasClass("btn_big_only--on") ? (c(this).removeClass(
								"btn_big_only--on"), c(this).attr("title", "打开纯净模式[C]"), c(".js_full_box").show(), c(".js_simp_box").hide(),
							curBoxClassName = "js_full_box") : (c(this).addClass("btn_big_only--on"), c(this).attr("title",
							"关闭纯净模式[C]"), c(".js_full_box").hide(), c(".js_simp_box").show(), curBoxClassName = "js_simp_box")
					})
				},
				setPlayBtnStatus: function() {},
				renderSong: function(t) {
					y("renderSong begin:" + (new Date).getUTCMilliseconds());
					var n = c("#song_box");
					if (!t) return c("#sim_song_info,#song_name,#singer_name,#album_name,#time_show").html(""), c("#song_pic").parents(
							"a.js_album").data("albummid", 0), c("#backImg").css("backgroundImage", ""), c("#song_pic").attr("src", f),
						void c("body").css("backgroundColor", "#292a2b");
					e && (clearTimeout(e), e = null), document.title = "正在播放 " + t.songname + (t.singername ? "-" + t.singername :
						"");
					var s = document.title;
					s = "…" + s;
					var o = 0;
					d.sougou || function t() {
						document.title = s.substring(o, s.length) + s.substring(0, o), ++o > s.length && (o = 0), e = setTimeout(
							function() {
								t()
							}, 500)
					}();
					var i = t.ix;
					if (n.length > 0) {
						c("li", n).length > i && (c(".js_play", c("#song_box .songlist__item--playing")).attr("title", "播放").html(
							'<i class="list_menu__icon_play"></i><span class="icon_txt">播放</span>'), c("div.songlist__item").removeClass(
							"songlist__item--playing"), P._curSongInfo && (c("div.songlist__item", c('li[mid="' + P._curSongInfo.songid +
							'"]')).addClass("songlist__item--playing"), c(".js_play", c('li[mid="' + P._curSongInfo.songid + '"]')).attr(
							"title", "暂停").html('<i class="list_menu__icon_pause"></i><span class="icon_txt">暂停</span>')))
					}

					function l(t) {
						var n = [];
						return c.each(t, function(t, e) {
							n.push('<a href="' + a.util.getSingerUrl({
									mid: e.mid
								}) + '#stat=y_new.player.info_area.singername" onclick="setStatCookie&&setStatCookie();" title="' + e.name +
								'" class="js_singer" data-stat="y_new.player.info_area.singername" data-singermid="' + e.mid +
								'" rel="noopener nofollow" target="_blank">' + e.name + "</a>")
						}), n.join(" / ")
					}
					if (c("#sim_song_info,#song_name,#singer_name,#album_name,#time_show").html(""), t && t.songmid && "" != t.songmid ?
						c("#sim_song_info").html('<a href="' + a.util.getSongUrl(t) +
							'#stat=y_new.player.info_area.songname" onclick="setStatCookie&&setStatCookie();" title="' + t.songname +
							'" class="js_song" data-stat="y_new.player.info_area.songname" data-mid="' + t.songmid + '" data-id="' + t.songid +
							'" data-songtype="' + t.songtype + '" data-disstid="' + (t.disstid ? t.disstid : "") +
							'" rel="noopener nofollow" target="_blank">' + t.songname + "</a> - " + l(t.singer)) : c("#sim_song_info").html(
							'<a title="' + t.songname + '">' + t.songname + '</a> - <a title="' + t.singername + '">' + t.singername +
							"</a>"), t.albummid && "" != t.albummid) {
						c("#song_pic").parents("a.js_album").data("albummid", t.albummid);
						var r = new Image;
						8623 == t.albumid && t.singer.length > 0 && t.singer[0].id > 0 ? r.src = a.util.getSingerPic({
								mid: t.singer[0].mid,
								type: 300
							}) : r.src = a.util.getAlbumPic({
								mid: t.albummid,
								type: 300
							}), c("#song_pic").attr("src", r.src), r.style.width = "0", r.style.height = "0", r.onload = function() {
								c("#backImg").css("backgroundImage", "url(" + r.src + ")"), c("#song_pic").attr("src", r.src)
							}, a.jQueryAjax.jsonp({
								url: "//c.y.qq.com/v8/fcg-bin/fcg_v8_album_info_cp.fcg?ct=24&albummid=" + t.albummid,
								charset: "utf-8",
								jsonpCallback: "albuminfoCallback",
								success: function(t) {
									0 == t.code && t.data.color > 0 ? c("body").css("backgroundColor", "#" + t.data.color.toString(16)) : c(
										"body").css("backgroundColor", "#292a2b")
								},
								error: function(t) {
									c("body").css("backgroundColor", "#292a2b")
								}
							}), 111 == t.songtype || 112 == t.songtype || 113 == t.songtype ? c("#song_name").html("歌曲名：<a href='" + a.util
								.getSongUrl({
									songid: t.songid,
									songtype: t.songtype
								}) + "#stat=y_new.player.info_area.songname' onclick='setStatCookie&&setStatCookie();' title='" + t.songname +
								"' target='_blank'>" + t.songname + "</a>") : t.songmid ? c("#song_name").html("歌曲名：<a href='" + a.util.getSongUrl({
									songmid: t.songmid
								}) + "#stat=y_new.player.info_area.songname' onclick='setStatCookie&&setStatCookie();' title='" + t.songname +
								"' target='_blank'>" + t.songname + "</a>") : c("#song_name").html("歌曲名：" + t.songname), t.singer.length > 0 &&
							t.singer[0].id > 0 && c("#singer_name").html("歌手名：" + l(t.singer)), t.albumid > 0 && t.albumname && c(
								"#album_name").html("专辑名：<a href='" + a.util.getAlbumUrl({
									albummid: t.albummid
								}) + "#stat=y_new.player.info_area.albumname' onclick='setStatCookie&&setStatCookie();' title='" + t.albumname +
								"' target='_blank'>" + t.albumname + "</a>")
					} else {
						c("#song_pic").parents("a.js_album").data("albummid", 0);
						(r = new Image).src = f, r.style.width = r.style.height = "0", r.onload = function() {
							c("#backImg").css("backgroundImage", ""), c("body").css("backgroundColor", "#292a2b"), c("#song_pic").attr(
								"src", f)
						}, t && (111 == t.songtype || 112 == t.songtype || 113 == t.songtype ? (c("#song_name").html("歌曲名：<a href='" +
								a.util.getSongUrl({
									songid: t.songid,
									songtype: t.songtype
								}) + "#stat=y_new.player.info_area.songname' onclick='setStatCookie&&setStatCookie();' title='" + t.songname +
								"' target='_blank'>" + t.songname + "</a>"), t.singer.length > 0 && t.singer[0].id > 0 && c("#singer_name")
							.html("歌手名：" + l(t.singer))) : (c("#song_name").html("歌曲名：" + t.songname), c("#singer_name").html("歌手名：" +
							t.singername), c("#album_name").html("")))
					}! function(t) {
						var n = "jsoncallback" + (Math.random() + "").replace("0.", "");
						if (!(t.songid > 0)) return c(".js_into_comment").hide(), !1;
						c(".js_into_comment").show(), c(".js_into_comment").attr("href", a.util.getSongUrl(t) + "#comment_box"), a.jQueryAjax
							.jsonp({
								url: location.protocol + "//c.y.qq.com/base/fcgi-bin/fcg_global_comment_h5.fcg",
								data: {
									cid: 205360772,
									reqtype: 1,
									biztype: b[t.songtype],
									topid: t.songid,
									cmd: 4,
									needmusiccrit: 0,
									pagenum: 0,
									pagesize: 0,
									lasthotcommentid: "",
									callback: n,
									format: "fs",
									domain: "qq.com"
								},
								type: "post",
								jsonpCallback: n,
								success: function(t) {
									if (!t || "object" != typeof t) return !1;
									var n = t.commenttotal || 0;
									n > 0 ? n < 10 ? (c(".js_into_comment").addClass("btn_comment9"), c(".js_into_comment").html(
										'<span class="btn_comment__numbers"><i class="btn_comment__numb btn_comment__numb_' + parseInt(n) +
										'"></i></span><span class="icon_txt">评论</span>')) : n < 100 ? (c(".js_into_comment").addClass(
										"btn_comment99"), c(".js_into_comment").html(
										'<span class="btn_comment__numbers"><i class="btn_comment__numb btn_comment__numb_' + parseInt(n / 10) +
										'"></i><i class="btn_comment__numb btn_comment__numb_' + parseInt(n % 10) +
										'"></i></span><span class="icon_txt">评论</span>')) : n < 1e3 ? (c(".js_into_comment").addClass(
										"btn_comment99"), c(".js_into_comment").html(
										'<span class="btn_comment__numbers"><i class="btn_comment__numb btn_comment__numb_' + parseInt(n / 100) +
										'"></i><i class="btn_comment__numb btn_comment__numb_' + parseInt(n % 100 / 10) +
										'"></i><i class="btn_comment__numb btn_comment__numb_' + parseInt(n % 10) +
										'"></i></span><span class="icon_txt">评论</span>')) : (c(".js_into_comment").addClass("btn_comment99"), c(
										".js_into_comment").html(
										'<span class="btn_comment__numbers"><i class="btn_comment__numb btn_comment__numb_9"></i><i class="btn_comment__numb btn_comment__numb_9"></i><i class="btn_comment__numb btn_comment__numb_9"></i><i class="btn_comment__numb btn_comment__numb_add"></i></span><span class="icon_txt">评论</span>'
									)) : (c(".js_into_comment").removeClass("btn_comment99").removeClass("btn_comment9"), c(
										".js_into_comment").html('<span class="icon_txt">无评论</span>'))
								},
								error: function() {}
							})
					}(t), y("renderSong end:" + (new Date).getUTCMilliseconds())
				},
				resetLikeIcon: function() {},
				updateSongLike: function(t, n) {},
				songHover: function(t, n) {},
				play: function(t, n, e) {
					if (y("play begin:" + (new Date).getUTCMilliseconds()), n && 1 == n) return S = !1, void c("#btnplay").click();
					var s = 0;
					t && t.length > 0 && (s = t[0].ix), v = 0, a.cookie.set("yq_index", s, null, null, 2400), o.playAnyPos(s), e &&
						e()
				},
				trogglePlay: function() {},
				prev: function(t) {
					t.preventDefault(), t.stopPropagation(), o.lastPlayer()
				},
				next: function(t) {
					t.preventDefault(), t.stopPropagation();
					var n = this;
					u.get(function(t) {
						-1 == v ? n.play() : o.nextPlayer()
					})
				},
				like: function(t, n) {},
				share: function(t, n) {},
				_objSong: null,
				fav: function(n, e, a, s) {
					(n = n || P._curSongInfo) && t.async("js/common/html/songlist.js", function(o) {
						o.getSongInfo([n], !0, function(n, o) {
							t.async("js/common/fav.js", function(t) {
								e ? t.like(o, function() {
									a && a()
								}) : t.unlike(o, function() {
									s && s()
								})
							})
						})
					})
				},
				download: function(n) {
					(n = n || P._curSongInfo) && t.async("js/common/html/songlist.js", function(e) {
						e.getSongInfo([n], !0, function(n, e) {
							t.async("js/common/download.js", function(t) {
								t.show(e)
							})
						})
					})
				},
				add: function(t, n) {},
				delBatch: function(t) {
					var n = [];
					t.sort(function(t, n) {
						return n.ix - t.ix
					}), c.each(t, function(t, e) {
						n.push(e.ix), P.del(e)
					}), u.delBatch(n)
				},
				del: function(t) {
					var n = t.ix;
					n >= 0 && !o.delSong(n) && (P.renderSong(), P._isPlaying = !1, o.stopPlayer())
				},
				insert: function(t, n) {},
				clearList: function() {},
				setPlayWay: function(t) {},
				modIndex: 0,
				realSetPlayWay: function(t) {
					var n = ["顺序播放", "随机播放", "单曲循环", "列表循环"],
						e = [2, 4, 1, 3],
						a = ["btn_big_style_order", "btn_big_style_random", "btn_big_style_single", "btn_big_style_list"];
					if ((t = t || -1) >= 0)
						for (var i in e) t == e[i] && (P.modIndex = parseInt(i));
					else P.modIndex++;
					P.modIndex > 3 && (P.modIndex = 0), c("#play_mod")[0].className = a[P.modIndex], c("#play_mod").html(
						'<span class="icon_txt">' + n[P.modIndex] + "[O]</span>").attr("title", n[P.modIndex] + "[O]"), o.setMode(e[P
						.modIndex]), k.mode = e[P.modIndex], p.set("y_mod", [k.mode, k.volume].join("|")), t < 0 && s.pgvClickStat(
						"y_new.player.opbanner." + a[P.modIndex].replace("btn_big_style", "play_mod"))
				},
				getCurSongInfo: function() {
					return P._curSongInfo
				}
			}
		}();

	function q(t, n, e) {
		if (c.jStorage.get("showPayTips") && (c.jStorage.deleteKey("showPayTips"), t)) {
			var s = [],
				o = [];
			for (i = 0; i < t.list.length; i++) {
				var l = t.list[i];
				s.push(l.songid), o.push(l.type)
			}
			a.player.showPayTips(s, o)
		}
		r = t.list, _ = function(s) {
			t.list = s, c.each(t.list, function(n, a) {
				t.list[n].toptype = e.toptype || 0, t.list[n].parentid = e.parentid || 0, 10050 == e.toptype ? t.list[n].parentid =
					t.list[n].songid : 10002 == e.toptype ? t.list[n].parentid = t.list[n].albumid : 0 == e.toptype && (t.list[n]
						.toptype = 10050, t.list[n].parentid = t.list[n].songid)
			}), t && t.list && t.list.length > 0 && w(t, n, function() {}), a.cookie.set("player_exist", 1)
		}, a.player.getLimitWhiteList(function() {
			var t = [];
			for (i = 0; i < r.length; i++) {
				var n = r[i];
				(n && n.action && n.action.play || !(r.length > 1) && n.tryPlay) && (!window.limitWhite && n && n.pay && (n.pay
					.pay_down || n.pay.paydownload) && (n.pay.payplay || n.pay.pay_play) || (window.limitWhite || m.isLogin() ||
					!n || !n.pay || !n.pay.pay_down && !n.pay.paydownload || n.pay.payplay || n.pay.pay_play) && (0 == n.type &&
					(n.size128 <= 0 || n.interval <= 0) || 0 != n.type && 111 != n.type && 112 != n.type && 113 != n.type && !n.songurl ||
					t.push(n)))
			}
			if (0 == r.length) return _ && _([]), [];
			if (1 == r.length) {
				if (!(r[0] && r[0].action && r[0].action.play)) {
					if (m.getUin() < 1e3 && r[0].pay && r[0].pay.payplay) return m.openLogin(), _ && _([]), [];
					if (!t.length) return _ && _([]), []
				}
			} else if (!t.length) return _ && _([]), [];
			return _ && _(t), t
		});
		var r, _
	}
	var T = {
		init: function() {
			o.init({
					fromtag: 30,
					statFromtag: 7,
					errorTips: function(t, n) {
						a.popup.show(t + n, 3e3, 1)
					}
				}), P.init(), c.jStorage.reInit(), a.cookie.set("yplayer_open", 1),
				function() {
					var n = null;

					function e(e, s, o) {
						switch (e) {
							case "r":
								var i = window.open("//y.qq.com/portal/player_radio.html#id=" + s, "_self");
								i && (i.opener = null);
								break;
							case "t":
								t.async("js/common/html/toplistdata.js", function(t) {
									t.init({
										topId: parseInt(s),
										topType: 0,
										reportID: 0,
										play: 0
									}, function(t) {
										o && a.cookie.set("yq_index", 0, null, null, 2400), q({
											list: t,
											play: o
										}, !0, {
											toptype: 10005,
											parentid: parseInt(s)
										})
									})
								});
								break;
							case "a":
								t.async("js/common/html/albumdata.js", function(t) {
									t.init({
										mid: s,
										reportID: 0,
										play: 0
									}, function(t) {
										o && a.cookie.set("yq_index", 0, null, null, 2400), q({
											list: t,
											play: o
										}, !0, {
											toptype: 10002
										})
									})
								});
								break;
							case "si":
								break;
							case "p":
								t.async("js/common/html/playlistdata.js", function(t) {
									t.init(s, function(t) {
										0 != t.length && (o && a.cookie.set("yq_index", 0, null, null, 2400), q({
											list: t,
											play: o
										}, !0, {
											toptype: 10014,
											parentid: s
										}))
									}, null, {
										song_begin: 0,
										song_num: 10
									})
								});
								break;
							case "s":
								t.async("js/common/html/songlist.js", function(e) {
									e.getSongInfo(s, !0, function(e, s) {
										var i = a.player.formatMusics(s);
										t.async("js/common/fav.js", function(t) {
											t.combineData(i, function(t) {
												0 != t.length && (o && a.cookie.set("yq_index", 0, null, null, 2400), q({
													list: t,
													play: o
												}, !0, n || {
													toptype: 10050
												}))
											})
										})
									})
								})
						}
					}
					setInterval(function() {
						if (1 == parseInt(a.cookie.get("yq_playschange"))) {
							a.cookie.set("yq_playschange", 0);
							var t = a.cookie.get("yq_playdata").split("_");
							if (a.cookie.set("yq_playdata", ""), t.length >= 2) {
								var s = t[0],
									o = t[1],
									i = 1;
								if (t.length > 2 && (i = parseInt(t[2])), ("r" == s || "t" == s || "p" == s) && o > 0 && e(s, o, i), "a" ==
									s && e(s, o, i), "s" == s) {
									var l = c.jStorage.get("addplaylist_new") ? c.jStorage.get("addplaylist_new").list : null,
										r = 3;
									if (l) n = c.jStorage.get("addplaylist_new").report || null, e(s, l, i), c.jStorage.deleteKey(
										"addplaylist_new");
									else var _ = setInterval(function() {
										r--, (l = c.jStorage.get("addplaylist_new") ? c.jStorage.get("addplaylist_new").list : null) && (n =
											c.jStorage.get("addplaylist_new").report || null, e(s, l, i), c.jStorage.deleteKey(
												"addplaylist_new"), _ && clearInterval(_)), 0 == r && _ && clearInterval(_)
									}, 1e3)
								}
							} else t.length > 0 && "s" == t[0] && q(c.jStorage.get("addplaylist"), !0, {
								toptype: 10050
							})
						}
						a.cookie.set("player_exist", 1)
					}, 100)
				}();
			var n = c.jStorage.get("addplaylist");
			e = function() {
				n ? q(n, !0, n ? n.report : null) : w(n, !1, function() {}), c.jStorage.deleteKey("addplaylist")
			}, u.get(function(t) {
				e && e()
			});
			var e;
			c.jStorage.subscribe("focusplayer", function(t, n) {
				n.status && (alert("窗口已打开！"), window.focus()), a.cookie.set("player_exist", 1)
			}), d.webkit && c(".sb_overview").css({
				height: c(".player__bd").height() - 56
			}), c(".qrc_ctn").on("mousedown", function(t) {
				t.preventDefault(), t.stopPropagation(), window.getlyricflag = !0, l.haveLrc && l.stopAnimFrame("qrc_ctn");
				var n = t.pageY,
					e = [];
				c.each(c(".qrc_ctn"), function(t, n) {
					if (a.util.supportCss3("transform") || a.util.supportCss3("-webkit-transform")) {
						e[t] = 0;
						var s = n.style,
							o = (s.transform || s.webkitTransform || "").split("(");
						o && o.length > 1 && (e[t] = -1 * parseInt(o[1]))
					} else e[t] = c(n).parent(".js_lyric_box").scrollTop()
				}), c(document).off("mousemove").on("mousemove", function(t) {
					l.haveLrc && l.stopAnimFrame(), (l.haveLrc || l.txtLrc) && c.each(c(".qrc_ctn"), function(s, o) {
						if ("none" != c(o).parents(".js_box").css("display")) {
							var i = e[s] + (n - t.pageY);
							i < 0 && (i = 0), a.util.supportCss3("-webkit-transition") && a.util.supportCss3("-webkit-transform") ?
								(o.style.webkitTransition = "-webkit-transform 0.1s ease-out", o.style.webkitTransform =
									"translateY(" + -1 * i + "px)") : a.util.supportCss3("transition") && a.util.supportCss3("transform") ?
								(o.style.transition = "transform 0.1s ease-out", o.style.transform = "translateY(" + -1 * i +
									"px,0px)") : c(o).parent(".js_lyric_box").scrollTop(i)
						}
					})
				});
				var s = 0;
				c(document).on("mouseup", function(t) {
					c(document).off("mousemove"), s++, n = 0, setTimeout(function() {
						n || (l.haveLrc && window.getlyricflag && 1 == s && (l.startAnimFrame("qrc_ctn"), window.getlyricflag = !
							1), s--)
					}, 3e3)
				})
			}).on("mousewheel", function() {
				return !1
			}), c(".js_btn_fav", "#opbanner").on("click", function(t) {
				var n = c(this);
				P.fav(null, c(this).hasClass("btn_big_like--like") ? 0 : 1, function() {
					n.addClass("btn_big_like--like")
				}, function() {
					n.removeClass("btn_big_like--like")
				}), s.pgvClickStat("y_new.player.opbanner.love")
			}), c(".js_btn_down", "#opbanner").on("click", function(t) {
				P.download(null), s.pgvClickStat("y_new.player.opbanner.download")
			}), c(document).on("like", function(t, n) {
				var e = [],
					a = n.data,
					s = n.flag;
				c.each(a, function(t, n) {
					n && e.push(n.songid), P._curSongInfo && n && n.songid == P._curSongInfo.songid && (s ? c(".js_btn_fav",
						"#opbanner").addClass("btn_big_like--like") : c(".js_btn_fav", "#opbanner").removeClass(
						"btn_big_like--like"), s ? c(".js_btn_fav").attr("title", "取消喜欢[V]") : c(".js_btn_fav").attr("title",
						"喜欢[V]"))
				}), o.setSongsFavStatus(e, s ? "mod_songname_menu__like--liked" : "")
			}).on("delete", function(t, n) {
				var e = n.data;
				P.delBatch(e), P._curSongInfo && (c(".js_play", c("#song_box .songlist__item--playing")).attr("title", "播放").html(
						'<i class="list_menu__icon_play"></i><span class="icon_txt">播放</span>'), c("div.songlist__item").removeClass(
						"songlist__item--playing"), c("div.songlist__item", c('li[mid="' + P._curSongInfo.songid + '"]')).addClass(
						"songlist__item--playing"), c(".js_play", c('li[mid="' + P._curSongInfo.songid + '"]')).attr("title", "暂停")
					.html('<i class="list_menu__icon_pause"></i><span class="icon_txt">暂停</span>')), g && g.resize()
			}).on("click", ".js_trans_btn", function() {
				var t = c(".btn_big_only--on").length > 0;
				c(this).hasClass("btn_lang--select") ? (c(".js_trans_line").hide(), c(".js_trans_btn").removeClass(
					"btn_lang--select"), k.trans = 0, s.pgvClickStat("y_new.player.translyric.open" + (t ? ".clear" : ""))) : (
					c(".js_trans_btn").addClass("btn_lang--select"), c(".js_trans_line").show(), k.trans = 1, s.pgvClickStat(
						"y_new.player.translyric.close" + (t ? ".clear" : ""))), p.set("y_mod", [k.mode, k.volume, k.trans].join(
					"|"))
			}).on("click", ".js_opts_login,.js_opts_unlogin", function() {
				var n = function(t) {
					var n = "";
					Array.prototype.join;
					return n +=
						'\t<div class="form__part">\r\n            <div class="form__label">历史播放列表</div>\r\n            <span class="mod_form_check">\r\n                <label class="form_check__label"><span class="form_check__checkbox ',
						t.deleteList || (n += "sprite form_check__checkbox--check"), n +=
						'"><input type="checkbox" name="privacy" class="form_check__check js_player_delete"></span>保留（勾选后，每次新打开播放器，将保留上次关闭时的播放列表）</label>\r\n            </span>\r\n        </div>\r\n        <div class="form__part">\r\n            <div class="form__label">播放设置</div>\r\n            <span class="mod_form_radio">\r\n                <label class="form_radio__label"><span class="form_radio__radiobox sprite ',
						0 == t.mod && (n += "form_radio__radiobox--check"), n +=
						'" data-mod="0"><input type="radio" name="privacy" class="form_radio__radio js_player_mods"></span>立即播放<span class="c_tx_thin">(默认添加到播放队列最顶部)</span></label>\r\n            </span>\r\n            <span class="mod_form_radio">\r\n                <label class="form_radio__label"><span class="form_radio__radiobox sprite ',
						1 == t.mod && (n += "form_radio__radiobox--check"), n +=
						'" data-mod="1"><input type="radio" name="privacy" class="form_radio__radio js_player_mods"></span>添加到播放队列末尾</label>\r\n            </span>\r\n            <span class="mod_form_radio">\r\n                <label class="form_radio__label"><span class="form_radio__radiobox sprite ',
						2 == t.mod && (n += "form_radio__radiobox--check"), n +=
						'" data-mod="2"><input type="radio" name="privacy" class="form_radio__radio js_player_mods"></span>下一首播放</label>\r\n            </span>\r\n        </div>\r\n\r\n        <div class="c_tx_thin">设置仅对当前电脑有效，清除Cookie后将恢复为默认设置。</div>'
				}(a.player.getPlayerOptions());
				t.async("js/common/dialog.js", function(t) {
					t.show({
						title: "播放器设置",
						dialogclass: "popup_player",
						mode: "common",
						width: 600,
						content: n,
						button_info1: {
							fn: function(n) {
								t.hide()
							},
							title: "取消"
						},
						button_info2: {
							highlight: "1",
							fn: function(n) {
								var e = {
									deleteList: !c(".js_player_delete").parents("span.form_check__checkbox").hasClass(
										"form_check__checkbox--check"),
									mod: parseInt(c(".js_player_mods").parents("span.form_radio__radiobox--check").data("mod"))
								};
								a.player.setPlayerOptions(e), t.hide()
							},
							title: "确定"
						}
					})
				}), s.pgvClickStat("y_new.player.options")
			}).on("click", ".js_player_delete", function() {
				var t = c(this).parents("span.form_check__checkbox");
				t.hasClass("form_check__checkbox--check") ? (t.removeClass("form_check__checkbox--check"), t.removeClass(
					"sprite")) : (t.addClass("form_check__checkbox--check"), t.addClass("sprite")), t.hasClass(
					"form_check__checkbox--check") ? s.pgvClickStat("y_new.player.options.notdelete") : s.pgvClickStat(
					"y_new.player.options.delete")
			}).on("click", ".js_player_mods", function() {
				var t = c(this).parents("span.form_radio__radiobox");
				c(".js_player_mods").parents("span.form_radio__radiobox").removeClass("form_radio__radiobox--check"), t.addClass(
					"form_radio__radiobox--check"), s.pgvClickStat("y_new.player.options.playmod" + c(".js_player_mods").parents(
					"span.form_radio__radiobox").data("mod"))
			}), c(window).resize(function() {
				d.webkit && c(".sb_overview").css({
					height: c(".player__bd").height() - 56
				})
			}), c(document).on("keydown", "", function(t) {
				if (c("#new_playlist_fav").length > 0) return !1;
				switch (t.keyCode) {
					case 32:
					case 19:
						S = !1, c("#btnplay").click();
						break;
					case 37:
						t.altKey ? c(".btn_big_prev").click() : t.ctrlKey && C.update(k.pos - 5);
						break;
					case 39:
						t.altKey ? c(".btn_big_next").click() : t.ctrlKey && C.update(k.pos + 5);
						break;
					case 38:
						t.altKey && j.incVol();
						break;
					case 40:
						t.altKey && j.decVol();
						break;
					case 67:
						c("#simp_btn").click();
						break;
					case 77:
						c("#spanmute").click();
						break;
					case 79:
						c("#play_mod").click();
						break;
					case 86:
						c(".js_btn_fav").click();
						break;
					case 68:
						c(".js_btn_down").click()
				}
			});
			var i = "";

			function r(t) {
				c(".songlist__drag").css({
					left: t.pageX - 180 + "px",
					top: t.pageY - 180 + "px"
				})
			}
			var _ = null;
			c(document).on("mousedown", ".songlist__list li", function(t) {
				var n = a.util.getTarget(t),
					e = this;
				if (c(n).parents("a").length > 0 || c(n).parents(".songlist__edit").length > 0) return !1;
				_ = setTimeout(function() {
					c(".songlist__end,.songlist__drag").remove(), c(e).before('<li class="songlist__end"></li>'), c(
							"#song_box").prepend('<li class="songlist__drag"></li>'), r(t), c(e).addClass("songlist__item--drag"), i =
						c("li.songlist__item--drag")[0].outerHTML.replace("songlist__item--drag", ""), s.pgvClickStat(
							"y_new.player.drag")
				}, 300);
				c(document).off("mousemove").on("mousemove", ".songlist__list li", function(t) {
					a.util.getTarget(t);
					if (c(".songlist__item--drag").length > 0) {
						var n = c(this).attr("mid"),
							e = c(this).attr("ix");
						if ("" != n) {
							var s = parseInt(parseInt(c(".sb_scrollable").css("height")) / 50) - 2;
							0 == c(".songlist__drag").length ? (c(".songlist__end,.songlist__drag").remove(), c(
								'.songlist__list li[mid="' + n + '"]').before('<li class="songlist__end"></li>'), c("#song_box").prepend(
								'<li class="songlist__drag"></li>')) : (c(".songlist__end").remove(), c('.songlist__list li[mid="' + n +
								'"]').before('<li class="songlist__end"></li>')), r(t), !d.webkit && g && g.scrollbar("scrollToY", 50 *
								(e - s)), d.webkit && (c(".sb_overview")[0].scrollTop = 50 * (e - s))
						}
					}
					return !1
				})
			}).on("mouseup", ".songlist__list li", function(t) {
				_ && (clearTimeout(_), _ = null);
				var n = a.util.getTarget(t);
				return !(c(n).parents("a").length > 0 || c(n).parents(".songlist__edit").length > 0) && (c(
					".songlist__end,.songlist__drag").remove(), !c(this).hasClass("songlist__item--drag") && i ? (c(
					"li.songlist__item--drag").remove(), c(this).before(i), i = "", u.get(function(t) {
					var n = {},
						e = [];
					c.each(t, function(t, e) {
						n[e.songid] = e
					});
					var s = c(".songlist__list li"),
						i = 0;
					c.each(s, function(t, a) {
						var s = c(a).attr("mid");
						if (c(a).attr("ix", t), c(".songlist__number", c(a)).html(t + 1), c(".songlist__item--playing", c(a))
							.length > 0 && (i = t), s in n) {
							var o = n[s];
							o.ix = t, e.push(o)
						}
					}), e.length > 0 && (u.clear(), u.add(e), o.setPlayerList(!1, e, k.mode), a.cookie.set("yq_index", i,
						null, null, 2400), o.setPostion(i))
				})) : c("li.songlist__item--drag").removeClass("songlist__item--drag"), c(document).off("mousemove"), !1)
			}).on("mouseup", "", function() {
				c(".songlist__end,.songlist__drag").remove(), setTimeout(function() {
					c("li.songlist__item--drag").removeClass("songlist__item--drag")
				}, 300), c(document).off("mousemove")
			})
		},
		play: P.play
	};
	return T
});
