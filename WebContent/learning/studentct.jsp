<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/houtai/includes.jsp"%>
<title>学习中心</title>
<link href="../css/studentct.css" type="text/css" rel="stylesheet" />
<script src="../js/studentct.js" type="text/javascript" charset="UTF-8"></script>
<div class="u-1">
	<div class="u-l">
		<h3>学习中心</h3>
	</div>
	<div class="u-r">
		<h5>
			当前位置 <span class="black">> 学习中心</span>
		</h5>
	</div>
</div>
<div class="u-2"></div>
	<div>
		<hr width="1px"  />
	</div>
	<div>
		<div class="lf">
			<div class="caidan">
				<div id="KB1Parent" class="parent">
					<div></div>
					<div class="szbg">
						<a href="#" class="noxian">&nbsp;》》》</a>
					</div>
				</div>
				<div id="KB1Child" class="child">
				</div>
				<div class="szkg"></div>
				<div id="KB2Parent" class="parent">
					<div class="szbg">
						<a href="studentdata" class="noxian">&nbsp; > 查看资料</a>
					</div>
				</div>
				<div id="KB2Child" class="child">
				</div>
				<div class="szkg"></div>
				<div id="KB3Parent" class="parent">
					<div class="szbg">
						<a href="classsee" class="noxian">&nbsp; > 查看自选课程</a>
					</div>
				</div>
				<div id="KB3Child" class="child">
				</div>
			</div>
		</div>
		<div class="fengge">
			<div class="dian"></div>
		</div>
		<div class="rt">
			<div>我的信息</div>
			<div>
				<hr />
			</div>
			<div>
				<c:if test="${!empty param.page1}">
					<jsp:include page="${param.page1}.jsp"></jsp:include>
				</c:if>
			</div>
		</div>
	</div>