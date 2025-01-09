package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class lsd_reg3_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_17") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1649LSDSec = (int)(GXutil.lval( httpContext.GetPar( "LSDSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
         A1657LSD2Sec = (int)(GXutil.lval( httpContext.GetPar( "LSD2Sec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_17( A3CliCod, A1EmpCod, A1649LSDSec, A1657LSD2Sec) ;
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
            AV11LSD3Sec = (short)(GXutil.lval( httpContext.GetPar( "LSD3Sec"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11LSD3Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11LSD3Sec), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSD3SEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11LSD3Sec), "ZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "LSD_reg3", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public lsd_reg3_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public lsd_reg3_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( lsd_reg3_impl.class ));
   }

   public lsd_reg3_impl( int remoteHandle ,
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliCod_Internalname, httpContext.getMessage( "Cli Cod", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg3.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpCod_Internalname, httpContext.getMessage( "Empresa", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_LSD_reg3.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSDSec_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSDSec_Internalname, httpContext.getMessage( "LSDSec", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSDSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1649LSDSec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1649LSDSec), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSDSec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSDSec_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg3.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD2Sec_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD2Sec_Internalname, httpContext.getMessage( "LSD2 Sec", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD2Sec_Internalname, GXutil.ltrim( localUtil.ntoc( A1657LSD2Sec, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1657LSD2Sec), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD2Sec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD2Sec_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg3.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD3Sec_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD3Sec_Internalname, httpContext.getMessage( "Sec", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD3Sec_Internalname, GXutil.ltrim( localUtil.ntoc( A1666LSD3Sec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1666LSD3Sec), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,42);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD3Sec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD3Sec_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg3.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD3cuilEmpleado_3_11_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD3cuilEmpleado_3_11_Internalname, httpContext.getMessage( "CUIL", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD3cuilEmpleado_3_11_Internalname, GXutil.ltrim( localUtil.ntoc( A1667LSD3cuilEmpleado_3_11, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD3cuilEmpleado_3_11_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1667LSD3cuilEmpleado_3_11), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1667LSD3cuilEmpleado_3_11), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD3cuilEmpleado_3_11_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD3cuilEmpleado_3_11_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg3.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD3codigoConcepto_14_10_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD3codigoConcepto_14_10_Internalname, httpContext.getMessage( "Concepto", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD3codigoConcepto_14_10_Internalname, GXutil.rtrim( A1668LSD3codigoConcepto_14_10), GXutil.rtrim( localUtil.format( A1668LSD3codigoConcepto_14_10, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,52);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD3codigoConcepto_14_10_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD3codigoConcepto_14_10_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg3.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD3cantidadConcepto_24_5_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD3cantidadConcepto_24_5_Internalname, httpContext.getMessage( "Cantidad", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD3cantidadConcepto_24_5_Internalname, GXutil.ltrim( localUtil.ntoc( A1669LSD3cantidadConcepto_24_5, (byte)(6), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD3cantidadConcepto_24_5_Enabled!=0) ? localUtil.format( A1669LSD3cantidadConcepto_24_5, "ZZ9.99") : localUtil.format( A1669LSD3cantidadConcepto_24_5, "ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,57);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD3cantidadConcepto_24_5_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD3cantidadConcepto_24_5_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg3.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD3unidadesConcepto_29_1_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD3unidadesConcepto_29_1_Internalname, httpContext.getMessage( "Unidades", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD3unidadesConcepto_29_1_Internalname, GXutil.rtrim( A1670LSD3unidadesConcepto_29_1), GXutil.rtrim( localUtil.format( A1670LSD3unidadesConcepto_29_1, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,62);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD3unidadesConcepto_29_1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD3unidadesConcepto_29_1_Enabled, 0, "text", "", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg3.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD3importeConcepto_30_15_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD3importeConcepto_30_15_Internalname, httpContext.getMessage( "Importe", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD3importeConcepto_30_15_Internalname, GXutil.ltrim( localUtil.ntoc( A1671LSD3importeConcepto_30_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD3importeConcepto_30_15_Enabled!=0) ? localUtil.format( A1671LSD3importeConcepto_30_15, "ZZZZZZZZZZZZ9.99") : localUtil.format( A1671LSD3importeConcepto_30_15, "ZZZZZZZZZZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,67);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD3importeConcepto_30_15_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD3importeConcepto_30_15_Enabled, 0, "text", "", 16, "chr", 1, "row", 16, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg3.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD3debitoCredito_45_1_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD3debitoCredito_45_1_Internalname, httpContext.getMessage( "Débito/Crédito", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD3debitoCredito_45_1_Internalname, GXutil.rtrim( A1672LSD3debitoCredito_45_1), GXutil.rtrim( localUtil.format( A1672LSD3debitoCredito_45_1, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,72);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD3debitoCredito_45_1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD3debitoCredito_45_1_Enabled, 0, "text", "", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LSD_reg3.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLSD3periodoAjuste_46_6_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtLSD3periodoAjuste_46_6_Internalname, httpContext.getMessage( "Periodo ajuste", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtLSD3periodoAjuste_46_6_Internalname, GXutil.ltrim( localUtil.ntoc( A1673LSD3periodoAjuste_46_6, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtLSD3periodoAjuste_46_6_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1673LSD3periodoAjuste_46_6), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1673LSD3periodoAjuste_46_6), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,77);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLSD3periodoAjuste_46_6_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLSD3periodoAjuste_46_6_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LSD_reg3.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LSD_reg3.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LSD_reg3.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LSD_reg3.htm");
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
      e114X2 ();
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
            Z1666LSD3Sec = (short)(localUtil.ctol( httpContext.cgiGet( "Z1666LSD3Sec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1667LSD3cuilEmpleado_3_11 = localUtil.ctol( httpContext.cgiGet( "Z1667LSD3cuilEmpleado_3_11"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            Z1668LSD3codigoConcepto_14_10 = httpContext.cgiGet( "Z1668LSD3codigoConcepto_14_10") ;
            Z1669LSD3cantidadConcepto_24_5 = localUtil.ctond( httpContext.cgiGet( "Z1669LSD3cantidadConcepto_24_5")) ;
            Z1670LSD3unidadesConcepto_29_1 = httpContext.cgiGet( "Z1670LSD3unidadesConcepto_29_1") ;
            Z1671LSD3importeConcepto_30_15 = localUtil.ctond( httpContext.cgiGet( "Z1671LSD3importeConcepto_30_15")) ;
            Z1672LSD3debitoCredito_45_1 = httpContext.cgiGet( "Z1672LSD3debitoCredito_45_1") ;
            Z1673LSD3periodoAjuste_46_6 = (int)(localUtil.ctol( httpContext.cgiGet( "Z1673LSD3periodoAjuste_46_6"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9LSDSec = (int)(localUtil.ctol( httpContext.cgiGet( "vLSDSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV10LSD2Sec = (int)(localUtil.ctol( httpContext.cgiGet( "vLSD2SEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV11LSD3Sec = (short)(localUtil.ctol( httpContext.cgiGet( "vLSD3SEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV17Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLSD3Sec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLSD3Sec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD3SEC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD3Sec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1666LSD3Sec = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1666LSD3Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1666LSD3Sec), 4, 0));
            }
            else
            {
               A1666LSD3Sec = (short)(localUtil.ctol( httpContext.cgiGet( edtLSD3Sec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1666LSD3Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1666LSD3Sec), 4, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLSD3cuilEmpleado_3_11_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLSD3cuilEmpleado_3_11_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD3CUILEMPLEADO_3_11");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD3cuilEmpleado_3_11_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1667LSD3cuilEmpleado_3_11 = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A1667LSD3cuilEmpleado_3_11", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1667LSD3cuilEmpleado_3_11), 11, 0));
            }
            else
            {
               A1667LSD3cuilEmpleado_3_11 = localUtil.ctol( httpContext.cgiGet( edtLSD3cuilEmpleado_3_11_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1667LSD3cuilEmpleado_3_11", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1667LSD3cuilEmpleado_3_11), 11, 0));
            }
            A1668LSD3codigoConcepto_14_10 = httpContext.cgiGet( edtLSD3codigoConcepto_14_10_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1668LSD3codigoConcepto_14_10", A1668LSD3codigoConcepto_14_10);
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtLSD3cantidadConcepto_24_5_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD3cantidadConcepto_24_5_Internalname)), DecimalUtil.stringToDec("999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD3CANTIDADCONCEPTO_24_5");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD3cantidadConcepto_24_5_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1669LSD3cantidadConcepto_24_5 = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1669LSD3cantidadConcepto_24_5", GXutil.ltrimstr( A1669LSD3cantidadConcepto_24_5, 6, 2));
            }
            else
            {
               A1669LSD3cantidadConcepto_24_5 = localUtil.ctond( httpContext.cgiGet( edtLSD3cantidadConcepto_24_5_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1669LSD3cantidadConcepto_24_5", GXutil.ltrimstr( A1669LSD3cantidadConcepto_24_5, 6, 2));
            }
            A1670LSD3unidadesConcepto_29_1 = httpContext.cgiGet( edtLSD3unidadesConcepto_29_1_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1670LSD3unidadesConcepto_29_1", A1670LSD3unidadesConcepto_29_1);
            if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD3importeConcepto_30_15_Internalname)), DecimalUtil.stringToDec("-999999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtLSD3importeConcepto_30_15_Internalname)), DecimalUtil.stringToDec("9999999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD3IMPORTECONCEPTO_30_15");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD3importeConcepto_30_15_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1671LSD3importeConcepto_30_15 = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1671LSD3importeConcepto_30_15", GXutil.ltrimstr( A1671LSD3importeConcepto_30_15, 16, 2));
            }
            else
            {
               A1671LSD3importeConcepto_30_15 = localUtil.ctond( httpContext.cgiGet( edtLSD3importeConcepto_30_15_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1671LSD3importeConcepto_30_15", GXutil.ltrimstr( A1671LSD3importeConcepto_30_15, 16, 2));
            }
            A1672LSD3debitoCredito_45_1 = httpContext.cgiGet( edtLSD3debitoCredito_45_1_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1672LSD3debitoCredito_45_1", A1672LSD3debitoCredito_45_1);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLSD3periodoAjuste_46_6_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLSD3periodoAjuste_46_6_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LSD3PERIODOAJUSTE_46_6");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLSD3periodoAjuste_46_6_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1673LSD3periodoAjuste_46_6 = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A1673LSD3periodoAjuste_46_6", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1673LSD3periodoAjuste_46_6), 6, 0));
            }
            else
            {
               A1673LSD3periodoAjuste_46_6 = (int)(localUtil.ctol( httpContext.cgiGet( edtLSD3periodoAjuste_46_6_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1673LSD3periodoAjuste_46_6", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1673LSD3periodoAjuste_46_6), 6, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"LSD_reg3");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1649LSDSec != Z1649LSDSec ) || ( A1657LSD2Sec != Z1657LSD2Sec ) || ( A1666LSD3Sec != Z1666LSD3Sec ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("lsd_reg3:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1666LSD3Sec = (short)(GXutil.lval( httpContext.GetPar( "LSD3Sec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1666LSD3Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1666LSD3Sec), 4, 0));
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
                  sMode231 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode231 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound231 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_4X0( ) ;
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
                        e114X2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e124X2 ();
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
         e124X2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll4X231( ) ;
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
         disableAttributes4X231( ) ;
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

   public void confirm_4X0( )
   {
      beforeValidate4X231( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls4X231( ) ;
         }
         else
         {
            checkExtendedTable4X231( ) ;
            closeExtendedTableCursors4X231( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption4X0( )
   {
   }

   public void e114X2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV12WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV12WWPContext = GXv_SdtWWPContext1[0] ;
      AV13IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLSD_reg3_Insert", GXv_boolean3) ;
         lsd_reg3_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLSD_reg3_Update", GXv_boolean3) ;
         lsd_reg3_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLSD_reg3_Delete", GXv_boolean3) ;
         lsd_reg3_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV17Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV15TrnContext.fromxml(AV16WebSession.getValue("TrnContext"), null, null);
   }

   public void e124X2( )
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

   public void zm4X231( int GX_JID )
   {
      if ( ( GX_JID == 16 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1667LSD3cuilEmpleado_3_11 = T004X3_A1667LSD3cuilEmpleado_3_11[0] ;
            Z1668LSD3codigoConcepto_14_10 = T004X3_A1668LSD3codigoConcepto_14_10[0] ;
            Z1669LSD3cantidadConcepto_24_5 = T004X3_A1669LSD3cantidadConcepto_24_5[0] ;
            Z1670LSD3unidadesConcepto_29_1 = T004X3_A1670LSD3unidadesConcepto_29_1[0] ;
            Z1671LSD3importeConcepto_30_15 = T004X3_A1671LSD3importeConcepto_30_15[0] ;
            Z1672LSD3debitoCredito_45_1 = T004X3_A1672LSD3debitoCredito_45_1[0] ;
            Z1673LSD3periodoAjuste_46_6 = T004X3_A1673LSD3periodoAjuste_46_6[0] ;
         }
         else
         {
            Z1667LSD3cuilEmpleado_3_11 = A1667LSD3cuilEmpleado_3_11 ;
            Z1668LSD3codigoConcepto_14_10 = A1668LSD3codigoConcepto_14_10 ;
            Z1669LSD3cantidadConcepto_24_5 = A1669LSD3cantidadConcepto_24_5 ;
            Z1670LSD3unidadesConcepto_29_1 = A1670LSD3unidadesConcepto_29_1 ;
            Z1671LSD3importeConcepto_30_15 = A1671LSD3importeConcepto_30_15 ;
            Z1672LSD3debitoCredito_45_1 = A1672LSD3debitoCredito_45_1 ;
            Z1673LSD3periodoAjuste_46_6 = A1673LSD3periodoAjuste_46_6 ;
         }
      }
      if ( GX_JID == -16 )
      {
         Z1666LSD3Sec = A1666LSD3Sec ;
         Z1667LSD3cuilEmpleado_3_11 = A1667LSD3cuilEmpleado_3_11 ;
         Z1668LSD3codigoConcepto_14_10 = A1668LSD3codigoConcepto_14_10 ;
         Z1669LSD3cantidadConcepto_24_5 = A1669LSD3cantidadConcepto_24_5 ;
         Z1670LSD3unidadesConcepto_29_1 = A1670LSD3unidadesConcepto_29_1 ;
         Z1671LSD3importeConcepto_30_15 = A1671LSD3importeConcepto_30_15 ;
         Z1672LSD3debitoCredito_45_1 = A1672LSD3debitoCredito_45_1 ;
         Z1673LSD3periodoAjuste_46_6 = A1673LSD3periodoAjuste_46_6 ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1649LSDSec = A1649LSDSec ;
         Z1657LSD2Sec = A1657LSD2Sec ;
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
      if ( ! (0==AV11LSD3Sec) )
      {
         A1666LSD3Sec = AV11LSD3Sec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1666LSD3Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1666LSD3Sec), 4, 0));
      }
      if ( ! (0==AV11LSD3Sec) )
      {
         edtLSD3Sec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLSD3Sec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD3Sec_Enabled), 5, 0), true);
      }
      else
      {
         edtLSD3Sec_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLSD3Sec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD3Sec_Enabled), 5, 0), true);
      }
      if ( ! (0==AV11LSD3Sec) )
      {
         edtLSD3Sec_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLSD3Sec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD3Sec_Enabled), 5, 0), true);
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
         AV17Pgmname = "LSD_reg3" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17Pgmname", AV17Pgmname);
      }
   }

   public void load4X231( )
   {
      /* Using cursor T004X5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec), Short.valueOf(A1666LSD3Sec)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound231 = (short)(1) ;
         A1667LSD3cuilEmpleado_3_11 = T004X5_A1667LSD3cuilEmpleado_3_11[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1667LSD3cuilEmpleado_3_11", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1667LSD3cuilEmpleado_3_11), 11, 0));
         A1668LSD3codigoConcepto_14_10 = T004X5_A1668LSD3codigoConcepto_14_10[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1668LSD3codigoConcepto_14_10", A1668LSD3codigoConcepto_14_10);
         A1669LSD3cantidadConcepto_24_5 = T004X5_A1669LSD3cantidadConcepto_24_5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1669LSD3cantidadConcepto_24_5", GXutil.ltrimstr( A1669LSD3cantidadConcepto_24_5, 6, 2));
         A1670LSD3unidadesConcepto_29_1 = T004X5_A1670LSD3unidadesConcepto_29_1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1670LSD3unidadesConcepto_29_1", A1670LSD3unidadesConcepto_29_1);
         A1671LSD3importeConcepto_30_15 = T004X5_A1671LSD3importeConcepto_30_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1671LSD3importeConcepto_30_15", GXutil.ltrimstr( A1671LSD3importeConcepto_30_15, 16, 2));
         A1672LSD3debitoCredito_45_1 = T004X5_A1672LSD3debitoCredito_45_1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1672LSD3debitoCredito_45_1", A1672LSD3debitoCredito_45_1);
         A1673LSD3periodoAjuste_46_6 = T004X5_A1673LSD3periodoAjuste_46_6[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1673LSD3periodoAjuste_46_6", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1673LSD3periodoAjuste_46_6), 6, 0));
         zm4X231( -16) ;
      }
      pr_default.close(3);
      onLoadActions4X231( ) ;
   }

   public void onLoadActions4X231( )
   {
      AV17Pgmname = "LSD_reg3" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17Pgmname", AV17Pgmname);
   }

   public void checkExtendedTable4X231( )
   {
      nIsDirty_231 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV17Pgmname = "LSD_reg3" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17Pgmname", AV17Pgmname);
      /* Using cursor T004X4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "LSD_reg2", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LSD2SEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
   }

   public void closeExtendedTableCursors4X231( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_17( int A3CliCod ,
                          short A1EmpCod ,
                          int A1649LSDSec ,
                          int A1657LSD2Sec )
   {
      /* Using cursor T004X6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "LSD_reg2", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LSD2SEC");
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

   public void getKey4X231( )
   {
      /* Using cursor T004X7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec), Short.valueOf(A1666LSD3Sec)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound231 = (short)(1) ;
      }
      else
      {
         RcdFound231 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T004X3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec), Short.valueOf(A1666LSD3Sec)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm4X231( 16) ;
         RcdFound231 = (short)(1) ;
         A1666LSD3Sec = T004X3_A1666LSD3Sec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1666LSD3Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1666LSD3Sec), 4, 0));
         A1667LSD3cuilEmpleado_3_11 = T004X3_A1667LSD3cuilEmpleado_3_11[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1667LSD3cuilEmpleado_3_11", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1667LSD3cuilEmpleado_3_11), 11, 0));
         A1668LSD3codigoConcepto_14_10 = T004X3_A1668LSD3codigoConcepto_14_10[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1668LSD3codigoConcepto_14_10", A1668LSD3codigoConcepto_14_10);
         A1669LSD3cantidadConcepto_24_5 = T004X3_A1669LSD3cantidadConcepto_24_5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1669LSD3cantidadConcepto_24_5", GXutil.ltrimstr( A1669LSD3cantidadConcepto_24_5, 6, 2));
         A1670LSD3unidadesConcepto_29_1 = T004X3_A1670LSD3unidadesConcepto_29_1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1670LSD3unidadesConcepto_29_1", A1670LSD3unidadesConcepto_29_1);
         A1671LSD3importeConcepto_30_15 = T004X3_A1671LSD3importeConcepto_30_15[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1671LSD3importeConcepto_30_15", GXutil.ltrimstr( A1671LSD3importeConcepto_30_15, 16, 2));
         A1672LSD3debitoCredito_45_1 = T004X3_A1672LSD3debitoCredito_45_1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1672LSD3debitoCredito_45_1", A1672LSD3debitoCredito_45_1);
         A1673LSD3periodoAjuste_46_6 = T004X3_A1673LSD3periodoAjuste_46_6[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1673LSD3periodoAjuste_46_6", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1673LSD3periodoAjuste_46_6), 6, 0));
         A3CliCod = T004X3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T004X3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1649LSDSec = T004X3_A1649LSDSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
         A1657LSD2Sec = T004X3_A1657LSD2Sec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1649LSDSec = A1649LSDSec ;
         Z1657LSD2Sec = A1657LSD2Sec ;
         Z1666LSD3Sec = A1666LSD3Sec ;
         sMode231 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load4X231( ) ;
         if ( AnyError == 1 )
         {
            RcdFound231 = (short)(0) ;
            initializeNonKey4X231( ) ;
         }
         Gx_mode = sMode231 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound231 = (short)(0) ;
         initializeNonKey4X231( ) ;
         sMode231 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode231 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey4X231( ) ;
      if ( RcdFound231 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound231 = (short)(0) ;
      /* Using cursor T004X8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1649LSDSec), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A1657LSD2Sec), Integer.valueOf(A1657LSD2Sec), Integer.valueOf(A1649LSDSec), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A1666LSD3Sec)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T004X8_A3CliCod[0] < A3CliCod ) || ( T004X8_A3CliCod[0] == A3CliCod ) && ( T004X8_A1EmpCod[0] < A1EmpCod ) || ( T004X8_A1EmpCod[0] == A1EmpCod ) && ( T004X8_A3CliCod[0] == A3CliCod ) && ( T004X8_A1649LSDSec[0] < A1649LSDSec ) || ( T004X8_A1649LSDSec[0] == A1649LSDSec ) && ( T004X8_A1EmpCod[0] == A1EmpCod ) && ( T004X8_A3CliCod[0] == A3CliCod ) && ( T004X8_A1657LSD2Sec[0] < A1657LSD2Sec ) || ( T004X8_A1657LSD2Sec[0] == A1657LSD2Sec ) && ( T004X8_A1649LSDSec[0] == A1649LSDSec ) && ( T004X8_A1EmpCod[0] == A1EmpCod ) && ( T004X8_A3CliCod[0] == A3CliCod ) && ( T004X8_A1666LSD3Sec[0] < A1666LSD3Sec ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T004X8_A3CliCod[0] > A3CliCod ) || ( T004X8_A3CliCod[0] == A3CliCod ) && ( T004X8_A1EmpCod[0] > A1EmpCod ) || ( T004X8_A1EmpCod[0] == A1EmpCod ) && ( T004X8_A3CliCod[0] == A3CliCod ) && ( T004X8_A1649LSDSec[0] > A1649LSDSec ) || ( T004X8_A1649LSDSec[0] == A1649LSDSec ) && ( T004X8_A1EmpCod[0] == A1EmpCod ) && ( T004X8_A3CliCod[0] == A3CliCod ) && ( T004X8_A1657LSD2Sec[0] > A1657LSD2Sec ) || ( T004X8_A1657LSD2Sec[0] == A1657LSD2Sec ) && ( T004X8_A1649LSDSec[0] == A1649LSDSec ) && ( T004X8_A1EmpCod[0] == A1EmpCod ) && ( T004X8_A3CliCod[0] == A3CliCod ) && ( T004X8_A1666LSD3Sec[0] > A1666LSD3Sec ) ) )
         {
            A3CliCod = T004X8_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T004X8_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A1649LSDSec = T004X8_A1649LSDSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
            A1657LSD2Sec = T004X8_A1657LSD2Sec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
            A1666LSD3Sec = T004X8_A1666LSD3Sec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1666LSD3Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1666LSD3Sec), 4, 0));
            RcdFound231 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound231 = (short)(0) ;
      /* Using cursor T004X9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1649LSDSec), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A1657LSD2Sec), Integer.valueOf(A1657LSD2Sec), Integer.valueOf(A1649LSDSec), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Short.valueOf(A1666LSD3Sec)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T004X9_A3CliCod[0] > A3CliCod ) || ( T004X9_A3CliCod[0] == A3CliCod ) && ( T004X9_A1EmpCod[0] > A1EmpCod ) || ( T004X9_A1EmpCod[0] == A1EmpCod ) && ( T004X9_A3CliCod[0] == A3CliCod ) && ( T004X9_A1649LSDSec[0] > A1649LSDSec ) || ( T004X9_A1649LSDSec[0] == A1649LSDSec ) && ( T004X9_A1EmpCod[0] == A1EmpCod ) && ( T004X9_A3CliCod[0] == A3CliCod ) && ( T004X9_A1657LSD2Sec[0] > A1657LSD2Sec ) || ( T004X9_A1657LSD2Sec[0] == A1657LSD2Sec ) && ( T004X9_A1649LSDSec[0] == A1649LSDSec ) && ( T004X9_A1EmpCod[0] == A1EmpCod ) && ( T004X9_A3CliCod[0] == A3CliCod ) && ( T004X9_A1666LSD3Sec[0] > A1666LSD3Sec ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T004X9_A3CliCod[0] < A3CliCod ) || ( T004X9_A3CliCod[0] == A3CliCod ) && ( T004X9_A1EmpCod[0] < A1EmpCod ) || ( T004X9_A1EmpCod[0] == A1EmpCod ) && ( T004X9_A3CliCod[0] == A3CliCod ) && ( T004X9_A1649LSDSec[0] < A1649LSDSec ) || ( T004X9_A1649LSDSec[0] == A1649LSDSec ) && ( T004X9_A1EmpCod[0] == A1EmpCod ) && ( T004X9_A3CliCod[0] == A3CliCod ) && ( T004X9_A1657LSD2Sec[0] < A1657LSD2Sec ) || ( T004X9_A1657LSD2Sec[0] == A1657LSD2Sec ) && ( T004X9_A1649LSDSec[0] == A1649LSDSec ) && ( T004X9_A1EmpCod[0] == A1EmpCod ) && ( T004X9_A3CliCod[0] == A3CliCod ) && ( T004X9_A1666LSD3Sec[0] < A1666LSD3Sec ) ) )
         {
            A3CliCod = T004X9_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T004X9_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A1649LSDSec = T004X9_A1649LSDSec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
            A1657LSD2Sec = T004X9_A1657LSD2Sec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
            A1666LSD3Sec = T004X9_A1666LSD3Sec[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1666LSD3Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1666LSD3Sec), 4, 0));
            RcdFound231 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey4X231( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert4X231( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound231 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1649LSDSec != Z1649LSDSec ) || ( A1657LSD2Sec != Z1657LSD2Sec ) || ( A1666LSD3Sec != Z1666LSD3Sec ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A1649LSDSec = Z1649LSDSec ;
               httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
               A1657LSD2Sec = Z1657LSD2Sec ;
               httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
               A1666LSD3Sec = Z1666LSD3Sec ;
               httpContext.ajax_rsp_assign_attri("", false, "A1666LSD3Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1666LSD3Sec), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update4X231( ) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1649LSDSec != Z1649LSDSec ) || ( A1657LSD2Sec != Z1657LSD2Sec ) || ( A1666LSD3Sec != Z1666LSD3Sec ) )
            {
               /* Insert record */
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert4X231( ) ;
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
                  GX_FocusControl = edtCliCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert4X231( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1649LSDSec != Z1649LSDSec ) || ( A1657LSD2Sec != Z1657LSD2Sec ) || ( A1666LSD3Sec != Z1666LSD3Sec ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1649LSDSec = Z1649LSDSec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
         A1657LSD2Sec = Z1657LSD2Sec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
         A1666LSD3Sec = Z1666LSD3Sec ;
         httpContext.ajax_rsp_assign_attri("", false, "A1666LSD3Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1666LSD3Sec), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency4X231( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T004X2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec), Short.valueOf(A1666LSD3Sec)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LSD_reg3"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z1667LSD3cuilEmpleado_3_11 != T004X2_A1667LSD3cuilEmpleado_3_11[0] ) || ( GXutil.strcmp(Z1668LSD3codigoConcepto_14_10, T004X2_A1668LSD3codigoConcepto_14_10[0]) != 0 ) || ( DecimalUtil.compareTo(Z1669LSD3cantidadConcepto_24_5, T004X2_A1669LSD3cantidadConcepto_24_5[0]) != 0 ) || ( GXutil.strcmp(Z1670LSD3unidadesConcepto_29_1, T004X2_A1670LSD3unidadesConcepto_29_1[0]) != 0 ) || ( DecimalUtil.compareTo(Z1671LSD3importeConcepto_30_15, T004X2_A1671LSD3importeConcepto_30_15[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1672LSD3debitoCredito_45_1, T004X2_A1672LSD3debitoCredito_45_1[0]) != 0 ) || ( Z1673LSD3periodoAjuste_46_6 != T004X2_A1673LSD3periodoAjuste_46_6[0] ) )
         {
            if ( Z1667LSD3cuilEmpleado_3_11 != T004X2_A1667LSD3cuilEmpleado_3_11[0] )
            {
               GXutil.writeLogln("lsd_reg3:[seudo value changed for attri]"+"LSD3cuilEmpleado_3_11");
               GXutil.writeLogRaw("Old: ",Z1667LSD3cuilEmpleado_3_11);
               GXutil.writeLogRaw("Current: ",T004X2_A1667LSD3cuilEmpleado_3_11[0]);
            }
            if ( GXutil.strcmp(Z1668LSD3codigoConcepto_14_10, T004X2_A1668LSD3codigoConcepto_14_10[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg3:[seudo value changed for attri]"+"LSD3codigoConcepto_14_10");
               GXutil.writeLogRaw("Old: ",Z1668LSD3codigoConcepto_14_10);
               GXutil.writeLogRaw("Current: ",T004X2_A1668LSD3codigoConcepto_14_10[0]);
            }
            if ( DecimalUtil.compareTo(Z1669LSD3cantidadConcepto_24_5, T004X2_A1669LSD3cantidadConcepto_24_5[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg3:[seudo value changed for attri]"+"LSD3cantidadConcepto_24_5");
               GXutil.writeLogRaw("Old: ",Z1669LSD3cantidadConcepto_24_5);
               GXutil.writeLogRaw("Current: ",T004X2_A1669LSD3cantidadConcepto_24_5[0]);
            }
            if ( GXutil.strcmp(Z1670LSD3unidadesConcepto_29_1, T004X2_A1670LSD3unidadesConcepto_29_1[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg3:[seudo value changed for attri]"+"LSD3unidadesConcepto_29_1");
               GXutil.writeLogRaw("Old: ",Z1670LSD3unidadesConcepto_29_1);
               GXutil.writeLogRaw("Current: ",T004X2_A1670LSD3unidadesConcepto_29_1[0]);
            }
            if ( DecimalUtil.compareTo(Z1671LSD3importeConcepto_30_15, T004X2_A1671LSD3importeConcepto_30_15[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg3:[seudo value changed for attri]"+"LSD3importeConcepto_30_15");
               GXutil.writeLogRaw("Old: ",Z1671LSD3importeConcepto_30_15);
               GXutil.writeLogRaw("Current: ",T004X2_A1671LSD3importeConcepto_30_15[0]);
            }
            if ( GXutil.strcmp(Z1672LSD3debitoCredito_45_1, T004X2_A1672LSD3debitoCredito_45_1[0]) != 0 )
            {
               GXutil.writeLogln("lsd_reg3:[seudo value changed for attri]"+"LSD3debitoCredito_45_1");
               GXutil.writeLogRaw("Old: ",Z1672LSD3debitoCredito_45_1);
               GXutil.writeLogRaw("Current: ",T004X2_A1672LSD3debitoCredito_45_1[0]);
            }
            if ( Z1673LSD3periodoAjuste_46_6 != T004X2_A1673LSD3periodoAjuste_46_6[0] )
            {
               GXutil.writeLogln("lsd_reg3:[seudo value changed for attri]"+"LSD3periodoAjuste_46_6");
               GXutil.writeLogRaw("Old: ",Z1673LSD3periodoAjuste_46_6);
               GXutil.writeLogRaw("Current: ",T004X2_A1673LSD3periodoAjuste_46_6[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"LSD_reg3"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert4X231( )
   {
      beforeValidate4X231( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4X231( ) ;
      }
      if ( AnyError == 0 )
      {
         zm4X231( 0) ;
         checkOptimisticConcurrency4X231( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4X231( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert4X231( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004X10 */
                  pr_default.execute(8, new Object[] {Short.valueOf(A1666LSD3Sec), Long.valueOf(A1667LSD3cuilEmpleado_3_11), A1668LSD3codigoConcepto_14_10, A1669LSD3cantidadConcepto_24_5, A1670LSD3unidadesConcepto_29_1, A1671LSD3importeConcepto_30_15, A1672LSD3debitoCredito_45_1, Integer.valueOf(A1673LSD3periodoAjuste_46_6), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LSD_reg3");
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
                        resetCaption4X0( ) ;
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
            load4X231( ) ;
         }
         endLevel4X231( ) ;
      }
      closeExtendedTableCursors4X231( ) ;
   }

   public void update4X231( )
   {
      beforeValidate4X231( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4X231( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4X231( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4X231( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate4X231( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004X11 */
                  pr_default.execute(9, new Object[] {Long.valueOf(A1667LSD3cuilEmpleado_3_11), A1668LSD3codigoConcepto_14_10, A1669LSD3cantidadConcepto_24_5, A1670LSD3unidadesConcepto_29_1, A1671LSD3importeConcepto_30_15, A1672LSD3debitoCredito_45_1, Integer.valueOf(A1673LSD3periodoAjuste_46_6), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec), Short.valueOf(A1666LSD3Sec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LSD_reg3");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LSD_reg3"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate4X231( ) ;
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
         endLevel4X231( ) ;
      }
      closeExtendedTableCursors4X231( ) ;
   }

   public void deferredUpdate4X231( )
   {
   }

   public void delete( )
   {
      beforeValidate4X231( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4X231( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls4X231( ) ;
         afterConfirm4X231( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete4X231( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T004X12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec), Short.valueOf(A1666LSD3Sec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LSD_reg3");
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
      sMode231 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel4X231( ) ;
      Gx_mode = sMode231 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls4X231( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV17Pgmname = "LSD_reg3" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17Pgmname", AV17Pgmname);
      }
   }

   public void endLevel4X231( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete4X231( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "lsd_reg3");
         if ( AnyError == 0 )
         {
            confirmValues4X0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "lsd_reg3");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart4X231( )
   {
      /* Scan By routine */
      /* Using cursor T004X13 */
      pr_default.execute(11);
      RcdFound231 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound231 = (short)(1) ;
         A3CliCod = T004X13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T004X13_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1649LSDSec = T004X13_A1649LSDSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
         A1657LSD2Sec = T004X13_A1657LSD2Sec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
         A1666LSD3Sec = T004X13_A1666LSD3Sec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1666LSD3Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1666LSD3Sec), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext4X231( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound231 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound231 = (short)(1) ;
         A3CliCod = T004X13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T004X13_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1649LSDSec = T004X13_A1649LSDSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
         A1657LSD2Sec = T004X13_A1657LSD2Sec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
         A1666LSD3Sec = T004X13_A1666LSD3Sec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1666LSD3Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1666LSD3Sec), 4, 0));
      }
   }

   public void scanEnd4X231( )
   {
      pr_default.close(11);
   }

   public void afterConfirm4X231( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert4X231( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate4X231( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete4X231( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete4X231( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate4X231( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes4X231( )
   {
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtLSDSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSDSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSDSec_Enabled), 5, 0), true);
      edtLSD2Sec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD2Sec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD2Sec_Enabled), 5, 0), true);
      edtLSD3Sec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD3Sec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD3Sec_Enabled), 5, 0), true);
      edtLSD3cuilEmpleado_3_11_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD3cuilEmpleado_3_11_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD3cuilEmpleado_3_11_Enabled), 5, 0), true);
      edtLSD3codigoConcepto_14_10_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD3codigoConcepto_14_10_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD3codigoConcepto_14_10_Enabled), 5, 0), true);
      edtLSD3cantidadConcepto_24_5_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD3cantidadConcepto_24_5_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD3cantidadConcepto_24_5_Enabled), 5, 0), true);
      edtLSD3unidadesConcepto_29_1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD3unidadesConcepto_29_1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD3unidadesConcepto_29_1_Enabled), 5, 0), true);
      edtLSD3importeConcepto_30_15_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD3importeConcepto_30_15_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD3importeConcepto_30_15_Enabled), 5, 0), true);
      edtLSD3debitoCredito_45_1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD3debitoCredito_45_1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD3debitoCredito_45_1_Enabled), 5, 0), true);
      edtLSD3periodoAjuste_46_6_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLSD3periodoAjuste_46_6_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLSD3periodoAjuste_46_6_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes4X231( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues4X0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.lsd_reg3", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9LSDSec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10LSD2Sec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11LSD3Sec,4,0))}, new String[] {"Gx_mode","CliCod","EmpCod","LSDSec","LSD2Sec","LSD3Sec"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"LSD_reg3");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("lsd_reg3:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
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
      web.GxWebStd.gx_hidden_field( httpContext, "Z1666LSD3Sec", GXutil.ltrim( localUtil.ntoc( Z1666LSD3Sec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1667LSD3cuilEmpleado_3_11", GXutil.ltrim( localUtil.ntoc( Z1667LSD3cuilEmpleado_3_11, (byte)(11), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1668LSD3codigoConcepto_14_10", GXutil.rtrim( Z1668LSD3codigoConcepto_14_10));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1669LSD3cantidadConcepto_24_5", GXutil.ltrim( localUtil.ntoc( Z1669LSD3cantidadConcepto_24_5, (byte)(6), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1670LSD3unidadesConcepto_29_1", GXutil.rtrim( Z1670LSD3unidadesConcepto_29_1));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1671LSD3importeConcepto_30_15", GXutil.ltrim( localUtil.ntoc( Z1671LSD3importeConcepto_30_15, (byte)(16), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1672LSD3debitoCredito_45_1", GXutil.rtrim( Z1672LSD3debitoCredito_45_1));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1673LSD3periodoAjuste_46_6", GXutil.ltrim( localUtil.ntoc( Z1673LSD3periodoAjuste_46_6, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
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
      web.GxWebStd.gx_hidden_field( httpContext, "vLSD3SEC", GXutil.ltrim( localUtil.ntoc( AV11LSD3Sec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLSD3SEC", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11LSD3Sec), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV17Pgmname));
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
      return formatLink("web.lsd_reg3", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9LSDSec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV10LSD2Sec,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11LSD3Sec,4,0))}, new String[] {"Gx_mode","CliCod","EmpCod","LSDSec","LSD2Sec","LSD3Sec"})  ;
   }

   public String getPgmname( )
   {
      return "LSD_reg3" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "LSD_reg3", "") ;
   }

   public void initializeNonKey4X231( )
   {
      A1667LSD3cuilEmpleado_3_11 = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1667LSD3cuilEmpleado_3_11", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1667LSD3cuilEmpleado_3_11), 11, 0));
      A1668LSD3codigoConcepto_14_10 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1668LSD3codigoConcepto_14_10", A1668LSD3codigoConcepto_14_10);
      A1669LSD3cantidadConcepto_24_5 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1669LSD3cantidadConcepto_24_5", GXutil.ltrimstr( A1669LSD3cantidadConcepto_24_5, 6, 2));
      A1670LSD3unidadesConcepto_29_1 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1670LSD3unidadesConcepto_29_1", A1670LSD3unidadesConcepto_29_1);
      A1671LSD3importeConcepto_30_15 = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1671LSD3importeConcepto_30_15", GXutil.ltrimstr( A1671LSD3importeConcepto_30_15, 16, 2));
      A1672LSD3debitoCredito_45_1 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1672LSD3debitoCredito_45_1", A1672LSD3debitoCredito_45_1);
      A1673LSD3periodoAjuste_46_6 = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1673LSD3periodoAjuste_46_6", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1673LSD3periodoAjuste_46_6), 6, 0));
      Z1667LSD3cuilEmpleado_3_11 = 0 ;
      Z1668LSD3codigoConcepto_14_10 = "" ;
      Z1669LSD3cantidadConcepto_24_5 = DecimalUtil.ZERO ;
      Z1670LSD3unidadesConcepto_29_1 = "" ;
      Z1671LSD3importeConcepto_30_15 = DecimalUtil.ZERO ;
      Z1672LSD3debitoCredito_45_1 = "" ;
      Z1673LSD3periodoAjuste_46_6 = 0 ;
   }

   public void initAll4X231( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A1649LSDSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1649LSDSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1649LSDSec), 8, 0));
      A1657LSD2Sec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1657LSD2Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1657LSD2Sec), 8, 0));
      A1666LSD3Sec = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1666LSD3Sec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1666LSD3Sec), 4, 0));
      initializeNonKey4X231( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void define_styles( )
   {
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412202026410", true, true);
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
      httpContext.AddJavascriptSource("gxdec.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("lsd_reg3.js", "?202412202026410", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtLSDSec_Internalname = "LSDSEC" ;
      edtLSD2Sec_Internalname = "LSD2SEC" ;
      edtLSD3Sec_Internalname = "LSD3SEC" ;
      edtLSD3cuilEmpleado_3_11_Internalname = "LSD3CUILEMPLEADO_3_11" ;
      edtLSD3codigoConcepto_14_10_Internalname = "LSD3CODIGOCONCEPTO_14_10" ;
      edtLSD3cantidadConcepto_24_5_Internalname = "LSD3CANTIDADCONCEPTO_24_5" ;
      edtLSD3unidadesConcepto_29_1_Internalname = "LSD3UNIDADESCONCEPTO_29_1" ;
      edtLSD3importeConcepto_30_15_Internalname = "LSD3IMPORTECONCEPTO_30_15" ;
      edtLSD3debitoCredito_45_1_Internalname = "LSD3DEBITOCREDITO_45_1" ;
      edtLSD3periodoAjuste_46_6_Internalname = "LSD3PERIODOAJUSTE_46_6" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
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
      Form.setCaption( httpContext.getMessage( "LSD_reg3", "") );
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtLSD3periodoAjuste_46_6_Jsonclick = "" ;
      edtLSD3periodoAjuste_46_6_Enabled = 1 ;
      edtLSD3debitoCredito_45_1_Jsonclick = "" ;
      edtLSD3debitoCredito_45_1_Enabled = 1 ;
      edtLSD3importeConcepto_30_15_Jsonclick = "" ;
      edtLSD3importeConcepto_30_15_Enabled = 1 ;
      edtLSD3unidadesConcepto_29_1_Jsonclick = "" ;
      edtLSD3unidadesConcepto_29_1_Enabled = 1 ;
      edtLSD3cantidadConcepto_24_5_Jsonclick = "" ;
      edtLSD3cantidadConcepto_24_5_Enabled = 1 ;
      edtLSD3codigoConcepto_14_10_Jsonclick = "" ;
      edtLSD3codigoConcepto_14_10_Enabled = 1 ;
      edtLSD3cuilEmpleado_3_11_Jsonclick = "" ;
      edtLSD3cuilEmpleado_3_11_Enabled = 1 ;
      edtLSD3Sec_Jsonclick = "" ;
      edtLSD3Sec_Enabled = 1 ;
      edtLSD2Sec_Jsonclick = "" ;
      edtLSD2Sec_Enabled = 1 ;
      edtLSDSec_Jsonclick = "" ;
      edtLSDSec_Enabled = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Enabled = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
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

   public void valid_Lsd2sec( )
   {
      /* Using cursor T004X14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "LSD_reg2", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LSD2SEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(12);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LSDSec',fld:'vLSDSEC',pic:'ZZZZZZZ9',hsh:true},{av:'AV10LSD2Sec',fld:'vLSD2SEC',pic:'ZZZZZZZ9',hsh:true},{av:'AV11LSD3Sec',fld:'vLSD3SEC',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9LSDSec',fld:'vLSDSEC',pic:'ZZZZZZZ9',hsh:true},{av:'AV10LSD2Sec',fld:'vLSD2SEC',pic:'ZZZZZZZ9',hsh:true},{av:'AV11LSD3Sec',fld:'vLSD3SEC',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e124X2',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_LSDSEC","{handler:'valid_Lsdsec',iparms:[]");
      setEventMetadata("VALID_LSDSEC",",oparms:[]}");
      setEventMetadata("VALID_LSD2SEC","{handler:'valid_Lsd2sec',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1649LSDSec',fld:'LSDSEC',pic:'ZZZZZZZ9'},{av:'A1657LSD2Sec',fld:'LSD2SEC',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VALID_LSD2SEC",",oparms:[]}");
      setEventMetadata("VALID_LSD3SEC","{handler:'valid_Lsd3sec',iparms:[]");
      setEventMetadata("VALID_LSD3SEC",",oparms:[]}");
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
      pr_default.close(12);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z1668LSD3codigoConcepto_14_10 = "" ;
      Z1669LSD3cantidadConcepto_24_5 = DecimalUtil.ZERO ;
      Z1670LSD3unidadesConcepto_29_1 = "" ;
      Z1671LSD3importeConcepto_30_15 = DecimalUtil.ZERO ;
      Z1672LSD3debitoCredito_45_1 = "" ;
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
      A1668LSD3codigoConcepto_14_10 = "" ;
      A1669LSD3cantidadConcepto_24_5 = DecimalUtil.ZERO ;
      A1670LSD3unidadesConcepto_29_1 = "" ;
      A1671LSD3importeConcepto_30_15 = DecimalUtil.ZERO ;
      A1672LSD3debitoCredito_45_1 = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV17Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode231 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV12WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV15TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV16WebSession = httpContext.getWebSession();
      T004X5_A1666LSD3Sec = new short[1] ;
      T004X5_A1667LSD3cuilEmpleado_3_11 = new long[1] ;
      T004X5_A1668LSD3codigoConcepto_14_10 = new String[] {""} ;
      T004X5_A1669LSD3cantidadConcepto_24_5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004X5_A1670LSD3unidadesConcepto_29_1 = new String[] {""} ;
      T004X5_A1671LSD3importeConcepto_30_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004X5_A1672LSD3debitoCredito_45_1 = new String[] {""} ;
      T004X5_A1673LSD3periodoAjuste_46_6 = new int[1] ;
      T004X5_A3CliCod = new int[1] ;
      T004X5_A1EmpCod = new short[1] ;
      T004X5_A1649LSDSec = new int[1] ;
      T004X5_A1657LSD2Sec = new int[1] ;
      T004X4_A3CliCod = new int[1] ;
      T004X6_A3CliCod = new int[1] ;
      T004X7_A3CliCod = new int[1] ;
      T004X7_A1EmpCod = new short[1] ;
      T004X7_A1649LSDSec = new int[1] ;
      T004X7_A1657LSD2Sec = new int[1] ;
      T004X7_A1666LSD3Sec = new short[1] ;
      T004X3_A1666LSD3Sec = new short[1] ;
      T004X3_A1667LSD3cuilEmpleado_3_11 = new long[1] ;
      T004X3_A1668LSD3codigoConcepto_14_10 = new String[] {""} ;
      T004X3_A1669LSD3cantidadConcepto_24_5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004X3_A1670LSD3unidadesConcepto_29_1 = new String[] {""} ;
      T004X3_A1671LSD3importeConcepto_30_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004X3_A1672LSD3debitoCredito_45_1 = new String[] {""} ;
      T004X3_A1673LSD3periodoAjuste_46_6 = new int[1] ;
      T004X3_A3CliCod = new int[1] ;
      T004X3_A1EmpCod = new short[1] ;
      T004X3_A1649LSDSec = new int[1] ;
      T004X3_A1657LSD2Sec = new int[1] ;
      T004X8_A3CliCod = new int[1] ;
      T004X8_A1EmpCod = new short[1] ;
      T004X8_A1649LSDSec = new int[1] ;
      T004X8_A1657LSD2Sec = new int[1] ;
      T004X8_A1666LSD3Sec = new short[1] ;
      T004X9_A3CliCod = new int[1] ;
      T004X9_A1EmpCod = new short[1] ;
      T004X9_A1649LSDSec = new int[1] ;
      T004X9_A1657LSD2Sec = new int[1] ;
      T004X9_A1666LSD3Sec = new short[1] ;
      T004X2_A1666LSD3Sec = new short[1] ;
      T004X2_A1667LSD3cuilEmpleado_3_11 = new long[1] ;
      T004X2_A1668LSD3codigoConcepto_14_10 = new String[] {""} ;
      T004X2_A1669LSD3cantidadConcepto_24_5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004X2_A1670LSD3unidadesConcepto_29_1 = new String[] {""} ;
      T004X2_A1671LSD3importeConcepto_30_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004X2_A1672LSD3debitoCredito_45_1 = new String[] {""} ;
      T004X2_A1673LSD3periodoAjuste_46_6 = new int[1] ;
      T004X2_A3CliCod = new int[1] ;
      T004X2_A1EmpCod = new short[1] ;
      T004X2_A1649LSDSec = new int[1] ;
      T004X2_A1657LSD2Sec = new int[1] ;
      T004X13_A3CliCod = new int[1] ;
      T004X13_A1EmpCod = new short[1] ;
      T004X13_A1649LSDSec = new int[1] ;
      T004X13_A1657LSD2Sec = new int[1] ;
      T004X13_A1666LSD3Sec = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T004X14_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.lsd_reg3__default(),
         new Object[] {
             new Object[] {
            T004X2_A1666LSD3Sec, T004X2_A1667LSD3cuilEmpleado_3_11, T004X2_A1668LSD3codigoConcepto_14_10, T004X2_A1669LSD3cantidadConcepto_24_5, T004X2_A1670LSD3unidadesConcepto_29_1, T004X2_A1671LSD3importeConcepto_30_15, T004X2_A1672LSD3debitoCredito_45_1, T004X2_A1673LSD3periodoAjuste_46_6, T004X2_A3CliCod, T004X2_A1EmpCod,
            T004X2_A1649LSDSec, T004X2_A1657LSD2Sec
            }
            , new Object[] {
            T004X3_A1666LSD3Sec, T004X3_A1667LSD3cuilEmpleado_3_11, T004X3_A1668LSD3codigoConcepto_14_10, T004X3_A1669LSD3cantidadConcepto_24_5, T004X3_A1670LSD3unidadesConcepto_29_1, T004X3_A1671LSD3importeConcepto_30_15, T004X3_A1672LSD3debitoCredito_45_1, T004X3_A1673LSD3periodoAjuste_46_6, T004X3_A3CliCod, T004X3_A1EmpCod,
            T004X3_A1649LSDSec, T004X3_A1657LSD2Sec
            }
            , new Object[] {
            T004X4_A3CliCod
            }
            , new Object[] {
            T004X5_A1666LSD3Sec, T004X5_A1667LSD3cuilEmpleado_3_11, T004X5_A1668LSD3codigoConcepto_14_10, T004X5_A1669LSD3cantidadConcepto_24_5, T004X5_A1670LSD3unidadesConcepto_29_1, T004X5_A1671LSD3importeConcepto_30_15, T004X5_A1672LSD3debitoCredito_45_1, T004X5_A1673LSD3periodoAjuste_46_6, T004X5_A3CliCod, T004X5_A1EmpCod,
            T004X5_A1649LSDSec, T004X5_A1657LSD2Sec
            }
            , new Object[] {
            T004X6_A3CliCod
            }
            , new Object[] {
            T004X7_A3CliCod, T004X7_A1EmpCod, T004X7_A1649LSDSec, T004X7_A1657LSD2Sec, T004X7_A1666LSD3Sec
            }
            , new Object[] {
            T004X8_A3CliCod, T004X8_A1EmpCod, T004X8_A1649LSDSec, T004X8_A1657LSD2Sec, T004X8_A1666LSD3Sec
            }
            , new Object[] {
            T004X9_A3CliCod, T004X9_A1EmpCod, T004X9_A1649LSDSec, T004X9_A1657LSD2Sec, T004X9_A1666LSD3Sec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T004X13_A3CliCod, T004X13_A1EmpCod, T004X13_A1649LSDSec, T004X13_A1657LSD2Sec, T004X13_A1666LSD3Sec
            }
            , new Object[] {
            T004X14_A3CliCod
            }
         }
      );
      AV17Pgmname = "LSD_reg3" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV8EmpCod ;
   private short wcpOAV11LSD3Sec ;
   private short Z1EmpCod ;
   private short Z1666LSD3Sec ;
   private short A1EmpCod ;
   private short AV8EmpCod ;
   private short AV11LSD3Sec ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A1666LSD3Sec ;
   private short RcdFound231 ;
   private short nIsDirty_231 ;
   private int wcpOAV7CliCod ;
   private int wcpOAV9LSDSec ;
   private int wcpOAV10LSD2Sec ;
   private int Z3CliCod ;
   private int Z1649LSDSec ;
   private int Z1657LSD2Sec ;
   private int Z1673LSD3periodoAjuste_46_6 ;
   private int A3CliCod ;
   private int A1649LSDSec ;
   private int A1657LSD2Sec ;
   private int AV7CliCod ;
   private int AV9LSDSec ;
   private int AV10LSD2Sec ;
   private int trnEnded ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Enabled ;
   private int edtLSDSec_Enabled ;
   private int edtLSD2Sec_Enabled ;
   private int edtLSD3Sec_Enabled ;
   private int edtLSD3cuilEmpleado_3_11_Enabled ;
   private int edtLSD3codigoConcepto_14_10_Enabled ;
   private int edtLSD3cantidadConcepto_24_5_Enabled ;
   private int edtLSD3unidadesConcepto_29_1_Enabled ;
   private int edtLSD3importeConcepto_30_15_Enabled ;
   private int edtLSD3debitoCredito_45_1_Enabled ;
   private int A1673LSD3periodoAjuste_46_6 ;
   private int edtLSD3periodoAjuste_46_6_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private long Z1667LSD3cuilEmpleado_3_11 ;
   private long A1667LSD3cuilEmpleado_3_11 ;
   private java.math.BigDecimal Z1669LSD3cantidadConcepto_24_5 ;
   private java.math.BigDecimal Z1671LSD3importeConcepto_30_15 ;
   private java.math.BigDecimal A1669LSD3cantidadConcepto_24_5 ;
   private java.math.BigDecimal A1671LSD3importeConcepto_30_15 ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z1668LSD3codigoConcepto_14_10 ;
   private String Z1670LSD3unidadesConcepto_29_1 ;
   private String Z1672LSD3debitoCredito_45_1 ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCliCod_Internalname ;
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
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtLSDSec_Internalname ;
   private String edtLSDSec_Jsonclick ;
   private String edtLSD2Sec_Internalname ;
   private String edtLSD2Sec_Jsonclick ;
   private String edtLSD3Sec_Internalname ;
   private String edtLSD3Sec_Jsonclick ;
   private String edtLSD3cuilEmpleado_3_11_Internalname ;
   private String edtLSD3cuilEmpleado_3_11_Jsonclick ;
   private String edtLSD3codigoConcepto_14_10_Internalname ;
   private String A1668LSD3codigoConcepto_14_10 ;
   private String edtLSD3codigoConcepto_14_10_Jsonclick ;
   private String edtLSD3cantidadConcepto_24_5_Internalname ;
   private String edtLSD3cantidadConcepto_24_5_Jsonclick ;
   private String edtLSD3unidadesConcepto_29_1_Internalname ;
   private String A1670LSD3unidadesConcepto_29_1 ;
   private String edtLSD3unidadesConcepto_29_1_Jsonclick ;
   private String edtLSD3importeConcepto_30_15_Internalname ;
   private String edtLSD3importeConcepto_30_15_Jsonclick ;
   private String edtLSD3debitoCredito_45_1_Internalname ;
   private String A1672LSD3debitoCredito_45_1 ;
   private String edtLSD3debitoCredito_45_1_Jsonclick ;
   private String edtLSD3periodoAjuste_46_6_Internalname ;
   private String edtLSD3periodoAjuste_46_6_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String AV17Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode231 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
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
   private boolean AV13IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Gx_longc ;
   private com.genexus.webpanels.WebSession AV16WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private short[] T004X5_A1666LSD3Sec ;
   private long[] T004X5_A1667LSD3cuilEmpleado_3_11 ;
   private String[] T004X5_A1668LSD3codigoConcepto_14_10 ;
   private java.math.BigDecimal[] T004X5_A1669LSD3cantidadConcepto_24_5 ;
   private String[] T004X5_A1670LSD3unidadesConcepto_29_1 ;
   private java.math.BigDecimal[] T004X5_A1671LSD3importeConcepto_30_15 ;
   private String[] T004X5_A1672LSD3debitoCredito_45_1 ;
   private int[] T004X5_A1673LSD3periodoAjuste_46_6 ;
   private int[] T004X5_A3CliCod ;
   private short[] T004X5_A1EmpCod ;
   private int[] T004X5_A1649LSDSec ;
   private int[] T004X5_A1657LSD2Sec ;
   private int[] T004X4_A3CliCod ;
   private int[] T004X6_A3CliCod ;
   private int[] T004X7_A3CliCod ;
   private short[] T004X7_A1EmpCod ;
   private int[] T004X7_A1649LSDSec ;
   private int[] T004X7_A1657LSD2Sec ;
   private short[] T004X7_A1666LSD3Sec ;
   private short[] T004X3_A1666LSD3Sec ;
   private long[] T004X3_A1667LSD3cuilEmpleado_3_11 ;
   private String[] T004X3_A1668LSD3codigoConcepto_14_10 ;
   private java.math.BigDecimal[] T004X3_A1669LSD3cantidadConcepto_24_5 ;
   private String[] T004X3_A1670LSD3unidadesConcepto_29_1 ;
   private java.math.BigDecimal[] T004X3_A1671LSD3importeConcepto_30_15 ;
   private String[] T004X3_A1672LSD3debitoCredito_45_1 ;
   private int[] T004X3_A1673LSD3periodoAjuste_46_6 ;
   private int[] T004X3_A3CliCod ;
   private short[] T004X3_A1EmpCod ;
   private int[] T004X3_A1649LSDSec ;
   private int[] T004X3_A1657LSD2Sec ;
   private int[] T004X8_A3CliCod ;
   private short[] T004X8_A1EmpCod ;
   private int[] T004X8_A1649LSDSec ;
   private int[] T004X8_A1657LSD2Sec ;
   private short[] T004X8_A1666LSD3Sec ;
   private int[] T004X9_A3CliCod ;
   private short[] T004X9_A1EmpCod ;
   private int[] T004X9_A1649LSDSec ;
   private int[] T004X9_A1657LSD2Sec ;
   private short[] T004X9_A1666LSD3Sec ;
   private short[] T004X2_A1666LSD3Sec ;
   private long[] T004X2_A1667LSD3cuilEmpleado_3_11 ;
   private String[] T004X2_A1668LSD3codigoConcepto_14_10 ;
   private java.math.BigDecimal[] T004X2_A1669LSD3cantidadConcepto_24_5 ;
   private String[] T004X2_A1670LSD3unidadesConcepto_29_1 ;
   private java.math.BigDecimal[] T004X2_A1671LSD3importeConcepto_30_15 ;
   private String[] T004X2_A1672LSD3debitoCredito_45_1 ;
   private int[] T004X2_A1673LSD3periodoAjuste_46_6 ;
   private int[] T004X2_A3CliCod ;
   private short[] T004X2_A1EmpCod ;
   private int[] T004X2_A1649LSDSec ;
   private int[] T004X2_A1657LSD2Sec ;
   private int[] T004X13_A3CliCod ;
   private short[] T004X13_A1EmpCod ;
   private int[] T004X13_A1649LSDSec ;
   private int[] T004X13_A1657LSD2Sec ;
   private short[] T004X13_A1666LSD3Sec ;
   private int[] T004X14_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV12WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV15TrnContext ;
}

final  class lsd_reg3__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T004X2", "SELECT LSD3Sec, LSD3cuilEmpleado_3_11, LSD3codigoConcepto_14_10, LSD3cantidadConcepto_24_5, LSD3unidadesConcepto_29_1, LSD3importeConcepto_30_15, LSD3debitoCredito_45_1, LSD3periodoAjuste_46_6, CliCod, EmpCod, LSDSec, LSD2Sec FROM LSD_reg3 WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ? AND LSD3Sec = ?  FOR UPDATE OF LSD_reg3 NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004X3", "SELECT LSD3Sec, LSD3cuilEmpleado_3_11, LSD3codigoConcepto_14_10, LSD3cantidadConcepto_24_5, LSD3unidadesConcepto_29_1, LSD3importeConcepto_30_15, LSD3debitoCredito_45_1, LSD3periodoAjuste_46_6, CliCod, EmpCod, LSDSec, LSD2Sec FROM LSD_reg3 WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ? AND LSD3Sec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004X4", "SELECT CliCod FROM LSD_reg2 WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004X5", "SELECT TM1.LSD3Sec, TM1.LSD3cuilEmpleado_3_11, TM1.LSD3codigoConcepto_14_10, TM1.LSD3cantidadConcepto_24_5, TM1.LSD3unidadesConcepto_29_1, TM1.LSD3importeConcepto_30_15, TM1.LSD3debitoCredito_45_1, TM1.LSD3periodoAjuste_46_6, TM1.CliCod, TM1.EmpCod, TM1.LSDSec, TM1.LSD2Sec FROM LSD_reg3 TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LSDSec = ? and TM1.LSD2Sec = ? and TM1.LSD3Sec = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LSDSec, TM1.LSD2Sec, TM1.LSD3Sec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004X6", "SELECT CliCod FROM LSD_reg2 WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004X7", "SELECT CliCod, EmpCod, LSDSec, LSD2Sec, LSD3Sec FROM LSD_reg3 WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ? AND LSD3Sec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004X8", "SELECT CliCod, EmpCod, LSDSec, LSD2Sec, LSD3Sec FROM LSD_reg3 WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and LSDSec > ? or LSDSec = ? and EmpCod = ? and CliCod = ? and LSD2Sec > ? or LSD2Sec = ? and LSDSec = ? and EmpCod = ? and CliCod = ? and LSD3Sec > ?) ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD3Sec  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004X9", "SELECT CliCod, EmpCod, LSDSec, LSD2Sec, LSD3Sec FROM LSD_reg3 WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and LSDSec < ? or LSDSec = ? and EmpCod = ? and CliCod = ? and LSD2Sec < ? or LSD2Sec = ? and LSDSec = ? and EmpCod = ? and CliCod = ? and LSD3Sec < ?) ORDER BY CliCod DESC, EmpCod DESC, LSDSec DESC, LSD2Sec DESC, LSD3Sec DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T004X10", "SAVEPOINT gxupdate;INSERT INTO LSD_reg3(LSD3Sec, LSD3cuilEmpleado_3_11, LSD3codigoConcepto_14_10, LSD3cantidadConcepto_24_5, LSD3unidadesConcepto_29_1, LSD3importeConcepto_30_15, LSD3debitoCredito_45_1, LSD3periodoAjuste_46_6, CliCod, EmpCod, LSDSec, LSD2Sec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004X11", "SAVEPOINT gxupdate;UPDATE LSD_reg3 SET LSD3cuilEmpleado_3_11=?, LSD3codigoConcepto_14_10=?, LSD3cantidadConcepto_24_5=?, LSD3unidadesConcepto_29_1=?, LSD3importeConcepto_30_15=?, LSD3debitoCredito_45_1=?, LSD3periodoAjuste_46_6=?  WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ? AND LSD3Sec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004X12", "SAVEPOINT gxupdate;DELETE FROM LSD_reg3  WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ? AND LSD3Sec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T004X13", "SELECT CliCod, EmpCod, LSDSec, LSD2Sec, LSD3Sec FROM LSD_reg3 ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD3Sec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004X14", "SELECT CliCod FROM LSD_reg2 WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
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
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
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
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
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
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setInt(12, ((Number) parms[11]).intValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setShort(15, ((Number) parms[14]).shortValue());
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
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setInt(12, ((Number) parms[11]).intValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setShort(15, ((Number) parms[14]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setString(3, (String)parms[2], 10);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setString(5, (String)parms[4], 1);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 2);
               stmt.setString(7, (String)parms[6], 1);
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setInt(12, ((Number) parms[11]).intValue());
               return;
            case 9 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               stmt.setString(4, (String)parms[3], 1);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setString(6, (String)parms[5], 1);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setShort(12, ((Number) parms[11]).shortValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

