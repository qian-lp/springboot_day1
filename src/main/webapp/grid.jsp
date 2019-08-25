<%@page pageEncoding="utf-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <!--引入样式文件-->
    <link rel="stylesheet" href="static/bs/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="static/jqgrid/css/trirand/ui.jqgrid-bootstrap.css" type="text/css">
    <!--引入js功能文件-->
    <script src="static/bs/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="static/bs/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="static/jqgrid/js/trirand/i18n/grid.locale-cn.js" type="text/javascript"></script>
    <script src="static/jqgrid/js/trirand/jquery.jqGrid.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            //初始化表格
            $("#tt").jqGrid({
                styleUI: 'Bootstrap',
                url: '/springboot/product/showAll',
                datatype: 'json',
                colNames: ['商品编号', '商品名称', '图片', '单价', '操作'],
                //开启编辑模式
                cellEdit: true,
                caption: '商品信息展示列表',
                //表单编辑时提交的路径
                editurl: '/springboot/product/query',
                colModel: [
                    {name: 'id', align: 'center'},
                    {name: 'productname', align: 'center'},
                    {
                        name: 'path', align: 'center',
                        formatter: function (value, options, row) {
                            return '<img src="' + row.path + '">'
                        }
                    },
                    {name: 'price', align: 'center'},
                    {
                        name: 'operation', align: 'center',
                        formatter: function (value, options, row) {
                            return '<input class="btn btn-primary" type="button" value="加入购物车" onclick="addcart(' + row.id + ')">'
                        }
                    },
                ],
                autowidth: true,
                pager: '#pager',
                rowList: [5, 10],
                rowNum: 3,
                page: 1,
                multiselect: true,
                rownumbers: true,

            }).navGrid('#pager', {'add': true, 'edit': true, 'del': true, 'search': true, 'refresh': true});
        })

        function addcart(id) {


        }
    </script>
</head>
<body>
<table id="tt"></table>
<div id="pager"></div>
</body>
</html>