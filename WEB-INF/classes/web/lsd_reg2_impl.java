package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class lsd_reg2_impl extends GXDataArea
{
   public void initenv( )
   {
      if ( GxWebError != 0 )
      {
         return  ;
      }
   }

   public void inittrn( )
   {
      initialize_properties( ) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      gxfirstwebparm_bkp = gxfirstwebparm ;
      gxfirstwebparm = httpContext.DecryptAjaxCall( gxfirstwebparm) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      if ( GXutil.strcmp(gxfirstwebparm, "dyncall") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         dyncall( httpContext.GetNextPar( )) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel1"+"_"+"CLICOD") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx1asaclicod4W227( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_14") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1649LSDSec = (int)(GXutil.lval( httpContext.GetPar( "LSDSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_14( A3CliCod, A1EmpCod, A1649LSDSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
      {
         httpContext.setAjaxEventMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
      {
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else
      {
         if ( ! httpContext.IsValidAjaxCall( false) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = gxfirstwebparm_bkp ;
      }
      if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
      {
         Gx_mode = gxfirstwebparm ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
            AV8EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8EmpCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
            AV9LSDSec = (int)(GXutil.lval( httpContext.GetPar( "LSDSec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9LSDSec), 8, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSDSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9LSDSec), "ZZZZZZZ9")));
            AV10LSD2Sec = (int)(GXutil.lval( httpContext.GetPar( "LSD2Sec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10LSD2Sec), 8, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSD2SEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10LSD2Sec), "ZZZZZZZ9")));
         }
      }
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
      if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
      {
         gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_web_controls( ) ;
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "LSD_reg2", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtLSD2cuilEmpleado_3_11_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public lsd_reg2_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public lsd_reg2_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( lsd_reg2_impl.class ));
   }

   public lsd_reg2_impl( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
   }

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.newmasterpage");
         MasterPageObj.setDataArea(this,false);
         validateSpaRequest();
         MasterPageObj.webExecute();
         if ( ( GxWebError == 0 ) && httpContext.isAjaxRequest( ) )
         {
            httpContext.enableOutput();
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
            }
            if ( ! httpContext.willRedirect( ) )
            {
               addString( httpContext.getJSONResponse( )) ;
            }
            else
            {
               if ( httpContext.isAjaxRequest( ) )
               {
                  httpContext.disableOutput();
               }
               renderHtmlHeaders( ) ;
               httpContext.redirect( httpContext.wjLoc );
               httpContext.dispatchAjaxCommands();
            }
         }
      }
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
   }

   public void fix_multi_value_controls( )
   {
   }

   public void draw( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         disable_std_buttons( ) ;
         enableDisable( ) ;
         set_caption( ) ;
         /* Form start */
         drawControls( ) ;
         fix_multi_value_controls( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Padding0", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "TableContentPadding", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucDvpanel_tableattributes.setProperty("Width", Dvpanel_tableattributes_Width);
      ucDvpanel_tableattributes.setProperty("AutoWidth", Dvpanel_tableattributes_Autowidth);
      ucDvpanel_tableattributes.setProperty("AutoHeight", Dvpanel_tableattributes_Autoheight);
      ucDvpanel_tableattributes.setProperty("Cls", Dvpanel_tableattributes_Cls);
      ucDvpanel_tableattributes.setProperty("Title", Dvpanel_tableattributes_Title);
      ucDvpanel_tableattributes.setProperty("Collapsible", Dvpanel_tableattributes_Collapsible);
      ucDvpanel_tableattributes.setProperty("Collapsed", Dvpanel_tableattributes_Collapsed);
      ucDvpanel_tableattributes.setProperty("ShowCollapseIcon", Dvpanel_tableattributes_Showcollapseicon);
      ucDvpanel_tableattributes.setProperty("IconPosition", Dvpanel_tableattributes_Iconposition);
      ucDvpanel_tableattributes.setProperty("AutoScroll", Dvpanel_tableattributes_Autoscroll);
      ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, "DVPANEL_TABLEATTRIBUTESContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD2cuilEmpleado_3_11_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD2cuilEmpleado_3_11_Internalname, httpContext.getMessage( "CUIL", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD2cuilEmpleado_3_11_Internalname, GXutil.ltrim( localUtil.ntoc( A1658LSD2cuilEmpleado_3_11, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD2cuilEmpleado_3_11_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1658LSD2cuilEmpleado_3_11), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1658LSD2cuilEmpleado_3_11), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD2cuilEmpleado_3_11_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD2cuilEmpleado_3_11_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg2.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD2legajoEmpleado_14_10_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD2legajoEmpleado_14_10_Internalname, httpContext.getMessage( "Legajo Id.", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD2legajoEmpleado_14_10_Internalname, GXutil.rtrim( A1659LSD2legajoEmpleado_14_10), GXutil.rtrim( localUtil.format( A1659LSD2legajoEmpleado_14_10, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD2legajoEmpleado_14_10_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD2legajoEmpleado_14_10_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg2.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD2dependenciaRevista_24_50_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD2dependenciaRevista_24_50_Internalname, httpContext.getMessage( "Dependencia de revista", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD2dependenciaRevista_24_50_Internalname, GXutil.rtrim( A1660LSD2dependenciaRevista_24_50), GXutil.rtrim( localUtil.format( A1660LSD2dependenciaRevista_24_50, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD2dependenciaRevista_24_50_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD2dependenciaRevista_24_50_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg2.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD2cbuEmpleado_74_22_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD2cbuEmpleado_74_22_Internalname, httpContext.getMessage( "CBU", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD2cbuEmpleado_74_22_Internalname, GXutil.rtrim( A1661LSD2cbuEmpleado_74_22), GXutil.rtrim( localUtil.format( A1661LSD2cbuEmpleado_74_22, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD2cbuEmpleado_74_22_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD2cbuEmpleado_74_22_Enabled, 0, "text", "", 22, "chr", 1, "row", 22, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg2.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD2diasLiquidados_96_3_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD2diasLiquidados_96_3_Internalname, httpContext.getMessage( "Días liquidados", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD2diasLiquidados_96_3_Internalname, GXutil.ltrim( localUtil.ntoc( A1662LSD2diasLiquidados_96_3, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD2diasLiquidados_96_3_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1662LSD2diasLiquidados_96_3), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1662LSD2diasLiquidados_96_3), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,42);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD2diasLiquidados_96_3_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD2diasLiquidados_96_3_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg2.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD2fechaPago_99_8_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD2fechaPago_99_8_Internalname, httpContext.getMessage( "Fecha de pago", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtLSD2fechaPago_99_8_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD2fechaPago_99_8_Internalname, localUtil.format(A1663LSD2fechaPago_99_8, "99/99/99"), localUtil.format( A1663LSD2fechaPago_99_8, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD2fechaPago_99_8_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtLSD2fechaPago_99_8_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg2.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtLSD2fechaPago_99_8_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtLSD2fechaPago_99_8_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LSD_reg2.htm");
      httpContext.writeTextNL( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD2fechaRubrica_107_8_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD2fechaRubrica_107_8_Internalname, httpContext.getMessage( "Fecha de rúbrica", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtLSD2fechaRubrica_107_8_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD2fechaRubrica_107_8_Internalname, localUtil.format(A1664LSD2fechaRubrica_107_8, "99/99/99"), localUtil.format( A1664LSD2fechaRubrica_107_8, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,52);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD2fechaRubrica_107_8_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtLSD2fechaRubrica_107_8_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg2.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtLSD2fechaRubrica_107_8_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtLSD2fechaRubrica_107_8_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LSD_reg2.htm");
      httpContext.writeTextNL( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD2formaPago_115_1_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD2formaPago_115_1_Internalname, httpContext.getMessage( "Forma de pago", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD2formaPago_115_1_Internalname, GXutil.rtrim( A1665LSD2formaPago_115_1), GXutil.rtrim( localUtil.format( A1665LSD2formaPago_115_1, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,57);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD2formaPago_115_1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD2formaPago_115_1_Enabled, 0, "text", "", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg2.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      ClassString = "ErrorViewer" ;
      StyleString = "" ;
      web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LSD_reg2.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LSD_reg2.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LSD_reg2.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      /* End of table */
      httpContext.writeText( "</table>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,73);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg2.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,74);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, edtEmpCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_LSD_reg2.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 75,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSDSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1649LSDSec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1649LSDSec), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,75);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSDSec_Jsonclick, 0, "Attribute", "", "", "", "", edtLSDSec_Visible, edtLSDSec_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg2.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 76,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD2Sec_Internalname, GXutil.ltrim( localUtil.ntoc( A1657LSD2Sec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1657LSD2Sec), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,76);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD2Sec_Jsonclick, 0, "Attribute", "", "", "", "", edtLSD2Sec_Visible, edtLSD2Sec_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg2.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void userMain( )
   {
      standaloneStartup( ) ;
   }

   public void userMainFullajax( )
   {
      initenv( ) ;
      inittrn( ) ;
      userMain( ) ;
      draw( ) ;
      sendCloseFormHiddens( ) ;
   }

   public void standaloneStartup( )
   {
      standaloneStartupServer( ) ;
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e114W2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1649LSDSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z1649LSDSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1657LSD2Sec = (int)(localUtil.ctol( httpContext.cgiGet( "Z1657LSD2Sec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1658LSD2cuilEmpleado_3_11 = localUtil.ctol( httpContext.cgiGet( "Z1658LSD2cuilEmpleado_3_11"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z1659LSD2legajoEmpleado_14_10 = httpContext.cgiGet( "Z1659LSD2legajoEmpleado_14_10") ;
            Z1660LSD2dependenciaRevista_24_50 = httpContext.cgiGet( "Z1660LSD2dependenciaRevista_24_50") ;
            Z1661LSD2cbuEmpleado_74_22 = httpContext.cgiGet( "Z1661LSD2cbuEmpleado_74_22") ;
            Z1662LSD2diasLiquidados_96_3 = (short)(localUtil.ctol( httpContext.cgiGet( "Z1662LSD2diasLiquidados_96_3"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1663LSD2fechaPago_99_8 = localUtil.ctod( httpContext.cgiGet( "Z1663LSD2fechaPago_99_8"), 0) ;
            Z1664LSD2fechaRubrica_107_8 = localUtil.ctod( httpContext.cgiGet( "Z1664LSD2fechaRubrica_107_8"), 0) ;
            Z1665LSD2formaPago_115_1 = httpContext.cgiGet( "Z1665LSD2formaPago_115_1") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9LSDSec = (int)(localUtil.ctol( httpContext.cgiGet( "vLSDSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV10LSD2Sec = (int)(localUtil.ctol( httpContext.cgiGet( "vLSD2SEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV16Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Dvpanel_tableattributes_Objectcall = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Objectcall") ;
            Dvpanel_tableattributes_Class = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Class") ;
            Dvpanel_tableattributes_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Enabled")) ;
            Dvpanel_tableattributes_Width = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Width") ;
            Dvpanel_tableattributes_Height = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Height") ;
            Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
            Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
            Dvpanel_tableattributes_Cls = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Cls") ;
            Dvpanel_tableattributes_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showheader")) ;
            Dvpanel_tableattributes_Title = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Title") ;
            Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
            Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
            Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
            Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Iconposition") ;
            Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
            Dvpanel_tableattributes_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Visible")) ;
            Dvpanel_tableattributes_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLSD2cuilEmpleado_3_11_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLSD2cuilEmpleado_3_11_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD2CUILEMPLEADO_3_11");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD2cuilEmpleado_3_11_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1658LSD2cuilEmpleado_3_11 = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A1658LSD2cuilEmpleado_3_11", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1658LSD2cuilEmpleado_3_11), 11, 0));
            }
            else
            {
               A1658LSD2cuilEmpleado_3_11 = localUtil.ctol( httpContext.cgiGet( edtLSD2cuilEmpleado_3_11_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1658LSD2cuilEmpleado_3_11", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1658LSD2cuilEmpleado_3_11), 11, 0));
            }
            A1659LSD2legajoEmpleado_14_10 = httpContext.cgiGet( edtLSD2legajoEmpleado_14_10_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1659LSD2legajoEmpleado_14_10", A1659LSD2legajoEmpleado_14_10);
            A1660LSD2dependenciaRevista_24_50 = httpContext.cgiGet( edtLSD2dependenciaRevista_24_50_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1660LSD2dependenciaRevista_24_50", A1660LSD2dependenciaRevista_24_50);
            A1661LSD2cbuEmpleado_74_22 = httpContext.cgiGet( edtLSD2cbuEmpleado_74_22_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1661LSD2cbuEmpleado_74_22", A1661LSD2cbuEmpleado_74_22);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLSD2diasLiquidados_96_3_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLSD2diasLiquidados_96_3_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD2DIASLIQUIDADOS_96_3");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD2diasLiquidados_96_3_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1662LSD2diasLiquidados_96_3 = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1662LSD2diasLiquidados_96_3", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1662LSD2diasLiquidados_96_3), 3, 0));
            }
            else
            {
               A1662LSD2diasLiquidados_96_3 = (short)(localUtil.ctol( httpContext.cgiGet( edtLSD2diasLiquidados_96_3_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1662LSD2diasLiquidados_96_3", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1662LSD2diasLiquidados_96_3), 3, 0));
            }
            if ( localUtil.vcdate( httpContext.cgiGet( edtLSD2fechaPago_99_8_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "LSD2FECHAPAGO_99_8");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD2fechaPago_99_8_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1663LSD2fechaPago_99_8 = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A1663LSD2fechaPago_99_8", localUtil.format(A1663LSD2fechaPago_99_8, "99/99/99"));
            }
            else
            {
               A1663LSD2fechaPago_99_8 = localUtil.ctod( httpContext.cgiGet( edtLSD2fechaPago_99_8_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1663LSD2fechaPago_99_8", localUtil.format(A1663LSD2fechaPago_99_8, "99/99/99"));
            }
            if ( localUtil.vcdate( httpContext.cgiGet( edtLSD2fechaRubrica_107_8_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "LSD2FECHARUBRICA_107_8");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD2fechaRubrica_107_8_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1664LSD2fechaRubrica_107_8 = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A1664LSD2fechaRubrica_107_8", localUtil.format(A1664LSD2fechaRubrica_107_8, "99/99/99"));
            }
            else
            {
               A1664LSD2fechaRubrica_107_8 = localUtil.ctod( httpContext.cgiGet( edtLSD2fechaRubrica_107_8_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1664LSD2fechaRubrica_107_8", localUtil.format(A1664LSD2fechaRubrica_107_8, "99/99/99"));
            }
            A1665LSD2formaPago_115_1 = httpContext.cgiGet( edtLSD2formaPago_115_1_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1665LSD2formaPago_115_1", A1665LSD2formaPago_115_1);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A3CliCod = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            else
            {
               A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPCOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1EmpCod = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            }
            else
            {
               A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLSDSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLSDSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSDSEC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSDSec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1649LSDSec = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
            }
            else
            {
               A1649LSDSec = (int)(localUtil.ctol( httpContext.cgiGet( edtLSDSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLSD2Sec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLSD2Sec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD2SEC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD2Sec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1657LSD2Sec = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
            }
            else
            {
               A1657LSD2Sec = (int)(localUtil.ctol( httpContext.cgiGet( edtLSD2Sec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"LSD_reg2");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1649LSDSec != Z1649LSDSec ) || ( A1657LSD2Sec != Z1657LSD2Sec ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("lsd_reg2:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A1649LSDSec = (int)(GXutil.lval( httpContext.GetPar( "LSDSec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
               A1657LSD2Sec = (int)(GXutil.lval( httpContext.GetPar( "LSD2Sec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode227 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode227 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound227 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_4W0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "CLICOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCliCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
   }

   public void process( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read Transaction buttons. */
         sEvt = httpContext.cgiGet( "_EventName") ;
         EvtGridId = httpContext.cgiGet( "_EventGridId") ;
         EvtRowId = httpContext.cgiGet( "_EventRowId") ;
         if ( GXutil.len( sEvt) > 0 )
         {
            sEvtType = GXutil.left( sEvt, 1) ;
            sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
            if ( GXutil.strcmp(sEvtType, "M") != 0 )
            {
               if ( GXutil.strcmp(sEvtType, "E") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, 1) ;
                  if ( GXutil.strcmp(sEvtType, ".") == 0 )
                  {
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                     if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e114W2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e124W2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! isDsp( ) )
                        {
                           btn_enter( ) ;
                        }
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                  }
                  else
                  {
                  }
               }
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e124W2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll4W227( ) ;
            standaloneNotModal( ) ;
            standaloneModal( ) ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public void disable_std_buttons( )
   {
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      if ( isDsp( ) || isDlt( ) )
      {
         bttBtntrn_delete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
         if ( isDsp( ) )
         {
            bttBtntrn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
         }
         disableAttributes4W227( ) ;
      }
   }

   public void set_caption( )
   {
      if ( ( IsConfirmed == 1 ) && ( AnyError == 0 ) )
      {
         if ( isDlt( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_confdelete"), 0, "", true);
         }
         else
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_mustconfirm"), 0, "", true);
         }
      }
   }

   public void confirm_4W0( )
   {
      beforeValidate4W227( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls4W227( ) ;
         }
         else
         {
            checkExtendedTable4W227( ) ;
            closeExtendedTableCursors4W227( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption4W0( )
   {
   }

   public void e114W2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV11WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV11WWPContext = GXv_SdtWWPContext1[0] ;
      AV12IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLSD_reg2_Insert", GXv_boolean3) ;
         lsd_reg2_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLSD_reg2_Update", GXv_boolean3) ;
         lsd_reg2_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLSD_reg2_Delete", GXv_boolean3) ;
         lsd_reg2_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV16Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      edtLSDSec_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSDSec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSDSec_Visible), 5, 0), true);
      edtLSD2Sec_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD2Sec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD2Sec_Visible), 5, 0), true);
   }

   public void e124W2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm4W227( int GX_JID )
   {
      if ( ( GX_JID == 13 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1658LSD2cuilEmpleado_3_11 = T004W3_A1658LSD2cuilEmpleado_3_11[0] ;
            Z1659LSD2legajoEmpleado_14_10 = T004W3_A1659LSD2legajoEmpleado_14_10[0] ;
            Z1660LSD2dependenciaRevista_24_50 = T004W3_A1660LSD2dependenciaRevista_24_50[0] ;
            Z1661LSD2cbuEmpleado_74_22 = T004W3_A1661LSD2cbuEmpleado_74_22[0] ;
            Z1662LSD2diasLiquidados_96_3 = T004W3_A1662LSD2diasLiquidados_96_3[0] ;
            Z1663LSD2fechaPago_99_8 = T004W3_A1663LSD2fechaPago_99_8[0] ;
            Z1664LSD2fechaRubrica_107_8 = T004W3_A1664LSD2fechaRubrica_107_8[0] ;
            Z1665LSD2formaPago_115_1 = T004W3_A1665LSD2formaPago_115_1[0] ;
         }
         else
         {
            Z1658LSD2cuilEmpleado_3_11 = A1658LSD2cuilEmpleado_3_11 ;
            Z1659LSD2legajoEmpleado_14_10 = A1659LSD2legajoEmpleado_14_10 ;
            Z1660LSD2dependenciaRevista_24_50 = A1660LSD2dependenciaRevista_24_50 ;
            Z1661LSD2cbuEmpleado_74_22 = A1661LSD2cbuEmpleado_74_22 ;
            Z1662LSD2diasLiquidados_96_3 = A1662LSD2diasLiquidados_96_3 ;
            Z1663LSD2fechaPago_99_8 = A1663LSD2fechaPago_99_8 ;
            Z1664LSD2fechaRubrica_107_8 = A1664LSD2fechaRubrica_107_8 ;
            Z1665LSD2formaPago_115_1 = A1665LSD2formaPago_115_1 ;
         }
      }
      if ( GX_JID == -13 )
      {
         Z1657LSD2Sec = A1657LSD2Sec ;
         Z1658LSD2cuilEmpleado_3_11 = A1658LSD2cuilEmpleado_3_11 ;
         Z1659LSD2legajoEmpleado_14_10 = A1659LSD2legajoEmpleado_14_10 ;
         Z1660LSD2dependenciaRevista_24_50 = A1660LSD2dependenciaRevista_24_50 ;
         Z1661LSD2cbuEmpleado_74_22 = A1661LSD2cbuEmpleado_74_22 ;
         Z1662LSD2diasLiquidados_96_3 = A1662LSD2diasLiquidados_96_3 ;
         Z1663LSD2fechaPago_99_8 = A1663LSD2fechaPago_99_8 ;
         Z1664LSD2fechaRubrica_107_8 = A1664LSD2fechaRubrica_107_8 ;
         Z1665LSD2formaPago_115_1 = A1665LSD2formaPago_115_1 ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1649LSDSec = A1649LSDSec ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            lsd_reg2_impl.this.GXt_int4 = GXv_int5[0] ;
            A3CliCod = GXt_int4 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      else
      {
         edtCliCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8EmpCod) )
      {
         A1EmpCod = AV8EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      if ( ! (0==AV8EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      else
      {
         edtEmpCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9LSDSec) )
      {
         A1649LSDSec = AV9LSDSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
      }
      if ( ! (0==AV9LSDSec) )
      {
         edtLSDSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLSDSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSDSec_Enabled), 5, 0), true);
      }
      else
      {
         edtLSDSec_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLSDSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSDSec_Enabled), 5, 0), true);
      }
      if ( ! (0==AV9LSDSec) )
      {
         edtLSDSec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLSDSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSDSec_Enabled), 5, 0), true);
      }
      if ( ! (0==AV10LSD2Sec) )
      {
         A1657LSD2Sec = AV10LSD2Sec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
      }
      if ( ! (0==AV10LSD2Sec) )
      {
         edtLSD2Sec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLSD2Sec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD2Sec_Enabled), 5, 0), true);
      }
      else
      {
         edtLSD2Sec_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLSD2Sec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD2Sec_Enabled), 5, 0), true);
      }
      if ( ! (0==AV10LSD2Sec) )
      {
         edtLSD2Sec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLSD2Sec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD2Sec_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtntrn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtntrn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV16Pgmname = "LSD_reg2" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
      }
   }

   public void load4W227( )
   {
      /* Using cursor T004W5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound227 = (short)(1) ;
         A1658LSD2cuilEmpleado_3_11 = T004W5_A1658LSD2cuilEmpleado_3_11[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1658LSD2cuilEmpleado_3_11", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1658LSD2cuilEmpleado_3_11), 11, 0));
         A1659LSD2legajoEmpleado_14_10 = T004W5_A1659LSD2legajoEmpleado_14_10[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1659LSD2legajoEmpleado_14_10", A1659LSD2legajoEmpleado_14_10);
         A1660LSD2dependenciaRevista_24_50 = T004W5_A1660LSD2dependenciaRevista_24_50[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1660LSD2dependenciaRevista_24_50", A1660LSD2dependenciaRevista_24_50);
         A1661LSD2cbuEmpleado_74_22 = T004W5_A1661LSD2cbuEmpleado_74_22[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1661LSD2cbuEmpleado_74_22", A1661LSD2cbuEmpleado_74_22);
         A1662LSD2diasLiquidados_96_3 = T004W5_A1662LSD2diasLiquidados_96_3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1662LSD2diasLiquidados_96_3", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1662LSD2diasLiquidados_96_3), 3, 0));
         A1663LSD2fechaPago_99_8 = T004W5_A1663LSD2fechaPago_99_8[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1663LSD2fechaPago_99_8", localUtil.format(A1663LSD2fechaPago_99_8, "99/99/99"));
         A1664LSD2fechaRubrica_107_8 = T004W5_A1664LSD2fechaRubrica_107_8[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1664LSD2fechaRubrica_107_8", localUtil.format(A1664LSD2fechaRubrica_107_8, "99/99/99"));
         A1665LSD2formaPago_115_1 = T004W5_A1665LSD2formaPago_115_1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1665LSD2formaPago_115_1", A1665LSD2formaPago_115_1);
         zm4W227( -13) ;
      }
      pr_default.close(3);
      onLoadActions4W227( ) ;
   }

   public void onLoadActions4W227( )
   {
      AV16Pgmname = "LSD_reg2" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
   }

   public void checkExtendedTable4W227( )
   {
      nIsDirty_227 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV16Pgmname = "LSD_reg2" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
      /* Using cursor T004W4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "LSD_reg1", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LSDSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
   }

   public void closeExtendedTableCursors4W227( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_14( int A3CliCod ,
                          short A1EmpCod ,
                          int A1649LSDSec )
   {
      /* Using cursor T004W6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "LSD_reg1", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LSDSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(4) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(4);
   }

   public void getKey4W227( )
   {
      /* Using cursor T004W7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound227 = (short)(1) ;
      }
      else
      {
         RcdFound227 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T004W3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm4W227( 13) ;
         RcdFound227 = (short)(1) ;
         A1657LSD2Sec = T004W3_A1657LSD2Sec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
         A1658LSD2cuilEmpleado_3_11 = T004W3_A1658LSD2cuilEmpleado_3_11[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1658LSD2cuilEmpleado_3_11", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1658LSD2cuilEmpleado_3_11), 11, 0));
         A1659LSD2legajoEmpleado_14_10 = T004W3_A1659LSD2legajoEmpleado_14_10[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1659LSD2legajoEmpleado_14_10", A1659LSD2legajoEmpleado_14_10);
         A1660LSD2dependenciaRevista_24_50 = T004W3_A1660LSD2dependenciaRevista_24_50[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1660LSD2dependenciaRevista_24_50", A1660LSD2dependenciaRevista_24_50);
         A1661LSD2cbuEmpleado_74_22 = T004W3_A1661LSD2cbuEmpleado_74_22[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1661LSD2cbuEmpleado_74_22", A1661LSD2cbuEmpleado_74_22);
         A1662LSD2diasLiquidados_96_3 = T004W3_A1662LSD2diasLiquidados_96_3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1662LSD2diasLiquidados_96_3", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1662LSD2diasLiquidados_96_3), 3, 0));
         A1663LSD2fechaPago_99_8 = T004W3_A1663LSD2fechaPago_99_8[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1663LSD2fechaPago_99_8", localUtil.format(A1663LSD2fechaPago_99_8, "99/99/99"));
         A1664LSD2fechaRubrica_107_8 = T004W3_A1664LSD2fechaRubrica_107_8[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1664LSD2fechaRubrica_107_8", localUtil.format(A1664LSD2fechaRubrica_107_8, "99/99/99"));
         A1665LSD2formaPago_115_1 = T004W3_A1665LSD2formaPago_115_1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1665LSD2formaPago_115_1", A1665LSD2formaPago_115_1);
         A3CliCod = T004W3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T004W3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1649LSDSec = T004W3_A1649LSDSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1649LSDSec = A1649LSDSec ;
         Z1657LSD2Sec = A1657LSD2Sec ;
         sMode227 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load4W227( ) ;
         if ( AnyError == 1 )
         {
            RcdFound227 = (short)(0) ;
            initializeNonKey4W227( ) ;
         }
         Gx_mode = sMode227 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound227 = (short)(0) ;
         initializeNonKey4W227( ) ;
         sMode227 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode227 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey4W227( ) ;
      if ( RcdFound227 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound227 = (short)(0) ;
      /* Using cursor T004W8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1649LSDSec), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A1657LSD2Sec)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T004W8_A3CliCod[0] < A3CliCod ) || ( T004W8_A3CliCod[0] == A3CliCod ) && ( T004W8_A1EmpCod[0] < A1EmpCod ) || ( T004W8_A1EmpCod[0] == A1EmpCod ) && ( T004W8_A3CliCod[0] == A3CliCod ) && ( T004W8_A1649LSDSec[0] < A1649LSDSec ) || ( T004W8_A1649LSDSec[0] == A1649LSDSec ) && ( T004W8_A1EmpCod[0] == A1EmpCod ) && ( T004W8_A3CliCod[0] == A3CliCod ) && ( T004W8_A1657LSD2Sec[0] < A1657LSD2Sec ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T004W8_A3CliCod[0] > A3CliCod ) || ( T004W8_A3CliCod[0] == A3CliCod ) && ( T004W8_A1EmpCod[0] > A1EmpCod ) || ( T004W8_A1EmpCod[0] == A1EmpCod ) && ( T004W8_A3CliCod[0] == A3CliCod ) && ( T004W8_A1649LSDSec[0] > A1649LSDSec ) || ( T004W8_A1649LSDSec[0] == A1649LSDSec ) && ( T004W8_A1EmpCod[0] == A1EmpCod ) && ( T004W8_A3CliCod[0] == A3CliCod ) && ( T004W8_A1657LSD2Sec[0] > A1657LSD2Sec ) ) )
         {
            A3CliCod = T004W8_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T004W8_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A1649LSDSec = T004W8_A1649LSDSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
            A1657LSD2Sec = T004W8_A1657LSD2Sec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
            RcdFound227 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound227 = (short)(0) ;
      /* Using cursor T004W9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1649LSDSec), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A1657LSD2Sec)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T004W9_A3CliCod[0] > A3CliCod ) || ( T004W9_A3CliCod[0] == A3CliCod ) && ( T004W9_A1EmpCod[0] > A1EmpCod ) || ( T004W9_A1EmpCod[0] == A1EmpCod ) && ( T004W9_A3CliCod[0] == A3CliCod ) && ( T004W9_A1649LSDSec[0] > A1649LSDSec ) || ( T004W9_A1649LSDSec[0] == A1649LSDSec ) && ( T004W9_A1EmpCod[0] == A1EmpCod ) && ( T004W9_A3CliCod[0] == A3CliCod ) && ( T004W9_A1657LSD2Sec[0] > A1657LSD2Sec ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T004W9_A3CliCod[0] < A3CliCod ) || ( T004W9_A3CliCod[0] == A3CliCod ) && ( T004W9_A1EmpCod[0] < A1EmpCod ) || ( T004W9_A1EmpCod[0] == A1EmpCod ) && ( T004W9_A3CliCod[0] == A3CliCod ) && ( T004W9_A1649LSDSec[0] < A1649LSDSec ) || ( T004W9_A1649LSDSec[0] == A1649LSDSec ) && ( T004W9_A1EmpCod[0] == A1EmpCod ) && ( T004W9_A3CliCod[0] == A3CliCod ) && ( T004W9_A1657LSD2Sec[0] < A1657LSD2Sec ) ) )
         {
            A3CliCod = T004W9_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T004W9_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A1649LSDSec = T004W9_A1649LSDSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
            A1657LSD2Sec = T004W9_A1657LSD2Sec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
            RcdFound227 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey4W227( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtLSD2cuilEmpleado_3_11_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert4W227( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound227 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1649LSDSec != Z1649LSDSec ) || ( A1657LSD2Sec != Z1657LSD2Sec ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A1649LSDSec = Z1649LSDSec ;
               httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
               A1657LSD2Sec = Z1657LSD2Sec ;
               httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtLSD2cuilEmpleado_3_11_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update4W227( ) ;
               GX_FocusControl = edtLSD2cuilEmpleado_3_11_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1649LSDSec != Z1649LSDSec ) || ( A1657LSD2Sec != Z1657LSD2Sec ) )
            {
               /* Insert record */
               GX_FocusControl = edtLSD2cuilEmpleado_3_11_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert4W227( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CLICOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCliCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtLSD2cuilEmpleado_3_11_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert4W227( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
      if ( isUpd( ) || isDlt( ) )
      {
         if ( AnyError == 0 )
         {
            httpContext.nUserReturn = (byte)(1) ;
         }
      }
   }

   public void btn_delete( )
   {
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1649LSDSec != Z1649LSDSec ) || ( A1657LSD2Sec != Z1657LSD2Sec ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1649LSDSec = Z1649LSDSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
         A1657LSD2Sec = Z1657LSD2Sec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtLSD2cuilEmpleado_3_11_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency4W227( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T004W2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LSD_reg2"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z1658LSD2cuilEmpleado_3_11 != T004W2_A1658LSD2cuilEmpleado_3_11[0] ) || ( GXutil.strcmp(Z1659LSD2legajoEmpleado_14_10, T004W2_A1659LSD2legajoEmpleado_14_10[0]) != 0 ) || ( GXutil.strcmp(Z1660LSD2dependenciaRevista_24_50, T004W2_A1660LSD2dependenciaRevista_24_50[0]) != 0 ) || ( GXutil.strcmp(Z1661LSD2cbuEmpleado_74_22, T004W2_A1661LSD2cbuEmpleado_74_22[0]) != 0 ) || ( Z1662LSD2diasLiquidados_96_3 != T004W2_A1662LSD2diasLiquidados_96_3[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(GXutil.resetTime(Z1663LSD2fechaPago_99_8), GXutil.resetTime(T004W2_A1663LSD2fechaPago_99_8[0])) ) || !( GXutil.dateCompare(GXutil.resetTime(Z1664LSD2fechaRubrica_107_8), GXutil.resetTime(T004W2_A1664LSD2fechaRubrica_107_8[0])) ) || ( GXutil.strcmp(Z1665LSD2formaPago_115_1, T004W2_A1665LSD2formaPago_115_1[0]) != 0 ) )
         {
            if ( Z1658LSD2cuilEmpleado_3_11 != T004W2_A1658LSD2cuilEmpleado_3_11[0] )
            {
               GXutil.writeLogln("lsd_reg2:[seudo value changed for attri]"+"LSD2cuilEmpleado_3_11");
               GXutil.writeLogRaw("Old: ",Z1658LSD2cuilEmpleado_3_11);
               GXutil.writeLogRaw("Current: ",T004W2_A1658LSD2cuilEmpleado_3_11[0]);
            }
            if ( GXutil.strcmp(Z1659LSD2legajoEmpleado_14_10, T004W2_A1659LSD2legajoEmpleado_14_10[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg2:[seudo value changed for attri]"+"LSD2legajoEmpleado_14_10");
               GXutil.writeLogRaw("Old: ",Z1659LSD2legajoEmpleado_14_10);
               GXutil.writeLogRaw("Current: ",T004W2_A1659LSD2legajoEmpleado_14_10[0]);
            }
            if ( GXutil.strcmp(Z1660LSD2dependenciaRevista_24_50, T004W2_A1660LSD2dependenciaRevista_24_50[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg2:[seudo value changed for attri]"+"LSD2dependenciaRevista_24_50");
               GXutil.writeLogRaw("Old: ",Z1660LSD2dependenciaRevista_24_50);
               GXutil.writeLogRaw("Current: ",T004W2_A1660LSD2dependenciaRevista_24_50[0]);
            }
            if ( GXutil.strcmp(Z1661LSD2cbuEmpleado_74_22, T004W2_A1661LSD2cbuEmpleado_74_22[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg2:[seudo value changed for attri]"+"LSD2cbuEmpleado_74_22");
               GXutil.writeLogRaw("Old: ",Z1661LSD2cbuEmpleado_74_22);
               GXutil.writeLogRaw("Current: ",T004W2_A1661LSD2cbuEmpleado_74_22[0]);
            }
            if ( Z1662LSD2diasLiquidados_96_3 != T004W2_A1662LSD2diasLiquidados_96_3[0] )
            {
               GXutil.writeLogln("lsd_reg2:[seudo value changed for attri]"+"LSD2diasLiquidados_96_3");
               GXutil.writeLogRaw("Old: ",Z1662LSD2diasLiquidados_96_3);
               GXutil.writeLogRaw("Current: ",T004W2_A1662LSD2diasLiquidados_96_3[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z1663LSD2fechaPago_99_8), GXutil.resetTime(T004W2_A1663LSD2fechaPago_99_8[0])) ) )
            {
               GXutil.writeLogln("lsd_reg2:[seudo value changed for attri]"+"LSD2fechaPago_99_8");
               GXutil.writeLogRaw("Old: ",Z1663LSD2fechaPago_99_8);
               GXutil.writeLogRaw("Current: ",T004W2_A1663LSD2fechaPago_99_8[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z1664LSD2fechaRubrica_107_8), GXutil.resetTime(T004W2_A1664LSD2fechaRubrica_107_8[0])) ) )
            {
               GXutil.writeLogln("lsd_reg2:[seudo value changed for attri]"+"LSD2fechaRubrica_107_8");
               GXutil.writeLogRaw("Old: ",Z1664LSD2fechaRubrica_107_8);
               GXutil.writeLogRaw("Current: ",T004W2_A1664LSD2fechaRubrica_107_8[0]);
            }
            if ( GXutil.strcmp(Z1665LSD2formaPago_115_1, T004W2_A1665LSD2formaPago_115_1[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg2:[seudo value changed for attri]"+"LSD2formaPago_115_1");
               GXutil.writeLogRaw("Old: ",Z1665LSD2formaPago_115_1);
               GXutil.writeLogRaw("Current: ",T004W2_A1665LSD2formaPago_115_1[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"LSD_reg2"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert4W227( )
   {
      beforeValidate4W227( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4W227( ) ;
      }
      if ( AnyError == 0 )
      {
         zm4W227( 0) ;
         checkOptimisticConcurrency4W227( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4W227( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert4W227( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004W10 */
                  pr_default.execute(8, new Object[] {Integer.valueOf(A1657LSD2Sec), Long.valueOf(A1658LSD2cuilEmpleado_3_11), A1659LSD2legajoEmpleado_14_10, A1660LSD2dependenciaRevista_24_50, A1661LSD2cbuEmpleado_74_22, Short.valueOf(A1662LSD2diasLiquidados_96_3), A1663LSD2fechaPago_99_8, A1664LSD2fechaRubrica_107_8, A1665LSD2formaPago_115_1, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LSD_reg2");
                  if ( (pr_default.getStatus(8) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption4W0( ) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load4W227( ) ;
         }
         endLevel4W227( ) ;
      }
      closeExtendedTableCursors4W227( ) ;
   }

   public void update4W227( )
   {
      beforeValidate4W227( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4W227( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4W227( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4W227( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate4W227( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004W11 */
                  pr_default.execute(9, new Object[] {Long.valueOf(A1658LSD2cuilEmpleado_3_11), A1659LSD2legajoEmpleado_14_10, A1660LSD2dependenciaRevista_24_50, A1661LSD2cbuEmpleado_74_22, Short.valueOf(A1662LSD2diasLiquidados_96_3), A1663LSD2fechaPago_99_8, A1664LSD2fechaRubrica_107_8, A1665LSD2formaPago_115_1, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LSD_reg2");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LSD_reg2"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate4W227( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        if ( isUpd( ) || isDlt( ) )
                        {
                           if ( AnyError == 0 )
                           {
                              httpContext.nUserReturn = (byte)(1) ;
                           }
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel4W227( ) ;
      }
      closeExtendedTableCursors4W227( ) ;
   }

   public void deferredUpdate4W227( )
   {
   }

   public void delete( )
   {
      beforeValidate4W227( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4W227( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls4W227( ) ;
         afterConfirm4W227( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete4W227( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T004W12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LSD_reg2");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     if ( isUpd( ) || isDlt( ) )
                     {
                        if ( AnyError == 0 )
                        {
                           httpContext.nUserReturn = (byte)(1) ;
                        }
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode227 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel4W227( ) ;
      Gx_mode = sMode227 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls4W227( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV16Pgmname = "LSD_reg2" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T004W13 */
         pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
         if ( (pr_default.getStatus(11) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LSD_reg4", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(11);
         /* Using cursor T004W14 */
         pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LSD_reg3", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
      }
   }

   public void endLevel4W227( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete4W227( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "lsd_reg2");
         if ( AnyError == 0 )
         {
            confirmValues4W0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "lsd_reg2");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart4W227( )
   {
      /* Scan By routine */
      /* Using cursor T004W15 */
      pr_default.execute(13);
      RcdFound227 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound227 = (short)(1) ;
         A3CliCod = T004W15_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T004W15_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1649LSDSec = T004W15_A1649LSDSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
         A1657LSD2Sec = T004W15_A1657LSD2Sec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext4W227( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound227 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound227 = (short)(1) ;
         A3CliCod = T004W15_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T004W15_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1649LSDSec = T004W15_A1649LSDSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
         A1657LSD2Sec = T004W15_A1657LSD2Sec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
      }
   }

   public void scanEnd4W227( )
   {
      pr_default.close(13);
   }

   public void afterConfirm4W227( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert4W227( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate4W227( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete4W227( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete4W227( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate4W227( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes4W227( )
   {
      edtLSD2cuilEmpleado_3_11_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD2cuilEmpleado_3_11_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD2cuilEmpleado_3_11_Enabled), 5, 0), true);
      edtLSD2legajoEmpleado_14_10_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD2legajoEmpleado_14_10_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD2legajoEmpleado_14_10_Enabled), 5, 0), true);
      edtLSD2dependenciaRevista_24_50_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD2dependenciaRevista_24_50_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD2dependenciaRevista_24_50_Enabled), 5, 0), true);
      edtLSD2cbuEmpleado_74_22_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD2cbuEmpleado_74_22_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD2cbuEmpleado_74_22_Enabled), 5, 0), true);
      edtLSD2diasLiquidados_96_3_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD2diasLiquidados_96_3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD2diasLiquidados_96_3_Enabled), 5, 0), true);
      edtLSD2fechaPago_99_8_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD2fechaPago_99_8_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD2fechaPago_99_8_Enabled), 5, 0), true);
      edtLSD2fechaRubrica_107_8_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD2fechaRubrica_107_8_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD2fechaRubrica_107_8_Enabled), 5, 0), true);
      edtLSD2formaPago_115_1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD2formaPago_115_1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD2formaPago_115_1_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtLSDSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSDSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSDSec_Enabled), 5, 0), true);
      edtLSD2Sec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD2Sec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD2Sec_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes4W227( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues4W0( )
   {
   }

   public void renderHtmlHeaders( )
   {
      web.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( Form.getCaption()) ;
      httpContext.writeTextNL( "</title>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( GXutil.len( sDynURL) > 0 )
      {
         httpContext.writeText( "<BASE href=\""+sDynURL+"\" />") ;
      }
      define_styles( ) ;
      MasterPageObj.master_styles();
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      bodyStyle += "-moz-opacity:0;opacity:0;" ;
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.lsd_reg2", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9LSDSec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10LSD2Sec,8,0))}, new String[] {"Gx_mode","CliCod","EmpCod","LSDSec","LSD2Sec"}) +"\">") ;
      web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"LSD_reg2");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("lsd_reg2:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1649LSDSec", GXutil.ltrim( localUtil.ntoc( Z1649LSDSec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1657LSD2Sec", GXutil.ltrim( localUtil.ntoc( Z1657LSD2Sec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1658LSD2cuilEmpleado_3_11", GXutil.ltrim( localUtil.ntoc( Z1658LSD2cuilEmpleado_3_11, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1659LSD2legajoEmpleado_14_10", GXutil.rtrim( Z1659LSD2legajoEmpleado_14_10));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1660LSD2dependenciaRevista_24_50", GXutil.rtrim( Z1660LSD2dependenciaRevista_24_50));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1661LSD2cbuEmpleado_74_22", GXutil.rtrim( Z1661LSD2cbuEmpleado_74_22));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1662LSD2diasLiquidados_96_3", GXutil.ltrim( localUtil.ntoc( Z1662LSD2diasLiquidados_96_3, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1663LSD2fechaPago_99_8", localUtil.dtoc( Z1663LSD2fechaPago_99_8, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1664LSD2fechaRubrica_107_8", localUtil.dtoc( Z1664LSD2fechaRubrica_107_8, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1665LSD2formaPago_115_1", GXutil.rtrim( Z1665LSD2formaPago_115_1));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLSDSEC", GXutil.ltrim( localUtil.ntoc( AV9LSDSec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSDSEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9LSDSec), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLSD2SEC", GXutil.ltrim( localUtil.ntoc( AV10LSD2Sec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSD2SEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10LSD2Sec), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV16Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Objectcall", GXutil.rtrim( Dvpanel_tableattributes_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Enabled", GXutil.booltostr( Dvpanel_tableattributes_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
      httpContext.SendComponentObjects();
      httpContext.SendServerCommands();
      httpContext.SendState();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      httpContext.writeTextNL( "</form>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      include_jscripts( ) ;
      httpContext.writeText( "<script type=\"text/javascript\">") ;
      httpContext.writeText( "gx.setLanguageCode(\""+httpContext.getLanguageProperty( "code")+"\");") ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         httpContext.writeText( "gx.setDateFormat(\""+httpContext.getLanguageProperty( "date_fmt")+"\");") ;
         httpContext.writeText( "gx.setTimeFormat("+httpContext.getLanguageProperty( "time_fmt")+");") ;
         httpContext.writeText( "gx.setCenturyFirstYear("+40+");") ;
         httpContext.writeText( "gx.setDecimalPoint(\""+httpContext.getLanguageProperty( "decimal_point")+"\");") ;
         httpContext.writeText( "gx.setThousandSeparator(\""+httpContext.getLanguageProperty( "thousand_sep")+"\");") ;
         httpContext.writeText( "gx.StorageTimeZone = "+1+";") ;
      }
      httpContext.writeText( "</script>") ;
   }

   public byte executeStartEvent( )
   {
      standaloneStartup( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      return gxajaxcallmode ;
   }

   public void renderHtmlContent( )
   {
      httpContext.writeText( "<div") ;
      web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
      httpContext.writeText( ">") ;
      draw( ) ;
      httpContext.writeText( "</div>") ;
   }

   public void dispatchEvents( )
   {
      process( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("web.lsd_reg2", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9LSDSec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10LSD2Sec,8,0))}, new String[] {"Gx_mode","CliCod","EmpCod","LSDSec","LSD2Sec"})  ;
   }

   public String getPgmname( )
   {
      return "LSD_reg2" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "LSD_reg2", "") ;
   }

   public void initializeNonKey4W227( )
   {
      A1658LSD2cuilEmpleado_3_11 = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1658LSD2cuilEmpleado_3_11", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1658LSD2cuilEmpleado_3_11), 11, 0));
      A1659LSD2legajoEmpleado_14_10 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1659LSD2legajoEmpleado_14_10", A1659LSD2legajoEmpleado_14_10);
      A1660LSD2dependenciaRevista_24_50 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1660LSD2dependenciaRevista_24_50", A1660LSD2dependenciaRevista_24_50);
      A1661LSD2cbuEmpleado_74_22 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1661LSD2cbuEmpleado_74_22", A1661LSD2cbuEmpleado_74_22);
      A1662LSD2diasLiquidados_96_3 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1662LSD2diasLiquidados_96_3", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1662LSD2diasLiquidados_96_3), 3, 0));
      A1663LSD2fechaPago_99_8 = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A1663LSD2fechaPago_99_8", localUtil.format(A1663LSD2fechaPago_99_8, "99/99/99"));
      A1664LSD2fechaRubrica_107_8 = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A1664LSD2fechaRubrica_107_8", localUtil.format(A1664LSD2fechaRubrica_107_8, "99/99/99"));
      A1665LSD2formaPago_115_1 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1665LSD2formaPago_115_1", A1665LSD2formaPago_115_1);
      Z1658LSD2cuilEmpleado_3_11 = 0 ;
      Z1659LSD2legajoEmpleado_14_10 = "" ;
      Z1660LSD2dependenciaRevista_24_50 = "" ;
      Z1661LSD2cbuEmpleado_74_22 = "" ;
      Z1662LSD2diasLiquidados_96_3 = (short)(0) ;
      Z1663LSD2fechaPago_99_8 = GXutil.nullDate() ;
      Z1664LSD2fechaRubrica_107_8 = GXutil.nullDate() ;
      Z1665LSD2formaPago_115_1 = "" ;
   }

   public void initAll4W227( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A1649LSDSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
      A1657LSD2Sec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
      initializeNonKey4W227( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412202026106", true, true);
         idxLst = (int)(idxLst+1) ;
      }
      if ( ! outputEnabled )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
      /* End function define_styles */
   }

   public void include_jscripts( )
   {
      httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      httpContext.AddJavascriptSource("lsd_reg2.js", "?202412202026106", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtLSD2cuilEmpleado_3_11_Internalname = "LSD2CUILEMPLEADO_3_11" ;
      edtLSD2legajoEmpleado_14_10_Internalname = "LSD2LEGAJOEMPLEADO_14_10" ;
      edtLSD2dependenciaRevista_24_50_Internalname = "LSD2DEPENDENCIAREVISTA_24_50" ;
      edtLSD2cbuEmpleado_74_22_Internalname = "LSD2CBUEMPLEADO_74_22" ;
      edtLSD2diasLiquidados_96_3_Internalname = "LSD2DIASLIQUIDADOS_96_3" ;
      edtLSD2fechaPago_99_8_Internalname = "LSD2FECHAPAGO_99_8" ;
      edtLSD2fechaRubrica_107_8_Internalname = "LSD2FECHARUBRICA_107_8" ;
      edtLSD2formaPago_115_1_Internalname = "LSD2FORMAPAGO_115_1" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtLSDSec_Internalname = "LSDSEC" ;
      edtLSD2Sec_Internalname = "LSD2SEC" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "LSD_reg2", "") );
      edtLSD2Sec_Jsonclick = "" ;
      edtLSD2Sec_Enabled = 1 ;
      edtLSD2Sec_Visible = 1 ;
      edtLSDSec_Jsonclick = "" ;
      edtLSDSec_Enabled = 1 ;
      edtLSDSec_Visible = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Enabled = 1 ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtLSD2formaPago_115_1_Jsonclick = "" ;
      edtLSD2formaPago_115_1_Enabled = 1 ;
      edtLSD2fechaRubrica_107_8_Jsonclick = "" ;
      edtLSD2fechaRubrica_107_8_Enabled = 1 ;
      edtLSD2fechaPago_99_8_Jsonclick = "" ;
      edtLSD2fechaPago_99_8_Enabled = 1 ;
      edtLSD2diasLiquidados_96_3_Jsonclick = "" ;
      edtLSD2diasLiquidados_96_3_Enabled = 1 ;
      edtLSD2cbuEmpleado_74_22_Jsonclick = "" ;
      edtLSD2cbuEmpleado_74_22_Enabled = 1 ;
      edtLSD2dependenciaRevista_24_50_Jsonclick = "" ;
      edtLSD2dependenciaRevista_24_50_Enabled = 1 ;
      edtLSD2legajoEmpleado_14_10_Jsonclick = "" ;
      edtLSD2legajoEmpleado_14_10_Enabled = 1 ;
      edtLSD2cuilEmpleado_3_11_Jsonclick = "" ;
      edtLSD2cuilEmpleado_3_11_Enabled = 1 ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "WWP_TemplateDataPanelTitle", "") ;
      Dvpanel_tableattributes_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      divLayoutmaintable_Class = "Table" ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gx1asaclicod4W227( int AV7CliCod )
   {
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            lsd_reg2_impl.this.GXt_int4 = GXv_int5[0] ;
            A3CliCod = GXt_int4 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void valid_Lsdsec( )
   {
      /* Using cursor T004W16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "LSD_reg1", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LSDSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(14);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LSDSec',fld:'vLSDSEC',pic:'ZZZZZZZ9',hsh:true},{av:'AV10LSD2Sec',fld:'vLSD2SEC',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LSDSec',fld:'vLSDSEC',pic:'ZZZZZZZ9',hsh:true},{av:'AV10LSD2Sec',fld:'vLSD2SEC',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e124W2',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_LSDSEC","{handler:'valid_Lsdsec',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1649LSDSec',fld:'LSDSEC',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VALID_LSDSEC",",oparms:[]}");
      setEventMetadata("VALID_LSD2SEC","{handler:'valid_Lsd2sec',iparms:[]");
      setEventMetadata("VALID_LSD2SEC",",oparms:[]}");
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
      pr_default.close(14);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z1659LSD2legajoEmpleado_14_10 = "" ;
      Z1660LSD2dependenciaRevista_24_50 = "" ;
      Z1661LSD2cbuEmpleado_74_22 = "" ;
      Z1663LSD2fechaPago_99_8 = GXutil.nullDate() ;
      Z1664LSD2fechaRubrica_107_8 = GXutil.nullDate() ;
      Z1665LSD2formaPago_115_1 = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A1659LSD2legajoEmpleado_14_10 = "" ;
      A1660LSD2dependenciaRevista_24_50 = "" ;
      A1661LSD2cbuEmpleado_74_22 = "" ;
      A1663LSD2fechaPago_99_8 = GXutil.nullDate() ;
      A1664LSD2fechaRubrica_107_8 = GXutil.nullDate() ;
      A1665LSD2formaPago_115_1 = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV16Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode227 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV11WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV14TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV15WebSession = httpContext.getWebSession();
      T004W5_A1657LSD2Sec = new int[1] ;
      T004W5_A1658LSD2cuilEmpleado_3_11 = new long[1] ;
      T004W5_A1659LSD2legajoEmpleado_14_10 = new String[] {""} ;
      T004W5_A1660LSD2dependenciaRevista_24_50 = new String[] {""} ;
      T004W5_A1661LSD2cbuEmpleado_74_22 = new String[] {""} ;
      T004W5_A1662LSD2diasLiquidados_96_3 = new short[1] ;
      T004W5_A1663LSD2fechaPago_99_8 = new java.util.Date[] {GXutil.nullDate()} ;
      T004W5_A1664LSD2fechaRubrica_107_8 = new java.util.Date[] {GXutil.nullDate()} ;
      T004W5_A1665LSD2formaPago_115_1 = new String[] {""} ;
      T004W5_A3CliCod = new int[1] ;
      T004W5_A1EmpCod = new short[1] ;
      T004W5_A1649LSDSec = new int[1] ;
      T004W4_A3CliCod = new int[1] ;
      T004W6_A3CliCod = new int[1] ;
      T004W7_A3CliCod = new int[1] ;
      T004W7_A1EmpCod = new short[1] ;
      T004W7_A1649LSDSec = new int[1] ;
      T004W7_A1657LSD2Sec = new int[1] ;
      T004W3_A1657LSD2Sec = new int[1] ;
      T004W3_A1658LSD2cuilEmpleado_3_11 = new long[1] ;
      T004W3_A1659LSD2legajoEmpleado_14_10 = new String[] {""} ;
      T004W3_A1660LSD2dependenciaRevista_24_50 = new String[] {""} ;
      T004W3_A1661LSD2cbuEmpleado_74_22 = new String[] {""} ;
      T004W3_A1662LSD2diasLiquidados_96_3 = new short[1] ;
      T004W3_A1663LSD2fechaPago_99_8 = new java.util.Date[] {GXutil.nullDate()} ;
      T004W3_A1664LSD2fechaRubrica_107_8 = new java.util.Date[] {GXutil.nullDate()} ;
      T004W3_A1665LSD2formaPago_115_1 = new String[] {""} ;
      T004W3_A3CliCod = new int[1] ;
      T004W3_A1EmpCod = new short[1] ;
      T004W3_A1649LSDSec = new int[1] ;
      T004W8_A3CliCod = new int[1] ;
      T004W8_A1EmpCod = new short[1] ;
      T004W8_A1649LSDSec = new int[1] ;
      T004W8_A1657LSD2Sec = new int[1] ;
      T004W9_A3CliCod = new int[1] ;
      T004W9_A1EmpCod = new short[1] ;
      T004W9_A1649LSDSec = new int[1] ;
      T004W9_A1657LSD2Sec = new int[1] ;
      T004W2_A1657LSD2Sec = new int[1] ;
      T004W2_A1658LSD2cuilEmpleado_3_11 = new long[1] ;
      T004W2_A1659LSD2legajoEmpleado_14_10 = new String[] {""} ;
      T004W2_A1660LSD2dependenciaRevista_24_50 = new String[] {""} ;
      T004W2_A1661LSD2cbuEmpleado_74_22 = new String[] {""} ;
      T004W2_A1662LSD2diasLiquidados_96_3 = new short[1] ;
      T004W2_A1663LSD2fechaPago_99_8 = new java.util.Date[] {GXutil.nullDate()} ;
      T004W2_A1664LSD2fechaRubrica_107_8 = new java.util.Date[] {GXutil.nullDate()} ;
      T004W2_A1665LSD2formaPago_115_1 = new String[] {""} ;
      T004W2_A3CliCod = new int[1] ;
      T004W2_A1EmpCod = new short[1] ;
      T004W2_A1649LSDSec = new int[1] ;
      T004W13_A3CliCod = new int[1] ;
      T004W13_A1EmpCod = new short[1] ;
      T004W13_A1649LSDSec = new int[1] ;
      T004W13_A1657LSD2Sec = new int[1] ;
      T004W13_A1674LSD4Sec = new short[1] ;
      T004W14_A3CliCod = new int[1] ;
      T004W14_A1EmpCod = new short[1] ;
      T004W14_A1649LSDSec = new int[1] ;
      T004W14_A1657LSD2Sec = new int[1] ;
      T004W14_A1666LSD3Sec = new short[1] ;
      T004W15_A3CliCod = new int[1] ;
      T004W15_A1EmpCod = new short[1] ;
      T004W15_A1649LSDSec = new int[1] ;
      T004W15_A1657LSD2Sec = new int[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXv_int5 = new int[1] ;
      T004W16_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.lsd_reg2__default(),
         new Object[] {
             new Object[] {
            T004W2_A1657LSD2Sec, T004W2_A1658LSD2cuilEmpleado_3_11, T004W2_A1659LSD2legajoEmpleado_14_10, T004W2_A1660LSD2dependenciaRevista_24_50, T004W2_A1661LSD2cbuEmpleado_74_22, T004W2_A1662LSD2diasLiquidados_96_3, T004W2_A1663LSD2fechaPago_99_8, T004W2_A1664LSD2fechaRubrica_107_8, T004W2_A1665LSD2formaPago_115_1, T004W2_A3CliCod,
            T004W2_A1EmpCod, T004W2_A1649LSDSec
            }
            , new Object[] {
            T004W3_A1657LSD2Sec, T004W3_A1658LSD2cuilEmpleado_3_11, T004W3_A1659LSD2legajoEmpleado_14_10, T004W3_A1660LSD2dependenciaRevista_24_50, T004W3_A1661LSD2cbuEmpleado_74_22, T004W3_A1662LSD2diasLiquidados_96_3, T004W3_A1663LSD2fechaPago_99_8, T004W3_A1664LSD2fechaRubrica_107_8, T004W3_A1665LSD2formaPago_115_1, T004W3_A3CliCod,
            T004W3_A1EmpCod, T004W3_A1649LSDSec
            }
            , new Object[] {
            T004W4_A3CliCod
            }
            , new Object[] {
            T004W5_A1657LSD2Sec, T004W5_A1658LSD2cuilEmpleado_3_11, T004W5_A1659LSD2legajoEmpleado_14_10, T004W5_A1660LSD2dependenciaRevista_24_50, T004W5_A1661LSD2cbuEmpleado_74_22, T004W5_A1662LSD2diasLiquidados_96_3, T004W5_A1663LSD2fechaPago_99_8, T004W5_A1664LSD2fechaRubrica_107_8, T004W5_A1665LSD2formaPago_115_1, T004W5_A3CliCod,
            T004W5_A1EmpCod, T004W5_A1649LSDSec
            }
            , new Object[] {
            T004W6_A3CliCod
            }
            , new Object[] {
            T004W7_A3CliCod, T004W7_A1EmpCod, T004W7_A1649LSDSec, T004W7_A1657LSD2Sec
            }
            , new Object[] {
            T004W8_A3CliCod, T004W8_A1EmpCod, T004W8_A1649LSDSec, T004W8_A1657LSD2Sec
            }
            , new Object[] {
            T004W9_A3CliCod, T004W9_A1EmpCod, T004W9_A1649LSDSec, T004W9_A1657LSD2Sec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T004W13_A3CliCod, T004W13_A1EmpCod, T004W13_A1649LSDSec, T004W13_A1657LSD2Sec, T004W13_A1674LSD4Sec
            }
            , new Object[] {
            T004W14_A3CliCod, T004W14_A1EmpCod, T004W14_A1649LSDSec, T004W14_A1657LSD2Sec, T004W14_A1666LSD3Sec
            }
            , new Object[] {
            T004W15_A3CliCod, T004W15_A1EmpCod, T004W15_A1649LSDSec, T004W15_A1657LSD2Sec
            }
            , new Object[] {
            T004W16_A3CliCod
            }
         }
      );
      AV16Pgmname = "LSD_reg2" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV8EmpCod ;
   private short Z1EmpCod ;
   private short Z1662LSD2diasLiquidados_96_3 ;
   private short A1EmpCod ;
   private short AV8EmpCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A1662LSD2diasLiquidados_96_3 ;
   private short RcdFound227 ;
   private short nIsDirty_227 ;
   private int wcpOAV7CliCod ;
   private int wcpOAV9LSDSec ;
   private int wcpOAV10LSD2Sec ;
   private int Z3CliCod ;
   private int Z1649LSDSec ;
   private int Z1657LSD2Sec ;
   private int AV7CliCod ;
   private int A3CliCod ;
   private int A1649LSDSec ;
   private int AV9LSDSec ;
   private int AV10LSD2Sec ;
   private int trnEnded ;
   private int edtLSD2cuilEmpleado_3_11_Enabled ;
   private int edtLSD2legajoEmpleado_14_10_Enabled ;
   private int edtLSD2dependenciaRevista_24_50_Enabled ;
   private int edtLSD2cbuEmpleado_74_22_Enabled ;
   private int edtLSD2diasLiquidados_96_3_Enabled ;
   private int edtLSD2fechaPago_99_8_Enabled ;
   private int edtLSD2fechaRubrica_107_8_Enabled ;
   private int edtLSD2formaPago_115_1_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Visible ;
   private int edtEmpCod_Enabled ;
   private int edtLSDSec_Visible ;
   private int edtLSDSec_Enabled ;
   private int A1657LSD2Sec ;
   private int edtLSD2Sec_Visible ;
   private int edtLSD2Sec_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private long Z1658LSD2cuilEmpleado_3_11 ;
   private long A1658LSD2cuilEmpleado_3_11 ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z1659LSD2legajoEmpleado_14_10 ;
   private String Z1660LSD2dependenciaRevista_24_50 ;
   private String Z1661LSD2cbuEmpleado_74_22 ;
   private String Z1665LSD2formaPago_115_1 ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtLSD2cuilEmpleado_3_11_Internalname ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String TempTags ;
   private String edtLSD2cuilEmpleado_3_11_Jsonclick ;
   private String edtLSD2legajoEmpleado_14_10_Internalname ;
   private String A1659LSD2legajoEmpleado_14_10 ;
   private String edtLSD2legajoEmpleado_14_10_Jsonclick ;
   private String edtLSD2dependenciaRevista_24_50_Internalname ;
   private String A1660LSD2dependenciaRevista_24_50 ;
   private String edtLSD2dependenciaRevista_24_50_Jsonclick ;
   private String edtLSD2cbuEmpleado_74_22_Internalname ;
   private String A1661LSD2cbuEmpleado_74_22 ;
   private String edtLSD2cbuEmpleado_74_22_Jsonclick ;
   private String edtLSD2diasLiquidados_96_3_Internalname ;
   private String edtLSD2diasLiquidados_96_3_Jsonclick ;
   private String edtLSD2fechaPago_99_8_Internalname ;
   private String edtLSD2fechaPago_99_8_Jsonclick ;
   private String edtLSD2fechaRubrica_107_8_Internalname ;
   private String edtLSD2fechaRubrica_107_8_Jsonclick ;
   private String edtLSD2formaPago_115_1_Internalname ;
   private String A1665LSD2formaPago_115_1 ;
   private String edtLSD2formaPago_115_1_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtLSDSec_Internalname ;
   private String edtLSDSec_Jsonclick ;
   private String edtLSD2Sec_Internalname ;
   private String edtLSD2Sec_Jsonclick ;
   private String AV16Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode227 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private java.util.Date Z1663LSD2fechaPago_99_8 ;
   private java.util.Date Z1664LSD2fechaRubrica_107_8 ;
   private java.util.Date A1663LSD2fechaPago_99_8 ;
   private java.util.Date A1664LSD2fechaRubrica_107_8 ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV12IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Gx_longc ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private int[] T004W5_A1657LSD2Sec ;
   private long[] T004W5_A1658LSD2cuilEmpleado_3_11 ;
   private String[] T004W5_A1659LSD2legajoEmpleado_14_10 ;
   private String[] T004W5_A1660LSD2dependenciaRevista_24_50 ;
   private String[] T004W5_A1661LSD2cbuEmpleado_74_22 ;
   private short[] T004W5_A1662LSD2diasLiquidados_96_3 ;
   private java.util.Date[] T004W5_A1663LSD2fechaPago_99_8 ;
   private java.util.Date[] T004W5_A1664LSD2fechaRubrica_107_8 ;
   private String[] T004W5_A1665LSD2formaPago_115_1 ;
   private int[] T004W5_A3CliCod ;
   private short[] T004W5_A1EmpCod ;
   private int[] T004W5_A1649LSDSec ;
   private int[] T004W4_A3CliCod ;
   private int[] T004W6_A3CliCod ;
   private int[] T004W7_A3CliCod ;
   private short[] T004W7_A1EmpCod ;
   private int[] T004W7_A1649LSDSec ;
   private int[] T004W7_A1657LSD2Sec ;
   private int[] T004W3_A1657LSD2Sec ;
   private long[] T004W3_A1658LSD2cuilEmpleado_3_11 ;
   private String[] T004W3_A1659LSD2legajoEmpleado_14_10 ;
   private String[] T004W3_A1660LSD2dependenciaRevista_24_50 ;
   private String[] T004W3_A1661LSD2cbuEmpleado_74_22 ;
   private short[] T004W3_A1662LSD2diasLiquidados_96_3 ;
   private java.util.Date[] T004W3_A1663LSD2fechaPago_99_8 ;
   private java.util.Date[] T004W3_A1664LSD2fechaRubrica_107_8 ;
   private String[] T004W3_A1665LSD2formaPago_115_1 ;
   private int[] T004W3_A3CliCod ;
   private short[] T004W3_A1EmpCod ;
   private int[] T004W3_A1649LSDSec ;
   private int[] T004W8_A3CliCod ;
   private short[] T004W8_A1EmpCod ;
   private int[] T004W8_A1649LSDSec ;
   private int[] T004W8_A1657LSD2Sec ;
   private int[] T004W9_A3CliCod ;
   private short[] T004W9_A1EmpCod ;
   private int[] T004W9_A1649LSDSec ;
   private int[] T004W9_A1657LSD2Sec ;
   private int[] T004W2_A1657LSD2Sec ;
   private long[] T004W2_A1658LSD2cuilEmpleado_3_11 ;
   private String[] T004W2_A1659LSD2legajoEmpleado_14_10 ;
   private String[] T004W2_A1660LSD2dependenciaRevista_24_50 ;
   private String[] T004W2_A1661LSD2cbuEmpleado_74_22 ;
   private short[] T004W2_A1662LSD2diasLiquidados_96_3 ;
   private java.util.Date[] T004W2_A1663LSD2fechaPago_99_8 ;
   private java.util.Date[] T004W2_A1664LSD2fechaRubrica_107_8 ;
   private String[] T004W2_A1665LSD2formaPago_115_1 ;
   private int[] T004W2_A3CliCod ;
   private short[] T004W2_A1EmpCod ;
   private int[] T004W2_A1649LSDSec ;
   private int[] T004W13_A3CliCod ;
   private short[] T004W13_A1EmpCod ;
   private int[] T004W13_A1649LSDSec ;
   private int[] T004W13_A1657LSD2Sec ;
   private short[] T004W13_A1674LSD4Sec ;
   private int[] T004W14_A3CliCod ;
   private short[] T004W14_A1EmpCod ;
   private int[] T004W14_A1649LSDSec ;
   private int[] T004W14_A1657LSD2Sec ;
   private short[] T004W14_A1666LSD3Sec ;
   private int[] T004W15_A3CliCod ;
   private short[] T004W15_A1EmpCod ;
   private int[] T004W15_A1649LSDSec ;
   private int[] T004W15_A1657LSD2Sec ;
   private int[] T004W16_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
}

final  class lsd_reg2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T004W2", "SELECT LSD2Sec, LSD2cuilEmpleado_3_11, LSD2legajoEmpleado_14_10, LSD2dependenciaRevista_24_50, LSD2cbuEmpleado_74_22, LSD2diasLiquidados_96_3, LSD2fechaPago_99_8, LSD2fechaRubrica_107_8, LSD2formaPago_115_1, CliCod, EmpCod, LSDSec FROM LSD_reg2 WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ?  FOR UPDATE OF LSD_reg2 NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004W3", "SELECT LSD2Sec, LSD2cuilEmpleado_3_11, LSD2legajoEmpleado_14_10, LSD2dependenciaRevista_24_50, LSD2cbuEmpleado_74_22, LSD2diasLiquidados_96_3, LSD2fechaPago_99_8, LSD2fechaRubrica_107_8, LSD2formaPago_115_1, CliCod, EmpCod, LSDSec FROM LSD_reg2 WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004W4", "SELECT CliCod FROM LSD_reg1 WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004W5", "SELECT TM1.LSD2Sec, TM1.LSD2cuilEmpleado_3_11, TM1.LSD2legajoEmpleado_14_10, TM1.LSD2dependenciaRevista_24_50, TM1.LSD2cbuEmpleado_74_22, TM1.LSD2diasLiquidados_96_3, TM1.LSD2fechaPago_99_8, TM1.LSD2fechaRubrica_107_8, TM1.LSD2formaPago_115_1, TM1.CliCod, TM1.EmpCod, TM1.LSDSec FROM LSD_reg2 TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LSDSec = ? and TM1.LSD2Sec = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LSDSec, TM1.LSD2Sec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004W6", "SELECT CliCod FROM LSD_reg1 WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004W7", "SELECT CliCod, EmpCod, LSDSec, LSD2Sec FROM LSD_reg2 WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004W8", "SELECT CliCod, EmpCod, LSDSec, LSD2Sec FROM LSD_reg2 WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and LSDSec > ? or LSDSec = ? and EmpCod = ? and CliCod = ? and LSD2Sec > ?) ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004W9", "SELECT CliCod, EmpCod, LSDSec, LSD2Sec FROM LSD_reg2 WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and LSDSec < ? or LSDSec = ? and EmpCod = ? and CliCod = ? and LSD2Sec < ?) ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T004W10", "SAVEPOINT gxupdate;INSERT INTO LSD_reg2(LSD2Sec, LSD2cuilEmpleado_3_11, LSD2legajoEmpleado_14_10, LSD2dependenciaRevista_24_50, LSD2cbuEmpleado_74_22, LSD2diasLiquidados_96_3, LSD2fechaPago_99_8, LSD2fechaRubrica_107_8, LSD2formaPago_115_1, CliCod, EmpCod, LSDSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004W11", "SAVEPOINT gxupdate;UPDATE LSD_reg2 SET LSD2cuilEmpleado_3_11=?, LSD2legajoEmpleado_14_10=?, LSD2dependenciaRevista_24_50=?, LSD2cbuEmpleado_74_22=?, LSD2diasLiquidados_96_3=?, LSD2fechaPago_99_8=?, LSD2fechaRubrica_107_8=?, LSD2formaPago_115_1=?  WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004W12", "SAVEPOINT gxupdate;DELETE FROM LSD_reg2  WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T004W13", "SELECT CliCod, EmpCod, LSDSec, LSD2Sec, LSD4Sec FROM LSD_reg4 WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004W14", "SELECT CliCod, EmpCod, LSDSec, LSD2Sec, LSD3Sec FROM LSD_reg3 WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004W15", "SELECT CliCod, EmpCod, LSDSec, LSD2Sec FROM LSD_reg2 ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004W16", "SELECT CliCod FROM LSD_reg1 WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((String[]) buf[3])[0] = rslt.getString(4, 50);
               ((String[]) buf[4])[0] = rslt.getString(5, 22);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((String[]) buf[3])[0] = rslt.getString(4, 50);
               ((String[]) buf[4])[0] = rslt.getString(5, 22);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((String[]) buf[3])[0] = rslt.getString(4, 50);
               ((String[]) buf[4])[0] = rslt.getString(5, 22);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setString(3, (String)parms[2], 10);
               stmt.setString(4, (String)parms[3], 50);
               stmt.setString(5, (String)parms[4], 22);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setDate(7, (java.util.Date)parms[6]);
               stmt.setDate(8, (java.util.Date)parms[7]);
               stmt.setString(9, (String)parms[8], 1);
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setInt(12, ((Number) parms[11]).intValue());
               return;
            case 9 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 50);
               stmt.setString(4, (String)parms[3], 22);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               stmt.setDate(7, (java.util.Date)parms[6]);
               stmt.setString(8, (String)parms[7], 1);
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setInt(12, ((Number) parms[11]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

